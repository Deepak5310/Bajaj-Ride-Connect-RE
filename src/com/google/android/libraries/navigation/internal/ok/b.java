package com.google.android.libraries.navigation.internal.ok;

import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.ob.h;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.aq;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.ou.c;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final c a;
    public final aq b;
    public final an c;
    public final AtomicBoolean d;
    private final ConcurrentHashMap e = new ConcurrentHashMap();

    public b(c cVar, an anVar, at atVar) {
        new ConcurrentHashMap();
        this.a = cVar;
        this.b = new aq(atVar);
        this.c = anVar;
        this.d = new AtomicBoolean(false);
    }

    public final void a(h hVar) {
        com.google.android.libraries.navigation.internal.ou.b bVar = (com.google.android.libraries.navigation.internal.ou.b) this.e.remove(hVar);
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void b(final h hVar) {
        this.e.compute(hVar, new BiFunction() { // from class: com.google.android.libraries.navigation.internal.ok.a
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                com.google.android.libraries.navigation.internal.ou.b bVar = (com.google.android.libraries.navigation.internal.ou.b) obj2;
                if (bVar != null) {
                    return bVar;
                }
                h hVar2 = hVar;
                b bVar2 = this.a;
                an anVarB = hVar2 == h.TRAFFIC ? bVar2.c : hVar2.b(bVar2.d.get());
                ap apVarA = bVar2.b.a(anVarB);
                com.google.android.libraries.navigation.internal.adn.a aVar = (com.google.android.libraries.navigation.internal.adn.a) com.google.android.libraries.navigation.internal.adn.b.a.q();
                if (!aVar.b.H()) {
                    aVar.v();
                }
                int i = anVarB.ah;
                com.google.android.libraries.navigation.internal.adn.b bVar3 = (com.google.android.libraries.navigation.internal.adn.b) aVar.b;
                bVar3.b |= 1;
                bVar3.c = i;
                String str = apVarA.b;
                if (!aVar.b.H()) {
                    aVar.v();
                }
                com.google.android.libraries.navigation.internal.adn.b bVar4 = (com.google.android.libraries.navigation.internal.adn.b) aVar.b;
                str.getClass();
                bVar4.b |= 4;
                bVar4.e = str;
                String str2 = apVarA.a;
                if (!aVar.b.H()) {
                    aVar.v();
                }
                com.google.android.libraries.navigation.internal.adn.b bVar5 = (com.google.android.libraries.navigation.internal.adn.b) aVar.b;
                str2.getClass();
                bVar5.b |= 2;
                bVar5.d = str2;
                return bVar2.a.a((com.google.android.libraries.navigation.internal.adn.b) aVar.t(), com.google.android.libraries.navigation.internal.adf.b.a);
            }
        });
    }

    public final boolean c(h hVar) {
        return this.e.containsKey(hVar);
    }
}
