package com.google.android.libraries.navigation.internal.ti;

import com.google.android.libraries.navigation.internal.adr.Cdo;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.jg;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.tj.ag;
import com.google.android.libraries.navigation.internal.zs.cz;
import com.google.android.libraries.navigation.internal.zs.db;
import com.google.android.libraries.navigation.internal.zs.ec;
import com.google.android.libraries.navigation.internal.zs.ee;
import com.google.android.libraries.navigation.internal.zs.ef;
import com.google.maps.android.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ p a;

    public o(p pVar) {
        this.a = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        int i;
        Cdo cdoM;
        ap.NAVIGATION_INTERNAL.f();
        com.google.android.libraries.navigation.internal.tj.u uVar = (com.google.android.libraries.navigation.internal.tj.u) mVar.c();
        if (!this.a.g(com.google.android.libraries.navigation.internal.b.b.g(uVar == null ? BuildConfig.TRAVIS : uVar.getClass().getSimpleName(), "onShowPrompt(", ")")) || uVar == null) {
            return;
        }
        ec ecVar = (ec) ef.a.q();
        switch (uVar.j()) {
            case BETTER_ROUTE:
                i = ee.b;
                break;
            case ENROUTE_SEARCH_RESULT_UPGRADE:
                i = ee.t;
                break;
            case ENROUTE_SEARCH_RESULT_LIST:
                i = ee.E;
                break;
            case FREE_NAV_DESTINATION_EXPLICIT:
                i = ee.c;
                break;
            case FREE_NAV_DESTINATION_OPPORTUNISTIC:
                i = ee.d;
                break;
            case JRNY_PENDING:
                i = ee.f;
                break;
            case JRNY_PEOPLE_PICKER:
                i = ee.u;
                break;
            case JRNY_CONFIRMATION:
                i = ee.w;
                break;
            case NAVIGATION_AD:
                i = ee.g;
                break;
            case NAV_CORE_ARRIVAL:
                i = ee.y;
                break;
            case NAV_CORE_EXIT:
                i = ee.z;
                break;
            case NAVIGATION_POI:
                i = ee.h;
                break;
            case NAVIGATION_POPUP:
                i = ee.i;
                break;
            case OFFLINE_TO_ONLINE_TRANSITION:
                i = ee.k;
                break;
            case OPTIONS_CHANGE:
                i = ee.l;
                break;
            case REPORT_INCIDENT:
                i = ee.s;
                break;
            case SUGGEST_TRAVEL_MODE_CHANGE:
                i = ee.f676n;
                break;
            case TRAFFIC_INCIDENT:
                i = ee.o;
                break;
            case TRAFFIC_REPORT:
                i = ee.p;
                break;
            case WAYPOINT_ALERT:
                i = ee.q;
                break;
            case INCIDENT_CALLOUT:
                i = ee.v;
                break;
            case MODERATABLE_TRAFFIC_INCIDENT:
                i = ee.A;
                break;
            case CHEVRON_PICKER:
                i = ee.B;
                break;
            case SPEED_LIMIT_MODERATION:
                i = ee.C;
                break;
            case ASSISTANT_ROUTINE:
                i = ee.D;
                break;
            case ASSISTIVE_PICKUP_SHARING_CONFIRMATION:
                i = ee.F;
                break;
            case ASSISTIVE_PICKUP_SHARING_NAV_EXIT:
                i = ee.G;
                break;
            case REMOVE_WAYPOINT_OR_EXIT_NAVIGATION:
                i = ee.H;
                break;
            case ASSISTIVE_PICKUP_SHARING_NOTICE:
                i = ee.I;
                break;
            case BETTER_TRIP_PLAN:
                i = ee.J;
                break;
            case THERMAL_NIGHT_MODE:
                i = ee.K;
                break;
            case MAPS_SUGGESTS_CHARGING_WHEN_BATTERY_IS_LOW:
                i = ee.L;
                break;
            case HOV_ROUTE_SUGGESTION:
                i = ee.M;
                break;
            case NAVATARS_SAFETY_ALERT:
                i = ee.N;
                break;
            default:
                i = ee.a;
                break;
        }
        if (!ecVar.b.H()) {
            ecVar.v();
        }
        ef efVar = (ef) ecVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        efVar.c = i2;
        efVar.b |= 1;
        if (uVar instanceof ag) {
            jg jgVar = ((ag) uVar).a;
            if ((jgVar.b & 32) != 0) {
                el elVar = jgVar.i;
                if (elVar == null) {
                    elVar = el.a;
                }
                el.a aVarB = el.a.b(elVar.f);
                if (aVarB == null) {
                    aVarB = el.a.INFORMATION;
                }
                if (!ecVar.b.H()) {
                    ecVar.v();
                }
                ef efVar2 = (ef) ecVar.b;
                efVar2.d = aVarB.e;
                efVar2.b |= 2;
                fp fpVarB = fp.b(elVar.g);
                if (fpVarB == null) {
                    fpVarB = fp.UNKNOWN;
                }
                if (!ecVar.b.H()) {
                    ecVar.v();
                }
                ef efVar3 = (ef) ecVar.b;
                efVar3.e = fpVarB.L;
                efVar3.b |= 4;
            }
        } else if ((uVar instanceof com.google.android.libraries.navigation.internal.tj.ab) && (cdoM = ((com.google.android.libraries.navigation.internal.tj.ab) uVar).c.m()) != null) {
            if (!ecVar.b.H()) {
                ecVar.v();
            }
            ef efVar4 = (ef) ecVar.b;
            efVar4.f = cdoM.C;
            efVar4.b |= 8;
        }
        cz czVar = (cz) db.a.q();
        if (!czVar.b.H()) {
            czVar.v();
        }
        db dbVar = (db) czVar.b;
        ef efVar5 = (ef) ecVar.t();
        efVar5.getClass();
        dbVar.d = efVar5;
        dbVar.c = 16;
        this.a.h.c(czVar);
    }
}
