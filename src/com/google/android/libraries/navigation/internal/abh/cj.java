package com.google.android.libraries.navigation.internal.abh;

import android.view.View;
import com.google.android.gms.maps.model.CameraPosition;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cj implements View.OnClickListener {
    final /* synthetic */ cm a;

    public cj(cm cmVar) {
        this.a = cmVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.i.c(com.google.android.libraries.navigation.internal.abx.b.COMPASS_BUTTON_CLICK);
        bv bvVar = this.a.v;
        if (bvVar != null && bvVar.b()) {
            this.a.v.c.b();
            return;
        }
        CameraPosition cameraPositionC = this.a.a.c();
        this.a.a.i(new CameraPosition(cameraPositionC.target, cameraPositionC.zoom, 0.0f, 0.0f), 400);
    }
}
