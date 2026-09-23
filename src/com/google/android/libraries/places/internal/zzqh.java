package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.math.RoundingMode;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzqh extends zzqi {
    final zzqd zzb;

    @CheckForNull
    final Character zzc;

    zzqh(zzqd zzqdVar, @CheckForNull Character ch) {
        this.zzb = zzqdVar;
        boolean z = true;
        if (ch != null) {
            ch.charValue();
            if (zzqdVar.zzd('=')) {
                z = false;
            }
        }
        zzkt.zzj(z, "Padding character %s was already in alphabet", ch);
        this.zzc = ch;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzqh) {
            zzqh zzqhVar = (zzqh) obj;
            if (this.zzb.equals(zzqhVar.zzb)) {
                Character ch = this.zzc;
                Character ch2 = zzqhVar.zzc;
                if (ch == ch2) {
                    return true;
                }
                if (ch != null && ch.equals(ch2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        Character ch = this.zzc;
        return (ch == null ? 0 : ch.hashCode()) ^ this.zzb.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BaseEncoding.");
        sb.append(this.zzb);
        if (8 % this.zzb.zzb != 0) {
            if (this.zzc == null) {
                sb.append(".omitPadding()");
            } else {
                sb.append(".withPadChar('");
                sb.append(this.zzc);
                sb.append("')");
            }
        }
        return sb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzqi
    int zza(byte[] bArr, CharSequence charSequence) throws zzqg {
        zzqd zzqdVar;
        CharSequence charSequenceZzg = zzg(charSequence);
        if (!this.zzb.zzc(charSequenceZzg.length())) {
            throw new zzqg("Invalid input length " + charSequenceZzg.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequenceZzg.length()) {
            long jZzb = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                zzqdVar = this.zzb;
                if (i3 >= zzqdVar.zzc) {
                    break;
                }
                jZzb <<= zzqdVar.zzb;
                if (i + i3 < charSequenceZzg.length()) {
                    jZzb |= (long) this.zzb.zzb(charSequenceZzg.charAt(i4 + i));
                    i4++;
                }
                i3++;
            }
            int i5 = zzqdVar.zzd;
            int i6 = i4 * zzqdVar.zzb;
            int i7 = (i5 - 1) * 8;
            while (i7 >= (i5 * 8) - i6) {
                bArr[i2] = (byte) ((jZzb >>> i7) & 255);
                i7 -= 8;
                i2++;
            }
            i += this.zzb.zzc;
        }
        return i2;
    }

    zzqi zzb(zzqd zzqdVar, @CheckForNull Character ch) {
        return new zzqh(zzqdVar, null);
    }

    @Override // com.google.android.libraries.places.internal.zzqi
    void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        zzkt.zzm(0, i2, bArr.length);
        while (i3 < i2) {
            zzh(appendable, bArr, i3, Math.min(this.zzb.zzd, i2 - i3));
            i3 += this.zzb.zzd;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzqi
    final int zzd(int i) {
        return (int) (((((long) this.zzb.zzb) * ((long) i)) + 7) / 8);
    }

    @Override // com.google.android.libraries.places.internal.zzqi
    final int zze(int i) {
        zzqd zzqdVar = this.zzb;
        return zzqdVar.zzc * zzaha.zza(i, zzqdVar.zzd, RoundingMode.CEILING);
    }

    @Override // com.google.android.libraries.places.internal.zzqi
    public final zzqi zzf() {
        return this.zzc == null ? this : zzb(this.zzb, null);
    }

    final void zzh(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzkt.zzm(i, i + i2, bArr.length);
        int i3 = 0;
        zzkt.zze(i2 <= this.zzb.zzd);
        long j = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            j = (j | ((long) (bArr[i + i4] & 255))) << 8;
        }
        int i5 = (i2 + 1) * 8;
        zzqd zzqdVar = this.zzb;
        while (i3 < i2 * 8) {
            long j2 = j >>> ((i5 - zzqdVar.zzb) - i3);
            zzqd zzqdVar2 = this.zzb;
            appendable.append(zzqdVar2.zza(((int) j2) & zzqdVar2.zza));
            i3 += this.zzb.zzb;
        }
        if (this.zzc != null) {
            while (i3 < this.zzb.zzd * 8) {
                this.zzc.charValue();
                appendable.append('=');
                i3 += this.zzb.zzb;
            }
        }
    }

    zzqh(String str, String str2, @CheckForNull Character ch) {
        this(new zzqd(str, str2.toCharArray()), ch);
    }

    @Override // com.google.android.libraries.places.internal.zzqi
    final CharSequence zzg(CharSequence charSequence) {
        charSequence.getClass();
        Character ch = this.zzc;
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
}
