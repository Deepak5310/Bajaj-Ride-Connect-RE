package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkg {
    public static final Appendable zza(Appendable appendable, Iterator it2, zzki zzkiVar, String str) throws IOException {
        if (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            appendable.append(zzki.zzh(entry.getKey()));
            appendable.append("=");
            appendable.append(zzki.zzh(entry.getValue()));
            while (it2.hasNext()) {
                appendable.append(zzkiVar.zza);
                Map.Entry entry2 = (Map.Entry) it2.next();
                appendable.append(zzki.zzh(entry2.getKey()));
                appendable.append("=");
                appendable.append(zzki.zzh(entry2.getValue()));
            }
        }
        return appendable;
    }
}
