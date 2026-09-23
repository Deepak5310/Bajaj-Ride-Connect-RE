package com.mappls.sdk.maps.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Environment;
import com.mappls.sdk.maps.MapStrictMode;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.util.TileServerOptions;
import com.mappls.sdk.maps.utils.FileUtils;
import com.mappls.sdk.maps.utils.ThreadUtils;
import java.io.File;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes4.dex */
public class FileSource {
    private static FileSource INSTANCE = null;
    private static final String MAPPLS_SHARED_PREFERENCE_RESOURCES_CACHE_PATH = "fileSourceResourcesCachePath";
    private static final String TAG = "Mbgl-FileSource";
    private static String internalCachePath;
    private static String resourcesCachePath;
    private long nativePtr;
    private static final Lock resourcesCachePathLoaderLock = new ReentrantLock();
    private static final Lock internalCachePathLoaderLock = new ReentrantLock();

    public interface ResourceTransformCallback {
        String onURL(int i, String str);
    }

    public interface ResourcesCachePathChangeCallback {
        void onError(String str);

        void onSuccess(String str);
    }

    private native void initialize(String str, String str2, TileServerOptions tileServerOptions);

    private native void setResourceCachePath(String str, ResourcesCachePathChangeCallback resourcesCachePathChangeCallback);

    public native void activate();

    public native void deactivate();

    protected native void finalize() throws Throwable;

    public native String getApiBaseUrl();

    public native String getApiKey();

    public native boolean isActivated();

    public native void setApiBaseUrl(String str);

    public native void setApiKey(String str);

    public native void setResourceTransform(ResourceTransformCallback resourceTransformCallback);

    public native void setTileServerOptions(TileServerOptions tileServerOptions);

