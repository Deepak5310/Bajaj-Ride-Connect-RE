package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p extends com.google.android.libraries.navigation.internal.za.d {
    private static final char[] a = {'+'};
    private static final char[] b = "0123456789ABCDEF".toCharArray();
    private final boolean c;
    private final boolean[] d;

    public p(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        String strConcat = str.concat("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        if (z && strConcat.contains(StringUtils.SPACE)) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        this.c = z;
        char[] charArray = strConcat.toCharArray();
        int iMax = -1;
        for (char c : charArray) {
            iMax = Math.max((int) c, iMax);
        }
        boolean[] zArr = new boolean[iMax + 1];
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        this.d = zArr;
    }

    @Override // com.google.android.libraries.navigation.internal.za.d, com.google.android.libraries.navigation.internal.za.a
    public final String a(String str) {
        int codePoint;
        ar.q(str);
        int length = str.length();
        int iB = 0;
        while (iB < length) {
            char cCharAt = str.charAt(iB);
            boolean[] zArr = this.d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                int length2 = str.length();
                char[] cArrD = (char[]) Objects.requireNonNull((char[]) com.google.android.libraries.navigation.internal.za.c.a.get());
                int i = 0;
                int i2 = 0;
                while (iB < length2) {
                    ar.q(str);
                    if (iB >= length2) {
                        throw new IndexOutOfBoundsException("Index exceeds specified range");
                    }
                    int i3 = iB + 1;
                    char cCharAt2 = str.charAt(iB);
                    if (cCharAt2 >= 55296 && cCharAt2 <= 57343) {
                        if (cCharAt2 > 56319) {
                            codePoint = cCharAt2;
                            codePoint = cCharAt2;
                            throw new IllegalArgumentException("Unexpected low surrogate character '" + cCharAt2 + "' with value " + ((int) cCharAt2) + " at index " + iB + " in '" + String.valueOf(str) + "'");
                        }
                        if (i3 == length2) {
                            codePoint = -cCharAt2;
                        } else {
                            char cCharAt3 = str.charAt(i3);
                            if (!Character.isLowSurrogate(cCharAt3)) {
                                throw new IllegalArgumentException("Expected low surrogate but got char '" + cCharAt3 + "' with value " + ((int) cCharAt3) + " at index " + i3 + " in '" + String.valueOf(str) + "'");
                            }
                            codePoint = Character.toCodePoint(cCharAt2, cCharAt3);
                        }
                    }
                    if (codePoint < 0) {
                        throw new IllegalArgumentException("Trailing high surrogate at end of input");
                    }
                    char[] cArrC = c(codePoint);
                    int i4 = (true == Character.isSupplementaryCodePoint(codePoint) ? 2 : 1) + iB;
                    if (cArrC != null) {
                        int i5 = iB - i;
                        int i6 = i2 + i5;
                        int length3 = cArrD.length;
                        int length4 = cArrC.length;
                        int i7 = i6 + length4;
                        if (length3 < i7) {
                            cArrD = com.google.android.libraries.navigation.internal.za.d.d(cArrD, i2, i7 + (length2 - iB) + 32);
                        }
                        if (i5 > 0) {
                            str.getChars(i, iB, cArrD, i2);
                            i2 = i6;
                        }
                        System.arraycopy(cArrC, 0, cArrD, i2, length4);
                        i2 += length4;
                        i = i4;
                    }
                    iB = b(str, i4, length2);
                }
                int i8 = length2 - i;
                if (i8 > 0) {
                    int i9 = i8 + i2;
                    if (cArrD.length < i9) {
                        cArrD = com.google.android.libraries.navigation.internal.za.d.d(cArrD, i2, i9);
                    }
                    str.getChars(i, length2, cArrD, i2);
                    i2 = i9;
                }
                return new String(cArrD, 0, i2);
            }
            iB++;
        }
        return str;
    }

    @Override // com.google.android.libraries.navigation.internal.za.d
    protected final int b(CharSequence charSequence, int i, int i2) {
        ar.q(charSequence);
        while (i < i2) {
            char cCharAt = charSequence.charAt(i);
            boolean[] zArr = this.d;
            if (cCharAt >= zArr.length || !zArr[cCharAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.za.d
    protected final char[] c(int i) {
        boolean[] zArr = this.d;
        if (i < zArr.length && zArr[i]) {
            return null;
        }
        if (i == 32 && this.c) {
            return a;
        }
        if (i <= 127) {
            char[] cArr = b;
            return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
        }
        if (i <= 2047) {
            char[] cArr2 = b;
            return new char[]{'%', cArr2[(i >>> 10) | 12], cArr2[(i >>> 6) & 15], '%', cArr2[((i >>> 4) & 3) | 8], cArr2[i & 15]};
        }
        if (i <= 65535) {
            char[] cArr3 = b;
            return new char[]{'%', 'E', cArr3[i >>> 12], '%', cArr3[((i >>> 10) & 3) | 8], cArr3[(i >>> 6) & 15], '%', cArr3[((i >>> 4) & 3) | 8], cArr3[i & 15]};
        }
        if (i > 1114111) {
            throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.b(i, "Invalid unicode character value "));
        }
        char[] cArr4 = b;
        return new char[]{'%', 'F', cArr4[i >>> 18], '%', cArr4[((i >>> 16) & 3) | 8], cArr4[(i >>> 12) & 15], '%', cArr4[((i >>> 10) & 3) | 8], cArr4[(i >>> 6) & 15], '%', cArr4[((i >>> 4) & 3) | 8], cArr4[i & 15]};
    }
}
