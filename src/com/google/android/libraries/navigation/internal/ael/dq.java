package com.google.android.libraries.navigation.internal.ael;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dq extends x {
    static final int[] a = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, TypedValues.MotionType.TYPE_QUANTIZE_MOTIONSTEPS, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    public static final /* synthetic */ int h = 0;
    private static final long serialVersionUID = 1;
    public final int d;
    public final x e;
    public final x f;
    public final int g;
    private final int i;

    public dq(x xVar, x xVar2) {
        this.e = xVar;
        this.f = xVar2;
        int iD = xVar.d();
        this.i = iD;
        this.d = iD + xVar2.d();
        this.g = Math.max(xVar.f(), xVar2.f()) + 1;
    }

    private static x D(x xVar, x xVar2) {
        int iD = xVar.d();
        int iD2 = xVar2.d();
        byte[] bArr = new byte[iD + iD2];
        xVar.z(bArr, 0, 0, iD);
        xVar2.z(bArr, 0, iD, iD2);
        return new v(bArr);
    }

    static int c(int i) {
        int[] iArr = a;
        int length = iArr.length;
        if (i >= 47) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public static x g(x xVar, x xVar2) {
        if (xVar2.d() == 0) {
            return xVar;
        }
        if (xVar.d() == 0) {
            return xVar2;
        }
        int iD = xVar.d() + xVar2.d();
        if (iD < 128) {
            return D(xVar, xVar2);
        }
        if (xVar instanceof dq) {
            dq dqVar = (dq) xVar;
            if (dqVar.f.d() + xVar2.d() < 128) {
                return new dq(dqVar.e, D(dqVar.f, xVar2));
            }
            if (dqVar.e.f() > dqVar.f.f() && dqVar.g > xVar2.f()) {
                return new dq(dqVar.e, new dq(dqVar.f, xVar2));
            }
        }
        if (iD >= c(Math.max(xVar.f(), xVar2.f()) + 1)) {
            return new dq(xVar, xVar2);
        }
        dn dnVar = new dn();
        dnVar.a(xVar);
        dnVar.a(xVar2);
        x dqVar2 = (x) dnVar.a.pop();
        while (!dnVar.a.isEmpty()) {
            dqVar2 = new dq((x) dnVar.a.pop(), dqVar2);
        }
        return dqVar2;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        throw new InvalidObjectException("RopeByteStream instances are not to be serialized directly");
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final byte a(int i) {
        y(i, this.d);
        return b(i);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final byte b(int i) {
        int i2 = this.i;
        return i < i2 ? this.e.b(i) : this.f.b(i - i2);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final int d() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected final void e(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.i;
        if (i4 <= i5) {
            this.e.e(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.f.e(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.e.e(bArr, i, i2, i6);
            this.f.e(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final boolean equals(Object obj) {
        u next;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.d != xVar.d()) {
            return false;
        }
        if (this.d == 0) {
            return true;
        }
        int i = this.c;
        int i2 = xVar.c;
        if (i != 0 && i2 != 0 && i != i2) {
            return false;
        }
        Cdo cdo = new Cdo(this);
        u next2 = cdo.next();
        Cdo cdo2 = new Cdo(xVar);
        u next3 = cdo2.next();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int iD = next2.d() - i3;
            int iD2 = next3.d() - i4;
            int iMin = Math.min(iD, iD2);
            if (!(i3 == 0 ? next2.g(next3, i4, iMin) : next3.g(next2, i3, iMin))) {
                return false;
            }
            i5 += iMin;
            int i6 = this.d;
            if (i5 >= i6) {
                if (i5 == i6) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == iD) {
                next = cdo.next();
                i3 = 0;
            } else {
                i3 += iMin;
            }
            if (iMin == iD2) {
                next2 = next2;
                next2 = next;
                next3 = cdo2.next();
                i4 = 0;
            } else {
                next2 = next2;
                next2 = next;
                i4 += iMin;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected final int f() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected final boolean h() {
        return this.d >= c(this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected final int i(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.i;
        if (i4 <= i5) {
            return this.e.i(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.f.i(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.f.i(this.e.i(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new dm(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final x j(int i, int i2) {
        int iQ = q(i, i2, this.d);
        if (iQ == 0) {
            return x.b;
        }
        if (iQ == this.d) {
            return this;
        }
        int i3 = this.i;
        if (i2 <= i3) {
            return this.e.j(i, i2);
        }
        int i4 = i2 - i3;
        if (i >= i3) {
            return this.f.j(i - i3, i4);
        }
        return new dq(this.e.w(i), this.f.j(0, i4));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final ac k() {
        ArrayList<ByteBuffer> arrayList = new ArrayList();
        Cdo cdo = new Cdo(this);
        while (cdo.hasNext()) {
            arrayList.add(cdo.next().n());
        }
        int i = ac.g;
        int i2 = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : arrayList) {
            iRemaining += byteBuffer.remaining();
            i2 = byteBuffer.hasArray() ? i2 | 1 : byteBuffer.isDirect() ? i2 | 2 : i2 | 4;
        }
        return i2 == 2 ? new z(arrayList, iRemaining) : ac.J(new cd(arrayList));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final InputStream l() {
        return new dp(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected final String m(Charset charset) {
        return new String(B(), charset);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final ByteBuffer n() {
        return ByteBuffer.wrap(B()).asReadOnlyBuffer();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final void o(n nVar) throws IOException {
        this.e.o(nVar);
        this.f.o(nVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final void p(OutputStream outputStream) throws IOException {
        this.e.p(outputStream);
        this.f.p(outputStream);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    /* JADX INFO: renamed from: r */
    public final s iterator() {
        return new dm(this);
    }

    Object writeReplace() {
        return new v(B());
    }
}
