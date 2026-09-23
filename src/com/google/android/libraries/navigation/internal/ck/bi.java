package com.google.android.libraries.navigation.internal.ck;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bi {
    public final int a;
    public final int b;
    public final boolean c;

    public bi(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bi)) {
            return false;
        }
        bi biVar = (bi) obj;
        return this.a == biVar.a && this.b == biVar.b && this.c == biVar.c;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + (true != this.c ? 1237 : 1231);
    }

    public final String toString() {
        return "RenderableVertexBreak(index=" + this.a + ", lineColorArgb=" + this.b + ", isActive=" + this.c + ")";
    }
}
