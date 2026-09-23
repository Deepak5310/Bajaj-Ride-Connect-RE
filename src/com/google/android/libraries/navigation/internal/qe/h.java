package com.google.android.libraries.navigation.internal.qe;

import android.view.MotionEvent;
import com.google.android.libraries.geo.mapcore.renderer.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h implements be {
    final /* synthetic */ i a;

    public h(i iVar) {
        this.a = iVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.be
    public final boolean a(MotionEvent motionEvent) {
        return this.a.b.a.onHoverEvent(motionEvent);
    }
}
