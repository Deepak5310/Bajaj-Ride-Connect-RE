package com.google.android.libraries.navigation.internal.tv;

import com.google.android.libraries.navigation.internal.tu.t;
import com.google.android.libraries.navigation.internal.yz.ck;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements Comparable {
    public final t a;
    public final c b;
    public final long c;

    public b(t tVar, c cVar, long j) {
        this.a = tVar;
        this.b = cVar;
        this.c = j;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        b bVar = (b) obj;
        return ck.b.e(bVar.b, this.b).d(this.c, bVar.c).a();
    }
}
