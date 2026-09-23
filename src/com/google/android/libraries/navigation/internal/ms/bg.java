package com.google.android.libraries.navigation.internal.ms;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import com.google.android.libraries.navigation.internal.yz.ho;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bg {
    public final ho a = new com.google.android.libraries.navigation.internal.yz.aw();
    public final bf b = new bf();
    public final Object c = new Object();

    private final void c(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return;
            } else {
                a(viewGroup.getChildAt(childCount));
            }
        }
    }

    final void a(View view) {
        cq cqVarA = cp.a(view);
        if (cqVarA != null) {
            b(cqVarA);
        } else if (view instanceof ViewGroup) {
            c((ViewGroup) view);
        }
    }

    public final void b(cq cqVar) {
        ck ckVar = cqVar.a;
        View view = ckVar.c;
        if (!ckVar.i) {
            bt btVar = ckVar.f;
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
            ckVar.n();
            view.setPressed(false);
            synchronized (this.c) {
                if (this.b.a.containsKey(btVar)) {
                    List listC = this.a.c(btVar);
                    if (listC.size() < 4) {
                        listC.add(cqVar);
                        return;
                    }
                }
            }
        }
        View viewA = cqVar.a();
        if ((viewA instanceof ViewGroup) && !(viewA instanceof AdapterView) && ck.j(viewA) == null) {
            c((ViewGroup) viewA);
        }
    }
}
