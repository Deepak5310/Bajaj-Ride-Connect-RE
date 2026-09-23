package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzlm extends zzlp {
    @Override // com.google.android.libraries.places.internal.zzlp
    public final int hashCode() {
        return ~this.zza.hashCode();
    }

    public final String toString() {
        return RemoteSettings.FORWARD_SLASH_STRING + this.zza.toString() + "\\";
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    final void zzc(StringBuilder sb) {
        sb.append('(');
        sb.append(this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    final void zzd(StringBuilder sb) {
        sb.append(this.zza);
        sb.append(']');
    }

    @Override // com.google.android.libraries.places.internal.zzlp
    final boolean zze(Comparable comparable) {
        int i = zzmk.zzc;
        return this.zza.compareTo(comparable) < 0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzlm(Comparable comparable) {
        super(comparable);
        comparable.getClass();
    }
}
