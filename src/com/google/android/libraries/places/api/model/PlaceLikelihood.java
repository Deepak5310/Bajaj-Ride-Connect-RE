package com.google.android.libraries.places.api.model;

import android.os.Parcelable;
import com.google.android.libraries.places.internal.zzkt;
import com.google.android.libraries.places.internal.zzmk;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class PlaceLikelihood implements Parcelable {
    public static final double LIKELIHOOD_MAX_VALUE = 1.0d;
    public static final double LIKELIHOOD_MIN_VALUE = 0.0d;

    public static PlaceLikelihood newInstance(Place place, double d) {
        Double dValueOf = Double.valueOf(0.0d);
        Double dValueOf2 = Double.valueOf(1.0d);
        zzmk zzmkVarZzb = zzmk.zzb(dValueOf, dValueOf2);
        Double dValueOf3 = Double.valueOf(d);
        zzkt.zzl(zzmkVarZzb.zzd(dValueOf3), "Likelihood must not be out-of-range: %s to %s, but was: %s.", dValueOf, dValueOf2, dValueOf3);
        return new zzbm(place, d);
    }

    public abstract double getLikelihood();

    public abstract Place getPlace();
}
