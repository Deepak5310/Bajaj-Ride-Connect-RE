package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjm {
    private zzbjm() {
    }

    static Set zza(Map map) {
        Set setZzc = zzc(map, "nonFatalStatusCodes");
        if (setZzc == null) {
            return Collections.unmodifiableSet(EnumSet.noneOf(zzawy.class));
        }
        zzlg.zza(!setZzc.contains(zzawy.OK), "%s must not contain OK", "nonFatalStatusCodes");
        return setZzc;
    }

    static Set zzb(Map map) {
        Set setZzc = zzc(map, "retryableStatusCodes");
        zzlg.zza(setZzc != null, "%s is required in retry policy", "retryableStatusCodes");
        zzlg.zza(true ^ setZzc.contains(zzawy.OK), "%s must not contain OK", "retryableStatusCodes");
        return setZzc;
    }

    private static Set zzc(Map map, String str) {
        zzawy zzawyVarZza;
        List listZzg = zzbdx.zzg(map, str);
        if (listZzg == null) {
            return null;
        }
        EnumSet enumSetNoneOf = EnumSet.noneOf(zzawy.class);
        for (Object obj : listZzg) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                int iIntValue = d.intValue();
                zzlg.zza(((double) iIntValue) == d.doubleValue(), "Status code %s is not integral", obj);
                zzawyVarZza = zzaxd.zzd(iIntValue).zza();
                zzlg.zza(zzawyVarZza.zza() == d.intValue(), "Status code %s is not valid", obj);
            } else {
                if (!(obj instanceof String)) {
                    throw new zzlh("Can not convert status code " + String.valueOf(obj) + " to Status.Code, because its type is " + String.valueOf(obj.getClass()));
                }
                try {
                    zzawyVarZza = (zzawy) Enum.valueOf(zzawy.class, (String) obj);
                } catch (IllegalArgumentException e) {
                    throw new zzlh("Status code " + String.valueOf(obj) + " is not valid", e);
                }
            }
            enumSetNoneOf.add(zzawyVarZza);
        }
        return Collections.unmodifiableSet(enumSetNoneOf);
    }
}
