package com.google.android.libraries.navigation.internal.uu;

import android.view.View;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements View.OnAttachStateChangeListener {
    final /* synthetic */ q a;

    public n(q qVar) {
        this.a = qVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        q qVar = this.a;
        qVar.b.b(qVar.v);
        q qVar2 = this.a;
        p pVar = qVar2.A;
        ar.q(pVar);
        t tVar = qVar2.c;
        tVar.e = pVar;
        tVar.a();
        tVar.b();
        tVar.a.l(tVar.d);
        pVar.a(tVar.b);
        pVar.b(tVar.c);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        t tVar = this.a.c;
        tVar.a.v(tVar.d);
        tVar.e = null;
        q qVar = this.a;
        qVar.b.c(qVar.v);
    }
}
