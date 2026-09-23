package com.google.android.libraries.navigation.internal.ch;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    @JvmStatic
    public static final String a(List items) {
        Intrinsics.checkNotNullParameter(items, "items");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = items.iterator();
        while (it2.hasNext()) {
            Object next = it2.next();
            String string = next != null ? next.toString() : null;
            if (string != null && !StringsKt.isBlank(string)) {
                arrayList.add(next);
            }
        }
        String strJoin = TextUtils.join(", ", arrayList);
        Intrinsics.checkNotNullExpressionValue(strJoin, "join(...)");
        return strJoin;
    }

    @JvmStatic
    public static final String b(Object... items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return a(ArraysKt.toList(items));
    }
}
