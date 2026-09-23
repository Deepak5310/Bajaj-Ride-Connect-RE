package com.google.android.libraries.navigation.internal.ag;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f implements com.google.android.libraries.navigation.internal.ai.c {
    private final CharSequence a;

    public f(CharSequence charSequence) {
        this.a = charSequence;
    }

    @Override // com.google.android.libraries.navigation.internal.ai.c
    public CharSequence a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            return this.a.toString().contentEquals(((f) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.toString().hashCode();
    }
}
