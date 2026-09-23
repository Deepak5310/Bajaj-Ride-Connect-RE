package io.invertase.firebase.fiam;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.inappmessaging.FirebaseInAppMessaging;
import io.invertase.firebase.common.UniversalFirebaseModule;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public class UniversalFirebaseFiamModule extends UniversalFirebaseModule {
    UniversalFirebaseFiamModule(Context context, String str) {
        super(context, str);
    }

    Task<Void> setAutomaticDataCollectionEnabled(final Boolean bool) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.fiam.UniversalFirebaseFiamModule$$ExternalSyntheticLambda2
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseFiamModule.lambda$setAutomaticDataCollectionEnabled$0(bool);
            }
        });
    }

    static /* synthetic */ Void lambda$setAutomaticDataCollectionEnabled$0(Boolean bool) throws Exception {
        FirebaseInAppMessaging.getInstance().setAutomaticDataCollectionEnabled(bool);
        return null;
    }

    Task<Void> setMessagesDisplaySuppressed(final Boolean bool) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.fiam.UniversalFirebaseFiamModule$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseFiamModule.lambda$setMessagesDisplaySuppressed$1(bool);
            }
        });
    }

    static /* synthetic */ Void lambda$setMessagesDisplaySuppressed$1(Boolean bool) throws Exception {
        FirebaseInAppMessaging.getInstance().setMessagesSuppressed(bool);
        return null;
    }

    Task<Void> triggerEvent(final String str) {
        return Tasks.call(new Callable() { // from class: io.invertase.firebase.fiam.UniversalFirebaseFiamModule$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseFiamModule.lambda$triggerEvent$2(str);
            }
        });
    }

    static /* synthetic */ Void lambda$triggerEvent$2(String str) throws Exception {
        FirebaseInAppMessaging.getInstance().triggerEvent(str);
        return null;
    }

    @Override // io.invertase.firebase.common.UniversalFirebaseModule
    public Map<String, Object> getConstants() {
        HashMap map = new HashMap();
        map.put("isMessagesDisplaySuppressed", Boolean.valueOf(FirebaseInAppMessaging.getInstance().areMessagesSuppressed()));
        map.put("isAutomaticDataCollectionEnabled", Boolean.valueOf(FirebaseInAppMessaging.getInstance().isAutomaticDataCollectionEnabled()));
        return map;
    }
}
