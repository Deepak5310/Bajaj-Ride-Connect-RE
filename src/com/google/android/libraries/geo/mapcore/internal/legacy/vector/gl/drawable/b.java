package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.bs;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class b extends a {
    private volatile transient int c;
    private volatile transient boolean d;

    public b(com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, m mVar) {
        super(aiVar, mVar);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.n
    public final int c() {
        int iG;
        int i;
        if (!this.d) {
            synchronized (this) {
                if (!this.d) {
                    bs[] bsVarArrE = e();
                    int length = bsVarArrE.length;
                    if (length == 0) {
                        iG = 1;
                    } else {
                        int[] iArr = new int[length];
                        for (int i2 = 0; i2 < bsVarArrE.length; i2++) {
                            bs bsVar = bsVarArrE[i2];
                            int[] iArr2 = bsVar.e;
                            if (iArr2.length == 0) {
                                i = 1;
                            } else {
                                i = 0;
                                for (int i3 : iArr2) {
                                    i += i3;
                                }
                                if ((bsVar.e.length & 1) == 1) {
                                    i += i;
                                }
                            }
                            iArr[i2] = Math.max(1, i);
                        }
                        iG = iArr[0];
                        for (int i4 = 1; i4 < length; i4++) {
                            int i5 = iArr[i4];
                            iG = (iG * i5) / com.google.android.libraries.navigation.internal.nq.a.g(iG, i5);
                        }
                    }
                    this.c = iG;
                    this.d = true;
                }
            }
        }
        return this.c;
    }
}
