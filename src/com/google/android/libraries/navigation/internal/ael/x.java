package com.google.android.libraries.navigation.internal.ael;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.util.Locale;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x implements Iterable, Serializable {
    private static final r a;
    public static final x b = new v(ca.b);
    private static final long serialVersionUID = 1;
    public int c = 0;

    static {
        int i = g.a;
        a = new w();
    }

    public static x s(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        q(0, iRemaining, byteBuffer.remaining());
        byte[] bArr = new byte[iRemaining];
        byteBuffer.get(bArr);
        return new v(bArr);
    }

    public static x t(byte[] bArr) {
        return u(bArr, 0, bArr.length);
    }

    public static x u(byte[] bArr, int i, int i2) {
        q(i, i + i2, bArr.length);
        return new v(a.a(bArr, i, i2));
    }

    public static x v(String str) {
        return new v(str.getBytes(ca.a));
    }

    static void y(int i, int i2) {
        if (((i2 - (i + 1)) | i) < 0) {
            if (i >= 0) {
                throw new ArrayIndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.l(i2, i, "Index > length: ", ", "));
            }
            throw new ArrayIndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.b(i, "Index < 0: "));
        }
    }

    public final boolean A() {
        return d() == 0;
    }

    public final byte[] B() {
        int iD = d();
        if (iD == 0) {
            return ca.b;
        }
        byte[] bArr = new byte[iD];
        e(bArr, 0, 0, iD);
        return bArr;
    }

    public final String C() throws UnsupportedEncodingException {
        try {
            return x(Charset.forName(CharEncoding.US_ASCII));
        } catch (UnsupportedCharsetException e) {
            UnsupportedEncodingException unsupportedEncodingException = new UnsupportedEncodingException(CharEncoding.US_ASCII);
            unsupportedEncodingException.initCause(e);
            throw unsupportedEncodingException;
        }
    }

    public abstract byte a(int i);

    public abstract byte b(int i);

    public abstract int d();

    protected abstract void e(byte[] bArr, int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    protected abstract int f();

    protected abstract boolean h();

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            int iD = d();
            i = i(iD, 0, iD);
            if (i == 0) {
                i = 1;
            }
            this.c = i;
        }
        return i;
    }

    protected abstract int i(int i, int i2, int i3);

    public abstract x j(int i, int i2);

    public abstract ac k();

    public abstract InputStream l();

    protected abstract String m(Charset charset);

    public abstract ByteBuffer n();

    public abstract void o(n nVar) throws IOException;

    public abstract void p(OutputStream outputStream) throws IOException;

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public s iterator() {
        return new o(this);
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(d()), d() <= 50 ? eb.a(this) : String.valueOf(eb.a(j(0, 47))).concat("..."));
    }

    public final x w(int i) {
        return j(i, d());
    }

    public final String x(Charset charset) {
        return d() == 0 ? "" : m(charset);
    }

    @Deprecated
    public final void z(byte[] bArr, int i, int i2, int i3) {
        q(i, i + i3, d());
        q(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            e(bArr, i, i2, i3);
        }
    }

    static int q(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.j(i, "Beginning index: ", " < 0"));
        }
        if (i2 < i) {
            throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.l(i2, i, "Beginning index larger than ending index: ", ", "));
        }
        throw new IndexOutOfBoundsException(com.google.android.libraries.navigation.internal.b.b.l(i3, i2, "End index: ", " >= "));
    }
}
