package com.google.android.libraries.navigation.internal.ol;

import android.graphics.Bitmap;
import com.google.android.libraries.navigation.internal.adg.id;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends f {
    private final id a;
    private final Bitmap b;
    private final Bitmap c;
    private final Bitmap d;

    public b(id idVar, Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        Objects.requireNonNull(idVar);
        this.a = idVar;
        this.b = bitmap;
        this.c = bitmap2;
        this.d = bitmap3;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.f
    public final Bitmap a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.f
    public final Bitmap b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.f
    public final Bitmap c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.f
    public final id d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (this.a.equals(fVar.d()) && ((bitmap = this.b) != null ? bitmap.equals(fVar.b()) : fVar.b() == null) && ((bitmap2 = this.c) != null ? bitmap2.equals(fVar.c()) : fVar.c() == null) && ((bitmap3 = this.d) != null ? bitmap3.equals(fVar.a()) : fVar.a() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iN;
        id idVar = this.a;
        if (idVar.H()) {
            iN = idVar.n();
        } else {
            int iN2 = idVar.ak;
            if (iN2 == 0) {
                iN2 = idVar.n();
                idVar.ak = iN2;
            }
            iN = iN2;
        }
        Bitmap bitmap = this.b;
        int iHashCode = bitmap == null ? 0 : bitmap.hashCode();
        int i = iN ^ 1000003;
        Bitmap bitmap2 = this.c;
        int iHashCode2 = ((((i * 1000003) ^ iHashCode) * 1000003) ^ (bitmap2 == null ? 0 : bitmap2.hashCode())) * 1000003;
        Bitmap bitmap3 = this.d;
        return iHashCode2 ^ (bitmap3 != null ? bitmap3.hashCode() : 0);
    }

    public final String toString() {
        Bitmap bitmap = this.d;
        Bitmap bitmap2 = this.c;
        Bitmap bitmap3 = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(bitmap3) + ", " + String.valueOf(bitmap2) + ", " + String.valueOf(bitmap) + "}";
    }
}
