package com.google.android.libraries.navigation.internal.afx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av {
    public final List a;
    public final c b;
    public final Object c;

    public av(List list, c cVar, Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.r(list, "addresses");
        this.a = Collections.unmodifiableList(new ArrayList(list));
        com.google.android.libraries.navigation.internal.yx.ar.r(cVar, "attributes");
        this.b = cVar;
        this.c = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof av)) {
            return false;
        }
        av avVar = (av) obj;
        return com.google.android.libraries.navigation.internal.yx.am.a(this.a, avVar.a) && com.google.android.libraries.navigation.internal.yx.am.a(this.b, avVar.b) && com.google.android.libraries.navigation.internal.yx.am.a(this.c, avVar.c);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("addresses", this.a);
        akVarB.g("attributes", this.b);
        akVarB.g("loadBalancingPolicyConfig", this.c);
        return akVarB.toString();
    }
}
