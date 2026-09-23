package com.google.android.libraries.navigation.internal.gm;

import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as implements com.google.android.libraries.navigation.internal.gh.e {
    private static final com.google.android.libraries.navigation.internal.gh.b a = new com.google.android.libraries.navigation.internal.gh.a("ZwiebackCookieRequirementSatisfied", Boolean.TRUE.toString());
    private static final com.google.android.libraries.navigation.internal.gh.b b = new com.google.android.libraries.navigation.internal.gh.a("ZwiebackCookieRequirementSatisfied", Boolean.FALSE.toString());
    private final com.google.android.libraries.navigation.internal.il.a d;
    private final List c = new ArrayList();
    private final AtomicBoolean e = new AtomicBoolean(false);
    private final AtomicInteger f = new AtomicInteger(0);

    public as(com.google.android.libraries.navigation.internal.il.a aVar) {
        this.d = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gh.e
    public final synchronized bj a() {
        ca caVar;
        caVar = new ca();
        com.google.android.libraries.navigation.internal.gh.b bVarB = b();
        if (Boolean.parseBoolean((String) ((com.google.android.libraries.navigation.internal.gh.a) bVarB).a)) {
            this.f.incrementAndGet();
            caVar.d(bVarB);
        } else {
            this.c.add(caVar);
        }
        return caVar;
    }

    public final synchronized com.google.android.libraries.navigation.internal.gh.b b() {
        if (!this.e.getAndSet(true)) {
            this.d.c();
        }
        if (!this.d.e() && this.f.get() != 0) {
            return b;
        }
        return a;
    }

    public final synchronized void c() {
        this.f.decrementAndGet();
        if (this.d.e()) {
            Iterator it2 = this.c.iterator();
            while (it2.hasNext()) {
                ((ca) it2.next()).d(a);
                this.f.incrementAndGet();
            }
            this.c.clear();
            return;
        }
        if (this.c.isEmpty()) {
            return;
        }
        ((ca) this.c.get(0)).d(a);
        this.c.remove(0);
        this.f.incrementAndGet();
    }
}
