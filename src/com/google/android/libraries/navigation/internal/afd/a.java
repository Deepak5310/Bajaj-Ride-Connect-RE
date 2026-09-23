package com.google.android.libraries.navigation.internal.afd;

import com.google.android.libraries.navigation.internal.zp.cf;
import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements Serializable, cf {
    public final int a;

    public a(int i) {
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.zp.cf
    public final int a() {
        return this.a;
    }

    public final String b() {
        return "veType: " + this.a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && this.a == ((a) obj).a();
    }

    public final int hashCode() {
        return this.a * 31;
    }

    public final String toString() {
        return b();
    }
}
