package com.google.android.libraries.navigation.internal.yr;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad {
    public final int[] a;
    public final ab b;
    public ab c;
    public int d;
    public int e;
    public int f;

    public ad(int[] iArr) {
        this.a = iArr;
        ab abVar = new ab(-1, -1);
        this.b = abVar;
        this.c = abVar;
    }

    private final void d(ab abVar, StringBuilder sb) {
        for (ab abVar2 : abVar.d.values()) {
            sb.append("  ");
            sb.append(abVar);
            sb.append(" -> ");
            sb.append(abVar2);
            sb.append(" [label=\"");
            int[] iArr = this.a;
            sb.append(Arrays.toString(Arrays.copyOfRange(iArr, abVar2.a, Math.min(iArr.length, abVar2.b + 1))));
            sb.append("\"]\n");
            d(abVar2, sb);
        }
    }

    final void a() {
        ab abVar = this.c.c;
        if (abVar != null) {
            this.c = abVar;
        } else {
            this.c = this.b;
            int i = this.e;
            if (i > 0) {
                this.e = i - 1;
            }
            if (this.f > 0) {
                this.d++;
            }
        }
        b();
    }

    final void b() {
        if (this.e == 0) {
            return;
        }
        ab abVar = (ab) this.c.d.get(Integer.valueOf(this.a[this.d]));
        while (true) {
            int i = (abVar.b - abVar.a) + 1;
            int i2 = this.e;
            if (i > i2) {
                return;
            }
            int i3 = this.d + i;
            this.d = i3;
            this.c = abVar;
            int i4 = i2 - i;
            this.e = i4;
            if (i4 > 0) {
                abVar = (ab) abVar.d.get(Integer.valueOf(this.a[i3]));
            }
        }
    }

    public final boolean c(int i, int i2, int i3, int i4) {
        if (i >= 0 && i3 >= 0) {
            int length = this.a.length;
            int iMin = Math.min(length, i2);
            if (iMin - i == Math.min(length, i4) - i3) {
                for (int i5 = i; i5 <= iMin; i5++) {
                    int[] iArr = this.a;
                    if (iArr[i5] != iArr[(i3 + i5) - i]) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("digraph {\n");
        d(this.b, sb);
        sb.append("}");
        return sb.toString();
    }
}
