package com.google.android.libraries.navigation.internal.abh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class al implements ab {
    final /* synthetic */ float a;

    public al(float f) {
        this.a = f;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_ZOOM_BY);
        acVar.u(this.a, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_ZOOM_BY";
    }
}
