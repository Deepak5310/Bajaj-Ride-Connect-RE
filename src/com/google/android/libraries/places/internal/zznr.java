package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zznr {
    private final String zza;
    private final Class zzb;
    private final boolean zzc;

    protected zznr(String str, Class cls, boolean z) {
        this(str, cls, z, true);
    }

    public static zznr zza(String str, Class cls) {
        return new zznr(str, cls, false, false);
    }

    public final String toString() {
        Class cls = this.zzb;
        return getClass().getName() + RemoteSettings.FORWARD_SLASH_STRING + this.zza + "[" + cls.getName() + "]";
    }

    public final boolean zzb() {
        return this.zzc;
    }

    private zznr(String str, Class cls, boolean z, boolean z2) {
        zzpr.zzb(str);
        this.zza = str;
        this.zzb = cls;
        this.zzc = z;
        System.identityHashCode(this);
        for (int i = 0; i < 5; i++) {
        }
    }
}
