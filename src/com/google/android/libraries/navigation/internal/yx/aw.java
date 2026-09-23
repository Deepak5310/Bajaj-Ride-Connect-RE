package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw extends an {
    private static final long serialVersionUID = 0;
    public final Object a;

    public aw(Object obj) {
        this.a = obj;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final an a(an anVar) {
        ar.q(anVar);
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final an b(aa aaVar) {
        Object objAk = aaVar.ak(this.a);
        ar.r(objAk, "the Function passed to Optional.transform() must not return null.");
        return new aw(objAk);
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object d(br brVar) {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object e(Object obj) {
        ar.r(obj, "use Optional.orNull() instead of Optional.or(null)");
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final boolean equals(Object obj) {
        if (obj instanceof aw) {
            return this.a.equals(((aw) obj).a);
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final Object f() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final boolean g() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.an
    public final String toString() {
        return "Optional.of(" + this.a.toString() + ")";
    }
}
