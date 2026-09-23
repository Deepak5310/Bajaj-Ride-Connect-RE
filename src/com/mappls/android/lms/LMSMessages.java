package com.mappls.android.lms;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.util.DisplayMetrics;
import androidx.mediarouter.media.SystemMediaRouteProvider;
import com.mappls.android.util.HttpService;
import com.mappls.android.util.LegacyVersionUtils;
import com.mappls.android.util.MPLog;
import com.mappls.android.util.MessageEncryptor;
import com.mappls.android.util.RemoteService;
import com.spotify.android.appremote.internal.SdkRemoteClientConnector;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class LMSMessages {
    private static final int CLEAR_ANONYMOUS_UPDATES = 7;
    private static final int EMPTY_QUEUES = 6;
    private static final int ENQUEUE_EVENTS = 1;
    private static final int ENQUEUE_FCM_EVENTS = 10;
    private static final int ENQUEUE_GROUP = 3;
    private static final int ENQUEUE_PEOPLE = 0;
    private static final int FLUSH_QUEUE = 2;
    private static final int KILL_WORKER = 5;
    private static final String LOGTAG = "MapplsAnalyticsAPI.Messages";
    private static final int PUSH_ANONYMOUS_PEOPLE_RECORDS = 4;
    private static final int REMOVE_RESIDUAL_IMAGE_FILES = 9;
    private static final int REWRITE_EVENT_PROPERTIES = 8;
    private static final Map<Context, LMSMessages> sInstances = new HashMap();
    protected final String deviceId;
    protected final MapplsLMSConfig mConfig;
    protected final Context mContext;
    private final Worker mWorker = createWorker();

    class EventDescription extends MapplsAnalyticsMessageDescription {
        private final String mEventName;
        private final boolean mIsAutomatic;
        private final JSONObject mSessionMetadata;

        public EventDescription(String str, JSONObject jSONObject, String str2) {
            this(str, jSONObject, str2, false, new JSONObject());
        }

        public EventDescription(String str, JSONObject jSONObject, String str2, boolean z, JSONObject jSONObject2) {
            super(str2, jSONObject);
            this.mEventName = str;
            this.mIsAutomatic = z;
            this.mSessionMetadata = jSONObject2;
        }

        public String getEventName() {
            return this.mEventName;
        }

        public JSONObject getProperties() {
            return getMessage();
        }

        public JSONObject getSessionMetadata() {
            return this.mSessionMetadata;
        }

        public boolean isAutomatic() {
            return this.mIsAutomatic;
        }
    }

    class GroupDescription extends MapplsAnalyticsMessageDescription {
        public GroupDescription(JSONObject jSONObject, String str) {
            super(str, jSONObject);
        }

        public String toString() {
            return getMessage().toString();
        }
    }

    class MapplsAnalyticsDescription {
        private final String mToken;

        public MapplsAnalyticsDescription(String str) {
            this.mToken = str;
        }

        public String getToken() {
            return this.mToken;
        }
    }

    class MapplsAnalyticsMessageDescription extends MapplsAnalyticsDescription {
        private final JSONObject mMessage;

        public MapplsAnalyticsMessageDescription(String str, JSONObject jSONObject) {
            super(str);
            if (jSONObject != null && jSONObject.length() > 0) {
                Iterator<String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    try {
                        jSONObject.get(next).toString();
                    } catch (AssertionError e) {
                        jSONObject.remove(next);
                        MPLog.e(LMSMessages.LOGTAG, "Removing people profile property from update", e);
                    } catch (JSONException unused) {
                    }
                }
            }
            this.mMessage = jSONObject;
        }

        public JSONObject getMessage() {
            return this.mMessage;
        }
    }

    class PeopleDescription extends MapplsAnalyticsMessageDescription {
        public PeopleDescription(JSONObject jSONObject, String str) {
            super(str, jSONObject);
        }

        public boolean isAnonymous() {
            return !getMessage().has("$distinct_id");
        }

        public String toString() {
            return getMessage().toString();
        }
    }

    class PushAnonymousPeopleDescription extends MapplsAnalyticsDescription {
        private final String mDistinctId;

        public PushAnonymousPeopleDescription(String str, String str2) {
            super(str2);
            this.mDistinctId = str;
        }

        public String getDistinctId() {
            return this.mDistinctId;
        }

        public String toString() {
            return this.mDistinctId;
        }
    }

    class UpdateEventsPropertiesDescription extends MapplsAnalyticsDescription {
        private final Map<String, String> mProps;

        public UpdateEventsPropertiesDescription(String str, Map<String, String> map) {
            super(str);
            this.mProps = map;
        }

        public Map<String, String> getProperties() {
            return this.mProps;
        }
    }

    class Worker {
        private SystemInformation mSystemInformation;
        private final Object mHandlerLock = new Object();
        private long mFlushCount = 0;
        private long mAveFlushFrequency = 0;
        private long mLastFlushTime = -1;
        private Handler mHandler = restartWorkerThread();

        class AnalyticsMessageHandler extends Handler {
            private MapplsLMSDbAdapter mDbAdapter;
            private int mFailedRetries;
            private final long mFlushInterval;
            private long mTrackEngageRetryAfter;

            public AnalyticsMessageHandler(Looper looper) {
                super(looper);
                this.mDbAdapter = null;
                Worker.this.mSystemInformation = SystemInformation.getInstance(LMSMessages.this.mContext);
                this.mFlushInterval = LMSMessages.this.mConfig.getFlushInterval();
            }

            private JSONObject getDefaultEventProperties() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                if (!MapplsLMSConfig.ADD_ADDITIONAL_DATA_IN_PACKET) {
                    return jSONObject;
                }
                jSONObject.put("mp_lib", SystemMediaRouteProvider.PACKAGE_NAME);
                jSONObject.put("$lib_version", "1.0.0");
                jSONObject.put("$os", "Android");
                String str = Build.VERSION.RELEASE;
                if (str == null) {
                    str = "UNKNOWN";
                }
                jSONObject.put("$os_version", str);
                String str2 = Build.MANUFACTURER;
                if (str2 == null) {
                    str2 = "UNKNOWN";
                }
                jSONObject.put("$manufacturer", str2);
                String str3 = Build.BRAND;
                if (str3 == null) {
                    str3 = "UNKNOWN";
                }
                jSONObject.put("$brand", str3);
                String str4 = Build.MODEL;
                jSONObject.put("$model", str4 != null ? str4 : "UNKNOWN");
                DisplayMetrics displayMetrics = Worker.this.mSystemInformation.getDisplayMetrics();
                jSONObject.put("$screen_dpi", displayMetrics.densityDpi);
                jSONObject.put("$screen_height", displayMetrics.heightPixels);
                jSONObject.put("$screen_width", displayMetrics.widthPixels);
                String appVersionName = Worker.this.mSystemInformation.getAppVersionName();
                if (appVersionName != null) {
                    jSONObject.put("$app_version", appVersionName);
                    jSONObject.put("$app_version_string", appVersionName);
                }
                Integer appVersionCode = Worker.this.mSystemInformation.getAppVersionCode();
                if (appVersionCode != null) {
                    String strValueOf = String.valueOf(appVersionCode);
                    jSONObject.put("$app_release", strValueOf);
                    jSONObject.put("$app_build_number", strValueOf);
                }
                boolean zHasNFC = Worker.this.mSystemInformation.hasNFC();
                Boolean boolValueOf = Boolean.valueOf(zHasNFC);
                if (boolValueOf != null) {
                    boolValueOf.getClass();
                    jSONObject.put("$has_nfc", zHasNFC);
                }
                boolean zHasTelephony = Worker.this.mSystemInformation.hasTelephony();
                Boolean boolValueOf2 = Boolean.valueOf(zHasTelephony);
                if (boolValueOf2 != null) {
                    boolValueOf2.getClass();
                    jSONObject.put("$has_telephone", zHasTelephony);
                }
                String currentNetworkOperator = Worker.this.mSystemInformation.getCurrentNetworkOperator();
                if (currentNetworkOperator != null && !currentNetworkOperator.trim().isEmpty()) {
                    jSONObject.put("$carrier", currentNetworkOperator);
                }
                Boolean boolIsWifiConnected = Worker.this.mSystemInformation.isWifiConnected();
                if (boolIsWifiConnected != null) {
                    jSONObject.put("$wifi", boolIsWifiConnected.booleanValue());
                }
                Boolean boolIsBluetoothEnabled = Worker.this.mSystemInformation.isBluetoothEnabled();
                if (boolIsBluetoothEnabled != null) {
                    jSONObject.put("$bluetooth_enabled", boolIsBluetoothEnabled);
                }
                String bluetoothVersion = Worker.this.mSystemInformation.getBluetoothVersion();
                if (bluetoothVersion != null) {
                    jSONObject.put("$bluetooth_version", bluetoothVersion);
                }
                return jSONObject;
            }

            private JSONObject prepareEventObject(EventDescription eventDescription) throws JSONException {
                JSONObject jSONObject = new JSONObject();
                JSONObject properties = eventDescription.getProperties();
                JSONObject defaultEventProperties = getDefaultEventProperties();
                defaultEventProperties.put(SdkRemoteClientConnector.APP_ID_AUTH, eventDescription.getToken());
                defaultEventProperties.put("timestamp", System.currentTimeMillis() / 1000);
                defaultEventProperties.put("device_id", LMSMessages.this.deviceId);
                if (properties != null) {
                    Iterator<String> itKeys = properties.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        defaultEventProperties.put(next, properties.get(next));
                    }
                }
                jSONObject.put("properties", defaultEventProperties);
                jSONObject.put("activity_name", eventDescription.getEventName());
                if (MapplsLMSConfig.ADD_ADDITIONAL_DATA_IN_PACKET) {
                    jSONObject.put("$mp_metadata", eventDescription.getSessionMetadata());
                }
                return jSONObject;
            }

            private void sendAllData(MapplsLMSDbAdapter mapplsLMSDbAdapter, String str) throws Throwable {
                RemoteService poster = LMSMessages.this.getPoster();
                LMSMessages lMSMessages = LMSMessages.this;
                if (!poster.isOnline(lMSMessages.mContext, lMSMessages.mConfig.getOfflineMode())) {
                    LMSMessages.this.logAboutMessageToMapplsAnalytics("Not flushing data to Mappls Analytics because the device is not connected to the internet.");
                } else {
                    sendData(mapplsLMSDbAdapter, str, MapplsLMSDbAdapter.Table.EVENTS, LMSMessages.this.mConfig.getEventsEndpoint());
                    sendData(mapplsLMSDbAdapter, str, MapplsLMSDbAdapter.Table.FCM_EVENTS, LMSMessages.this.mConfig.getFcmEventsEndpoint());
                }
            }

            private void sendData(MapplsLMSDbAdapter mapplsLMSDbAdapter, String str, MapplsLMSDbAdapter.Table table, String str2) throws Throwable {
                LMSMessages lMSMessages;
                StringBuilder sb;
                StringBuilder sb2;
                RemoteService poster = LMSMessages.this.getPoster();
                String[] strArrGenerateDataString = mapplsLMSDbAdapter.generateDataString(table, str);
                int i = 0;
                Integer numValueOf = strArrGenerateDataString != null ? Integer.valueOf(strArrGenerateDataString[2]) : 0;
                while (strArrGenerateDataString != null && numValueOf.intValue() > 0) {
                    String str3 = strArrGenerateDataString[i];
                    String str4 = strArrGenerateDataString[1];
                    MPLog.d("AnalyticsMessages", str4);
                    String strEncryptMessage = MessageEncryptor.encryptMessage(str4);
                    HashMap map = new HashMap();
                    map.put("data", strEncryptMessage);
                    try {
                        try {
                            byte[] bArrPerformRequest = poster.performRequest(str2, map, LMSMessages.this.mConfig.getSSLSocketFactory());
                            if (bArrPerformRequest == null) {
                                try {
                                    LMSMessages.this.logAboutMessageToMapplsAnalytics("Response was null, unexpected failure posting to " + str2 + ".");
                                } catch (OutOfMemoryError e) {
                                    e = e;
                                    sb2 = new StringBuilder("Out of memory when posting to ");
                                    sb2.append(str2);
                                    sb2.append(".");
                                    MPLog.e(LMSMessages.LOGTAG, sb2.toString(), e);
                                } catch (MalformedURLException e2) {
                                    e = e2;
                                    sb2 = new StringBuilder("Cannot interpret ");
                                    sb2.append(str2);
                                    sb2.append(" as a URL.");
                                    MPLog.e(LMSMessages.LOGTAG, sb2.toString(), e);
                                }
                            } else {
                                try {
                                    String str5 = new String(bArrPerformRequest, "UTF-8");
                                    if (this.mFailedRetries > 0) {
                                        this.mFailedRetries = i;
                                        removeMessages(2, str);
                                    }
                                    LMSMessages.this.logAboutMessageToMapplsAnalytics("Successfully posted to " + str2 + ": \n" + str4);
                                    LMSMessages lMSMessages2 = LMSMessages.this;
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Response was ");
                                    sb3.append(str5);
                                    lMSMessages2.logAboutMessageToMapplsAnalytics(sb3.toString());
                                    i = 1;
                                } catch (UnsupportedEncodingException e3) {
                                    throw new RuntimeException("UTF not supported on this platform?", e3);
                                }
                            }
                        } catch (OutOfMemoryError e4) {
                            e = e4;
                            i = 1;
                        } catch (MalformedURLException e5) {
                            e = e5;
                            i = 1;
                        }
                    } catch (RemoteService.ServiceUnavailableException e6) {
                        LMSMessages.this.logAboutMessageToMapplsAnalytics("Cannot post message to " + str2 + ".", e6);
                        this.mTrackEngageRetryAfter = (long) (e6.getRetryAfter() * 1000);
                        i = 0;
                    } catch (SocketTimeoutException e7) {
                        e = e7;
                        lMSMessages = LMSMessages.this;
                        sb = new StringBuilder("Cannot post message to ");
                        sb.append(str2);
                        sb.append(".");
                        lMSMessages.logAboutMessageToMapplsAnalytics(sb.toString(), e);
                        i = 0;
                    } catch (IOException e8) {
                        e = e8;
                        lMSMessages = LMSMessages.this;
                        sb = new StringBuilder("Cannot post message to ");
                        sb.append(str2);
                        sb.append(".");
                        lMSMessages.logAboutMessageToMapplsAnalytics(sb.toString(), e);
                        i = 0;
                    }
                    if (i == 0) {
                        removeMessages(2, str);
                        long jMax = Math.max(((long) Math.pow(2.0d, this.mFailedRetries)) * 60000, this.mTrackEngageRetryAfter);
                        this.mTrackEngageRetryAfter = jMax;
                        this.mTrackEngageRetryAfter = Math.min(jMax, 600000L);
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 2;
                        messageObtain.obj = str;
                        sendMessageDelayed(messageObtain, this.mTrackEngageRetryAfter);
                        this.mFailedRetries++;
                        LMSMessages.this.logAboutMessageToMapplsAnalytics("Retrying this batch of events in " + this.mTrackEngageRetryAfter + " ms");
                        return;
                    }
                    LMSMessages.this.logAboutMessageToMapplsAnalytics("Not retrying this batch of events, deleting them from DB.");
                    mapplsLMSDbAdapter.cleanupEvents(str3, table, str);
                    strArrGenerateDataString = mapplsLMSDbAdapter.generateDataString(table, str);
                    if (strArrGenerateDataString != null) {
                        numValueOf = Integer.valueOf(strArrGenerateDataString[2]);
                        i = 0;
                    } else {
                        i = 0;
                    }
                }
            }

            protected long getTrackEngageRetryAfter() {
                return this.mTrackEngageRetryAfter;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) throws Throwable {
                String token;
                int iAddJSON;
                String token2;
                MapplsLMSDbAdapter mapplsLMSDbAdapter;
                if (this.mDbAdapter == null) {
                    LMSMessages lMSMessages = LMSMessages.this;
                    MapplsLMSDbAdapter mapplsLMSDbAdapterMakeDbAdapter = lMSMessages.makeDbAdapter(lMSMessages.mContext);
                    this.mDbAdapter = mapplsLMSDbAdapterMakeDbAdapter;
                    mapplsLMSDbAdapterMakeDbAdapter.cleanupEvents(System.currentTimeMillis() - LMSMessages.this.mConfig.getDataExpiration(), MapplsLMSDbAdapter.Table.EVENTS);
                    this.mDbAdapter.cleanupEvents(System.currentTimeMillis() - LMSMessages.this.mConfig.getDataExpiration(), MapplsLMSDbAdapter.Table.PEOPLE);
                }
                try {
                    int i = message.what;
                    if (i == 0) {
                        PeopleDescription peopleDescription = (PeopleDescription) message.obj;
                        MapplsLMSDbAdapter.Table table = peopleDescription.isAnonymous() ? MapplsLMSDbAdapter.Table.ANONYMOUS_PEOPLE : MapplsLMSDbAdapter.Table.PEOPLE;
                        LMSMessages.this.logAboutMessageToMapplsAnalytics("Queuing people record for sending later");
                        LMSMessages.this.logAboutMessageToMapplsAnalytics("    " + peopleDescription.toString());
                        token = peopleDescription.getToken();
                        iAddJSON = this.mDbAdapter.addJSON(MessageEncryptor.offlineEncryptMessage(peopleDescription.getMessage().toString()), token, table);
                        if (peopleDescription.isAnonymous()) {
                            iAddJSON = 0;
                        }
                    } else if (i == 3) {
                        GroupDescription groupDescription = (GroupDescription) message.obj;
                        LMSMessages.this.logAboutMessageToMapplsAnalytics("Queuing group record for sending later");
                        LMSMessages.this.logAboutMessageToMapplsAnalytics("    " + groupDescription.toString());
                        String token3 = groupDescription.getToken();
                        token = token3;
                        iAddJSON = this.mDbAdapter.addJSON(MessageEncryptor.offlineEncryptMessage(groupDescription.getMessage().toString()), token3, MapplsLMSDbAdapter.Table.GROUPS);
                    } else if (i == 1 || i == 10) {
                        EventDescription eventDescription = (EventDescription) message.obj;
                        try {
                            JSONObject jSONObjectPrepareEventObject = prepareEventObject(eventDescription);
                            LMSMessages.this.logAboutMessageToMapplsAnalytics("Queuing event for sending later");
                            LMSMessages.this.logAboutMessageToMapplsAnalytics("    " + jSONObjectPrepareEventObject.toString());
                            String token4 = eventDescription.getToken();
                            try {
                                iAddJSON = this.mDbAdapter.addJSON(MessageEncryptor.offlineEncryptMessage(jSONObjectPrepareEventObject.toString()), token4, message.what == 10 ? MapplsLMSDbAdapter.Table.FCM_EVENTS : MapplsLMSDbAdapter.Table.EVENTS);
                                token = token4;
                            } catch (JSONException e) {
                                e = e;
                                token = token4;
                                MPLog.e(LMSMessages.LOGTAG, "Exception tracking event " + eventDescription.getEventName(), e);
                                iAddJSON = -3;
                            }
                        } catch (JSONException e2) {
                            e = e2;
                            token = null;
                        }
                    } else if (i == 4) {
                        PushAnonymousPeopleDescription pushAnonymousPeopleDescription = (PushAnonymousPeopleDescription) message.obj;
                        String distinctId = pushAnonymousPeopleDescription.getDistinctId();
                        String token5 = pushAnonymousPeopleDescription.getToken();
                        iAddJSON = this.mDbAdapter.pushAnonymousUpdatesToPeopleDb(token5, distinctId);
                        token = token5;
                    } else {
                        if (i == 7) {
                            token2 = ((MapplsAnalyticsDescription) message.obj).getToken();
                            mapplsLMSDbAdapter = this.mDbAdapter;
                        } else {
                            if (i == 8) {
                                UpdateEventsPropertiesDescription updateEventsPropertiesDescription = (UpdateEventsPropertiesDescription) message.obj;
                                MPLog.d(LMSMessages.LOGTAG, this.mDbAdapter.rewriteEventDataWithProperties(updateEventsPropertiesDescription.getProperties(), updateEventsPropertiesDescription.getToken()) + " stored events were updated with new properties.");
                            } else {
                                if (i == 2) {
                                    LMSMessages.this.logAboutMessageToMapplsAnalytics("Flushing queue due to scheduled or forced flush");
                                    Worker.this.updateFlushFrequency();
                                    token = (String) message.obj;
                                    sendAllData(this.mDbAdapter, token);
                                } else if (i == 6) {
                                    token2 = ((MapplsAnalyticsDescription) message.obj).getToken();
                                    this.mDbAdapter.cleanupAllEvents(MapplsLMSDbAdapter.Table.EVENTS, token2);
                                    this.mDbAdapter.cleanupAllEvents(MapplsLMSDbAdapter.Table.FCM_EVENTS, token2);
                                    this.mDbAdapter.cleanupAllEvents(MapplsLMSDbAdapter.Table.PEOPLE, token2);
                                    this.mDbAdapter.cleanupAllEvents(MapplsLMSDbAdapter.Table.GROUPS, token2);
                                    mapplsLMSDbAdapter = this.mDbAdapter;
                                } else if (i == 5) {
                                    MPLog.w(LMSMessages.LOGTAG, "Worker received a hard kill. Dumping all events and force-killing. Thread id " + Thread.currentThread().getId());
                                    synchronized (Worker.this.mHandlerLock) {
                                        this.mDbAdapter.deleteDB();
                                        Worker.this.mHandler = null;
                                        Looper.myLooper().quit();
                                    }
                                } else if (i == 9) {
                                    LegacyVersionUtils.removeLegacyResidualImageFiles((File) message.obj);
                                } else {
                                    MPLog.e(LMSMessages.LOGTAG, "Unexpected message received by Mappls Analytics worker: " + message);
                                }
                                iAddJSON = -3;
                            }
                            iAddJSON = -3;
                            token = null;
                        }
                        token = token2;
                        mapplsLMSDbAdapter.cleanupAllEvents(MapplsLMSDbAdapter.Table.ANONYMOUS_PEOPLE, token);
                        iAddJSON = -3;
                    }
                    if ((iAddJSON >= LMSMessages.this.mConfig.getBulkUploadLimit() || iAddJSON == -2) && this.mFailedRetries <= 0 && token != null) {
                        LMSMessages.this.logAboutMessageToMapplsAnalytics("Flushing queue due to bulk upload limit (" + iAddJSON + ") for project " + token);
                        Worker.this.updateFlushFrequency();
                        sendAllData(this.mDbAdapter, token);
                        return;
                    }
                    if (iAddJSON <= 0 || hasMessages(2, token)) {
                        return;
                    }
                    LMSMessages.this.logAboutMessageToMapplsAnalytics("Queue depth " + iAddJSON + " - Adding flush in " + this.mFlushInterval);
                    if (this.mFlushInterval >= 0) {
                        Message messageObtain = Message.obtain();
                        messageObtain.what = 2;
                        messageObtain.obj = token;
                        messageObtain.arg1 = 1;
                        sendMessageDelayed(messageObtain, this.mFlushInterval);
                    }
                } catch (RuntimeException e3) {
                    MPLog.e(LMSMessages.LOGTAG, "Worker threw an unhandled exception", e3);
                    synchronized (Worker.this.mHandlerLock) {
                        Worker.this.mHandler = null;
                        try {
                            Looper.myLooper().quit();
                            MPLog.e(LMSMessages.LOGTAG, "Mappls Analytics will not process any more analytics messages", e3);
                        } catch (Exception e4) {
                            MPLog.e(LMSMessages.LOGTAG, "Could not halt looper", e4);
                        }
                    }
                }
            }
        }

        public Worker() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateFlushFrequency() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.mFlushCount;
            long j2 = 1 + j;
            long j3 = this.mLastFlushTime;
            if (j3 > 0) {
                long j4 = ((this.mAveFlushFrequency * j) + (jCurrentTimeMillis - j3)) / j2;
                this.mAveFlushFrequency = j4;
                LMSMessages.this.logAboutMessageToMapplsAnalytics("Average send frequency approximately " + (j4 / 1000) + " seconds.");
            }
            this.mLastFlushTime = jCurrentTimeMillis;
            this.mFlushCount = j2;
        }

        public boolean isDead() {
            boolean z;
            synchronized (this.mHandlerLock) {
                z = this.mHandler == null;
            }
            return z;
        }

        protected Handler restartWorkerThread() {
            HandlerThread handlerThread = new HandlerThread("com.mappls.android.AnalyticsWorker", 10);
            handlerThread.start();
            return new AnalyticsMessageHandler(handlerThread.getLooper());
        }

        public void runMessage(Message message) {
            synchronized (this.mHandlerLock) {
                Handler handler = this.mHandler;
                if (handler == null) {
                    LMSMessages.this.logAboutMessageToMapplsAnalytics("Dead Mappls Analytics worker dropping a message: " + message.what);
                } else {
                    handler.sendMessage(message);
                }
            }
        }
    }

    LMSMessages(Context context) {
        this.mContext = context;
        this.mConfig = getConfig(context);
        this.deviceId = Settings.Secure.getString(context.getContentResolver(), "android_id");
        getPoster().checkIsMapplsAnalyticsBlocked();
    }

    public static LMSMessages getInstance(Context context) {
        LMSMessages lMSMessages;
        Map<Context, LMSMessages> map = sInstances;
        synchronized (map) {
            Context applicationContext = context.getApplicationContext();
            if (map.containsKey(applicationContext)) {
                lMSMessages = map.get(applicationContext);
            } else {
                lMSMessages = new LMSMessages(applicationContext);
                map.put(applicationContext, lMSMessages);
            }
        }
        return lMSMessages;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAboutMessageToMapplsAnalytics(String str) {
        MPLog.v(LOGTAG, str + " (Thread " + Thread.currentThread().getId() + ")");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void logAboutMessageToMapplsAnalytics(String str, Throwable th) {
        MPLog.v(LOGTAG, str + " (Thread " + Thread.currentThread().getId() + ")", th);
    }

    public void clearAnonymousUpdatesMessage(MapplsAnalyticsDescription mapplsAnalyticsDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 7;
        messageObtain.obj = mapplsAnalyticsDescription;
        this.mWorker.runMessage(messageObtain);
    }

    protected Worker createWorker() {
        return new Worker();
    }

    public void emptyTrackingQueues(MapplsAnalyticsDescription mapplsAnalyticsDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 6;
        messageObtain.obj = mapplsAnalyticsDescription;
        this.mWorker.runMessage(messageObtain);
    }

    public void eventsMessage(EventDescription eventDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = eventDescription;
        this.mWorker.runMessage(messageObtain);
    }

    public void fcmEventsMessage(EventDescription eventDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 10;
        messageObtain.obj = eventDescription;
        this.mWorker.runMessage(messageObtain);
    }

    protected MapplsLMSConfig getConfig(Context context) {
        return MapplsLMSConfig.getInstance(context);
    }

    protected RemoteService getPoster() {
        return new HttpService();
    }

    public long getTrackEngageRetryAfter() {
        return ((Worker.AnalyticsMessageHandler) this.mWorker.mHandler).getTrackEngageRetryAfter();
    }

    public void groupMessage(GroupDescription groupDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 3;
        messageObtain.obj = groupDescription;
        this.mWorker.runMessage(messageObtain);
    }

    public void hardKill() {
        Message messageObtain = Message.obtain();
        messageObtain.what = 5;
        this.mWorker.runMessage(messageObtain);
    }

    boolean isDead() {
        return this.mWorker.isDead();
    }

    protected MapplsLMSDbAdapter makeDbAdapter(Context context) {
        return MapplsLMSDbAdapter.getInstance(context);
    }

    public void peopleMessage(PeopleDescription peopleDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 0;
        messageObtain.obj = peopleDescription;
        this.mWorker.runMessage(messageObtain);
    }

    public void postToServer(MapplsAnalyticsDescription mapplsAnalyticsDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.obj = mapplsAnalyticsDescription.getToken();
        messageObtain.arg1 = 0;
        this.mWorker.runMessage(messageObtain);
    }

    public void pushAnonymousPeopleMessage(PushAnonymousPeopleDescription pushAnonymousPeopleDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 4;
        messageObtain.obj = pushAnonymousPeopleDescription;
        this.mWorker.runMessage(messageObtain);
    }

    public void removeResidualImageFiles(File file) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 9;
        messageObtain.obj = file;
        this.mWorker.runMessage(messageObtain);
    }

    public void updateEventProperties(UpdateEventsPropertiesDescription updateEventsPropertiesDescription) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 8;
        messageObtain.obj = updateEventsPropertiesDescription;
        this.mWorker.runMessage(messageObtain);
    }
}
