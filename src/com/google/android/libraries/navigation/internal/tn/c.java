package com.google.android.libraries.navigation.internal.tn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends b {
    private volatile transient String m;

    public c(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, CharSequence charSequence5, CharSequence charSequence6, CharSequence charSequence7, CharSequence charSequence8, CharSequence charSequence9, CharSequence charSequence10, CharSequence charSequence11, CharSequence charSequence12) {
        super(charSequence, charSequence2, charSequence3, charSequence4, charSequence5, charSequence6, charSequence7, charSequence8, charSequence9, charSequence10, charSequence11, charSequence12);
    }

    @Override // com.google.android.libraries.navigation.internal.tn.b, com.google.android.libraries.navigation.internal.tn.p
    public final String toString() {
        if (this.m == null) {
            synchronized (this) {
                if (this.m == null) {
                    this.m = g.a(this, new StringBuilder());
                    if (this.m == null) {
                        throw new NullPointerException("toString() cannot return null");
                    }
                }
            }
        }
        return this.m;
    }
}
