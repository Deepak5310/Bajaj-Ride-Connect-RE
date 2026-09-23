package com.google.android.libraries.places.internal;

import android.location.Location;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.model.LocationBias;
import com.google.android.libraries.places.api.model.LocationRestriction;
import com.google.android.libraries.places.api.model.RectangularBounds;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhg {
    private static final zzma zza;

    static {
        zzlz zzlzVar = new zzlz();
        zzlzVar.zza(zzdz.NONE, "NONE");
        zzlzVar.zza(zzdz.PSK, "WPA_PSK");
        zzlzVar.zza(zzdz.EAP, "WPA_EAP");
        zzlzVar.zza(zzdz.OTHER, "SECURED_NONE");
        zza = zzlzVar.zzc();
    }

    public static String zza(Location location) {
        if (location == null) {
            return null;
        }
        return zzf(location.getLatitude(), location.getLongitude());
    }

    public static String zzb(LatLng latLng) {
        if (latLng == null) {
            return null;
        }
        return zzf(latLng.latitude, latLng.longitude);
    }

    public static String zze(zzlx zzlxVar, int i) {
        StringBuilder sb = new StringBuilder();
        int size = zzlxVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzea zzeaVar = (zzea) zzlxVar.get(i2);
            int length = sb.length();
            zzlz zzlzVar = new zzlz();
            zzlzVar.zza("mac", zzeaVar.zzd());
            zzlzVar.zza("strength_dbm", Integer.valueOf(zzeaVar.zzb()));
            zzlzVar.zza("wifi_auth_type", zza.get(zzeaVar.zzc()));
            zzlzVar.zza("is_connected", Boolean.valueOf(zzeaVar.zze()));
            zzlzVar.zza("frequency_mhz", Integer.valueOf(zzeaVar.zza()));
            zzma zzmaVarZzc = zzlzVar.zzc();
            zzki zzkiVarZzc = zzki.zzc(",");
            Iterator<E> it2 = zzmaVarZzc.entrySet().iterator();
            StringBuilder sb2 = new StringBuilder();
            try {
                zzkg.zza(sb2, it2, zzkiVarZzc, "=");
                String string = sb2.toString();
                int length2 = sb.length();
                String strConcat = (length > 0 ? "|" : "").concat(string);
                if (length2 + strConcat.length() > 4000) {
                    break;
                }
                sb.append(strConcat);
            } catch (IOException e) {
                throw new AssertionError(e);
            }
        }
        return sb.toString();
    }

    private static String zzf(double d, double d2) {
        return String.format(Locale.US, "%.15f,%.15f", Double.valueOf(d), Double.valueOf(d2));
    }

    private static String zzg(RectangularBounds rectangularBounds) {
        LatLng southwest = rectangularBounds.getSouthwest();
        double d = southwest.latitude;
        double d2 = southwest.longitude;
        LatLng northeast = rectangularBounds.getNortheast();
        return String.format(Locale.US, "rectangle:%.15f,%.15f|%.15f,%.15f", Double.valueOf(d), Double.valueOf(d2), Double.valueOf(northeast.latitude), Double.valueOf(northeast.longitude));
    }

    public static String zzc(LocationBias locationBias) {
        if (locationBias == null) {
            return null;
        }
        if (locationBias instanceof RectangularBounds) {
            return zzg((RectangularBounds) locationBias);
        }
        throw new AssertionError("Unknown LocationBias type.");
    }

    public static String zzd(LocationRestriction locationRestriction) {
        if (locationRestriction == null) {
            return null;
        }
        if (locationRestriction instanceof RectangularBounds) {
            return zzg((RectangularBounds) locationRestriction);
        }
        throw new AssertionError("Unknown LocationRestriction type.");
    }
}
