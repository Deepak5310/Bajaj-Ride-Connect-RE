package com.google.android.libraries.navigation.internal.po;

import android.graphics.Bitmap;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends gz {
    private final Bitmap a;
    private final com.google.android.libraries.geo.mapcore.internal.vector.gl.o b;

    public h(Bitmap bitmap, com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar) {
        Objects.requireNonNull(bitmap);
        this.a = bitmap;
        Objects.requireNonNull(oVar);
        this.b = oVar;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gz
    public final Bitmap a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.po.gz
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.o b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof gz) {
            gz gzVar = (gz) obj;
            if (this.a.equals(gzVar.a()) && this.b.equals(gzVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(oVar) + "}";
    }
}
