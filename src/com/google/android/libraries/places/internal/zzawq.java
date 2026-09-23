package com.google.android.libraries.places.internal;

import androidx.core.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawq {
    private static final Logger zza = Logger.getLogger(zzawq.class.getName());
    private static zzawq zzb;
    private final zzawf zzc = new zzawn(this, null);
    private String zzd = EnvironmentCompat.MEDIA_UNKNOWN;
    private final LinkedHashSet zze = new LinkedHashSet();
    private zzma zzf = zzma.zzd();

    public static synchronized zzawq zzb() {
        if (zzb == null) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(Class.forName("com.google.android.libraries.places.internal.zzbbz"));
            } catch (ClassNotFoundException e) {
                zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getHardCodedClasses", "Unable to find DNS NameResolver", (Throwable) e);
            }
            List<zzawl> listZza = zzawx.zza(zzawl.class, Collections.unmodifiableList(arrayList), zzawl.class.getClassLoader(), new zzawp(null));
            if (listZza.isEmpty()) {
                zza.logp(Level.WARNING, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
            }
            zzb = new zzawq();
            for (zzawl zzawlVar : listZza) {
                zza.logp(Level.FINE, "io.grpc.NameResolverRegistry", "getDefaultRegistry", "Service loader found ".concat(String.valueOf(String.valueOf(zzawlVar))));
                zzb.zze(zzawlVar);
            }
            zzb.zzf();
        }
        return zzb;
    }

    private final synchronized void zze(zzawl zzawlVar) {
        zzawlVar.zzd();
        this.zze.add(zzawlVar);
    }

    private final synchronized void zzf() {
        HashMap map = new HashMap();
        String strZzb = EnvironmentCompat.MEDIA_UNKNOWN;
        byte b = -2147483648;
        for (zzawl zzawlVar : this.zze) {
            String strZzb2 = zzawlVar.zzb();
            if (((zzawl) map.get(strZzb2)) != null) {
                zzawlVar.zzc();
            } else {
                map.put(strZzb2, zzawlVar);
            }
            zzawlVar.zzc();
            if (b < 5) {
                zzawlVar.zzc();
                strZzb = zzawlVar.zzb();
            }
            b = 5;
        }
        this.zzf = zzma.zzc(map.entrySet());
        this.zzd = strZzb;
    }

    public final zzawf zza() {
        return this.zzc;
    }

    final synchronized Map zzd() {
        return this.zzf;
    }
}
