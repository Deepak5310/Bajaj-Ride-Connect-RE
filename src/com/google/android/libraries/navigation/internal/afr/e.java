package com.google.android.libraries.navigation.internal.afr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements k, com.google.android.libraries.navigation.internal.afo.a {
    private static final Object a = new Object();
    private volatile k b;
    private volatile Object c = a;

    private e(k kVar) {
        this.b = kVar;
    }

    public static com.google.android.libraries.navigation.internal.afo.a b(k kVar) {
        if (kVar instanceof com.google.android.libraries.navigation.internal.afo.a) {
            return (com.google.android.libraries.navigation.internal.afo.a) kVar;
        }
        j.b(kVar);
        return new e(kVar);
    }

    public static com.google.android.libraries.navigation.internal.afo.a c(com.google.android.libraries.navigation.internal.agl.a aVar) {
        return b(n.a(aVar));
    }

    public static k d(k kVar) {
        j.b(kVar);
        return kVar instanceof e ? kVar : new e(kVar);
    }

    private final synchronized Object e() {
        Object obj = this.c;
        Object obj2 = a;
        if (obj != obj2) {
            return obj;
        }
        Object objA = this.b.a();
        Object obj3 = this.c;
        if (obj3 != obj2 && obj3 != objA) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objA + ". This is likely due to a circular dependency.");
        }
        this.c = objA;
        this.b = null;
        return objA;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final Object a() {
        Object obj = this.c;
        return obj == a ? e() : obj;
    }
}
