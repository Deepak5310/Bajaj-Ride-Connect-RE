package com.google.android.libraries.places.internal;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaun {
    private List zza;
    private final zzarv zzb = zzarv.zza;
    private final Object[][] zzc = (Object[][]) Array.newInstance((Class<?>) Object.class, 0, 2);

    zzaun() {
    }

    public final zzaun zza(List list) {
        zzkt.zzf(!list.isEmpty(), "addrs is empty");
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        return this;
    }

    public final zzaup zzb() {
        return new zzaup(this.zza, this.zzb, this.zzc, null);
    }
}
