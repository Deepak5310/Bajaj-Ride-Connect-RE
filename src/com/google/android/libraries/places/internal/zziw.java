package com.google.android.libraries.places.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.model.AutocompletePrediction;
import com.google.android.libraries.places.api.model.Place;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zziw {
    public static zziw zzg() {
        return zzr(3).zzf();
    }

    public static zziw zzk() {
        return zzr(2).zzf();
    }

    public static zziw zzl() {
        zziv zzivVarZzr = zzr(10);
        zzivVarZzr.zze(new Status(16));
        return zzivVarZzr.zzf();
    }

    public static zziw zzo() {
        return zzr(1).zzf();
    }

    public static zziw zzp() {
        return zzr(4).zzf();
    }

    private static zziv zzr(int i) {
        zzio zzioVar = new zzio();
        zzioVar.zzg(i);
        return zzioVar;
    }

    public abstract Status zza();

    public abstract AutocompletePrediction zzb();

    public abstract Place zzc();

    public abstract zzlx zzd();

    public abstract String zze();

    public abstract int zzf();

    public static zziw zzh(String str) {
        str.getClass();
        zziv zzivVarZzr = zzr(6);
        zzivVarZzr.zzd(str);
        return zzivVarZzr.zzf();
    }

    public static zziw zzj(List list) {
        list.getClass();
        zziv zzivVarZzr = zzr(5);
        zzivVarZzr.zzc(list);
        return zzivVarZzr.zzf();
    }

    public static zziw zzm(AutocompletePrediction autocompletePrediction, Status status) {
        status.getClass();
        zziv zzivVarZzr = zzr(9);
        zzivVarZzr.zzb(autocompletePrediction);
        zzivVarZzr.zze(status);
        return zzivVarZzr.zzf();
    }

    public static zziw zzn(Place place) {
        place.getClass();
        zziv zzivVarZzr = zzr(8);
        zzivVarZzr.zza(place);
        return zzivVarZzr.zzf();
    }

    public static zziw zzq(Status status) {
        status.getClass();
        zziv zzivVarZzr = zzr(10);
        zzivVarZzr.zze(status);
        return zzivVarZzr.zzf();
    }

    public static zziw zzi(String str, Status status) {
        str.getClass();
        status.getClass();
        zziv zzivVarZzr = zzr(7);
        zzivVarZzr.zzd(str);
        zzivVarZzr.zze(status);
        return zzivVarZzr.zzf();
    }
}
