package com.google.android.libraries.navigation.internal.aga;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ek {
    public final String a;
    public final Map b;

    public ek(String str, Map map) {
        com.google.android.libraries.navigation.internal.yx.ar.r(str, "policyName");
        this.a = str;
        com.google.android.libraries.navigation.internal.yx.ar.r(map, "rawConfigValue");
        this.b = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ek) {
            ek ekVar = (ek) obj;
            if (this.a.equals(ekVar.a) && this.b.equals(ekVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("policyName", this.a);
        akVarB.g("rawConfigValue", this.b);
        return akVarB.toString();
    }
}
