package com.google.android.libraries.navigation.internal.gw;

import android.content.res.Configuration;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends t {
    private final Configuration a;
    private final int b;

    public c(Configuration configuration, int i) {
        Objects.requireNonNull(configuration);
        this.a = configuration;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.t
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.gw.t
    public final Configuration b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            if (this.a.equals(tVar.b()) && this.b == tVar.a()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b;
    }

    public final String toString() {
        return "{" + this.a.toString() + ", " + this.b + "}";
    }
}
