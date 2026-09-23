package com.google.android.libraries.places.internal;

import android.content.Context;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.runtime.TransportRuntime;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzih {
    private final Transport zza;

    public zzih(Context context) {
        TransportRuntime.initialize(context.getApplicationContext());
        this.zza = TransportRuntime.getInstance().newFactory("cct").getTransport("LE", zzqm.class, new Transformer() { // from class: com.google.android.libraries.places.internal.zzig
            @Override // com.google.android.datatransport.Transformer
            public final Object apply(Object obj) {
                return ((zzqm) obj).zzaj();
            }
        });
    }

    public final void zza(zzqm zzqmVar) {
        this.zza.send(Event.ofData(zzqmVar));
    }
}
