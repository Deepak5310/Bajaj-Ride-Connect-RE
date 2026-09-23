package com.google.android.libraries.navigation.internal.gm;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class am {
    public com.google.android.libraries.navigation.internal.gh.b a;
    private final Map b = new HashMap();

    public final com.google.android.libraries.navigation.internal.gh.b a(String str) {
        return (com.google.android.libraries.navigation.internal.gh.b) this.b.get(str);
    }

    public final void b(com.google.android.libraries.navigation.internal.gh.b bVar) {
        this.b.put(bVar.b(), bVar);
    }
}
