package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg implements Comparable {
    final bn a;
    final int b;
    final es c;
    final boolean d;

    public bg(bn bnVar, int i, es esVar, boolean z) {
        this.a = bnVar;
        this.b = i;
        this.c = esVar;
        this.d = z;
    }

    public static final cx e(cx cxVar, cy cyVar) {
        ((bb) cxVar).x((bi) cyVar);
        return cxVar;
    }

    public static final dd f() {
        throw new UnsupportedOperationException();
    }

    public final int a() {
        return this.b;
    }

    public final es b() {
        return this.c;
    }

    public final et c() {
        return this.c.s;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.b - ((bg) obj).b;
    }

    public final boolean d() {
        return this.d;
    }
}
