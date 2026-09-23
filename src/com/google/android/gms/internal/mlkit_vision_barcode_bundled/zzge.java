package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.mlkit:barcode-scanning@@17.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class zzge extends zzgl {
    zzge(int i) {
        super(i, null);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzgl
    public final void zza() {
        if (!zzj()) {
            for (int i = 0; i < zzb(); i++) {
                ((zzdr) zzg(i).getKey()).zzg();
            }
            Iterator it2 = zzc().iterator();
            while (it2.hasNext()) {
                ((zzdr) ((Map.Entry) it2.next()).getKey()).zzg();
            }
        }
        super.zza();
    }
}
