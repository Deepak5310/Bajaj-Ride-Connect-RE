package com.google.android.libraries.places.internal;

import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzna {
    private static final char[][] zza = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 0, 0);
    private final char[][] zzb;

    private zzna(char[][] cArr) {
        this.zzb = cArr;
    }

    public static zzna zza(Map map) {
        char[][] cArr;
        if (map.isEmpty()) {
            cArr = zza;
        } else {
            char[][] cArr2 = new char[((Character) Collections.max(map.keySet())).charValue() + 1][];
            for (Character ch : map.keySet()) {
                cArr2[ch.charValue()] = ((String) map.get(ch)).toCharArray();
            }
            cArr = cArr2;
        }
        return new zzna(cArr);
    }

    final char[][] zzb() {
        return this.zzb;
    }
}
