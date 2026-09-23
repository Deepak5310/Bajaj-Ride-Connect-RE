package com.google.android.apps.gmm.base.views.viewpager;

import androidx.viewpager.widget.ViewPager;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class a implements ViewPager.OnPageChangeListener {
    final /* synthetic */ ArrowViewPager a;

    public a(ArrowViewPager arrowViewPager) {
        this.a = arrowViewPager;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0053  */
    /* JADX WARN: Code duplicated, block: B:26:0x005b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0061  */
    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrollStateChanged(int i) {
        ArrowViewPager arrowViewPager;
        ArrowViewPager arrowViewPager2 = this.a;
        if (arrowViewPager2.k == null) {
            return;
        }
        if (arrowViewPager2.f37n == 0 && i == 1) {
            if (arrowViewPager2.a() == 0) {
                this.a.l = true;
            } else {
                ArrowViewPager arrowViewPager3 = this.a;
                if (arrowViewPager3.a() == arrowViewPager3.d.getCount() - 1) {
                    this.a.m = true;
                }
            }
            i = 1;
        }
        if (i == 0) {
            ArrowViewPager arrowViewPager4 = this.a;
            if (arrowViewPager4.f37n != 0) {
                if (arrowViewPager4.a() == this.a.d.getCount() - 1) {
                    ArrowViewPager arrowViewPager5 = this.a;
                    if (arrowViewPager5.m) {
                        arrowViewPager5.k.a();
                    } else if (this.a.a() == 0) {
                        arrowViewPager = this.a;
                        if (arrowViewPager.l) {
                            arrowViewPager.k.b();
                        }
                    }
                } else if (this.a.a() == 0) {
                    arrowViewPager = this.a;
                    if (arrowViewPager.l) {
                        arrowViewPager.k.b();
                    }
                }
                ArrowViewPager arrowViewPager6 = this.a;
                arrowViewPager6.m = false;
                arrowViewPager6.l = false;
            }
        }
        this.a.f37n = i;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageScrolled(int i, float f, int i2) {
        if (f > 0.0f) {
            ArrowViewPager arrowViewPager = this.a;
            arrowViewPager.l = false;
            arrowViewPager.m = false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public final void onPageSelected(int i) {
    }
}
