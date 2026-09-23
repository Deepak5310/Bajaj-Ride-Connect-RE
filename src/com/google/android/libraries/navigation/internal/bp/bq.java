package com.google.android.libraries.navigation.internal.bp;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import com.google.android.libraries.navigation.internal.adr.Cif;
import com.google.android.libraries.navigation.internal.adr.dh;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.en;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.time.Duration;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bq {
    public static final /* synthetic */ int O = 0;
    private static final int P = com.google.android.libraries.navigation.internal.adr.bg.values().length;
    public final List A;
    public final List B;
    public final List C;
    public final com.google.android.libraries.navigation.internal.adq.h D;
    public final en E;
    public final String F;
    public final String G;
    public final String H;
    public final List I;
    public final boolean J;
    public final ev K;
    public final String L;
    public bq M;
    public bq N;
    private final float Q;
    private final List R;
    private final List S;
    private final ev T;
    private final boolean U;
    public final Cif a;
    public final bt b;
    public final com.google.android.libraries.navigation.internal.oe.x c;
    public final com.google.android.libraries.navigation.internal.aap.l d;
    public final hs e;
    public final hu f;
    public final int g;
    public final int h;
    public final int i;
    public final String j;
    public final int k;
    public int l;
    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Duration f355n;
    public final float o;
    public final Spanned p;
    public final String q;
    public final boolean r;
    public final CharSequence s;
    public final boolean t;
    public final bs u;
    public final bs v;
    public final List w;
    public final List x;
    public final List y;
    public final List z;

    public bq(bp bpVar) {
        int i;
        com.google.android.libraries.navigation.internal.aap.l lVar = bpVar.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(lVar);
        this.d = lVar;
        hs hsVar = bpVar.b;
        com.google.android.libraries.navigation.internal.yx.ar.q(hsVar);
        this.e = hsVar;
        hu huVar = bpVar.c;
        com.google.android.libraries.navigation.internal.yx.ar.q(huVar);
        this.f = huVar;
        this.g = bpVar.d;
        this.h = bpVar.e;
        com.google.android.libraries.navigation.internal.oe.x xVar = bpVar.f;
        com.google.android.libraries.navigation.internal.yx.ar.q(xVar);
        this.c = xVar;
        this.i = bpVar.g;
        this.k = bpVar.h;
        String str = bpVar.i;
        com.google.android.libraries.navigation.internal.yx.ar.q(str);
        this.j = str;
        this.s = bpVar.j;
        this.t = bpVar.k;
        this.l = bpVar.l;
        this.m = bpVar.m;
        this.f355n = bpVar.f354n;
        this.o = bpVar.o;
        this.Q = bpVar.p;
        List list = bpVar.q;
        com.google.android.libraries.navigation.internal.yx.ar.q(list);
        this.R = list;
        List list2 = bpVar.r;
        com.google.android.libraries.navigation.internal.yx.ar.q(list2);
        this.z = list2;
        List list3 = bpVar.s;
        com.google.android.libraries.navigation.internal.yx.ar.q(list3);
        this.A = list3;
        List list4 = bpVar.t;
        com.google.android.libraries.navigation.internal.yx.ar.q(list4);
        this.B = list4;
        List list5 = bpVar.u;
        com.google.android.libraries.navigation.internal.yx.ar.q(list5);
        this.C = list5;
        this.a = bpVar.w;
        this.b = bpVar.x;
        this.D = bpVar.y;
        this.G = bpVar.A;
        this.H = bpVar.B;
        this.F = bpVar.z;
        this.E = bpVar.v;
        this.r = bpVar.D;
        List list6 = bpVar.E;
        com.google.android.libraries.navigation.internal.yx.ar.q(list6);
        this.I = list6;
        ev evVar = bpVar.F;
        com.google.android.libraries.navigation.internal.yx.ar.q(evVar);
        this.T = evVar;
        this.J = bpVar.G;
        this.K = bpVar.H;
        this.U = bpVar.I;
        this.L = bpVar.J;
        this.M = bpVar.K;
        Iterator it2 = list3.iterator();
        while (true) {
            boolean z = true;
            if (!it2.hasNext()) {
                break;
            }
            bw bwVar = (bw) it2.next();
            if (bwVar.h != null) {
                z = false;
            }
            com.google.android.libraries.navigation.internal.yx.ar.l(z, "Attempted to reassign Step for existing StepGuidance");
            bwVar.h = this;
        }
        this.w = new ArrayList();
        this.x = new ArrayList();
        this.S = new ArrayList();
        this.y = new ArrayList();
        List list7 = this.R;
        int i2 = P;
        bs[][] bsVarArr = new bs[i2][];
        int[] iArr = new int[i2];
        int size = list7.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = ((bs) list7.get(i3)).d().o;
            iArr[i4] = iArr[i4] + 1;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = iArr[i5];
            if (i6 > 0) {
                bsVarArr[i5] = new bs[i6];
            }
        }
        for (bs bsVar : hx.g(list7)) {
            int i7 = bsVar.d().o;
            bs[] bsVarArr2 = bsVarArr[i7];
            int i8 = iArr[i7] - 1;
            iArr[i7] = i8;
            bsVarArr2[i8] = bsVar;
        }
        for (int i9 = 0; i9 < i2; i9++) {
            com.google.android.libraries.navigation.internal.yx.ar.k(iArr[i9] == 0);
        }
        if (this.d != com.google.android.libraries.navigation.internal.aap.l.UTURN) {
            g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TO_ROAD_NAME, this.w);
        } else {
            g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_AT_ROAD_NAME, this.w);
            g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TO_ROAD_NAME, this.x);
        }
        g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TOWARD_NAME, this.x);
        g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TOWARD_ROAD_NAME, this.x);
        g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_FOLLOW_ROAD_NAME, this.S);
        g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_INTERSECTION, this.y);
        if (this.d == com.google.android.libraries.navigation.internal.aap.l.DESTINATION) {
            bs bsVarF = f(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TITLE);
            if (bsVarF != null) {
                this.w.add(bsVarF);
            }
            g(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_ADDRESS, this.x);
        }
        this.u = f(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_EXIT_NUMBER);
        this.v = f(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_EXIT_NAME);
        f(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TRANSIT_SIGNPOST);
        f(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TRANSIT_ENTRANCE_NAME);
        f(bsVarArr, com.google.android.libraries.navigation.internal.adr.bg.TYPE_TRANSIT_EXIT_NAME);
        String str2 = this.j;
        List list8 = this.R;
        SpannableString spannableString = new SpannableString(str2);
        if (!Bidi.requiresBidi(str2.toCharArray(), 0, str2.length())) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list8);
            Collections.sort(arrayList, new Comparator() { // from class: com.google.android.libraries.navigation.internal.bp.bo
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int i10 = bq.O;
                    return ((bs) obj2).g().length() - ((bs) obj).g().length();
                }
            });
            int size2 = arrayList.size();
            for (int i10 = 0; i10 < size2; i10++) {
                bs bsVar2 = (bs) arrayList.get(i10);
                String strG = bsVar2.g();
                if (strG.length() != 0) {
                    int iIndexOf = -1;
                    do {
                        iIndexOf = str2.indexOf(strG, iIndexOf + 1);
                        if (iIndexOf < 0) {
                            break;
                        }
                    } while (spannableString.getSpans(iIndexOf, strG.length() + iIndexOf, Object.class).length != 0);
                    if (iIndexOf >= 0) {
                        spannableString.setSpan(bsVar2, iIndexOf, strG.length() + iIndexOf, 33);
                    }
                }
            }
        }
        this.p = spannableString;
        String string = bpVar.C;
        if (string == null) {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spannableString);
            for (Object obj : spannableStringBuilder.getSpans(0, spannableString.length(), bs.class)) {
                bs bsVar3 = (bs) obj;
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(bsVar3), spannableStringBuilder.getSpanEnd(bsVar3), (CharSequence) ((bsVar3.a().b & 32) != 0 ? bsVar3.a().e : bsVar3.g()));
            }
            string = spannableStringBuilder.toString();
        }
        this.q = string;
    }

    private static bs f(bs[][] bsVarArr, com.google.android.libraries.navigation.internal.adr.bg bgVar) {
        bs[] bsVarArr2 = bsVarArr[bgVar.o];
        if (bsVarArr2 == null || bsVarArr2.length <= 0) {
            return null;
        }
        return bsVarArr2[0];
    }

    private static void g(bs[][] bsVarArr, com.google.android.libraries.navigation.internal.adr.bg bgVar, List list) {
        bs[] bsVarArr2 = bsVarArr[bgVar.o];
        if (bsVarArr2 != null) {
            for (bs bsVar : bsVarArr2) {
                com.google.android.libraries.navigation.internal.yx.ar.q(bsVar);
                list.add(bsVar);
            }
        }
    }

    public final bp a() {
        bp bpVar = new bp();
        bpVar.a = this.d;
        bpVar.b = this.e;
        bpVar.c = this.f;
        bpVar.d = this.g;
        bpVar.e = this.h;
        bpVar.f = this.c;
        bpVar.g = this.i;
        bpVar.h = this.k;
        bpVar.i = this.j;
        bpVar.j = this.s;
        bpVar.k = this.t;
        bpVar.l = this.l;
        bpVar.f354n = this.f355n;
        bpVar.o = this.o;
        bpVar.p = this.Q;
        bpVar.q = this.R;
        bpVar.r = this.z;
        bpVar.t = this.B;
        bpVar.w = this.a;
        bpVar.x = this.b;
        bpVar.y = this.D;
        bpVar.z = this.F;
        bpVar.A = this.G;
        bpVar.B = this.H;
        bpVar.C = this.q;
        bpVar.D = this.r;
        bpVar.v = this.E;
        bpVar.E = new ArrayList(this.I);
        bpVar.F = this.T;
        bpVar.G = this.J;
        bpVar.H = this.K;
        bpVar.I = this.U;
        bpVar.J = this.L;
        bpVar.K = this.M;
        eq eqVar = new eq();
        for (bw bwVar : this.A) {
            bv bvVar = new bv();
            bvVar.a = bwVar.a;
            bvVar.b = bwVar.b;
            bvVar.c = bwVar.c;
            bvVar.d = bwVar.d;
            bvVar.e = bwVar.e;
            bvVar.f = bwVar.f;
            bvVar.g = bwVar.g;
            bvVar.h = bwVar.h;
            Iterator it2 = bwVar.i.iterator();
            while (it2.hasNext()) {
                bvVar.a((com.google.android.libraries.navigation.internal.yx.br) it2.next());
            }
            bvVar.h = null;
            eqVar.h(new bw(bvVar));
        }
        bpVar.s = eqVar.g();
        return bpVar;
    }

    public final bs b() {
        Iterator it2 = (this.S.isEmpty() ? this.w : this.S).iterator();
        if (it2.hasNext()) {
            return (bs) it2.next();
        }
        return null;
    }

    public final bw c() {
        for (bw bwVar : this.A) {
            if (bwVar.a == dh.ACT) {
                return bwVar;
            }
        }
        return null;
    }

    public final bw d() {
        for (bw bwVar : this.A) {
            if (bwVar.a == dh.PREPARE) {
                return bwVar;
            }
        }
        return null;
    }

    public final boolean e() {
        return this.u != null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it2 = this.z.iterator();
        while (it2.hasNext()) {
            sb.append(((el) it2.next()).h);
            sb.append(",");
        }
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.h();
        akVarB.g(FirebaseAnalytics.Param.LOCATION, this.c.E());
        akVarB.g("maneuverType", this.d);
        akVarB.g("turnSide", this.e);
        com.google.android.libraries.navigation.internal.yx.ak akVarC = akVarB.c("roundaboutTurnAngle", this.g).c("stepNumber", this.i).c("polylineVertexOffset", this.k).c("distanceFromPrevStepMeters", this.l);
        akVarC.g("timeFromPrevStep", this.f355n);
        com.google.android.libraries.navigation.internal.yx.ak akVarB2 = akVarC.b("incomingBearing", this.o).b("outgoingBearing", this.Q);
        akVarB2.g("text", this.p);
        akVarB2.g("secondaryText", this.s);
        akVarB2.g("exitNumber", this.u);
        akVarB2.g("exitName", this.v);
        akVarB2.g("directCues", this.w);
        akVarB2.g("indirectCues", this.x.isEmpty() ? null : this.x);
        akVarB2.g("followCues", this.S.isEmpty() ? null : this.S);
        akVarB2.g("intersectionCues", this.y.isEmpty() ? null : this.y);
        akVarB2.g("notices", this.z.isEmpty() ? null : sb.toString());
        akVarB2.g("stepGuidances", this.A);
        akVarB2.g(FirebaseAnalytics.Param.LEVEL, this.D);
        akVarB2.g("stepIconId", this.G);
        akVarB2.g("stepIconDescription", this.H);
        akVarB2.g("ved", this.F);
        akVarB2.g("laneGuidances", this.B.isEmpty() ? null : this.B);
        akVarB2.g("navigationPopups", this.C.isEmpty() ? null : this.C);
        String str = this.q;
        akVarB2.g("spokenText", true != str.isEmpty() ? str : null);
        com.google.android.libraries.navigation.internal.yx.ak akVarE = akVarB2.e("namesValidForEntireStep", this.r);
        akVarE.g("drivingSide", this.E);
        com.google.android.libraries.navigation.internal.yx.ak akVarE2 = akVarE.e("isSyntheticPolyline", this.J);
        akVarE2.g("stepId", this.L);
        akVarE2.g("speedLimitChanges", this.I);
        akVarE2.g("summary", this.a);
        return akVarE2.toString();
    }
}
