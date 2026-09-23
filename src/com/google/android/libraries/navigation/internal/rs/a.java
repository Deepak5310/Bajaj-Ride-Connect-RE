package com.google.android.libraries.navigation.internal.rs;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static int a(int i, List list) {
        int iBinarySearch = Collections.binarySearch(list, Integer.valueOf(i));
        return iBinarySearch < 0 ? Math.abs(iBinarySearch + 1) - 1 : iBinarySearch;
    }
}
