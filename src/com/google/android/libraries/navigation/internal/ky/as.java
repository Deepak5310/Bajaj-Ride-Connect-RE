package com.google.android.libraries.navigation.internal.ky;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.libraries.navigation.internal.lh.az;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as extends com.google.android.libraries.navigation.internal.li.a {
    public static final Parcelable.Creator<as> CREATOR = new at();
    private static final String[] m = new String[0];
    public final com.google.android.libraries.navigation.internal.la.y a;
    public final byte[] b;
    public final int[] c;
    public final String[] d;
    public final int[] e;
    public final byte[][] f;
    public final com.google.android.libraries.navigation.internal.ma.l[] g;
    public final boolean h;
    public com.google.android.libraries.navigation.internal.la.w i;
    public final int j;
    public final com.google.android.libraries.navigation.internal.la.k k;
    public final com.google.android.libraries.navigation.internal.afk.b l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final String[] f476n;

    public as(com.google.android.libraries.navigation.internal.la.y yVar, com.google.android.libraries.navigation.internal.afk.b bVar, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, com.google.android.libraries.navigation.internal.ma.l[] lVarArr, boolean z, String[] strArr2, int i, com.google.android.libraries.navigation.internal.la.k kVar) {
        this.a = yVar;
        this.l = bVar;
        this.b = bArr;
        this.c = iArr;
        this.d = null;
        this.e = iArr2;
        this.f = null;
        this.g = lVarArr;
        this.h = true;
        this.f476n = strArr2;
        this.j = i;
        this.k = null;
    }

    public as(com.google.android.libraries.navigation.internal.la.y yVar, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z, com.google.android.libraries.navigation.internal.ma.l[] lVarArr, com.google.android.libraries.navigation.internal.la.w wVar, String[] strArr2, int i, com.google.android.libraries.navigation.internal.la.k kVar) {
        this.a = yVar;
        this.b = bArr;
        this.c = iArr;
        this.d = strArr;
        this.e = iArr2;
        this.f = bArr2;
        this.h = z;
        this.g = lVarArr;
        this.i = wVar;
        this.f476n = strArr2;
        this.j = i;
        this.l = null;
        this.k = kVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof as) {
            as asVar = (as) obj;
            if (az.a(this.a, asVar.a) && Arrays.equals(this.b, asVar.b) && Arrays.equals(this.c, asVar.c) && Arrays.equals(this.d, asVar.d) && az.a(this.l, asVar.l) && Arrays.equals(this.e, asVar.e) && Arrays.deepEquals(this.f, asVar.f) && Arrays.equals(this.g, asVar.g) && Arrays.equals(this.f476n, asVar.f476n) && this.h == asVar.h && az.a(this.i, asVar.i) && this.j == asVar.j && az.a(this.k, asVar.k)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.l, this.e, this.f, this.g, Boolean.valueOf(this.h), this.f476n, this.i, Integer.valueOf(this.j), this.k});
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LogEventParcelable[");
        sb.append(this.a);
        sb.append(", LogEventBytes: ");
        byte[] bArr = this.b;
        sb.append(bArr == null ? null : new String(bArr, StandardCharsets.UTF_8));
        sb.append(", TestCodes: ");
        sb.append(Arrays.toString(this.c));
        sb.append(", MendelPackages: ");
        sb.append(Arrays.toString(this.d));
        sb.append(", LogEvent: ");
        sb.append(this.l);
        sb.append(", , ExperimentIDs: ");
        sb.append(Arrays.toString(this.e));
        sb.append(", ExperimentTokens: ");
        sb.append(Arrays.deepToString(this.f));
        sb.append(", ExperimentTokensParcelables: ");
        sb.append(Arrays.toString(this.g));
        sb.append(", MendelPackagesToFilter: ");
        sb.append(Arrays.toString(this.f476n));
        sb.append("AddPhenotypeExperimentTokens: ");
        sb.append(this.h);
        sb.append(", LogVerifierResult: ");
        com.google.android.libraries.navigation.internal.la.w wVar = this.i;
        sb.append(wVar != null ? wVar.toString() : null);
        sb.append("EventCode: ");
        sb.append(this.j);
        sb.append(", ");
        sb.append(this.k);
        sb.append("]");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 2, this.a, i);
        com.google.android.libraries.navigation.internal.li.d.k(parcel, 3, this.b);
        com.google.android.libraries.navigation.internal.li.d.o(parcel, 4, this.c);
        com.google.android.libraries.navigation.internal.li.d.s(parcel, 5, this.d);
        com.google.android.libraries.navigation.internal.li.d.o(parcel, 6, this.e);
        com.google.android.libraries.navigation.internal.li.d.l(parcel, 7, this.f);
        com.google.android.libraries.navigation.internal.li.d.d(parcel, 8, this.h);
        com.google.android.libraries.navigation.internal.li.d.u(parcel, 9, this.g, i);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 11, this.i, i);
        String[] strArr = this.f476n;
        if (strArr == null) {
            strArr = m;
        }
        com.google.android.libraries.navigation.internal.li.d.s(parcel, 12, strArr);
        com.google.android.libraries.navigation.internal.li.d.h(parcel, 13, this.j);
        com.google.android.libraries.navigation.internal.li.d.q(parcel, 14, this.k, i);
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
