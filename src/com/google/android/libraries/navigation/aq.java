package com.google.android.libraries.navigation;

import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.xe.fi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class aq implements com.google.android.libraries.navigation.internal.pi.n {
    final /* synthetic */ NavigationView a;

    public aq(NavigationView navigationView) {
        this.a = navigationView;
    }

    @Override // com.google.android.libraries.navigation.internal.pi.n
    public final void i(com.google.android.libraries.navigation.internal.pi.w wVar) {
        if (wVar instanceof com.google.android.libraries.navigation.internal.pi.z) {
            bg bgVar = (bg) wVar.a(bg.class);
            fi fiVar = this.a.j;
            if (fiVar == null || bgVar == null) {
                return;
            }
            fiVar.k(bgVar);
        }
    }
}
