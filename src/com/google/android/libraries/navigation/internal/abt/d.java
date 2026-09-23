package com.google.android.libraries.navigation.internal.abt;

import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d implements Comparable {
    public final String a;
    public final int b;
    public final int c;
    public final int d;

    public d(String str, int i, int i2, int i3) {
        s.k(str, "panoId");
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
    }

    public final boolean a() {
        return this.b == 0 && this.c == 0 && this.d == 0;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        d dVar = (d) obj;
        int iCompareTo = this.a.compareTo(dVar.a);
        int i = this.d - dVar.d;
        int i2 = this.b - dVar.b;
        int i3 = this.c - dVar.c;
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        if (i != 0) {
            return i;
        }
        return i2 != 0 ? i2 : i3;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return r.a(this.a, dVar.a) && this.b == dVar.b && this.c == dVar.c && this.d == dVar.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    public String toString() {
        return String.format("TileKey[%s@x%s,y%s,z%s]", this.a, Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d));
    }
}
