package com.google.android.libraries.navigation.internal.px;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class w extends eg {
    private final eb a;
    private final eb b;

    public w(eb ebVar, eb ebVar2) {
        Objects.requireNonNull(ebVar);
        this.a = ebVar;
        Objects.requireNonNull(ebVar2);
        this.b = ebVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.px.eg
    public final eb a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.eg
    public final eb b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof eg) {
            eg egVar = (eg) obj;
            if (this.a.equals(egVar.b()) && this.b.equals(egVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        eb ebVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + ebVar.toString() + "}";
    }
}
