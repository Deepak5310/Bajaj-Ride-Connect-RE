package com.google.android.libraries.navigation.internal.oe;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements Serializable {
    public final int a;
    public final int b;
    public final int c;

    public q(int i, int i2) {
        this.a = i;
        this.b = i2;
        this.c = 0;
    }

    public q(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    public q(x xVar) {
        this.a = xVar.a;
        this.b = xVar.b;
        this.c = xVar.c;
    }

    public final x a() {
        return new x(this.a, this.b, this.c);
    }

    public final x b() {
        return new x(this.a, this.b, 0);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.a == qVar.a && this.b == qVar.b && this.c == qVar.c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "ImmutablePoint{(" + this.a + "," + this.b + "," + this.c + ")}";
    }
}
