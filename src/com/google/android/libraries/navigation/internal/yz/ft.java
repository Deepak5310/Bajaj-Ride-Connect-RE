package com.google.android.libraries.navigation.internal.yz;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ft {
    public final List a = new ArrayList();

    public final void a(lr lrVar) {
        com.google.android.libraries.navigation.internal.yx.ar.f(!lrVar.i(), "range must not be empty, but was %s", lrVar);
        this.a.add(lrVar);
    }
}
