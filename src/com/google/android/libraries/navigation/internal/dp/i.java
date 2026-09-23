package com.google.android.libraries.navigation.internal.dp;

import java.util.Optional;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ k a;

    public i(k kVar) {
        this.a = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Optional optional;
        if (mVar != null) {
            mVar.c();
        }
        final Boolean bool = (Boolean) mVar.c();
        if (bool == null) {
            return;
        }
        if ((this.a.q == com.google.android.libraries.navigation.internal.dt.c.NAVIGATION || this.a.q == com.google.android.libraries.navigation.internal.dt.c.NAVIGATION_CUSTOM_3D_CHEVRON) && (optional = this.a.d) != null) {
            optional.ifPresent(new Consumer() { // from class: com.google.android.libraries.navigation.internal.dp.h
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    bool.booleanValue();
                    ((com.google.android.libraries.navigation.internal.aw.a) obj).c();
                }
            });
        }
    }
}
