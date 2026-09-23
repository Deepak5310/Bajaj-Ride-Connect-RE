package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends k {
    private final char a;
    private final char b;

    public n(char c, char c2) {
        this.a = c;
        this.b = c2;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.s
    public final boolean b(char c) {
        return c == this.a || c == this.b;
    }

    public final String toString() {
        return "CharMatcher.anyOf(\"" + s.f(this.a) + s.f(this.b) + "\")";
    }
}
