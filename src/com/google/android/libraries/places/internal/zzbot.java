package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbot extends zzavb {
    private static final Logger zzf = Logger.getLogger(zzbot.class.getName());
    protected boolean zzc;
    protected zzasu zze;
    private final zzaus zzh;
    private final Map zzg = new LinkedHashMap();
    protected final zzbgw zzd = new zzbgw();

    protected zzbot(zzaus zzausVar) {
        this.zzh = zzausVar;
        zzf.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "<init>", "Created");
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zza(zzaxd zzaxdVar) {
        if (this.zze != zzasu.READY) {
            this.zzh.zzd(zzasu.TRANSIENT_FAILURE, new zzaur(zzaut.zzb(zzaxdVar)));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zzd() {
        zzf.logp(Level.INFO, "io.grpc.util.MultiChildLoadBalancer", "shutdown", "Shutdown");
        Iterator it2 = this.zzg.values().iterator();
        while (it2.hasNext()) {
            ((zzbor) it2.next()).zzk();
        }
        this.zzg.clear();
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final boolean zze(zzaux zzauxVar) {
        zzati zzatiVar;
        boolean z = true;
        try {
            this.zzc = true;
            zzf.logp(Level.FINE, "io.grpc.util.MultiChildLoadBalancer", "acceptResolvedAddressesInternal", "Received resolution result: {0}", zzauxVar);
            HashMap map = new HashMap();
            Iterator it2 = zzauxVar.zze().iterator();
            while (it2.hasNext()) {
                zzbos zzbosVar = new zzbos((zzati) it2.next());
                zzbor zzborVar = (zzbor) this.zzg.get(zzbosVar);
                if (zzborVar != null) {
                    map.put(zzbosVar, zzborVar);
                } else {
                    map.put(zzbosVar, new zzbor(this, zzbosVar, this.zzd, null, zzb));
                }
            }
            if (map.isEmpty()) {
                zza(zzaxd.zzp.zzg("NameResolver returned no usable address. ".concat(String.valueOf(String.valueOf(zzauxVar)))));
                z = false;
            } else {
                for (Map.Entry entry : map.entrySet()) {
                    Object key = entry.getKey();
                    zzavd zzavdVarZzc = ((zzbor) entry.getValue()).zzc();
                    if (this.zzg.containsKey(key)) {
                        zzbor zzborVar2 = (zzbor) this.zzg.get(key);
                        if (zzborVar2.zzm()) {
                            zzborVar2.zzi(zzavdVarZzc);
                        }
                    } else {
                        this.zzg.put(key, (zzbor) entry.getValue());
                    }
                    zzboo zzbooVar = ((zzbor) this.zzg.get(key)).zzd;
                    Object zzbosVar2 = key instanceof zzati ? new zzbos((zzati) key) : key;
                    zzkt.zzf(zzbosVar2 instanceof zzbos, "key is wrong type");
                    Iterator it3 = zzauxVar.zze().iterator();
                    do {
                        if (!it3.hasNext()) {
                            zzatiVar = null;
                            break;
                        }
                        zzatiVar = (zzati) it3.next();
                    } while (!zzbosVar2.equals(new zzbos(zzatiVar)));
                    zzkt.zzc(zzatiVar, String.valueOf(String.valueOf(zzbosVar2)).concat(" no longer present in load balancer children"));
                    zzauv zzauvVarZzc = zzauxVar.zzc();
                    zzauvVarZzc.zza(Collections.singletonList(zzatiVar));
                    zzauvVarZzc.zzc(null);
                    zzaux zzauxVarZzd = zzauvVarZzc.zzd();
                    ((zzbor) this.zzg.get(key)).zzj(zzauxVarZzd);
                    zzbooVar.zzg().zzb(zzauxVarZzd);
                }
                zzlx zzlxVarZzj = zzlx.zzj(this.zzg.keySet());
                int size = zzlxVarZzj.size();
                for (int i = 0; i < size; i++) {
                    Object obj = zzlxVarZzj.get(i);
                    if (!map.containsKey(obj)) {
                        ((zzbor) this.zzg.get(obj)).zzh();
                    }
                }
                zzl();
            }
            this.zzc = false;
            return z;
        } catch (Throwable th) {
            this.zzc = false;
            throw th;
        }
    }

    protected final zzaus zzh() {
        return this.zzh;
    }

    protected final Collection zzi() {
        return this.zzg.values();
    }

    protected void zzl() {
        throw null;
    }
}
