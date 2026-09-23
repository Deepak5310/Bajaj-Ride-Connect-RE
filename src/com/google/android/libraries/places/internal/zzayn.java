package com.google.android.libraries.places.internal;

import io.grpc.internal.GrpcUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayn {
    private final zzavf zza;
    private final String zzb;

    zzayn(zzavf zzavfVar, String str) {
        zzkt.zzc(zzavfVar, "registry");
        this.zza = zzavfVar;
        this.zzb = GrpcUtil.DEFAULT_LB_POLICY;
    }

    static /* bridge */ /* synthetic */ zzavd zza(zzayn zzaynVar, String str, String str2) throws zzaym {
        zzavd zzavdVarZza = zzaynVar.zza.zza(GrpcUtil.DEFAULT_LB_POLICY);
        if (zzavdVarZza != null) {
            return zzavdVarZza;
        }
        throw new zzaym("Trying to load 'pick_first' because using default policy, but it's unavailable", null);
    }

    @Nullable
    final zzawe zzc(Map map) {
        List<zzbjk> listUnmodifiableList;
        String strZze;
        if (map != null) {
            try {
                ArrayList arrayList = new ArrayList();
                if (map.containsKey("loadBalancingConfig")) {
                    arrayList.addAll(zzbdx.zzh(map, "loadBalancingConfig"));
                }
                if (arrayList.isEmpty() && (strZze = zzbdx.zze(map, "loadBalancingPolicy")) != null) {
                    arrayList.add(Collections.singletonMap(strZze.toLowerCase(Locale.ROOT), Collections.emptyMap()));
                }
                List<Map> listUnmodifiableList2 = Collections.unmodifiableList(arrayList);
                if (listUnmodifiableList2 == null) {
                    listUnmodifiableList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Map map2 : listUnmodifiableList2) {
                        if (map2.size() != 1) {
                            throw new RuntimeException("There are " + map2.size() + " fields in a LoadBalancingConfig object. Exactly one is expected. Config=" + String.valueOf(map2));
                        }
                        String str = (String) ((Map.Entry) map2.entrySet().iterator().next()).getKey();
                        arrayList2.add(new zzbjk(str, zzbdx.zzj(map2, str)));
                    }
                    listUnmodifiableList = Collections.unmodifiableList(arrayList2);
                }
            } catch (RuntimeException e) {
                return zzawe.zzb(zzaxd.zzc.zzg("can't parse load balancer configuration").zzf(e));
            }
        } else {
            listUnmodifiableList = null;
        }
        if (listUnmodifiableList == null || listUnmodifiableList.isEmpty()) {
            return null;
        }
        zzavf zzavfVar = this.zza;
        ArrayList arrayList3 = new ArrayList();
        for (zzbjk zzbjkVar : listUnmodifiableList) {
            String strZza = zzbjkVar.zza();
            zzavd zzavdVarZza = zzavfVar.zza(strZza);
            if (zzavdVarZza != null) {
                if (!arrayList3.isEmpty()) {
                    Logger.getLogger(zzbjm.class.getName()).logp(Level.FINEST, "io.grpc.internal.ServiceConfigUtil", "selectLbPolicyFromList", "{0} specified by Service Config are not available", arrayList3);
                }
                zzawe zzaweVarZzc = zzavdVarZza.zzc(zzbjkVar.zzb());
                return zzaweVarZzc.zzc() == null ? zzawe.zza(new zzbjl(zzavdVarZza, zzaweVarZzc.zzd())) : zzaweVarZzc;
            }
            arrayList3.add(strZza);
        }
        return zzawe.zzb(zzaxd.zzc.zzg("None of " + arrayList3.toString() + " specified by Service Config are available."));
    }
}
