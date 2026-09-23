package com.google.android.libraries.navigation.internal.mx;

import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.lp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class i implements m {
    public m[] c;
    public int d;

    public i(m... mVarArr) {
        int i = 0;
        while (true) {
            int length = mVarArr.length;
            if (i >= length) {
                this.c = mVarArr;
                this.d = length;
                return;
            } else {
                if (mVarArr[i] == null) {
                    throw new NullPointerException(com.google.android.libraries.navigation.internal.b.b.j(i, "Child node at index ", " was null"));
                }
                i++;
            }
        }
    }

    private final void a(int i) {
        int i2 = this.d + i;
        m[] mVarArr = this.c;
        int length = mVarArr.length;
        if (i2 > length) {
            m[] mVarArr2 = (m[]) lp.a(mVarArr, length + i + 5);
            System.arraycopy(this.c, 0, mVarArr2, 0, this.d);
            this.c = mVarArr2;
        }
    }

    public static cc g(m[] mVarArr, int i) {
        while (true) {
            i--;
            if (i < 0) {
                return null;
            }
            m mVar = mVarArr[i];
            if (mVar instanceof aa) {
                return ((aa) mVar).a;
            }
            if (mVar instanceof k) {
                m[] mVarArr2 = ((k) mVar).a;
                cc ccVarG = g(mVarArr2, mVarArr2.length);
                if (ccVarG != null) {
                    return ccVarG;
                }
            }
        }
    }

    public final void h(m... mVarArr) {
        int i = 0;
        while (true) {
            int length = mVarArr.length;
            if (i >= length) {
                a(length);
                System.arraycopy(mVarArr, 0, this.c, this.d, length);
                this.d += length;
                return;
            }
            ar.r(mVarArr[i], com.google.android.libraries.navigation.internal.b.b.j(i, "Property at index ", " was null"));
            i++;
        }
    }

    public final void i(m mVar) {
        if (mVar != m.e) {
            a(1);
            m[] mVarArr = this.c;
            int i = this.d;
            this.d = i + 1;
            mVarArr[i] = mVar;
        }
    }
}
