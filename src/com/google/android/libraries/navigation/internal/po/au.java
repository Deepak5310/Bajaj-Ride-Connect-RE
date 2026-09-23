package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au implements gv {
    int a = Integer.MAX_VALUE;
    int b = Integer.MAX_VALUE;
    int c = Integer.MIN_VALUE;
    int d = 0;
    final /* synthetic */ ay e;

    protected au(ay ayVar) {
        this.e = ayVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final float a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final com.google.android.libraries.navigation.internal.oe.x b() {
        return new com.google.android.libraries.navigation.internal.oe.x(this.a, this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final com.google.android.libraries.geo.mapcore.renderer.ff c(List list, boolean z, float[] fArr, float[] fArr2, float[] fArr3, float f, GeometryUtil geometryUtil, com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.p pVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.v vVar) {
        int i = this.a;
        int i2 = this.b;
        ay ayVar = this.e;
        return com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.v.b(list, i, i2, ayVar.t, ayVar.m, z, fArr, fArr2, fArr3, f, vVar, geometryUtil, pVar);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00db  */
    /* JADX WARN: Code duplicated, block: B:60:0x00df  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ed  */
    @Override // com.google.android.libraries.navigation.internal.po.gv
    public final void d(com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t tVar) {
        char c;
        int[] iArr;
        int i;
        int iAbs;
        int i2;
        int i3;
        int iMin;
        int iMax;
        Iterator it2 = tVar.b.iterator();
        while (it2.hasNext()) {
            int[] iArr2 = ((com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u) it2.next()).b;
            int length = iArr2.length;
            if (length == 0 || (length & 1) != 0) {
                c = 3;
                iArr = new int[]{0, 0, 0, 0};
            } else {
                int i4 = iArr2[0];
                int i5 = i4;
                int i6 = 0;
                for (int i7 = 0; i7 < iArr2.length; i7 += 2) {
                    int i8 = iArr2[0];
                    int i9 = iArr2[i7];
                    int iAbs2 = Math.abs(i8 - i9);
                    if (iAbs2 > 536870912) {
                        iAbs2 = 1073741824 - iAbs2;
                    }
                    if (iAbs2 > i6) {
                        i6 = iAbs2;
                        i5 = i9;
                    }
                }
                boolean z = false;
                for (int i10 = 0; i10 < iArr2.length; i10 += 2) {
                    int i11 = iArr2[i10];
                    int iAbs3 = Math.abs(i11 - i5);
                    if (iAbs3 > 536870912) {
                        iAbs3 = 1073741824 - iAbs3;
                        z = true;
                    }
                    if (iAbs3 > i6) {
                        i6 = iAbs3;
                        i4 = i11;
                    }
                }
                if (z) {
                    iMin = Math.max(i5, i4);
                    iMax = Math.min(i5, i4);
                } else {
                    iMin = Math.min(i5, i4);
                    iMax = Math.max(i5, i4);
                }
                int i12 = iArr2[1];
                for (int i13 = 1; i13 < iArr2.length; i13 += 2) {
                    int i14 = iArr2[i13];
                    if (i14 < i12) {
                        i12 = i14;
                    }
                }
                c = 3;
                iArr = new int[]{iMin, iMax, i12, i6};
            }
            int iMax2 = this.c;
            if (iMax2 == Integer.MIN_VALUE) {
                this.a = iArr[0];
                this.c = iArr[1];
                this.b = iArr[2];
                this.d = iArr[c];
            } else {
                int iMin2 = this.a;
                if (iMin2 > iMax2 || (i2 = iArr[0]) > (i3 = iArr[1])) {
                    if (iMin2 < 0) {
                        iMin2 = iArr[0];
                    } else {
                        int i15 = iArr[0];
                        if (i15 >= 0) {
                            iMin2 = Math.min(i15, iMin2);
                        } else if (iMax2 >= 0) {
                            iMax2 = iArr[1];
                        } else {
                            i = iArr[1];
                            if (i < 0) {
                                iMax2 = Math.max(i, iMax2);
                            }
                        }
                        iAbs = Math.abs(iMin2 - iMax2);
                        this.d = iAbs;
                        if (iAbs > 536870912) {
                            this.d = 1073741824 - iAbs;
                        }
                        this.b = Math.min(this.b, iArr[2]);
                    }
                    this.a = iMin2;
                    if (iMax2 >= 0) {
                        iMax2 = iArr[1];
                    } else {
                        i = iArr[1];
                        if (i < 0) {
                            iMax2 = Math.max(i, iMax2);
                        }
                        iAbs = Math.abs(iMin2 - iMax2);
                        this.d = iAbs;
                        if (iAbs > 536870912) {
                            this.d = 1073741824 - iAbs;
                        }
                        this.b = Math.min(this.b, iArr[2]);
                    }
                } else {
                    iMin2 = Math.min(i2, iMin2);
                    this.a = iMin2;
                    iMax2 = Math.max(i3, iMax2);
                }
                this.c = iMax2;
                iAbs = Math.abs(iMin2 - iMax2);
                this.d = iAbs;
                if (iAbs > 536870912) {
                    this.d = 1073741824 - iAbs;
                }
                this.b = Math.min(this.b, iArr[2]);
            }
        }
    }
}
