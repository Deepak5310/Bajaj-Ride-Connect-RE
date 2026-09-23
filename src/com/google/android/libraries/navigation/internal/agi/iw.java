package com.google.android.libraries.navigation.internal.agi;

import java.util.Objects;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class iw {
    public static hd a(ix ixVar) {
        return ixVar.d();
    }

    public static Object b(ix ixVar, Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Object obj2 = ixVar.get(obj);
        boolean z = obj2 != null || ixVar.containsKey(obj);
        if (true != z) {
            obj2 = null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply != null) {
            ixVar.put(obj, objApply);
            return objApply;
        }
        if (z) {
            ixVar.remove(obj);
        }
        return null;
    }

    public static Object c(ix ixVar, Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Object obj2 = ixVar.get(obj);
        if (obj2 == null && !ixVar.containsKey(obj)) {
            return null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply == null) {
            ixVar.remove(obj);
            return null;
        }
        ixVar.put(obj, objApply);
        return objApply;
    }

    public static Object d(ix ixVar, Object obj, Object obj2, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(obj2);
        Object obj3 = ixVar.get(obj);
        if ((obj3 != null || ixVar.containsKey(obj)) && (obj2 = biFunction.apply(obj3, obj2)) == null) {
            ixVar.remove(obj);
            return null;
        }
        ixVar.put(obj, obj2);
        return obj2;
    }

    public static Object e(ix ixVar, Object obj, Object obj2) {
        Object obj3 = ixVar.get(obj);
        if (obj3 != null || ixVar.containsKey(obj)) {
            return obj3;
        }
        ixVar.put(obj, obj2);
        return null;
    }

    public static Object f(ix ixVar, Object obj, Object obj2) {
        if (ixVar.containsKey(obj)) {
            return ixVar.put(obj, obj2);
        }
        return null;
    }

    public static boolean h(ix ixVar, Object obj, Object obj2) {
        Object obj3 = ixVar.get(obj);
        if (!Objects.equals(obj3, obj2)) {
            return false;
        }
        if (obj3 == null && !ixVar.containsKey(obj)) {
            return false;
        }
        ixVar.remove(obj);
        return true;
    }

    public static boolean i(ix ixVar, Object obj, Object obj2, Object obj3) {
        Object obj4 = ixVar.get(obj);
        if (!Objects.equals(obj4, obj2)) {
            return false;
        }
        if (obj4 == null && !ixVar.containsKey(obj)) {
            return false;
        }
        ixVar.put(obj, obj3);
        return true;
    }
}
