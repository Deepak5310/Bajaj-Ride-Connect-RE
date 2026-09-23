package com.google.android.libraries.navigation.internal.qo;

import com.google.android.libraries.navigation.internal.abm.d;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public final Executor a;
    public final Set b = Collections.synchronizedSet(new HashSet());
    public final d c;

    public b(Executor executor, d dVar) {
        this.a = executor;
        this.c = dVar;
    }
}
