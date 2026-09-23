package com.google.android.libraries.navigation.internal.q;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y implements com.google.android.libraries.navigation.internal.ms.c {
    final /* synthetic */ int a;
    final /* synthetic */ float b;
    final /* synthetic */ float c;
    final /* synthetic */ int d;

    public y(int i, float f, float f2, int i2) {
        this.a = i;
        this.b = f;
        this.c = f2;
        this.d = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.c
    public final void a(View view, boolean z) {
        if (!z && view.getVisibility() != this.a) {
            view.animate().alpha(this.b).scaleX(this.c).scaleY(this.c).setInterpolator(com.google.android.libraries.navigation.internal.k.a.a).setDuration(this.d).setListener(new x(this, view)).start();
        } else {
            view.animate().cancel();
            b(view);
        }
    }

    public final void b(View view) {
        view.setVisibility(this.a);
        view.setAlpha(this.b);
        view.setScaleX(this.c);
        view.setScaleY(this.c);
    }
}
