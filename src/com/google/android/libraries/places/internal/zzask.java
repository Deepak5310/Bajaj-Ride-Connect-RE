package com.google.android.libraries.places.internal;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzask {
    private static final zzasf zza = new zzash();

    public static zzasb zza(zzasb zzasbVar, List list) {
        zzkt.zzc(zzasbVar, "channel");
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzasbVar = new zzasj(zzasbVar, (zzasg) it2.next(), null);
        }
        return zzasbVar;
    }
}
