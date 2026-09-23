package com.google.android.libraries.navigation.internal.ael;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bh extends ap {
    final cy a;
    public final Object b;
    final cy c;
    public final bg d;

    public bh(cy cyVar, Object obj, cy cyVar2, bg bgVar) {
        if (cyVar == null) {
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }
        if (bgVar.c == es.MESSAGE && cyVar2 == null) {
            throw new IllegalArgumentException("Null messageDefaultInstance");
        }
        this.a = cyVar;
        this.b = obj;
        this.c = cyVar2;
        this.d = bgVar;
    }

    public final int a() {
        return this.d.b;
    }

    public final es b() {
        return this.d.c;
    }

    public final Object c(Object obj) {
        bg bgVar = this.d;
        if (!bgVar.d) {
            return d(obj);
        }
        if (bgVar.c() != et.ENUM) {
            return obj;
        }
        dj djVar = new dj(dj.a, 0, true);
        List list = (List) obj;
        djVar.d(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            djVar.add(d(it2.next()));
        }
        djVar.b();
        return djVar;
    }

    final Object d(Object obj) {
        if (this.d.c() != et.ENUM) {
            return obj;
        }
        bg bgVar = this.d;
        return bgVar.a.a(((Integer) obj).intValue());
    }

    final Object e(Object obj) {
        return this.d.c() == et.ENUM ? Integer.valueOf(((bm) obj).a()) : obj;
    }

    public final boolean f() {
        return this.d.d;
    }
}
