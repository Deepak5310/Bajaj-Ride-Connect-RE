package com.google.android.libraries.navigation.internal.pt;

import com.google.android.libraries.navigation.internal.oe.bd;
import com.google.android.libraries.navigation.internal.oe.i;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final i a = new i(0, 0);
    public final ev b;
    public final String c;
    public final String d;
    public final d e;
    private final int f;
    private final bd g;

    public c(i iVar, ev evVar, String str, String str2, int i, int i2, bd bdVar) {
        this.b = evVar;
        this.c = str;
        this.d = str2;
        this.f = i;
        this.e = new d(iVar, i2);
        this.g = bdVar;
    }

    public final i a() {
        return this.e.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        c cVar = (c) obj;
        return hx.i(this.b, cVar.b) && this.c.equals(cVar.c) && this.d.equals(cVar.d) && this.f == cVar.f && this.e.equals(cVar.e) && am.a(this.g, cVar.g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.d, Integer.valueOf(this.f), this.e, this.g});
    }

    public final String toString() {
        return "[Level: " + this.e.toString() + "]";
    }
}
