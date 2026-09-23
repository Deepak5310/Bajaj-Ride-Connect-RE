package com.mappls.sdk.navigation;

import android.content.Context;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes4.dex */
public abstract class q {
    private static ArrayList b = new ArrayList();
    private boolean a;

    public static q a() {
        for (q qVar : b()) {
            if (com.mappls.sdk.navigation.tracks.a.class.isInstance(qVar)) {
                return qVar;
            }
        }
        return null;
    }

    public static ArrayList b() {
        ArrayList arrayList = new ArrayList(b.size());
        for (q qVar : b) {
            if (qVar.a) {
                arrayList.add(qVar);
            }
        }
        return arrayList;
    }

    public abstract void c();

    public void d() {
    }

    public static void a(Context context) {
        LinkedHashSet linkedHashSetG = NavigationContext.getNavigationContext().k().g();
        b.add(new com.mappls.sdk.navigation.tracks.a(context));
        linkedHashSetG.add("navigation.monitoring");
        for (q qVar : b) {
            qVar.c();
            if (linkedHashSetG.contains("navigation.monitoring") || qVar.a) {
                try {
                    qVar.a = true;
                } catch (Exception e) {
                    qVar.c();
                    NavigationLogger.e(e, "Plugin initialization failed %s", "navigation.monitoring");
                }
            }
        }
    }
}
