package com.google.android.libraries.places.internal;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzati {
    public static final zzart zza = zzart.zza("io.grpc.EquivalentAddressGroup.ATTR_AUTHORITY_OVERRIDE");
    private final List zzb;
    private final zzarv zzc;
    private final int zzd;

    public zzati(List list, zzarv zzarvVar) {
        zzkt.zzf(!list.isEmpty(), "addrs is empty");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.zzb = listUnmodifiableList;
        zzkt.zzc(zzarvVar, "attrs");
        this.zzc = zzarvVar;
        this.zzd = listUnmodifiableList.hashCode();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzati)) {
            return false;
        }
        zzati zzatiVar = (zzati) obj;
        if (this.zzb.size() != zzatiVar.zzb.size()) {
            return false;
        }
        for (int i = 0; i < this.zzb.size(); i++) {
            if (!((SocketAddress) this.zzb.get(i)).equals(zzatiVar.zzb.get(i))) {
                return false;
            }
        }
        return this.zzc.equals(zzatiVar.zzc);
    }

    public final int hashCode() {
        return this.zzd;
    }

    public final String toString() {
        zzarv zzarvVar = this.zzc;
        return "[" + String.valueOf(this.zzb) + RemoteSettings.FORWARD_SLASH_STRING + zzarvVar.toString() + "]";
    }

    public final zzarv zza() {
        return this.zzc;
    }

    public final List zzb() {
        return this.zzb;
    }
}
