package com.google.android.libraries.places.internal;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.CharCompanionObject;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznh {
    private final Map zza = new HashMap();

    private zznh() {
    }

    public final zznd zza() {
        return new zznf(this, this.zza, (char) 0, CharCompanionObject.MAX_VALUE);
    }

    public final zznh zzb(char c, String str) {
        this.zza.put(Character.valueOf(c), str);
        return this;
    }

    /* synthetic */ zznh(zzng zzngVar) {
    }
}
