package io.invertase.firebase.firestore;

import android.content.Context;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.LoadBundleTask;
import io.invertase.firebase.common.UniversalFirebaseModule;
import io.invertase.firebase.common.UniversalFirebasePreferences;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public class UniversalFirebaseFirestoreModule extends UniversalFirebaseModule {
    private static HashMap<String, String> emulatorConfigs = new HashMap<>();

    UniversalFirebaseFirestoreModule(Context context, String str) {
        super(context, str);
    }

    Task<Void> disableNetwork(String str, String str2) {
        return UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).disableNetwork();
    }

    Task<Void> enableNetwork(String str, String str2) {
        return UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).enableNetwork();
    }

    Task<Void> useEmulator(final String str, final String str2, final String str3, final int i) {
        return Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.UniversalFirebaseFirestoreModule$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseFirestoreModule.lambda$useEmulator$0(str, str2, str3, i);
            }
        });
    }

    static /* synthetic */ Void lambda$useEmulator$0(String str, String str2, String str3, int i) throws Exception {
        String strCreateFirestoreKey = UniversalFirebaseFirestoreCommon.createFirestoreKey(str, str2);
        if (emulatorConfigs.get(strCreateFirestoreKey) != null) {
            return null;
        }
        emulatorConfigs.put(strCreateFirestoreKey, "true");
        UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).useEmulator(str3, i);
        return null;
    }

    Task<Void> settings(final String str, final Map<String, Object> map) {
        return Tasks.call(getExecutor(), new Callable() { // from class: io.invertase.firebase.firestore.UniversalFirebaseFirestoreModule$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return UniversalFirebaseFirestoreModule.lambda$settings$1(map, str);
            }
        });
    }

    static /* synthetic */ Void lambda$settings$1(Map map, String str) throws Exception {
        if (map.containsKey("cacheSizeBytes")) {
            Double d = (Double) map.get("cacheSizeBytes");
            UniversalFirebasePreferences.getSharedInstance().setIntValue(UniversalFirebaseFirestoreStatics.FIRESTORE_CACHE_SIZE + "_" + str, ((Double) Objects.requireNonNull(d)).intValue());
        }
        if (map.containsKey("host")) {
            UniversalFirebasePreferences.getSharedInstance().setStringValue(UniversalFirebaseFirestoreStatics.FIRESTORE_HOST + "_" + str, (String) map.get("host"));
        }
        if (map.containsKey("persistence")) {
            UniversalFirebasePreferences.getSharedInstance().setBooleanValue(UniversalFirebaseFirestoreStatics.FIRESTORE_PERSISTENCE + "_" + str, ((Boolean) map.get("persistence")).booleanValue());
        }
        if (map.containsKey("ssl")) {
            UniversalFirebasePreferences.getSharedInstance().setBooleanValue(UniversalFirebaseFirestoreStatics.FIRESTORE_SSL + "_" + str, ((Boolean) map.get("ssl")).booleanValue());
        }
        if (!map.containsKey("serverTimestampBehavior")) {
            return null;
        }
        UniversalFirebasePreferences.getSharedInstance().setStringValue(UniversalFirebaseFirestoreStatics.FIRESTORE_SERVER_TIMESTAMP_BEHAVIOR + "_" + str, (String) map.get("serverTimestampBehavior"));
        return null;
    }

    LoadBundleTask loadBundle(String str, String str2, String str3) {
        return UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).loadBundle(str3.getBytes(StandardCharsets.UTF_8));
    }

    Task<Void> clearPersistence(String str, String str2) {
        return UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).clearPersistence();
    }

    Task<Void> waitForPendingWrites(String str, String str2) {
        return UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).waitForPendingWrites();
    }

    Task<Void> terminate(String str, String str2) {
        FirebaseFirestore firestoreForApp = UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2);
        String strCreateFirestoreKey = UniversalFirebaseFirestoreCommon.createFirestoreKey(str, str2);
        if (UniversalFirebaseFirestoreCommon.instanceCache.get(strCreateFirestoreKey) != null) {
            UniversalFirebaseFirestoreCommon.instanceCache.get(strCreateFirestoreKey).clear();
            UniversalFirebaseFirestoreCommon.instanceCache.remove(strCreateFirestoreKey);
        }
        return firestoreForApp.terminate();
    }
}
