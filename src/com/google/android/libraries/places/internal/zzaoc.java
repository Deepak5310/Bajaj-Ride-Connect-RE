package com.google.android.libraries.places.internal;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzaoc extends IOException {
    private zzaoz zza;
    private boolean zzb;

    public zzaoc(IOException iOException) {
        super(iOException.getMessage(), iOException);
        this.zza = null;
    }

    static zzaob zza() {
        return new zzaob("Protocol message tag had invalid wire type.");
    }

    static zzaoc zzb() {
        return new zzaoc("Protocol message end-group tag did not match expected tag.");
    }

    static zzaoc zzc() {
        return new zzaoc("Protocol message contained an invalid tag (zero).");
    }

    static zzaoc zzd() {
        return new zzaoc("Protocol message had invalid UTF-8.");
    }

    static zzaoc zze() {
        return new zzaoc("CodedInputStream encountered a malformed varint.");
    }

    static zzaoc zzf() {
        return new zzaoc("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzaoc zzg() {
        return new zzaoc("Failed to parse the message.");
    }

    static zzaoc zzi() {
        return new zzaoc("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzaoc zzj() {
        return new zzaoc("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    public final zzaoc zzh(zzaoz zzaozVar) {
        this.zza = zzaozVar;
        return this;
    }

    final void zzk() {
        this.zzb = true;
    }

    final boolean zzl() {
        return this.zzb;
    }

    public zzaoc(String str) {
        super(str);
        this.zza = null;
    }
}
