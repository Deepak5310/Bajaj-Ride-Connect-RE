package com.google.android.libraries.navigation.internal.qi;

import com.google.android.libraries.geo.mapcore.internal.model.aq;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.abh.bj;
import com.google.android.libraries.navigation.internal.oe.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends a {
    private volatile transient int g;
    private volatile transient boolean h;
    private volatile transient String i;

    public b(ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.rq.a aVar, aq aqVar, int i, bj bjVar) {
        super(apVar, cgVar, aVar, aqVar, i, null);
    }

    @Override // com.google.android.libraries.navigation.internal.qi.a
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b) || hashCode() != obj.hashCode()) {
            return false;
        }
        if (this != obj) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (!this.a.equals(fVar.b()) || !this.b.equals(fVar.d()) || !this.c.equals(fVar.e()) || !this.d.equals(fVar.c()) || this.e != fVar.a()) {
                return false;
            }
            fVar.f();
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.a, com.google.android.libraries.navigation.internal.qi.f
    public final int hashCode() {
        if (!this.h) {
            synchronized (this) {
                if (!this.h) {
                    this.g = (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e) * 1000003;
                    this.h = true;
                }
            }
        }
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.a
    public final String toString() {
        if (this.i == null) {
            synchronized (this) {
                if (this.i == null) {
                    this.i = "{" + String.valueOf(this.a) + ", " + String.valueOf(this.b) + ", " + String.valueOf(this.c) + ", " + String.valueOf(this.d) + ", " + this.e + ", null}";
                    if (this.i == null) {
                        throw new NullPointerException("toString() cannot return null");
                    }
                }
            }
        }
        return this.i;
    }
}
