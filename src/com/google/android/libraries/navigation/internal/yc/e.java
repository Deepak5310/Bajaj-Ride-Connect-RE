package com.google.android.libraries.navigation.internal.yc;

import com.google.android.libraries.navigation.internal.yx.ah;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static final Pattern a = Pattern.compile("(\\w+).*");

    public static String a(List list) {
        if (list.isEmpty()) {
            return null;
        }
        return "transform=".concat(String.valueOf(new ah("+").f(list)));
    }
}
