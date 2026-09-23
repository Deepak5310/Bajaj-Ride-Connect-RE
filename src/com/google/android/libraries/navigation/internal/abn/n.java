package com.google.android.libraries.navigation.internal.abn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements bf {
    final /* synthetic */ u a;

    public n(u uVar) {
        this.a = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.abn.bf
    public final void a(aw awVar) {
        com.google.android.libraries.navigation.internal.abf.t.b(!this.a.e, "Camera stopped during a cancellation");
        com.google.android.libraries.navigation.internal.abf.t.b(this.a.f == null, "stopAnimation() is not a CameraUpdate.");
        this.a.C(awVar, "MAP_STOP_ANIMATION", awVar.d(), 0, -4);
    }
}
