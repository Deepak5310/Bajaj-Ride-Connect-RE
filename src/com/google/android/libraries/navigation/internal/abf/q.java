package com.google.android.libraries.navigation.internal.abf;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public final Object a;
    public final Object b;

    public q(Object obj, Object obj2) {
        this.a = obj;
        this.b = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return r.a(this.a, qVar.a) && r.a(this.b, qVar.b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        Object obj = this.b;
        return "NullSafePair(" + String.valueOf(this.a) + "," + String.valueOf(obj) + ")";
    }
}
