package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class dp implements com.google.android.libraries.navigation.internal.qb.f {
    public final /* synthetic */ boolean a;

    public /* synthetic */ dp(boolean z) {
        this.a = z;
    }

    @Override // com.google.android.libraries.navigation.internal.qb.f
    public final com.google.android.libraries.navigation.internal.qb.e a(Object obj, Object obj2) {
        int i = ed.g;
        if (this.a) {
            return com.google.android.libraries.navigation.internal.qb.e.IGNORE;
        }
        com.google.android.libraries.navigation.internal.qb.d dVar = (com.google.android.libraries.navigation.internal.qb.d) obj;
        com.google.android.libraries.navigation.internal.qb.d dVar2 = (com.google.android.libraries.navigation.internal.qb.d) obj2;
        return dVar.a.equals(dVar2.a) ? com.google.android.libraries.navigation.internal.qb.e.IGNORE : ed.d(dVar, dVar2);
    }
}
