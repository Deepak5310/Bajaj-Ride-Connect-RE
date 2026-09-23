package com.google.android.libraries.navigation.internal.aac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ay extends d.i implements Runnable {
    private bj a;

    public ay(bj bjVar) {
        this.a = bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        bj bjVar = this.a;
        if (bjVar != null) {
            return com.google.android.libraries.navigation.internal.b.b.n(bjVar, "delegate=[", "]");
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final void b() {
        this.a = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bj bjVar = this.a;
        if (bjVar != null) {
            aA(bjVar);
        }
    }
}
