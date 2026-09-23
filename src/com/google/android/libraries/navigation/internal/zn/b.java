package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends f {
    final char[] a;

    public b(a aVar) {
        super(aVar, null);
        this.a = new char[512];
        ar.a(aVar.a.length == 16);
        for (int i = 0; i < 256; i++) {
            this.a[i] = aVar.a(i >>> 4);
            this.a[i | 256] = aVar.a(i & 15);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zn.f, com.google.android.libraries.navigation.internal.zn.g
    public final int a(byte[] bArr, CharSequence charSequence) throws d {
        if (charSequence.length() % 2 == 1) {
            throw new d("Invalid input length " + charSequence.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            bArr[i2] = (byte) ((this.b.b(charSequence.charAt(i)) << 4) | this.b.b(charSequence.charAt(i + 1)));
            i += 2;
            i2++;
        }
        return i2;
    }

    @Override // com.google.android.libraries.navigation.internal.zn.f, com.google.android.libraries.navigation.internal.zn.g
    public final void b(Appendable appendable, byte[] bArr, int i) throws IOException {
        ar.j(0, i, bArr.length);
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = bArr[i2] & 255;
            appendable.append(this.a[i3]);
            appendable.append(this.a[i3 | 256]);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zn.f
    public final g c(a aVar) {
        return new b(aVar);
    }
}
