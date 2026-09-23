package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.adg.hg;
import com.google.android.libraries.navigation.internal.agi.gi;
import com.google.android.libraries.navigation.internal.agi.ig;
import com.google.android.libraries.navigation.internal.agi.ik;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends nn {
    public int a = 0;
    private final gi b;
    private final Iterator c;

    public e(f fVar) {
        this.b = fVar.b.a.p().a();
        this.c = ((ev) fVar.a).iterator();
    }

    @Override // java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final hg next() {
        gi giVar = this.b;
        if (giVar.hasNext()) {
            ik next = ((ig) giVar).next();
            this.a = next.a();
            return (hg) next.getKey();
        }
        if (!this.c.hasNext()) {
            throw new IllegalStateException("Calling next() on an exhausted iterator");
        }
        this.a = 0;
        return (hg) this.c.next();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.b.hasNext() || this.c.hasNext();
    }
}
