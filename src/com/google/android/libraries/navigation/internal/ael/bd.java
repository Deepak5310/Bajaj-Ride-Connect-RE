package com.google.android.libraries.navigation.internal.ael;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bd extends bb implements bf {
    protected bd(be beVar) {
        super(beVar);
    }

    private final av c() {
        av avVar = ((be) this.b).w;
        if (!avVar.c) {
            return avVar;
        }
        av avVarC = avVar.clone();
        ((be) this.b).w = avVarC;
        return avVarC;
    }

    private final void d(bh bhVar) {
        if (bhVar.a != this.a) {
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public final void A(ap apVar, Object obj) {
        bh bhVarS = bi.s(apVar);
        d(bhVarS);
        if (!this.b.H()) {
            v();
        }
        c().l(bhVarS.d, bhVarS.e(obj));
    }

    public final void B(ap apVar) {
        bh bhVarS = bi.s(apVar);
        d(bhVarS);
        if (!this.b.H()) {
            v();
        }
        av avVarC = c();
        avVarC.b.remove(bhVarS.d);
        if (avVarC.b.isEmpty()) {
            avVarC.d = false;
        }
    }

    public final void C(ap apVar, Object obj) {
        bh bhVarS = bi.s(apVar);
        d(bhVarS);
        if (!this.b.H()) {
            v();
        }
        av avVarC = c();
        bg bgVar = bhVarS.d;
        if (!bgVar.d) {
            obj = bhVarS.e(obj);
        } else if (bgVar.c() == et.ENUM) {
            ArrayList arrayList = new ArrayList();
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                arrayList.add(bhVarS.e(it2.next()));
            }
            obj = arrayList;
        }
        avVarC.m(bgVar, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bb, com.google.android.libraries.navigation.internal.ael.cx
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public final be u() {
        if (!((be) this.b).H()) {
            return (be) this.b;
        }
        ((be) this.b).w.e();
        return (be) super.u();
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bb
    public final void v() {
        super.v();
        if (((be) this.b).w != av.a) {
            be beVar = (be) this.b;
            beVar.w = beVar.w.clone();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bf
    public final Object y(ap apVar) {
        be beVar = (be) this.b;
        bh bhVarS = bi.s(apVar);
        beVar.h(bhVarS);
        Object objK = beVar.w.k(bhVarS.d);
        return objK == null ? bhVarS.b : bhVarS.c(objK);
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bf
    public final boolean z(ap apVar) {
        be beVar = (be) this.b;
        bh bhVarS = bi.s(apVar);
        beVar.h(bhVarS);
        return beVar.w.n(bhVarS.d);
    }
}
