package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class s implements as {
    protected s() {
    }

    public static s e(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return p.a;
        }
        if (length != 1) {
            return length != 2 ? new h(charSequence) : new n(charSequence.charAt(0), charSequence.charAt(1));
        }
        return new m(charSequence.charAt(0));
    }

    public static String f(char c) {
        char[] cArr = new char[6];
        int i = 0;
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        int i2 = c;
        while (i < 4) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(i2 & 15);
            i++;
            i2 >>= 4;
        }
        return String.copyValueOf(cArr);
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    @Deprecated
    public final /* bridge */ /* synthetic */ boolean a(Object obj) {
        return b(((Character) obj).charValue());
    }

    public abstract boolean b(char c);

    public s c(s sVar) {
        return new q(this, sVar);
    }

    public int d(CharSequence charSequence, int i) {
        int length = charSequence.length();
        ar.u(i, length);
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public final String g(CharSequence charSequence) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return "";
            }
        } while (b(charSequence.charAt(length)));
        return charSequence.subSequence(0, length + 1).toString();
    }

    public final boolean h(CharSequence charSequence) {
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (b(charSequence.charAt(length)));
        return false;
    }
}
