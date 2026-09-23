package com.google.android.libraries.navigation.internal.sv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class v implements com.google.android.libraries.navigation.internal.yx.as {
    public final /* synthetic */ ak a;

    public /* synthetic */ v(ak akVar) {
        this.a = akVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.as
    public final boolean a(Object obj) {
        Exception exc = (Exception) obj;
        if (exc instanceof com.google.android.libraries.navigation.internal.sx.am) {
            com.google.android.libraries.navigation.internal.fw.g gVar = ((com.google.android.libraries.navigation.internal.sx.am) exc).e;
            if (gVar != null && !gVar.s) {
                return true;
            }
        } else if (exc instanceof com.google.android.libraries.navigation.internal.sx.an) {
            ak akVar = this.a;
            akVar.w = false;
            if (akVar.J.f != null && !akVar.A()) {
                akVar.J(com.google.android.libraries.geo.navcore.guidance.impl.as.b, null);
            }
            com.google.android.libraries.navigation.internal.fw.g gVar2 = ((com.google.android.libraries.navigation.internal.sx.an) exc).a;
            if (gVar2 != null && !gVar2.s) {
                return true;
            }
        }
        return false;
    }
}
