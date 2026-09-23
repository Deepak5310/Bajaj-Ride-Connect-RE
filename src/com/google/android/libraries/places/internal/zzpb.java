package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpb extends zzop {
    private static final Set zza;
    private static final zzoh zzb;
    private static final zzoy zzc;
    private final String zzd;
    private final zznu zze;
    private final Level zzf;
    private final Set zzg;
    private final zzoh zzh;

    static {
        Set setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(zzno.zza, zznt.zza)));
        zza = setUnmodifiableSet;
        zzb = zzok.zza(setUnmodifiableSet).zzd();
        zzc = new zzoy();
    }

    /* synthetic */ zzpb(String str, String str2, boolean z, zznu zznuVar, Level level, Set set, zzoh zzohVar, zzpa zzpaVar) {
        super(str2);
        if (str2.length() > 23) {
            int i = -1;
            for (int length = str2.length() - 1; length >= 0; length--) {
                char cCharAt = str2.charAt(length);
                if (cCharAt == '.' || cCharAt == '$') {
                    i = length;
                    break;
                }
            }
            str2 = str2.substring(i + 1);
        }
        String strConcat = "".concat(String.valueOf(str2));
        this.zzd = strConcat.substring(0, Math.min(strConcat.length(), 23));
        this.zze = zznuVar;
        this.zzf = level;
        this.zzg = set;
        this.zzh = zzohVar;
    }

    public static zzoy zzc() {
        return zzc;
    }
}
