package com.google.android.libraries.navigation.internal.zi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f extends d {
    private static final String a;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
            if (!property.matches("\\n|\\r(?:\\n)?")) {
                property = "\n";
            }
        } catch (SecurityException unused) {
        }
        a = property;
    }

    static int d(String str, int i) throws e {
        while (i < str.length()) {
            int i2 = i + 1;
            if (str.charAt(i) != '%') {
                i = i2;
            } else {
                if (i2 >= str.length()) {
                    throw e.c("trailing unquoted '%' character", str, i);
                }
                char cCharAt = str.charAt(i2);
                if (cCharAt != '%' && cCharAt != 'n') {
                    return i;
                }
                i += 2;
            }
        }
        return -1;
    }

    public abstract int a(c cVar, int i, String str, int i2, int i3, int i4) throws e;

    /* JADX WARN: Code duplicated, block: B:44:0x0094  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b1 A[LOOP:2: B:42:0x008e->B:47:0x00b1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:61:0x00b4 A[SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.zi.d
    public final void b(c cVar) throws e {
        int i;
        char cCharAt;
        int i2;
        int i3;
        int i4;
        int i5;
        String strG = cVar.g();
        int iD = d(strG, 0);
        int i6 = 0;
        int i7 = -1;
        while (iD >= 0) {
            int i8 = iD + 1;
            int i9 = i8;
            int i10 = 0;
            while (true) {
                if (i9 >= strG.length()) {
                    throw e.c("unterminated parameter", strG, iD);
                }
                i = i9 + 1;
                cCharAt = strG.charAt(i9);
                char c = (char) (cCharAt - '0');
                if (c < '\n') {
                    i10 = (i10 * 10) + c;
                    if (i10 >= 1000000) {
                        throw e.b("index too large", strG, iD, i);
                    }
                    i9 = i;
                }
            }
            if (cCharAt != '$') {
                if (cCharAt != '<') {
                    i2 = i6;
                    i6++;
                    i3 = i8;
                } else {
                    if (i7 == -1) {
                        throw e.b("invalid relative parameter", strG, iD, i);
                    }
                    if (i == strG.length()) {
                        throw e.c("unterminated parameter", strG, iD);
                    }
                    i4 = i9 + 2;
                    i2 = i7;
                }
                i5 = i - 1;
                while (true) {
                    if (i5 < strG.length()) {
                        throw e.c("unterminated parameter", strG, iD);
                    }
                    if (((char) ((strG.charAt(i5) & (-33)) - 65)) < 26) {
                        break;
                    } else {
                        i5++;
                    }
                }
                iD = d(strG, a(cVar, i2, strG, iD, i3, i5));
                i6 = i6;
                i7 = i2;
            } else {
                if (i9 - i8 == 0) {
                    throw e.b("missing index", strG, iD, i);
                }
                if (strG.charAt(i8) == '0') {
                    throw e.b("index has leading zero", strG, iD, i);
                }
                int i11 = i10 - 1;
                if (i == strG.length()) {
                    throw e.c("unterminated parameter", strG, iD);
                }
                i4 = i9 + 2;
                i2 = i11;
            }
            i3 = i;
            i = i4;
            i5 = i - 1;
            while (true) {
                if (i5 < strG.length()) {
                    throw e.c("unterminated parameter", strG, iD);
                }
                if (((char) ((strG.charAt(i5) & (-33)) - 65)) < 26) {
                    break;
                } else {
                    i5++;
                }
            }
            iD = d(strG, a(cVar, i2, strG, iD, i3, i5));
            i6 = i6;
            i7 = i2;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zi.d
    public final void c(StringBuilder sb, String str, int i, int i2) {
        int i3 = i;
        while (i < i2) {
            int i4 = i + 1;
            if (str.charAt(i) == '%') {
                if (i4 == i2) {
                    break;
                }
                char cCharAt = str.charAt(i4);
                if (cCharAt == '%') {
                    sb.append((CharSequence) str, i3, i4);
                } else if (cCharAt == 'n') {
                    sb.append((CharSequence) str, i3, i);
                    sb.append(a);
                }
                i3 = i + 2;
                i = i3;
            }
            i = i4;
        }
        if (i3 < i2) {
            sb.append((CharSequence) str, i3, i2);
        }
    }
}
