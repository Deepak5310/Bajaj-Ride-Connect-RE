package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lv;
import j$.time.Duration;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.bp.f");

    /* JADX WARN: Multi-variable type inference failed */
    static b a(av[] avVarArr) {
        ev evVarG;
        if (gs.g(de.d(Arrays.asList(avVarArr)).h(), new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.bp.e
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                return ((av) obj).b == null;
            }
        })) {
            return null;
        }
        int i = ev.d;
        eq eqVar = new eq();
        Duration durationPlus = Duration.ZERO;
        int i2 = 0;
        for (int i3 = 0; i3 < avVarArr.length; i3++) {
            if (i3 > 0) {
                av avVar = avVarArr[i3 - 1];
                if ((avVar.d().b & 4) != 0) {
                    com.google.android.libraries.navigation.internal.adr.bm bmVar = avVar.d().e;
                    if (bmVar == null) {
                        bmVar = com.google.android.libraries.navigation.internal.adr.bm.a;
                    }
                    i2 += bmVar.c;
                    com.google.android.libraries.navigation.internal.adr.cm cmVar = avVar.d().i;
                    if (cmVar == null) {
                        cmVar = com.google.android.libraries.navigation.internal.adr.cm.a;
                    }
                    if ((cmVar.b & 1) != 0) {
                        com.google.android.libraries.navigation.internal.adr.cm cmVar2 = avVar.d().i;
                        if (cmVar2 == null) {
                            cmVar2 = com.google.android.libraries.navigation.internal.adr.cm.a;
                        }
                        com.google.android.libraries.navigation.internal.aap.d dVar = cmVar2.c;
                        if (dVar == null) {
                            dVar = com.google.android.libraries.navigation.internal.aap.d.a;
                        }
                        durationPlus = durationPlus.plus(com.google.android.libraries.navigation.internal.bw.a.a(dVar));
                    } else if ((avVar.d().b & 8) != 0) {
                        com.google.android.libraries.navigation.internal.aap.d dVar2 = avVar.d().f;
                        if (dVar2 == null) {
                            dVar2 = com.google.android.libraries.navigation.internal.aap.d.a;
                        }
                        durationPlus = durationPlus.plus(com.google.android.libraries.navigation.internal.bw.a.a(dVar2));
                    } else {
                        ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('1')).p("Missing Path information for AD polylines");
                        evVarG = lv.a;
                    }
                } else {
                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F('2')).p("Missing Path information for AD polylines");
                    evVarG = lv.a;
                }
                return new g(evVarG);
            }
            b bVar = avVarArr[i3].b;
            if (bVar != null) {
                int i4 = 0;
                while (true) {
                    ev evVar = ((g) bVar).b;
                    if (i4 < ((lv) evVar).c) {
                        d dVar3 = (d) evVar.get(i4);
                        h hVar = new h();
                        hVar.e(dVar3.b() + i2);
                        hVar.c(dVar3.a());
                        hVar.d(dVar3.d().plus(durationPlus));
                        hVar.b(dVar3.c());
                        eqVar.h(hVar.a());
                        i4++;
                    }
                }
            }
        }
        evVarG = eqVar.g();
        return new g(evVarG);
    }
}
