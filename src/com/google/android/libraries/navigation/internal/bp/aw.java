package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aw {
    public final List a;
    public int c;
    public int b = 0;
    public Cif d = null;

    private aw(List list) {
        this.a = list;
    }

    static aw a() {
        return new aw(new ArrayList());
    }

    final bq b() {
        return (bq) gs.d(this.a);
    }

    final void c() {
        this.b = 0;
    }

    final bq[] d() {
        return (bq[]) this.a.toArray(new bq[0]);
    }
}
