package io.invertase.firebase.config;

import androidx.core.os.EnvironmentCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.remoteconfig.ConfigUpdate;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeFirebaseConfigModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Config";
    private static HashMap<String, ConfigUpdateListenerRegistration> mConfigUpdateRegistrations = new HashMap<>();
    private final UniversalFirebaseConfigModule module;

    ReactNativeFirebaseConfigModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseConfigModule(reactApplicationContext, SERVICE_NAME);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        Iterator<Map.Entry<String, ConfigUpdateListenerRegistration>> it2 = mConfigUpdateRegistrations.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().remove();
            it2.remove();
        }
    }

    @ReactMethod
    public void activate(String str, final Promise promise) {
        this.module.activate(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$activate$0(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$activate$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void fetch(String str, double d, final Promise promise) {
        this.module.fetch(str, (long) d).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$fetch$1(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetch$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
        } else {
            rejectPromiseWithConfigException(promise, task.getException());
        }
    }

    @ReactMethod
    public void fetchAndActivate(String str, final Promise promise) {
        this.module.fetchAndActivate(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda3
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$fetchAndActivate$2(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$fetchAndActivate$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
        } else {
            rejectPromiseWithConfigException(promise, task.getException());
        }
    }

    @ReactMethod
    public void reset(String str, final Promise promise) {
        this.module.reset(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$reset$3(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$reset$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
        } else {
            rejectPromiseWithConfigException(promise, task.getException());
        }
    }

    @ReactMethod
    public void setConfigSettings(String str, ReadableMap readableMap, final Promise promise) {
        this.module.setConfigSettings(str, Arguments.toBundle(readableMap)).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$setConfigSettings$4(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setConfigSettings$4(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setDefaults(String str, ReadableMap readableMap, final Promise promise) {
        this.module.setDefaults(str, readableMap.toHashMap()).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$setDefaults$5(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaults$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setDefaultsFromResource(String str, String str2, final Promise promise) {
        this.module.setDefaultsFromResource(str, str2).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$setDefaultsFromResource$6(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setDefaultsFromResource$6(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
            return;
        }
        Exception exception = task.getException();
        if (exception != null && exception.getMessage().equals("resource_not_found")) {
            rejectPromiseWithCodeAndMessage(promise, "resource_not_found", "The specified resource name was not found.");
        }
        rejectPromiseWithExceptionMap(promise, task.getException());
    }

    @ReactMethod
    public void ensureInitialized(String str, final Promise promise) {
        this.module.ensureInitialized(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda6
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$ensureInitialized$7(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$ensureInitialized$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(null));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void onConfigUpdated(final String str) {
        if (mConfigUpdateRegistrations.get(str) == null) {
            mConfigUpdateRegistrations.put(str, FirebaseRemoteConfig.getInstance(FirebaseApp.getInstance(str)).addOnConfigUpdateListener(new ConfigUpdateListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule.1
                @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
                public void onUpdate(ConfigUpdate configUpdate) {
                    ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
                    ArrayList arrayList = new ArrayList(configUpdate.getUpdatedKeys());
                    HashMap map = new HashMap();
                    map.put("appName", str);
                    map.put("resultType", FirebaseAnalytics.Param.SUCCESS);
                    map.put("updatedKeys", arrayList);
                    sharedInstance.sendEvent(new ReactNativeFirebaseEvent("on_config_updated", Arguments.makeNativeMap(map), str));
                }

                @Override // com.google.firebase.remoteconfig.ConfigUpdateListener
                public void onError(FirebaseRemoteConfigException firebaseRemoteConfigException) {
                    ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
                    WritableMap writableMapCreateMap = Arguments.createMap();
                    writableMapCreateMap.putString("resultType", "error");
                    writableMapCreateMap.putString("appName", str);
                    int i = AnonymousClass2.$SwitchMap$com$google$firebase$remoteconfig$FirebaseRemoteConfigException$Code[firebaseRemoteConfigException.getCode().ordinal()];
                    if (i == 1) {
                        writableMapCreateMap.putString(AccountsQueryParameters.CODE, "config_update_stream_error");
                    } else if (i == 2) {
                        writableMapCreateMap.putString(AccountsQueryParameters.CODE, "config_update_message_invalid");
                    } else if (i == 3) {
                        writableMapCreateMap.putString(AccountsQueryParameters.CODE, "config_update_not_fetched");
                    } else if (i == 4) {
                        writableMapCreateMap.putString(AccountsQueryParameters.CODE, "config_update_unavailable");
                    } else if (i == 5) {
                        writableMapCreateMap.putString(AccountsQueryParameters.CODE, EnvironmentCompat.MEDIA_UNKNOWN);
                    } else {
                        writableMapCreateMap.putString(AccountsQueryParameters.CODE, "internal");
                    }
                    writableMapCreateMap.putString(StackTraceHelper.MESSAGE_KEY, firebaseRemoteConfigException.getMessage());
                    writableMapCreateMap.putString("nativeErrorMessage", firebaseRemoteConfigException.getMessage());
                    sharedInstance.sendEvent(new ReactNativeFirebaseEvent("on_config_updated", writableMapCreateMap, str));
                }
            }));
        }
    }

    /* JADX INFO: renamed from: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$remoteconfig$FirebaseRemoteConfigException$Code;

        static {
            int[] iArr = new int[FirebaseRemoteConfigException.Code.values().length];
            $SwitchMap$com$google$firebase$remoteconfig$FirebaseRemoteConfigException$Code = iArr;
            try {
                iArr[FirebaseRemoteConfigException.Code.CONFIG_UPDATE_STREAM_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$remoteconfig$FirebaseRemoteConfigException$Code[FirebaseRemoteConfigException.Code.CONFIG_UPDATE_MESSAGE_INVALID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$firebase$remoteconfig$FirebaseRemoteConfigException$Code[FirebaseRemoteConfigException.Code.CONFIG_UPDATE_NOT_FETCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$firebase$remoteconfig$FirebaseRemoteConfigException$Code[FirebaseRemoteConfigException.Code.CONFIG_UPDATE_UNAVAILABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$firebase$remoteconfig$FirebaseRemoteConfigException$Code[FirebaseRemoteConfigException.Code.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    @ReactMethod
    public void removeConfigUpdateRegistration(String str) {
        ConfigUpdateListenerRegistration configUpdateListenerRegistration = mConfigUpdateRegistrations.get(str);
        if (configUpdateListenerRegistration != null) {
            configUpdateListenerRegistration.remove();
            mConfigUpdateRegistrations.remove(str);
        }
    }

    @ReactMethod
    public void setCustomSignals(String str, ReadableMap readableMap, final Promise promise) {
        this.module.setCustomSignals(str, readableMap.toHashMap()).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.config.ReactNativeFirebaseConfigModule$$ExternalSyntheticLambda8
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$setCustomSignals$8(promise, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$setCustomSignals$8(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(resultWithConstants(task.getResult()));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    private WritableMap resultWithConstants(Object obj) {
        HashMap map = new HashMap(2);
        map.put("result", obj);
        map.put("constants", this.module.getConstantsForApp(FirebaseApp.DEFAULT_APP_NAME));
        return Arguments.makeNativeMap(map);
    }

    private void rejectPromiseWithConfigException(Promise promise, @Nullable Exception exc) {
        if (exc == null) {
            rejectPromiseWithCodeAndMessage(promise, EnvironmentCompat.MEDIA_UNKNOWN, "Operation cannot be completed successfully, due to an unknown error.");
        } else if (exc.getCause() instanceof FirebaseRemoteConfigFetchThrottledException) {
            rejectPromiseWithCodeAndMessage(promise, "throttled", "fetch() operation cannot be completed successfully, due to throttling.", exc.getMessage());
        } else {
            rejectPromiseWithCodeAndMessage(promise, "failure", "fetch() operation cannot be completed successfully.", exc.getMessage());
        }
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.module.getConstants();
    }
}
