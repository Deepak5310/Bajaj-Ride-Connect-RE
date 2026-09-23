package com.google.android.libraries.geo.mapcore.renderer;

import com.google.android.libraries.navigation.internal.agi.jn;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class en {
    public final ArrayList a;
    boolean b;
    public int c;
    public int d;

    public en(boolean z) {
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = true;
        this.c = 0;
        this.d = 0;
        arrayList.add(new jn());
        if (z) {
            arrayList.add(new jn());
        }
    }

    public final void a(er erVar) {
        for (int i = 0; i < this.a.size(); i++) {
            ((jn) this.a.get(i)).remove(erVar);
        }
    }
}
