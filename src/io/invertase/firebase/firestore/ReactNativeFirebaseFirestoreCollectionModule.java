package io.invertase.firebase.firestore;

import android.util.SparseArray;
import androidx.core.os.EnvironmentCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.AggregateQuerySnapshot;
import com.google.firebase.firestore.AggregateSource;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.MetadataChanges;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.ArrayList;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeFirebaseFirestoreCollectionModule extends ReactNativeFirebaseModule {
    private static final String SERVICE_NAME = "FirestoreCollection";
    private static SparseArray<ListenerRegistration> collectionSnapshotListeners = new SparseArray<>();

    ReactNativeFirebaseFirestoreCollectionModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, SERVICE_NAME);
    }

    @Override // io.invertase.firebase.common.ReactNativeFirebaseModule, com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule, com.facebook.react.turbomodule.core.interfaces.TurboModule
    public void invalidate() {
        super.invalidate();
        int size = collectionSnapshotListeners.size();
        for (int i = 0; i < size; i++) {
            collectionSnapshotListeners.get(collectionSnapshotListeners.keyAt(i)).remove();
        }
        collectionSnapshotListeners.clear();
    }

    @ReactMethod
    public void namedQueryOnSnapshot(final String str, final String str2, String str3, String str4, final ReadableArray readableArray, final ReadableArray readableArray2, final ReadableMap readableMap, final int i, final ReadableMap readableMap2) {
        if (collectionSnapshotListeners.get(i) != null) {
            return;
        }
        UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).getNamedQuery(str3).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$namedQueryOnSnapshot$0(str, str2, i, readableArray, readableArray2, readableMap, readableMap2, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$namedQueryOnSnapshot$0(String str, String str2, int i, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, ReadableMap readableMap2, Task task) {
        if (task.isSuccessful()) {
            Query query = (Query) task.getResult();
            if (query == null) {
                sendOnSnapshotError(str, str2, i, new NullPointerException());
                return;
            } else {
                handleQueryOnSnapshot(new ReactNativeFirebaseFirestoreQuery(str, str2, query, readableArray, readableArray2, readableMap), str, str2, i, readableMap2);
                return;
            }
        }
        sendOnSnapshotError(str, str2, i, task.getException());
    }

    @ReactMethod
    public void collectionOnSnapshot(String str, String str2, String str3, String str4, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, int i, ReadableMap readableMap2) {
        if (collectionSnapshotListeners.get(i) != null) {
            return;
        }
        handleQueryOnSnapshot(new ReactNativeFirebaseFirestoreQuery(str, str2, UniversalFirebaseFirestoreCommon.getQueryForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3, str4), readableArray, readableArray2, readableMap), str, str2, i, readableMap2);
    }

    @ReactMethod
    public void collectionOffSnapshot(String str, String str2, int i) {
        ListenerRegistration listenerRegistration = collectionSnapshotListeners.get(i);
        if (listenerRegistration != null) {
            listenerRegistration.remove();
            collectionSnapshotListeners.remove(i);
            removeEventListeningExecutor(Integer.toString(i));
        }
    }

    @ReactMethod
    public void namedQueryGet(final String str, final String str2, String str3, String str4, final ReadableArray readableArray, final ReadableArray readableArray2, final ReadableMap readableMap, final ReadableMap readableMap2, final Promise promise) {
        UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2).getNamedQuery(str3).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda5
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$namedQueryGet$1(promise, str, str2, readableArray, readableArray2, readableMap, readableMap2, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$namedQueryGet$1(Promise promise, String str, String str2, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, ReadableMap readableMap2, Task task) {
        if (task.isSuccessful()) {
            Query query = (Query) task.getResult();
            if (query == null) {
                ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, new NullPointerException());
                return;
            } else {
                handleQueryGet(new ReactNativeFirebaseFirestoreQuery(str, str2, query, readableArray, readableArray2, readableMap), getSource(readableMap2), promise);
                return;
            }
        }
        ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
    }

    @ReactMethod
    public void collectionCount(String str, String str2, String str3, String str4, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, final Promise promise) {
        new ReactNativeFirebaseFirestoreQuery(str, str2, UniversalFirebaseFirestoreCommon.getQueryForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3, str4), readableArray, readableArray2, readableMap).query.count().get(AggregateSource.SERVER).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda7
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreCollectionModule.lambda$collectionCount$2(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$collectionCount$2(Promise promise, Task task) {
        if (task.isSuccessful()) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putDouble("count", Long.valueOf(((AggregateQuerySnapshot) task.getResult()).getCount()).doubleValue());
            promise.resolve(writableMapCreateMap);
            return;
        }
        ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
    }

    @ReactMethod
    public void aggregateQuery(String str, String str2, String str3, String str4, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, final ReadableArray readableArray3, final Promise promise) {
        ReactNativeFirebaseFirestoreQuery reactNativeFirebaseFirestoreQuery = new ReactNativeFirebaseFirestoreQuery(str, str2, UniversalFirebaseFirestoreCommon.getQueryForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3, str4), readableArray, readableArray2, readableMap);
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            if (i < readableArray3.size()) {
                ReadableMap map = readableArray3.getMap(i);
                String string = map.getString("aggregateType");
                if (string == null) {
                    string = "";
                }
                String string2 = map.getString("field");
                string.hashCode();
                switch (string) {
                    case "average":
                        arrayList.add(AggregateField.average(string2));
                        break;
                    case "sum":
                        arrayList.add(AggregateField.sum(string2));
                        break;
                    case "count":
                        arrayList.add(AggregateField.count());
                        break;
                    default:
                        rejectPromiseWithCodeAndMessage(promise, "firestore/invalid-argument", "Invalid AggregateType: " + string);
                        return;
                }
                i++;
            } else {
                reactNativeFirebaseFirestoreQuery.query.aggregate((AggregateField) arrayList.get(0), (AggregateField[]) arrayList.subList(1, arrayList.size()).toArray(new AggregateField[0])).get(AggregateSource.SERVER).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda1
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        ReactNativeFirebaseFirestoreCollectionModule.lambda$aggregateQuery$3(readableArray3, promise, task);
                    }
                });
                return;
            }
        }
    }

    static /* synthetic */ void lambda$aggregateQuery$3(ReadableArray readableArray, Promise promise, Task task) {
        if (task.isSuccessful()) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            AggregateQuerySnapshot aggregateQuerySnapshot = (AggregateQuerySnapshot) task.getResult();
            for (int i = 0; i < readableArray.size(); i++) {
                ReadableMap map = readableArray.getMap(i);
                String string = map.getString("aggregateType");
                if (string == null) {
                    string = "";
                }
                String string2 = map.getString("field");
                String string3 = map.getString("key");
                if (string3 == null) {
                    rejectPromiseWithCodeAndMessage(promise, "firestore/invalid-argument", "key may not be null");
                    return;
                }
                string.hashCode();
                switch (string) {
                    case "average":
                        Double d = aggregateQuerySnapshot.get(AggregateField.average(string2));
                        if (d == null) {
                            writableMapCreateMap.putNull(string3);
                            break;
                        } else {
                            writableMapCreateMap.putDouble(string3, d.doubleValue());
                            break;
                        }
                        break;
                    case "sum":
                        Number number = (Number) aggregateQuerySnapshot.get(AggregateField.sum(string2));
                        if (number == null) {
                            rejectPromiseWithCodeAndMessage(promise, "firestore/unknown", "sum unexpectedly null");
                            return;
                        } else {
                            writableMapCreateMap.putDouble(string3, number.doubleValue());
                            break;
                        }
                        break;
                    case "count":
                        writableMapCreateMap.putDouble(string3, Long.valueOf(aggregateQuerySnapshot.getCount()).doubleValue());
                        break;
                    default:
                        rejectPromiseWithCodeAndMessage(promise, "firestore/invalid-argument", "Invalid AggregateType: " + string);
                        return;
                }
            }
            promise.resolve(writableMapCreateMap);
            return;
        }
        ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
    }

    @ReactMethod
    public void collectionGet(String str, String str2, String str3, String str4, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap, ReadableMap readableMap2, Promise promise) {
        handleQueryGet(new ReactNativeFirebaseFirestoreQuery(str, str2, UniversalFirebaseFirestoreCommon.getQueryForFirestore(UniversalFirebaseFirestoreCommon.getFirestoreForApp(str, str2), str3, str4), readableArray, readableArray2, readableMap), getSource(readableMap2), promise);
    }

    private void handleQueryOnSnapshot(ReactNativeFirebaseFirestoreQuery reactNativeFirebaseFirestoreQuery, final String str, final String str2, final int i, ReadableMap readableMap) {
        MetadataChanges metadataChanges;
        if (readableMap != null && readableMap.hasKey("includeMetadataChanges") && readableMap.getBoolean("includeMetadataChanges")) {
            metadataChanges = MetadataChanges.INCLUDE;
        } else {
            metadataChanges = MetadataChanges.EXCLUDE;
        }
        final MetadataChanges metadataChanges2 = metadataChanges;
        collectionSnapshotListeners.put(i, reactNativeFirebaseFirestoreQuery.query.addSnapshotListener(metadataChanges, new EventListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda6
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                this.f$0.lambda$handleQueryOnSnapshot$4(i, str, str2, metadataChanges2, (QuerySnapshot) obj, firebaseFirestoreException);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleQueryOnSnapshot$4(int i, String str, String str2, MetadataChanges metadataChanges, QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            ListenerRegistration listenerRegistration = collectionSnapshotListeners.get(i);
            if (listenerRegistration != null) {
                listenerRegistration.remove();
                collectionSnapshotListeners.remove(i);
            }
            sendOnSnapshotError(str, str2, i, firebaseFirestoreException);
            return;
        }
        sendOnSnapshotEvent(str, str2, i, querySnapshot, metadataChanges);
    }

    private void handleQueryGet(ReactNativeFirebaseFirestoreQuery reactNativeFirebaseFirestoreQuery, Source source, final Promise promise) {
        reactNativeFirebaseFirestoreQuery.get(getExecutor(), source).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                ReactNativeFirebaseFirestoreCollectionModule.lambda$handleQueryGet$5(promise, task);
            }
        });
    }

    static /* synthetic */ void lambda$handleQueryGet$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            ReactNativeFirebaseFirestoreCommon.rejectPromiseFirestoreException(promise, task.getException());
        }
    }

    private void sendOnSnapshotEvent(final String str, final String str2, final int i, final QuerySnapshot querySnapshot, final MetadataChanges metadataChanges) {
        Tasks.call(getTransactionalExecutor(Integer.toString(i)), new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda3
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap(str, str2, "onSnapshot", querySnapshot, metadataChanges);
            }
        }).addOnCompleteListener(new OnCompleteListener() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreCollectionModule$$ExternalSyntheticLambda4
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f$0.lambda$sendOnSnapshotEvent$7(str, str2, i, task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$sendOnSnapshotEvent$7(String str, String str2, int i, Task task) {
        if (task.isSuccessful()) {
            WritableMap writableMapCreateMap = Arguments.createMap();
            writableMapCreateMap.putMap("snapshot", (ReadableMap) task.getResult());
            ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_collection_sync_event", writableMapCreateMap, str, str2, i));
            return;
        }
        sendOnSnapshotError(str, str2, i, task.getException());
    }

    private void sendOnSnapshotError(String str, String str2, int i, Exception exc) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        WritableMap writableMapCreateMap2 = Arguments.createMap();
        if (exc instanceof FirebaseFirestoreException) {
            UniversalFirebaseFirestoreException universalFirebaseFirestoreException = new UniversalFirebaseFirestoreException((FirebaseFirestoreException) exc, exc.getCause());
            writableMapCreateMap2.putString(AccountsQueryParameters.CODE, universalFirebaseFirestoreException.getCode());
            writableMapCreateMap2.putString(StackTraceHelper.MESSAGE_KEY, universalFirebaseFirestoreException.getMessage());
        } else {
            writableMapCreateMap2.putString(AccountsQueryParameters.CODE, EnvironmentCompat.MEDIA_UNKNOWN);
            writableMapCreateMap2.putString(StackTraceHelper.MESSAGE_KEY, "An unknown error occurred");
        }
        writableMapCreateMap.putMap("error", writableMapCreateMap2);
        ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(new ReactNativeFirebaseFirestoreEvent("firestore_collection_sync_event", writableMapCreateMap, str, str2, i));
    }

    private Source getSource(ReadableMap readableMap) {
        if (readableMap != null && readableMap.hasKey("source")) {
            String string = readableMap.getString("source");
            if ("server".equals(string)) {
                return Source.SERVER;
            }
            if ("cache".equals(string)) {
                return Source.CACHE;
            }
            return Source.DEFAULT;
        }
        return Source.DEFAULT;
    }
}
