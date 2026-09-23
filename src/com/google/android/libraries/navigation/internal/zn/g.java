package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g {
    public static final g d = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    public static final g e = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    static {
        new f("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
        new f("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
        new b(new a("base16()", "0123456789ABCDEF".toCharArray()));
    }

    public abstract int a(byte[] bArr, CharSequence charSequence) throws d;

    public abstract void b(Appendable appendable, byte[] bArr, int i) throws IOException;

    public abstract int d(int i);

    public abstract int e(int i);

    public abstract g f();

    public CharSequence g(CharSequence charSequence) {
        throw null;
    }

    public final String i(byte[] bArr) {
        int length = bArr.length;
        ar.j(0, length, length);
        StringBuilder sb = new StringBuilder(e(length));
        try {
            b(sb, bArr, length);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final byte[] j(CharSequence charSequence) {
        try {
            CharSequence charSequenceG = g(charSequence);
            int iD = d(charSequenceG.length());
            byte[] bArr = new byte[iD];
            int iA = a(bArr, charSequenceG);
            if (iA == iD) {
                return bArr;
            }
            byte[] bArr2 = new byte[iA];
            System.arraycopy(bArr, 0, bArr2, 0, iA);
            return bArr2;
        } catch (d e2) {
            throw new IllegalArgumentException(e2);
        }
    }
}
