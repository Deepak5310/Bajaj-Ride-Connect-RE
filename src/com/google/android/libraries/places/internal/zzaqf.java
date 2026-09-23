package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaqf extends RuntimeException {
    public zzaqf(zzaoz zzaozVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public final zzaoc zza() {
        return new zzaoc(getMessage());
    }
}
