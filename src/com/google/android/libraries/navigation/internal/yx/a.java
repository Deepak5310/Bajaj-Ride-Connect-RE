package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends an {
    public static final a a = new a();
    private static final long serialVersionUID = 0;

    private a() {
    }

    private Object readResolve() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final an a(an anVar) {
        ar.q(anVar);
        return anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final an b(aa aaVar) {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object c() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object d(br brVar) {
        Object objA = brVar.a();
        ar.r(objA, "use Optional.orNull() instead of a Supplier that returns null");
        return objA;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object e(Object obj) {
        ar.r(obj, "use Optional.orNull() instead of Optional.or(null)");
        return obj;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final boolean equals(Object obj) {
        return obj == this;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final boolean g() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final int hashCode() {
        return 2040732332;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final String toString() {
        return "Optional.absent()";
    }
}
