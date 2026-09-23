package com.google.android.libraries.navigation.internal.bp;

import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aa {
    public static final void a(ac acVar, ArrayList arrayList) {
        if (acVar instanceof z) {
            Collections.addAll(arrayList, ((z) acVar).a);
        } else {
            arrayList.add(acVar);
        }
    }
}
