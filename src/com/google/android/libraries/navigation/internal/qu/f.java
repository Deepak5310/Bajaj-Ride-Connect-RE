package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.geo.mapcore.internal.model.ck;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f implements Runnable {
    final /* synthetic */ com.google.android.libraries.geo.mapcore.internal.model.cd a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.qv.i b;
    final /* synthetic */ byte[] c;
    final /* synthetic */ h d;

    public f(h hVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar, byte[] bArr) {
        this.a = cdVar;
        this.b = iVar;
        this.c = bArr;
        this.d = hVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [com.google.android.libraries.geo.mapcore.internal.model.cc, java.lang.Object] */
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
    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.yx.an anVarJ;
        k kVar = this.d.c;
        com.google.android.libraries.geo.mapcore.internal.model.cd cdVar = this.a;
        com.google.android.libraries.navigation.internal.qv.i iVar = this.b;
        byte[] bArr = this.c;
        if (bArr.length == 0) {
            anVarJ = com.google.android.libraries.navigation.internal.yx.an.j(new com.google.android.libraries.geo.mapcore.internal.model.t((com.google.android.libraries.navigation.internal.dm.s) kVar.b(cdVar).t(), k.b, cdVar, com.google.android.libraries.navigation.internal.oe.as.UNKNOWN));
        } else {
            com.google.android.libraries.geo.mapcore.internal.model.q qVar = (com.google.android.libraries.geo.mapcore.internal.model.q) kVar.h.a((com.google.android.libraries.navigation.internal.dm.s) kVar.b(cdVar).t(), k.b, cdVar, bArr, com.google.android.libraries.navigation.internal.oe.as.NETWORK);
            if (qVar.a == ck.IO_ERROR) {
                kVar.f(cdVar, iVar, com.google.android.libraries.navigation.internal.qv.h.IO_ERROR, null);
                kVar.f.a(cdVar);
                RuntimeException runtimeException = new RuntimeException("I/O error unpacking tile");
                runtimeException.fillInStackTrace();
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) k.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(runtimeException)).F((char) 1126)).o();
            }
            if (!qVar.b.g()) {
                k.b.name();
            }
            anVarJ = qVar.b;
        }
        if (anVarJ.g()) {
            ?? C = anVarJ.c();
            kVar.d.e(cdVar, C);
            kVar.f.b(cdVar);
            kVar.f(cdVar, iVar, com.google.android.libraries.navigation.internal.qv.h.OK, C);
        }
    }
}
