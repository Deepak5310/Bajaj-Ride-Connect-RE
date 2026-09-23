package com.google.android.libraries.navigation.internal.hx;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static Executor a(Executor executor) {
        return executor instanceof b ? ((b) executor).o("<sequential>") : new ag(executor);
    }
}
