package com.google.android.libraries.navigation.internal.jb;

import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g {
    private static final Pattern a = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)([^\\+]*)?(?:\\+.*)?$");

    public static g g(String str) {
        Matcher matcher = a.matcher(str);
        ar.o(matcher.matches(), "Wrong format of version string: %s. Expected the string contains at least three number parts '<major>.<minor>.<point>' with optional '<suffix>' part. Presence of '+<metadata>' is allowed but ignored.", str);
        int i = Integer.parseInt(aq.b(matcher.group(1)));
        int i2 = Integer.parseInt(aq.b(matcher.group(2)));
        int i3 = Integer.parseInt(aq.b(matcher.group(3)));
        String strB = aq.b(matcher.group(4));
        com.google.android.libraries.navigation.internal.jc.a aVar = new com.google.android.libraries.navigation.internal.jc.a(i, i2, i3);
        return new a(i, i2, i3, strB, aVar, aq.c(strB) ? aVar.toString() : aVar.toString().concat(strB));
    }

    public abstract int a();

    public abstract int b();

    public abstract int c();

    public abstract com.google.android.libraries.navigation.internal.jc.b d();

    public abstract String e();

    public abstract String f();
}
