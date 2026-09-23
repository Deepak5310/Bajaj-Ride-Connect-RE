package com.google.android.libraries.navigation.internal.qe;

import android.view.MotionEvent;
import com.google.android.libraries.geo.mapcore.renderer.be;
import com.google.android.libraries.geo.mapcore.renderer.bf;
import com.google.android.libraries.navigation.internal.pn.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements bf {
    final /* synthetic */ n a;
    final /* synthetic */ j b;

    public f(j jVar, n nVar) {
        this.a = nVar;
        this.b = jVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bf
    public final boolean a(MotionEvent motionEvent, be beVar) {
        if (!this.b.a.isEnabled() || !this.b.a.isClickable()) {
            return false;
        }
        if (this.a.e(motionEvent)) {
            return true;
        }
        return beVar.a(motionEvent);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.bf
    public final boolean b(MotionEvent motionEvent) {
        if (!this.b.a.isEnabled() || !this.b.a.isClickable()) {
            return false;
        }
        this.a.f(motionEvent);
        return true;
    }
}
