package com.google.android.libraries.navigation.internal.ael;

import com.google.common.base.Ascii;
import okio.Utf8;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class en {
    public static void a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws cc {
        if (i(b2) || (((b << Ascii.FS) + (b2 + 112)) >> 30) != 0 || i(b3) || i(b4)) {
            throw new cc("Protocol message had invalid UTF-8.");
        }
        int iH = ((b & 7) << 18) | (h(b2) << 12) | (h(b3) << 6) | h(b4);
        cArr[i] = (char) ((iH >>> 10) + Utf8.HIGH_SURROGATE_HEADER);
        cArr[i + 1] = (char) ((iH & 1023) + Utf8.LOG_SURROGATE_HEADER);
    }

    public static void b(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    public static void d(byte b, byte b2, char[] cArr, int i) throws cc {
        if (b < -62 || i(b2)) {
            throw new cc("Protocol message had invalid UTF-8.");
        }
        cArr[i] = (char) (((b & Ascii.US) << 6) | h(b2));
    }

    public static boolean e(byte b) {
        return b >= 0;
    }

    public static boolean f(byte b) {
        return b < -16;
    }

    public static boolean g(byte b) {
        return b < -32;
    }

    private static int h(byte b) {
        return b & Utf8.REPLACEMENT_BYTE;
    }

    private static boolean i(byte b) {
        return b > -65;
    }

    public static void c(byte b, byte b2, byte b3, char[] cArr, int i) throws cc {
        if (!i(b2)) {
            if (b != -32) {
                if ((b == -19 || b2 < -96) && !i(b3)) {
                    cArr[i] = (char) (((b & Ascii.SI) << 12) | (h(b2) << 6) | h(b3));
                    return;
                }
            } else if (b2 >= -96) {
                b = -32;
                if (b == -19) {
                    cArr[i] = (char) (((b & Ascii.SI) << 12) | (h(b2) << 6) | h(b3));
                    return;
                }
                cArr[i] = (char) (((b & Ascii.SI) << 12) | (h(b2) << 6) | h(b3));
                return;
            }
        }
        throw new cc("Protocol message had invalid UTF-8.");
    }
}
