package com.google.android.libraries.navigation.internal.zb;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class p extends com.google.android.libraries.navigation.internal.zd.n {
    public Object[] a = new Object[8];
    public int b = 0;

    public final int a(ac acVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.a[i + i].equals(acVar)) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.n
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.n
    public final ac c(int i) {
        if (i < this.b) {
            return (ac) this.a[i + i];
        }
        throw new IndexOutOfBoundsException();
    }

    @Override // com.google.android.libraries.navigation.internal.zd.n
    public final Object d(ac acVar) {
        int iA = a(acVar);
        if (iA != -1) {
            return acVar.c(this.a[iA + iA + 1]);
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.n
    public final Object e(int i) {
        if (i < this.b) {
            return this.a[i + i + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    final void f(ac acVar, Object obj) {
        int iA;
        if (!acVar.b && (iA = a(acVar)) != -1) {
            com.google.android.libraries.navigation.internal.zj.b.d(obj, "metadata value");
            this.a[iA + iA + 1] = obj;
            return;
        }
        int i = this.b + 1;
        Object[] objArr = this.a;
        int length = objArr.length;
        if (i + i > length) {
            this.a = Arrays.copyOf(objArr, length + length);
        }
        Object[] objArr2 = this.a;
        int i2 = this.b;
        com.google.android.libraries.navigation.internal.zj.b.d(acVar, "metadata key");
        objArr2[i2 + i2] = acVar;
        Object[] objArr3 = this.a;
        int i3 = this.b;
        com.google.android.libraries.navigation.internal.zj.b.d(obj, "metadata value");
        objArr3[i3 + i3 + 1] = obj;
        this.b++;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Metadata{");
        for (int i = 0; i < this.b; i++) {
            sb.append(" '");
            sb.append(c(i));
            sb.append("': ");
            sb.append(e(i));
        }
        sb.append(" }");
        return sb.toString();
    }
}
