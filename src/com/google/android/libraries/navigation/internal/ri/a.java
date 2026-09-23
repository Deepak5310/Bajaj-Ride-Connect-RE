package com.google.android.libraries.navigation.internal.ri;

import android.view.MotionEvent;
import com.google.android.libraries.geo.mapcore.renderer.be;
import com.google.android.libraries.geo.mapcore.renderer.bf;
import com.google.android.libraries.navigation.internal.pn.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements bf {
    final /* synthetic */ n a;
    final /* synthetic */ e b;

    public a(e eVar, n nVar) {
        this.a = nVar;
        this.b = eVar;
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
        return e.a(this.b.a, motionEvent, this.a);
    }
}
