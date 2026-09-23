package com.google.android.libraries.navigation;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.libraries.navigation.internal.ms.bg;
import com.google.android.libraries.navigation.internal.ms.cr;
import com.google.android.libraries.navigation.internal.xe.ej;
import com.google.android.libraries.navigation.internal.xe.fi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class e implements ej {
    final /* synthetic */ Bundle a;
    final /* synthetic */ DirectionsListView b;

    public e(DirectionsListView directionsListView, Bundle bundle) {
        this.a = bundle;
        this.b = directionsListView;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.ej
    public final void a(Navigator navigator, com.google.android.libraries.navigation.environment.am amVar) {
        DirectionsListView directionsListView = this.b;
        directionsListView.a = (fi) navigator;
        if (directionsListView.c) {
            Bundle bundle = this.a;
            cr crVarL = new com.google.android.libraries.navigation.internal.ru.a(directionsListView.getContext().getApplicationContext(), new bg(), amVar.E(), amVar.C(), amVar.ag(), null).l();
            com.google.android.libraries.navigation.internal.uh.w wVarA = amVar.aM().a(directionsListView.f, directionsListView.b);
            wVarA.o(bundle);
            com.google.android.libraries.navigation.internal.uj.d dVar = new com.google.android.libraries.navigation.internal.uj.d(directionsListView.f, wVarA, directionsListView.getContext(), new com.google.android.libraries.navigation.internal.uj.b(new com.google.android.libraries.navigation.internal.zm.a(amVar.aN()), new com.google.android.libraries.navigation.internal.zm.a(amVar.f()), new com.google.android.libraries.navigation.internal.zm.a(amVar.bZ()), new com.google.android.libraries.navigation.internal.zm.a(com.google.android.libraries.navigation.internal.vb.n.a(amVar.t())), new com.google.android.libraries.navigation.internal.vb.d(), new com.google.android.libraries.navigation.internal.vb.g(), new com.google.android.libraries.navigation.internal.vb.k(), new com.google.android.libraries.navigation.internal.zm.a(com.google.android.libraries.navigation.internal.ul.a.c(directionsListView.getContext().getApplicationContext(), amVar.cc(), amVar.cb())), new com.google.android.libraries.navigation.internal.vb.l(directionsListView.getContext().getApplicationContext()), new com.google.android.libraries.navigation.internal.zm.a(amVar.aO()), new com.google.android.libraries.navigation.internal.zm.a(amVar.ar()), new com.google.android.libraries.navigation.internal.zm.a(amVar.aj())), amVar.aX(), amVar.aZ(), new com.google.android.libraries.navigation.internal.ms.at());
            Context context = directionsListView.getContext();
            com.google.android.libraries.navigation.internal.mj.a aVarH = amVar.H();
            Resources resources = directionsListView.getContext().getResources();
            com.google.android.libraries.navigation.internal.hf.n nVar = new com.google.android.libraries.navigation.internal.hf.n(directionsListView.getContext().getResources());
            com.google.android.libraries.navigation.internal.hf.n.a aVar = new com.google.android.libraries.navigation.internal.hf.n.a();
            aVar.c();
            com.google.android.libraries.navigation.internal.uz.d dVar2 = new com.google.android.libraries.navigation.internal.uz.d(directionsListView.getContext(), new com.google.android.libraries.navigation.internal.uz.i(context, aVarH, resources, nVar, aVar, amVar.aA()));
            directionsListView.b.b(amVar.W(), dVar, wVarA, dVar2, amVar.az());
            crVarL.c(new com.google.android.libraries.navigation.internal.uy.ac(), directionsListView).c(dVar2);
            directionsListView.b.h(bundle);
        }
        DirectionsListView directionsListView2 = this.b;
        if (directionsListView2.d) {
            directionsListView2.b();
        }
        DirectionsListView directionsListView3 = this.b;
        if (directionsListView3.e) {
            directionsListView3.a();
        }
    }
}
