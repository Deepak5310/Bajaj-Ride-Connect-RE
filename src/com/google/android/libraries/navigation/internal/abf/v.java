package com.google.android.libraries.navigation.internal.abf;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class v implements ak {
    public final int a;
    public final int b;

    public v(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final synchronized boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return r.a(Integer.valueOf(this.a), Integer.valueOf(vVar.a)) && r.a(Integer.valueOf(this.b), Integer.valueOf(vVar.b));
    }

    @Override // com.google.android.libraries.navigation.internal.abf.ak
    public final int getHeight() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.abf.ak
    public final int getWidth() {
        return this.a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.a), Integer.valueOf(this.b)});
    }

    public final synchronized String toString() {
        return aj.f(this).c("width", this.a).c("height", this.b).toString();
    }
}
