package com.google.android.libraries.navigation.internal.po;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hn {
    private static final a c = new a(com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b, null);
    private final com.google.android.libraries.navigation.internal.qy.h d;
    private final com.google.android.libraries.navigation.internal.kl.b h;
    private final com.google.android.libraries.navigation.internal.aac.bn i;
    private final gr j;
    private final AtomicInteger e = new AtomicInteger(0);
    public final AtomicBoolean a = new AtomicBoolean();
    private final HashMap f = new HashMap();
    private int g = 0;
    public com.google.android.libraries.navigation.internal.aac.bl b = null;

    public hn(gr grVar, com.google.android.libraries.navigation.internal.qy.h hVar, com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.aac.bn bnVar) {
        this.j = grVar;
        this.d = hVar;
        this.h = bVar;
        this.i = bnVar;
    }

    private final synchronized a j(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar) {
        a aVar = (a) this.f.get(nVar);
        if (aVar != null) {
            return aVar;
        }
        return c;
    }

    final synchronized com.google.android.libraries.geo.mapcore.internal.vector.gl.n a(com.google.android.libraries.geo.mapcore.internal.vector.gl.o oVar, com.google.android.libraries.geo.mapcore.renderer.h hVar) {
        com.google.android.libraries.geo.mapcore.internal.vector.gl.a aVar;
        String str = "ClientProvidedTexture_" + this.e.getAndIncrement();
        com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        aVar = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a(str, oVar);
        a aVar2 = new a(aVar, this.j);
        aVar2.f(hVar);
        this.f.put(aVar, aVar2);
        f();
        return aVar;
    }

    final synchronized com.google.android.libraries.geo.mapcore.internal.vector.gl.n b(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, com.google.android.libraries.geo.mapcore.renderer.h hVar) {
        a aVarJ = j(nVar);
        if (aVarJ != c) {
            aVarJ.d();
            return nVar;
        }
        com.google.android.libraries.geo.mapcore.internal.vector.gl.a aVar = new com.google.android.libraries.geo.mapcore.internal.vector.gl.a("ClientProvidedTexture_" + this.e.getAndIncrement(), nVar.a());
        a aVar2 = new a(nVar, this.j);
        aVar2.f(hVar);
        this.f.put(nVar, aVar2);
        f();
        return aVar;
    }

    final synchronized com.google.android.libraries.geo.mapcore.renderer.ek c(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar) {
        return j(nVar).b();
    }

    final synchronized void d(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar) {
        if (j(nVar) == c) {
            a aVar = new a(nVar, this.j);
            this.f.put(nVar, aVar);
            f();
            com.google.android.libraries.navigation.internal.qy.h hVar = this.d;
            final gr grVar = this.j;
            Objects.requireNonNull(grVar);
            aVar.c(hVar, new hl() { // from class: com.google.android.libraries.navigation.internal.po.hj
                @Override // com.google.android.libraries.navigation.internal.po.hl
                public final void a() {
                    grVar.b();
                }
            });
        }
    }

    final synchronized void e(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, hl hlVar) {
        a aVarJ = j(nVar);
        if (aVarJ == c) {
            a aVar = new a(nVar, this.j);
            this.f.put(nVar, aVar);
            f();
            aVarJ = aVar;
        } else {
            aVarJ.d();
        }
        aVarJ.c(this.d, hlVar);
    }

    final void f() {
        com.google.android.libraries.navigation.internal.aac.bn bnVar;
        if (!this.a.compareAndSet(false, true) || (bnVar = this.i) == null) {
            return;
        }
        this.b = bnVar.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.hk
            @Override // java.lang.Runnable
            public final void run() {
                hn hnVar = this.a;
                hnVar.g();
                hnVar.a.set(false);
            }
        }, 1L, TimeUnit.MINUTES);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        com.google.android.libraries.navigation.internal.yz.ev evVarO;
        com.google.android.libraries.geo.mapcore.renderer.cs csVar;
        synchronized (this) {
            evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(this.f.values());
        }
        int size = evVarO.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = (a) evVarO.get(i2);
            if (aVar != null && !aVar.d) {
                synchronized (aVar) {
                    com.google.android.libraries.geo.mapcore.renderer.ek ekVarB = aVar.b();
                    if (ekVarB != null && (csVar = ekVarB.b) != null) {
                        i += csVar.f * csVar.g * 4;
                    }
                }
            }
        }
        if (i > this.g) {
            this.g = i;
            this.h.e(com.google.android.libraries.navigation.internal.km.p.aw, i);
        }
    }

    final synchronized void h(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar) {
        a aVarJ = j(nVar);
        if (aVarJ != c) {
            aVarJ.e(this.d, nVar.b());
        }
    }

    final synchronized boolean i(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar) {
        a aVarJ = j(nVar);
        if (aVarJ == c) {
            return true;
        }
        if (aVarJ.d) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 912)).p("Attempted to release to a destroyed TextureNode");
        }
        if (aVarJ.c.decrementAndGet() != 0) {
            return false;
        }
        aVarJ.d = true;
        this.f.remove(nVar);
        return true;
    }

    /* JADX INFO: compiled from: PG */
    class a implements com.google.android.libraries.navigation.internal.qz.g {
        public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.po.hn$a");
        private final com.google.android.libraries.geo.mapcore.internal.vector.gl.n e;
        private final gr h;
        public final List b = new ArrayList();
        private com.google.android.libraries.geo.mapcore.renderer.ek f = null;
        private int g = 1;
        public final AtomicInteger c = new AtomicInteger(1);
        public boolean d = false;

        public a(com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar, gr grVar) {
            this.e = nVar;
            this.h = grVar;
        }

        @Override // com.google.android.libraries.navigation.internal.qz.g
        public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
            final Bitmap bitmapC;
            gr grVar;
            if (!kVar.p() || (bitmapC = kVar.c()) == null || (grVar = this.h) == null) {
                return;
            }
            grVar.c(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.hm
                @Override // java.lang.Runnable
                public final void run() {
                    ArrayList arrayList;
                    hn.a aVar = this.a;
                    Bitmap bitmap = bitmapC;
                    synchronized (aVar) {
                        aVar.f(new com.google.android.libraries.geo.mapcore.renderer.i(bitmap));
                        arrayList = new ArrayList(aVar.b.size());
                        arrayList.addAll(aVar.b);
                        aVar.b.clear();
                    }
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        ((hl) arrayList.get(i)).a();
                    }
                }
            });
            this.h.b();
        }

        final synchronized com.google.android.libraries.geo.mapcore.renderer.ek b() {
            return this.f;
        }

        public final void d() {
            if (this.d) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 910)).p("Attempted to add a reference to a destroyed TextureNode");
            }
            this.c.incrementAndGet();
        }

        final synchronized void e(com.google.android.libraries.navigation.internal.qy.h hVar, String str) {
            com.google.android.libraries.navigation.internal.qz.k kVarB = hVar.b(str, "", null);
            if (!kVarB.p() || kVarB.c() == null) {
                this.f = null;
                this.g = 1;
            }
        }

        final synchronized void f(com.google.android.libraries.geo.mapcore.renderer.h hVar) {
            this.g = 3;
            com.google.android.libraries.geo.mapcore.renderer.eg egVarB = hVar.b();
            com.google.android.libraries.geo.mapcore.renderer.ek ekVar = new com.google.android.libraries.geo.mapcore.renderer.ek(this.e.b(), 2, this.e.a().c ? 4 : 1);
            this.f = ekVar;
            int i = ((com.google.android.libraries.geo.mapcore.renderer.g) egVarB).a;
            int i2 = ((com.google.android.libraries.geo.mapcore.renderer.g) egVarB).b;
            ekVar.d(new com.google.android.libraries.geo.mapcore.renderer.cs(hVar, i, i2, i, i2, this.e.a().c));
        }

        final void c(com.google.android.libraries.navigation.internal.qy.h hVar, hl hlVar) {
            boolean z;
            synchronized (this) {
                int i = this.g;
                int i2 = i - 1;
                if (i == 0) {
                    throw null;
                }
                z = true;
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.b.add(hlVar);
                    } else if (i2 != 2) {
                    }
                    z = false;
                } else {
                    com.google.android.libraries.navigation.internal.qz.k kVarB = hVar.b(this.e.b(), "", this);
                    if (kVarB.p()) {
                        Bitmap bitmapC = kVarB.c();
                        if (bitmapC != null) {
                            f(new com.google.android.libraries.geo.mapcore.renderer.i(bitmapC));
                        }
                    } else {
                        this.g = 2;
                        this.b.add(hlVar);
                    }
                    z = false;
                }
            }
            if (z) {
                hlVar.a();
            }
        }
    }
}
