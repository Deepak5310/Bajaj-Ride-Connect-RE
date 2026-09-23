package com.google.android.libraries.navigation.internal.ky;

import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.EnumSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aw {
    public static final aw a = new aw(mp.b(EnumSet.allOf(ax.class)));
    public static final aw b = new aw(mb.a);
    public static final aw c = new aw(mp.c(ax.ZWIEBACK, new ax[0]));
    public final fy d;

    public aw(fy fyVar) {
        this.d = fyVar;
    }

    public final boolean a(ax axVar) {
        return this.d.contains(axVar);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof aw) && this.d.equals(((aw) obj).d);
    }

    public final int hashCode() {
        return this.d.hashCode();
    }
}
