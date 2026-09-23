package com.google.android.libraries.navigation.internal.xe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dt implements Runnable {
    final /* synthetic */ du a;

    public dt(du duVar) {
        this.a = duVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        du duVar = this.a;
        duVar.a = true;
        duVar.c();
    }
}
