package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.bs;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
abstract class n {
    public abstract m a();

    public abstract com.google.android.libraries.geo.mapcore.internal.model.ai b();

    public int c() {
        throw null;
    }

    public final boolean d() {
        return c() > 1;
    }

    public final bs[] e() {
        if (a() == m.AREA_STROKE) {
            return b().f58n;
        }
        return a() == m.VOLUME_STROKE ? b().p : b().o;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            return Arrays.equals(e(), ((n) obj).e());
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(e());
    }
}
