package com.google.android.libraries.places.internal;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0016\b\u0000\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0004\b\u0002\u0010\fJ\r\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0003J\u000f\u0010\u000f\u001a\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0000¢\u0006\u0004\b\u0014\u0010\u0010J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0018\u001a\u00020\u0000¢\u0006\u0004\b\u0018\u0010\u0010J\u001d\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0006¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0016\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u001dR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010 R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010 ¨\u0006#"}, d2 = {"Lokio/Segment;", "", "<init>", "()V", "", "data", "", "pos", "limit", "", "shared", "owner", "([BIIZZ)V", "", "compact", "pop", "()Lokio/Segment;", "segment", "push", "(Lokio/Segment;)Lokio/Segment;", "sharedCopy", "byteCount", "split", "(I)Lokio/Segment;", "unsharedCopy", "sink", "writeTo", "(Lokio/Segment;I)V", "[B", "I", "next", "Lokio/Segment;", "Z", "prev", "Companion", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class zzbpx {
    public static final zzbpw zza = new zzbpw(null);
    public final byte[] zzb;
    public int zzc;
    public int zzd;
    public boolean zze;
    public final boolean zzf;
    public zzbpx zzg;
    public zzbpx zzh;

    public zzbpx() {
        this.zzb = new byte[8192];
        this.zzf = true;
        this.zze = false;
    }

    public zzbpx(byte[] data, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.zzb = data;
        this.zzc = i;
        this.zzd = i2;
        this.zze = z;
        this.zzf = false;
    }

    public final zzbpx zza() {
        zzbpx zzbpxVar = this.zzg;
        if (zzbpxVar == this) {
            zzbpxVar = null;
        }
        zzbpx zzbpxVar2 = this.zzh;
        Intrinsics.checkNotNull(zzbpxVar2);
        zzbpxVar2.zzg = this.zzg;
        zzbpx zzbpxVar3 = this.zzg;
        Intrinsics.checkNotNull(zzbpxVar3);
        zzbpxVar3.zzh = this.zzh;
        this.zzg = null;
        this.zzh = null;
        return zzbpxVar;
    }

    public final zzbpx zzb(zzbpx segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.zzh = this;
        segment.zzg = this.zzg;
        zzbpx zzbpxVar = this.zzg;
        Intrinsics.checkNotNull(zzbpxVar);
        zzbpxVar.zzh = segment;
        this.zzg = segment;
        return segment;
    }

    public final zzbpx zzc() {
        this.zze = true;
        return new zzbpx(this.zzb, this.zzc, this.zzd, true, false);
    }

    public final void zze(zzbpx sink, int i) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.zzf) {
            throw new IllegalStateException("only owner can write");
        }
        int i2 = sink.zzd;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (sink.zze) {
                throw new IllegalArgumentException();
            }
            int i4 = sink.zzc;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.zzb;
            ArraysKt.copyInto$default(bArr, bArr, 0, i4, i2, 2, (Object) null);
            i2 = sink.zzd - sink.zzc;
            sink.zzd = i2;
            sink.zzc = 0;
        }
        byte[] bArr2 = this.zzb;
        byte[] bArr3 = sink.zzb;
        int i5 = this.zzc;
        ArraysKt.copyInto(bArr2, bArr3, i2, i5, i5 + i);
        sink.zzd += i;
        this.zzc += i;
    }

    public final zzbpx zzd(int i) {
        zzbpx zzbpxVarZza;
        if (i > this.zzd - this.zzc) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i >= 1024) {
            zzbpxVarZza = zzc();
        } else {
            byte[] bArr = this.zzb;
            zzbpxVarZza = zzbpy.zza();
            byte[] bArr2 = zzbpxVarZza.zzb;
            int i2 = this.zzc;
            ArraysKt.copyInto$default(bArr, bArr2, 0, i2, i2 + i, 2, (Object) null);
        }
        zzbpxVarZza.zzd = zzbpxVarZza.zzc + i;
        this.zzc += i;
        zzbpx zzbpxVar = this.zzh;
        Intrinsics.checkNotNull(zzbpxVar);
        zzbpxVar.zzb(zzbpxVarZza);
        return zzbpxVarZza;
    }
}
