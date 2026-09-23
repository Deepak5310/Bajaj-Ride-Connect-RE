package com.google.android.libraries.navigation.internal.ael;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa extends ac {
    private final InputStream a;
    private final byte[] h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f241n = Integer.MAX_VALUE;

    public aa(InputStream inputStream) {
        Charset charset = ca.a;
        this.a = inputStream;
        this.h = new byte[4096];
        this.i = 0;
        this.k = 0;
        this.m = 0;
    }

    private static int G(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        try {
            return inputStream.read(bArr, i, i2);
        } catch (cc e) {
            e.a();
            throw e;
        }
    }

    private final List Q(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.a.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.m += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void R() {
        int i = this.i + this.j;
        this.i = i;
        int i2 = this.m + i;
        int i3 = this.f241n;
        if (i2 <= i3) {
            this.j = 0;
            return;
        }
        int i4 = i2 - i3;
        this.j = i4;
        this.i = i - i4;
    }

    private final void S(int i) throws IOException {
        if (T(i)) {
            return;
        }
        if (i <= (this.e - this.m) - this.k) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new cc("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    private final boolean T(int i) throws IOException {
        int i2 = this.k;
        int i3 = i2 + i;
        int i4 = this.i;
        if (i3 <= i4) {
            throw new IllegalStateException(com.google.android.libraries.navigation.internal.b.b.j(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i5 = this.e;
        int i6 = this.m;
        if (i > (i5 - i6) - i2 || i6 + i2 + i > this.f241n) {
            return false;
        }
        if (i2 > 0) {
            if (i4 > i2) {
                byte[] bArr = this.h;
                System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
            }
            i6 = this.m + i2;
            this.m = i6;
            i4 = this.i - i2;
            this.i = i4;
            this.k = 0;
        }
        int iG = G(this.a, this.h, i4, Math.min(4096 - i4, (this.e - i6) - i4));
        if (iG == 0 || iG < -1 || iG > 4096) {
            throw new IllegalStateException(String.valueOf(this.a.getClass()) + "#read(byte[]) returned invalid result: " + iG + "\nThe InputStream implementation is buggy.");
        }
        if (iG <= 0) {
            return false;
        }
        this.i += iG;
        R();
        if (this.i >= i) {
            return true;
        }
        return T(i);
    }

    private final byte[] U(int i) throws IOException {
        if (i == 0) {
            return ca.b;
        }
        int i2 = this.m;
        int i3 = this.k;
        int i4 = i2 + i3 + i;
        if (i4 - this.e > 0) {
            throw new cc("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i5 = this.f241n;
        if (i4 > i5) {
            B((i5 - i2) - i3);
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = this.i - i3;
        int i7 = i - i6;
        if (i7 >= 4096) {
            try {
                if (i7 > this.a.available()) {
                    return null;
                }
            } catch (cc e) {
                e.a();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.h, this.k, bArr, 0, i6);
        this.m += this.i;
        this.k = 0;
        this.i = 0;
        while (i6 < i) {
            int iG = G(this.a, bArr, i6, i - i6);
            if (iG == -1) {
                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.m += iG;
            i6 += iG;
        }
        return bArr;
    }

    private final byte[] V(int i) throws IOException {
        byte[] bArrU = U(i);
        if (bArrU != null) {
            return bArrU;
        }
        int i2 = this.k;
        int i3 = this.i;
        int i4 = i3 - i2;
        this.m += i3;
        this.k = 0;
        this.i = 0;
        List<byte[]> listQ = Q(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.h, i2, bArr, 0, i4);
        for (byte[] bArr2 : listQ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i4, length);
            i4 += length;
        }
        return bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final void A(int i) {
        this.f241n = i;
        R();
    }

    public final void B(int i) throws IOException {
        int i2 = this.i;
        int i3 = this.k;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.k = i3 + i;
            return;
        }
        if (i < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.m;
        int i6 = i5 + i3;
        int i7 = this.f241n;
        if (i6 + i > i7) {
            B((i7 - i5) - i3);
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.m = i6;
        this.i = 0;
        this.k = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                try {
                    long jSkip = this.a.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        throw new IllegalStateException(String.valueOf(this.a.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i4 += (int) jSkip;
                    }
                } catch (cc e) {
                    e.a();
                    throw e;
                }
            } catch (Throwable th) {
                this.m += i4;
                R();
                throw th;
            }
        }
        this.m += i4;
        R();
        if (i4 >= i) {
            return;
        }
        int i8 = this.i;
        int i9 = i8 - this.k;
        this.k = i8;
        S(1);
        while (true) {
            int i10 = i - i9;
            int i11 = this.i;
            if (i10 <= i11) {
                this.k = i10;
                return;
            } else {
                i9 += i11;
                this.k = i11;
                S(1);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean C() throws IOException {
        return this.k == this.i && !T(1);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean D() throws IOException {
        return r() != 0;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean E(int i) throws IOException {
        int iB = eu.b(i);
        int i2 = 0;
        if (iB == 0) {
            if (this.i - this.k < 10) {
                while (i2 < 10) {
                    if (a() < 0) {
                        i2++;
                    }
                }
                throw new cc("CodedInputStream encountered a malformed varint.");
            }
            while (i2 < 10) {
                byte[] bArr = this.h;
                int i3 = this.k;
                this.k = i3 + 1;
                if (bArr[i3] < 0) {
                    i2++;
                }
            }
            throw new cc("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (iB == 1) {
            B(8);
            return true;
        }
        if (iB == 2) {
            B(j());
            return true;
        }
        if (iB == 3) {
            P();
            z(eu.c(eu.a(i), 4));
            return true;
        }
        if (iB == 4) {
            O();
            return false;
        }
        if (iB != 5) {
            throw new cb();
        }
        B(4);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final byte[] F() throws IOException {
        int iJ = j();
        int i = this.i;
        int i2 = this.k;
        if (iJ > i - i2 || iJ <= 0) {
            if (iJ >= 0) {
                return V(iJ);
            }
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(this.h, i2, i2 + iJ);
        this.k += iJ;
        return bArrCopyOfRange;
    }

    public final byte a() throws IOException {
        if (this.k == this.i) {
            S(1);
        }
        byte[] bArr = this.h;
        int i = this.k;
        this.k = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final double b() throws IOException {
        return Double.longBitsToDouble(q());
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final float c() throws IOException {
        return Float.intBitsToFloat(i());
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int d() {
        return this.m + this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int f() throws IOException {
        return j();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int g() throws IOException {
        return i();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int h() throws IOException {
        return j();
    }

    public final int i() throws IOException {
        int i = this.k;
        if (this.i - i < 4) {
            S(4);
            i = this.k;
        }
        byte[] bArr = this.h;
        this.k = i + 4;
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int k() throws IOException {
        return i();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int l() throws IOException {
        return H(j());
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int m() throws IOException {
        if (C()) {
            this.l = 0;
            return 0;
        }
        int iJ = j();
        this.l = iJ;
        if (eu.a(iJ) != 0) {
            return iJ;
        }
        throw new cc("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int n() throws IOException {
        return j();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long o() throws IOException {
        return q();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long p() throws IOException {
        return r();
    }

    public final long q() throws IOException {
        int i = this.k;
        if (this.i - i < 8) {
            S(8);
            i = this.k;
        }
        byte[] bArr = this.h;
        this.k = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j4 = bArr[i + 3];
        return ((((long) bArr[i + 7]) & 255) << 56) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j4 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
    }

    final long s() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bA = a();
            j |= ((long) (bA & 127)) << i;
            if ((bA & 128) == 0) {
                return j;
            }
        }
        throw new cc("CodedInputStream encountered a malformed varint.");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long t() throws IOException {
        return q();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long u() throws IOException {
        return I(r());
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long v() throws IOException {
        return r();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final x w() throws IOException {
        int iJ = j();
        int i = this.i;
        int i2 = this.k;
        if (iJ <= i - i2 && iJ > 0) {
            x xVarU = x.u(this.h, i2, iJ);
            this.k += iJ;
            return xVarU;
        }
        if (iJ == 0) {
            return x.b;
        }
        if (iJ < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArrU = U(iJ);
        if (bArrU != null) {
            return x.t(bArrU);
        }
        int i3 = this.k;
        int i4 = this.i;
        int i5 = i4 - i3;
        this.m += i4;
        this.k = 0;
        this.i = 0;
        List<byte[]> listQ = Q(iJ - i5);
        byte[] bArr = new byte[iJ];
        System.arraycopy(this.h, i3, bArr, 0, i5);
        for (byte[] bArr2 : listQ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        x xVar = x.b;
        return new v(bArr);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final String x() throws IOException {
        int iJ = j();
        if (iJ > 0) {
            int i = this.i;
            int i2 = this.k;
            if (iJ <= i - i2) {
                String str = new String(this.h, i2, iJ, ca.a);
                this.k += iJ;
                return str;
            }
        }
        if (iJ == 0) {
            return "";
        }
        if (iJ < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (iJ > this.i) {
            return new String(V(iJ), ca.a);
        }
        S(iJ);
        String str2 = new String(this.h, this.k, iJ, ca.a);
        this.k += iJ;
        return str2;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final String y() throws IOException {
        byte[] bArrV;
        int iJ = j();
        int i = this.k;
        int i2 = this.i;
        if (iJ <= i2 - i && iJ > 0) {
            bArrV = this.h;
            this.k = i + iJ;
        } else {
            if (iJ == 0) {
                return "";
            }
            if (iJ < 0) {
                throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            i = 0;
            if (iJ <= i2) {
                S(iJ);
                bArrV = this.h;
                this.k = iJ;
            } else {
                bArrV = V(iJ);
            }
        }
        return er.h(bArrV, i, iJ);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final void z(int i) throws cc {
        if (this.l != i) {
            throw new cc("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int e(int i) throws cc {
        if (i < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = i + this.m + this.k;
        if (i2 < 0) {
            throw new cc("Failed to parse the message.");
        }
        int i3 = this.f241n;
        if (i2 > i3) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.f241n = i2;
        R();
        return i3;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int j() throws IOException {
        int i;
        int i2 = this.k;
        int i3 = this.i;
        if (i3 != i2) {
            byte[] bArr = this.h;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.k = i4;
                return b;
            }
            if (i3 - i4 >= 9) {
                int i5 = i2 + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    i = i6 ^ (-128);
                } else {
                    int i7 = i2 + 3;
                    int i8 = (bArr[i5] << Ascii.SO) ^ i6;
                    if (i8 >= 0) {
                        i = i8 ^ 16256;
                    } else {
                        int i9 = i2 + 4;
                        int i10 = i8 ^ (bArr[i7] << Ascii.NAK);
                        if (i10 < 0) {
                            i = (-2080896) ^ i10;
                        } else {
                            i7 = i2 + 5;
                            byte b2 = bArr[i9];
                            int i11 = (i10 ^ (b2 << Ascii.FS)) ^ 266354560;
                            if (b2 < 0) {
                                i9 = i2 + 6;
                                if (bArr[i7] < 0) {
                                    i7 = i2 + 7;
                                    if (bArr[i9] < 0) {
                                        i9 = i2 + 8;
                                        if (bArr[i7] < 0) {
                                            i7 = i2 + 9;
                                            if (bArr[i9] < 0) {
                                                int i12 = i2 + 10;
                                                if (bArr[i7] >= 0) {
                                                    i5 = i12;
                                                    i = i11;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i11;
                            }
                            i = i11;
                        }
                        i5 = i9;
                    }
                    i5 = i7;
                }
                this.k = i5;
                return i;
            }
        }
        return (int) s();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long r() throws IOException {
        long j;
        long j2;
        int i = this.k;
        int i2 = this.i;
        if (i2 != i) {
            byte[] bArr = this.h;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.k = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ (-128);
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            long j3 = (-2080896) ^ i9;
                            i4 = i8;
                            j = j3;
                        } else {
                            i6 = i + 5;
                            long j4 = (((long) bArr[i8]) << 28) ^ ((long) i9);
                            if (j4 >= 0) {
                                j = j4 ^ 266354560;
                            } else {
                                i4 = i + 6;
                                long j5 = (((long) bArr[i6]) << 35) ^ j4;
                                if (j5 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    int i10 = i + 7;
                                    long j6 = j5 ^ (((long) bArr[i4]) << 42);
                                    if (j6 >= 0) {
                                        j = j6 ^ 4363953127296L;
                                    } else {
                                        i4 = i + 8;
                                        j5 = j6 ^ (((long) bArr[i10]) << 49);
                                        if (j5 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i10 = i + 9;
                                            long j7 = (j5 ^ (((long) bArr[i4]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i4 = i + 10;
                                                if (bArr[i10] >= 0) {
                                                    j = j7;
                                                }
                                            } else {
                                                j = j7;
                                            }
                                        }
                                    }
                                    i4 = i10;
                                }
                                j = j5 ^ j2;
                            }
                        }
                    }
                    i4 = i6;
                }
                this.k = i4;
                return j;
            }
        }
        return s();
    }
}
