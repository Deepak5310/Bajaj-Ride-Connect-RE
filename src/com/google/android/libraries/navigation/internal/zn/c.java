package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends f {
    private c(a aVar, Character ch) {
        super(aVar, ch);
        ar.a(aVar.a.length == 64);
    }

    @Override // com.google.android.libraries.navigation.internal.zn.f, com.google.android.libraries.navigation.internal.zn.g
    public final int a(byte[] bArr, CharSequence charSequence) throws d {
        CharSequence charSequenceG = g(charSequence);
        if (!this.b.c(charSequenceG.length())) {
            throw new d("Invalid input length " + charSequenceG.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceG.length()) {
            int i3 = i2 + 1;
            int iB = (this.b.b(charSequenceG.charAt(i)) << 18) | (this.b.b(charSequenceG.charAt(i + 1)) << 12);
            bArr[i2] = (byte) (iB >>> 16);
            int i4 = i + 2;
            if (i4 < charSequenceG.length()) {
                int i5 = i + 3;
                int iB2 = iB | (this.b.b(charSequenceG.charAt(i4)) << 6);
                int i6 = i2 + 2;
                bArr[i3] = (byte) ((iB2 >>> 8) & 255);
                if (i5 < charSequenceG.length()) {
                    i += 4;
                    i2 += 3;
                    bArr[i6] = (byte) ((iB2 | this.b.b(charSequenceG.charAt(i5))) & 255);
                } else {
                    i2 = i6;
                    i = i5;
                }
            } else {
                i = i4;
                i2 = i3;
            }
        }
        return i2;
    }

    @Override // com.google.android.libraries.navigation.internal.zn.f, com.google.android.libraries.navigation.internal.zn.g
    public final void b(Appendable appendable, byte[] bArr, int i) throws IOException {
        int i2 = 0;
        ar.j(0, i, bArr.length);
        for (int i3 = i; i3 >= 3; i3 -= 3) {
            int i4 = bArr[i2] & 255;
            int i5 = ((bArr[i2 + 1] & 255) << 8) | (i4 << 16) | (bArr[i2 + 2] & 255);
            appendable.append(this.b.a(i5 >>> 18));
            appendable.append(this.b.a((i5 >>> 12) & 63));
            appendable.append(this.b.a((i5 >>> 6) & 63));
            appendable.append(this.b.a(i5 & 63));
            i2 += 3;
        }
        if (i2 < i) {
            h(appendable, bArr, i2, i - i2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zn.f
    public final g c(a aVar) {
        return new c(aVar, null);
    }

    public c(String str, String str2, Character ch) {
        this(new a(str, str2.toCharArray()), ch);
    }
}
