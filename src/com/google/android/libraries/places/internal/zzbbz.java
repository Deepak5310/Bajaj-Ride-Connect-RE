package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.URI;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbz extends zzawl {
    private static final boolean zza = zzaui.zza(zzbbz.class.getClassLoader());

    @Override // com.google.android.libraries.places.internal.zzawf
    public final zzawk zza(URI uri, zzawd zzawdVar) {
        if (!"dns".equals(uri.getScheme())) {
            return null;
        }
        String path = uri.getPath();
        zzkt.zzc(path, "targetPath");
        zzkt.zzk(path.startsWith(RemoteSettings.FORWARD_SLASH_STRING), "the path component (%s) of the target (%s) must start with '/'", path, uri);
        return new zzbby(uri.getAuthority(), path.substring(1), zzawdVar, zzbcu.zzp, zzla.zzb(), zza);
    }

    @Override // com.google.android.libraries.places.internal.zzawf
    public final String zzb() {
        return "dns";
    }

    @Override // com.google.android.libraries.places.internal.zzawl
    public final int zzc() {
        return 5;
    }

    @Override // com.google.android.libraries.places.internal.zzawl
    protected final boolean zzd() {
        return true;
    }
}
