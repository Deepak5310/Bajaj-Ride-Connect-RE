package com.google.android.libraries.geo.mapcore.internal.model;

import android.graphics.Color;
import com.google.android.libraries.navigation.internal.adg.id;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class bs {
    public final int b;
    public final int c;
    public final float d;
    public final int[] e;
    public final int f;
    public final int g;
    public final float h;
    public com.google.android.libraries.geo.mapcore.internal.vector.gl.n i;
    public com.google.android.libraries.geo.mapcore.internal.vector.gl.n j;
    public com.google.android.libraries.geo.mapcore.internal.vector.gl.n k;
    public final float l;
    public final float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int[] f62n = new int[0];
    public static final bs a = new bs(0, 1.0f, new int[0], 0.0f);

    /* JADX WARN: Illegal instructions before constructor call */
    public bs(int i, float f, int[] iArr, float f2) {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2 = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        this(i, i, f, iArr, 0.0f, nVar, 0.0f, 0.0f, nVar2, nVar2);
    }

    public static bs a(id idVar, com.google.android.libraries.navigation.internal.adh.b bVar) {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2 = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        return b(idVar, bVar, nVar, nVar2, nVar2);
    }

    public static bs b(id idVar, com.google.android.libraries.navigation.internal.adh.b bVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar3) {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n aVar;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar4 = nVar == null ? com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b : nVar;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar5 = nVar2 == null ? com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b : nVar2;
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n aVar2 = nVar3 == null ? com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b : nVar3;
        int i = idVar.c;
        if ((idVar.b & 64) != 0) {
            i = -1;
        }
        int i2 = i;
        float fA = ay.a(idVar.e);
        int[] iArr = f62n;
        if (idVar.f.size() > 0) {
            iArr = new int[idVar.f.size()];
            for (int i3 = 0; i3 < idVar.f.size(); i3++) {
                iArr[i3] = idVar.f.d(i3);
            }
        }
        int[] iArr2 = iArr;
        float fA2 = ay.a(idVar.g);
        float fA3 = ay.a(idVar.i);
        float fA4 = ay.a(idVar.j);
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n aVar3 = (nVar4 != com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b || (idVar.b & 64) == 0) ? nVar4 : new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(idVar.h, com.google.android.libraries.geo.mapcore.internal.vector.gl.o.WRAP_T);
        if (nVar5 != com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b || (idVar.b & 1024) == 0) {
            aVar = nVar5;
        } else {
            com.google.android.libraries.navigation.internal.adg.bw bwVar = idVar.k;
            if (bwVar == null) {
                bwVar = com.google.android.libraries.navigation.internal.adg.bw.a;
            }
            aVar = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(cm.a(bwVar.c, (bwVar.b & 2) != 0, bwVar.d, bVar), com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP);
        }
        if (aVar2 == com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b && (idVar.b & 2048) != 0) {
            com.google.android.libraries.navigation.internal.adg.bw bwVar2 = idVar.l;
            if (bwVar2 == null) {
                bwVar2 = com.google.android.libraries.navigation.internal.adg.bw.a;
            }
            aVar2 = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(cm.a(bwVar2.c, (bwVar2.b & 2) != 0, bwVar2.d, bVar), com.google.android.libraries.geo.mapcore.internal.vector.gl.o.NO_WRAP);
        }
        return new bs(i2, (idVar.b & 4) != 0 ? idVar.d : i2, fA, iArr2, fA2, aVar3, fA3, fA4, aVar, aVar2);
    }

    public final boolean c() {
        return this.e.length > 0;
    }

    public final boolean d() {
        if (this.d <= 0.0f) {
            return false;
        }
        if (Color.alpha(this.b) > 0 || Color.alpha(this.c) > 0) {
            return true;
        }
        return (this.i.c() && this.j.c() && this.k.c()) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof bs)) {
            return false;
        }
        bs bsVar = (bs) obj;
        if (this.b != bsVar.b || this.c != bsVar.c || !Arrays.equals(this.e, bsVar.e)) {
            return false;
        }
        if (Float.floatToIntBits(this.h) == Float.floatToIntBits(bsVar.h) && this.j.equals(bsVar.j) && this.k.equals(bsVar.k) && this.i.equals(bsVar.i)) {
            return Float.floatToIntBits(this.d) == Float.floatToIntBits(bsVar.d);
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.b + 31) * 31) + this.c) * 31) + Arrays.hashCode(this.e)) * 31) + Float.floatToIntBits(this.h)) * 31) + Float.floatToIntBits(this.d);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Stroke{color=");
        sb.append(Integer.toHexString(this.b));
        if (this.b != this.c) {
            sb.append(", endColor=");
            sb.append(Integer.toHexString(this.c));
        }
        sb.append(", width=");
        sb.append(this.d);
        sb.append(", offset=");
        sb.append(this.h);
        sb.append(", dashes=");
        sb.append(Arrays.toString(this.e));
        if (!this.i.c()) {
            sb.append(", stampTextureKey=");
            sb.append(this.i);
        }
        if (!this.j.c()) {
            sb.append(", startCapMaskTextureKey=");
            sb.append(this.j);
        }
        if (!this.k.c()) {
            sb.append(", endCapMaskTextureKey=");
            sb.append(this.k);
        }
        sb.append("}");
        return sb.toString();
    }

    public bs(int i, int i2, float f, int[] iArr, float f2, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, float f3, float f4, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2, com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar3) {
        this.b = i;
        this.c = i2;
        this.d = f;
        this.e = iArr;
        this.h = f2;
        this.l = f3;
        this.m = f4;
        this.i = nVar;
        this.j = nVar2;
        this.k = nVar3;
        int i3 = 1;
        if (iArr.length != 0) {
            int iG = 0;
            for (int i4 : iArr) {
                iG = iG == 0 ? i4 : iG;
                if (i4 > 0) {
                    iG = com.google.android.libraries.navigation.internal.nq.a.g(iG, i4);
                }
            }
            if (iG != 0) {
                i3 = iG;
            }
        }
        this.g = i3;
        int i5 = 0;
        for (int i6 : iArr) {
            i5 += i6;
        }
        this.f = i5;
    }
}
