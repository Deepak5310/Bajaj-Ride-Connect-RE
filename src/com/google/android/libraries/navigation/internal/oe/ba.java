package com.google.android.libraries.navigation.internal.oe;

import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba {
    private static final ThreadLocal a = new az();
    private final List b = hx.f(40);

    public static ba b() {
        return (ba) a.get();
    }

    public final ay a() {
        int size = this.b.size();
        return size == 0 ? new ay() : (ay) this.b.remove(size - 1);
    }

    public final void c(ay ayVar) {
        if (this.b.size() >= 40) {
            return;
        }
        this.b.add(ayVar);
    }
}
