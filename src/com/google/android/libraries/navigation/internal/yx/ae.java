package com.google.android.libraries.navigation.internal.yx;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ae extends ah {
    final /* synthetic */ String a = BuildConfig.TRAVIS;
    final /* synthetic */ ah b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ae(ah ahVar, ah ahVar2) {
        super(ahVar2);
        this.b = ahVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.ah
    public final CharSequence a(Object obj) {
        return obj == null ? this.a : this.b.a(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yx.ah
    public final ah b() {
        throw new UnsupportedOperationException("already specified useForNull");
    }
}
