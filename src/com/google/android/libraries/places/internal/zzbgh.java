package com.google.android.libraries.places.internal;

import com.drew.metadata.exif.ExifDirectoryBase;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbgh implements Closeable, zzbaa {
    private zzbgd zza;
    private int zzb;
    private final zzbjt zzc;
    private final zzbke zzd;
    private zzate zze;
    private boolean zzg;
    private zzazv zzh;
    private long zzj;
    private int zzm;
    private int zzp = 1;
    private int zzf = 5;
    private zzazv zzi = new zzazv();
    private boolean zzk = false;
    private int zzl = -1;
    private boolean zzn = false;
    private volatile boolean zzo = false;

    public zzbgh(zzbgd zzbgdVar, zzate zzateVar, int i, zzbjt zzbjtVar, zzbke zzbkeVar) {
        this.zza = zzbgdVar;
        this.zze = zzateVar;
        this.zzb = i;
        this.zzc = zzbjtVar;
        this.zzd = zzbkeVar;
    }

    private final void zzh() {
        int i;
        InputStream zzbhcVar;
        if (this.zzk) {
            return;
        }
        this.zzk = true;
        loop0: while (this.zzj > 0) {
            try {
                try {
                    if (this.zzh == null) {
                        this.zzh = new zzazv();
                    }
                    i = 0;
                    while (true) {
                        try {
                            int iZzf = this.zzf - this.zzh.zzf();
                            if (iZzf > 0) {
                                if (this.zzi.zzf() == 0) {
                                    if (i <= 0) {
                                        break loop0;
                                    }
                                    this.zza.zzE(i);
                                    if (this.zzp != 2) {
                                        break loop0;
                                    }
                                    this.zzc.zzh(i);
                                    this.zzm += i;
                                    break loop0;
                                }
                                int iMin = Math.min(iZzf, this.zzi.zzf());
                                i += iMin;
                                this.zzh.zzh(this.zzi.zzg(iMin));
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (i > 0) {
                                this.zza.zzE(i);
                                if (this.zzp == 2) {
                                    this.zzc.zzh(i);
                                    this.zzm += i;
                                }
                            }
                            throw th;
                        }
                    }
                    if (i > 0) {
                        this.zza.zzE(i);
                        if (this.zzp == 2) {
                            this.zzc.zzh(i);
                            this.zzm += i;
                        }
                    }
                    int i2 = this.zzp;
                    int i3 = i2 - 1;
                    if (i2 == 0) {
                        throw null;
                    }
                    if (i3 == 0) {
                        int iZze = this.zzh.zze();
                        if ((iZze & ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE) != 0) {
                            throw new zzaxf(zzaxd.zzo.zzg("gRPC frame header malformed: reserved bits not zero"), null);
                        }
                        this.zzg = 1 == (iZze & 1);
                        zzazv zzazvVar = this.zzh;
                        zzazvVar.zza(4);
                        int iZze2 = zzazvVar.zze() | (zzazvVar.zze() << 24) | (zzazvVar.zze() << 16) | (zzazvVar.zze() << 8);
                        this.zzf = iZze2;
                        if (iZze2 < 0 || iZze2 > this.zzb) {
                            throw new zzaxf(zzaxd.zzj.zzg(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.zzb), Integer.valueOf(this.zzf))), null);
                        }
                        int i4 = this.zzl + 1;
                        this.zzl = i4;
                        this.zzc.zze(i4);
                        this.zzd.zzc();
                        this.zzp = 2;
                    } else {
                        if (i3 != 1) {
                            throw new AssertionError("Invalid state: " + (i2 != 1 ? "BODY" : "HEADER"));
                        }
                        this.zzc.zzf(this.zzl, this.zzm, -1L);
                        this.zzm = 0;
                        if (this.zzg) {
                            zzate zzateVar = this.zze;
                            if (zzateVar == zzasq.zza) {
                                throw new zzaxf(zzaxd.zzo.zzg("Can't decode compressed gRPC message as compression not configured"), null);
                            }
                            try {
                                zzbhcVar = new zzbgg(zzateVar.zza(new zzbhc(this.zzh)), this.zzb, this.zzc);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            this.zzc.zzg(this.zzh.zzf());
                            zzbhcVar = new zzbhc(this.zzh);
                        }
                        this.zzh = null;
                        this.zza.zzr(new zzbgf(zzbhcVar, null));
                        this.zzp = 1;
                        this.zzf = 5;
                        this.zzj--;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 0;
                }
            } catch (Throwable th3) {
                this.zzk = false;
                throw th3;
            }
        }
        if (this.zzn && zzi()) {
            close();
        }
        this.zzk = false;
    }

    private final boolean zzi() {
        return this.zzi.zzf() == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, com.google.android.libraries.places.internal.zzbaa
    public final void close() {
        if (zzg()) {
            return;
        }
        zzazv zzazvVar = this.zzh;
        boolean z = false;
        if (zzazvVar != null && zzazvVar.zzf() > 0) {
            z = true;
        }
        try {
            zzazv zzazvVar2 = this.zzi;
            if (zzazvVar2 != null) {
                zzazvVar2.close();
            }
            zzazv zzazvVar3 = this.zzh;
            if (zzazvVar3 != null) {
                zzazvVar3.close();
            }
            this.zzi = null;
            this.zzh = null;
            this.zza.zze(z);
        } catch (Throwable th) {
            this.zzi = null;
            this.zzh = null;
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbaa
    public final void zza() {
        if (zzg()) {
            return;
        }
        if (zzi()) {
            close();
        } else {
            this.zzn = true;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbaa
    public final void zzb(zzbhb zzbhbVar) throws Throwable {
        boolean z = true;
        try {
            if (!zzg() && !this.zzn) {
                this.zzi.zzh(zzbhbVar);
                try {
                    zzh();
                    return;
                } catch (Throwable th) {
                    th = th;
                    z = false;
                    if (z) {
                        zzbhbVar.close();
                    }
                    throw th;
                }
            }
            zzbhbVar.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbaa
    public final void zzc(int i) {
        if (zzg()) {
            return;
        }
        this.zzj += 2;
        zzh();
    }

    @Override // com.google.android.libraries.places.internal.zzbaa
    public final void zzd(zzate zzateVar) {
        this.zze = zzateVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbaa
    public final void zze(int i) {
        this.zzb = i;
    }

    final void zzf(zzbgd zzbgdVar) {
        this.zza = zzbgdVar;
    }

    public final boolean zzg() {
        return this.zzi == null;
    }
}
