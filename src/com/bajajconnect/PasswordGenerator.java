package com.bajajconnect;

import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class PasswordGenerator {
    public static String getPassword(String str) {
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        byte[] bArr = new byte[50];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 50));
        byte[] bArr2 = new byte[20];
        scramble(bArr, 50, bArr2, 20);
        return new String(bArr2, StandardCharsets.US_ASCII);
    }

    private static void scramble(byte[] bArr, int i, byte[] bArr2, int i2) {
        char[] charArray = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
        int length = charArray.length;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            int i6 = bArr[i5] & 255;
            int i7 = i5 % 8;
            i3 = (((i3 * 31) + i6) ^ (((i6 >>> (8 - i7)) & 255) | ((i6 << i7) & 255))) & 255;
            int i8 = bArr[(i - i5) - 1] & 255;
            int i9 = i5 % 7;
            i4 = (((i4 * 37) + i8) ^ (((i8 << i9) & 255) | ((i8 >>> (7 - i9)) & 255))) & 255;
        }
        for (int i10 = 0; i10 < i2; i10++) {
            int i11 = (bArr[i10 % i] & 255) ^ ((i10 * 157) & 255);
            int i12 = 0;
            while (i12 < 8) {
                int i13 = (i4 ^ (((i3 + i11) + (i12 * NikonType2MakernoteDirectory.TAG_AF_RESPONSE)) & 255)) & 255;
                int i14 = i12 + 1;
                int i15 = (i3 ^ ((i11 * i14) & 255)) & 255;
                i11 = (i11 + (bArr[(i10 + i12) % i] & 255) + i12 + i13) & 255;
                i12 = i14;
                i4 = i15;
                i3 = i13;
            }
            byte b = (byte) charArray[(i3 ^ i4) % length];
            bArr2[i10] = b;
            i3 ^= (b * 199) & 255;
            i4 ^= (b * 223) & 255;
        }
    }
}
