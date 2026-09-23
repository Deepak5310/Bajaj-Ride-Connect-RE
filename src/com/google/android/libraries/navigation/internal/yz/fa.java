package com.google.android.libraries.navigation.internal.yz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fa extends ff {
    final /* synthetic */ fb a;

    public fa(fb fbVar) {
        this.a = fbVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public final nn listIterator() {
        return this.a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ff
    public final fd h() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ff, com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return super.writeReplace();
    }
}
