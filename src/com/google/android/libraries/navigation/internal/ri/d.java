package com.google.android.libraries.navigation.internal.ri;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.libraries.geo.mapcore.renderer.bf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements View.OnHoverListener {
    final /* synthetic */ bf a;
    final /* synthetic */ e b;

    public d(e eVar, bf bfVar) {
        this.a = bfVar;
        this.b = eVar;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        return this.a.a(motionEvent, new c(this));
    }
}
