package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.maps.android.BuildConfig;
import java.io.IOException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public final com.google.android.libraries.navigation.internal.oe.x a;
    public float b;
    public int c;

    public c(com.google.android.libraries.navigation.internal.oe.x xVar, int i, float f) {
        this.a = xVar;
        this.c = i;
        this.b = f;
    }

    public static c a(com.google.android.libraries.navigation.internal.oe.x xVar) {
        return new c(xVar, 2, 0.0f);
    }

    public static c b(com.google.android.libraries.navigation.internal.adg.d dVar, com.google.android.libraries.navigation.internal.oe.o oVar) throws IOException {
        float f;
        int i;
        com.google.android.libraries.navigation.internal.adg.h hVar = dVar.c;
        if (hVar == null) {
            hVar = com.google.android.libraries.navigation.internal.adg.h.a;
        }
        com.google.android.libraries.navigation.internal.oe.x xVarG = oVar.g(hVar.c);
        if ((dVar.b & 4) != 0) {
            f = dVar.e / 10.0f;
            i = 1;
        } else {
            f = 0.0f;
            i = 2;
        }
        return new c(xVarG, i, f);
    }

    public final boolean c() {
        float f = this.b;
        if (Float.isNaN(f)) {
            return false;
        }
        return (f == 0.0f && this.c == 2) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (this.c != cVar.c) {
            return false;
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = this.a;
        if (xVar == null) {
            if (cVar.a != null) {
                return false;
            }
        } else if (!xVar.equals(cVar.a)) {
            return false;
        }
        return Float.floatToIntBits(this.b) == Float.floatToIntBits(cVar.b);
    }

    public final int hashCode() {
        int i = this.c;
        if (i == 0) {
            throw null;
        }
        int i2 = i + 31;
        com.google.android.libraries.navigation.internal.oe.x xVar = this.a;
        return (((i2 * 31) + (xVar == null ? 0 : xVar.hashCode())) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("AbsolutePosition{position=");
        sb.append(this.a);
        if (c()) {
            sb.append(", rotationMode=");
            int i = this.c;
            if (i != 1) {
                str = i != 2 ? BuildConfig.TRAVIS : "SCREEN_RELATIVE";
            } else {
                str = "WORLD_RELATIVE";
            }
            sb.append((Object) str);
            sb.append(", rotation=");
            sb.append(this.b);
        }
        sb.append('}');
        return sb.toString();
    }
}
