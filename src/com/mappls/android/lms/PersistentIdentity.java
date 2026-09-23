package com.mappls.android.lms;

import android.content.Context;
import android.content.SharedPreferences;
import com.mappls.android.util.MPLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
class PersistentIdentity {
    private static final String DELIMITER = ",";
    private static final String LOGTAG = "MapplsAnalyticsAPI.PIdentity";
    private static Boolean sIsFirstAppLaunch = null;
    private static Integer sPreviousVersionCode = null;
    private static boolean sReferrerPrefsDirty = true;
    private static final Object sReferrerPrefsLock = new Object();
    private String mAnonymousId;
    private String mEventsDistinctId;
    private boolean mEventsUserIdPresent;
    private boolean mHadPersistedDistinctId;
    private Boolean mIsUserOptOut;
    private final Future<SharedPreferences> mLoadReferrerPreferences;
    private final Future<SharedPreferences> mLoadStoredPreferences;
    private final Future<SharedPreferences> mMapplsAnalyticsPreferences;
    private String mPeopleDistinctId;
    private final Future<SharedPreferences> mTimeEventsPreferences;
    private final Object mSuperPropsLock = new Object();
    private JSONObject mSuperPropertiesCache = null;
    private Map<String, String> mReferrerPropertiesCache = null;
    private boolean mIdentitiesLoaded = false;
    private final SharedPreferences.OnSharedPreferenceChangeListener mReferrerChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.mappls.android.lms.PersistentIdentity.1
        @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
            synchronized (PersistentIdentity.sReferrerPrefsLock) {
                PersistentIdentity.this.readReferrerProperties();
                boolean unused = PersistentIdentity.sReferrerPrefsDirty = false;
            }
        }
    };

    public PersistentIdentity(Future<SharedPreferences> future, Future<SharedPreferences> future2, Future<SharedPreferences> future3, Future<SharedPreferences> future4) {
        this.mLoadReferrerPreferences = future;
        this.mLoadStoredPreferences = future2;
        this.mTimeEventsPreferences = future3;
        this.mMapplsAnalyticsPreferences = future4;
    }

    public static String getPeopleDistinctId(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("people_distinct_id", null);
    }

    private JSONObject getSuperPropertiesCache() {
        if (this.mSuperPropertiesCache == null) {
            readSuperProperties();
        }
        return this.mSuperPropertiesCache;
    }

    private void readIdentities() {
        Throwable e;
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.mLoadStoredPreferences.get();
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Cannot read distinct ids from sharedPreferences.", e);
            sharedPreferences = null;
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Cannot read distinct ids from sharedPreferences.", e);
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return;
        }
        this.mEventsDistinctId = sharedPreferences.getString("events_distinct_id", null);
        this.mEventsUserIdPresent = sharedPreferences.getBoolean("events_user_id_present", false);
        this.mPeopleDistinctId = sharedPreferences.getString("people_distinct_id", null);
        this.mAnonymousId = sharedPreferences.getString("anonymous_id", null);
        this.mHadPersistedDistinctId = sharedPreferences.getBoolean("had_persisted_distinct_id", false);
        if (this.mEventsDistinctId == null) {
            this.mAnonymousId = UUID.randomUUID().toString();
            this.mEventsDistinctId = "$device:" + this.mAnonymousId;
            this.mEventsUserIdPresent = false;
            writeIdentities();
        }
        this.mIdentitiesLoaded = true;
    }

    private void readOptOutFlag(String str) {
        Throwable e;
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = this.mMapplsAnalyticsPreferences.get();
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Cannot read opt out flag from sharedPreferences.", e);
            sharedPreferences = null;
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Cannot read opt out flag from sharedPreferences.", e);
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return;
        }
        this.mIsUserOptOut = Boolean.valueOf(sharedPreferences.getBoolean("opt_out_" + str, false));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void readReferrerProperties() {
        Throwable e;
        this.mReferrerPropertiesCache = new HashMap();
        try {
            SharedPreferences sharedPreferences = this.mLoadReferrerPreferences.get();
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(this.mReferrerChangeListener);
            sharedPreferences.registerOnSharedPreferenceChangeListener(this.mReferrerChangeListener);
            for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                this.mReferrerPropertiesCache.put(entry.getKey(), entry.getValue().toString());
            }
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Cannot load referrer properties from shared preferences.", e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Cannot load referrer properties from shared preferences.", e);
        }
    }

    private void readSuperProperties() {
        JSONObject jSONObject;
        try {
            try {
                try {
                    String string = this.mLoadStoredPreferences.get().getString("super_properties", "{}");
                    MPLog.v(LOGTAG, "Loading Super Properties " + string);
                    this.mSuperPropertiesCache = new JSONObject(string);
                } catch (JSONException unused) {
                    MPLog.e(LOGTAG, "Cannot parse stored superProperties");
                    storeSuperProperties();
                    if (this.mSuperPropertiesCache == null) {
                        jSONObject = new JSONObject();
                        this.mSuperPropertiesCache = jSONObject;
                    }
                }
            } catch (InterruptedException e) {
                MPLog.e(LOGTAG, "Cannot load superProperties from SharedPreferences.", e);
                if (this.mSuperPropertiesCache == null) {
                    jSONObject = new JSONObject();
                    this.mSuperPropertiesCache = jSONObject;
                }
            } catch (ExecutionException e2) {
                MPLog.e(LOGTAG, "Cannot load superProperties from SharedPreferences.", e2.getCause());
                if (this.mSuperPropertiesCache == null) {
                    jSONObject = new JSONObject();
                    this.mSuperPropertiesCache = jSONObject;
                }
            }
        } catch (Throwable th) {
            if (this.mSuperPropertiesCache == null) {
                this.mSuperPropertiesCache = new JSONObject();
            }
            throw th;
        }
    }

    private void storeSuperProperties() {
        Throwable e;
        JSONObject jSONObject = this.mSuperPropertiesCache;
        if (jSONObject == null) {
            MPLog.e(LOGTAG, "storeSuperProperties should not be called with uninitialized superPropertiesCache.");
            return;
        }
        String string = jSONObject.toString();
        MPLog.v(LOGTAG, "Storing Super Properties " + string);
        try {
            SharedPreferences.Editor editorEdit = this.mLoadStoredPreferences.get().edit();
            editorEdit.putString("super_properties", string);
            writeEdits(editorEdit);
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Cannot store superProperties in shared preferences.", e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Cannot store superProperties in shared preferences.", e);
        }
    }

    private static void writeEdits(SharedPreferences.Editor editor) {
        editor.apply();
    }

    private void writeIdentities() {
        Throwable e;
        try {
            SharedPreferences.Editor editorEdit = this.mLoadStoredPreferences.get().edit();
            editorEdit.putString("events_distinct_id", this.mEventsDistinctId);
            editorEdit.putBoolean("events_user_id_present", this.mEventsUserIdPresent);
            editorEdit.putString("people_distinct_id", this.mPeopleDistinctId);
            editorEdit.putString("anonymous_id", this.mAnonymousId);
            editorEdit.putBoolean("had_persisted_distinct_id", this.mHadPersistedDistinctId);
            writeEdits(editorEdit);
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Can't write distinct ids to shared preferences.", e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Can't write distinct ids to shared preferences.", e);
        }
    }

    private void writeOptOutFlag(String str) {
        Throwable e;
        try {
            SharedPreferences.Editor editorEdit = this.mMapplsAnalyticsPreferences.get().edit();
            editorEdit.putBoolean("opt_out_" + str, this.mIsUserOptOut.booleanValue());
            writeEdits(editorEdit);
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Can't write opt-out shared preferences.", e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Can't write opt-out shared preferences.", e);
        }
    }

    public static void writeReferrerPrefs(Context context, String str, Map<String, String> map) {
        synchronized (sReferrerPrefsLock) {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                editorEdit.putString(entry.getKey(), entry.getValue());
            }
            writeEdits(editorEdit);
            sReferrerPrefsDirty = true;
        }
    }

    public void addSuperPropertiesToObject(JSONObject jSONObject) {
        synchronized (this.mSuperPropsLock) {
            JSONObject superPropertiesCache = getSuperPropertiesCache();
            Iterator<String> itKeys = superPropertiesCache.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    jSONObject.put(next, superPropertiesCache.get(next));
                } catch (JSONException e) {
                    MPLog.e(LOGTAG, "Object read from one JSON Object cannot be written to another", e);
                }
            }
        }
    }

    public void addTimeEvent(String str, Long l) {
        try {
            SharedPreferences.Editor editorEdit = this.mTimeEventsPreferences.get().edit();
            editorEdit.putLong(str, l.longValue());
            writeEdits(editorEdit);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public synchronized void clearPreferences() {
        try {
            SharedPreferences.Editor editorEdit = this.mLoadStoredPreferences.get().edit();
            editorEdit.clear();
            writeEdits(editorEdit);
            readSuperProperties();
            readIdentities();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    public void clearReferrerProperties() {
        String str;
        String str2;
        Throwable e;
        synchronized (sReferrerPrefsLock) {
            try {
                SharedPreferences.Editor editorEdit = this.mLoadReferrerPreferences.get().edit();
                editorEdit.clear();
                writeEdits(editorEdit);
            } catch (InterruptedException e2) {
                e = e2;
                str = LOGTAG;
                str2 = "Cannot load referrer properties from shared preferences.";
                MPLog.e(str, str2, e);
            } catch (ExecutionException e3) {
                str = LOGTAG;
                str2 = "Cannot load referrer properties from shared preferences.";
                e = e3.getCause();
                MPLog.e(str, str2, e);
            }
        }
    }

    public void clearSuperProperties() {
        synchronized (this.mSuperPropsLock) {
            this.mSuperPropertiesCache = new JSONObject();
            storeSuperProperties();
        }
    }

    public void clearTimedEvents() {
        try {
            SharedPreferences.Editor editorEdit = this.mTimeEventsPreferences.get().edit();
            editorEdit.clear();
            writeEdits(editorEdit);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public synchronized String getAnonymousId() {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        return this.mAnonymousId;
    }

    public synchronized String getEventsDistinctId() {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        return this.mEventsDistinctId;
    }

    public synchronized String getEventsUserId() {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        if (!this.mEventsUserIdPresent) {
            return null;
        }
        return this.mEventsDistinctId;
    }

    public synchronized boolean getHadPersistedDistinctId() {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        return this.mHadPersistedDistinctId;
    }

    public synchronized boolean getOptOutTracking(String str) {
        if (this.mIsUserOptOut == null) {
            readOptOutFlag(str);
        }
        return this.mIsUserOptOut.booleanValue();
    }

    public synchronized String getPeopleDistinctId() {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        return this.mPeopleDistinctId;
    }

    public Map<String, String> getReferrerProperties() {
        synchronized (sReferrerPrefsLock) {
            if (sReferrerPrefsDirty || this.mReferrerPropertiesCache == null) {
                readReferrerProperties();
                sReferrerPrefsDirty = false;
            }
        }
        return this.mReferrerPropertiesCache;
    }

    public Map<String, Long> getTimeEvents() {
        HashMap map = new HashMap();
        try {
            for (Map.Entry<String, ?> entry : this.mTimeEventsPreferences.get().getAll().entrySet()) {
                map.put(entry.getKey(), Long.valueOf(entry.getValue().toString()));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return map;
    }

    protected boolean hasOptOutFlag(String str) {
        Throwable e;
        try {
            return this.mMapplsAnalyticsPreferences.get().contains("opt_out_" + str);
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Can't read opt-out shared preferences.", e);
            return false;
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Can't read opt-out shared preferences.", e);
            return false;
        }
    }

    public synchronized boolean isFirstIntegration(String str) {
        boolean z;
        Throwable e;
        String str2;
        String str3;
        z = false;
        try {
            z = this.mMapplsAnalyticsPreferences.get().getBoolean(str, false);
        } catch (InterruptedException e2) {
            e = e2;
            str2 = LOGTAG;
            str3 = "Couldn't read internal Mappls Analytics from shared preferences.";
            MPLog.e(str2, str3, e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            str2 = LOGTAG;
            str3 = "Couldn't read internal Mappls Analytics shared preferences.";
            MPLog.e(str2, str3, e);
        }
        return z;
    }

    public synchronized boolean isFirstLaunch(boolean z, String str) {
        if (sIsFirstAppLaunch == null) {
            try {
                if (this.mMapplsAnalyticsPreferences.get().getBoolean("has_launched_" + str, false)) {
                    sIsFirstAppLaunch = Boolean.FALSE;
                } else {
                    Boolean boolValueOf = Boolean.valueOf(!z);
                    sIsFirstAppLaunch = boolValueOf;
                    boolValueOf.getClass();
                    if (z) {
                        setHasLaunched(str);
                    }
                }
            } catch (InterruptedException | ExecutionException unused) {
                sIsFirstAppLaunch = Boolean.FALSE;
            }
        }
        return sIsFirstAppLaunch.booleanValue();
    }

    public synchronized boolean isNewVersion(String str) {
        Throwable e;
        String str2;
        String str3;
        if (str == null) {
            return false;
        }
        Integer numValueOf = Integer.valueOf(str);
        try {
            if (sPreviousVersionCode == null) {
                int i = this.mMapplsAnalyticsPreferences.get().getInt("latest_version_code", -1);
                Integer numValueOf2 = Integer.valueOf(i);
                sPreviousVersionCode = numValueOf2;
                numValueOf2.getClass();
                if (i == -1) {
                    sPreviousVersionCode = numValueOf;
                    SharedPreferences.Editor editorEdit = this.mMapplsAnalyticsPreferences.get().edit();
                    editorEdit.putInt("latest_version_code", numValueOf.intValue());
                    writeEdits(editorEdit);
                }
            }
            if (sPreviousVersionCode.intValue() < numValueOf.intValue()) {
                SharedPreferences.Editor editorEdit2 = this.mMapplsAnalyticsPreferences.get().edit();
                editorEdit2.putInt("latest_version_code", numValueOf.intValue());
                writeEdits(editorEdit2);
                return true;
            }
        } catch (InterruptedException e2) {
            e = e2;
            str2 = LOGTAG;
            str3 = "Couldn't write internal Mappls Analytics from shared preferences.";
            MPLog.e(str2, str3, e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            str2 = LOGTAG;
            str3 = "Couldn't write internal Mappls Analytics shared preferences.";
            MPLog.e(str2, str3, e);
        }
        return false;
    }

    public synchronized void markEventsUserIdPresent() {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        this.mEventsUserIdPresent = true;
        writeIdentities();
    }

    public void registerSuperProperties(JSONObject jSONObject) {
        synchronized (this.mSuperPropsLock) {
            JSONObject superPropertiesCache = getSuperPropertiesCache();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                try {
                    superPropertiesCache.put(next, jSONObject.get(next));
                } catch (JSONException e) {
                    MPLog.e(LOGTAG, "Exception registering super property.", e);
                }
            }
            storeSuperProperties();
        }
    }

    public void registerSuperPropertiesOnce(JSONObject jSONObject) {
        synchronized (this.mSuperPropsLock) {
            JSONObject superPropertiesCache = getSuperPropertiesCache();
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                if (!superPropertiesCache.has(next)) {
                    try {
                        superPropertiesCache.put(next, jSONObject.get(next));
                    } catch (JSONException e) {
                        MPLog.e(LOGTAG, "Exception registering super property.", e);
                    }
                }
            }
            storeSuperProperties();
        }
    }

    protected void removeOptOutFlag(String str) {
        Throwable e;
        try {
            SharedPreferences.Editor editorEdit = this.mMapplsAnalyticsPreferences.get().edit();
            editorEdit.clear();
            writeEdits(editorEdit);
        } catch (InterruptedException e2) {
            e = e2;
            MPLog.e(LOGTAG, "Can't remove opt-out shared preferences.", e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            MPLog.e(LOGTAG, "Can't remove opt-out shared preferences.", e);
        }
    }

    public void removeTimedEvent(String str) {
        try {
            SharedPreferences.Editor editorEdit = this.mTimeEventsPreferences.get().edit();
            editorEdit.remove(str);
            writeEdits(editorEdit);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public synchronized void setAnonymousIdIfAbsent(String str) {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        if (this.mAnonymousId != null) {
            return;
        }
        this.mAnonymousId = str;
        this.mHadPersistedDistinctId = true;
        writeIdentities();
    }

    public synchronized void setEventsDistinctId(String str) {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        this.mEventsDistinctId = str;
        writeIdentities();
    }

    public synchronized void setHasLaunched(String str) {
        Throwable e;
        String str2;
        String str3;
        try {
            SharedPreferences.Editor editorEdit = this.mMapplsAnalyticsPreferences.get().edit();
            editorEdit.putBoolean("has_launched_" + str, true);
            writeEdits(editorEdit);
        } catch (InterruptedException e2) {
            e = e2;
            str2 = LOGTAG;
            str3 = "Couldn't write internal Mappls Analytics shared preferences.";
            MPLog.e(str2, str3, e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            str2 = LOGTAG;
            str3 = "Couldn't write internal Mappls Analytics shared preferences.";
            MPLog.e(str2, str3, e);
        }
    }

    public synchronized void setIsIntegrated(String str) {
        Throwable e;
        String str2;
        String str3;
        try {
            SharedPreferences.Editor editorEdit = this.mMapplsAnalyticsPreferences.get().edit();
            editorEdit.putBoolean(str, true);
            writeEdits(editorEdit);
        } catch (InterruptedException e2) {
            e = e2;
            str2 = LOGTAG;
            str3 = "Couldn't write internal Mappls Analytics from shared preferences.";
            MPLog.e(str2, str3, e);
        } catch (ExecutionException e3) {
            e = e3.getCause();
            str2 = LOGTAG;
            str3 = "Couldn't write internal Mappls Analytics shared preferences.";
            MPLog.e(str2, str3, e);
        }
    }

    public synchronized void setOptOutTracking(boolean z, String str) {
        this.mIsUserOptOut = Boolean.valueOf(z);
        writeOptOutFlag(str);
    }

    public synchronized void setPeopleDistinctId(String str) {
        if (!this.mIdentitiesLoaded) {
            readIdentities();
        }
        this.mPeopleDistinctId = str;
        writeIdentities();
    }

    public void unregisterSuperProperty(String str) {
        synchronized (this.mSuperPropsLock) {
            getSuperPropertiesCache().remove(str);
            storeSuperProperties();
        }
    }

    public void updateSuperProperties(SuperPropertyUpdate superPropertyUpdate) {
        synchronized (this.mSuperPropsLock) {
            JSONObject superPropertiesCache = getSuperPropertiesCache();
            JSONObject jSONObject = new JSONObject();
            try {
                Iterator<String> itKeys = superPropertiesCache.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    jSONObject.put(next, superPropertiesCache.get(next));
                }
                JSONObject jSONObjectUpdate = superPropertyUpdate.update(jSONObject);
                if (jSONObjectUpdate == null) {
                    MPLog.w(LOGTAG, "An update to Mappls Analytics's super properties returned null, and will have no effect.");
                } else {
                    this.mSuperPropertiesCache = jSONObjectUpdate;
                    storeSuperProperties();
                }
            } catch (JSONException e) {
                MPLog.e(LOGTAG, "Can't copy from one JSONObject to another", e);
            }
        }
    }
}
