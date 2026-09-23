package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0012\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "third_party.java_src.okio_okio-jvm"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class zzbpq implements zzbqc {
    private final InputStream zza;
    private final zzbqf zzb;

    public zzbpq(InputStream input, zzbqf timeout) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(timeout, "timeout");
        this.zza = input;
        this.zzb = timeout;
    }

    @Override // com.google.android.libraries.places.internal.zzbqc, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza.close();
    }

    public final String toString() {
        return "source(" + this.zza + ")";
    }

    @Override // com.google.android.libraries.places.internal.zzbqc
    public final long zza(zzbpl sink, long j) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        try {
            zzbqf.zzb();
            zzbpx zzbpxVarZzB = sink.zzB(1);
            int i = this.zza.read(zzbpxVarZzB.zzb, zzbpxVarZzB.zzd, (int) Math.min(j, 8192 - zzbpxVarZzB.zzd));
            if (i != -1) {
                zzbpxVarZzB.zzd += i;
                long j2 = i;
                sink.zzE(sink.getZzb() + j2);
                return j2;
            }
            if (zzbpxVarZzB.zzc != zzbpxVarZzB.zzd) {
                return -1L;
            }
            sink.zza = zzbpxVarZzB.zza();
            zzbpy.zzb(zzbpxVarZzB);
            return -1L;
        } catch (AssertionError e) {
            if (zzbps.zza(e)) {
                throw new IOException(e);
            }
            throw e;
        }
    }
}
