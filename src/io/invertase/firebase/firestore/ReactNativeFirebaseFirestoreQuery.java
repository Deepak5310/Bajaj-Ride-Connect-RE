package io.invertase.firebase.firestore;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.Filter;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.Source;
import com.mappls.sdk.services.account.Region;
import io.invertase.firebase.common.RCTConvertFirebase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes4.dex */
public class ReactNativeFirebaseFirestoreQuery {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    String appName;
    String databaseId;
    Query query;

    ReactNativeFirebaseFirestoreQuery(String str, String str2, Query query, ReadableArray readableArray, ReadableArray readableArray2, ReadableMap readableMap) {
        this.appName = str;
        this.query = query;
        applyFilters(readableArray);
        applyOrders(readableArray2);
        applyOptions(readableMap);
    }

    public Task<WritableMap> get(Executor executor, final Source source) {
        return Tasks.call(executor, new Callable() { // from class: io.invertase.firebase.firestore.ReactNativeFirebaseFirestoreQuery$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f$0.lambda$get$0(source);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ WritableMap lambda$get$0(Source source) throws Exception {
        return ReactNativeFirebaseFirestoreSerialize.snapshotToWritableMap(this.appName, this.databaseId, "get", (QuerySnapshot) Tasks.await(this.query.get(source)), null);
    }

    private void applyFilters(ReadableArray readableArray) {
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            if (map.hasKey("fieldPath")) {
                FieldPath fieldPathOf = FieldPath.of((String[]) Objects.requireNonNull((String[]) ((ReadableArray) Objects.requireNonNull(((ReadableMap) Objects.requireNonNull(map)).getArray("fieldPath"))).toArrayList().toArray(new String[0])));
                String string = map.getString("operator");
                Object typeMap = ReactNativeFirebaseFirestoreSerialize.parseTypeMap(this.query.getFirestore(), (ReadableArray) Objects.requireNonNull(map.getArray("value")));
                String str = (String) Objects.requireNonNull(string);
                str.hashCode();
                switch (str) {
                    case "LESS_THAN_OR_EQUAL":
                        this.query = this.query.whereLessThanOrEqualTo((FieldPath) Objects.requireNonNull(fieldPathOf), Objects.requireNonNull(typeMap));
                        break;
                    case "NOT_IN":
                        this.query = this.query.whereNotIn((FieldPath) Objects.requireNonNull(fieldPathOf), (List<? extends Object>) Objects.requireNonNull((List) typeMap));
                        break;
                    case "LESS_THAN":
                        this.query = this.query.whereLessThan((FieldPath) Objects.requireNonNull(fieldPathOf), Objects.requireNonNull(typeMap));
                        break;
                    case "ARRAY_CONTAINS_ANY":
                        this.query = this.query.whereArrayContainsAny((FieldPath) Objects.requireNonNull(fieldPathOf), (List<? extends Object>) Objects.requireNonNull((List) typeMap));
                        break;
                    case "IN":
                        this.query = this.query.whereIn((FieldPath) Objects.requireNonNull(fieldPathOf), (List<? extends Object>) Objects.requireNonNull((List) typeMap));
                        break;
                    case "EQUAL":
                        this.query = this.query.whereEqualTo((FieldPath) Objects.requireNonNull(fieldPathOf), typeMap);
                        break;
                    case "ARRAY_CONTAINS":
                        this.query = this.query.whereArrayContains((FieldPath) Objects.requireNonNull(fieldPathOf), Objects.requireNonNull(typeMap));
                        break;
                    case "GREATER_THAN":
                        this.query = this.query.whereGreaterThan((FieldPath) Objects.requireNonNull(fieldPathOf), Objects.requireNonNull(typeMap));
                        break;
                    case "GREATER_THAN_OR_EQUAL":
                        this.query = this.query.whereGreaterThanOrEqualTo((FieldPath) Objects.requireNonNull(fieldPathOf), Objects.requireNonNull(typeMap));
                        break;
                    case "NOT_EQUAL":
                        this.query = this.query.whereNotEqualTo((FieldPath) Objects.requireNonNull(fieldPathOf), typeMap);
                        break;
                }
            } else if (map.hasKey("operator") && map.hasKey("queries")) {
                this.query = this.query.where(applyFilterQueries(map));
            }
        }
    }

    private Filter applyFilterQueries(ReadableMap readableMap) {
        if (readableMap.hasKey("fieldPath")) {
            String str = (String) Objects.requireNonNull(((ReadableMap) Objects.requireNonNull(readableMap)).getString("operator"));
            ReadableArray readableArray = (ReadableArray) Objects.requireNonNull(((ReadableMap) Objects.requireNonNull(readableMap.getMap("fieldPath"))).getArray("_segments"));
            int size = readableArray.size();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                strArr[i] = readableArray.getString(i);
            }
            FieldPath fieldPathOf = FieldPath.of(strArr);
            Object typeMap = ReactNativeFirebaseFirestoreSerialize.parseTypeMap(this.query.getFirestore(), (ReadableArray) Objects.requireNonNull(readableMap.getArray("value")));
            str.hashCode();
            switch (str) {
                case "LESS_THAN_OR_EQUAL":
                    return Filter.lessThanOrEqualTo(fieldPathOf, typeMap);
                case "NOT_IN":
                    return Filter.notInArray(fieldPathOf, (List<? extends Object>) typeMap);
                case "LESS_THAN":
                    return Filter.lessThan(fieldPathOf, typeMap);
                case "ARRAY_CONTAINS_ANY":
                    return Filter.arrayContainsAny(fieldPathOf, (List<? extends Object>) typeMap);
                case "IN":
                    return Filter.inArray(fieldPathOf, (List<? extends Object>) typeMap);
                case "EQUAL":
                    return Filter.equalTo(fieldPathOf, typeMap);
                case "ARRAY_CONTAINS":
                    return Filter.arrayContains(fieldPathOf, typeMap);
                case "GREATER_THAN":
                    return Filter.greaterThan(fieldPathOf, typeMap);
                case "GREATER_THAN_OR_EQUAL":
                    return Filter.greaterThanOrEqualTo(fieldPathOf, typeMap);
                case "NOT_EQUAL":
                    return Filter.notEqualTo(fieldPathOf, typeMap);
                default:
                    throw new Error("Invalid operator");
            }
        }
        String string = ((ReadableMap) Objects.requireNonNull(readableMap)).getString("operator");
        ReadableArray readableArray2 = (ReadableArray) Objects.requireNonNull(((ReadableMap) Objects.requireNonNull(readableMap)).getArray("queries"));
        ArrayList arrayList = new ArrayList();
        int size2 = readableArray2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            arrayList.add(applyFilterQueries(readableArray2.getMap(i2)));
        }
        if (string.equals(Region.REGION_ANDORRA)) {
            return Filter.and((Filter[]) arrayList.toArray(new Filter[0]));
        }
        if (string.equals("OR")) {
            return Filter.or((Filter[]) arrayList.toArray(new Filter[0]));
        }
        throw new Error("Missing 'Filter' instance return");
    }

    private void applyOrders(ReadableArray readableArray) {
        Iterator<Object> it2 = RCTConvertFirebase.toArrayList(readableArray).iterator();
        while (it2.hasNext()) {
            Map map = (Map) it2.next();
            if (map.get("fieldPath") instanceof List) {
                this.query = this.query.orderBy((FieldPath) Objects.requireNonNull(FieldPath.of((String[]) ((ArrayList) map.get("fieldPath")).toArray(new String[0]))), Query.Direction.valueOf((String) map.get("direction")));
            } else {
                this.query = this.query.orderBy((String) Objects.requireNonNull((String) map.get("fieldPath")), Query.Direction.valueOf((String) map.get("direction")));
            }
        }
    }

    private void applyOptions(ReadableMap readableMap) {
        if (readableMap.hasKey("limit")) {
            this.query = this.query.limit(readableMap.getInt("limit"));
        }
        if (readableMap.hasKey("limitToLast")) {
            this.query = this.query.limitToLast(readableMap.getInt("limitToLast"));
        }
        if (readableMap.hasKey("startAt")) {
            this.query = this.query.startAt((Object[]) Objects.requireNonNull(ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("startAt")).toArray()));
        }
        if (readableMap.hasKey("startAfter")) {
            this.query = this.query.startAfter((Object[]) Objects.requireNonNull(ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("startAfter")).toArray()));
        }
        if (readableMap.hasKey("endAt")) {
            this.query = this.query.endAt((Object[]) Objects.requireNonNull(ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("endAt")).toArray()));
        }
        if (readableMap.hasKey("endBefore")) {
            this.query = this.query.endBefore((Object[]) Objects.requireNonNull(ReactNativeFirebaseFirestoreSerialize.parseReadableArray(this.query.getFirestore(), readableMap.getArray("endBefore")).toArray()));
        }
    }
}
