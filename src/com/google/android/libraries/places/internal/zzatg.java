package com.google.android.libraries.places.internal;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatg {
    static final zzki zza = zzki.zzb(',');
    private static final zzatg zzb = new zzatg(zzasq.zza, false, new zzatg(new zzasp(), true, new zzatg()));
    private final Map zzc;
    private final byte[] zzd;

    private zzatg() {
        this.zzc = new LinkedHashMap(0);
        this.zzd = new byte[0];
    }

    public static zzatg zzb() {
        return zzb;
    }

    @Nullable
    public final zzate zza(String str) {
        zzatf zzatfVar = (zzatf) this.zzc.get(str);
        if (zzatfVar != null) {
            return zzatfVar.zza;
        }
        return null;
    }

    final byte[] zzc() {
        return this.zzd;
    }

    private zzatg(zzate zzateVar, boolean z, zzatg zzatgVar) {
        String strZzb = zzateVar.zzb();
        zzkt.zzf(!strZzb.contains(","), "Comma is currently not allowed in message encoding");
        int size = zzatgVar.zzc.size();
        LinkedHashMap linkedHashMap = new LinkedHashMap(zzatgVar.zzc.containsKey(zzateVar.zzb()) ? size : size + 1);
        for (zzatf zzatfVar : zzatgVar.zzc.values()) {
            String strZzb2 = zzatfVar.zza.zzb();
            if (!strZzb2.equals(strZzb)) {
                linkedHashMap.put(strZzb2, new zzatf(zzatfVar.zza, zzatfVar.zzb));
            }
        }
        linkedHashMap.put(strZzb, new zzatf(zzateVar, z));
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        this.zzc = mapUnmodifiableMap;
        zzki zzkiVar = zza;
        HashSet hashSet = new HashSet(mapUnmodifiableMap.size());
        for (Map.Entry entry : mapUnmodifiableMap.entrySet()) {
            if (((zzatf) entry.getValue()).zzb) {
                hashSet.add((String) entry.getKey());
            }
        }
        this.zzd = zzkiVar.zzf(Collections.unmodifiableSet(hashSet)).getBytes(Charset.forName(CharEncoding.US_ASCII));
    }
}
