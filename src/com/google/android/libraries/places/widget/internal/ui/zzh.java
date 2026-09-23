package com.google.android.libraries.places.widget.internal.ui;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.internal.zzdh;
import com.google.android.libraries.places.internal.zzdk;
import com.google.android.libraries.places.internal.zzic;
import com.google.android.libraries.places.internal.zzid;
import com.google.android.libraries.places.internal.zzih;
import com.google.android.libraries.places.internal.zziu;
import com.google.android.libraries.places.internal.zzjs;
import com.google.android.libraries.places.internal.zzjt;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzh extends FragmentFactory {
    private final int zza;
    private final PlacesClient zzb;
    private final zziu zzc;
    private final zzjs zzd;
    private final zzdh zze;

    public zzh(int i, Context context, zziu zziuVar) {
        this.zza = i;
        Context applicationContext = context.getApplicationContext();
        zzic zzicVarZzd = zzid.zzd(applicationContext);
        zzicVarZzd.zzd(2);
        zzid zzidVarZze = zzicVarZzd.zze();
        zzih zzihVar = new zzih(applicationContext);
        this.zzb = Places.zza(applicationContext, zzidVarZze);
        this.zzc = zziuVar;
        this.zzd = new zzjt(zzihVar, zzidVarZze);
        this.zze = new zzdk();
    }

    @Override // androidx.fragment.app.FragmentFactory
    public final Fragment instantiate(ClassLoader classLoader, String str) {
        return loadFragmentClass(classLoader, str) == AutocompleteImplFragment.class ? new AutocompleteImplFragment(this.zza, this.zzb, this.zzc, this.zzd, this.zze) : super.instantiate(classLoader, str);
    }
}
