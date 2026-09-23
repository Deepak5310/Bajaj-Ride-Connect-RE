package com.google.android.libraries.navigation.internal.pe;

import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.iv.p;
import com.google.android.libraries.navigation.internal.iv.t;
import com.google.android.libraries.navigation.internal.iv.v;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final t a = d("lat");
    public static final t b = d("lng");
    public static final t c = d("zoom");
    public static final t d = d("tilt");
    public static final t e = d("bearing");
    public static final p f = new p("Camera_tracking", ab.c);
    public static final v g = new v("Camera_timestamp", ab.c);
    public final f h;
    public boolean i;

    public c(f fVar) {
        this.h = fVar;
    }

    public static final Object c(ab abVar, Class cls, Map map) {
        String string = abVar.toString();
        if (!map.containsKey(string)) {
            throw new IllegalArgumentException("Missing key: ".concat(String.valueOf(String.valueOf(abVar))));
        }
        Object obj = map.get(string);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        throw new ClassCastException("Incompatible value: " + String.valueOf(obj) + "[" + String.valueOf(obj.getClass()) + "]  for " + String.valueOf(abVar) + "  " + cls.toString());
    }

    private static t d(String str) {
        return new t("Camera_".concat(str), ab.c);
    }

    public final synchronized void a() {
        if (this.i) {
            return;
        }
        this.h.z();
        this.i = true;
    }

    public final boolean b() {
        return this.h.w(a) || this.h.w(b) || this.h.w(c) || this.h.w(d) || this.h.w(e) || this.h.w(f) || this.h.w(g);
    }
}
