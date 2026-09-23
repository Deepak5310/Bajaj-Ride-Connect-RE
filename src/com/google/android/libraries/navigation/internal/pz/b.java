package com.google.android.libraries.navigation.internal.pz;

import android.graphics.Color;
import android.graphics.Typeface;
import com.google.android.libraries.geo.mapcore.internal.model.ai;
import com.google.android.libraries.geo.mapcore.internal.model.cb;
import com.google.android.libraries.geo.mapcore.internal.model.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static float a(ai aiVar) {
        cb cbVar = aiVar.r;
        float f = cbVar != null ? ((o) cbVar).d : 2.8f;
        if (Color.alpha(c(aiVar)) == 0) {
            return 0.0f;
        }
        return f;
    }

    public static float b(int i, d dVar, float f) {
        float f2 = i * dVar.e;
        float f3 = dVar.c;
        int i2 = dVar.d;
        return Math.max(f3, Math.min(32.0f, f2)) * f;
    }

    public static int c(ai aiVar) {
        if (aiVar.q()) {
            return ((o) aiVar.r).b;
        }
        int iD = d(aiVar);
        return (((((((iD >>> 16) & 255) * 77) + (((iD >>> 8) & 255) * 151)) + ((iD & 255) * 28)) >> 8) >= 192 ? 8421504 : 16777215) | ((((iD >>> 24) * 160) / 255) << 24);
    }

    public static int d(ai aiVar) {
        int i = aiVar.q() ? ((o) aiVar.r).a : -9541545;
        if (i == 0) {
            return -9541545;
        }
        return i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public static Typeface e(int i, boolean z) {
        ?? r1;
        Typeface typefaceCreate = null;
        if (i > 0) {
            boolean zK = cb.k(i);
            if (cb.l(i)) {
                r1 = zK;
                r1 = (zK ? 1 : 0) | 2;
            }
            r1 = zK;
            if (cb.m(i)) {
                typefaceCreate = Typeface.create(true != z ? "sans-serif-light" : "google-sans-light", r1 == true ? 1 : 0);
            } else if (cb.n(i)) {
                try {
                    typefaceCreate = Typeface.create(z ? "google-sans-medium" : "sans-serif-medium", r1 == true ? 1 : 0);
                } catch (Exception unused) {
                }
            }
        } else {
            r1 = 0;
        }
        if (typefaceCreate == null && z) {
            typefaceCreate = Typeface.create("google-sans", (int) r1);
        }
        return typefaceCreate == null ? Typeface.defaultFromStyle(r1) : typefaceCreate;
    }
}
