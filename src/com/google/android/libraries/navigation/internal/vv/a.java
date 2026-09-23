package com.google.android.libraries.navigation.internal.vv;

import android.content.Context;
import com.google.android.libraries.navigation.internal.bp.af;
import com.google.android.libraries.navigation.internal.bp.ai;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.ck;
import com.google.android.libraries.navigation.internal.oe.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final a a;
    public final bh b;
    public final ev c;
    public final ai d;
    public final bg e;

    static {
        bh bhVar = bh.b;
        int i = ev.d;
        a = new a(bhVar, lv.a, null, null);
    }

    private a(bh bhVar, ev evVar, ai aiVar, bg bgVar) {
        this.c = evVar;
        this.d = aiVar;
        this.e = bgVar;
        this.b = bhVar;
    }

    public static a b(ai aiVar, Context context) {
        af afVar = aiVar.b;
        int iA = afVar.a();
        if (iA < 0) {
            iA = afVar.b();
        }
        bg bgVarA = aiVar.a(iA, context);
        ar.q(bgVarA);
        bh bhVarH = bh.h(iA, aiVar.d(context));
        ev evVarO = ev.o(bgVarA.A());
        ar.a(!evVarO.isEmpty());
        ar.b(evVarO.size() == bgVarA.g.b(), "Number of Waypoints given is not equal to the number of trips in directionsStorage");
        return new a(bhVarH, evVarO, aiVar, bgVarA);
    }

    public static List c(an anVar) {
        int iA = anVar.a();
        ArrayList arrayList = new ArrayList(iA);
        for (int i = 0; i < iA; i++) {
            arrayList.add(anVar.b(i).t());
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ck a() {
        return (ck) this.c.get(0);
    }

    public final boolean d() {
        return !this.c.isEmpty();
    }
}
