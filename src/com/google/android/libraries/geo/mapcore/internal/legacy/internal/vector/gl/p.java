package com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl;

import android.graphics.Color;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.bs;
import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class p {
    private static final int[] a = new int[0];
    protected final Map b;
    public final List c;
    protected final List d;
    protected int e;
    public int f;
    public final float g;
    public final n h;
    private final Set i;
    private final float[] j;

    public p(float f, int i) {
        this(f, i, false);
    }

    public final int c(bt btVar, bt btVar2) {
        Integer num = (Integer) this.b.get(btVar);
        if (num == null) {
            int i = this.e;
            this.e = i + 1;
            Integer numValueOf = Integer.valueOf(i);
            numValueOf.getClass();
            g(i, btVar, btVar2);
            num = numValueOf;
        }
        return num.intValue();
    }

    public final int d(ai aiVar) {
        return this.h.b(aiVar);
    }

    public final int e() {
        int size = this.e;
        if (size == 0) {
            size = this.c.size();
        }
        return com.google.android.libraries.navigation.internal.nq.a.f(size * 5, 1);
    }

    public final bs f(ai aiVar, int i) {
        return this.h.c(aiVar, i);
    }

    public final void g(int i, bt btVar, bt btVar2) {
        this.b.put(btVar, Integer.valueOf(i));
        while (i >= this.c.size()) {
            this.c.add(null);
            this.d.add(null);
        }
        this.c.set(i, btVar);
        this.d.set(i, btVar2);
    }

    public final byte[] h() {
        float f;
        int i;
        int i2;
        int[] iArr;
        float f2;
        float f3;
        int iHSVToColor;
        float f4;
        p pVar = this;
        if (pVar.c.isEmpty()) {
            return null;
        }
        int iE = e();
        int size = iE - (pVar.c.size() * 5);
        byte[] bArr = new byte[iE * 128];
        int i3 = 4;
        k kVar = new k(pVar, bArr, 4, size);
        l lVar = new l(pVar);
        int i4 = 0;
        while (i4 < pVar.c.size()) {
            bt btVar = (bt) pVar.c.get(i4);
            ai aiVarG = btVar.g(pVar.f);
            int iB = pVar.h.b(aiVarG);
            int i5 = 0;
            while (true) {
                f = 1.0f;
                if (i5 >= i3) {
                    break;
                }
                if (i5 < iB) {
                    int i6 = 0;
                    for (int i7 : pVar.h.c(aiVarG, i5).e) {
                        i6 += i7;
                    }
                    if (i6 != 0) {
                        float f5 = i6;
                        f = 1.0f / (f5 + f5);
                    }
                }
                int i8 = 0;
                for (int i9 = 0; i9 < i3; i9++) {
                    float f6 = f * 255.0f;
                    int iMin = Math.min(255, (int) f6);
                    i8 = (i8 << 8) | iMin;
                    f = f6 - iMin;
                }
                kVar.a(i8);
                kVar.g = 0;
                kVar.f.clear();
                i5++;
            }
            int iMax = Math.max(0, pVar.f);
            int iC = btVar.c(iMax) + iMax;
            int i10 = 0;
            while (i10 < i3) {
                int i11 = iMax + i10;
                if (i11 >= iC) {
                    i11 = iC - 1;
                }
                ai aiVarG2 = btVar.g(Math.max(0, i11));
                int iB2 = pVar.h.b(aiVarG2);
                int i12 = 0;
                while (i12 < i3) {
                    if (i12 >= iB2) {
                        int i13 = i11 + 1;
                        while (true) {
                            if (i13 >= i3) {
                                iHSVToColor = 0;
                                break;
                            }
                            ai aiVarG3 = btVar.g(Math.max(0, i13 >= iC ? iC - 1 : i13));
                            if (i12 < pVar.h.b(aiVarG3)) {
                                iHSVToColor = pVar.h.c(aiVarG3, i12).b;
                                break;
                            }
                            i13++;
                            i3 = 4;
                        }
                    } else {
                        iHSVToColor = pVar.h.c(aiVarG2, i12).b;
                    }
                    if (pVar.i.contains(btVar)) {
                        Color.colorToHSV(iHSVToColor, pVar.j);
                        float[] fArr = pVar.j;
                        f4 = 1.0f;
                        fArr[2] = Math.min(1.0f, fArr[2] * 1.5f);
                        iHSVToColor = Color.HSVToColor(fArr);
                    } else {
                        f4 = 1.0f;
                    }
                    int i14 = (iHSVToColor >>> 24) | (iHSVToColor << 8);
                    kVar.f.c(i14);
                    kVar.a(i14);
                    i12++;
                    f = f4;
                    iC = iC;
                    i3 = 4;
                }
                int i15 = iC;
                int[] iArr2 = lVar.b;
                char c = 0;
                iArr2[0] = 0;
                char c2 = 1;
                iArr2[1] = 0;
                int i16 = 0;
                int i17 = 4;
                while (i16 < i17) {
                    int[] iArr3 = lVar.b;
                    iArr3[c] = iArr3[c] << 8;
                    iArr3[c2] = iArr3[c2] << 8;
                    int iMin2 = i16 < iB2 ? (int) Math.min(65535.0d, Math.floor((lVar.a.h.c(aiVarG2, i16).d / 255.0f) * 65535.0f)) : 0;
                    int[] iArr4 = lVar.b;
                    iArr4[0] = iArr4[0] | (iMin2 / 256);
                    iArr4[1] = (iMin2 % 256) | iArr4[1];
                    i16++;
                    i4 = i4;
                    c2 = 1;
                    i17 = 4;
                    c = 0;
                }
                int i18 = i4;
                int[] iArr5 = lVar.b;
                for (int i19 = 0; i19 < 2; i19++) {
                    kVar.a(iArr5[i19]);
                }
                i10++;
                i4 = i18;
                iC = i15;
                i3 = 4;
                f = 1.0f;
            }
            int i20 = i4;
            int i21 = i3;
            for (int i22 = 0; i22 < i21; i22++) {
                kVar.a(0);
            }
            ai aiVarG4 = btVar.g(iMax);
            int iB3 = pVar.h.b(aiVarG4);
            int i23 = 0;
            while (i23 < i21) {
                int[] iArr6 = i23 < iB3 ? pVar.h.c(aiVarG4, i23).e : a;
                byte[] bArr2 = new byte[32];
                if (iArr6.length == 0) {
                    Arrays.fill(bArr2, 0, 32, (byte) -1);
                } else {
                    int i24 = 0;
                    for (int i25 : iArr6) {
                        i24 += i25;
                    }
                    float f7 = kVar.h.g;
                    int i26 = 0;
                    int i27 = 32;
                    while (i26 < i27) {
                        ar.b(true, "Invalid texel index");
                        int length = iArr6.length;
                        if ((length & 1) == 1) {
                            length += length;
                            i = i24 + i24;
                        } else {
                            i = i24;
                        }
                        float f8 = i26;
                        l lVar2 = lVar;
                        ai aiVar = aiVarG4;
                        int i28 = 0;
                        int i29 = 0;
                        boolean z = true;
                        while (true) {
                            if (i28 >= length) {
                                throw new IllegalStateException("Couldn't find dash");
                            }
                            i2 = iB3;
                            float f9 = i * f8;
                            int i30 = i;
                            int i31 = iArr6[i28 % iArr6.length] + i29;
                            iArr = iArr6;
                            f2 = i31;
                            f3 = f9 / 32.0f;
                            if (f3 <= f2) {
                                break;
                            }
                            z = !z;
                            i28++;
                            i29 = i31;
                            iB3 = i2;
                            i = i30;
                            iArr6 = iArr;
                        }
                        float f10 = 8.0f / f7;
                        float f11 = f3 - i29;
                        float f12 = f2 - f3;
                        bArr2[i26] = (byte) Math.round(((f11 <= f10 || f12 <= f10) ? 0.5f + ((Math.min(f11, f12) / f10) * (true != z ? -0.5f : 0.5f)) : z ? 1.0f : 0.0f) * 255.0f);
                        i26++;
                        i27 = 32;
                        lVar = lVar2;
                        aiVarG4 = aiVar;
                        iB3 = i2;
                        iArr6 = iArr;
                    }
                }
                l lVar3 = lVar;
                ai aiVar2 = aiVarG4;
                int i32 = iB3;
                int iN = kVar.f.n(kVar.g);
                int i33 = 0;
                for (int i34 = 32; i33 < i34; i34 = 32) {
                    kVar.a(((bArr2[i33] & 255) * (iN & 255)) / 255);
                    i33++;
                }
                kVar.g++;
                i23++;
                i21 = 4;
                pVar = this;
                lVar = lVar3;
                aiVarG4 = aiVar2;
                iB3 = i32;
            }
            i4 = i20 + 1;
            i3 = 4;
            pVar = this;
        }
        for (int i35 = 0; i35 < kVar.e; i35++) {
            for (int i36 = 0; i36 < 32; i36++) {
                kVar.a(0);
            }
        }
        kVar.b = 0;
        return bArr;
    }

    public p(float f, int i, boolean z) {
        this.b = new HashMap();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = 0;
        this.i = new HashSet();
        this.j = new float[3];
        this.g = f;
        this.f = i;
        this.h = z ? new j() : new m();
    }
}
