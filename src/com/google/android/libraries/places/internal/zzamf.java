package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzamf extends zzami {
    private final int zzc;

    zzamf(byte[] bArr, int i, int i2) {
        super(bArr);
        zzj(0, i2, bArr.length);
        this.zzc = i2;
    }

    @Override // com.google.android.libraries.places.internal.zzami, com.google.android.libraries.places.internal.zzaml
    final byte zzb(int i) {
        return this.zza[i];
    }

    @Override // com.google.android.libraries.places.internal.zzami
    protected final int zzc() {
        return 0;
    }

    @Override // com.google.android.libraries.places.internal.zzami, com.google.android.libraries.places.internal.zzaml
    public final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.libraries.places.internal.zzami, com.google.android.libraries.places.internal.zzaml
    public final byte zza(int i) {
        int i2 = this.zzc;
        if (((i2 - (i + 1)) | i) >= 0) {
            return this.zza[i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + i2);
    }
}
