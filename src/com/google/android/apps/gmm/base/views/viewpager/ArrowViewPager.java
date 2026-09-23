package com.google.android.apps.gmm.base.views.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.o;
import com.google.android.libraries.navigation.internal.ms.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public class ArrowViewPager extends FrameLayout {
    public static final cx a = new g();
    final ViewPager.OnPageChangeListener b;
    ViewPager c;
    public PagerAdapter d;
    public View e;
    public View f;
    public f g;
    public f h;
    boolean i;
    public a j;
    public e k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f37n;
    public boolean o;
    public b p;
    private final ViewGroup.OnHierarchyChangeListener q;
    private final View.OnClickListener r;

    /* JADX INFO: compiled from: PG */
    public final class ArrowViewNext extends FrameLayout {
        public ArrowViewNext(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ArrowViewNext(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    /* JADX INFO: compiled from: PG */
    public final class ArrowViewPrevious extends FrameLayout {
        public ArrowViewPrevious(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ArrowViewPrevious(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }

    /* JADX INFO: compiled from: PG */
    public interface a {
        void a(int i, b bVar, o oVar);
    }

    /* JADX INFO: compiled from: PG */
    public enum b {
        USER_SWIPE,
        USER_ARROW_CLICK_PREVIOUS,
        USER_ARROW_CLICK_NEXT,
        PROGRAMMATIC
    }

    public ArrowViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = new com.google.android.apps.gmm.base.views.viewpager.a(this);
        this.f37n = 0;
        this.q = new c(this);
        this.r = new d(this);
        h();
    }

    public static o b(View view) {
        aa aaVarC = com.google.android.libraries.navigation.internal.jw.e.c(view);
        o oVarA = com.google.android.libraries.navigation.internal.jw.e.a(view);
        if (aaVarC != null && oVarA != null) {
            return oVarA;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (viewGroup.getChildCount() > 0) {
            return b(viewGroup.getChildAt(0));
        }
        return null;
    }

    private final void h() {
        GmmViewPager gmmViewPager = new GmmViewPager(getContext(), null);
        this.c = gmmViewPager;
        addView(gmmViewPager, 0, new ViewGroup.LayoutParams(-1, -1));
        this.c.addOnPageChangeListener(new com.google.android.apps.gmm.base.views.viewpager.b(this));
        this.p = b.PROGRAMMATIC;
        g(true);
        setOnHierarchyChangeListener(this.q);
        this.c.addOnPageChangeListener(this.b);
    }

    public final int a() {
        return this.c.getCurrentItem();
    }

    public final void c() {
        this.p = b.USER_ARROW_CLICK_NEXT;
        ViewPager viewPager = this.c;
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    public final void d() {
        this.p = b.USER_ARROW_CLICK_PREVIOUS;
        ViewPager viewPager = this.c;
        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (motionEvent.getAction() == 0 && !com.google.android.libraries.navigation.internal.ap.a.a(this, motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        f fVar = this.g;
        boolean z2 = fVar != null && fVar.a(motionEvent);
        f fVar2 = this.h;
        if (fVar2 != null && fVar2.a(motionEvent)) {
            z = true;
        }
        if (!z2) {
            if (z) {
                c();
            } else if (motionEvent.getAction() == 1) {
                this.p = b.USER_SWIPE;
            }
            boolean zDispatchTouchEvent = this.c.dispatchTouchEvent(motionEvent);
            this.p = b.PROGRAMMATIC;
            return zDispatchTouchEvent;
        }
        d();
        motionEvent.setAction(3);
        boolean zDispatchTouchEvent2 = this.c.dispatchTouchEvent(motionEvent);
        this.p = b.PROGRAMMATIC;
        return zDispatchTouchEvent2;
    }

    public final void e(View view) {
        view.setOnClickListener(this.r);
        bringChildToFront(view);
    }

    public final void g(Boolean bool) {
        this.i = bool.booleanValue();
        f(this.c.getCurrentItem());
    }

    public final void f(int i) {
        PagerAdapter pagerAdapter = this.d;
        int count = pagerAdapter == null ? 0 : pagerAdapter.getCount();
        boolean z = this.i;
        boolean z2 = z && i > 0;
        boolean z3 = z && (i < count + (-1) || count == 0);
        View view = this.e;
        if (view != null) {
            view.setVisibility(true != z2 ? 4 : 0);
        }
        View view2 = this.f;
        if (view2 != null) {
            view2.setVisibility(true != z3 ? 4 : 0);
        }
    }

    public ArrowViewPager(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new com.google.android.apps.gmm.base.views.viewpager.a(this);
        this.f37n = 0;
        this.q = new c(this);
        this.r = new d(this);
        h();
    }
}
