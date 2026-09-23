package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class s extends bv {
    public final ArrayList a;
    public final ev b;

    public s() {
        this.a = new ArrayList();
        this.b = null;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final int a() {
        int size;
        synchronized (this.a) {
            size = this.a.size();
        }
        return size;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final bt b(int i) {
        return c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final bt c(long j) {
        synchronized (this.a) {
            if (j >= 0) {
                if (j < this.a.size()) {
                    return (bt) this.a.get((int) j);
                }
            }
            return c;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final bt d(int i, ez ezVar, bx bxVar) {
        return c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.bv
    public final byte[] e() {
        return d;
    }

    public s(List list) {
        this.a = new ArrayList(list.size());
        this.b = null;
    }
}
