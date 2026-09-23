package com.google.android.libraries.geo.navcore.ui.header.views;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class j implements Runnable {
    final /* synthetic */ StepCueView a;

    public j(StepCueView stepCueView) {
        this.a = stepCueView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b();
    }
}
