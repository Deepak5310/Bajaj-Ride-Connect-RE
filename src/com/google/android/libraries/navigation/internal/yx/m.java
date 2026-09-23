package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends k {
    private final char a;

    public m(char c) {
        this.a = c;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.s
    public final boolean b(char c) {
        return c == this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.s
    public final s c(s sVar) {
        return sVar.b(this.a) ? sVar : new q(this, sVar);
    }

    public final String toString() {
        return "CharMatcher.is('" + s.f(this.a) + "')";
    }
}
