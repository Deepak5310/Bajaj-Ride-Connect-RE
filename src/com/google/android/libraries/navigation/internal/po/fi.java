package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.HashSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fi {
    public final com.google.android.libraries.navigation.internal.yz.fd a;
    public final com.google.android.libraries.navigation.internal.yz.fd b;
    private final com.google.android.libraries.navigation.internal.ob.s c;
    private final com.google.android.libraries.navigation.internal.yz.fd d;
    private final com.google.android.libraries.navigation.internal.ace.ff e;

    public fi(com.google.android.libraries.navigation.internal.ob.s sVar, final com.google.android.libraries.navigation.internal.agl.a aVar) {
        com.google.android.libraries.navigation.internal.adi.an anVar = com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PERSONALIZATION;
        fh fhVar = fh.ENABLE_AT_STARTUP;
        com.google.android.libraries.navigation.internal.adi.an anVar2 = com.google.android.libraries.navigation.internal.adi.an.GMM_LOCAL_RECOMMENDATIONS;
        fh fhVar2 = fh.ENABLE_AT_STARTUP;
        com.google.android.libraries.navigation.internal.adi.an anVar3 = com.google.android.libraries.navigation.internal.adi.an.DESTINATIONS;
        fh fhVar3 = fh.ENABLE_WHEN_INTENTED;
        com.google.android.libraries.navigation.internal.adi.an anVar4 = com.google.android.libraries.navigation.internal.adi.an.EVCS;
        com.google.android.libraries.navigation.internal.adi.an anVar5 = com.google.android.libraries.navigation.internal.adi.an.GMM_BUSYNESS;
        com.google.android.libraries.navigation.internal.adi.an anVar6 = com.google.android.libraries.navigation.internal.adi.an.GMM_AREA_BUSYNESS;
        com.google.android.libraries.navigation.internal.adi.an anVar7 = com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PHOTOS;
        com.google.android.libraries.navigation.internal.adi.an anVar8 = com.google.android.libraries.navigation.internal.adi.an.ADDITIVE_STATIC_LABELS;
        com.google.android.libraries.navigation.internal.adi.an anVar9 = com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_OVERLAY;
        fh fhVar4 = fh.ENABLE_AFTER_STARTUP;
        com.google.android.libraries.navigation.internal.adi.an anVar10 = com.google.android.libraries.navigation.internal.adi.an.MAPS_WAYFINDING;
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar, fhVar);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar2, fhVar2);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar3, fhVar3);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar4, fhVar3);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar5, fhVar2);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar6, fhVar2);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar7, fhVar2);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar8, fhVar2);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar9, fhVar4);
        com.google.android.libraries.navigation.internal.yz.bs.a(anVar10, fhVar3);
        ma maVarA = ma.a(10, new Object[]{anVar, fhVar, anVar2, fhVar2, anVar3, fhVar3, anVar4, fhVar3, anVar5, fhVar2, anVar6, fhVar2, anVar7, fhVar2, anVar8, fhVar2, anVar9, fhVar4, anVar10, fhVar3});
        Object objA = aVar.a();
        HashSet hashSetF = mp.f(com.google.android.libraries.navigation.internal.adi.an.GMM_LOCAL_RECOMMENDATIONS, com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PERSONALIZATION, com.google.android.libraries.navigation.internal.adi.an.GMM_AREA_BUSYNESS, com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PHOTOS, com.google.android.libraries.navigation.internal.adi.an.ADDITIVE_STATIC_LABELS, com.google.android.libraries.navigation.internal.adi.an.GMM_BUSYNESS);
        if (((com.google.android.libraries.navigation.internal.om.l) objA).e()) {
            hashSetF.remove(com.google.android.libraries.navigation.internal.adi.an.GMM_LOCAL_RECOMMENDATIONS);
        }
        com.google.android.libraries.navigation.internal.yz.fy.o(hashSetF);
        this.c = sVar;
        com.google.android.libraries.navigation.internal.yz.ez ezVar = new com.google.android.libraries.navigation.internal.yz.ez();
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PERSONALIZATION, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fa
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).l());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_LOCAL_RECOMMENDATIONS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fd
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).x());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.DESTINATIONS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fe
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).q());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.EVCS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.ff
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).t());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_BUSYNESS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fg
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).n());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_AREA_BUSYNESS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.et
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).j());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PHOTOS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.eu
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).m());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.GMM_CRISIS_OVERLAY, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.ev
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).o());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.MAPS_WAYFINDING, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.ew
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).D());
            }
        });
        ezVar.f(com.google.android.libraries.navigation.internal.adi.an.ADDITIVE_STATIC_LABELS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.ex
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).g());
            }
        });
        this.d = ezVar.d();
        this.b = com.google.android.libraries.navigation.internal.yz.fd.l(com.google.android.libraries.navigation.internal.adi.an.GMM_LOCAL_RECOMMENDATIONS, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fb
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.l) aVar.a()).J());
            }
        }, com.google.android.libraries.navigation.internal.adi.an.GMM_BASEMAP_PERSONALIZATION, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.fc
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return false;
            }
        });
        this.a = maVarA;
        this.e = ((com.google.android.libraries.navigation.internal.om.l) aVar.a()).d();
    }

    public final com.google.android.libraries.navigation.internal.yz.fy a() {
        return this.a.keySet();
    }

    public final boolean b(com.google.android.libraries.navigation.internal.adi.an anVar) {
        return ((Boolean) ((com.google.android.libraries.navigation.internal.yx.br) this.b.getOrDefault(anVar, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.ey
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return false;
            }
        })).a()).booleanValue();
    }

    public final boolean c(com.google.android.libraries.navigation.internal.adi.an anVar) {
        if (this.c.a(anVar)) {
            return ((Boolean) ((com.google.android.libraries.navigation.internal.yx.br) this.d.getOrDefault(anVar, new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.ez
                @Override // com.google.android.libraries.navigation.internal.yx.br
                public final Object a() {
                    return false;
                }
            })).a()).booleanValue();
        }
        return false;
    }

    public final boolean d(boolean z) {
        return this.e == com.google.android.libraries.navigation.internal.ace.ff.NEVER_SHOW && z;
    }
}
