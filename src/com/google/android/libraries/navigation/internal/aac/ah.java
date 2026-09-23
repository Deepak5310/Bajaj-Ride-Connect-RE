package com.google.android.libraries.navigation.internal.aac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ah implements s {
    final /* synthetic */ aj a;
    final /* synthetic */ s b;

    public ah(aj ajVar, s sVar) {
        this.a = ajVar;
        this.b = sVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.s
    public final bj a() throws Exception {
        return !this.a.compareAndSet(ai.NOT_RUN, ai.STARTED) ? az.f() : this.b.a();
    }

    public final String toString() {
        return this.b.toString();
    }
}
