package com.google.android.libraries.navigation.internal.cd;

import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class a implements Serializable {
    private final ev a;
    private final com.google.android.libraries.navigation.internal.bn.a b;

    static {
        new a();
    }

    public a() {
        int i = ev.d;
        this.a = lv.a;
        this.b = com.google.android.libraries.navigation.internal.bn.a.TRANSIT_AUTO;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return am.a(this.a, aVar.a) && am.a(this.b, aVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public a(ev evVar, com.google.android.libraries.navigation.internal.bn.a aVar) {
        this.a = (ev) com.google.android.libraries.navigation.internal.hc.a.c(evVar, new eq());
        this.b = aVar;
    }
}
