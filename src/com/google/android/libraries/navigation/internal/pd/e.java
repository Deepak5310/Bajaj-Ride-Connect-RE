package com.google.android.libraries.navigation.internal.pd;

import androidx.core.math.MathUtils;
import com.google.android.libraries.navigation.internal.yx.al;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements Serializable {
    public static final e a = new e(0.0f, 0.0f);
    public final float b;
    public final float c;

    public e(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public static e c(float f, float f2, float f3, float f4) {
        return new e(((f + f) / f3) - 1.0f, ((f2 + f2) / f4) - 1.0f);
    }

    public static e e(e eVar) {
        float f = eVar.b;
        float fClamp = Float.isNaN(f) ? 0.0f : MathUtils.clamp(f, -1.0f, 1.0f);
        float f2 = eVar.c;
        float fClamp2 = Float.isNaN(f2) ? 0.0f : MathUtils.clamp(f2, -1.0f, 1.0f);
        return (Float.floatToIntBits(fClamp) == Float.floatToIntBits(eVar.b) && Float.floatToIntBits(fClamp2) == Float.floatToIntBits(eVar.c)) ? eVar : new e(fClamp, fClamp2);
    }

    public final float a() {
        return (this.b + 1.0f) / 2.0f;
    }

    public final float b() {
        return (this.c + 1.0f) / 2.0f;
    }

    public final e d(e eVar, float f) {
        float f2 = eVar.b;
        float f3 = this.b;
        float f4 = eVar.c;
        float f5 = this.c;
        return new e(f3 + ((f2 - f3) * f), f5 + ((f4 - f5) * f));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (Float.floatToIntBits(this.b) == Float.floatToIntBits(eVar.b) && Float.floatToIntBits(this.c) == Float.floatToIntBits(eVar.c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.b), Float.valueOf(this.c)});
    }

    public final String toString() {
        return al.b(this).b("x", this.b).b("y", this.c).toString();
    }
}
