package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@FunctionalInterface
public interface dt extends Comparator {
    int a(int i, int i2);

    @Deprecated
    int b(Integer num, Integer num2);

    dt c();

    dt d(dt dtVar);
}
