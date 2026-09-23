package com.google.android.libraries.places.internal;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzol {
    private static final zzon zza = zzb(zzon.zzd);

    private static zzon zzb(String[] strArr) {
        zzon zzonVarZza;
        try {
            zzonVarZza = zzoo.zza();
        } catch (NoClassDefFoundError unused) {
            zzonVarZza = null;
        }
        if (zzonVarZza != null) {
            return zzonVarZza;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            try {
                return (zzon) Class.forName(str).getConstructor(null).newInstance(null);
            } catch (Throwable th) {
                th = th;
                if (th instanceof InvocationTargetException) {
                    th = th.getCause();
                }
                sb.append('\n');
                sb.append(str);
                sb.append(": ");
                sb.append(th);
            }
        }
        throw new IllegalStateException(sb.insert(0, "No logging platforms found:").toString());
    }
}
