package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface bm extends ExecutorService {
    bj c(Runnable runnable);

    bj d(Callable callable);
}
