package com.google.android.libraries.navigation.internal.aga;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dc {
    public final ed a;
    public final Object b;
    public final Map c;
    private final da d;
    private final Map e;
    private final Map f;

    public dc(da daVar, Map map, Map map2, ed edVar, Object obj, Map map3) {
        this.d = daVar;
        this.e = Collections.unmodifiableMap(new HashMap(map));
        this.f = Collections.unmodifiableMap(new HashMap(map2));
        this.a = edVar;
        this.b = obj;
        this.c = map3 != null ? Collections.unmodifiableMap(new HashMap(map3)) : null;
    }

    final com.google.android.libraries.navigation.internal.afx.ah a() {
        if (this.f.isEmpty() && this.e.isEmpty() && this.d == null) {
            return null;
        }
        return new db();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            dc dcVar = (dc) obj;
            if (com.google.android.libraries.navigation.internal.yx.am.a(this.d, dcVar.d) && com.google.android.libraries.navigation.internal.yx.am.a(this.e, dcVar.e) && com.google.android.libraries.navigation.internal.yx.am.a(this.f, dcVar.f) && com.google.android.libraries.navigation.internal.yx.am.a(this.a, dcVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, dcVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.d, this.e, this.f, this.a, this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("defaultMethodConfig", this.d);
        akVarB.g("serviceMethodMap", this.e);
        akVarB.g("serviceMap", this.f);
        akVarB.g("retryThrottling", this.a);
        akVarB.g("loadBalancingConfig", this.b);
        return akVarB.toString();
    }
}
