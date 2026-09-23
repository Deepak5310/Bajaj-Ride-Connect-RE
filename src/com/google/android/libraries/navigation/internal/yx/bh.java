package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class bh extends b {
    final CharSequence c;
    final s d;
    final boolean e;
    int f = 0;
    int g = Integer.MAX_VALUE;

    protected bh(bj bjVar, CharSequence charSequence) {
        this.d = bjVar.a;
        this.e = bjVar.b;
        this.c = charSequence;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.b
    protected final /* bridge */ /* synthetic */ Object a() {
        int iB;
        int i = this.f;
        while (true) {
            int i2 = this.f;
            if (i2 == -1) {
                this.a = 3;
                return null;
            }
            int iC = c(i2);
            if (iC == -1) {
                iC = this.c.length();
                this.f = -1;
                iB = -1;
            } else {
                iB = b(iC);
                this.f = iB;
            }
            if (iB == i) {
                int i3 = iB + 1;
                this.f = i3;
                if (i3 > this.c.length()) {
                    this.f = -1;
                }
            } else {
                while (i < iC && this.d.b(this.c.charAt(i))) {
                    i++;
                }
                while (iC > i) {
                    int i4 = iC - 1;
                    if (!this.d.b(this.c.charAt(i4))) {
                        break;
                    }
                    iC = i4;
                }
                if (!this.e || i != iC) {
                    int i5 = this.g;
                    if (i5 == 1) {
                        iC = this.c.length();
                        this.f = -1;
                        while (iC > i) {
                            int i6 = iC - 1;
                            if (!this.d.b(this.c.charAt(i6))) {
                                break;
                            }
                            iC = i6;
                        }
                    } else {
                        this.g = i5 - 1;
                    }
                    return this.c.subSequence(i, iC).toString();
                }
                i = this.f;
            }
        }
    }

    public abstract int b(int i);

    public abstract int c(int i);
}
