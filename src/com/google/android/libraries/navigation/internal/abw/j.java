package com.google.android.libraries.navigation.internal.abw;

import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;
import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public final HashMap a = new HashMap();

    public final Object a(int i, int i2, int i3) {
        HashMap map;
        HashMap map2 = (HashMap) this.a.get(Integer.valueOf(i));
        if (map2 == null || (map = (HashMap) map2.get(Integer.valueOf(i2))) == null) {
            return null;
        }
        return map.get(Integer.valueOf(i3));
    }

    public final void b(int i, int i2, int i3, Object obj) {
        Integer numValueOf = Integer.valueOf(i);
        Integer numValueOf2 = Integer.valueOf(i2);
        Integer numValueOf3 = Integer.valueOf(i3);
        s.b(obj != null, "value for [%s,%s,%s] cannot be <null>", numValueOf, numValueOf2, numValueOf3);
        HashMap map = (HashMap) this.a.get(numValueOf);
        if (map == null) {
            map = new HashMap();
            this.a.put(numValueOf, map);
        }
        HashMap map2 = (HashMap) map.get(numValueOf2);
        if (map2 == null) {
            map2 = new HashMap();
            map.put(numValueOf2, map2);
        }
        map2.put(numValueOf3, obj);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            return r.a(this.a, ((j) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        return this.a.toString();
    }
}
