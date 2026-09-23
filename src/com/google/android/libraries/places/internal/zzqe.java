package com.google.android.libraries.places.internal;

import java.io.IOException;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzqe extends zzqh {
    final char[] zza;

    private zzqe(zzqd zzqdVar) {
        super(zzqdVar, null);
        this.zza = new char[512];
        zzkt.zze(zzqdVar.zzf.length == 16);
        for (int i = 0; i < 256; i++) {
            this.zza[i] = zzqdVar.zza(i >>> 4);
            this.zza[i | 256] = zzqdVar.zza(i & 15);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzqh, com.google.android.libraries.places.internal.zzqi
    final int zza(byte[] bArr, CharSequence charSequence) throws zzqg {
        if (charSequence.length() % 2 == 1) {
            throw new zzqg("Invalid input length " + charSequence.length());
        }
        int i = 0;
        int i2 = 0;
        while (i < charSequence.length()) {
            bArr[i2] = (byte) ((this.zzb.zzb(charSequence.charAt(i)) << 4) | this.zzb.zzb(charSequence.charAt(i + 1)));
            i += 2;
            i2++;
        }
        return i2;
    }

    @Override // com.google.android.libraries.places.internal.zzqh
    final zzqi zzb(zzqd zzqdVar, @CheckForNull Character ch) {
        return new zzqe(zzqdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzqh, com.google.android.libraries.places.internal.zzqi
    final void zzc(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
        zzkt.zzm(0, i2, bArr.length);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = bArr[i3] & 255;
            appendable.append(this.zza[i4]);
            appendable.append(this.zza[i4 | 256]);
        }
    }

    zzqe(String str, String str2) {
        this(new zzqd("base16()", "0123456789ABCDEF".toCharArray()));
    }
}
