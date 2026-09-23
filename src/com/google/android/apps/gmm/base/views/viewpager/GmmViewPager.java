package com.google.android.apps.gmm.base.views.viewpager;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.libraries.navigation.internal.zb.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class GmmViewPager extends ViewPager {
    boolean a;
    boolean b;
    boolean c;
    boolean d;
    a e;
    final ViewPager.OnPageChangeListener f;
    public PagerAdapter g;
    public ViewPager.OnPageChangeListener h;
    public final ArrayList i;
    private boolean j;
    private int k;

    /* JADX INFO: compiled from: PG */
    class a extends PagerAdapter {
        private static final j e = j.e("com.google.android.apps.gmm.base.views.viewpager.GmmViewPager$a");
        GmmViewPager a;
        public final PagerAdapter b;
        DataSetObserver c;
        boolean d;
        private final HashMap f = new HashMap();
        private WeakReference g = new WeakReference(null);
        private int h;
        private boolean i;

        public a(GmmViewPager gmmViewPager, PagerAdapter pagerAdapter) {
            this.a = gmmViewPager;
            this.b = pagerAdapter;
            i iVar = new i(gmmViewPager);
            this.c = iVar;
            pagerAdapter.registerDataSetObserver(iVar);
            this.h = pagerAdapter.getCount();
            this.i = gmmViewPager.c;
        }

        final int a(int i) {
            int i2 = this.h;
            if (i2 == 0) {
                return 0;
            }
            return this.i ? (i2 - i) - 1 : i;
        }

        final void b(int i) {
            boolean z = true;
            this.d = i == 1;
            try {
                int currentItem = this.a.getCurrentItem();
                Object obj = this.g.get();
                if (obj != null && getItemPosition(obj) != -2) {
                    z = false;
                }
                this.i = this.a.c;
                this.h = this.b.getCount();
                notifyDataSetChanged();
                if (z) {
                    this.a.setCurrentItem(Math.max(0, Math.min(this.h - 1, currentItem)), false);
                }
                GmmViewPager gmmViewPager = this.a;
                gmmViewPager.b(gmmViewPager.getCurrentItem());
            } finally {
                this.d = false;
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj == this.g.get()) {
                this.g = new WeakReference(null);
            }
            this.f.remove(obj);
            try {
                this.b.destroyItem(viewGroup, a(i), obj);
            } catch (RuntimeException e2) {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) e.d(com.google.android.libraries.navigation.internal.nl.a.a).g(new RuntimeException(String.format("destroyItem failed for container %s and object %s. Mostly likely object is null.", viewGroup, obj), e2))).F('\n')).o();
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void finishUpdate(ViewGroup viewGroup) {
            this.b.finishUpdate(viewGroup);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getCount() {
            return this.h;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final int getItemPosition(Object obj) {
            if (this.d) {
                return a(((Integer) this.f.get(obj)).intValue());
            }
            int itemPosition = this.b.getItemPosition(obj);
            if (itemPosition == -1) {
                return a(((Integer) this.f.get(obj)).intValue());
            }
            if (itemPosition == -2) {
                return -2;
            }
            return a(itemPosition);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final CharSequence getPageTitle(int i) {
            return this.b.getPageTitle(a(i));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final float getPageWidth(int i) {
            return this.b.getPageWidth(a(i));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Object instantiateItem(ViewGroup viewGroup, int i) {
            PagerAdapter pagerAdapter = this.b;
            int iA = a(i);
            Object objInstantiateItem = pagerAdapter.instantiateItem(viewGroup, iA);
            this.f.put(objInstantiateItem, Integer.valueOf(iA));
            return objInstantiateItem;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final boolean isViewFromObject(View view, Object obj) {
            return this.b.isViewFromObject(view, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void restoreState(Parcelable parcelable, ClassLoader classLoader) {
            this.b.restoreState(parcelable, classLoader);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final Parcelable saveState() {
            return this.b.saveState();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            int iA = a(i);
            this.g = new WeakReference(obj);
            this.b.setPrimaryItem(viewGroup, iA, obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public final void startUpdate(ViewGroup viewGroup) {
            this.b.startUpdate(viewGroup);
        }
    }

    public GmmViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = true;
        this.b = true;
        this.c = false;
        this.j = true;
        this.d = true;
        this.i = new ArrayList(1);
        h hVar = new h(this);
        this.f = hVar;
        super.addOnPageChangeListener(hVar);
    }

    public final int a(int i) {
        a aVar = this.e;
        return aVar != null ? aVar.a(i) : i;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void addOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.i.add(onPageChangeListener);
    }

    public final void b(int i) {
        View childAt;
        if (i != this.k) {
            this.k = i;
            ViewPager.OnPageChangeListener onPageChangeListener = this.h;
            if (onPageChangeListener != null) {
                onPageChangeListener.onPageSelected(i);
            }
            ArrayList arrayList = this.i;
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                ((ViewPager.OnPageChangeListener) arrayList.get(i2)).onPageSelected(i);
            }
            if (this.j && this.d && (childAt = getChildAt(i)) != null) {
                int importantForAccessibility = childAt.getImportantForAccessibility();
                childAt.setImportantForAccessibility(1);
                childAt.sendAccessibilityEvent(8);
                childAt.setImportantForAccessibility(importantForAccessibility);
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean canScrollHorizontally(int i) {
        if (isShown() && this.a) {
            return super.canScrollHorizontally(i);
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final PagerAdapter getAdapter() {
        return this.g;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final int getCurrentItem() {
        return a(super.getCurrentItem());
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            try {
                return super.onInterceptTouchEvent(motionEvent);
            } catch (IllegalArgumentException unused) {
            }
        }
        return false;
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        boolean zB = com.google.android.libraries.navigation.internal.kj.c.b(this);
        if (zB != this.c) {
            this.c = zB;
            a aVar = this.e;
            if (aVar != null) {
                this.d = false;
                aVar.b(1);
                this.d = true;
            }
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.a) {
            try {
                return super.onTouchEvent(motionEvent);
            } catch (IllegalArgumentException | IndexOutOfBoundsException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void removeOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.i.remove(onPageChangeListener);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setAdapter(PagerAdapter pagerAdapter) {
        a aVar = this.e;
        if (aVar != null) {
            aVar.b.unregisterDataSetObserver(aVar.c);
            aVar.a = null;
            aVar.c = null;
            this.e = null;
        }
        this.g = pagerAdapter;
        if (pagerAdapter != null) {
            this.e = new a(this, pagerAdapter);
        }
        super.setAdapter(this.e);
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int i) {
        this.d = false;
        boolean z = this.b;
        int iA = a(i);
        if (z) {
            super.setCurrentItem(iA);
        } else {
            super.setCurrentItem(iA, false);
        }
        this.d = true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.h = onPageChangeListener;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public final void setCurrentItem(int i, boolean z) {
        this.d = false;
        super.setCurrentItem(a(i), z);
        this.d = true;
    }
}
