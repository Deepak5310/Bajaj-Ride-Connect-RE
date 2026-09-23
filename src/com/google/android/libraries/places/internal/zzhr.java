package com.google.android.libraries.places.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.libraries.places.api.net.PlacesClient;
import io.grpc.internal.GrpcUtil;
import java.security.MessageDigest;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhr implements zzhu {
    private final zzhw zza;
    private final Context zzb;
    private final zzid zzc;
    private final zzhr zzd = this;
    private final zzbpd zze = zzarq.zza(zzdj.zza());

    /* synthetic */ zzhr(Context context, zzhw zzhwVar, zzid zzidVar, zzhq zzhqVar) {
        this.zza = zzhwVar;
        this.zzb = context;
        this.zzc = zzidVar;
    }

    private final zzee zzb() {
        return zzef.zza(new zzih(this.zzb), this.zzc, this.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzhu
    public final PlacesClient zza() {
        String strZzk;
        MessageDigest messageDigest;
        byte[] bArrDigest;
        zzij zzijVar = new zzij(this.zzb);
        Context applicationContext = this.zzb.getApplicationContext();
        zzarp.zza(applicationContext);
        RequestQueue requestQueueNewRequestQueue = Volley.newRequestQueue(applicationContext);
        zzarp.zza(requestQueueNewRequestQueue);
        zzem zzemVarZza = zzen.zza(requestQueueNewRequestQueue, new zzgn());
        Context applicationContext2 = this.zzb.getApplicationContext();
        zzarp.zza(applicationContext2);
        RequestQueue requestQueueNewRequestQueue2 = Volley.newRequestQueue(applicationContext2);
        zzarp.zza(requestQueueNewRequestQueue2);
        zzgy zzgyVarZza = zzgz.zza(this.zza, zzijVar, zzemVarZza, zzet.zza(requestQueueNewRequestQueue2), zzb(), (zzdh) this.zze.zzb(), zzga.zza(), zzge.zza(zzhc.zza()), zzgi.zza(), zzgm.zza(zzhc.zza()));
        Context applicationContext3 = this.zzb.getApplicationContext();
        zzarp.zza(applicationContext3);
        FusedLocationProviderClient fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(applicationContext3);
        zzarp.zza(fusedLocationProviderClient);
        zzdx zzdxVarZza = zzdy.zza(fusedLocationProviderClient, new zzhn(new zzhj()));
        Context applicationContext4 = this.zzb.getApplicationContext();
        zzarp.zza(applicationContext4);
        zzec zzecVarZza = zzed.zza(applicationContext4, (zzdh) this.zze.zzb());
        zzbpd zzbpdVar = this.zze;
        zzee zzeeVarZzb = zzb();
        zzdh zzdhVar = (zzdh) zzbpdVar.zzb();
        zzbla zzblaVarZze = zzbla.zze("places.googleapis.com", GrpcUtil.DEFAULT_PORT_SSL);
        zzblaVarZze.zzf();
        zzavg zzavgVarZza = zzblaVarZze.zza();
        Context context = this.zzb;
        Context applicationContext5 = context.getApplicationContext();
        zzarp.zza(applicationContext5);
        Context applicationContext6 = context.getApplicationContext();
        zzarp.zza(applicationContext6);
        try {
            PackageInfo packageInfo = applicationContext6.getPackageManager().getPackageInfo(applicationContext6.getPackageName(), 64);
            strZzk = (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0 || (messageDigest = MessageDigest.getInstance("SHA-1")) == null || (bArrDigest = messageDigest.digest(packageInfo.signatures[0].toByteArray())) == null) ? null : zzqi.zzi().zzk(bArrDigest, 0, bArrDigest.length);
        } catch (Exception unused) {
        }
        return zzfi.zza(this.zza, zzgyVarZza, zzdxVarZza, zzecVarZza, zzeeVarZzb, zzdhVar, zzfq.zza(this.zza, zzavgVarZza, applicationContext5, strZzk, zzb(), (zzdh) this.zze.zzb()));
    }
}
