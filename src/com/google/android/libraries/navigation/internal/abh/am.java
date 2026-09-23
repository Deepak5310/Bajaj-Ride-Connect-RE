package com.google.android.libraries.navigation.internal.abh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class am implements ab {
    final /* synthetic */ float a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;

    public am(float f, int i, int i2) {
        this.a = f;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_ZOOM_BY_FIXING);
        acVar.v(this.a, this.b, this.c, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_ZOOM_BY_FIXING";
    }
}
