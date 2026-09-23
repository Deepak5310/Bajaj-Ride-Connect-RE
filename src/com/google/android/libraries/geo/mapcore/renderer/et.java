package com.google.android.libraries.geo.mapcore.renderer;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class et {
    public float a;
    public float b;
    private final List c;

    public et(List list) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = list;
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            er erVar = (er) it2.next();
            if (erVar != null) {
                this.a = Math.max(this.a, erVar.b());
                this.b = Math.max(this.b, erVar.a());
            }
        }
    }

    public final int a() {
        return this.c.size();
    }

    public final er b(int i) {
        if (i < 0 || i >= this.c.size()) {
            return null;
        }
        return (er) this.c.get(i);
    }

    public final void c() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            if (this.c.get(i) != null) {
                ((er) this.c.get(i)).c();
            }
        }
    }
}
