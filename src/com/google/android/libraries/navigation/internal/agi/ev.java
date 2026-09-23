package com.google.android.libraries.navigation.internal.agi;

import java.util.Objects;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ev {
    public static hd a(ey eyVar) {
        return eyVar.d();
    }

    public static Object b(ey eyVar, Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Object obj2 = eyVar.get(obj);
        boolean z = obj2 != null || eyVar.containsKey(obj);
        if (true != z) {
            obj2 = null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply != null) {
            eyVar.put(obj, objApply);
            return objApply;
        }
        if (z) {
            eyVar.remove(obj);
        }
        return null;
    }

    public static Object c(ey eyVar, Object obj, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Object obj2 = eyVar.get(obj);
        if (obj2 == null && !eyVar.containsKey(obj)) {
            return null;
        }
        Object objApply = biFunction.apply(obj, obj2);
        if (objApply == null) {
            eyVar.remove(obj);
            return null;
        }
        eyVar.put(obj, objApply);
        return objApply;
    }

    public static Object d(ey eyVar, Object obj, Object obj2, BiFunction biFunction) {
        Objects.requireNonNull(biFunction);
        Objects.requireNonNull(obj2);
        Object obj3 = eyVar.get(obj);
        if ((obj3 != null || eyVar.containsKey(obj)) && (obj2 = biFunction.apply(obj3, obj2)) == null) {
            eyVar.remove(obj);
            return null;
        }
        eyVar.put(obj, obj2);
        return obj2;
    }

    public static Object e(ey eyVar, Object obj, Object obj2) {
        Object obj3 = eyVar.get(obj);
        if (obj3 != null || eyVar.containsKey(obj)) {
            return obj3;
        }
        eyVar.put(obj, obj2);
        return null;
    }

    public static Object f(ey eyVar, Object obj, Object obj2) {
        if (eyVar.containsKey(obj)) {
            return eyVar.put(obj, obj2);
        }
        return null;
    }

    public static boolean h(ey eyVar, Object obj, Object obj2) {
        Object obj3 = eyVar.get(obj);
        if (!Objects.equals(obj3, obj2)) {
            return false;
        }
        if (obj3 == null && !eyVar.containsKey(obj)) {
            return false;
        }
        eyVar.remove(obj);
        return true;
    }

    public static boolean i(ey eyVar, Object obj, Object obj2, Object obj3) {
        Object obj4 = eyVar.get(obj);
        if (!Objects.equals(obj4, obj2)) {
            return false;
        }
        if (obj4 == null && !eyVar.containsKey(obj)) {
            return false;
        }
        eyVar.put(obj, obj3);
        return true;
    }
}
