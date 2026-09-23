package com.google.android.libraries.navigation.internal.ym;

import com.google.android.libraries.navigation.internal.ael.ar;
import com.google.android.libraries.navigation.internal.ael.cy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends b {
    public final cy a;
    private final ar b;

    public a(cy cyVar, ar arVar) {
        this.a = cyVar;
        if (arVar == null) {
            throw new NullPointerException("Null extensionRegistryLite");
        }
        this.b = arVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ym.b
    public final ar a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ym.b
    public final cy b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a.equals(bVar.b()) && this.b.equals(bVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        ar arVar = this.b;
        return "ProtoSerializer{defaultValue=" + this.a.toString() + ", extensionRegistryLite=" + arVar.toString() + "}";
    }
}
