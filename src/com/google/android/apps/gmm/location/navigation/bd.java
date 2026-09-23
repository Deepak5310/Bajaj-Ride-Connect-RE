package com.google.android.apps.gmm.location.navigation;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class bd extends com.google.android.libraries.navigation.internal.ia.k {
    public bd(Class cls, ay ayVar, com.google.android.libraries.navigation.internal.hx.ap apVar) {
        super(cls, ayVar, apVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        ay ayVar = (ay) this.c;
        com.google.android.libraries.navigation.internal.dh.ai aiVar = (com.google.android.libraries.navigation.internal.dh.ai) aVar;
        if (aiVar.g()) {
            long j = ba.a;
            float f = aiVar.b;
            float f2 = aiVar.b;
            long jA = ayVar.a.b.a();
            Long lValueOf = Long.valueOf(jA);
            ba baVar = ayVar.a;
            lValueOf.getClass();
            if (!baVar.f.isEmpty()) {
                int i = 0;
                while (i < baVar.f.size() && jA - ((Long) ((com.google.android.libraries.navigation.internal.yx.ao) baVar.f.get(i)).b).longValue() >= ba.a) {
                    i++;
                }
                baVar.f.subList(0, i).clear();
            }
            ba baVar2 = ayVar.a;
            if (f2 <= baVar2.e) {
                baVar2.f.add(new com.google.android.libraries.navigation.internal.yx.ao(com.google.android.libraries.navigation.internal.ds.b.INDOOR, lValueOf));
            } else {
                baVar2.f.add(new com.google.android.libraries.navigation.internal.yx.ao(com.google.android.libraries.navigation.internal.ds.b.OUTDOOR, lValueOf));
            }
            ba baVar3 = ayVar.a;
        }
    }
}
