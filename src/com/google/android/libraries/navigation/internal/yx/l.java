package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l extends k {
    private final char a;
    private final char b;

    public l(char c, char c2) {
        ar.a(c2 >= c);
        this.a = c;
        this.b = c2;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.s
    public final boolean b(char c) {
        return this.a <= c && c <= this.b;
    }

    public final String toString() {
        return "CharMatcher.inRange('" + s.f(this.a) + "', '" + s.f(this.b) + "')";
    }
}
