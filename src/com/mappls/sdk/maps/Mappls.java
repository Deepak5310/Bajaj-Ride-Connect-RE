package com.mappls.sdk.maps;

import android.content.Context;
import android.content.res.AssetManager;
import com.mappls.sdk.maps.exceptions.MapplsConfigurationException;
import com.mappls.sdk.maps.module.http.HttpRequestImpl;
import com.mappls.sdk.maps.net.ConnectivityReceiver;
import com.mappls.sdk.maps.offline.OfflineManager;
import com.mappls.sdk.maps.session.AuthenticationError;
import com.mappls.sdk.maps.session.IStopSession;
import com.mappls.sdk.maps.session.InitializationListener;
import com.mappls.sdk.maps.session.SessionHelper;
import com.mappls.sdk.maps.storage.FileSource;
import com.mappls.sdk.maps.util.TileServerOptions;
import com.mappls.sdk.maps.utils.ThreadUtils;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.utils.MapplsUtils;

/* JADX INFO: loaded from: classes4.dex */
public final class Mappls {
    private static Mappls INSTANCE = null;
    private static final String TAG = "Mbgl-Mappls";
    private static ModuleProvider moduleProvider;
    private String accessToken;
    private Context context;
    private SessionHelper sessionHelper;
    private MapplsStylesHelper stylesHelper;
    private TileServerOptions tileServerOptions;

    static boolean isAccessTokenValid(String str) {
        return str != null;
    }

    public static synchronized Mappls getInstance(Context context) {
        ThreadUtils.init(context);
        ThreadUtils.checkThread(TAG);
        if (INSTANCE == null) {
            Context applicationContext = context.getApplicationContext();
            FileSource.initializeFileDirsPaths(applicationContext);
            INSTANCE = new Mappls(applicationContext, MapplsAccountManager.getInstance().getMapSDKKey());
            ConnectivityReceiver.instance(applicationContext);
            MapplsAccountManager.getInstance().init(context);
        }
        TileServerOptions tileServerOptions = TileServerOptions.get(WellKnownTileServer.MAPPLS);
        Mappls mappls = INSTANCE;
        mappls.tileServerOptions = tileServerOptions;
        mappls.accessToken = null;
        FileSource fileSource = FileSource.getInstance(context);
        fileSource.setTileServerOptions(tileServerOptions);
        fileSource.setApiKey(null);
        return INSTANCE;
    }

    Mappls(Context context, String str) {
        this.context = context;
        this.accessToken = str;
        MapplsAccountManager.getInstance().init(context);
        MapplsUtils.setText(BuildConfig.MAPPLS_SDK_VERSION);
        this.sessionHelper = new SessionHelper(context);
        this.stylesHelper = new MapplsStylesHelper(context);
    }

    public static TileServerOptions getTileServerOptions() {
        validateMappls();
        return INSTANCE.tileServerOptions;
    }

    public static void setProxy(String str, int i) {
        HttpRequestImpl.setProxy(str, i);
    }

    public static void initialize(final InitializationListener initializationListener) {
        getSessionHelper().startGlobalSession(new InitializationListener() { // from class: com.mappls.sdk.maps.Mappls.1
            @Override // com.mappls.sdk.maps.session.InitializationListener
            public void onSuccess() {
                InitializationListener initializationListener2 = initializationListener;
                if (initializationListener2 != null) {
                    initializationListener2.onSuccess();
                }
            }

            @Override // com.mappls.sdk.maps.session.InitializationListener
            public void onFailure(AuthenticationError authenticationError, Exception exc) {
                if (authenticationError.errorCode == 409) {
                    Mappls.getSessionHelper().deleteNavigationSession(new IStopSession() { // from class: com.mappls.sdk.maps.Mappls.1.1
                        @Override // com.mappls.sdk.maps.session.IStopSession
                        public void onSuccess() {
                            Mappls.initialize(initializationListener);
                        }

                        @Override // com.mappls.sdk.maps.session.IStopSession
                        public void onFailure() {
                            if (initializationListener != null) {
                                initializationListener.onFailure(new AuthenticationError(5, "Something went wrong"), null);
                            }
                        }
                    });
                    return;
                }
                InitializationListener initializationListener2 = initializationListener;
                if (initializationListener2 != null) {
                    initializationListener2.onFailure(authenticationError, exc);
                }
            }
        });
    }

    public static SessionHelper getSessionHelper() {
        return INSTANCE.sessionHelper;
    }

    public static MapplsStylesHelper getStyleHelper() {
        return INSTANCE.stylesHelper;
    }

    public static String getAccessToken() {
        validateMappls();
        return INSTANCE.accessToken;
    }

    public static void setAccessToken(String str) {
        validateMappls();
        throwIfAccessTokenInvalid(str);
        INSTANCE.accessToken = str;
        FileSource.getInstance(getApplicationContext()).setApiKey(str);
    }

    public static Context getApplicationContext() {
        validateMappls();
        return INSTANCE.context;
    }

    public static synchronized void setConnected(Boolean bool) {
        validateMappls();
        ConnectivityReceiver.instance(INSTANCE.context).setConnected(bool);
    }

    public static synchronized Boolean isConnected() {
        validateMappls();
        return Boolean.valueOf(ConnectivityReceiver.instance(INSTANCE.context).isConnected());
    }

    public static ModuleProvider getModuleProvider() {
        if (moduleProvider == null) {
            moduleProvider = new ModuleProviderImpl();
        }
        return moduleProvider;
    }

    private static void validateMappls() {
        if (INSTANCE == null) {
            throw new MapplsConfigurationException();
        }
    }

    public static void throwIfAccessTokenInvalid(String str) {
        if (isAccessTokenValid(str)) {
            return;
        }
        throw new MapplsConfigurationException("A valid maps sdk key parameter is required when using a Mappls service.Currently provided key is: " + str);
    }

    public static boolean hasInstance() {
        return INSTANCE != null;
    }

    private static AssetManager getAssetManager() {
        return getApplicationContext().getResources().getAssets();
    }

    public static void clearMapCache(final ClearMapCacheCallback clearMapCacheCallback) {
        OfflineManager.getInstance(INSTANCE.context).clearAmbientCache(new OfflineManager.FileSourceCallback() { // from class: com.mappls.sdk.maps.Mappls.2
            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onSuccess() {
                ClearMapCacheCallback clearMapCacheCallback2 = clearMapCacheCallback;
                if (clearMapCacheCallback2 != null) {
                    clearMapCacheCallback2.onSuccess();
                }
            }

            @Override // com.mappls.sdk.maps.offline.OfflineManager.FileSourceCallback
            public void onError(String str) {
                ClearMapCacheCallback clearMapCacheCallback2 = clearMapCacheCallback;
                if (clearMapCacheCallback2 != null) {
                    clearMapCacheCallback2.onError(str);
                }
            }
        });
    }
}
