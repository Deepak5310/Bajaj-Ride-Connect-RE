package com.google.android.libraries.navigation.internal.wt;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bm;
import com.google.android.libraries.navigation.internal.aac.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.wt.m");
    public final bm a;
    public final bj b;
    private final int d;
    private final int e;
    private final h f;
    private final c g = new c();
    private int h;

    public m(int i, int i2, h hVar, bm bmVar, bj bjVar) {
        this.d = i;
        this.e = i2;
        this.f = hVar;
        this.a = bmVar;
        this.b = bjVar;
    }

    private final synchronized k e(k kVar) {
        c cVar = this.g;
        cVar.a++;
        cVar.b++;
        final b bVar = new b(kVar);
        bVar.c = null;
        b bVar2 = cVar.c;
        bVar.b = bVar2;
        if (bVar2 != null) {
            bVar2.c = bVar;
        }
        cVar.c = bVar;
        if (cVar.d == null) {
            cVar.d = bVar;
        }
        f();
        if (!this.g.c(bVar)) {
            final ca caVar = kVar.c;
            caVar.l(new Runnable() { // from class: com.google.android.libraries.navigation.internal.wt.d
                @Override // java.lang.Runnable
                public final void run() {
                    if (caVar.isCancelled()) {
                        this.a.b(bVar);
                    }
                }
            }, this.a);
        }
        if (this.g.a <= this.e) {
            return null;
        }
        return (k) this.g.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.google.android.libraries.navigation.internal.aac.bm] */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.lang.Runnable] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
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
    private final void f() {
        int i;
        ?? A;
        while (this.b.isDone() && this.g.c != null && (i = this.h) < this.d) {
            this.h = i + 1;
            ?? r0 = this.a;
            int iOrdinal = this.f.ordinal();
            if (iOrdinal == 0) {
                c cVar = this.g;
                A = cVar.a(cVar.c);
            } else {
                if (iOrdinal != 1) {
                    throw new AssertionError(this.f);
                }
                A = this.g.b();
            }
            r0.execute(A);
        }
    }

    public final bj a(String str, l lVar) {
        k kVar = new k(this, str, new f(lVar), SystemClock.elapsedRealtime());
        k kVarE = e(kVar);
        if (kVarE != null) {
            kVarE.c.ap(new i());
        }
        return kVar.c;
    }

    public final synchronized void b(b bVar) {
        c cVar = this.g;
        if (cVar.c(bVar)) {
            return;
        }
        cVar.a(bVar);
    }

    public final synchronized void c() {
        this.h--;
        f();
    }

    public final synchronized void d() {
        f();
    }
}
