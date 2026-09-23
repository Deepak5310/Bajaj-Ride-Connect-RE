package com.google.android.libraries.navigation.internal.zx;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m {
    public static Collection a(Collection collection) {
        ArrayList arrayListB = hx.b(collection);
        int size = arrayListB.size();
        for (int i = 0; i < size; i++) {
            ar.r(arrayListB.get(i), "this list cannot contain null");
        }
        return arrayListB;
    }
}
