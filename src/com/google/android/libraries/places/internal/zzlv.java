package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlv extends zzli {
    private final zzlx zza;

    zzlv(zzlx zzlxVar, int i) {
        super(zzlxVar.size(), i);
        this.zza = zzlxVar;
    }

    @Override // com.google.android.libraries.places.internal.zzli
    protected final Object zza(int i) {
        return this.zza.get(i);
    }
}
