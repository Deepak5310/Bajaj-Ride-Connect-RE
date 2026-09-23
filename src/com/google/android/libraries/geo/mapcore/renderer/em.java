package com.google.android.libraries.geo.mapcore.renderer;

import com.google.android.libraries.navigation.internal.agi.jn;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class em implements Iterable {
    final boolean a;
    final int b;
    final jn c;

    public em(boolean z, int i, jn jnVar) {
        this.a = z;
        this.b = i;
        this.c = jnVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.c.d().a();
    }
}
