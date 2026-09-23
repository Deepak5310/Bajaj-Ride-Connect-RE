package com.google.android.libraries.navigation.internal.zk;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Serializable {
    byte a;
    byte b;
    byte c;
    public d d;
    double e;
    double f;
    double g;
    double h;

    c() {
    }

    public c(d dVar) {
        this.d = dVar;
        this.a = (byte) dVar.a();
        long jG = dVar.g();
        this.c = (byte) (3 & jG);
        this.b = (byte) dVar.d();
        int iB = d.b(jG);
        int iC = d.c(jG);
        int iD = 1 << (30 - dVar.d());
        this.e = u.a(iB, iD);
        this.f = u.a(iB + iD, iD);
        this.g = u.a(iC, iD);
        this.h = u.a(iC + iD, iD);
    }

    public final f a(int i) {
        int i2 = i >> 1;
        return f.b(u.f(this.a, ((i & 1) ^ i2) == 0 ? this.e : this.f, i2 == 0 ? this.g : this.h));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.a == cVar.a && this.b == cVar.b && this.c == cVar.c && this.d.equals(cVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.a + 629) * 37) + this.c) * 37) + this.b) * 37) + this.d.hashCode();
    }

    public final String toString() {
        byte b = this.a;
        byte b2 = this.b;
        byte b3 = this.c;
        return "[" + ((int) b) + ", " + ((int) b2) + ", " + ((int) b3) + ", " + String.valueOf(this.d) + "]";
    }
}
