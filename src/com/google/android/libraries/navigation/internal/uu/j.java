package com.google.android.libraries.navigation.internal.uu;

import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.hn;
import com.google.android.libraries.navigation.internal.adr.ho;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.ax;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ l a;

    public j(l lVar) {
        this.a = lVar;
    }

    /* JADX WARN: Code duplicated, block: B:60:0x00ef  */
    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        final bm.a aVar;
        com.google.android.libraries.navigation.internal.tj.j jVar = ((com.google.android.libraries.navigation.internal.rw.i) bVar).d;
        if (jVar == null) {
            this.a.d(null);
            this.a.f = false;
            return;
        }
        l lVar = this.a;
        if (!lVar.f) {
            lVar.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.uu.d
                @Override // com.google.android.libraries.navigation.internal.yx.ax
                public final void a(Object obj) {
                    ((k) obj).a();
                }
            });
            this.a.f = true;
        }
        com.google.android.libraries.navigation.internal.se.b bVarC = jVar.c();
        l lVar2 = this.a;
        final al alVar = bVarC.b.j;
        if (alVar != lVar2.d) {
            lVar2.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.uu.b
                @Override // com.google.android.libraries.navigation.internal.yx.ax
                public final void a(Object obj) {
                    ((k) obj).d(alVar);
                }
            });
        }
        lVar2.d = alVar;
        List list = bVarC.b.W;
        boolean z = list.contains("US") || list.contains("CA");
        bg bgVar = bVarC.b;
        bm.a aVar2 = bgVar.O;
        if (!bVarC.m) {
            this.a.d(aVar2);
            this.a.f(z);
            return;
        }
        if (!bgVar.X()) {
            if (this.a.c != -1) {
                bg bgVar2 = bVarC.b;
            }
            this.a.d(aVar2);
            this.a.f(z);
            return;
        }
        bq bqVar = bVarC.c;
        if (bqVar == null) {
            return;
        }
        bq bqVar2 = bqVar.N;
        if (bqVar2 == null) {
            l lVar3 = this.a;
            if (lVar3.e) {
                return;
            }
            lVar3.d(aVar2);
            this.a.f(z);
            this.a.e = true;
            return;
        }
        int i = bqVar.l - bVarC.f;
        bq bqVar3 = this.a.a;
        if (bqVar3 == null || !bqVar3.equals(bqVar2)) {
            l lVar4 = this.a;
            lVar4.a = bqVar2;
            lVar4.b = -1;
        }
        for (ho hoVar : bqVar2.I) {
            int i2 = hoVar.b;
            if (i2 > this.a.b && i2 <= i) {
                int iA = hn.a(hoVar.d);
                if (iA == 0) {
                    iA = hn.a;
                }
                if (iA == hn.b) {
                    aVar = bm.a.KILOMETERS;
                } else {
                    int iA2 = hn.a(hoVar.d);
                    if (iA2 == 0) {
                        iA2 = hn.a;
                    }
                    if (iA2 == hn.c) {
                        aVar = bm.a.MILES;
                    } else if (list.size() > 1) {
                        aVar = null;
                    } else if (list.contains("US")) {
                        aVar = bm.a.MILES;
                    } else if (list.contains("AU") || list.contains("BR") || list.contains("CA")) {
                        aVar = bm.a.KILOMETERS;
                    } else {
                        aVar = null;
                    }
                }
                if (aVar == null) {
                    this.a.d(aVar2);
                    this.a.f(z);
                } else {
                    int i3 = hoVar.c;
                    int i4 = hoVar.b;
                    l lVar5 = this.a;
                    ar.q(hoVar);
                    final int i5 = hoVar.c;
                    final int i6 = hoVar.e;
                    lVar5.c = i5;
                    lVar5.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.uu.i
                        @Override // com.google.android.libraries.navigation.internal.yx.ax
                        public final void a(Object obj) {
                            int i7 = i5;
                            bm.a aVar3 = aVar;
                            ((k) obj).f(l.a(i7, aVar3), aVar3);
                        }
                    });
                    this.a.f(z);
                }
            }
        }
        this.a.b = i;
    }
}
