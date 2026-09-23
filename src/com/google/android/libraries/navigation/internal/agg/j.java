package com.google.android.libraries.navigation.internal.agg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends fm {
    final es a;

    public j(es esVar) {
        super(0);
        this.a = esVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi
    protected final int a(int i) {
        return this.a.n(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fm
    protected final int b() {
        return this.a.size();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.fi
    protected final /* bridge */ /* synthetic */ fh c(int i, int i2) {
        return new j(this.a, i, i2);
    }

    public j(es esVar, int i, int i2) {
        super(i, i2);
        this.a = esVar;
    }
}
