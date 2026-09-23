package com.google.android.libraries.navigation.internal.ael;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends ac {
    private final byte[] a;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m = Integer.MAX_VALUE;

    public y(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.h = i2 + i;
        this.j = i;
        this.k = i;
    }

    private final void Q() {
        int i = this.h + this.i;
        this.h = i;
        int i2 = i - this.k;
        int i3 = this.m;
        if (i2 <= i3) {
            this.i = 0;
            return;
        }
        int i4 = i2 - i3;
        this.i = i4;
        this.h = i - i4;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final void A(int i) {
        this.m = i;
        Q();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean C() throws IOException {
        return this.j == this.h;
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
            if (this.h - this.j < 10) {
                while (i2 < 10) {
                    if (a() < 0) {
                        i2++;
                    }
                }
                throw new cc("CodedInputStream encountered a malformed varint.");
            }
            while (i2 < 10) {
                byte[] bArr = this.a;
                int i3 = this.j;
                this.j = i3 + 1;
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
        return G(j());
    }

    public final byte a() throws IOException {
        int i = this.j;
        if (i == this.h) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.a;
        this.j = i + 1;
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
        return this.j - this.k;
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
        int i = this.j;
        if (this.h - i < 4) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.a;
        this.j = i + 4;
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
        int i = this.j;
        if (this.h - i < 8) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.a;
        this.j = i + 8;
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
        if (iJ > 0) {
            int i = this.h;
            int i2 = this.j;
            if (iJ <= i - i2) {
                x xVarU = x.u(this.a, i2, iJ);
                this.j += iJ;
                return xVarU;
            }
        }
        if (iJ == 0) {
            return x.b;
        }
        byte[] bArrG = G(iJ);
        x xVar = x.b;
        return new v(bArrG);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final String x() throws IOException {
        int iJ = j();
        if (iJ > 0) {
            int i = this.h;
            int i2 = this.j;
            if (iJ <= i - i2) {
                String str = new String(this.a, i2, iJ, ca.a);
                this.j += iJ;
                return str;
            }
        }
        if (iJ == 0) {
            return "";
        }
        if (iJ < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final String y() throws IOException {
        int iJ = j();
        if (iJ > 0) {
            int i = this.h;
            int i2 = this.j;
            if (iJ <= i - i2) {
                String strH = er.h(this.a, i2, iJ);
                this.j += iJ;
                return strH;
            }
        }
        if (iJ == 0) {
            return "";
        }
        if (iJ <= 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
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
        int iD = i + d();
        if (iD < 0) {
            throw new cc("Failed to parse the message.");
        }
        int i2 = this.m;
        if (iD > i2) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.m = iD;
        Q();
        return i2;
    }

    public final void B(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.h;
            int i3 = this.j;
            if (i <= i2 - i3) {
                this.j = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final byte[] G(int i) throws IOException {
        if (i > 0) {
            int i2 = this.h;
            int i3 = this.j;
            if (i <= i2 - i3) {
                int i4 = i + i3;
                this.j = i4;
                return Arrays.copyOfRange(this.a, i3, i4);
            }
        }
        if (i > 0) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i == 0) {
            return ca.b;
        }
        throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int j() throws IOException {
        int i;
        int i2 = this.j;
        int i3 = this.h;
        if (i3 != i2) {
            byte[] bArr = this.a;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.j = i4;
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
                this.j = i5;
                return i;
            }
        }
        return (int) s();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long r() throws IOException {
        long j;
        long j2;
        int i = this.j;
        int i2 = this.h;
        if (i2 != i) {
            byte[] bArr = this.a;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.j = i3;
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
                this.j = i4;
                return j;
            }
        }
        return s();
    }
}
