package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bc extends bh {
    final /* synthetic */ t b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bc(bj bjVar, CharSequence charSequence, t tVar) {
        super(bjVar, charSequence);
        this.b = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.bh
    public final int b(int i) {
        return ((ac) this.b).a.end();
    }

    @Override // com.google.android.libraries.navigation.internal.yx.bh
    public final int c(int i) {
        if (((ac) this.b).a.find(i)) {
            return ((ac) this.b).a.start();
        }
        return -1;
    }
}
