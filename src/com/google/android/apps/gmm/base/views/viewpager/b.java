package com.google.android.apps.gmm.base.views.viewpager;

import androidx.viewpager.widget.ViewPager;
import com.google.android.libraries.navigation.internal.jy.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class b extends ViewPager.SimpleOnPageChangeListener {
    final /* synthetic */ ArrowViewPager a;

    public b(ArrowViewPager arrowViewPager) {
        this.a = arrowViewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        this.a.o = i != 0;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        if (f > 0.0f) {
            this.a.o = true;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        this.a.f(i);
        ArrowViewPager arrowViewPager = this.a;
        if (arrowViewPager.j != null) {
            o oVarB = ArrowViewPager.b(arrowViewPager.c);
            ArrowViewPager arrowViewPager2 = this.a;
            arrowViewPager2.j.a(i, arrowViewPager2.p, oVarB);
        }
        this.a.p = ArrowViewPager.b.PROGRAMMATIC;
    }
}
