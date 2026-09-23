package com.google.android.libraries.navigation.internal.oe;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements e {
    static final ai a;
    private final List b = new ArrayList();
    private final ai c = a;

    static {
        x xVar = new x(Integer.MIN_VALUE, Integer.MIN_VALUE);
        a = new ai(xVar, xVar);
    }

    @Override // com.google.android.libraries.navigation.internal.oe.e
    public final ai a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.oe.e
    public final boolean b(aj ajVar) {
        if (this.c.b(ajVar)) {
            for (int i = 0; i < this.b.size(); i++) {
                if (((e) this.b.get(i)).b(ajVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
