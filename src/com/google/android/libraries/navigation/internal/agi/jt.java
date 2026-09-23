package com.google.android.libraries.navigation.internal.agi;

import java.util.Objects;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class jt {
    public static hd a(ju juVar) {
        return juVar.d();
    }

    public static Object b(ju juVar, Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Object obj2 = juVar.get(obj);
        boolean z = obj2 != null || juVar.containsKey(obj);
        if (true != z) {
            obj2 = null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply != null) {
            juVar.put(obj, objApply);
            return objApply;
        }
        if (z) {
            juVar.remove(obj);
        }
        return null;
    }

    public static Object c(ju juVar, Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Object obj2 = juVar.get(obj);
        if (obj2 == null && !juVar.containsKey(obj)) {
            return null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply == null) {
            juVar.remove(obj);
            return null;
        }
        juVar.put(obj, objApply);
        return objApply;
    }

    public static Object d(ju juVar, Object obj, Object obj2, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(obj2);
        Object obj3 = juVar.get(obj);
        if ((obj3 != null || juVar.containsKey(obj)) && (obj2 = biFunction.apply(obj3, obj2)) == null) {
            juVar.remove(obj);
            return null;
        }
        juVar.put(obj, obj2);
        return obj2;
    }

    public static Object e(ju juVar, Object obj, Object obj2) {
        Object obj3 = juVar.get(obj);
        if (obj3 != null || juVar.containsKey(obj)) {
            return obj3;
        }
        juVar.put(obj, obj2);
        return null;
    }

    public static Object f(ju juVar, Object obj, Object obj2) {
        if (juVar.containsKey(obj)) {
            return juVar.put(obj, obj2);
        }
        return null;
    }

    public static boolean h(ju juVar, Object obj, Object obj2) {
        Object obj3 = juVar.get(obj);
        if (obj3 != obj2) {
            return false;
        }
        if (obj3 == null && !juVar.containsKey(obj)) {
            return false;
        }
        juVar.remove(obj);
        return true;
    }

    public static boolean i(ju juVar, Object obj, Object obj2, Object obj3) {
        Object obj4 = juVar.get(obj);
        if (obj4 != obj2) {
            return false;
        }
        if (obj4 == null && !juVar.containsKey(obj)) {
            return false;
        }
        juVar.put(obj, obj3);
        return true;
    }
}
