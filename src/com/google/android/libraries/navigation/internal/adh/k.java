package com.google.android.libraries.navigation.internal.adh;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class k {
    public static final Charset r = Charset.forName("UTF-8");
    protected static final byte[] s = new byte[0];
    public byte[] t = s;

    public static int j(byte[] bArr, i iVar) {
        int i = iVar.a;
        iVar.a = i + 1;
        return bArr[i] & 255;
    }

    public static int k(byte[] bArr, i iVar) {
        int i = iVar.a;
        iVar.a = i + 4;
        return (bArr[i] & 255) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static int l(byte[] bArr, i iVar) {
        int iJ = j(bArr, iVar);
        if (iJ < 128) {
            return iJ;
        }
        int iJ2 = j(bArr, iVar);
        int i = (iJ & 127) | ((iJ2 & 127) << 7);
        if (iJ2 < 128) {
            return i;
        }
        int iJ3 = j(bArr, iVar);
        int i2 = i | ((iJ3 & 127) << 14);
        if (iJ3 < 128) {
            return i2;
        }
        int iJ4 = j(bArr, iVar);
        int i3 = i2 | ((iJ4 & 127) << 21);
        if (iJ4 < 128) {
            return i3;
        }
        int iJ5 = j(bArr, iVar);
        int i4 = i3 | ((iJ5 & 127) << 28);
        if (iJ5 >= 128) {
            while (iJ5 >= 128) {
                iJ5 = j(bArr, iVar);
            }
        }
        return i4;
    }

    public static long m(byte[] bArr, i iVar) {
        int i = iVar.a;
        iVar.a = i + 8;
        return (((long) bArr[i]) & 255) | ((bArr[i + 7] & 255) << 56) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    public static long n(byte[] bArr, i iVar) {
        long j = j(bArr, iVar);
        if (j < 128) {
            return j;
        }
        long j2 = j & 127;
        int i = 7;
        while (true) {
            long j3 = j(bArr, iVar);
            j2 |= (j3 & 127) << i;
            if (j3 < 128) {
                return j2;
            }
            i += 7;
        }
    }

    public void b() {
        this.t = s;
    }

    protected void c(int i, int i2, int i3) {
        throw null;
    }

    protected boolean h(int i) {
        return false;
    }

    protected boolean i(int i) {
        return false;
    }

    public final void o(byte[] bArr, int i) throws IndexOutOfBoundsException {
        int i2;
        if (this.t == bArr) {
            return;
        }
        b();
        this.t = bArr;
        i iVar = new i(0);
        int i3 = 0;
        int i4 = 0;
        int iL = 0;
        while (true) {
            i2 = iVar.a;
            if (i2 >= i) {
                break;
            }
            int iL2 = l(bArr, iVar);
            i4 = iL2 & 7;
            i3 = iL2 >> 3;
            if (i4 == 0) {
                if (h(i3)) {
                    n(bArr, iVar);
                    i(i3);
                } else {
                    l(bArr, iVar);
                    q(i3);
                }
                iL = 0;
            } else if (i4 == 1) {
                m(bArr, iVar);
                i(i3);
                iL = 8;
            } else if (i4 == 2) {
                iL = l(bArr, iVar);
                c(i3, iVar.a, iL);
                iVar.a += iL;
            } else if (i4 == 5) {
                k(bArr, iVar);
                iL = 4;
            }
        }
        if (i2 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("Proto parsing overran buffer (ended at " + i2 + ", past " + i + ", last tag was " + i3 + " of type " + i4 + " with length " + iL + ")");
    }

    public final long p(int i, int i2) {
        i iVar = new i(i);
        while (iVar.a < i + i2) {
            int iL = l(this.t, iVar);
            int i3 = iL & 7;
            int i4 = iL >> 3;
            if (i3 == 0) {
                long jN = n(this.t, iVar);
                if (i4 == 1) {
                    return jN;
                }
            } else if (i3 != 1) {
                if (i3 == 2) {
                    iVar.a += l(this.t, iVar);
                } else if (i3 != 5) {
                    continue;
                } else {
                    if (i4 == 1) {
                        return k(this.t, iVar);
                    }
                    iVar.a += 4;
                }
            } else {
                if (i4 == 1) {
                    return m(this.t, iVar);
                }
                iVar.a += 8;
            }
        }
        return -1L;
    }

    protected boolean q(int i) {
        return false;
    }
}
