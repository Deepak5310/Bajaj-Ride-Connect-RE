package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.geo.mapcore.internal.model.ay;
import com.google.android.libraries.geo.mapcore.internal.model.br;
import com.google.android.libraries.geo.mapcore.internal.model.cc;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cp;
import com.google.android.libraries.geo.mapcore.internal.model.cq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.google.android.libraries.navigation.internal.qv.i {
    private final f a;

    public i(f fVar) {
        this.a = fVar;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.libraries.navigation.internal.qv.i
    public final void a(cd cdVar, com.google.android.libraries.navigation.internal.qv.h hVar, cc ccVar) {
        int i = hVar.j;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 != 0) {
            if (i2 == 1) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.E(TimeUnit.SECONDS)).F(916)).s("IO error for %s", cdVar);
                this.a.a(cdVar, 1, null);
                return;
            } else if (i2 != 3) {
                this.a.a(cdVar, 1, null);
                return;
            } else {
                this.a.a(cdVar, 2, null);
                return;
            }
        }
        if (ccVar == null || !(ccVar instanceof cq)) {
            this.a.a(cdVar, 1, null);
            return;
        }
        int i3 = ev.d;
        List arrayList = lv.a;
        cp cpVarK = ((cq) ccVar).k();
        while (cpVarK.hasNext()) {
            br next = cpVarK.next();
            if (next.a() == 3) {
                com.google.android.libraries.geo.mapcore.internal.model.g gVar = (com.google.android.libraries.geo.mapcore.internal.model.g) next;
                com.google.android.libraries.navigation.internal.pt.b bVar = !ay.f(gVar.i, 8) ? null : new com.google.android.libraries.navigation.internal.pt.b(gVar.f66n, gVar.g);
                if (bVar != null) {
                    if (arrayList.isEmpty()) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(bVar);
                }
            }
        }
        arrayList.size();
        this.a.a(cdVar, 0, arrayList);
    }
}
