package com.google.android.libraries.navigation.internal.jc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    private final int a;
    private final int b;
    private final int c;

    public a(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // com.google.android.libraries.navigation.internal.jc.b
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.jc.b
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.jc.b
    public final int c() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a == bVar.a() && this.b == bVar.b() && this.c == bVar.c()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }
}
