package com.google.android.libraries.navigation.internal.ael;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class v extends u {
    private static final long serialVersionUID = 1;
    protected final byte[] a;

    public v(byte[] bArr) {
        bArr.getClass();
        this.a = bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public byte a(int i) {
        return this.a[i];
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public byte b(int i) {
        return this.a[i];
    }

    protected int c() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public int d() {
        return this.a.length;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected void e(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.a, i, bArr, i2, i3);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x) || d() != ((x) obj).d()) {
            return false;
        }
        if (d() == 0) {
            return true;
        }
        if (!(obj instanceof v)) {
            return obj.equals(this);
        }
        v vVar = (v) obj;
        int i = this.c;
        int i2 = vVar.c;
        if (i == 0 || i2 == 0 || i == i2) {
            return g(vVar, 0, d());
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.u
    public final boolean g(x xVar, int i, int i2) {
        if (i2 > xVar.d()) {
            throw new IllegalArgumentException("Length too large: " + i2 + d());
        }
        int i3 = i + i2;
        if (i3 > xVar.d()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + xVar.d());
        }
        if (!(xVar instanceof v)) {
            return xVar.j(i, i3).equals(j(0, i2));
        }
        v vVar = (v) xVar;
        byte[] bArr = this.a;
        byte[] bArr2 = vVar.a;
        int iC = c() + i2;
        int iC2 = c();
        int iC3 = vVar.c() + i;
        while (iC2 < iC) {
            if (bArr[iC2] != bArr2[iC3]) {
                return false;
            }
            iC2++;
            iC3++;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected final int i(int i, int i2, int i3) {
        return ca.c(i, this.a, c() + i2, i3);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final x j(int i, int i2) {
        int iQ = q(i, i2, d());
        return iQ == 0 ? x.b : new q(this.a, c() + i, iQ);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final ac k() {
        return ac.M(this.a, c(), d(), true);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final InputStream l() {
        return new ByteArrayInputStream(this.a, c(), d());
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    protected final String m(Charset charset) {
        return new String(this.a, c(), d(), charset);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final ByteBuffer n() {
        return ByteBuffer.wrap(this.a, c(), d()).asReadOnlyBuffer();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final void o(n nVar) throws IOException {
        nVar.a(this.a, c(), d());
    }

    @Override // com.google.android.libraries.navigation.internal.ael.x
    public final void p(OutputStream outputStream) throws IOException {
        outputStream.write(B());
    }
}
