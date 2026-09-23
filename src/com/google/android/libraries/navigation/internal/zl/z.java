package com.google.android.libraries.navigation.internal.zl;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class z extends c {
    private long b;
    private int c;
    private int a = 0;
    private int d = 0;
    private boolean e = false;

    public z(int i) {
    }

    private final void e(int i, long j) {
        long j2 = this.b;
        int i2 = this.c;
        long j3 = ((j & 4294967295L) << i2) | j2;
        this.b = j3;
        int i3 = i2 + (i * 8);
        this.c = i3;
        this.d += i;
        if (i3 >= 32) {
            this.a = aa.g(this.a, aa.h((int) j3));
            this.b = j3 >>> 32;
            this.c = i3 - 32;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n a(ByteBuffer byteBuffer) {
        ByteOrder byteOrderOrder = byteBuffer.order();
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        while (byteBuffer.remaining() >= 4) {
            c(byteBuffer.getInt());
        }
        while (byteBuffer.hasRemaining()) {
            f(byteBuffer.get());
        }
        byteBuffer.order(byteOrderOrder);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n c(int i) {
        e(4, i);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final void f(byte b) {
        e(1, b & 255);
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n g(byte[] bArr, int i) {
        int i2 = 0;
        ar.j(0, i, bArr.length);
        while (true) {
            int i3 = i2 + 4;
            if (i3 > i) {
                break;
            }
            e(4, aa.f(bArr, i2));
            i2 = i3;
        }
        while (i2 < i) {
            f(bArr[i2]);
            i2++;
        }
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n i(long j) {
        e(4, (int) j);
        e(4, j >>> 32);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.c, com.google.android.libraries.navigation.internal.zl.n
    public final n j(CharSequence charSequence, Charset charset) {
        if (!StandardCharsets.UTF_8.equals(charset)) {
            return super.j(charSequence, charset);
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i + 4;
            if (i2 > length) {
                break;
            }
            char cCharAt = charSequence.charAt(i);
            char cCharAt2 = charSequence.charAt(i + 1);
            char cCharAt3 = charSequence.charAt(i + 2);
            char cCharAt4 = charSequence.charAt(i + 3);
            if (cCharAt >= 128 || cCharAt2 >= 128 || cCharAt3 >= 128 || cCharAt4 >= 128) {
                break;
            }
            e(4, (cCharAt2 << '\b') | cCharAt | (cCharAt3 << 16) | (cCharAt4 << 24));
            i = i2;
        }
        while (i < length) {
            char cCharAt5 = charSequence.charAt(i);
            if (cCharAt5 < 128) {
                e(1, cCharAt5);
            } else if (cCharAt5 < 2048) {
                e(2, aa.j(cCharAt5));
            } else if (cCharAt5 < 55296 || cCharAt5 > 57343) {
                e(3, aa.i(cCharAt5));
            } else {
                int iCodePointAt = Character.codePointAt(charSequence, i);
                if (iCodePointAt == cCharAt5) {
                    b(charSequence.subSequence(i, length).toString().getBytes(charset));
                    return this;
                }
                e(4, aa.k(iCodePointAt));
                i++;
            }
            i++;
        }
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.zl.n
    public final l o() {
        ar.k(!this.e);
        this.e = true;
        int iH = this.a ^ aa.h((int) this.b);
        this.a = iH;
        return aa.l(iH, this.d);
    }
}
