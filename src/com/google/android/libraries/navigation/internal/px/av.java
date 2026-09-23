package com.google.android.libraries.navigation.internal.px;

import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.agg.fa;
import com.google.android.libraries.navigation.internal.agg.fc;
import com.google.android.libraries.navigation.internal.agg.fd;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av extends ak {
    private final ad a;

    public av(com.google.android.libraries.navigation.internal.fq.f fVar, ad adVar) {
        super(fVar, com.google.android.libraries.navigation.internal.fq.n.POINTS_LABELS);
        this.a = adVar;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0207  */
    /* JADX WARN: Code duplicated, block: B:102:0x020e  */
    /* JADX WARN: Code duplicated, block: B:105:0x0217  */
    /* JADX WARN: Code duplicated, block: B:107:0x021d  */
    /* JADX WARN: Code duplicated, block: B:109:0x0223  */
    /* JADX WARN: Code duplicated, block: B:110:0x0226  */
    /* JADX WARN: Code duplicated, block: B:112:0x022c  */
    /* JADX WARN: Code duplicated, block: B:113:0x022f  */
    /* JADX WARN: Code duplicated, block: B:115:0x023b  */
    /* JADX WARN: Code duplicated, block: B:116:0x023e  */
    /* JADX WARN: Code duplicated, block: B:118:0x0250  */
    /* JADX WARN: Code duplicated, block: B:120:0x0255  */
    /* JADX WARN: Code duplicated, block: B:121:0x025a  */
    /* JADX WARN: Code duplicated, block: B:122:0x025d  */
    /* JADX WARN: Code duplicated, block: B:124:0x0260  */
    /* JADX WARN: Code duplicated, block: B:126:0x0264  */
    /* JADX WARN: Code duplicated, block: B:127:0x0267  */
    /* JADX WARN: Code duplicated, block: B:128:0x026a  */
    /* JADX WARN: Code duplicated, block: B:130:0x0270  */
    /* JADX WARN: Code duplicated, block: B:131:0x0273  */
    /* JADX WARN: Code duplicated, block: B:133:0x0279  */
    /* JADX WARN: Code duplicated, block: B:135:0x027f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0282  */
    /* JADX WARN: Code duplicated, block: B:137:0x0285  */
    /* JADX WARN: Code duplicated, block: B:139:0x028b  */
    /* JADX WARN: Code duplicated, block: B:141:0x0291  */
    /* JADX WARN: Code duplicated, block: B:142:0x0294  */
    /* JADX WARN: Code duplicated, block: B:143:0x0297  */
    /* JADX WARN: Code duplicated, block: B:145:0x029d  */
    /* JADX WARN: Code duplicated, block: B:146:0x02a1  */
    /* JADX WARN: Code duplicated, block: B:148:0x02a7  */
    /* JADX WARN: Code duplicated, block: B:149:0x02ab  */
    /* JADX WARN: Code duplicated, block: B:161:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:164:0x02e8 A[PHI: r6
      0x02e8: PHI (r6v5 com.google.android.libraries.navigation.internal.po.bb) = 
      (r6v1 com.google.android.libraries.navigation.internal.po.bb)
      (r6v3 com.google.android.libraries.navigation.internal.po.bb)
      (r6v3 com.google.android.libraries.navigation.internal.po.bb)
     binds: [B:163:0x02e6, B:166:0x02f9, B:167:0x02fb] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:165:0x02eb  */
    /* JADX WARN: Code duplicated, block: B:70:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:73:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:75:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:81:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:84:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:90:0x01e5  */
    /* JADX WARN: Code duplicated, block: B:92:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:95:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:97:0x01fd  */
    /* JADX WARN: Multi-variable type inference failed */
    public final bz a(ek ekVar, int i, int i2, com.google.android.libraries.navigation.internal.pz.a aVar, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.qz.g gVar2, Resources resources, com.google.android.libraries.navigation.internal.pz.d dVar, boolean z) {
        au auVarB;
        ev evVarD;
        ar arVar;
        com.google.android.libraries.navigation.internal.adl.as asVarR;
        ar arVar2;
        com.google.android.libraries.navigation.internal.adg.d dVar2;
        com.google.android.libraries.geo.mapcore.internal.model.d dVarC;
        com.google.android.libraries.navigation.internal.adg.d dVar3;
        com.google.android.libraries.navigation.internal.adg.b bVarB;
        com.google.android.libraries.navigation.internal.adl.x xVarD;
        com.google.android.libraries.navigation.internal.adl.m mVar;
        com.google.android.libraries.geo.mapcore.renderer.af afVar;
        ad adVar;
        com.google.android.libraries.navigation.internal.po.bb bbVarR;
        com.google.android.libraries.navigation.internal.adg.dt dtVar;
        ar arVarF;
        com.google.android.libraries.navigation.internal.adg.dt dtVar2 = ekVar.o().c;
        if (dtVar2 == null) {
            dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        com.google.android.libraries.navigation.internal.adg.dt dtVar3 = dtVar2;
        int i3 = ev.d;
        ar arVarF2 = ar.f(dtVar3, ekVar, i, lv.a, resources, aVar, bVar, gVar, gVar2, dVar, z);
        if (arVarF2 != null) {
            if (arVarF2.o()) {
                return bz.b;
            }
            ez ezVarA = ei.a(ekVar.o());
            fa faVar = fd.a;
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarD = gVar.d(ekVar, new fc(ezVarA), i);
            fw fwVar = new fw();
            com.google.android.libraries.navigation.internal.adg.ef efVarO = ekVar.o();
            com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.c);
            efVarO.h(bhVarS);
            if (efVarO.w.n(bhVarS.d)) {
                com.google.android.libraries.navigation.internal.adg.ef efVarO2 = ekVar.o();
                com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.c);
                efVarO2.h(bhVarS2);
                Object objK = efVarO2.w.k(bhVarS2.d);
                Object objC = objK == null ? bhVarS2.b : bhVarS2.c(objK);
                com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
                for (com.google.android.libraries.navigation.internal.adl.z zVar : ((com.google.android.libraries.navigation.internal.adl.ad) objC).b) {
                    com.google.android.libraries.navigation.internal.adg.ee eeVarB = com.google.android.libraries.navigation.internal.adg.ee.b(zVar.c);
                    if (eeVarB == null) {
                        eeVarB = com.google.android.libraries.navigation.internal.adg.ee.CENTER_LEFT_TO_CENTER_RIGHT;
                    }
                    com.google.android.libraries.navigation.internal.adg.ds dsVarB = com.google.android.libraries.navigation.internal.adg.ds.b(zVar.d);
                    if (dsVarB == null) {
                        dsVarB = com.google.android.libraries.navigation.internal.adg.ds.LEFT_JUSTIFY;
                    }
                    eqVar.h(new com.google.android.libraries.geo.mapcore.internal.model.k(eeVarB, dsVarB));
                }
                fwVar.k(eqVar.g());
            }
            fwVar.k(aiVarD.y);
            ev evVarD2 = fwVar.i().d();
            com.google.android.libraries.navigation.internal.po.bb bbVarR2 = null;
            if ((ekVar.o().b & 2) == 0) {
                auVarB = null;
            } else if (evVarD2.isEmpty()) {
                com.google.android.libraries.navigation.internal.adg.ee eeVarB2 = com.google.android.libraries.navigation.internal.adg.ee.b(ekVar.o().g);
                if (eeVarB2 == null) {
                    eeVarB2 = com.google.android.libraries.navigation.internal.adg.ee.CENTER_LEFT_TO_CENTER_RIGHT;
                }
                auVarB = ax.b(eeVarB2);
            } else {
                auVarB = ax.b(((com.google.android.libraries.geo.mapcore.internal.model.aj) evVarD2.get(0)).b());
            }
            com.google.android.libraries.navigation.internal.adl.as asVarR2 = ekVar.r();
            if (asVarR2 == null) {
                evVarD = lv.a;
            } else {
                fw fwVar2 = new fw();
                for (com.google.android.libraries.navigation.internal.adl.z zVar2 : asVarR2.c) {
                    com.google.android.libraries.navigation.internal.adg.ee eeVarB3 = com.google.android.libraries.navigation.internal.adg.ee.b(zVar2.c);
                    if (eeVarB3 == null) {
                        eeVarB3 = com.google.android.libraries.navigation.internal.adg.ee.CENTER_LEFT_TO_CENTER_RIGHT;
                    }
                    com.google.android.libraries.navigation.internal.adg.ds dsVarB2 = com.google.android.libraries.navigation.internal.adg.ds.b(zVar2.d);
                    if (dsVarB2 == null) {
                        dsVarB2 = com.google.android.libraries.navigation.internal.adg.ds.LEFT_JUSTIFY;
                    }
                    fwVar2.c(new com.google.android.libraries.geo.mapcore.internal.model.k(eeVarB3, dsVarB2));
                }
                evVarD = fwVar2.i().d();
            }
            au auVarB2 = ekVar.r() == null ? null : evVarD.isEmpty() ? ax.a : ax.b(((com.google.android.libraries.geo.mapcore.internal.model.aj) evVarD.get(0)).b());
            if ((ekVar.o().b & 2) == 0) {
                arVar = null;
                asVarR = ekVar.r();
                if (asVarR == null) {
                    arVar2 = null;
                } else {
                    dtVar = asVarR.b;
                    if (dtVar == null) {
                        dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
                    }
                    arVarF = ar.f(dtVar, ekVar, i, evVarD, resources, aVar, bVar, gVar, gVar2, dVar, z);
                    if (arVarF != null) {
                        if (arVarF.o()) {
                            arVar2 = null;
                        } else {
                            arVar2 = arVarF;
                        }
                    }
                }
                if (aiVarD == null && aiVarD.n()) {
                    dVarC = com.google.android.libraries.geo.mapcore.internal.model.d.c(aiVarD.x);
                } else {
                    dVar2 = ekVar.o().e;
                    if (dVar2 == null) {
                        dVar2 = com.google.android.libraries.navigation.internal.adg.d.a;
                    }
                    if ((dVar2.b & 2) != 0) {
                        dVar3 = ekVar.o().e;
                        if (dVar3 == null) {
                            dVar3 = com.google.android.libraries.navigation.internal.adg.d.a;
                        }
                        bVarB = com.google.android.libraries.navigation.internal.adg.b.b(dVar3.d);
                        if (bVarB == null) {
                            bVarB = com.google.android.libraries.navigation.internal.adg.b.CENTER;
                        }
                        dVarC = com.google.android.libraries.geo.mapcore.internal.model.d.c(bVarB);
                    } else {
                        dVarC = com.google.android.libraries.geo.mapcore.internal.model.d.b;
                    }
                }
                com.google.android.libraries.geo.mapcore.internal.model.d dVar4 = dVarC;
                if (ekVar.I()) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.SDK_INFO_WINDOW;
                } else if (ekVar.ag()) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.BLUE_DOT_CALLOUT;
                } else if (ekVar.aj()) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.STARS;
                } else if (com.google.android.libraries.navigation.internal.rb.a.d(ekVar.o()).f213n) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.AR_MAPS_LABELS;
                } else {
                    xVarD = com.google.android.libraries.navigation.internal.rb.a.d(ekVar.o());
                    if (com.google.android.libraries.navigation.internal.adl.w.a(xVarD.c) == com.google.android.libraries.navigation.internal.adl.w.FRIEND_LABEL_METADATA) {
                        mVar = null;
                    } else if (xVarD.c == 4) {
                        mVar = (com.google.android.libraries.navigation.internal.adl.m) xVarD.d;
                    } else {
                        mVar = com.google.android.libraries.navigation.internal.adl.m.a;
                    }
                    if (mVar != null) {
                        if (mVar.b) {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.FRIEND_CLUSTER;
                        } else {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.FRIEND;
                        }
                    } else if (ekVar.aq()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.TRANSIT_VEHICLE;
                    } else if (ekVar.w()) {
                        if (ekVar.G()) {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.NAVIGATION_ADS;
                        } else {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.ADS;
                        }
                    } else if (ekVar.L()) {
                        if (ekVar.ao()) {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.SEARCH_RESULT_ICONS;
                        } else {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.SEARCH_RESULT_MEASLES;
                        }
                    } else if (ekVar.x()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.TRAFFIC_INCIDENTS;
                    } else if (ekVar.F()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.MY_MAPS_LABELS;
                    } else if (!ekVar.ak() || com.google.android.libraries.navigation.internal.rb.a.j(ekVar.o())) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.PLACEMARK_LABELS;
                    } else if (ekVar.ar()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.VISUAL_EXPLORE_CLUSTER;
                    } else {
                        afVar = ekVar.af() ? com.google.android.libraries.geo.mapcore.renderer.ck.BIKESHARING_VEHICLE : com.google.android.libraries.geo.mapcore.renderer.ci.LABELS;
                    }
                }
                com.google.android.libraries.geo.mapcore.renderer.af afVar2 = afVar;
                ax axVar = (ax) c();
                adVar = this.a;
                if (ekVar.ai()) {
                    com.google.android.libraries.navigation.internal.po.dh dhVar = (com.google.android.libraries.navigation.internal.po.dh) adVar;
                    bbVarR2 = dhVar.r(ekVar.o());
                    com.google.android.libraries.navigation.internal.adg.ef efVarN = ekVar.n();
                    if (bbVarR2 == null || efVarN == null) {
                        bbVarR = bbVarR2;
                    } else {
                        bbVarR = dhVar.r(efVarN);
                    }
                } else {
                    bbVarR = bbVarR2;
                }
                com.google.android.libraries.geo.mapcore.internal.model.c cVar = ((m) ekVar.h()).a;
                com.google.android.libraries.navigation.internal.yx.ar.q(cVar);
                axVar.c(ekVar, aiVarD, i2, cVar, arVarF2, dVar4, arVar, arVar2, auVarB, auVarB2, ekVar.ah(), ekVar.H(), afVar2, dVar, bbVarR, evVarD2, evVarD, z);
                return new bz(axVar);
            }
            com.google.android.libraries.navigation.internal.adg.dt dtVar4 = ekVar.o().d;
            if (dtVar4 == null) {
                dtVar4 = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            ar arVarF3 = ar.f(dtVar4, ekVar, i, evVarD2, resources, aVar, bVar, gVar, gVar2, dVar, z);
            if (arVarF3 != null) {
                if (arVarF3.o()) {
                    arVar = null;
                } else {
                    arVar = arVarF3;
                }
                asVarR = ekVar.r();
                if (asVarR == null) {
                    arVar2 = null;
                } else {
                    dtVar = asVarR.b;
                    if (dtVar == null) {
                        dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
                    }
                    arVarF = ar.f(dtVar, ekVar, i, evVarD, resources, aVar, bVar, gVar, gVar2, dVar, z);
                    if (arVarF != null) {
                        if (arVarF.o()) {
                            arVar2 = null;
                        } else {
                            arVar2 = arVarF;
                        }
                    }
                }
                if (aiVarD == null) {
                    dVar2 = ekVar.o().e;
                    if (dVar2 == null) {
                        dVar2 = com.google.android.libraries.navigation.internal.adg.d.a;
                    }
                    if ((dVar2.b & 2) != 0) {
                        dVar3 = ekVar.o().e;
                        if (dVar3 == null) {
                            dVar3 = com.google.android.libraries.navigation.internal.adg.d.a;
                        }
                        bVarB = com.google.android.libraries.navigation.internal.adg.b.b(dVar3.d);
                        if (bVarB == null) {
                            bVarB = com.google.android.libraries.navigation.internal.adg.b.CENTER;
                        }
                        dVarC = com.google.android.libraries.geo.mapcore.internal.model.d.c(bVarB);
                    } else {
                        dVarC = com.google.android.libraries.geo.mapcore.internal.model.d.b;
                    }
                } else {
                    dVar2 = ekVar.o().e;
                    if (dVar2 == null) {
                        dVar2 = com.google.android.libraries.navigation.internal.adg.d.a;
                    }
                    if ((dVar2.b & 2) != 0) {
                        dVar3 = ekVar.o().e;
                        if (dVar3 == null) {
                            dVar3 = com.google.android.libraries.navigation.internal.adg.d.a;
                        }
                        bVarB = com.google.android.libraries.navigation.internal.adg.b.b(dVar3.d);
                        if (bVarB == null) {
                            bVarB = com.google.android.libraries.navigation.internal.adg.b.CENTER;
                        }
                        dVarC = com.google.android.libraries.geo.mapcore.internal.model.d.c(bVarB);
                    } else {
                        dVarC = com.google.android.libraries.geo.mapcore.internal.model.d.b;
                    }
                }
                com.google.android.libraries.geo.mapcore.internal.model.d dVar5 = dVarC;
                if (ekVar.I()) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.SDK_INFO_WINDOW;
                } else if (ekVar.ag()) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.BLUE_DOT_CALLOUT;
                } else if (ekVar.aj()) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.STARS;
                } else if (com.google.android.libraries.navigation.internal.rb.a.d(ekVar.o()).f213n) {
                    afVar = com.google.android.libraries.geo.mapcore.renderer.ck.AR_MAPS_LABELS;
                } else {
                    xVarD = com.google.android.libraries.navigation.internal.rb.a.d(ekVar.o());
                    if (com.google.android.libraries.navigation.internal.adl.w.a(xVarD.c) == com.google.android.libraries.navigation.internal.adl.w.FRIEND_LABEL_METADATA) {
                        mVar = null;
                    } else if (xVarD.c == 4) {
                        mVar = (com.google.android.libraries.navigation.internal.adl.m) xVarD.d;
                    } else {
                        mVar = com.google.android.libraries.navigation.internal.adl.m.a;
                    }
                    if (mVar != null) {
                        if (mVar.b) {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.FRIEND_CLUSTER;
                        } else {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.FRIEND;
                        }
                    } else if (ekVar.aq()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.TRANSIT_VEHICLE;
                    } else if (ekVar.w()) {
                        if (ekVar.G()) {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.NAVIGATION_ADS;
                        } else {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.ADS;
                        }
                    } else if (ekVar.L()) {
                        if (ekVar.ao()) {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.SEARCH_RESULT_ICONS;
                        } else {
                            afVar = com.google.android.libraries.geo.mapcore.renderer.ck.SEARCH_RESULT_MEASLES;
                        }
                    } else if (ekVar.x()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.TRAFFIC_INCIDENTS;
                    } else if (ekVar.F()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.MY_MAPS_LABELS;
                    } else if (ekVar.ak()) {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.PLACEMARK_LABELS;
                    } else {
                        afVar = com.google.android.libraries.geo.mapcore.renderer.ck.PLACEMARK_LABELS;
                    }
                }
                com.google.android.libraries.geo.mapcore.renderer.af afVar3 = afVar;
                ax axVar2 = (ax) c();
                adVar = this.a;
                if (ekVar.ai()) {
                    bbVarR = bbVarR2;
                } else {
                    com.google.android.libraries.navigation.internal.po.dh dhVar2 = (com.google.android.libraries.navigation.internal.po.dh) adVar;
                    bbVarR2 = dhVar2.r(ekVar.o());
                    com.google.android.libraries.navigation.internal.adg.ef efVarN2 = ekVar.n();
                    if (bbVarR2 == null) {
                        bbVarR = bbVarR2;
                    } else {
                        bbVarR = bbVarR2;
                    }
                }
                com.google.android.libraries.geo.mapcore.internal.model.c cVar2 = ((m) ekVar.h()).a;
                com.google.android.libraries.navigation.internal.yx.ar.q(cVar2);
                axVar2.c(ekVar, aiVarD, i2, cVar2, arVarF2, dVar5, arVar, arVar2, auVarB, auVarB2, ekVar.ah(), ekVar.H(), afVar3, dVar, bbVarR, evVarD2, evVarD, z);
                return new bz(axVar2);
            }
        }
        return bz.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ak
    protected final /* synthetic */ al b() {
        return new ax();
    }
}
