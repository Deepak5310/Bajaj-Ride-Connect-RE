package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ct extends cv {
    public static final ct a = new ct();
    private static final long serialVersionUID = 0;

    private ct() {
        super("");
    }

    private Object readResolve() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    /* JADX INFO: renamed from: a */
    public final int compareTo(cv cvVar) {
        return cvVar == this ? 0 : -1;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final Comparable b() {
        throw new IllegalStateException("range unbounded on this side");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final void c(StringBuilder sb) {
        sb.append("(-∞");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv, java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((cv) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final void d(StringBuilder sb) {
        throw new AssertionError();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final boolean e(Comparable comparable) {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.cv
    public final int hashCode() {
        return System.identityHashCode(this);
    }

    public final String toString() {
        return "-∞";
    }
}
