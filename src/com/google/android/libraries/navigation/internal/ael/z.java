package com.google.android.libraries.navigation.internal.ael;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z extends ac {
    private final Iterable a;
    private final Iterator h;
    private ByteBuffer i;
    private int j;
    private int k;
    private int m;
    private long o;
    private long p;
    private long q;
    private long r;
    private int l = Integer.MAX_VALUE;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f246n = 0;

    public z(Iterable iterable, int i) {
        this.j = i;
        this.a = iterable;
        this.h = iterable.iterator();
        if (i != 0) {
            T();
            return;
        }
        this.i = ca.c;
        this.o = 0L;
        this.p = 0L;
        this.r = 0L;
        this.q = 0L;
    }

    private final int G() {
        return (int) ((((long) (this.j - this.f246n)) - this.o) + this.p);
    }

    private final long Q() {
        return this.r - this.o;
    }

    private final void R() throws cc {
        if (!this.h.hasNext()) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        T();
    }

    private final void S() {
        int i = this.j + this.k;
        this.j = i;
        int i2 = this.l;
        if (i <= i2) {
            this.k = 0;
            return;
        }
        int i3 = i - i2;
        this.k = i3;
        this.j = i - i3;
    }

    private final void T() {
        ByteBuffer byteBuffer = (ByteBuffer) this.h.next();
        this.i = byteBuffer;
        this.f246n += (int) (this.o - this.p);
        long jPosition = byteBuffer.position();
        this.o = jPosition;
        this.p = jPosition;
        this.r = this.i.limit();
        long jG = em.g(this.i);
        this.q = jG;
        this.o += jG;
        this.p += jG;
        this.r += jG;
    }

    private final void U(byte[] bArr, int i) throws IOException {
        if (i > G()) {
            if (i > 0) {
                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            return;
        }
        int i2 = i;
        while (i2 > 0) {
            if (Q() == 0) {
                R();
            }
            int iMin = Math.min(i2, (int) Q());
            long j = iMin;
            em.m(this.o, bArr, i - i2, j);
            i2 -= iMin;
            this.o += j;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final void A(int i) {
        this.l = i;
        S();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean C() throws IOException {
        return (((long) this.f246n) + this.o) - this.p == ((long) this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean D() throws IOException {
        return r() != 0;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean E(int i) throws IOException {
        int iB = eu.b(i);
        if (iB == 0) {
            for (int i2 = 0; i2 < 10; i2++) {
                if (a() >= 0) {
                    return true;
                }
            }
            throw new cc("CodedInputStream encountered a malformed varint.");
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
        if (iJ >= 0) {
            long j = iJ;
            if (j <= Q()) {
                byte[] bArr = new byte[iJ];
                em.m(this.o, bArr, 0L, j);
                this.o += j;
                return bArr;
            }
        }
        if (iJ >= 0 && iJ <= G()) {
            byte[] bArr2 = new byte[iJ];
            U(bArr2, iJ);
            return bArr2;
        }
        if (iJ > 0) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (iJ == 0) {
            return ca.b;
        }
        throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public final byte a() throws IOException {
        if (Q() == 0) {
            R();
        }
        long j = this.o;
        this.o = 1 + j;
        return em.a(j);
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
        return (int) ((((long) this.f246n) + this.o) - this.p);
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
        if (Q() < 4) {
            int iA = a() & 255;
            int iA2 = (a() & 255) << 8;
            return iA | iA2 | ((a() & 255) << 16) | ((a() & 255) << 24);
        }
        long j = this.o;
        this.o = 4 + j;
        int iA3 = em.a(j) & 255;
        int iA4 = (em.a(1 + j) & 255) << 8;
        return ((em.a(j + 3) & 255) << 24) | iA3 | iA4 | ((em.a(2 + j) & 255) << 16);
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
            this.m = 0;
            return 0;
        }
        int iJ = j();
        this.m = iJ;
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
        long jA;
        long j;
        if (Q() >= 8) {
            long j2 = this.o;
            this.o = 8 + j2;
            long jA2 = ((long) em.a(j2)) & 255;
            long jA3 = (((long) em.a(1 + j2)) & 255) << 8;
            long jA4 = (((long) em.a(2 + j2)) & 255) << 16;
            long jA5 = (((long) em.a(3 + j2)) & 255) << 24;
            long jA6 = (((long) em.a(j2 + 4)) & 255) << 32;
            long jA7 = (((long) em.a(j2 + 5)) & 255) << 40;
            long jA8 = (((long) em.a(j2 + 6)) & 255) << 48;
            jA = (((long) em.a(j2 + 7)) & 255) << 56;
            j = jA2 | jA3 | jA4 | jA5 | jA6 | jA7 | jA8;
        } else {
            long jA9 = ((long) a()) & 255;
            long jA10 = (((long) a()) & 255) << 8;
            long jA11 = (((long) a()) & 255) << 16;
            long jA12 = (((long) a()) & 255) << 24;
            long jA13 = (((long) a()) & 255) << 32;
            long jA14 = (((long) a()) & 255) << 40;
            long jA15 = (((long) a()) & 255) << 48;
            jA = (((long) a()) & 255) << 56;
            j = jA9 | jA10 | jA11 | jA12 | jA13 | jA14 | jA15;
        }
        return j | jA;
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
            long j = this.r;
            long j2 = this.o;
            long j3 = iJ;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[iJ];
                em.m(j2, bArr, 0L, j3);
                this.o += j3;
                x xVar = x.b;
                return new v(bArr);
            }
        }
        if (iJ > 0 && iJ <= G()) {
            byte[] bArr2 = new byte[iJ];
            U(bArr2, iJ);
            x xVar2 = x.b;
            return new v(bArr2);
        }
        if (iJ == 0) {
            return x.b;
        }
        if (iJ < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final String x() throws IOException {
        int iJ = j();
        if (iJ > 0) {
            long j = this.r;
            long j2 = this.o;
            long j3 = iJ;
            if (j3 <= j - j2) {
                byte[] bArr = new byte[iJ];
                em.m(j2, bArr, 0L, j3);
                String str = new String(bArr, ca.a);
                this.o += j3;
                return str;
            }
        }
        if (iJ > 0 && iJ <= G()) {
            byte[] bArr2 = new byte[iJ];
            U(bArr2, iJ);
            return new String(bArr2, ca.a);
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
            long j = this.r;
            long j2 = this.o;
            long j3 = iJ;
            if (j3 <= j - j2) {
                String strG = er.g(this.i, (int) (j2 - this.p), iJ);
                this.o += j3;
                return strG;
            }
        }
        if (iJ >= 0 && iJ <= G()) {
            byte[] bArr = new byte[iJ];
            U(bArr, iJ);
            return er.h(bArr, 0, iJ);
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
        if (this.m != i) {
            throw new cc("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int e(int i) throws cc {
        if (i < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iD = i + d();
        int i2 = this.l;
        if (iD > i2) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.l = iD;
        S();
        return i2;
    }

    public final void B(int i) throws IOException {
        if (i >= 0) {
            if (i <= (((long) (this.j - this.f246n)) - this.o) + this.p) {
                while (i > 0) {
                    if (Q() == 0) {
                        R();
                    }
                    int iMin = Math.min(i, (int) Q());
                    i -= iMin;
                    this.o += (long) iMin;
                }
                return;
            }
        }
        if (i >= 0) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int j() throws IOException {
        int i;
        long j = this.o;
        if (this.r != j) {
            long j2 = j + 1;
            byte bA = em.a(j);
            if (bA >= 0) {
                this.o++;
                return bA;
            }
            if (this.r - this.o >= 10) {
                long j3 = 2 + j;
                int iA = (em.a(j2) << 7) ^ bA;
                if (iA < 0) {
                    i = iA ^ (-128);
                } else {
                    long j4 = 3 + j;
                    int iA2 = (em.a(j3) << Ascii.SO) ^ iA;
                    if (iA2 >= 0) {
                        i = iA2 ^ 16256;
                    } else {
                        long j5 = 4 + j;
                        int iA3 = iA2 ^ (em.a(j4) << Ascii.NAK);
                        if (iA3 < 0) {
                            i = (-2080896) ^ iA3;
                        } else {
                            j4 = 5 + j;
                            byte bA2 = em.a(j5);
                            int i2 = (iA3 ^ (bA2 << Ascii.FS)) ^ 266354560;
                            if (bA2 < 0) {
                                j5 = 6 + j;
                                if (em.a(j4) < 0) {
                                    j4 = 7 + j;
                                    if (em.a(j5) < 0) {
                                        j5 = 8 + j;
                                        if (em.a(j4) < 0) {
                                            j4 = 9 + j;
                                            if (em.a(j5) < 0) {
                                                long j6 = j + 10;
                                                if (em.a(j4) >= 0) {
                                                    i = i2;
                                                    j3 = j6;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i2;
                            }
                            i = i2;
                        }
                        j3 = j5;
                    }
                    j3 = j4;
                }
                this.o = j3;
                return i;
            }
        }
        return (int) s();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long r() throws IOException {
        long j;
        long j2;
        long j3 = this.o;
        if (this.r != j3) {
            long j4 = j3 + 1;
            byte bA = em.a(j3);
            if (bA >= 0) {
                this.o++;
                return bA;
            }
            if (this.r - this.o >= 10) {
                long j5 = 2 + j3;
                int iA = (em.a(j4) << 7) ^ bA;
                if (iA < 0) {
                    j = iA ^ (-128);
                } else {
                    long j6 = 3 + j3;
                    int iA2 = (em.a(j5) << Ascii.SO) ^ iA;
                    if (iA2 >= 0) {
                        j = iA2 ^ 16256;
                    } else {
                        long j7 = 4 + j3;
                        int iA3 = iA2 ^ (em.a(j6) << Ascii.NAK);
                        if (iA3 < 0) {
                            j = (-2080896) ^ iA3;
                            j5 = j7;
                        } else {
                            j6 = 5 + j3;
                            long jA = (((long) em.a(j7)) << 28) ^ ((long) iA3);
                            if (jA >= 0) {
                                j = 266354560 ^ jA;
                            } else {
                                long j8 = 6 + j3;
                                long jA2 = jA ^ (((long) em.a(j6)) << 35);
                                if (jA2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    long j9 = 7 + j3;
                                    long jA3 = jA2 ^ (((long) em.a(j8)) << 42);
                                    if (jA3 >= 0) {
                                        j = 4363953127296L ^ jA3;
                                    } else {
                                        j8 = 8 + j3;
                                        jA2 = jA3 ^ (((long) em.a(j9)) << 49);
                                        if (jA2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j9 = 9 + j3;
                                            long jA4 = (jA2 ^ (((long) em.a(j8)) << 56)) ^ 71499008037633920L;
                                            if (jA4 < 0) {
                                                long j10 = j3 + 10;
                                                if (em.a(j9) >= 0) {
                                                    j = jA4;
                                                    j5 = j10;
                                                }
                                            } else {
                                                j = jA4;
                                            }
                                        }
                                    }
                                    j5 = j9;
                                }
                                j = j2 ^ jA2;
                                j5 = j8;
                            }
                        }
                    }
                    j5 = j6;
                }
                this.o = j5;
                return j;
            }
        }
        return s();
    }
}
