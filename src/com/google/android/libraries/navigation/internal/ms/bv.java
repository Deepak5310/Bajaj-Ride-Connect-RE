package com.google.android.libraries.navigation.internal.ms;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class bv extends ck {
    public bv(View view, ax axVar, bx bxVar, cc ccVar, bt btVar, int i, boolean z) {
        super(view, axVar, bxVar, ccVar, btVar, z);
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ck
    public final void c(cs csVar, cs csVar2) {
        List listA;
        boolean z = csVar instanceof ct;
        cv cvVarN = this.g.n();
        if (z) {
            ((ct) csVar).b();
        }
        if (csVar2 instanceof ct) {
            ((ct) csVar2).a();
        }
        if (csVar != null && (listA = cvVarN.a(csVar, false)) != null) {
            int size = listA.size();
            while (true) {
                size--;
                if (size < 0) {
                    break;
                } else if (((WeakReference) listA.get(size)).get() == this) {
                    listA.remove(size);
                }
            }
        }
        if (csVar2 == null) {
            return;
        }
        List listA2 = cvVarN.a(csVar2, true);
        int size2 = listA2.size();
        for (int i = 0; i < size2; i++) {
            if (((WeakReference) listA2.get(i)).get() == this) {
                return;
            }
        }
        listA2.add(new WeakReference(this));
    }
}
