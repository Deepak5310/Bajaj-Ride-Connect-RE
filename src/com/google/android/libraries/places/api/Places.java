package com.google.android.libraries.places.api;

import android.content.Context;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzhs;
import com.google.android.libraries.places.internal.zzht;
import com.google.android.libraries.places.internal.zzhu;
import com.google.android.libraries.places.internal.zzhw;
import com.google.android.libraries.places.internal.zzid;
import com.google.android.libraries.places.internal.zzif;
import com.google.android.libraries.places.internal.zzkt;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class Places {
    private static final zzhw zza = new zzhw();
    private static volatile zzhu zzb;

    private Places() {
    }

    public static synchronized PlacesClient createClient(Context context) {
        try {
            zzkt.zzc(context, "Context must not be null.");
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
        return zza(context, zzid.zzd(context).zze());
    }

    public static synchronized void deinitialize() {
        zza.zzc();
    }

    public static void initialize(Context context, String str) {
        try {
            zzb(context, str, null, false, false);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public static void initializeWithNewPlacesApiEnabled(Context context, String str) {
        try {
            zzb(context, str, null, false, true);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public static synchronized boolean isInitialized() {
        try {
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
        return zza.zzg();
    }

    public static synchronized PlacesClient zza(Context context, zzid zzidVar) {
        zzht zzhtVarZza;
        try {
            zzkt.zzc(context, "Context must not be null.");
            zzkt.zzo(isInitialized(), "Places must be initialized first.");
            zzhtVarZza = zzhs.zza();
            zzhtVarZza.zzc(context);
            zzhtVarZza.zza(zza);
            zzhtVarZza.zzb(zzidVar);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
        return zzhtVarZza.zzd().zza();
    }

    public static synchronized void zzb(Context context, String str, Locale locale, boolean z, boolean z2) {
        try {
            try {
                zzkt.zzc(context, "Application context must not be null.");
                zzkt.zzc(str, "API Key must not be null.");
                zzkt.zzf(!str.isEmpty(), "API Key must not be empty.");
                zzif.zza(context.getApplicationContext(), false);
                if (z2) {
                    zza.zze(str, locale, false);
                } else {
                    zza.zzd(str, locale, false);
                }
            } catch (Throwable th) {
                throw th;
            }
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public static synchronized zzhw zzc() {
        return zza;
    }

    public static void initialize(Context context, String str, Locale locale) {
        try {
            zzb(context, str, locale, false, false);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }

    public static void initializeWithNewPlacesApiEnabled(Context context, String str, Locale locale) {
        try {
            zzb(context, str, locale, false, true);
        } catch (Error | RuntimeException e) {
            zzif.zzb(e);
            throw e;
        }
    }
}
