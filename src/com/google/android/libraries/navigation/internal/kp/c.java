package com.google.android.libraries.navigation.internal.kp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class c extends e implements a {
    public long q;

    @Override // com.google.android.libraries.navigation.internal.kp.a
    public final long b() {
        return this.q;
    }

    protected abstract f c();

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Long.compare(this.q, ((a) obj).b());
    }

    public /* synthetic */ String d() {
        return null;
    }

    public /* synthetic */ boolean e() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.a
    public final f n() {
        f fVarC = c();
        fVarC.c = this.q;
        return fVarC;
    }

    @Override // com.google.android.libraries.navigation.internal.kp.e
    public final a p(long j) {
        this.q = j;
        return this;
    }
}
