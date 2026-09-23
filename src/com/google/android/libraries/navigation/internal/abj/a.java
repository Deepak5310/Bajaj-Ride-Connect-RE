package com.google.android.libraries.navigation.internal.abj;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends f {
    public final c[] a;

    public a(c[] cVarArr) {
        this.a = cVarArr;
        c cVar = cVarArr[0];
        int i = cVar.a;
        int i2 = cVar.b;
        for (int i3 = 1; i3 < 4; i3++) {
            c cVar2 = cVarArr[i3];
            int i4 = cVar2.a;
            int i5 = cVar2.b;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    public final boolean a(c cVar) {
        int i;
        c[] cVarArr = this.a;
        ?? E = c.e(cVarArr[0], cVarArr[1], cVar);
        c[] cVarArr2 = this.a;
        int i2 = E;
        if (c.e(cVarArr2[1], cVarArr2[2], cVar)) {
            i2 = E + 1;
        }
        c[] cVarArr3 = this.a;
        int i3 = i2;
        if (c.e(cVarArr3[2], cVarArr3[3], cVar)) {
            i3 = i2 + 1;
        }
        c[] cVarArr4 = this.a;
        int i4 = i3;
        if (c.e(cVarArr4[3], cVarArr4[0], cVar)) {
            i = i3 + 1;
        }
        if (i4 == 1) {
            i4 = i;
            return true;
        }
        i4 = i;
        return false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            return Arrays.equals(this.a, ((a) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.a);
    }

    public final String toString() {
        c[] cVarArr = this.a;
        return "[" + String.valueOf(cVarArr[0]) + "," + String.valueOf(cVarArr[1]) + "," + String.valueOf(cVarArr[2]) + "," + String.valueOf(cVarArr[3]) + "]";
    }
}
