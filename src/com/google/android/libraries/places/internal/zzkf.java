package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkf extends zzki {
    final /* synthetic */ zzki zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzkf(zzki zzkiVar, zzki zzkiVar2) {
        super(zzkiVar2, null);
        this.zza = zzkiVar;
    }

    @Override // com.google.android.libraries.places.internal.zzki
    public final Appendable zza(Appendable appendable, Iterator it2) throws IOException {
        zzkt.zzc(it2, "parts");
        while (it2.hasNext()) {
            Object next = it2.next();
            if (next != null) {
                appendable.append(zzki.zzh(next));
                break;
            }
        }
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (next2 != null) {
                appendable.append(this.zza.zza);
                appendable.append(zzki.zzh(next2));
            }
        }
        return appendable;
    }
}
