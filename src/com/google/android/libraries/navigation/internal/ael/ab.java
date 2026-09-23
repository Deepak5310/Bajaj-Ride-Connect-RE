package com.google.android.libraries.navigation.internal.ael;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ab extends ac {
    public static final /* synthetic */ int a = 0;
    private final ByteBuffer h;
    private final long i;
    private long j;
    private long k;
    private long l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f242n;
    private int o = Integer.MAX_VALUE;

    public ab(ByteBuffer byteBuffer) {
        this.h = byteBuffer.duplicate();
        long jG = em.g(byteBuffer);
        this.i = jG;
        this.j = ((long) byteBuffer.limit()) + jG;
        long jPosition = jG + ((long) byteBuffer.position());
        this.k = jPosition;
        this.l = jPosition;
    }

    private final int G(long j) {
        return (int) (j - this.i);
    }

    private final int Q() {
        return (int) (this.j - this.k);
    }

    private final void R() {
        long j = this.j + ((long) this.m);
        this.j = j;
        int i = (int) (j - this.l);
        int i2 = this.o;
        if (i <= i2) {
            this.m = 0;
            return;
        }
        int i3 = i - i2;
        this.m = i3;
        this.j = j - ((long) i3);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final void A(int i) {
        this.o = i;
        R();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final boolean C() throws IOException {
        return this.k == this.j;
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
            if (Q() < 10) {
                while (i2 < 10) {
                    if (a() < 0) {
                        i2++;
                    }
                }
                throw new cc("CodedInputStream encountered a malformed varint.");
            }
            while (i2 < 10) {
                long j = this.k;
                this.k = 1 + j;
                if (em.a(j) < 0) {
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

    /* JADX WARN: Bottom block not found for handler: all -> 0x0042 */
    @Override // com.google.android.libraries.navigation.internal.ael.ac
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final byte[] F() throws IOException {
        int iJ = j();
        if (iJ < 0 || iJ > Q()) {
            if (iJ > 0) {
                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (iJ == 0) {
                return ca.b;
            }
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        byte[] bArr = new byte[iJ];
        long j = this.k;
        long j2 = iJ;
        long j3 = j + j2;
        ByteBuffer byteBuffer = this.h;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        try {
            byteBuffer.position(G(j));
            byteBuffer.limit(G(j3));
            ByteBuffer byteBufferSlice = this.h.slice();
            byteBuffer.position(iPosition);
            byteBuffer.limit(iLimit);
            byteBufferSlice.get(bArr);
            this.k += j2;
            return bArr;
        } catch (IllegalArgumentException e) {
            cc ccVar = new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            ccVar.initCause(e);
            throw ccVar;
        }
    }

    public final byte a() throws IOException {
        long j = this.k;
        if (j == this.j) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.k = 1 + j;
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
        return (int) (this.k - this.l);
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
        long j = this.k;
        if (this.j - j < 4) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.k = 4 + j;
        int iA = em.a(j) & 255;
        int iA2 = em.a(1 + j) & 255;
        int iA3 = em.a(2 + j) & 255;
        return ((em.a(j + 3) & 255) << 24) | (iA2 << 8) | iA | (iA3 << 16);
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
            this.f242n = 0;
            return 0;
        }
        int iJ = j();
        this.f242n = iJ;
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
        long j = this.k;
        if (this.j - j < 8) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.k = 8 + j;
        long jA = em.a(j);
        long jA2 = em.a(1 + j);
        long jA3 = em.a(2 + j);
        long jA4 = em.a(3 + j);
        long jA5 = em.a(4 + j);
        return ((((long) em.a(j + 7)) & 255) << 56) | (jA & 255) | ((jA2 & 255) << 8) | ((jA3 & 255) << 16) | ((jA4 & 255) << 24) | ((jA5 & 255) << 32) | ((em.a(5 + j) & 255) << 40) | ((em.a(6 + j) & 255) << 48);
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
        if (iJ <= 0 || iJ > Q()) {
            if (iJ == 0) {
                return x.b;
            }
            if (iJ < 0) {
                throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = new byte[iJ];
        long j = iJ;
        em.m(this.k, bArr, 0L, j);
        this.k += j;
        x xVar = x.b;
        return new v(bArr);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final String x() throws IOException {
        int iJ = j();
        if (iJ <= 0 || iJ > Q()) {
            if (iJ == 0) {
                return "";
            }
            if (iJ < 0) {
                throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = new byte[iJ];
        long j = iJ;
        em.m(this.k, bArr, 0L, j);
        String str = new String(bArr, ca.a);
        this.k += j;
        return str;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final String y() throws IOException {
        int iJ = j();
        if (iJ > 0 && iJ <= Q()) {
            String strG = er.g(this.h, G(this.k), iJ);
            this.k += (long) iJ;
            return strG;
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
        if (this.f242n != i) {
            throw new cc("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final int e(int i) throws cc {
        if (i < 0) {
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int iD = i + d();
        int i2 = this.o;
        if (iD > i2) {
            throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.o = iD;
        R();
        return i2;
    }

    public final void B(int i) throws IOException {
        if (i >= 0 && i <= Q()) {
            this.k += (long) i;
        } else {
            if (i >= 0) {
                throw new cc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            throw new cc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0089, code lost:
    
        if (com.google.android.libraries.navigation.internal.ael.em.a(r3) >= 0) goto L33;
     */
    @Override // com.google.android.libraries.navigation.internal.ael.ac
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int j() throws IOException {
        int i;
        long j = this.k;
        if (this.j != j) {
            long j2 = 1 + j;
            byte bA = em.a(j);
            if (bA >= 0) {
                this.k = j2;
                return bA;
            }
            if (this.j - j2 >= 9) {
                long j3 = 2 + j;
                int iA = (em.a(j2) << 7) ^ bA;
                if (iA < 0) {
                    i = iA ^ (-128);
                } else {
                    long j4 = 3 + j;
                    int iA2 = iA ^ (em.a(j3) << Ascii.SO);
                    if (iA2 >= 0) {
                        i = iA2 ^ 16256;
                    } else {
                        j3 = 4 + j;
                        int iA3 = iA2 ^ (em.a(j4) << Ascii.NAK);
                        if (iA3 < 0) {
                            i = (-2080896) ^ iA3;
                        } else {
                            j4 = 5 + j;
                            byte bA2 = em.a(j3);
                            int i2 = (iA3 ^ (bA2 << Ascii.FS)) ^ 266354560;
                            if (bA2 < 0) {
                                j3 = 6 + j;
                                if (em.a(j4) < 0) {
                                    j4 = 7 + j;
                                    if (em.a(j3) < 0) {
                                        j3 = 8 + j;
                                        if (em.a(j4) < 0) {
                                            j4 = j + 9;
                                            if (em.a(j3) < 0) {
                                                j3 = 10 + j;
                                            }
                                        }
                                    }
                                }
                                i = i2;
                            }
                            i = i2;
                        }
                    }
                    j3 = j4;
                }
                this.k = j3;
                return i;
            }
        }
        return (int) s();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.ac
    public final long r() throws IOException {
        long j;
        long j2;
        int i;
        long j3 = this.k;
        if (this.j != j3) {
            long j4 = 1 + j3;
            byte bA = em.a(j3);
            if (bA >= 0) {
                this.k = j4;
                return bA;
            }
            if (this.j - j4 >= 9) {
                long j5 = 2 + j3;
                int iA = (em.a(j4) << 7) ^ bA;
                if (iA >= 0) {
                    long j6 = 3 + j3;
                    int iA2 = iA ^ (em.a(j5) << Ascii.SO);
                    if (iA2 < 0) {
                        j5 = 4 + j3;
                        int iA3 = iA2 ^ (em.a(j6) << Ascii.NAK);
                        if (iA3 < 0) {
                            i = (-2080896) ^ iA3;
                        } else {
                            j6 = 5 + j3;
                            long jA = (((long) em.a(j5)) << 28) ^ ((long) iA3);
                            if (jA >= 0) {
                                j = 266354560 ^ jA;
                            } else {
                                long j7 = 6 + j3;
                                long jA2 = (((long) em.a(j6)) << 35) ^ jA;
                                if (jA2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    j5 = j3 + 7;
                                    long jA3 = jA2 ^ (((long) em.a(j7)) << 42);
                                    if (jA3 >= 0) {
                                        j = 4363953127296L ^ jA3;
                                    } else {
                                        j7 = 8 + j3;
                                        jA2 = jA3 ^ (((long) em.a(j5)) << 49);
                                        if (jA2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            j5 = j3 + 9;
                                            long jA4 = (jA2 ^ (((long) em.a(j7)) << 56)) ^ 71499008037633920L;
                                            if (jA4 < 0) {
                                                long j8 = j3 + 10;
                                                if (em.a(j5) >= 0) {
                                                    j5 = j8;
                                                }
                                            }
                                            j = jA4;
                                        }
                                    }
                                }
                                j = j2 ^ jA2;
                                j5 = j7;
                            }
                        }
                        this.k = j5;
                        return j;
                    }
                    j = iA2 ^ 16256;
                    j5 = j6;
                    this.k = j5;
                    return j;
                }
                i = iA ^ (-128);
                j = i;
                this.k = j5;
                return j;
            }
        }
        return s();
    }
}
