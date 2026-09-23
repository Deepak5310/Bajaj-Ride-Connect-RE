package com.google.android.libraries.places.internal;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjm implements ViewModelProvider.Factory {
    private final zzjb zza;
    private final zzjr zzb;
    private final zzjs zzc;

    public zzjm(zzjb zzjbVar, zzjr zzjrVar, zzjs zzjsVar) {
        this.zza = zzjbVar;
        this.zzb = zzjrVar;
        this.zzc = zzjsVar;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls) {
        zzkt.zzf(cls == zzjo.class, "This factory can only be used to instantiate its enclosing class.");
        return new zzjo(this.zza, this.zzb, this.zzc, null);
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public final ViewModel create(Class cls, CreationExtras creationExtras) {
        return create(cls);
    }
}
