package com.google.android.libraries.navigation.internal.abh;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cp extends ExploreByTouchHelper {
    public static final /* synthetic */ int b = 0;
    private static final Rect c = new Rect(-2, -2, -1, -1);
    public List a;
    private final ey d;
    private final String e;

    public cp(View view, ey eyVar, be beVar) {
        super(view);
        this.e = beVar.n(com.google.android.gms.maps.am.f47n);
        this.d = eyVar;
    }

    public static String a(es esVar) {
        if (esVar == null) {
            return "";
        }
        String strJ = esVar.j();
        String strI = esVar.i();
        String strConcat = com.google.android.libraries.navigation.internal.abf.x.a(strJ) ? "" : String.valueOf(strJ).concat(". ");
        if (com.google.android.libraries.navigation.internal.abf.x.a(strI)) {
            return strConcat;
        }
        return strConcat + strI + ".";
    }

    private static String b(es esVar) {
        String strJ = esVar.j();
        return !com.google.android.libraries.navigation.internal.abf.x.a(strJ) ? strJ : "";
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected final int getVirtualViewAt(float f, float f2) {
        if (this.a == null) {
            return Integer.MIN_VALUE;
        }
        for (int i = 0; i < this.a.size(); i++) {
            es esVar = (es) this.a.get(i);
            if (!esVar.Y() && esVar.P().contains((int) f, (int) f2)) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected final void getVisibleVirtualViews(List list) {
        List listC = this.d.c();
        this.a = listC;
        if (listC == null) {
            return;
        }
        int size = listC.size();
        for (int i = 0; i < size; i++) {
            list.add(Integer.valueOf(i));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected final boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        return false;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected final void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        List list = this.a;
        if (list == null || i >= list.size()) {
            this.a = this.d.c();
        }
        List list2 = this.a;
        if (list2 == null || i >= list2.size()) {
            accessibilityEvent.setContentDescription("");
        } else {
            accessibilityEvent.setContentDescription(a((es) this.a.get(i)));
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    protected final void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        List list = this.a;
        String strB = "";
        if (list == null || i >= list.size() || ((es) this.a.get(i)).Y()) {
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(c);
            return;
        }
        es esVar = (es) this.a.get(i);
        if (com.google.android.libraries.navigation.internal.afu.y.c()) {
            if (esVar != null) {
                if (esVar.R() != null) {
                    strB = esVar.R();
                } else {
                    strB = !com.google.android.libraries.navigation.internal.yx.aq.c(b(esVar)) ? b(esVar) : this.e;
                }
            }
            accessibilityNodeInfoCompat.setContentDescription(strB);
        } else {
            accessibilityNodeInfoCompat.setContentDescription(a(esVar));
            if (com.google.android.libraries.navigation.internal.afu.d.m()) {
                accessibilityNodeInfoCompat.addAction(16);
            }
        }
        if (!com.google.android.libraries.navigation.internal.afu.d.m()) {
            accessibilityNodeInfoCompat.addAction(16);
        }
        accessibilityNodeInfoCompat.setBoundsInParent(esVar.P());
        accessibilityNodeInfoCompat.setFocusable(true);
    }
}
