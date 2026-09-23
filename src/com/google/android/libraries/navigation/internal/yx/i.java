package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends o {
    public static final s a = new i();

    public i() {
        super("CharMatcher.ascii()");
    }

    @Override // com.google.android.libraries.navigation.internal.yx.s
    public final boolean b(char c) {
        return c <= 127;
    }
}
