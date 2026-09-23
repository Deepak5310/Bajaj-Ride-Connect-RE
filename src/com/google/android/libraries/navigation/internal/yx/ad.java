package com.google.android.libraries.navigation.internal.yx;

import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ad extends u implements Serializable {
    private static final long serialVersionUID = 0;
    private final Pattern a;

    public ad(Pattern pattern) {
        ar.q(pattern);
        this.a = pattern;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.u
    public final t a(CharSequence charSequence) {
        return new ac(this.a.matcher(charSequence));
    }

    public final String toString() {
        return this.a.toString();
    }
}
