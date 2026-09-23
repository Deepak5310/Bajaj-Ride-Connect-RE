package com.google.android.libraries.places.internal;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzgo extends zzeu {
    private final Locale zza;
    private final String zzb;
    private final zzij zzc;

    protected zzgo(zzhx zzhxVar, Locale locale, String str, boolean z, zzij zzijVar) {
        super(zzhxVar);
        this.zza = locale;
        this.zzb = str;
        this.zzc = zzijVar;
    }

    protected static void zzg(Map map, String str, Object obj, Object obj2) {
        String string = obj != null ? obj.toString() : null;
        if (TextUtils.isEmpty(string)) {
            return;
        }
        map.put(str, string);
    }

    @Override // com.google.android.libraries.places.internal.zzeu
    protected final String zzc() {
        zzha zzhaVar = new zzha(zze(), this.zzb);
        zzhaVar.zza(this.zza);
        zzhaVar.zzb(zzf());
        return zzhaVar.zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzeu
    protected final Map zzd() {
        HashMap map = new HashMap();
        map.putAll(this.zzc.zza());
        map.put("X-Places-Android-Sdk", "3.3.0");
        return map;
    }

    protected abstract String zze();

    protected abstract Map zzf();
}
