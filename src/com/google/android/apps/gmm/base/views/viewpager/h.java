package com.google.android.apps.gmm.base.views.viewpager;

import androidx.viewpager.widget.ViewPager;
import java.util.ArrayList;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class h implements ViewPager.OnPageChangeListener {
    final /* synthetic */ GmmViewPager a;

    public h(GmmViewPager gmmViewPager) {
        this.a = gmmViewPager;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        GmmViewPager gmmViewPager = this.a;
        ViewPager.OnPageChangeListener onPageChangeListener = gmmViewPager.h;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i);
        }
        ArrayList arrayList = gmmViewPager.i;
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ViewPager.OnPageChangeListener) arrayList.get(i2)).onPageScrollStateChanged(i);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
        GmmViewPager gmmViewPager = this.a;
        gmmViewPager.b(gmmViewPager.a(i));
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        GmmViewPager gmmViewPager = this.a;
        if (gmmViewPager.c) {
            i = gmmViewPager.a(i);
            if (f == 0.0f) {
                f = 0.0f;
                i2 = 0;
            } else {
                i--;
                f = 1.0f - f;
                i2 = this.a.getWidth() - i2;
            }
        }
        GmmViewPager gmmViewPager2 = this.a;
        ViewPager.OnPageChangeListener onPageChangeListener = gmmViewPager2.h;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i, f, i2);
        }
        ArrayList arrayList = gmmViewPager2.i;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((ViewPager.OnPageChangeListener) arrayList.get(i3)).onPageScrolled(i, f, i2);
        }
    }
}
