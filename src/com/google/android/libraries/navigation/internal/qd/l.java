package com.google.android.libraries.navigation.internal.qd;

import com.google.android.libraries.geo.mapcore.internal.model.ar;
import com.google.android.libraries.geo.mapcore.renderer.af;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.oe.ai;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l {
    public static final float a = (float) Math.log(2.0d);
    public static final float b = (float) Math.log(2.0d);
    public ar c;
    final Map d = new LinkedHashMap();
    public boolean e;
    boolean f;
    public final ax g;
    protected com.google.android.libraries.geo.mapcore.internal.vector.gl.v h;

    public l(ax axVar) {
        this.g = axVar;
    }

    public abstract void a();

    final synchronized void b(a aVar) {
        List list = (List) this.d.get(this.c);
        if (list != null) {
            list.add(aVar.a);
            this.f = true;
        }
    }

    final synchronized void c() {
        ar arVar = this.c;
        if (arVar != null) {
            List list = (List) this.d.get(arVar);
            if (list != null) {
                list.clear();
            }
        } else {
            this.d.clear();
        }
        this.f = true;
    }

    public synchronized void d() {
        if (this.e) {
            i();
        }
    }

    protected abstract void e(af afVar);

    public final void f() {
        this.f = true;
    }

    final synchronized void g(af afVar) {
        d();
        this.e = true;
        e(afVar);
    }

    protected abstract void h(com.google.android.libraries.navigation.internal.pb.t tVar);

    public abstract void i();

    public final synchronized void j(com.google.android.libraries.navigation.internal.pb.t tVar, ai aiVar) {
        if (this.e) {
            if (l(tVar) && aiVar != null && !this.d.isEmpty() && k(tVar, aiVar)) {
                tVar.h();
            }
            h(tVar);
        }
    }

    protected abstract boolean k(com.google.android.libraries.navigation.internal.pb.t tVar, ai aiVar);

    public boolean l(com.google.android.libraries.navigation.internal.pb.t tVar) {
        throw null;
    }
}
