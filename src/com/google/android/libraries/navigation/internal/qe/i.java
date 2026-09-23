package com.google.android.libraries.navigation.internal.qe;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.libraries.geo.mapcore.renderer.bf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements View.OnHoverListener {
    final /* synthetic */ bf a;
    final /* synthetic */ j b;

    public i(j jVar, bf bfVar) {
        this.a = bfVar;
        this.b = jVar;
    }

    @Override // android.view.View.OnHoverListener
    public final boolean onHover(View view, MotionEvent motionEvent) {
        return this.a.a(motionEvent, new h(this));
    }
}
