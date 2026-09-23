package com.google.android.libraries.geo.mapcore.internal.ui;

import com.google.android.libraries.navigation.internal.po.gr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class h implements Runnable {
    final /* synthetic */ CompassButtonView a;
    private final com.google.android.libraries.navigation.internal.oq.d b;
    private final gr c;

    public h(CompassButtonView compassButtonView, com.google.android.libraries.navigation.internal.oq.d dVar, gr grVar) {
        this.a = compassButtonView;
        this.b = dVar;
        this.c = grVar;
    }

    public final /* synthetic */ void a(com.google.android.libraries.navigation.internal.oq.f fVar) {
        this.a.a(fVar.a(), fVar.b());
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.d(this);
        final com.google.android.libraries.navigation.internal.oq.f fVarA = this.b.a();
        this.a.post(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.ui.g
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(fVarA);
            }
        });
    }
}