    public static synchronized FileSource getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new FileSource(getResourcesCachePath(context));
        }
        return INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getCachePath(Context context) {
        String string = context.getSharedPreferences(MapplsConstants.MAPPLS_SHARED_PREFERENCES, 0).getString(MAPPLS_SHARED_PREFERENCE_RESOURCES_CACHE_PATH, null);
        if (isPathWritable(string)) {
            return string;
        }
        String defaultCachePath = getDefaultCachePath(context);
        context.getSharedPreferences(MapplsConstants.MAPPLS_SHARED_PREFERENCES, 0).edit().remove(MAPPLS_SHARED_PREFERENCE_RESOURCES_CACHE_PATH).apply();
        return defaultCachePath;
    }

    private static String getDefaultCachePath(Context context) {
        File externalFilesDir;
        if (isExternalStorageConfiguration(context) && isExternalStorageReadable() && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            return externalFilesDir.getAbsolutePath();
        }
        return context.getFilesDir().getAbsolutePath();
    }

    private static boolean isExternalStorageConfiguration(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                return applicationInfo.metaData.getBoolean(MapplsConstants.KEY_META_DATA_SET_STORAGE_EXTERNAL, false);
            }
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.e(TAG, "Failed to read the package metadata: ", e);
            MapStrictMode.strictModeViolation(e);
            return false;
        } catch (Exception e2) {
            Logger.e(TAG, "Failed to read the storage key: ", e2);
            MapStrictMode.strictModeViolation(e2);
            return false;
        }
    }

    public static boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        if ("mounted".equals(externalStorageState) || "mounted_ro".equals(externalStorageState)) {
            return true;
        }
        Logger.w(TAG, "External storage was requested but it isn't readable. For API level < 18 make sure you've requested READ_EXTERNAL_STORAGE or WRITE_EXTERNAL_STORAGE permissions in your app Manifest (defaulting to internal storage).");
        return false;
    }

    public static void initializeFileDirsPaths(Context context) {
        ThreadUtils.checkThread(TAG);
        lockPathLoaders();
        if (resourcesCachePath == null || internalCachePath == null) {
            new FileDirsPathsTask().execute(context);
        }
    }

    private static class FileDirsPathsTask extends AsyncTask<Context, Void, String[]> {
        private FileDirsPathsTask() {
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            FileSource.unlockPathLoaders();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public String[] doInBackground(Context... contextArr) {
            return new String[]{FileSource.getCachePath(contextArr[0]), contextArr[0].getCacheDir().getAbsolutePath()};
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(String[] strArr) {
            String unused = FileSource.resourcesCachePath = strArr[0];
            String unused2 = FileSource.internalCachePath = strArr[1];
            FileSource.unlockPathLoaders();
        }
    }

    public static String getResourcesCachePath(Context context) {
        resourcesCachePathLoaderLock.lock();
        try {
            if (resourcesCachePath == null) {
                resourcesCachePath = getCachePath(context);
            }
            return resourcesCachePath;
        } finally {
            resourcesCachePathLoaderLock.unlock();
        }
    }

    public static String getInternalCachePath(Context context) {
        internalCachePathLoaderLock.lock();
        try {
            if (internalCachePath == null) {
                internalCachePath = context.getCacheDir().getAbsolutePath();
            }
            return internalCachePath;
        } finally {
            internalCachePathLoaderLock.unlock();
        }
    }

    @Deprecated
    public static void setResourcesCachePath(Context context, String str, ResourcesCachePathChangeCallback resourcesCachePathChangeCallback) {
        setResourcesCachePath(str, resourcesCachePathChangeCallback);
    }

    public static void setResourcesCachePath(final String str, final ResourcesCachePathChangeCallback resourcesCachePathChangeCallback) {
        final Context applicationContext = Mappls.getApplicationContext();
        getInstance(applicationContext);
        if (str.equals(getResourcesCachePath(applicationContext))) {
            resourcesCachePathChangeCallback.onSuccess(str);
        } else {
            new FileUtils.CheckFileWritePermissionTask(new FileUtils.OnCheckFileWritePermissionListener() { // from class: com.mappls.sdk.maps.storage.FileSource.1
                @Override // com.mappls.sdk.maps.utils.FileUtils.OnCheckFileWritePermissionListener
                public void onWritePermissionGranted() {
                    SharedPreferences.Editor editorEdit = applicationContext.getSharedPreferences(MapplsConstants.MAPPLS_SHARED_PREFERENCES, 0).edit();
                    editorEdit.putString(FileSource.MAPPLS_SHARED_PREFERENCE_RESOURCES_CACHE_PATH, str);
                    editorEdit.apply();
                    FileSource.internalSetResourcesCachePath(applicationContext, str, resourcesCachePathChangeCallback);
                }

                @Override // com.mappls.sdk.maps.utils.FileUtils.OnCheckFileWritePermissionListener
                public void onError() {
                    String str2 = "Path is not writable: " + str;
                    Logger.e(FileSource.TAG, str2);
                    resourcesCachePathChangeCallback.onError(str2);
                }
            }).execute(new File(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void internalSetResourcesCachePath(Context context, String str, final ResourcesCachePathChangeCallback resourcesCachePathChangeCallback) {
        final FileSource fileSource = getInstance(context);
        final boolean zIsActivated = fileSource.isActivated();
        if (!zIsActivated) {
            fileSource.activate();
        }
        fileSource.setResourceCachePath(str, new ResourcesCachePathChangeCallback() { // from class: com.mappls.sdk.maps.storage.FileSource.2
            @Override // com.mappls.sdk.maps.storage.FileSource.ResourcesCachePathChangeCallback
            public void onSuccess(String str2) {
                if (!zIsActivated) {
                    fileSource.deactivate();
                }
                FileSource.resourcesCachePathLoaderLock.lock();
                String unused = FileSource.resourcesCachePath = str2;
                FileSource.resourcesCachePathLoaderLock.unlock();
                resourcesCachePathChangeCallback.onSuccess(str2);
            }

            @Override // com.mappls.sdk.maps.storage.FileSource.ResourcesCachePathChangeCallback
            public void onError(String str2) {
                if (!zIsActivated) {
                    fileSource.deactivate();
                }
                resourcesCachePathChangeCallback.onError(str2);
            }
        });
    }

    private static boolean isPathWritable(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return new File(str).canWrite();
    }

    private static void lockPathLoaders() {
        internalCachePathLoaderLock.lock();
        resourcesCachePathLoaderLock.lock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unlockPathLoaders() {
        resourcesCachePathLoaderLock.unlock();
        internalCachePathLoaderLock.unlock();
    }

    private FileSource(String str) {
        initialize(Mappls.getAccessToken(), str, Mappls.getTileServerOptions());
    }
}
