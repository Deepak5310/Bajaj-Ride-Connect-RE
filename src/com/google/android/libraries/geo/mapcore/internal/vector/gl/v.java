package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.google.android.libraries.geo.mapcore.renderer.bq;
import com.google.android.libraries.geo.mapcore.renderer.fb;
import com.google.android.libraries.geo.mapcore.renderer.ff;
import com.google.android.libraries.navigation.internal.agg.de;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    private static final ByteBuffer j = ByteBuffer.allocate(0);
    private static final com.google.android.libraries.navigation.internal.fq.o k = new u();
    public boolean b;
    int c;
    public int e;
    public int g;
    private com.google.android.libraries.navigation.internal.agj.o l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private bq f73n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private byte[] u;
    private int v;
    private int x;
    private float y;
    private int m = 0;
    private int A = 1;
    private int B = 1;
    private int C = 1;
    private int D = 1;
    public final byte[] d = new byte[8];
    public int f = 0;
    private int w = 0;
    public float h = 1.0f;
    private final de z = new de();
    public ByteBuffer i = j;
    public String a = "unused";

    public static v b(String str, int i, int i2, boolean z, int i3, boolean z2, bq bqVar) {
        v vVar;
        int i4;
        com.google.android.libraries.navigation.internal.fq.o oVar = k;
        synchronized (oVar) {
            vVar = (v) oVar.c();
            vVar.a = str;
            vVar.g = i2;
            vVar.t = z;
            vVar.b = z2;
            vVar.f73n = bqVar;
            if ((i2 & 2) != 0) {
                i4 = 1;
            } else {
                i4 = (i2 & 1) != 0 ? 2 : 0;
            }
            vVar.m = i4;
            vVar.x = i3;
            vVar.h = 1.0f;
            vVar.y = i3 < 0 ? 1 << (-i3) : 1.0f / (1 << i3);
            if (i3 > 0) {
                vVar.h = 1.0f / (1 << i3);
            }
            boolean z3 = (i2 & 16) != 0;
            vVar.o = z3;
            boolean z4 = (i2 & 8) != 0;
            vVar.q = z4;
            boolean z5 = (i2 & 32) != 0;
            vVar.p = z5;
            if ((i2 & 2176) == 0) {
                vVar.A = 1;
            } else if ((i2 & 128) != 0) {
                vVar.A = 2;
            }
            if ((i2 & FujifilmMakernoteDirectory.TAG_AUTO_BRACKETING) == 0) {
                vVar.B = 1;
            } else if ((i2 & 256) != 0) {
                vVar.B = 2;
            }
            if ((i2 & 8704) == 0) {
                vVar.C = 1;
            } else if ((i2 & 512) != 0) {
                vVar.C = 2;
            }
            if ((i2 & 17408) == 0) {
                vVar.D = 1;
            } else if ((i2 & 1024) != 0) {
                vVar.D = 2;
            }
            vVar.r = (32768 & i2) != 0;
            int i5 = i2 & 64;
            vVar.s = i5 != 0;
            if (i4 == 1) {
                int i6 = i5 != 0 ? 2 : 4;
                vVar.c = i6 + i6;
            } else if (i4 == 2) {
                vVar.c = (i5 != 0 ? 2 : 3) * 4;
            }
            if (z4) {
                vVar.c += 16;
            } else if (z5) {
                vVar.c += 4;
            }
            if (z3) {
                vVar.c += 8;
            }
            int i7 = vVar.c;
            vVar.v = i7;
            if (vVar.A == 2) {
                vVar.c = i7 + 4;
            }
            if (vVar.B == 2) {
                vVar.c += 4;
            }
            int i8 = vVar.c;
            vVar.e = i8;
            if (vVar.C == 2) {
                i8 += 4;
                vVar.c = i8;
            }
            if (vVar.D == 2) {
                i8 += 4;
                vVar.c = i8;
            }
            vVar.u = new byte[i8];
            if (z && vVar.l == null) {
                vVar.l = new com.google.android.libraries.navigation.internal.agj.o(i / 2);
            }
            vVar.n(i);
        }
        return vVar;
    }

    private final float p(float f) {
        return f * this.y;
    }

    private final int q(int i) {
        int i2 = this.x;
        return i2 <= 0 ? i << (-i2) : i >> i2;
    }

    private final short r(int i) {
        int i2 = this.x;
        return (short) (i2 <= 0 ? i << (-i2) : i >> i2);
    }

    public final int a() {
        return this.z.b;
    }

    public final ff c(int i) {
        short[] sArr;
        j();
        byte[] bArrArray = this.i.array();
        String str = this.a;
        int i2 = this.f;
        int i3 = this.g;
        int i4 = this.c;
        if (this.t) {
            com.google.android.libraries.navigation.internal.agj.o oVar = this.l;
            ar.q(oVar);
            sArr = new short[oVar.b];
            System.arraycopy(oVar.a, 0, sArr, 0, oVar.b);
        } else {
            sArr = null;
        }
        ff ffVar = new ff(str, new fb(bArrArray, i2, i4), i3, i, sArr, this.w, this.f73n);
        h();
        return ffVar;
    }

    public final void d(ByteBuffer byteBuffer, float f, float f2, float f3) {
        if (this.m != 1) {
            byteBuffer.putFloat(p(f));
            byteBuffer.putFloat(p(f2));
            if (this.s) {
                return;
            }
            byteBuffer.putFloat(p(f3));
            return;
        }
        byteBuffer.putShort(r((int) f));
        byteBuffer.putShort(r((int) f2));
        if (this.s) {
            return;
        }
        byteBuffer.putShort(r((int) f3));
        byteBuffer.putShort((short) 0);
    }

    public final void e(int i, int i2, int i3) {
        com.google.android.libraries.navigation.internal.agj.o oVar = this.l;
        ar.q(oVar);
        oVar.i((short) i);
        oVar.i((short) i2);
        oVar.i((short) i3);
        this.w += 3;
    }

    public final void f(float f, float f2, float f3, int i, int i2) {
        this.i.putFloat(f);
        this.i.putFloat(f2);
        this.i.putFloat(f3);
        this.i.putFloat(i);
        this.i.putFloat(i2);
        this.f++;
    }

    public final void g(x xVar, float f, float f2) {
        if (this.m == 1) {
            this.i.putShort(r(xVar.a));
            this.i.putShort(r(xVar.b));
            if (!this.s) {
                this.i.putShort(this.r ? r(xVar.c) : (short) xVar.c);
                this.i.putShort((short) 0);
            }
        } else {
            this.i.putFloat(q(xVar.a));
            this.i.putFloat(q(xVar.b));
            if (!this.s) {
                this.i.putFloat(xVar.c);
            }
        }
        this.i.putFloat(f);
        this.i.putFloat(f2);
        this.f++;
    }

    public final void h() {
        com.google.android.libraries.navigation.internal.agj.o oVar = this.l;
        if (oVar != null) {
            oVar.clear();
        }
        this.w = 0;
        this.f = 0;
        this.z.clear();
        this.i = j;
    }

    public final void i(byte[] bArr) {
        this.i.put(bArr);
        this.f += bArr.length / this.c;
        j();
    }

    public final void j() {
        this.z.c(this.f);
    }

    public final void k() {
        this.i.position(this.i.position() - this.c);
        this.i.get(this.u);
        this.i.put(this.u);
        this.f++;
    }

    public final void l() {
        h();
        com.google.android.libraries.navigation.internal.fq.o oVar = k;
        synchronized (oVar) {
            oVar.g(this);
        }
    }

    public final void m(int i, byte[] bArr) {
        int i2 = this.v + 2;
        while (i2 < bArr.length) {
            bArr[i2] = (byte) i;
            i2 += this.c;
        }
    }

    public final boolean n(int i) {
        ByteBuffer byteBuffer = this.i;
        ar.q(byteBuffer);
        if (byteBuffer.capacity() == 0) {
            this.i = ByteBuffer.allocate(this.c * i).order(ByteOrder.nativeOrder());
            return true;
        }
        if (this.c * i <= byteBuffer.capacity()) {
            return true;
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(this.c * i).order(ByteOrder.nativeOrder());
        if (byteBuffer.position() != 0) {
            byteBuffer.rewind();
            byteBufferOrder.put(byteBuffer);
        }
        this.i = byteBufferOrder;
        return false;
    }

    public final byte[] o(int i) {
        int iN = i == 0 ? 0 : this.z.n(i - 1);
        int iN2 = this.z.n(i);
        int i2 = this.c;
        int i3 = i2 * iN;
        byte[] bArr = new byte[i2 * (iN2 - iN)];
        int iPosition = this.i.position();
        this.i.position(i3);
        this.i.get(bArr);
        this.i.position(iPosition);
        return bArr;
    }
}
