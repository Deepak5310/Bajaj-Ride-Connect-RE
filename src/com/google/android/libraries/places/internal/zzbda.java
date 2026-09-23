package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbda {
    private final ArrayList zza = new ArrayList();

    public final String toString() {
        return this.zza.toString();
    }

    public final zzbda zza(@Nullable Object obj) {
        this.zza.add(obj.toString());
        return this;
    }

    public final zzbda zzb(String str, @Nullable Object obj) {
        this.zza.add(str + "=" + String.valueOf(obj));
        return this;
    }
}
