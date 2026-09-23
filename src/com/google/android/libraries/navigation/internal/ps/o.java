package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.oe.ai;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements com.google.android.libraries.navigation.internal.pg.f {
    public volatile boolean a;
    public k b;
    private final com.google.android.libraries.navigation.internal.pg.f e;
    private final ct g;
    public final Object c = new Object();
    private final ai f = new ai(new com.google.android.libraries.navigation.internal.oe.x(), new com.google.android.libraries.navigation.internal.oe.x());
    public final n d = new n();

    public o(com.google.android.libraries.navigation.internal.pg.f fVar, ct ctVar) {
        this.e = fVar;
        this.g = ctVar;
    }

    private static cd e(cd cdVar, com.google.android.libraries.navigation.internal.pt.c cVar) {
        return cdVar.g(cVar.e);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final long a(com.google.android.libraries.navigation.internal.pb.t tVar, List list) {
        long j;
        synchronized (this.d) {
            synchronized (this.c) {
                if (this.b != null) {
                    long j2 = this.d.f;
                    if (tVar.w().k >= 17.0f) {
                        n nVar = this.d;
                        nVar.f = this.e.a(tVar, nVar.a);
                    } else {
                        n nVar2 = this.d;
                        nVar2.f = -1L;
                        nVar2.a.clear();
                    }
                    if (this.a || this.d.f != j2) {
                        this.a = false;
                        this.d.b.clear();
                        this.d.c.clear();
                        this.d.d.clear();
                        byte[] bArr = this.g.a(tVar.t(), an.GMM_VECTOR_BASE).c;
                        int length = bArr.length;
                        byte b = -1;
                        if (length != 0) {
                            b = bArr[length - 1];
                        }
                        synchronized (this.c) {
                            k kVar = this.b;
                            if (kVar != null) {
                                for (int i = 0; i < this.d.a.size(); i++) {
                                    cd cdVar = (cd) this.d.a.get(i);
                                    cdVar.i(this.f);
                                    for (com.google.android.libraries.navigation.internal.pt.b bVar : kVar.c) {
                                        if (bVar.c.b(this.f)) {
                                            com.google.android.libraries.navigation.internal.pt.a aVar = bVar.b;
                                            com.google.android.libraries.navigation.internal.pt.c cVarA = kVar.a(aVar);
                                            if (cVarA != null) {
                                                cd cdVarE = e(cdVar, cVarA);
                                                if (cdVarE.a > b || aVar == null || !cVarA.equals(aVar.a())) {
                                                    this.d.b.add(cdVarE);
                                                } else {
                                                    this.d.c.add(cdVarE);
                                                }
                                            }
                                            if (aVar != null && aVar.equals(kVar.a)) {
                                                no it2 = aVar.b.iterator();
                                                while (it2.hasNext()) {
                                                    com.google.android.libraries.navigation.internal.pt.c cVar = (com.google.android.libraries.navigation.internal.pt.c) it2.next();
                                                    if (cdVar.a > b || !cVar.equals(aVar.a())) {
                                                        if (!cVar.equals(cVarA)) {
                                                            this.d.d.add(e(cdVar, cVar));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                this.d.e++;
                            }
                        }
                    }
                }
            }
            list.clear();
            list.addAll(this.d.b);
            j = this.d.e;
        }
        return j;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final float b(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.e.b(xVar);
        return 22.0f;
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final cd c(cd cdVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        return this.e.c(cdVar, xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.pg.f
    public final List d(cd cdVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        return this.e.d(cdVar, xVar);
    }
}
