package com.google.android.libraries.navigation.internal.ma;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.libraries.navigation.internal.lh.be;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o extends com.google.android.libraries.navigation.internal.li.a implements Comparable<o> {
    public static final Parcelable.Creator<o> CREATOR = new p();
    public final String a;
    public final long b;
    public final boolean c;
    public final double d;
    public final String e;
    public final byte[] f;
    public final int g;
    public final int h;
    public final int i;

    public o(String str, long j, boolean z, double d, String str2, byte[] bArr, int i, int i2, int i3) {
        this.a = str;
        this.b = j;
        this.c = z;
        this.d = d;
        this.e = str2;
        this.f = bArr;
        this.g = i;
        this.h = i2;
        this.i = i3;
    }

    private static int b(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i != i2 ? 1 : 0;
    }

    final void a(StringBuilder sb) {
        sb.append("Flag(");
        sb.append(this.a);
        sb.append(", ");
        int i = this.g;
        if (i == 1) {
            sb.append(this.b);
        } else if (i == 2) {
            sb.append(this.c);
        } else if (i == 3) {
            sb.append(this.d);
        } else if (i == 4) {
            sb.append("'");
            String str = this.e;
            be.j(str);
            sb.append(str);
            sb.append("'");
        } else {
            if (i != 5) {
                throw new AssertionError("Invalid type: " + this.a + ", " + i);
            }
            sb.append("'");
            byte[] bArr = this.f;
            be.j(bArr);
            sb.append(Base64.encodeToString(bArr, 3));
            sb.append("'");
        }
        sb.append(", ");
        sb.append(this.g);
        sb.append(", ");
        sb.append(this.h);
        sb.append(", ");
        sb.append(this.i);
        sb.append(")");
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
    
        if (r0 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
    
        if (r4 == r6) goto L45;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ int compareTo(o oVar) {
        o oVar2 = oVar;
        int iCompareTo = this.a.compareTo(oVar2.a);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int i = this.g;
        int iB = b(i, oVar2.g);
        if (iB == 0) {
            iB = -1;
            int i2 = 0;
            if (i != 1) {
                if (i == 2) {
                    boolean z = this.c;
                    if (z != oVar2.c) {
                    }
                    return 0;
                }
                if (i == 3) {
                    return Double.compare(this.d, oVar2.d);
                }
                if (i == 4) {
                    String str = this.e;
                    String str2 = oVar2.e;
                    if (str != str2) {
                        if (str != null) {
                            if (str2 != null) {
                                return str.compareTo(str2);
                            }
                            return 1;
                        }
                    }
                    return 0;
                }
                if (i != 5) {
                    throw new AssertionError(com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid enum value: "));
                }
                byte[] bArr = this.f;
                byte[] bArr2 = oVar2.f;
                if (bArr != bArr2) {
                    if (bArr != null) {
                        if (bArr2 != null) {
                            while (true) {
                                byte[] bArr3 = this.f;
                                int length = bArr3.length;
                                byte[] bArr4 = oVar2.f;
                                int length2 = bArr4.length;
                                if (i2 >= Math.min(length, length2)) {
                                    return b(length, length2);
                                }
                                int i3 = bArr3[i2] - bArr4[i2];
                                if (i3 != 0) {
                                    return i3;
                                }
                                i2++;
                            }
                        }
                        return 1;
                    }
                }
                return 0;
            }
            long j = this.b;
            long j2 = oVar2.b;
            if (j >= j2) {
            }
        }
        return iB;
    }

    public final boolean equals(Object obj) {
        int i;
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (am.a(this.a, oVar.a) && (i = this.g) == oVar.g && this.h == oVar.h && this.i == oVar.i) {
                if (i != 1) {
                    if (i == 2) {
                        return this.c == oVar.c;
                    }
                    if (i == 3) {
                        return this.d == oVar.d;
                    }
                    if (i == 4) {
                        return am.a(this.e, oVar.e);
                    }
                    if (i == 5) {
                        return Arrays.equals(this.f, oVar.f);
                    }
                    throw new AssertionError(com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid enum value: "));
                }
                if (this.b == oVar.b) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iA = com.google.android.libraries.navigation.internal.li.d.a(parcel);
        String str = this.a;
        if (!p.b(str)) {
            com.google.android.libraries.navigation.internal.li.d.r(parcel, 2, str);
        }
        long j = this.b;
        if (j != 0) {
            com.google.android.libraries.navigation.internal.li.d.i(parcel, 3, j);
        }
        if (this.c) {
            com.google.android.libraries.navigation.internal.li.d.d(parcel, 4, true);
        }
        double d = this.d;
        if (d != 0.0d) {
            com.google.android.libraries.navigation.internal.li.d.f(parcel, 5, d);
        }
        String str2 = this.e;
        if (!p.b(str2)) {
            com.google.android.libraries.navigation.internal.li.d.r(parcel, 6, str2);
        }
        byte[] bArr = this.f;
        if (!p.b(bArr)) {
            com.google.android.libraries.navigation.internal.li.d.k(parcel, 7, bArr);
        }
        int i2 = this.g;
        if (!p.a(i2)) {
            com.google.android.libraries.navigation.internal.li.d.h(parcel, 8, i2);
        }
        int i3 = this.h;
        if (!p.a(i3)) {
            com.google.android.libraries.navigation.internal.li.d.h(parcel, 9, i3);
        }
        int i4 = this.i;
        if (!p.a(i4)) {
            com.google.android.libraries.navigation.internal.li.d.h(parcel, 10, i4);
        }
        com.google.android.libraries.navigation.internal.li.d.c(parcel, iA);
    }
}
