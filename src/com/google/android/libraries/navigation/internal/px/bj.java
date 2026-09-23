package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bj extends com.google.android.libraries.navigation.internal.fq.m {
    public bj(com.google.android.libraries.navigation.internal.fq.f fVar) {
        super(com.google.android.libraries.navigation.internal.fq.l.GL_LABEL, fVar);
    }

    @Override // com.google.android.libraries.navigation.internal.fq.m
    protected final /* bridge */ /* synthetic */ void g(Object obj) {
        ((ai) obj).D(4);
    }

    public final void j() {
        f(0);
    }

    public final void k(ai aiVar) {
        if (super.d(aiVar.z()) == null) {
            aiVar.C(4);
            super.e(aiVar.z(), aiVar);
        }
    }

    public final void l(int i) {
        super.i(i);
    }

    public final synchronized ai m(long j) {
        ai aiVar;
        aiVar = (ai) super.d(j);
        if (aiVar != null) {
            aiVar.C(1);
        }
        return aiVar;
    }
}
