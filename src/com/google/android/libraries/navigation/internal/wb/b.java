package com.google.android.libraries.navigation.internal.wb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ d a;

    public b(d dVar) {
        this.a = dVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Boolean bool = (Boolean) mVar.c();
        if (bool == null) {
            return;
        }
        this.a.a.setVisibilityMode(bool.booleanValue() ? com.google.android.libraries.geo.mapcore.internal.ui.a.ALWAYS_ON : com.google.android.libraries.geo.mapcore.internal.ui.a.OFF_IF_NORTH_UP_TOP_DOWN);
    }
}
