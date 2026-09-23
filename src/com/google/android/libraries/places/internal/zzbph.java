package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"okio/AsyncTimeout$sink$1", "Lokio/Sink;", "close", "", "flush", "timeout", "Lokio/AsyncTimeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class zzbph implements zzbqa {
    final /* synthetic */ zzbpj zza;
    final /* synthetic */ zzbqa zzb;

    zzbph(zzbpj zzbpjVar, zzbqa zzbqaVar) {
        this.zza = zzbpjVar;
        this.zzb = zzbqaVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqa, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        zzbpj zzbpjVar = this.zza;
        try {
            try {
                this.zzb.close();
                Unit unit = Unit.INSTANCE;
                zzbpg.zza(zzbpj.zza, zzbpjVar);
            } catch (IOException e) {
                zzbpg.zza(zzbpj.zza, zzbpjVar);
                throw e;
            }
        } catch (Throwable th) {
            zzbpg.zza(zzbpj.zza, zzbpjVar);
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbqa, java.io.Flushable
    public final void flush() {
        zzbpj zzbpjVar = this.zza;
        try {
            try {
                this.zzb.flush();
                Unit unit = Unit.INSTANCE;
                zzbpg.zza(zzbpj.zza, zzbpjVar);
            } catch (IOException e) {
                zzbpg.zza(zzbpj.zza, zzbpjVar);
                throw e;
            }
        } catch (Throwable th) {
            zzbpg.zza(zzbpj.zza, zzbpjVar);
            throw th;
        }
    }

    public final String toString() {
        return "AsyncTimeout.sink(" + this.zzb + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbqa
    public final void zzn(zzbpl source, long j) {
        Intrinsics.checkNotNullParameter(source, "source");
        zzbpf.zzb(source.getZzb(), 0L, j);
        while (true) {
            long j2 = 0;
            if (j <= 0) {
                return;
            }
            zzbpx zzbpxVar = source.zza;
            Intrinsics.checkNotNull(zzbpxVar);
            while (j2 < PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                j2 += (long) (zzbpxVar.zzd - zzbpxVar.zzc);
                if (j2 >= j) {
                    j2 = j;
                    break;
                } else {
                    zzbpxVar = zzbpxVar.zzg;
                    Intrinsics.checkNotNull(zzbpxVar);
                }
            }
            zzbpj zzbpjVar = this.zza;
            try {
                this.zzb.zzn(source, j2);
                Unit unit = Unit.INSTANCE;
                zzbpg.zza(zzbpj.zza, zzbpjVar);
                j -= j2;
            } catch (IOException e) {
                throw e;
            } finally {
                zzbpg.zza(zzbpj.zza, zzbpjVar);
            }
        }
    }
}
