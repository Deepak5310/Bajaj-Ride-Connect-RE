package com.google.android.libraries.navigation.internal.qe;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.libraries.geo.mapcore.renderer.bf;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements View.OnTouchListener {
    final /* synthetic */ bf a;

    public g(bf bfVar) {
        this.a = bfVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.a.b(motionEvent);
    }
}
