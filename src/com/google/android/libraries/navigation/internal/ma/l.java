package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yz.mp;
import com.google.maps.android.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends com.google.android.libraries.navigation.internal.li.a {
    public final String b;
    public final byte[] c;
    public final byte[][] d;
    public final byte[][] e;
    public final byte[][] f;
    public final byte[][] g;
    public final int[] h;
    public final byte[][] i;
    public final int[] j;
    public final byte[][] k;
    public static final byte[][] a = new byte[0][];
    public static final Parcelable.Creator<l> CREATOR = new m();

    public l(String str, byte[] bArr, byte[][] bArr2, byte[][] bArr3, byte[][] bArr4, byte[][] bArr5, int[] iArr, byte[][] bArr6, int[] iArr2, byte[][] bArr7) {
        this.b = str;
        this.c = bArr;
        this.d = bArr2;
        this.e = bArr3;
        this.f = bArr4;
        this.g = bArr5;
        this.h = iArr;
        this.i = bArr6;
        this.j = iArr2;
        this.k = bArr7;
    }

    public static byte[][] a(List list, k kVar) {
        byte[][] bArrA;
        byte[][] bArrA2;
        Iterator it2 = list.iterator();
        int length = 0;
        while (it2.hasNext()) {
            l lVar = (l) it2.next();
            if (lVar != null && (bArrA2 = kVar.a(lVar)) != null) {
                length += bArrA2.length;
            }
        }
        byte[][] bArr = new byte[length][];
        Iterator it3 = list.iterator();
        int i = 0;
        while (it3.hasNext()) {
            l lVar2 = (l) it3.next();
            if (lVar2 != null && (bArrA = kVar.a(lVar2)) != null) {
                for (byte[] bArr2 : bArrA) {
                    if (bArr2 != null) {
                        bArr[i] = bArr2;
                        i++;
                    }
                }
            }
        }
        return bArr;
    }

    private static List b(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length >> 1);
        for (int i = 0; i < iArr.length; i += 2) {
            arrayList.add(new u(iArr[i], iArr[i + 1]));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private final Set c() {
        ArrayList arrayList = new ArrayList();
        byte[][] bArr = this.i;
        if (bArr != null) {
            Collections.addAll(arrayList, bArr);
        }
        byte[] bArr2 = this.c;
        if (bArr2 != null) {
            arrayList.add(bArr2);
        }
        return e((byte[][]) arrayList.toArray(new byte[0][]));
    }

    private static void f(StringBuilder sb, String str, byte[][] bArr) {
        sb.append(str);
        sb.append("=");
        if (bArr == null) {
            sb.append(BuildConfig.TRAVIS);
            return;
        }
        sb.append("(");
        boolean z = true;
        int i = 0;
        while (i < bArr.length) {
            byte[] bArr2 = bArr[i];
            if (!z) {
                sb.append(", ");
            }
            sb.append("'");
            be.j(bArr2);
            sb.append(Base64.encodeToString(bArr2, 3));
            sb.append("'");
            i++;
            z = false;
        }
        sb.append(")");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (am.a(this.b, lVar.b) && am.a(c(), lVar.c()) && am.a(e(this.d), e(lVar.d)) && am.a(e(this.e), e(lVar.e)) && am.a(e(this.f), e(lVar.f)) && am.a(e(this.g), e(lVar.g)) && am.a(d(this.h), d(lVar.h)) && am.a(b(this.j), b(lVar.j)) && am.a(e(this.k), e(lVar.k))) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ExperimentTokens");
        sb.append("(");
        String str = this.b;
        sb.append(str == null ? BuildConfig.TRAVIS : com.google.android.libraries.navigation.internal.b.b.g(str, "'", "'"));
        sb.append(", direct==");
        byte[] bArr = this.c;
        if (bArr == null) {
            sb.append(BuildConfig.TRAVIS);
        } else {
            sb.append("'");
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append("'");
        }
        sb.append(", ");
        f(sb, "GAIA=", this.d);
        sb.append(", ");
        f(sb, "PSEUDO=", this.e);
        sb.append(", ");
        f(sb, "ALWAYS=", this.f);
        sb.append(", ");
        f(sb, "OTHER=", this.g);
        sb.append(", weak=");
        sb.append(Arrays.toString(this.h));
        sb.append(", ");
        f(sb, "directs=", this.i);
        sb.append(", genDims=");
        sb.append(Arrays.toString(b(this.j).toArray()));
        sb.append(", ");
        f(sb, "external=", this.k);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, this.b);
        com.google.android.libraries.navigation.internal.li.d.k(parcel, 3, this.c);
        com.google.android.libraries.navigation.internal.li.d.l(parcel, 4, this.d);
        com.google.android.libraries.navigation.internal.li.d.l(parcel, 5, this.e);
        com.google.android.libraries.navigation.internal.li.d.l(parcel, 6, this.f);
        com.google.android.libraries.navigation.internal.li.d.l(parcel, 7, this.g);
        com.google.android.libraries.navigation.internal.li.d.o(parcel, 8, this.h);
        com.google.android.libraries.navigation.internal.li.d.l(parcel, 9, this.i);
        com.google.android.libraries.navigation.internal.li.d.o(parcel, 10, this.j);
        com.google.android.libraries.navigation.internal.li.d.l(parcel, 11, this.k);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }

    private static Set d(int[] iArr) {
        int length;
        if (iArr == null || (length = iArr.length) == 0) {
            return Collections.emptySet();
        }
        HashSet hashSetG = mp.g(length);
        for (int i : iArr) {
            hashSetG.add(Integer.valueOf(i));
        }
        return hashSetG;
    }

    private static Set e(byte[][] bArr) {
        int length;
        if (bArr == null || (length = bArr.length) == 0) {
            return Collections.emptySet();
        }
        HashSet hashSetG = mp.g(length);
        for (byte[] bArr2 : bArr) {
            be.j(bArr2);
            hashSetG.add(Base64.encodeToString(bArr2, 3));
        }
        return hashSetG;
    }
}
