package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjb extends zzawj {
    private final boolean zza;
    private final zzayn zzb;

    public zzbjb(boolean z, int i, int i2, zzayn zzaynVar) {
        this.zza = z;
        zzkt.zzc(zzaynVar, "autoLoadBalancerFactory");
        this.zzb = zzaynVar;
    }

    @Override // com.google.android.libraries.places.internal.zzawj
    public final zzawe zza(Map map) {
        Object objZzd;
        zzbis zzbisVar;
        zzbga zzbgaVar;
        Map mapZzj;
        try {
            zzawe zzaweVarZzc = this.zzb.zzc(map);
            zzbfx zzbfxVar = null;
            if (zzaweVarZzc == null) {
                objZzd = null;
            } else {
                if (zzaweVarZzc.zzc() != null) {
                    return zzawe.zzb(zzaweVarZzc.zzc());
                }
                objZzd = zzaweVarZzc.zzd();
            }
            boolean z = this.zza;
            if (!z || map == null || (mapZzj = zzbdx.zzj(map, "retryThrottling")) == null) {
                zzbisVar = null;
            } else {
                float fFloatValue = zzbdx.zzb(mapZzj, "maxTokens").floatValue();
                float fFloatValue2 = zzbdx.zzb(mapZzj, "tokenRatio").floatValue();
                zzkt.zzo(fFloatValue > 0.0f, "maxToken should be greater than zero");
                zzkt.zzo(fFloatValue2 > 0.0f, "tokenRatio should be greater than zero");
                zzbisVar = new zzbis(fFloatValue, fFloatValue2);
            }
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            Map mapZzj2 = map == null ? null : zzbdx.zzj(map, "healthCheckConfig");
            List<Map> listZzh = zzbdx.zzh(map, "methodConfig");
            if (listZzh == null) {
                zzbgaVar = new zzbga(null, map2, map3, zzbisVar, objZzd, mapZzj2);
            } else {
                for (Map map4 : listZzh) {
                    zzbfx zzbfxVar2 = new zzbfx(map4, z, 5, 5);
                    List<Map> listZzh2 = zzbdx.zzh(map4, "name");
                    if (listZzh2 != null && !listZzh2.isEmpty()) {
                        for (Map map5 : listZzh2) {
                            String strZze = zzbdx.zze(map5, NotificationCompat.CATEGORY_SERVICE);
                            String strZze2 = zzbdx.zze(map5, FirebaseAnalytics.Param.METHOD);
                            if (zzlb.zzd(strZze)) {
                                zzkt.zzj(zzlb.zzd(strZze2), "missing service name for method %s", strZze2);
                                zzkt.zzj(zzbfxVar == null, "Duplicate default method config in service config %s", map);
                                zzbfxVar = zzbfxVar2;
                            } else if (zzlb.zzd(strZze2)) {
                                zzkt.zzj(!map3.containsKey(strZze), "Duplicate service %s", strZze);
                                map3.put(strZze, zzbfxVar2);
                            } else {
                                String strZze3 = zzawa.zze(strZze, strZze2);
                                zzkt.zzj(!map2.containsKey(strZze3), "Duplicate method name %s", strZze3);
                                map2.put(strZze3, zzbfxVar2);
                            }
                        }
                    }
                }
                zzbgaVar = new zzbga(zzbfxVar, map2, map3, zzbisVar, objZzd, mapZzj2);
            }
            return zzawe.zza(zzbgaVar);
        } catch (RuntimeException e) {
            return zzawe.zzb(zzaxd.zzc.zzg("failed to parse service config").zzf(e));
        }
    }
}
