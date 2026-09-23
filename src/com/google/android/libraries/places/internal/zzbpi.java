package com.google.android.libraries.places.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"okio/AsyncTimeout$source$1", "Lokio/Source;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/AsyncTimeout;", "toString", "", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class zzbpi implements zzbqc {
    final /* synthetic */ zzbpj zza;
    final /* synthetic */ zzbqc zzb;

    zzbpi(zzbpj zzbpjVar, zzbqc zzbqcVar) {
        this.zza = zzbpjVar;
        this.zzb = zzbqcVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbqc, java.io.Closeable, java.lang.AutoCloseable
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

    public final String toString() {
        return "AsyncTimeout.source(" + this.zzb + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbqc
    public final long zza(zzbpl sink, long j) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        zzbpj zzbpjVar = this.zza;
        try {
            try {
                long jZza = this.zzb.zza(sink, j);
                zzbpg.zza(zzbpj.zza, zzbpjVar);
                return jZza;
            } catch (IOException e) {
                zzbpg.zza(zzbpj.zza, zzbpjVar);
                throw e;
            }
        } catch (Throwable th) {
            zzbpg.zza(zzbpj.zza, zzbpjVar);
            throw th;
        }
    }
}
