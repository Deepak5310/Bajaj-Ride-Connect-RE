package com.google.android.libraries.navigation.internal.abh;

import android.view.View;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.abh.if, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class Cif implements View.OnClickListener {
    public final View a;
    public final View b;
    public final View c;
    public ce d;

    public Cif(View view, View view2, View view3) {
        this.c = view;
        this.a = view2;
        this.b = view3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ce ceVar = this.d;
        if (ceVar == null) {
            return;
        }
        if (view == this.a) {
            ceVar.a.i.c(com.google.android.libraries.navigation.internal.abx.b.ZOOM_IN_BUTTON_CLICK);
            ceVar.a.a.x(1.0f);
        } else if (view == this.b) {
            ceVar.a.i.c(com.google.android.libraries.navigation.internal.abx.b.ZOOM_OUT_BUTTON_CLICK);
            ceVar.a.a.x(-1.0f);
        }
    }
}
