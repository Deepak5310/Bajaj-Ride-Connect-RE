package com.google.android.libraries.navigation.internal.xo;

import android.content.Context;
import android.database.ContentObserver;
import androidx.core.content.PermissionChecker;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements i {
    private static l b;
    public final Context a;
    private final ContentObserver c;

    private l() {
        this.a = null;
        this.c = null;
    }

    private l(Context context) {
        this.a = context;
        k kVar = new k();
        this.c = kVar;
        context.getContentResolver().registerContentObserver(com.google.android.libraries.navigation.internal.mh.d.a, true, kVar);
    }

    public static l b(Context context) {
        l lVar;
        synchronized (l.class) {
            if (b == null) {
                b = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new l(context) : new l();
            }
            lVar = b;
        }
        return lVar;
    }

    static synchronized void d() {
        Context context;
        l lVar = b;
        if (lVar != null && (context = lVar.a) != null && lVar.c != null) {
            context.getContentResolver().unregisterContentObserver(b.c);
        }
        b = null;
    }

    @Override // com.google.android.libraries.navigation.internal.xo.i
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final String a(final String str) {
        Context context = this.a;
        if (context != null && !com.google.android.libraries.navigation.internal.nd.a.b(context)) {
            try {
                return (String) g.a(new h() { // from class: com.google.android.libraries.navigation.internal.xo.j
                    @Override // com.google.android.libraries.navigation.internal.xo.h
                    public final Object a() {
                        return com.google.android.libraries.navigation.internal.mh.c.a.a(this.a.a.getContentResolver(), str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException unused) {
            }
        }
        return null;
    }
}
