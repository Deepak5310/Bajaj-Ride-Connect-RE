package com.google.android.libraries.navigation.internal.ri;

import android.view.MotionEvent;
import com.google.android.libraries.geo.mapcore.renderer.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c implements be {
    final /* synthetic */ d a;

    public c(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.be
    public final boolean a(MotionEvent motionEvent) {
        return this.a.b.a.onHoverEvent(motionEvent);
    }
}
