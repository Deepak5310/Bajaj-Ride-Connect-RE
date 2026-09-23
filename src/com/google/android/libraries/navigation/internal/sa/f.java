package com.google.android.libraries.navigation.internal.sa;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class f {
    public static e b() {
        a aVar = new a();
        int i = ev.d;
        ev evVar = lv.a;
        Objects.requireNonNull(evVar);
        if (aVar.a != null) {
            throw new IllegalStateException();
        }
        aVar.b = evVar;
        return aVar;
    }

    public abstract ev a();
}
