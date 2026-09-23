package com.google.android.libraries.navigation.internal.sk;

import android.app.Application;
import android.content.Context;
import com.reactnativekeyboardcontroller.views.background.ImePackages;
import java.io.File;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ek implements dt {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.ek");
    private final Context b;
    private final com.google.android.libraries.navigation.internal.mj.a c;
    private final ce d;
    private final com.google.android.libraries.navigation.internal.iv.f e;
    private final com.google.android.libraries.navigation.internal.gb.a f;
    private final com.google.android.libraries.navigation.internal.tv.f g;
    private final com.google.android.libraries.navigation.internal.fz.d h;
    private com.google.android.libraries.navigation.internal.tv.e i;
    private ei j;
    private final eo k;

    public ek(ce ceVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.gb.a aVar2, com.google.android.libraries.navigation.internal.tv.f fVar2, eo eoVar, Context context) {
        this.d = ceVar;
        this.h = dVar;
        this.e = fVar;
        this.c = aVar;
        this.f = aVar2;
        this.g = fVar2;
        this.k = eoVar;
        this.b = context;
    }

    private final long j() {
        try {
            return this.b.getPackageManager().getPackageInfo(ImePackages.GOOGLE_TTS, 0).versionCode;
        } catch (Exception unused) {
            return -1L;
        }
    }

    private final eh k(com.google.android.libraries.navigation.internal.tu.t tVar) {
        File fileA;
        boolean z = false;
        if (!n() || h() == null) {
            fileA = null;
        } else {
            com.google.android.libraries.navigation.internal.tu.s sVar = (com.google.android.libraries.navigation.internal.tu.s) h();
            com.google.android.libraries.navigation.internal.tu.y yVar = sVar.d;
            Application application = sVar.b;
            fileA = yVar.a(com.google.android.libraries.navigation.internal.tu.s.b(sVar.c, tVar, sVar.h));
            if (fileA != null) {
                z = true;
            }
        }
        if (fileA == null && m() && g() != null) {
            fileA = g().a(tVar);
        }
        if (fileA != null && fileA.exists() && fileA.canRead()) {
            return new eh(fileA, this.d, this.e, z);
        }
        return null;
    }

    private final synchronized void l() {
        if (this.i == null) {
            this.i = this.g.a(new ej(this), this.h);
        }
    }

    private final boolean m() {
        if (!this.k.e() || this.k.d()) {
            return true;
        }
        return j() >= Math.max(210316363L, this.h.R().s);
    }

    private final boolean n() {
        if (this.f.a()) {
            return false;
        }
        return !this.h.R().q || j() < Math.max(210316363L, this.h.R().s);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.z
    public final c a(com.google.android.libraries.navigation.internal.vn.d dVar) {
        return k(dVar.a);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.z
    public final void b() {
        ei eiVar;
        boolean z;
        synchronized (this) {
            eiVar = this.j;
            z = true;
            if (eiVar != null) {
                if (eiVar.b == com.google.android.libraries.navigation.internal.sl.h.j) {
                    z = false;
                }
                if (z) {
                    this.j = null;
                }
            } else {
                eiVar = null;
            }
        }
        if (eiVar != null && z) {
            eiVar.c();
        }
        if (g() != null && z) {
            g().c();
        }
        if (h() == null || !z) {
            return;
        }
        com.google.android.libraries.navigation.internal.tu.s sVar = (com.google.android.libraries.navigation.internal.tu.s) h();
        sVar.g.size();
        sVar.g.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.du
    public final void c(Locale locale) {
        if (g() != null) {
            com.google.android.libraries.navigation.internal.tv.d dVarG = g();
            synchronized (dVarG) {
                ((com.google.android.libraries.navigation.internal.tu.f) dVarG).e = false;
            }
            com.google.android.libraries.navigation.internal.tu.f fVar = (com.google.android.libraries.navigation.internal.tu.f) dVarG;
            fVar.c();
            fVar.b.d(locale, new com.google.android.libraries.navigation.internal.tu.d(fVar));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r0 != false) goto L14;
     */
    @Override // com.google.android.libraries.navigation.internal.sk.dt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(com.google.android.libraries.navigation.internal.vn.d dVar, dr drVar, com.google.android.libraries.navigation.internal.tv.c cVar, com.google.android.libraries.navigation.internal.sl.h hVar) {
        boolean z;
        com.google.android.libraries.navigation.internal.tv.b bVar;
        com.google.android.libraries.navigation.internal.tv.d dVarH;
        boolean zF = f(dVar);
        if (cVar.equals(com.google.android.libraries.navigation.internal.tv.c.PREFETCH) && !dVar.a.toString().isEmpty() && n() && (dVarH = h()) != null) {
            com.google.android.libraries.navigation.internal.tu.s sVar = (com.google.android.libraries.navigation.internal.tu.s) dVarH;
            sVar.f.k();
            if (zF) {
                sVar.f.j();
                if (drVar != null) {
                    a(dVar);
                    drVar.g();
                    return;
                }
                return;
            }
            ei eiVar = new ei(dVar, drVar, cVar, hVar);
            if (eiVar.a == com.google.android.libraries.navigation.internal.tv.c.NOW) {
                synchronized (this) {
                    this.j = eiVar;
                }
            }
            com.google.android.libraries.navigation.internal.tv.c cVar2 = eiVar.a;
            if ((cVar2 == com.google.android.libraries.navigation.internal.tv.c.NOW || cVar2 == com.google.android.libraries.navigation.internal.tv.c.SOON || (cVar2 == com.google.android.libraries.navigation.internal.tv.c.PREFETCH && this.h.R() != null && this.h.R().p)) && m()) {
                com.google.android.libraries.navigation.internal.tu.t tVarA = eiVar.a();
                com.google.android.libraries.navigation.internal.tv.c cVar3 = eiVar.a;
                if (g() != null) {
                    com.google.android.libraries.navigation.internal.tv.d dVarG = g();
                    com.google.android.libraries.navigation.internal.tv.b bVar2 = new com.google.android.libraries.navigation.internal.tv.b(tVarA, cVar3, this.c.a());
                    synchronized (dVarG) {
                        z = ((com.google.android.libraries.navigation.internal.tu.f) dVarG).e;
                        bVar = null;
                        if (!z) {
                            com.google.android.libraries.navigation.internal.tv.b bVar3 = ((com.google.android.libraries.navigation.internal.tu.f) dVarG).d;
                            if (bVar3 != null) {
                                bVar = bVar3;
                            }
                            ((com.google.android.libraries.navigation.internal.tu.f) dVarG).d = bVar2;
                        }
                    }
                    if (bVar != null) {
                        ((com.google.android.libraries.navigation.internal.tu.f) dVarG).f(bVar.a);
                    }
                    if (z) {
                        ((com.google.android.libraries.navigation.internal.tu.f) dVarG).h(bVar2);
                    }
                }
            }
            if (n()) {
                com.google.android.libraries.navigation.internal.tu.t tVarA2 = eiVar.a();
                com.google.android.libraries.navigation.internal.tv.c cVar4 = eiVar.a;
                if (h() != null) {
                    com.google.android.libraries.navigation.internal.tv.d dVarH2 = h();
                    com.google.android.libraries.navigation.internal.tv.b bVar4 = new com.google.android.libraries.navigation.internal.tv.b(tVarA2, cVar4, this.c.a());
                    com.google.android.libraries.navigation.internal.tu.s.a aVar = ((com.google.android.libraries.navigation.internal.tu.s) dVarH2).e;
                    aVar.a.add(bVar4);
                    com.google.android.libraries.navigation.internal.tv.b[] bVarArr = (com.google.android.libraries.navigation.internal.tv.b[]) aVar.a.toArray(com.google.android.libraries.navigation.internal.tu.s.a);
                    com.google.android.libraries.navigation.internal.yx.ar.q(bVarArr);
                    for (int i = 0; i < bVarArr.length; i++) {
                        com.google.android.libraries.navigation.internal.tv.b bVar5 = bVarArr[i];
                        if (bVar5 != bVar4 && bVar5.a.equals(bVar4.a)) {
                            com.google.android.libraries.navigation.internal.tv.b bVar6 = bVarArr[i];
                            for (int i2 = 0; i2 < bVarArr.length; i2++) {
                                if (bVarArr[i2].b.compareTo(bVar4.b) < 0) {
                                    com.google.android.libraries.navigation.internal.tv.b bVar7 = bVarArr[i2];
                                    if (bVar7.c <= bVar6.c) {
                                        aVar.a.remove(bVar7);
                                    }
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sk.du
    public final void e(com.google.android.libraries.navigation.internal.vn.d dVar, com.google.android.libraries.navigation.internal.tv.c cVar) {
        d(dVar, null, cVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dt
    public final boolean f(com.google.android.libraries.navigation.internal.vn.d dVar) {
        c cVarA = a(dVar);
        if (cVarA == null) {
            return false;
        }
        if (!n() || h() == null) {
            return true;
        }
        return ((eh) cVarA).b == b.b;
    }

    public final com.google.android.libraries.navigation.internal.tv.d g() {
        l();
        return ((com.google.android.libraries.navigation.internal.tv.a) this.i).a;
    }

    public final com.google.android.libraries.navigation.internal.tv.d h() {
        l();
        return ((com.google.android.libraries.navigation.internal.tv.a) this.i).b;
    }

    public final void i(com.google.android.libraries.navigation.internal.tu.t tVar) {
        ei eiVar;
        boolean z;
        synchronized (this) {
            eiVar = this.j;
            z = false;
            if (eiVar != null && tVar.equals(eiVar.a())) {
                this.j = null;
                z = true;
            }
        }
        if (z) {
            eiVar.b(k(eiVar.a()));
        } else if (eiVar != null) {
            eiVar.c();
        }
    }
}
