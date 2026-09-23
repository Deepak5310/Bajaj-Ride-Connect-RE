package com.google.android.libraries.navigation.internal.ms;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cy {
    public static final Set a = Collections.newSetFromMap(new WeakHashMap());
    private static final com.google.android.libraries.navigation.internal.my.l b = new com.google.android.libraries.navigation.internal.my.l();

    @Deprecated
    public static int a(cs csVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(csVar);
        com.google.android.libraries.navigation.internal.yt.a aVarD = com.google.android.libraries.navigation.internal.yt.d.d("VPB.invalidate ", csVar);
        try {
            ArrayList<ck> arrayList = new ArrayList();
            d(csVar, new com.google.android.libraries.navigation.internal.my.c(arrayList));
            int i = 0;
            for (ck ckVar : arrayList) {
                if (ckVar.j == csVar) {
                    i++;
                    ckVar.m();
                }
            }
            au auVar = (au) b.a(csVar);
            if (auVar != null) {
                auVar.a();
            }
            aVarD.close();
            return i;
        } catch (Throwable th) {
            try {
                aVarD.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    @Deprecated
    public static View b(View view, cc ccVar, Class cls) {
        ck ckVarH = ck.h(view, new cj(ccVar));
        if (ckVarH == null) {
            return null;
        }
        View view2 = ckVarH.c;
        if (cls.isInstance(view2)) {
            return view2;
        }
        return null;
    }

    public static View c(cs csVar) {
        ArrayList arrayList = new ArrayList();
        d(csVar, new com.google.android.libraries.navigation.internal.my.c(arrayList));
        Iterator it2 = arrayList.iterator();
        bv bvVar = !it2.hasNext() ? null : (bv) it2.next();
        if (bvVar == null) {
            return null;
        }
        return bvVar.c;
    }

    static void d(cs csVar, com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        Iterator it2 = a.iterator();
        while (it2.hasNext()) {
            List listA = ((ax) it2.next()).n().a(csVar, false);
            if (listA != null) {
                int size = listA.size();
                for (int i = 0; i < size; i++) {
                    bv bvVar = (bv) ((WeakReference) listA.get(i)).get();
                    if (bvVar != null) {
                        ((com.google.android.libraries.navigation.internal.my.c) aaVar).ak(bvVar);
                    }
                }
            }
        }
    }

    public static void e(View view) {
        ck ckVarJ = ck.j(view);
        if (ckVarJ != null) {
            ckVarJ.q(ckVarJ.j, 1);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                e(viewGroup.getChildAt(i));
            }
        }
    }
}
