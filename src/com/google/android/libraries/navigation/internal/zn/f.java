package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f extends g {
    final a b;
    final Character c;

    public f(a aVar, Character ch) {
        ar.q(aVar);
        this.b = aVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (aVar.f[61] != -1) {
                z = false;
            }
        }
        ar.f(z, "Padding character %s was already in alphabet", ch);
        this.c = ch;
    }

    @Override // com.google.android.libraries.navigation.internal.zn.g
    public int a(byte[] bArr, CharSequence charSequence) throws d {
        a aVar;
        CharSequence charSequenceG = g(charSequence);
        if (!this.b.c(charSequenceG.length())) {
            throw new d("Invalid input length " + charSequenceG.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceG.length()) {
            long jB = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                aVar = this.b;
                if (i3 >= aVar.d) {
                    break;
                }
                jB <<= aVar.c;
                if (i + i3 < charSequenceG.length()) {
                    jB |= (long) this.b.b(charSequenceG.charAt(i4 + i));
                    i4++;
                }
                i3++;
            }
            int i5 = aVar.e;
            int i6 = i4 * aVar.c;
            int i7 = (i5 - 1) * 8;
            while (i7 >= (i5 * 8) - i6) {
                bArr[i2] = (byte) ((jB >>> i7) & 255);
                i7 -= 8;
                i2++;
            }
            i += this.b.d;
        }
        return i2;
    }

    @Override // com.google.android.libraries.navigation.internal.zn.g
    public void b(Appendable appendable, byte[] bArr, int i) throws IOException {
        int i2 = 0;
        ar.j(0, i, bArr.length);
        while (i2 < i) {
            h(appendable, bArr, i2, Math.min(this.b.e, i - i2));
            i2 += this.b.e;
        }
    }

    public g c(a aVar) {
        return new f(aVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.zn.g
    public final int d(int i) {
        return (int) (((((long) this.b.c) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.libraries.navigation.internal.zn.g
    public final int e(int i) {
        a aVar = this.b;
        return aVar.d * com.google.android.libraries.navigation.internal.zw.e.a(i, aVar.e, RoundingMode.CEILING);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.b.equals(fVar.b) && Objects.equals(this.c, fVar.c)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.zn.g
    public final g f() {
        return this.c == null ? this : c(this.b);
    }

    @Override // com.google.android.libraries.navigation.internal.zn.g
    public final CharSequence g(CharSequence charSequence) {
        ar.q(charSequence);
        Character ch = this.c;
        if (ch == null) {
            return charSequence;
        }
        ch.charValue();
        int length = charSequence.length();
        do {
            length--;
            if (length < 0) {
                break;
            }
        } while (charSequence.charAt(length) == '=');
        return charSequence.subSequence(0, length + 1);
    }

    final void h(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        ar.j(i, i + i2, bArr.length);
        int i3 = 0;
        ar.a(i2 <= this.b.e);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = (i2 + 1) * 8;
        a aVar = this.b;
        while (i3 < i2 * 8) {
            long j2 = j >>> ((i5 - aVar.c) - i3);
            a aVar2 = this.b;
            appendable.append(aVar2.a(((int) j2) & aVar2.b));
            i3 += this.b.c;
        }
        if (this.c != null) {
            while (i3 < this.b.e * 8) {
                this.c.charValue();
                appendable.append('=');
                i3 += this.b.c;
            }
        }
    }

    public final int hashCode() {
        Character ch = this.c;
        return Objects.hashCode(ch) ^ this.b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.b);
        if (8 % this.b.c != 0) {
            if (this.c == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.c);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    public f(String str, String str2, Character ch) {
        this(new a(str, str2.toCharArray()), ch);
    }
}
