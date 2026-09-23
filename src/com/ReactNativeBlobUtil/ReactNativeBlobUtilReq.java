package com.ReactNativeBlobUtil;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Base64;
import android.webkit.CookieManager;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.work.Data;
import com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilDefaultResp;
import com.ReactNativeBlobUtil.Response.ReactNativeBlobUtilFileResp;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public class ReactNativeBlobUtilReq extends BroadcastReceiver implements Runnable {
    Callback callback;
    boolean callbackfired;
    OkHttpClient client;
    long contentLength;
    String destPath;
    long downloadManagerId;
    private Future<?> future;
    ReadableMap headers;
    String method;
    ReactNativeBlobUtilConfig options;
    String rawRequestBody;
    ReadableArray rawRequestBodyArray;
    ReactNativeBlobUtilBody requestBody;
    RequestType requestType;
    WritableMap respInfo;
    ResponseType responseType;
    String taskId;
    String url;
    public static HashMap<String, Call> taskTable = new HashMap<>();
    public static HashMap<String, Long> androidDownloadManagerTaskTable = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> progressReport = new HashMap<>();
    static HashMap<String, ReactNativeBlobUtilProgressConfig> uploadProgressReport = new HashMap<>();
    static ConnectionPool pool = new ConnectionPool();
    ResponseFormat responseFormat = ResponseFormat.Auto;
    boolean timeout = false;
    ArrayList<String> redirects = new ArrayList<>();
    private final int QUERY = OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue;
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private Handler mHandler = new Handler(new Handler.Callback() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1314 && message.getData().getLong("downloadManagerId") == ReactNativeBlobUtilReq.this.downloadManagerId) {
                DownloadManager downloadManager = (DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download");
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(ReactNativeBlobUtilReq.this.downloadManagerId);
                Cursor cursorQuery = downloadManager.query(query);
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    long j = cursorQuery.getInt(cursorQuery.getColumnIndex("bytes_so_far"));
                    long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("total_size"));
                    cursorQuery.close();
                    ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilReq.this.taskId);
                    float f = j2 > 0 ? j / j2 : 0.0f;
                    if (reportProgress != null && reportProgress.shouldReport(f)) {
                        WritableMap writableMapCreateMap = Arguments.createMap();
                        writableMapCreateMap.putString("taskId", String.valueOf(ReactNativeBlobUtilReq.this.taskId));
                        writableMapCreateMap.putString("written", String.valueOf(j));
                        writableMapCreateMap.putString("total", String.valueOf(j2));
                        writableMapCreateMap.putString("chunk", "");
                        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, writableMapCreateMap);
                    }
                    if (j2 == j) {
                        ReactNativeBlobUtilReq.this.future.cancel(true);
                    }
                }
            }
            return true;
        }
    });

    enum RequestType {
        Form,
        SingleFile,
        AsIs,
        WithoutBody,
        Others
    }

    enum ResponseFormat {
        Auto,
        UTF8,
        BASE64
    }

    enum ResponseType {
        KeepInMemory,
        FileStorage
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder builder) {
        return builder;
    }

    private boolean shouldTransformFile() {
        return this.options.transformFile.booleanValue() && (this.options.fileCache.booleanValue() || this.options.path != null);
    }

    public ReactNativeBlobUtilReq(ReadableMap readableMap, String str, String str2, String str3, ReadableMap readableMap2, String str4, ReadableArray readableArray, OkHttpClient okHttpClient, Callback callback) {
        this.method = str2.toUpperCase(Locale.ROOT);
        ReactNativeBlobUtilConfig reactNativeBlobUtilConfig = new ReactNativeBlobUtilConfig(readableMap);
        this.options = reactNativeBlobUtilConfig;
        this.taskId = str;
        this.url = str3;
        this.headers = readableMap2;
        this.callback = callback;
        this.rawRequestBody = str4;
        this.rawRequestBodyArray = readableArray;
        this.client = okHttpClient;
        this.callbackfired = false;
        if ((reactNativeBlobUtilConfig.fileCache.booleanValue() || this.options.path != null) && !shouldTransformFile()) {
            this.responseType = ResponseType.FileStorage;
        } else {
            this.responseType = ResponseType.KeepInMemory;
        }
        if (str4 != null) {
            this.requestType = RequestType.SingleFile;
        } else if (readableArray != null) {
            this.requestType = RequestType.Form;
        } else {
            this.requestType = RequestType.WithoutBody;
        }
    }

    public static void cancelTask(String str) {
        Call call = taskTable.get(str);
        if (call != null) {
            call.cancel();
            taskTable.remove(str);
        }
        if (androidDownloadManagerTaskTable.containsKey(str)) {
            ((DownloadManager) ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getSystemService("download")).remove(androidDownloadManagerTaskTable.get(str).longValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invoke_callback(Object... objArr) {
        if (this.callbackfired) {
            return;
        }
        this.callback.invoke(objArr);
        this.callbackfired = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        OkHttpClient.Builder builderNewBuilder;
        if (this.options.addAndroidDownloads != null && this.options.addAndroidDownloads.hasKey("useDownloadManager") && this.options.addAndroidDownloads.getBoolean("useDownloadManager")) {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(this.url));
            if (this.options.addAndroidDownloads.hasKey("notification") && this.options.addAndroidDownloads.getBoolean("notification")) {
                request.setNotificationVisibility(1);
            } else {
                request.setNotificationVisibility(2);
            }
            if (this.options.addAndroidDownloads.hasKey("title")) {
                request.setTitle(this.options.addAndroidDownloads.getString("title"));
            }
            if (this.options.addAndroidDownloads.hasKey(SavingTrackHelper.POINT_COL_DESCRIPTION)) {
                request.setDescription(this.options.addAndroidDownloads.getString(SavingTrackHelper.POINT_COL_DESCRIPTION));
            }
            if (this.options.addAndroidDownloads.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
                request.setDestinationUri(Uri.parse("file://" + this.options.addAndroidDownloads.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)));
            }
            if (this.options.addAndroidDownloads.hasKey("mime")) {
                request.setMimeType(this.options.addAndroidDownloads.getString("mime"));
            }
            if (this.options.addAndroidDownloads.hasKey("mediaScannable") && this.options.addAndroidDownloads.getBoolean("mediaScannable")) {
                request.allowScanningByMediaScanner();
            }
            if (Build.VERSION.SDK_INT >= 29 && this.options.addAndroidDownloads.hasKey("storeInDownloads") && this.options.addAndroidDownloads.getBoolean("storeInDownloads")) {
                String string = this.options.addAndroidDownloads.getString("title");
                if (string == null || string.isEmpty()) {
                    string = UUID.randomUUID().toString();
                }
                if (this.options.appendExt != null && !this.options.appendExt.isEmpty()) {
                    string = string + "." + this.options.appendExt;
                }
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, string);
            }
            ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator = this.headers.keySetIterator();
            while (readableMapKeySetIteratorKeySetIterator.hasNextKey()) {
                String strNextKey = readableMapKeySetIteratorKeySetIterator.nextKey();
                request.addRequestHeader(strNextKey, this.headers.getString(strNextKey));
            }
            try {
                URL url = new URL(this.url);
                request.addRequestHeader(HttpHeaders.COOKIE, CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Context applicationContext = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext();
            long jEnqueue = ((DownloadManager) applicationContext.getSystemService("download")).enqueue(request);
            this.downloadManagerId = jEnqueue;
            androidDownloadManagerTaskTable.put(this.taskId, Long.valueOf(jEnqueue));
            if (Build.VERSION.SDK_INT >= 34) {
                applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"), 2);
            } else {
                applicationContext.registerReceiver(this, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
            }
            this.future = this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.2
                @Override // java.lang.Runnable
                public void run() {
                    Message messageObtainMessage = ReactNativeBlobUtilReq.this.mHandler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putLong("downloadManagerId", ReactNativeBlobUtilReq.this.downloadManagerId);
                    messageObtainMessage.setData(bundle);
                    messageObtainMessage.what = OlympusCameraSettingsMakernoteDirectory.TagPictureModeHue;
                    ReactNativeBlobUtilReq.this.mHandler.sendMessage(messageObtainMessage);
                }
            }, 0L, 100L, TimeUnit.MILLISECONDS);
            return;
        }
        String md5 = this.taskId;
        if (this.options.appendExt == null || this.options.appendExt.isEmpty()) {
            str = "";
        } else {
            str = "." + this.options.appendExt;
        }
        if (this.options.key != null) {
            md5 = ReactNativeBlobUtilUtils.getMD5(this.options.key);
            if (md5 == null) {
                md5 = this.taskId;
            }
            File file = new File(ReactNativeBlobUtilFS.getTmpPath(md5) + str);
            if (file.exists()) {
                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, file.getAbsolutePath());
                return;
            }
        }
        if (this.options.path != null) {
            this.destPath = this.options.path;
        } else if (this.options.fileCache.booleanValue()) {
            this.destPath = ReactNativeBlobUtilFS.getTmpPath(md5) + str;
        }
        try {
            if (this.options.trusty.booleanValue()) {
                builderNewBuilder = ReactNativeBlobUtilUtils.getUnsafeOkHttpClient(this.client);
            } else {
                builderNewBuilder = this.client.newBuilder();
            }
            OkHttpClient.Builder builder = builderNewBuilder;
            if (this.options.wifiOnly.booleanValue()) {
                ReactApplicationContext reactApplicationContext = ReactNativeBlobUtilImpl.RCTContext;
                ReactApplicationContext reactApplicationContext2 = ReactNativeBlobUtilImpl.RCTContext;
                ConnectivityManager connectivityManager = (ConnectivityManager) reactApplicationContext.getSystemService("connectivity");
                Network[] allNetworks = connectivityManager.getAllNetworks();
                int length = allNetworks.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        Network network = allNetworks[i];
                        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                        if (networkCapabilities != null && networkInfo != null && networkInfo.isConnected() && networkCapabilities.hasTransport(1)) {
                            builder.proxy(Proxy.NO_PROXY);
                            builder.socketFactory(network.getSocketFactory());
                            break;
                        }
                        i++;
                    } else {
                        invoke_callback("No available WiFi connections.", null, null);
                        releaseTaskResource();
                        return;
                    }
                }
            }
            Request.Builder builder2 = new Request.Builder();
            try {
                builder2.url(new URL(this.url));
            } catch (MalformedURLException e2) {
                e2.printStackTrace();
            }
            HashMap<String, String> map = new HashMap<>();
            ReadableMap readableMap = this.headers;
            if (readableMap != null) {
                ReadableMapKeySetIterator readableMapKeySetIteratorKeySetIterator2 = readableMap.keySetIterator();
                while (readableMapKeySetIteratorKeySetIterator2.hasNextKey()) {
                    String strNextKey2 = readableMapKeySetIteratorKeySetIterator2.nextKey();
                    String string2 = this.headers.getString(strNextKey2);
                    if (strNextKey2.equalsIgnoreCase("RNFB-Response")) {
                        if (string2.equalsIgnoreCase("base64")) {
                            this.responseFormat = ResponseFormat.BASE64;
                        } else if (string2.equalsIgnoreCase(ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8)) {
                            this.responseFormat = ResponseFormat.UTF8;
                        }
                    } else {
                        builder2.header(strNextKey2.toLowerCase(Locale.ROOT), string2);
                        map.put(strNextKey2.toLowerCase(Locale.ROOT), string2);
                    }
                }
            }
            if (this.method.equalsIgnoreCase("post") || this.method.equalsIgnoreCase("put") || this.method.equalsIgnoreCase("patch")) {
                String lowerCase = getHeaderIgnoreCases(map, "Content-Type").toLowerCase(Locale.ROOT);
                if (this.rawRequestBodyArray != null) {
                    this.requestType = RequestType.Form;
                } else if (lowerCase == null || lowerCase.isEmpty()) {
                    if (!lowerCase.equalsIgnoreCase("")) {
                        builder2.header("Content-Type", "application/octet-stream");
                    }
                    this.requestType = RequestType.SingleFile;
                }
                String str2 = this.rawRequestBody;
                if (str2 != null) {
                    if (!str2.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX) && !this.rawRequestBody.startsWith(ReactNativeBlobUtilConst.CONTENT_PREFIX)) {
                        if (lowerCase.toLowerCase(Locale.ROOT).contains(";base64") || lowerCase.toLowerCase(Locale.ROOT).startsWith("application/octet")) {
                            String strReplace = lowerCase.replace(";base64", "").replace(";BASE64", "");
                            if (map.containsKey("content-type")) {
                                map.put("content-type", strReplace);
                            }
                            if (map.containsKey("Content-Type")) {
                                map.put("Content-Type", strReplace);
                            }
                            this.requestType = RequestType.SingleFile;
                        } else {
                            this.requestType = RequestType.AsIs;
                        }
                    } else {
                        this.requestType = RequestType.SingleFile;
                    }
                }
            } else {
                this.requestType = RequestType.WithoutBody;
            }
            boolean zEqualsIgnoreCase = getHeaderIgnoreCases(map, HttpHeaders.TRANSFER_ENCODING).equalsIgnoreCase("chunked");
            int i2 = AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[this.requestType.ordinal()];
            if (i2 == 1) {
                ReactNativeBlobUtilBody mime = new ReactNativeBlobUtilBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBody).setMIME(MediaType.parse(getHeaderIgnoreCases(map, "content-type")));
                this.requestBody = mime;
                builder2.method(this.method, mime);
            } else if (i2 == 2) {
                ReactNativeBlobUtilBody mime2 = new ReactNativeBlobUtilBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBody).setMIME(MediaType.parse(getHeaderIgnoreCases(map, "content-type")));
                this.requestBody = mime2;
                builder2.method(this.method, mime2);
            } else if (i2 == 3) {
                String str3 = "ReactNativeBlobUtil-" + this.taskId;
                ReactNativeBlobUtilBody mime3 = new ReactNativeBlobUtilBody(this.taskId).chunkedEncoding(zEqualsIgnoreCase).setRequestType(this.requestType).setBody(this.rawRequestBodyArray).setMIME(MediaType.parse("multipart/form-data; boundary=" + str3));
                this.requestBody = mime3;
                builder2.method(this.method, mime3);
            } else if (i2 == 4) {
                if (this.method.equalsIgnoreCase("post") || this.method.equalsIgnoreCase("put") || this.method.equalsIgnoreCase("patch")) {
                    builder2.method(this.method, RequestBody.create((MediaType) null, new byte[0]));
                } else {
                    builder2.method(this.method, null);
                }
            }
            final Request requestBuild = builder2.build();
            builder.addNetworkInterceptor(new Interceptor() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.3
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    ReactNativeBlobUtilReq.this.redirects.add(chain.request().url().getUrl());
                    return chain.proceed(chain.request());
                }
            });
            builder.addInterceptor(new Interceptor() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.4
                @Override // okhttp3.Interceptor
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    ResponseBody reactNativeBlobUtilDefaultResp;
                    Response responseProceed = null;
                    try {
                        responseProceed = chain.proceed(requestBuild);
                        int i3 = AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[ReactNativeBlobUtilReq.this.responseType.ordinal()];
                        if (i3 != 1 && i3 == 2) {
                            reactNativeBlobUtilDefaultResp = new ReactNativeBlobUtilFileResp(ReactNativeBlobUtilImpl.RCTContext, ReactNativeBlobUtilReq.this.taskId, responseProceed.body(), ReactNativeBlobUtilReq.this.destPath, ReactNativeBlobUtilReq.this.options.overwrite.booleanValue());
                        } else {
                            reactNativeBlobUtilDefaultResp = new ReactNativeBlobUtilDefaultResp(ReactNativeBlobUtilImpl.RCTContext, ReactNativeBlobUtilReq.this.taskId, responseProceed.body(), ReactNativeBlobUtilReq.this.options.increment.booleanValue());
                        }
                        return responseProceed.newBuilder().body(reactNativeBlobUtilDefaultResp).build();
                    } catch (SocketException unused) {
                        ReactNativeBlobUtilReq.this.timeout = true;
                        if (responseProceed != null) {
                            responseProceed.close();
                        }
                        return chain.proceed(chain.request());
                    } catch (SocketTimeoutException unused2) {
                        ReactNativeBlobUtilReq.this.timeout = true;
                        if (responseProceed != null) {
                            responseProceed.close();
                        }
                        return chain.proceed(chain.request());
                    } catch (Exception unused3) {
                        if (responseProceed != null) {
                            responseProceed.close();
                        }
                        return chain.proceed(chain.request());
                    }
                }
            });
            if (this.options.timeout >= 0) {
                builder.connectTimeout(this.options.timeout, TimeUnit.MILLISECONDS);
                builder.readTimeout(this.options.timeout, TimeUnit.MILLISECONDS);
            }
            builder.connectionPool(pool);
            builder.retryOnConnectionFailure(false);
            builder.followRedirects(this.options.followRedirect.booleanValue());
            builder.followSslRedirects(this.options.followRedirect.booleanValue());
            builder.retryOnConnectionFailure(true);
            Call callNewCall = enableTls12OnPreLollipop(builder).build().newCall(requestBuild);
            taskTable.put(this.taskId, callNewCall);
            FirebasePerfOkHttpClient.enqueue(callNewCall, new okhttp3.Callback() { // from class: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq.5
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    ReactNativeBlobUtilReq.cancelTask(ReactNativeBlobUtilReq.this.taskId);
                    if (ReactNativeBlobUtilReq.this.respInfo == null) {
                        ReactNativeBlobUtilReq.this.respInfo = Arguments.createMap();
                    }
                    if (iOException.getClass().equals(SocketTimeoutException.class)) {
                        ReactNativeBlobUtilReq.this.respInfo.putBoolean("timeout", true);
                        ReactNativeBlobUtilReq.this.invoke_callback("The request timed out.", null, null);
                    } else {
                        ReactNativeBlobUtilReq.this.invoke_callback(iOException.getLocalizedMessage(), null, null);
                    }
                    ReactNativeBlobUtilReq.this.releaseTaskResource();
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    String string3;
                    ReadableMap readableMap2 = ReactNativeBlobUtilReq.this.options.addAndroidDownloads;
                    if (readableMap2 != null) {
                        String string4 = readableMap2.hasKey("title") ? ReactNativeBlobUtilReq.this.options.addAndroidDownloads.getString("title") : "";
                        String string5 = readableMap2.hasKey(SavingTrackHelper.POINT_COL_DESCRIPTION) ? readableMap2.getString(SavingTrackHelper.POINT_COL_DESCRIPTION) : "";
                        if (!readableMap2.hasKey("mime")) {
                            string3 = "text/plain";
                        } else {
                            string3 = readableMap2.getString("mime");
                        }
                        String str4 = string3;
                        boolean z = readableMap2.hasKey("mediaScannable") ? readableMap2.getBoolean("mediaScannable") : false;
                        boolean z2 = readableMap2.hasKey("notification") ? readableMap2.getBoolean("notification") : false;
                        ReactApplicationContext reactApplicationContext3 = ReactNativeBlobUtilImpl.RCTContext;
                        ReactApplicationContext reactApplicationContext4 = ReactNativeBlobUtilImpl.RCTContext;
                        ((DownloadManager) reactApplicationContext3.getSystemService("download")).addCompletedDownload(string4, string5, z, str4, ReactNativeBlobUtilReq.this.destPath, ReactNativeBlobUtilReq.this.contentLength, z2);
                    }
                    ReactNativeBlobUtilReq.this.done(response);
                }
            });
        } catch (Exception e3) {
            e3.printStackTrace();
            releaseTaskResource();
            invoke_callback("ReactNativeBlobUtil request error: " + e3.getMessage() + e3.getCause());
        }
    }

    /* JADX INFO: renamed from: com.ReactNativeBlobUtil.ReactNativeBlobUtilReq$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType;
        static final /* synthetic */ int[] $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType;

        static {
            int[] iArr = new int[ResponseType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType = iArr;
            try {
                iArr[ResponseType.KeepInMemory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[ResponseType.FileStorage.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[RequestType.values().length];
            $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType = iArr2;
            try {
                iArr2[RequestType.SingleFile.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.AsIs.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.Form.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$RequestType[RequestType.WithoutBody.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseTaskResource() {
        if (taskTable.containsKey(this.taskId)) {
            taskTable.remove(this.taskId);
        }
        if (androidDownloadManagerTaskTable.containsKey(this.taskId)) {
            androidDownloadManagerTaskTable.remove(this.taskId);
        }
        if (uploadProgressReport.containsKey(this.taskId)) {
            uploadProgressReport.remove(this.taskId);
        }
        if (progressReport.containsKey(this.taskId)) {
            progressReport.remove(this.taskId);
        }
        ReactNativeBlobUtilBody reactNativeBlobUtilBody = this.requestBody;
        if (reactNativeBlobUtilBody != null) {
            reactNativeBlobUtilBody.clearRequestBody();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:41:0x0133 A[Catch: IOException -> 0x0206, TryCatch #2 {IOException -> 0x0206, blocks: (B:34:0x00ec, B:36:0x00f6, B:37:0x0112, B:39:0x0119, B:40:0x011d, B:41:0x0133, B:43:0x0141, B:45:0x0145, B:47:0x015a, B:48:0x015d, B:50:0x016b, B:51:0x016e, B:60:0x0187, B:58:0x0185, B:57:0x0182, B:62:0x01a3, B:63:0x01aa, B:64:0x01ab, B:67:0x01b3, B:69:0x01c3, B:71:0x01df, B:73:0x01e5, B:74:0x01f6), top: B:84:0x00ec, inners: #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x0141 A[Catch: IOException -> 0x0206, TryCatch #2 {IOException -> 0x0206, blocks: (B:34:0x00ec, B:36:0x00f6, B:37:0x0112, B:39:0x0119, B:40:0x011d, B:41:0x0133, B:43:0x0141, B:45:0x0145, B:47:0x015a, B:48:0x015d, B:50:0x016b, B:51:0x016e, B:60:0x0187, B:58:0x0185, B:57:0x0182, B:62:0x01a3, B:63:0x01aa, B:64:0x01ab, B:67:0x01b3, B:69:0x01c3, B:71:0x01df, B:73:0x01e5, B:74:0x01f6), top: B:84:0x00ec, inners: #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0145 A[Catch: IOException -> 0x0206, TryCatch #2 {IOException -> 0x0206, blocks: (B:34:0x00ec, B:36:0x00f6, B:37:0x0112, B:39:0x0119, B:40:0x011d, B:41:0x0133, B:43:0x0141, B:45:0x0145, B:47:0x015a, B:48:0x015d, B:50:0x016b, B:51:0x016e, B:60:0x0187, B:58:0x0185, B:57:0x0182, B:62:0x01a3, B:63:0x01aa, B:64:0x01ab, B:67:0x01b3, B:69:0x01c3, B:71:0x01df, B:73:0x01e5, B:74:0x01f6), top: B:84:0x00ec, inners: #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x015a A[Catch: IOException -> 0x0206, TRY_LEAVE, TryCatch #2 {IOException -> 0x0206, blocks: (B:34:0x00ec, B:36:0x00f6, B:37:0x0112, B:39:0x0119, B:40:0x011d, B:41:0x0133, B:43:0x0141, B:45:0x0145, B:47:0x015a, B:48:0x015d, B:50:0x016b, B:51:0x016e, B:60:0x0187, B:58:0x0185, B:57:0x0182, B:62:0x01a3, B:63:0x01aa, B:64:0x01ab, B:67:0x01b3, B:69:0x01c3, B:71:0x01df, B:73:0x01e5, B:74:0x01f6), top: B:84:0x00ec, inners: #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x01a3 A[Catch: IOException -> 0x0206, TryCatch #2 {IOException -> 0x0206, blocks: (B:34:0x00ec, B:36:0x00f6, B:37:0x0112, B:39:0x0119, B:40:0x011d, B:41:0x0133, B:43:0x0141, B:45:0x0145, B:47:0x015a, B:48:0x015d, B:50:0x016b, B:51:0x016e, B:60:0x0187, B:58:0x0185, B:57:0x0182, B:62:0x01a3, B:63:0x01aa, B:64:0x01ab, B:67:0x01b3, B:69:0x01c3, B:71:0x01df, B:73:0x01e5, B:74:0x01f6), top: B:84:0x00ec, inners: #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x01ab A[Catch: IOException -> 0x0206, TRY_LEAVE, TryCatch #2 {IOException -> 0x0206, blocks: (B:34:0x00ec, B:36:0x00f6, B:37:0x0112, B:39:0x0119, B:40:0x011d, B:41:0x0133, B:43:0x0141, B:45:0x0145, B:47:0x015a, B:48:0x015d, B:50:0x016b, B:51:0x016e, B:60:0x0187, B:58:0x0185, B:57:0x0182, B:62:0x01a3, B:63:0x01aa, B:64:0x01ab, B:67:0x01b3, B:69:0x01c3, B:71:0x01df, B:73:0x01e5, B:74:0x01f6), top: B:84:0x00ec, inners: #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01b3 A[Catch: IOException -> 0x0206, TRY_ENTER, TRY_LEAVE, TryCatch #2 {IOException -> 0x0206, blocks: (B:34:0x00ec, B:36:0x00f6, B:37:0x0112, B:39:0x0119, B:40:0x011d, B:41:0x0133, B:43:0x0141, B:45:0x0145, B:47:0x015a, B:48:0x015d, B:50:0x016b, B:51:0x016e, B:60:0x0187, B:58:0x0185, B:57:0x0182, B:62:0x01a3, B:63:0x01aa, B:64:0x01ab, B:67:0x01b3, B:69:0x01c3, B:71:0x01df, B:73:0x01e5, B:74:0x01f6), top: B:84:0x00ec, inners: #3, #7 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public void done(Response response) throws IOException {
        byte[] bArrBytes;
        File file;
        FileOutputStream fileOutputStream;
        boolean zIsBlobResponse = isBlobResponse(response);
        WritableMap responseInfo = getResponseInfo(response, zIsBlobResponse);
        emitStateEvent(responseInfo.copy());
        emitStateEvent(getResponseInfo(response, zIsBlobResponse));
        int i = AnonymousClass6.$SwitchMap$com$ReactNativeBlobUtil$ReactNativeBlobUtilReq$ResponseType[this.responseType.ordinal()];
        String strString = null;
        if (i != 1) {
            if (i == 2) {
                ResponseBody responseBodyBody = response.body();
                try {
                    responseBodyBody.bytes();
                } catch (Exception unused) {
                }
                try {
                    ReactNativeBlobUtilFileResp reactNativeBlobUtilFileResp = (ReactNativeBlobUtilFileResp) responseBodyBody;
                    if (reactNativeBlobUtilFileResp != null && !reactNativeBlobUtilFileResp.isDownloadComplete()) {
                        invoke_callback("Download interrupted.", responseInfo.copy());
                    } else {
                        String strReplace = this.destPath.replace("?append=true", "");
                        this.destPath = strReplace;
                        invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, strReplace, responseInfo.copy());
                    }
                } catch (ClassCastException unused2) {
                    if (responseBodyBody != null) {
                        try {
                            boolean z = responseBodyBody.getSource().getBufferField().size() > 0;
                            boolean z2 = responseBodyBody.getContentLength() > 0;
                            if (z && z2) {
                                strString = responseBodyBody.string();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        invoke_callback("Unexpected FileStorage response file: " + strString, responseInfo.copy());
                        return;
                    }
                    invoke_callback("Unexpected FileStorage response with no file.", responseInfo.copy());
                    return;
                }
            } else {
                try {
                    invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(response.body().bytes(), "UTF-8"), responseInfo.copy());
                } catch (IOException unused3) {
                    invoke_callback("ReactNativeBlobUtil failed to encode response data to UTF8 string.", responseInfo.copy());
                }
            }
        } else if (zIsBlobResponse) {
            try {
                if (this.options.auto.booleanValue()) {
                    String tmpPath = ReactNativeBlobUtilFS.getTmpPath(this.taskId);
                    InputStream inputStreamByteStream = response.body().byteStream();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(tmpPath));
                    byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                    while (true) {
                        int i2 = inputStreamByteStream.read(bArr);
                        if (i2 == -1) {
                            break;
                        } else {
                            fileOutputStream2.write(bArr, 0, i2);
                        }
                    }
                    inputStreamByteStream.close();
                    fileOutputStream2.flush();
                    fileOutputStream2.close();
                    invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, tmpPath, responseInfo.copy());
                } else {
                    bArrBytes = response.body().bytes();
                    if (shouldTransformFile()) {
                        if (ReactNativeBlobUtilFileTransformer.sharedFileTransformer != null) {
                            throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                        }
                        this.destPath = this.destPath.replace("?append=true", "");
                        file = new File(this.destPath);
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                fileOutputStream.write(ReactNativeBlobUtilFileTransformer.sharedFileTransformer.onWriteFile(bArrBytes));
                                fileOutputStream.close();
                                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, this.destPath, responseInfo.copy());
                                return;
                            } catch (Throwable th) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                                throw th;
                            }
                        } catch (Exception e2) {
                            invoke_callback("Error from file transformer:" + e2.getLocalizedMessage(), responseInfo.copy());
                            return;
                        }
                    }
                    if (this.responseFormat == ResponseFormat.BASE64) {
                        invoke_callback(null, "base64", Base64.encodeToString(bArrBytes, 2), responseInfo.copy());
                        return;
                    }
                    try {
                        Charset charsetForName = Charset.forName("UTF-8");
                        charsetForName.newDecoder().decode(ByteBuffer.wrap(bArrBytes));
                        invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bArrBytes, charsetForName));
                    } catch (CharacterCodingException unused4) {
                        if (this.responseFormat == ResponseFormat.UTF8) {
                            invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bArrBytes), responseInfo.copy());
                        } else {
                            invoke_callback(null, "base64", Base64.encodeToString(bArrBytes, 2), responseInfo.copy());
                        }
                    }
                    invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
                }
            } catch (IOException unused5) {
                invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
            }
        } else {
            bArrBytes = response.body().bytes();
            if (shouldTransformFile()) {
                if (ReactNativeBlobUtilFileTransformer.sharedFileTransformer != null) {
                    throw new IllegalStateException("Write file with transform was specified but the shared file transformer is not set");
                }
                this.destPath = this.destPath.replace("?append=true", "");
                file = new File(this.destPath);
                if (!file.exists()) {
                    file.createNewFile();
                }
                fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(ReactNativeBlobUtilFileTransformer.sharedFileTransformer.onWriteFile(bArrBytes));
                fileOutputStream.close();
                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, this.destPath, responseInfo.copy());
                return;
            }
            if (this.responseFormat == ResponseFormat.BASE64) {
                invoke_callback(null, "base64", Base64.encodeToString(bArrBytes, 2), responseInfo.copy());
                return;
            } else {
                Charset charsetForName2 = Charset.forName("UTF-8");
                charsetForName2.newDecoder().decode(ByteBuffer.wrap(bArrBytes));
                invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_UTF8, new String(bArrBytes, charsetForName2));
            }
            invoke_callback("ReactNativeBlobUtil failed to encode response data to BASE64 string.", responseInfo.copy());
        }
        response.body().close();
        releaseTaskResource();
    }

    public static ReactNativeBlobUtilProgressConfig getReportProgress(String str) {
        if (progressReport.containsKey(str)) {
            return progressReport.get(str);
        }
        return null;
    }

    public static ReactNativeBlobUtilProgressConfig getReportUploadProgress(String str) {
        if (uploadProgressReport.containsKey(str)) {
            return uploadProgressReport.get(str);
        }
        return null;
    }

    private WritableMap getResponseInfo(Response response, boolean z) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(NotificationCompat.CATEGORY_STATUS, response.code());
        writableMapCreateMap.putString("state", ExifInterface.GPS_MEASUREMENT_2D);
        writableMapCreateMap.putString("taskId", this.taskId);
        writableMapCreateMap.putBoolean("timeout", this.timeout);
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        for (int i = 0; i < response.headers().size(); i++) {
            writableMapCreateMap2.putString(response.headers().name(i), response.headers().value(i));
        }
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<String> it2 = this.redirects.iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushString(it2.next());
        }
        writableMapCreateMap.putArray("redirects", writableArrayCreateArray);
        writableMapCreateMap.putMap("headers", writableMapCreateMap2);
        Headers headers = response.headers();
        if (z) {
            writableMapCreateMap.putString("respType", "blob");
        } else if (getHeaderIgnoreCases(headers, "content-type").equalsIgnoreCase("text/")) {
            writableMapCreateMap.putString("respType", "text");
        } else if (getHeaderIgnoreCases(headers, "content-type").contains("application/json")) {
            writableMapCreateMap.putString("respType", "json");
        } else {
            writableMapCreateMap.putString("respType", "");
        }
        return writableMapCreateMap;
    }

    private boolean isBlobResponse(Response response) {
        boolean z;
        String headerIgnoreCases = getHeaderIgnoreCases(response.headers(), "Content-Type");
        boolean zEqualsIgnoreCase = headerIgnoreCases.equalsIgnoreCase("text/");
        boolean zEqualsIgnoreCase2 = headerIgnoreCases.equalsIgnoreCase("application/json");
        if (this.options.binaryContentTypes == null) {
            z = false;
            break;
        }
        int i = 0;
        while (true) {
            if (i >= this.options.binaryContentTypes.size()) {
                z = false;
                break;
            }
            if (headerIgnoreCases.toLowerCase(Locale.ROOT).contains(this.options.binaryContentTypes.getString(i).toLowerCase(Locale.ROOT))) {
                z = true;
                break;
            }
            i++;
        }
        return (zEqualsIgnoreCase2 && zEqualsIgnoreCase) || z;
    }

    private String getHeaderIgnoreCases(Headers headers, String str) {
        String str2 = headers.get(str);
        if (str2 != null) {
            return str2;
        }
        return headers.get(str.toLowerCase(Locale.ROOT)) == null ? "" : headers.get(str.toLowerCase(Locale.ROOT));
    }

    private String getHeaderIgnoreCases(HashMap<String, String> map, String str) {
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3 = map.get(str.toLowerCase(Locale.ROOT));
        return str3 == null ? "" : str3;
    }

    private void emitStateEvent(WritableMap writableMap) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilImpl.RCTContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_HTTP_STATE, writableMap);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x00ca  */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String string;
        Cursor cursorQuery;
        if ("android.intent.action.DOWNLOAD_COMPLETE".equals(intent.getAction())) {
            Context applicationContext = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext();
            if (intent.getExtras().getLong("extra_download_id") == this.downloadManagerId) {
                releaseTaskResource();
                DownloadManager.Query query = new DownloadManager.Query();
                query.setFilterById(this.downloadManagerId);
                DownloadManager downloadManager = (DownloadManager) applicationContext.getSystemService("download");
                downloadManager.query(query);
                Cursor cursorQuery2 = downloadManager.query(query);
                if (cursorQuery2 == null) {
                    invoke_callback("Download manager failed to download from  " + this.url + ". Query was unsuccessful ", null, null);
                    return;
                }
                try {
                    if (cursorQuery2.moveToFirst()) {
                        int i = cursorQuery2.getInt(cursorQuery2.getColumnIndex(NotificationCompat.CATEGORY_STATUS));
                        if (i == 16) {
                            invoke_callback("Download manager failed to download from  " + this.url + ". Status Code = " + i, null, null);
                            if (cursorQuery2 != null) {
                                cursorQuery2.close();
                                return;
                            }
                            return;
                        }
                        String string2 = cursorQuery2.getString(cursorQuery2.getColumnIndex("local_uri"));
                        if (string2 == null || (cursorQuery = applicationContext.getContentResolver().query(Uri.parse(string2), new String[]{"_data"}, null, null, null)) == null) {
                            string = null;
                        } else {
                            cursorQuery.moveToFirst();
                            string = cursorQuery.getString(0);
                            cursorQuery.close();
                        }
                    } else {
                        string = null;
                    }
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                    }
                    if (this.options.addAndroidDownloads.hasKey(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
                        try {
                            String string3 = this.options.addAndroidDownloads.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
                            if (!new File(string3).exists()) {
                                throw new Exception("Download manager download failed, the file does not downloaded to destination.");
                            }
                            invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, string3);
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            invoke_callback(e.getLocalizedMessage(), null);
                            return;
                        }
                    }
                    if (Build.VERSION.SDK_INT < 29 || !this.options.addAndroidDownloads.hasKey("storeInDownloads") || !this.options.addAndroidDownloads.getBoolean("storeInDownloads")) {
                        if (string == null) {
                            invoke_callback("Download manager could not resolve downloaded file path.", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, null);
                            return;
                        } else {
                            invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, string);
                            return;
                        }
                    }
                    Uri uriForDownloadedFile = downloadManager.getUriForDownloadedFile(this.downloadManagerId);
                    if (uriForDownloadedFile == null) {
                        invoke_callback("Download manager could not resolve downloaded file uri.", ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, null);
                    } else {
                        invoke_callback(null, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, uriForDownloadedFile.toString());
                    }
                } catch (Throwable th) {
                    if (cursorQuery2 != null) {
                        cursorQuery2.close();
                    }
                    throw th;
                }
            }
        }
    }
}
