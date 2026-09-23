package com.google.android.libraries.navigation.internal.sn;

import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements Iterator {
    private bq a;
    private int b;

    public g(bw bwVar) {
        bq bqVarA = bwVar.a();
        this.a = bqVarA;
        this.b = bqVarA.A.indexOf(bwVar);
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final bw next() {
        bq bqVar = this.a;
        ar.q(bqVar);
        bw bwVar = (bw) bqVar.A.get(this.b);
        this.b++;
        while (true) {
            bq bqVar2 = this.a;
            if (bqVar2 == null || this.b < bqVar2.A.size()) {
                break;
            }
            this.a = this.a.M;
            this.b = 0;
        }
        return bwVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        bq bqVar = this.a;
        return bqVar != null && this.b < bqVar.A.size();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
