package com.google.android.libraries.navigation.internal.abs;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends ExploreByTouchHelper {
    private final m a;

    public j(m mVar, View view) {
        super(view);
        this.a = mVar;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final int getVirtualViewAt(float f, float f2) {
        int iA = this.a.a(f, f2);
        if (iA == -1) {
            return Integer.MIN_VALUE;
        }
        return iA;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void getVisibleVirtualViews(List list) {
        RectF[] rectFArr;
        m mVar = this.a;
        synchronized (mVar) {
            if (mVar.f && (rectFArr = mVar.j) != null) {
                int length = rectFArr.length;
                for (int i = 0; i < length; i++) {
                    list.add(Integer.valueOf(i));
                }
            }
        }
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
        return true;
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateEventForVirtualView(int i, AccessibilityEvent accessibilityEvent) {
        Float fValueOf;
        m mVar = this.a;
        synchronized (mVar) {
            List list = mVar.h;
            fValueOf = null;
            if (list != null && i < ((lv) list).c) {
                fValueOf = Float.valueOf(((com.google.android.libraries.navigation.internal.abt.b) list.get(i)).bearing);
            }
        }
        accessibilityEvent.setContentDescription(fValueOf == null ? "" : mVar.d[com.google.android.libraries.navigation.internal.abw.k.n(fValueOf.floatValue())]);
    }

    @Override // androidx.customview.widget.ExploreByTouchHelper
    public final void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Float fValueOf;
        RectF rectF;
        RectF[] rectFArr;
        m mVar = this.a;
        synchronized (mVar) {
            List list = mVar.h;
            fValueOf = null;
            if (list == null || i >= ((lv) list).c || (rectFArr = mVar.j) == null || i >= rectFArr.length) {
                rectF = null;
            } else {
                fValueOf = Float.valueOf(((com.google.android.libraries.navigation.internal.abt.b) list.get(i)).bearing);
                rectF = mVar.j[i];
            }
        }
        if (fValueOf == null) {
            accessibilityNodeInfoCompat.setFocusable(false);
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(m.b);
        } else {
            accessibilityNodeInfoCompat.setFocusable(true);
            accessibilityNodeInfoCompat.setContentDescription(mVar.d[com.google.android.libraries.navigation.internal.abw.k.n(fValueOf.floatValue())]);
            com.google.android.libraries.navigation.internal.abf.s.k(rectF, "rectF");
            accessibilityNodeInfoCompat.setBoundsInParent(new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
        }
    }
}
