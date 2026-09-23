package com.google.android.libraries.navigation.internal.vt;

import com.google.android.libraries.navigation.internal.db.s;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.xe.fw;
import com.google.android.libraries.navigation.internal.yz.fz;
import com.google.android.libraries.navigation.internal.zb.j;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private static final j b = j.e("com.google.android.libraries.navigation.internal.vt.d");
    private final com.google.android.libraries.navigation.internal.ia.e c;
    private final a f;
    final CopyOnWriteArraySet a = new CopyOnWriteArraySet();
    private boolean d = false;
    private final c e = new c(this);

    public d(com.google.android.libraries.navigation.internal.ia.e eVar, a aVar) {
        this.c = eVar;
        this.f = aVar;
    }

    public final synchronized void a() {
        a aVar = this.f;
        if (aVar == null || !aVar.g()) {
            return;
        }
        this.f.f();
    }

    public final synchronized void b(fw fwVar) {
        CopyOnWriteArraySet copyOnWriteArraySet = this.a;
        boolean zIsEmpty = copyOnWriteArraySet.isEmpty();
        copyOnWriteArraySet.add(fwVar);
        if (zIsEmpty) {
            a aVar = this.f;
            if (aVar != null) {
                aVar.c();
            }
            if (!this.d) {
                com.google.android.libraries.navigation.internal.ia.e eVar = this.c;
                c cVar = this.e;
                fz fzVar = new fz();
                fzVar.b(s.class, new e(0, s.class, cVar, ap.UI_THREAD));
                fzVar.b(com.google.android.libraries.navigation.internal.dh.a.class, new e(1, com.google.android.libraries.navigation.internal.dh.a.class, cVar, ap.UI_THREAD));
                fzVar.b(com.google.android.libraries.navigation.internal.cw.d.class, new e(2, com.google.android.libraries.navigation.internal.cw.d.class, cVar, ap.UI_THREAD));
                eVar.c(cVar, fzVar.a());
                this.d = true;
            }
        }
    }

    public final synchronized void c(fw fwVar) {
        a aVar;
        if (this.a.remove(fwVar) && this.a.isEmpty() && (aVar = this.f) != null) {
            aVar.d();
        }
    }
}
