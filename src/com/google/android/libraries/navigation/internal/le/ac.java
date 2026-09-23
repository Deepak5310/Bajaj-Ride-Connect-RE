package com.google.android.libraries.navigation.internal.le;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ac implements Runnable {
    final /* synthetic */ ad a;

    public ac(ad adVar) {
        this.a = adVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.ld.i iVar = this.a.a.b;
        iVar.j(String.valueOf(iVar.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
