package com.google.android.libraries.navigation.internal.wm;

import com.google.android.libraries.navigation.internal.ade.n;
import com.google.android.libraries.navigation.internal.bp.bg;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final Map a = new HashMap();
    private final Queue b = new ArrayDeque();

    public final com.google.android.libraries.navigation.internal.wl.c a(String str) {
        return (com.google.android.libraries.navigation.internal.wl.c) this.a.get(str);
    }

    public final void b(String str, bg bgVar, n nVar) {
        int size = this.b.size();
        for (int i = 0; i < size - 9; i++) {
            String str2 = (String) this.b.poll();
            if (str2 != null) {
                this.b.remove(str2);
            }
        }
        this.b.add(str);
        this.a.put(str, new com.google.android.libraries.navigation.internal.wl.a(bgVar, nVar));
    }
}
