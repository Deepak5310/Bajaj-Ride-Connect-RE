package com.google.android.libraries.navigation.internal.abh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class an implements ab {
    final /* synthetic */ float a;
    final /* synthetic */ float b;

    public an(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.ab
    public final void a(ac acVar, int i, ht htVar) {
        htVar.c(com.google.android.libraries.navigation.internal.abx.b.CAMERA_UPDATE_SCROLL_BY);
        acVar.p(this.a, this.b, i);
    }

    public final String toString() {
        return "CAMERA_UPDATE_SCROLL_BY";
    }
}
