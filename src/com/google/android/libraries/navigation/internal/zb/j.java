package com.google.android.libraries.navigation.internal.zb;

import java.util.logging.Level;
import org.apache.commons.lang3.ClassUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends com.google.android.libraries.navigation.internal.zb.a {
    public static final a b = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: compiled from: PG */
    public final class a extends k<h> implements h {
    }

    public j(com.google.android.libraries.navigation.internal.zd.j jVar) {
        super(jVar);
    }

    @Deprecated
    public static j e(String str) {
        com.google.android.libraries.navigation.internal.zj.b.a(!str.isEmpty(), "injected class name is empty");
        return new j(com.google.android.libraries.navigation.internal.zd.ah.d(str.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR)));
    }

    public final h d(Level level) {
        boolean zC = c(level);
        com.google.android.libraries.navigation.internal.zd.ah.n(a(), level, zC);
        return !zC ? b : new i(this, level);
    }
}
