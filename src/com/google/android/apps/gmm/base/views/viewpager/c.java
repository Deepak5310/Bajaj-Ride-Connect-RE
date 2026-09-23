package com.google.android.apps.gmm.base.views.viewpager;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class c implements ViewGroup.OnHierarchyChangeListener {
    final /* synthetic */ ArrowViewPager a;

    public c(ArrowViewPager arrowViewPager) {
        this.a = arrowViewPager;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewAdded(View view, View view2) {
        ArrowViewPager arrowViewPager = this.a;
        if (view != arrowViewPager) {
            return;
        }
        if (view2 instanceof ArrowViewPager.ArrowViewPrevious) {
            View view3 = arrowViewPager.e;
            if (view3 != view2) {
                if (view3 != null) {
                    arrowViewPager.removeView(view3);
                }
                arrowViewPager.e = view2;
                arrowViewPager.g = new f(arrowViewPager, arrowViewPager.e);
                arrowViewPager.e(arrowViewPager.e);
            }
            ArrowViewPager arrowViewPager2 = this.a;
            arrowViewPager2.f(arrowViewPager2.c.getCurrentItem());
            return;
        }
        if (view2 instanceof ArrowViewPager.ArrowViewNext) {
            View view4 = arrowViewPager.f;
            if (view4 != view2) {
                if (view4 != null) {
                    arrowViewPager.removeView(view4);
                }
                arrowViewPager.f = view2;
                arrowViewPager.h = new f(arrowViewPager, arrowViewPager.f);
                arrowViewPager.e(arrowViewPager.f);
            }
            ArrowViewPager arrowViewPager3 = this.a;
            arrowViewPager3.f(arrowViewPager3.c.getCurrentItem());
        }
    }
}
