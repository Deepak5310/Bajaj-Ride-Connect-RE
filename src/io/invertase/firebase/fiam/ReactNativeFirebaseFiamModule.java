package io.invertase.firebase.fiam;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeFirebaseFiamModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "Fiam";
    private final UniversalFirebaseFiamModule module;

    ReactNativeFirebaseFiamModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
        this.module = new UniversalFirebaseFiamModule(reactApplicationContext, SERVICE_NAME);
    }

    @ReactMethod
    public void setAutomaticDataCollectionEnabled(Boolean bool, final Promise promise) {
        this.module.setAutomaticDataCollectionEnabled(bool).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.fiam.ReactNativeFirebaseFiamModule$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFiamModule.lambda$setAutomaticDataCollectionEnabled$0(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setAutomaticDataCollectionEnabled$0(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setMessagesDisplaySuppressed(Boolean bool, final Promise promise) {
        this.module.setMessagesDisplaySuppressed(bool).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.fiam.ReactNativeFirebaseFiamModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFiamModule.lambda$setMessagesDisplaySuppressed$1(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$setMessagesDisplaySuppressed$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void triggerEvent(String str, final Promise promise) {
        this.module.triggerEvent(str).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.fiam.ReactNativeFirebaseFiamModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFiamModule.lambda$triggerEvent$2(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$triggerEvent$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.module.getConstants();
    }
}
