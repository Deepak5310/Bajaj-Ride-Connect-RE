package com.google.android.libraries.navigation.internal.pt;

import com.google.android.libraries.navigation.internal.oe.i;
import com.google.android.libraries.navigation.internal.oe.q;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public final i a;
    public final ev b;
    public final boolean c;
    public final int d;
    public final q e;
    public final a f;

    public a(i iVar, ev evVar, int i, boolean z, q qVar, a aVar) {
        this.a = iVar;
        this.b = evVar;
        this.d = i;
        this.c = z;
        this.e = qVar;
        this.f = aVar;
    }

    public final c a() {
        return b(this.d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final c b(int i) {
        if (i < 0) {
            return null;
        }
        ev evVar = this.b;
        if (i >= ((lv) evVar).c) {
            return null;
        }
        return (c) evVar.get(i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        a aVar = (a) obj;
        return am.a(this.e, aVar.e) && am.a(this.b, aVar.b) && am.a(this.a, aVar.a) && this.d == aVar.d && this.c == aVar.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.e, this.b, Integer.valueOf(this.d), this.a, Boolean.valueOf(this.c)});
    }

    public final String toString() {
        return "[Building: " + this.a.f() + "]";
    }
}
