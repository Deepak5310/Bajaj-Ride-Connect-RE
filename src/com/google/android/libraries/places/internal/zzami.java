package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzami extends zzamh {
    protected final byte[] zza;

    zzami(byte[] bArr) {
        bArr.getClass();
        this.zza = bArr;
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzaml) || zzd() != ((zzaml) obj).zzd()) {
            return false;
        }
        if (zzd() == 0) {
            return true;
        }
        if (!(obj instanceof zzami)) {
            return obj.equals(this);
        }
        zzami zzamiVar = (zzami) obj;
        int iZzk = zzk();
        int iZzk2 = zzamiVar.zzk();
        if (iZzk != 0 && iZzk2 != 0 && iZzk != iZzk2) {
            return false;
        }
        int iZzd = zzd();
        if (iZzd > zzamiVar.zzd()) {
            throw new IllegalArgumentException("Length too large: " + iZzd + zzd());
        }
        if (iZzd > zzamiVar.zzd()) {
            throw new IllegalArgumentException("Ran off end of other: 0, " + iZzd + ", " + zzamiVar.zzd());
        }
        if (!(zzamiVar instanceof zzami)) {
            return zzamiVar.zzf(0, iZzd).equals(zzf(0, iZzd));
        }
        byte[] bArr = this.zza;
        byte[] bArr2 = zzamiVar.zza;
        zzamiVar.zzc();
        int i = 0;
        int i2 = 0;
        while (i < iZzd) {
            if (bArr[i] != bArr2[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    public byte zza(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    byte zzb(int i) {
        return this.zza[i];
    }

    protected int zzc() {
        return 0;
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    public int zzd() {
        return this.zza.length;
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    protected final int zze(int i, int i2, int i3) {
        return zzaoa.zzb(i, this.zza, 0, i3);
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    public final zzaml zzf(int i, int i2) {
        int iZzj = zzj(0, i2, zzd());
        return iZzj == 0 ? zzaml.zzb : new zzamf(this.zza, 0, iZzj);
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    protected final String zzg(Charset charset) {
        return new String(this.zza, 0, zzd(), charset);
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    final void zzh(zzamb zzambVar) throws IOException {
        zzambVar.zza(this.zza, 0, zzd());
    }

    @Override // com.google.android.libraries.places.internal.zzaml
    public final boolean zzi() {
        return zzaqv.zzf(this.zza, 0, zzd());
    }
}
