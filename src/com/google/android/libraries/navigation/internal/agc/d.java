package com.google.android.libraries.navigation.internal.agc;

import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface d extends Function {
    boolean containsKey(Object obj);

    Object get(Object obj);

    int size();
}
