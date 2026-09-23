package com.google.android.libraries.navigation.internal.ael;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i {
    public static final /* synthetic */ int a = 0;
    private static volatile int b = 100;

    static double a(byte[] bArr, int i) {
        return Double.longBitsToDouble(t(bArr, i));
    }

    static float b(byte[] bArr, int i) {
        return Float.intBitsToFloat(e(bArr, i));
    }

    static int c(byte[] bArr, int i, h hVar) throws cc {
        int iM = m(bArr, i, hVar);
        int i2 = hVar.a;
        if (i2 < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iM) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            hVar.c = x.b;
            return iM;
        }
        hVar.c = x.u(bArr, iM, i2);
        return iM + i2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static int d(int i, byte[] bArr, int i2, int i3, be beVar, bh bhVar, ef efVar, h hVar) throws IOException {
        int i4;
        int i5 = i >>> 3;
        av avVar = beVar.w;
        Object objValueOf = null;
        if (bhVar.b() != es.ENUM) {
            switch (bhVar.b()) {
                case DOUBLE:
                    i4 = i2 + 8;
                    objValueOf = Double.valueOf(a(bArr, i2));
                    i2 = i4;
                    break;
                case FLOAT:
                    i4 = i2 + 4;
                    objValueOf = Float.valueOf(b(bArr, i2));
                    i2 = i4;
                    break;
                case INT64:
                case UINT64:
                    i2 = p(bArr, i2, hVar);
                    objValueOf = Long.valueOf(hVar.b);
                    break;
                case INT32:
                case UINT32:
                    i2 = m(bArr, i2, hVar);
                    objValueOf = Integer.valueOf(hVar.a);
                    break;
                case FIXED64:
                case SFIXED64:
                    i4 = i2 + 8;
                    objValueOf = Long.valueOf(t(bArr, i2));
                    i2 = i4;
                    break;
                case FIXED32:
                case SFIXED32:
                    i4 = i2 + 4;
                    objValueOf = Integer.valueOf(e(bArr, i2));
                    i2 = i4;
                    break;
                case BOOL:
                    i2 = p(bArr, i2, hVar);
                    objValueOf = Boolean.valueOf(hVar.b != 0);
                    break;
                case STRING:
                    i2 = j(bArr, i2, hVar);
                    objValueOf = hVar.c;
                    break;
                case GROUP:
                    int i6 = (i5 << 3) | 4;
                    dr drVarA = di.a.a(bhVar.c.getClass());
                    if (bhVar.f()) {
                        int iF = f(drVarA, bArr, i2, i3, i6, hVar);
                        avVar.l(bhVar.d, hVar.c);
                        return iF;
                    }
                    Object objK = avVar.k(bhVar.d);
                    if (objK == null) {
                        objK = drVarA.e();
                        avVar.m(bhVar.d, objK);
                    }
                    return q(objK, drVarA, bArr, i2, i3, i6, hVar);
                case MESSAGE:
                    dr drVarA2 = di.a.a(bhVar.c.getClass());
                    if (bhVar.f()) {
                        int iG = g(drVarA2, bArr, i2, i3, hVar);
                        avVar.l(bhVar.d, hVar.c);
                        return iG;
                    }
                    Object objK2 = avVar.k(bhVar.d);
                    if (objK2 == null) {
                        objK2 = drVarA2.e();
                        avVar.m(bhVar.d, objK2);
                    }
                    return r(objK2, drVarA2, bArr, i2, i3, hVar);
                case BYTES:
                    i2 = c(bArr, i2, hVar);
                    objValueOf = hVar.c;
                    break;
                case ENUM:
                    throw new IllegalStateException("Shouldn't reach here.");
                case SINT32:
                    i2 = m(bArr, i2, hVar);
                    objValueOf = Integer.valueOf(ac.H(hVar.a));
                    break;
                case SINT64:
                    i2 = p(bArr, i2, hVar);
                    objValueOf = Long.valueOf(ac.I(hVar.b));
                    break;
            }
        } else {
            i2 = m(bArr, i2, hVar);
            if (bhVar.d.a.a(hVar.a) == null) {
                dt.l(beVar, i5, hVar.a, null, efVar);
                return i2;
            }
            objValueOf = Integer.valueOf(hVar.a);
        }
        if (bhVar.f()) {
            avVar.l(bhVar.d, objValueOf);
        } else {
            avVar.m(bhVar.d, objValueOf);
        }
        return i2;
    }

    static int e(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int f(dr drVar, byte[] bArr, int i, int i2, int i3, h hVar) throws IOException {
        Object objE = drVar.e();
        int iQ = q(objE, drVar, bArr, i, i2, i3, hVar);
        drVar.f(objE);
        hVar.c = objE;
        return iQ;
    }

    static int g(dr drVar, byte[] bArr, int i, int i2, h hVar) throws IOException {
        Object objE = drVar.e();
        int iR = r(objE, drVar, bArr, i, i2, hVar);
        drVar.f(objE);
        hVar.c = objE;
        return iR;
    }

    static int h(dr drVar, int i, byte[] bArr, int i2, int i3, bz bzVar, h hVar) throws IOException {
        int iG = g(drVar, bArr, i2, i3, hVar);
        bzVar.add(hVar.c);
        while (iG < i3) {
            int iM = m(bArr, iG, hVar);
            if (i != hVar.a) {
                break;
            }
            iG = g(drVar, bArr, iM, i3, hVar);
            bzVar.add(hVar.c);
        }
        return iG;
    }

    static int i(byte[] bArr, int i, bz bzVar, h hVar) throws IOException {
        bj bjVar = (bj) bzVar;
        int iM = m(bArr, i, hVar);
        int i2 = hVar.a + iM;
        while (iM < i2) {
            iM = m(bArr, iM, hVar);
            bjVar.i(hVar.a);
        }
        if (iM == i2) {
            return iM;
        }
        throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int j(byte[] bArr, int i, h hVar) throws cc {
        int iM = m(bArr, i, hVar);
        int i2 = hVar.a;
        if (i2 < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            hVar.c = "";
            return iM;
        }
        hVar.c = new String(bArr, iM, i2, ca.a);
        return iM + i2;
    }

    static int k(byte[] bArr, int i, h hVar) throws cc {
        int iM = m(bArr, i, hVar);
        int i2 = hVar.a;
        if (i2 < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            hVar.c = "";
            return iM;
        }
        hVar.c = er.h(bArr, iM, i2);
        return iM + i2;
    }

    static int l(int i, byte[] bArr, int i2, int i3, eg egVar, h hVar) throws cc {
        if (eu.a(i) == 0) {
            throw new cc("Protocol message contained an invalid tag (zero).");
        }
        int iB = eu.b(i);
        if (iB == 0) {
            int iP = p(bArr, i2, hVar);
            egVar.e(i, Long.valueOf(hVar.b));
            return iP;
        }
        if (iB == 1) {
            egVar.e(i, Long.valueOf(t(bArr, i2)));
            return i2 + 8;
        }
        if (iB == 2) {
            int iM = m(bArr, i2, hVar);
            int i4 = hVar.a;
            if (i4 < 0) {
                throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i4 > bArr.length - iM) {
                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i4 == 0) {
                egVar.e(i, x.b);
            } else {
                egVar.e(i, x.u(bArr, iM, i4));
            }
            return iM + i4;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new cc("Protocol message contained an invalid tag (zero).");
            }
            egVar.e(i, Integer.valueOf(e(bArr, i2)));
            return i2 + 4;
        }
        eg egVar2 = new eg();
        int i5 = (i & (-8)) | 4;
        int i6 = hVar.e + 1;
        hVar.e = i6;
        u(i6);
        int i7 = 0;
        while (i2 < i3) {
            int iM2 = m(bArr, i2, hVar);
            int i8 = hVar.a;
            if (i8 == i5) {
                i7 = i8;
                i2 = iM2;
                break;
            }
            i7 = i8;
            i2 = l(i8, bArr, iM2, i3, egVar2, hVar);
        }
        hVar.e--;
        if (i2 > i3 || i7 != i5) {
            throw new cc("Failed to parse the message.");
        }
        egVar.e(i, egVar2);
        return i2;
    }

    static int m(byte[] bArr, int i, h hVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return n(b2, bArr, i2, hVar);
        }
        hVar.a = b2;
        return i2;
    }

    static int n(int i, byte[] bArr, int i2, h hVar) {
        byte b2 = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b2 >= 0) {
            hVar.a = i4 | (b2 << 7);
            return i3;
        }
        int i5 = i4 | ((b2 & 127) << 7);
        int i6 = i2 + 2;
        byte b3 = bArr[i3];
        if (b3 >= 0) {
            hVar.a = i5 | (b3 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i2 + 3;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            hVar.a = i7 | (b4 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i2 + 4;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            hVar.a = i9 | (b5 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                hVar.a = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int o(int i, byte[] bArr, int i2, int i3, bz bzVar, h hVar) {
        bj bjVar = (bj) bzVar;
        int iM = m(bArr, i2, hVar);
        bjVar.i(hVar.a);
        while (iM < i3) {
            int iM2 = m(bArr, iM, hVar);
            if (i != hVar.a) {
                break;
            }
            iM = m(bArr, iM2, hVar);
            bjVar.i(hVar.a);
        }
        return iM;
    }

    static int p(byte[] bArr, int i, h hVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            hVar.b = j;
            return i2;
        }
        int i3 = i + 2;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & 127)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & 127)) << i4;
            b2 = b3;
            i3 = i5;
        }
        hVar.b = j2;
        return i3;
    }

    static int q(Object obj, dr drVar, byte[] bArr, int i, int i2, int i3, h hVar) throws IOException {
        db dbVar = (db) drVar;
        int i4 = hVar.e + 1;
        hVar.e = i4;
        u(i4);
        int iC = dbVar.c(obj, bArr, i, i2, i3, hVar);
        hVar.e--;
        hVar.c = obj;
        return iC;
    }

    static int r(Object obj, dr drVar, byte[] bArr, int i, int i2, h hVar) throws IOException {
        int iN = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iN = n(i3, bArr, iN, hVar);
            i3 = hVar.a;
        }
        int i4 = iN;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = hVar.e + 1;
        hVar.e = i5;
        u(i5);
        int i6 = i3 + i4;
        drVar.i(obj, bArr, i4, i6, hVar);
        hVar.e--;
        hVar.c = obj;
        return i6;
    }

    static int s(int i, byte[] bArr, int i2, int i3, h hVar) throws cc {
        if (eu.a(i) == 0) {
            throw new cc("Protocol message contained an invalid tag (zero).");
        }
        int iB = eu.b(i);
        if (iB == 0) {
            return p(bArr, i2, hVar);
        }
        if (iB == 1) {
            return i2 + 8;
        }
        if (iB == 2) {
            return m(bArr, i2, hVar) + hVar.a;
        }
        if (iB != 3) {
            if (iB == 5) {
                return i2 + 4;
            }
            throw new cc("Protocol message contained an invalid tag (zero).");
        }
        int i4 = (i & (-8)) | 4;
        int i5 = 0;
        while (i2 < i3) {
            i2 = m(bArr, i2, hVar);
            i5 = hVar.a;
            if (i5 == i4) {
                break;
            }
            i2 = s(i5, bArr, i2, i3, hVar);
        }
        if (i2 > i3 || i5 != i4) {
            throw new cc("Failed to parse the message.");
        }
        return i2;
    }

    static long t(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void u(int i) throws cc {
        if (i >= b) {
            throw new cc("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
