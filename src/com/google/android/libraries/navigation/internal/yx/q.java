package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends s {
    final s a;
    final s b;

    public q(s sVar, s sVar2) {
        this.a = sVar;
        this.b = sVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.s
    public final boolean b(char c) {
        return this.a.b(c) || this.b.b(c);
    }

    public final String toString() {
        s sVar = this.b;
        return "CharMatcher.or(" + String.valueOf(this.a) + ", " + String.valueOf(sVar) + ")";
    }
}
