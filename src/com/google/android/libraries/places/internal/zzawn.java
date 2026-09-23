package com.google.android.libraries.places.internal;

import java.net.URI;
import java.util.Locale;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzawn extends zzawf {
    final /* synthetic */ zzawq zza;

    /* synthetic */ zzawn(zzawq zzawqVar, zzawm zzawmVar) {
        this.zza = zzawqVar;
    }

    @Override // com.google.android.libraries.places.internal.zzawf
    @Nullable
    public final zzawk zza(URI uri, zzawd zzawdVar) {
        zzawl zzawlVar;
        String scheme = uri.getScheme();
        if (scheme == null || (zzawlVar = (zzawl) this.zza.zzd().get(scheme.toLowerCase(Locale.US))) == null) {
            return null;
        }
        return zzawlVar.zza(uri, zzawdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzawf
    public final String zzb() {
        String str;
        synchronized (this.zza) {
            str = this.zza.zzd;
        }
        return str;
    }
}
