package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae implements w {
    public final Object a = new Object();
    public final Map b = new HashMap();
    public final ac c;
    private final o d;
    private final Runnable e;
    private final e f;

    public ae(com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, Executor executor, Runnable runnable) {
        o oVar = new o();
        this.d = oVar;
        this.f = null;
        this.e = runnable;
        this.c = new ac(aVar, executor, runnable != null, oVar, new br() { // from class: com.google.android.libraries.navigation.internal.qk.aa
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                ArrayList arrayList;
                ae aeVar = this.a;
                synchronized (aeVar.a) {
                    arrayList = new ArrayList(aeVar.b.values());
                }
                arrayList.sort(Comparator.comparing(new Function() { // from class: com.google.android.libraries.navigation.internal.qk.x
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return ((d) ((ad) obj).a).c;
                    }
                }).thenComparing(new Function() { // from class: com.google.android.libraries.navigation.internal.qk.y
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return Integer.valueOf(((d) ((ad) obj).a).d);
                    }
                }).thenComparingInt(new ToIntFunction() { // from class: com.google.android.libraries.navigation.internal.qk.z
                    @Override // java.util.function.ToIntFunction
                    public final int applyAsInt(Object obj) {
                        return System.identityHashCode((ad) obj);
                    }
                }));
                return ev.o(arrayList);
            }
        }, null, aVar2);
    }

    @Override // com.google.android.libraries.navigation.internal.qk.w
    public final void a(com.google.android.libraries.navigation.internal.op.g gVar) {
        synchronized (this.a) {
            ad adVar = (ad) this.b.remove(gVar);
            if (adVar != null) {
                ((d) adVar.a).a.b();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qk.w
    public final void b(v vVar) {
        com.google.android.libraries.navigation.internal.op.f fVar = ((d) vVar).a;
        synchronized (this.a) {
            this.b.putIfAbsent(fVar.a(), new ad(vVar));
        }
        Runnable runnable = this.e;
        if (runnable != null) {
            runnable.run();
        } else {
            this.c.b();
        }
    }
}
