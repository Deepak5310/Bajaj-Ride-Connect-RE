package com.google.android.libraries.navigation.internal.cw;

import com.google.android.libraries.navigation.internal.afl.du;
import com.google.android.libraries.navigation.internal.zr.bb;
import com.google.android.libraries.navigation.internal.zr.be;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public volatile int a;
    public volatile int b;
    public volatile int c;

    public c() {
        this.a = b.a;
        this.b = b.a;
        this.c = b.a;
    }

    public c(c cVar) {
        this.a = cVar.a;
        this.b = cVar.b;
        this.c = cVar.c;
    }

    static int c(int i) {
        if (i == 0) {
            throw null;
        }
        int i2 = i - 1;
        if (i2 == 1) {
            return du.b;
        }
        if (i2 == 2) {
            return du.c;
        }
        if (i2 != 3) {
            return i2 != 4 ? du.a : du.e;
        }
        return du.d;
    }

    public final be a() {
        bb bbVar = (bb) be.a.q();
        int iC = c(this.a);
        if (!bbVar.b.H()) {
            bbVar.v();
        }
        be beVar = (be) bbVar.b;
        int i = iC - 1;
        if (iC == 0) {
            throw null;
        }
        beVar.c = i;
        beVar.b |= 1;
        int iC2 = c(this.b);
        if (!bbVar.b.H()) {
            bbVar.v();
        }
        be beVar2 = (be) bbVar.b;
        int i2 = iC2 - 1;
        if (iC2 == 0) {
            throw null;
        }
        beVar2.d = i2;
        beVar2.b |= 2;
        int iC3 = c(this.c);
        if (!bbVar.b.H()) {
            bbVar.v();
        }
        be beVar3 = (be) bbVar.b;
        int i3 = iC3 - 1;
        if (iC3 == 0) {
            throw null;
        }
        beVar3.e = i3;
        beVar3.b |= 4;
        return (be) bbVar.t();
    }

    public final boolean b() {
        int i = b.c;
        return this.a == i || this.c == i || this.b == i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof c)) {
            c cVar = (c) obj;
            if (this.a == cVar.a && this.b == cVar.b && this.c == cVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b), Integer.valueOf(this.c)});
    }

    public final String toString() {
        return "GmmLocationControllerState[gps = " + ((Object) b.a(this.a)) + ", cell = " + ((Object) b.a(this.b)) + ", wifi = " + ((Object) b.a(this.c)) + "]";
    }
}
