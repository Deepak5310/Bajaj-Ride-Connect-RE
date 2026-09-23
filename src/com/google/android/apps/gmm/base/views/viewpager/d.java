package com.google.android.apps.gmm.base.views.viewpager;

import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class d implements View.OnClickListener {
    final /* synthetic */ ArrowViewPager a;

    public d(ArrowViewPager arrowViewPager) {
        this.a = arrowViewPager;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrowViewPager arrowViewPager = this.a;
        if (view == arrowViewPager.e) {
            arrowViewPager.d();
        }
        ArrowViewPager arrowViewPager2 = this.a;
        if (view == arrowViewPager2.f) {
            arrowViewPager2.c();
        }
    }
}
