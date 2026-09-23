package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzavf {
    private static final Logger zza = Logger.getLogger(zzavf.class.getName());
    private static zzavf zzb;
    private static final Iterable zzc;
    private final LinkedHashSet zzd = new LinkedHashSet();
    private final LinkedHashMap zze = new LinkedHashMap();

    static {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("com.google.android.libraries.places.internal.zzbgw"));
        } catch (ClassNotFoundException e) {
            zza.logp(Level.WARNING, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find pick-first LoadBalancer", (Throwable) e);
        }
        try {
            arrayList.add(Class.forName("com.google.android.libraries.places.internal.zzboy"));
        } catch (ClassNotFoundException e2) {
            zza.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getHardCodedClasses", "Unable to find round-robin LoadBalancer", (Throwable) e2);
        }
        zzc = Collections.unmodifiableList(arrayList);
    }

    public static synchronized zzavf zzb() {
        if (zzb == null) {
            List<zzavd> listZza = zzawx.zza(zzavd.class, zzc, zzavd.class.getClassLoader(), new zzave());
            zzb = new zzavf();
            for (zzavd zzavdVar : listZza) {
                zza.logp(Level.FINE, "io.grpc.LoadBalancerRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(String.valueOf(zzavdVar))));
                zzb.zzc(zzavdVar);
            }
            zzb.zzd();
        }
        return zzb;
    }

    private final synchronized void zzc(zzavd zzavdVar) {
        zzavdVar.zze();
        this.zzd.add(zzavdVar);
    }

    private final synchronized void zzd() {
        this.zze.clear();
        for (zzavd zzavdVar : this.zzd) {
            String strZzd = zzavdVar.zzd();
            if (((zzavd) this.zze.get(strZzd)) != null) {
                zzavdVar.zzb();
            } else {
                this.zze.put(strZzd, zzavdVar);
            }
        }
    }

    @Nullable
    public final synchronized zzavd zza(String str) {
        return (zzavd) this.zze.get(str);
    }
}
