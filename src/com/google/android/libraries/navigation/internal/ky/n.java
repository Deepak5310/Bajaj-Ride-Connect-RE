package com.google.android.libraries.navigation.internal.ky;

import com.google.android.libraries.navigation.internal.ael.cy;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends h {
    public final cy m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public av f478n;

    public n(o oVar, cy cyVar) {
        super(oVar);
        this.m = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.h
    public final /* bridge */ /* synthetic */ h b() {
        Iterator it2 = ((o) this.a).p.iterator();
        n nVarA = this;
        while (it2.hasNext()) {
            nVarA = ((m) it2.next()).a(nVarA);
        }
        Iterator it3 = o.o.iterator();
        while (it3.hasNext()) {
            nVarA = ((m) it3.next()).a(nVarA);
        }
        return nVarA;
    }

    @Override // com.google.android.libraries.navigation.internal.ky.h
    public final com.google.android.libraries.navigation.internal.me.w c() {
        if (this.c) {
            throw new IllegalStateException("do not reuse LogEventBuilder");
        }
        this.c = true;
        return ((o) this.a).g.a(this);
    }
}
