package com.google.android.libraries.navigation.internal.ms;

import android.animation.LayoutTransition;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.webkit.WebView;
import android.widget.AbsListView;
import android.widget.AbsSeekBar;
import android.widget.AutoCompleteTextView;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;
import android.widget.VideoView;
import android.widget.ViewAnimator;
import androidx.core.os.BuildCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.bajajconnect.rideapp.R;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m {
    public static final bq a = new bq();
    public static final bq b = new bq();
    public static final bq c = new bq();
    public static final bq d = new bq();
    private static final bq e = new bq();
    private final ax f;

    public m(ax axVar) {
        this.f = axVar;
    }

    public static int a(Object obj, View view) {
        if (obj instanceof dd) {
            return a(((dd) obj).a(ck.k(view)), view);
        }
        if (obj instanceof by) {
            return a(((by) obj).a(ck.k(view), view.getContext()), view);
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
            return ((com.google.android.libraries.navigation.internal.nc.ap) obj).d(view.getContext());
        }
        if (obj == null) {
            return 0;
        }
        throw new com.google.android.libraries.navigation.internal.yx.cb("Can't handle padding object: ".concat(obj.toString()));
    }

    public static void aY(Object obj, View view) {
        if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
            ((com.google.android.libraries.navigation.internal.nc.x) obj).b(view.getContext());
        } else if (obj instanceof Number) {
            ((Number) obj).intValue();
        } else if (obj != null) {
            throw new IllegalArgumentException("Unable to resolve color: ".concat(obj.toString()));
        }
    }

    public static ColorStateList b(Object obj, View view) {
        if (obj instanceof com.google.android.libraries.navigation.internal.nc.x) {
            return ((com.google.android.libraries.navigation.internal.nc.x) obj).c(view.getContext());
        }
        if (obj instanceof Number) {
            return ColorStateList.valueOf(((Number) obj).intValue());
        }
        if (obj == null) {
            return ColorStateList.valueOf(0);
        }
        throw new IllegalArgumentException("Unable to resolve color state list: ".concat(obj.toString()));
    }

    private final int bF(Object obj, View view) {
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof cc)) {
            throw new IllegalArgumentException("The value argument passed to getNextFocusId() was not ofexpected type Integer or Token.");
        }
        this.f.d();
        return be.a((View) view.getParent(), (cc) obj).getId();
    }

    private final ListAdapter bG(Object obj) {
        if (obj instanceof com.google.android.libraries.navigation.internal.mt.c) {
            return (com.google.android.libraries.navigation.internal.mt.c) obj;
        }
        if (obj instanceof ListAdapter) {
            return (ListAdapter) obj;
        }
        if (!(obj instanceof bs)) {
            return null;
        }
        com.google.android.libraries.navigation.internal.mt.i iVar = new com.google.android.libraries.navigation.internal.mt.i(this.f.l());
        Iterator it2 = ((bs) obj).b.iterator();
        while (it2.hasNext()) {
            iVar.a.f((bu) it2.next());
            iVar.notifyDataSetChanged();
        }
        return iVar;
    }

    private static final boolean bH(ListAdapter listAdapter, ListAdapter listAdapter2) {
        if (!(listAdapter instanceof com.google.android.libraries.navigation.internal.mt.i) || !(listAdapter2 instanceof com.google.android.libraries.navigation.internal.mt.i)) {
            return false;
        }
        int viewTypeCount = listAdapter.getViewTypeCount();
        int count = listAdapter2.getCount();
        for (int i = 0; i < count; i++) {
            if (listAdapter2.getItemViewType(i) >= viewTypeCount) {
                return false;
            }
        }
        return true;
    }

    private static final void bI(Drawable drawable, TextView textView, int i) {
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        compoundDrawables[i] = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), compoundDrawables[i].getIntrinsicHeight());
        }
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    private static final void bJ(Drawable drawable, TextView textView, int i) {
        Drawable[] compoundDrawablesRelative = textView.getCompoundDrawablesRelative();
        compoundDrawablesRelative[i] = drawable;
        if (drawable != null) {
            drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), compoundDrawablesRelative[i].getIntrinsicHeight());
        }
        textView.setCompoundDrawablesRelative(compoundDrawablesRelative[0], compoundDrawablesRelative[1], compoundDrawablesRelative[2], compoundDrawablesRelative[3]);
    }

    public static void c(View view) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = (View.OnAttachStateChangeListener) view.getTag(2131230772);
        if (onAttachStateChangeListener != null) {
            if (onAttachStateChangeListener instanceof j) {
                ((j) onAttachStateChangeListener).a();
            }
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            view.setTag(2131230772, null);
        }
    }

    public static void d(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                return;
            }
            View childAt = viewGroup.getChildAt(childCount);
            viewGroup.removeViewAt(childCount);
            cq cqVarA = cp.a(childAt);
            if (cqVarA != null) {
                cqVarA.d();
            }
        }
    }

    public final void A(Drawable drawable, View view) {
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackground(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final void B(ColorFilter colorFilter, ImageView imageView) {
        if (colorFilter == null) {
            imageView.clearColorFilter();
        } else {
            imageView.setColorFilter(colorFilter);
        }
    }

    public final void C(cc ccVar, ViewAnimator viewAnimator, ck ckVar) {
        ckVar.g.l();
        int childCount = viewAnimator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ck ckVarJ = ck.j(viewAnimator.getChildAt(i));
            if (ckVarJ != null && ckVarJ.e == ccVar) {
                viewAnimator.setDisplayedChild(i);
                return;
            }
        }
        throw new com.google.android.libraries.navigation.internal.yx.cb("Unable to find view to switch to");
    }

    public final void D(List list, NumberPicker numberPicker) {
        numberPicker.setDisplayedValues((String[]) list.toArray(new String[list.size()]));
    }

    public final void E(Drawable drawable, TextView textView) {
        bJ(drawable, textView, 3);
    }

    public final void F(Drawable drawable, TextView textView) {
        bJ(drawable, textView, 2);
    }

    public final void G(Drawable drawable, TextView textView) {
        bI(drawable, textView, 0);
    }

    public final void H(Drawable drawable, TextView textView) {
        bI(drawable, textView, 2);
    }

    public final void I(Drawable drawable, TextView textView) {
        bJ(drawable, textView, 0);
    }

    public final void J(Drawable drawable, TextView textView) {
        bJ(drawable, textView, 1);
    }

    public final void K(boolean z, View view) {
        ViewParent parent = view.getParent();
        if (!(parent instanceof ViewGroup)) {
            view.setDuplicateParentStateEnabled(z);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeViewAt(iIndexOfChild);
        view.setDuplicateParentStateEnabled(z);
        viewGroup.addView(view, iIndexOfChild);
    }

    public final void L(com.google.android.libraries.navigation.internal.nc.ap apVar, View view) {
        try {
            view.setElevation(apVar.a(view.getContext()));
        } catch (NoSuchMethodError unused) {
        }
    }

    public final void M(Number number, View view) {
        try {
            view.setElevation(number.floatValue());
        } catch (NoSuchMethodError unused) {
        }
    }

    public final void N(Boolean bool, View view) {
        view.setFitsSystemWindows(bool == null ? false : bool.booleanValue());
    }

    public final void O(String str, TextView textView) {
        textView.setFontFeatureSettings(str);
    }

    public final void P(Drawable drawable, FrameLayout frameLayout) {
        frameLayout.setForeground(drawable);
    }

    public final void Q(FragmentPagerAdapter fragmentPagerAdapter, ViewPager viewPager) {
        if (Objects.equals(fragmentPagerAdapter, viewPager.getAdapter())) {
            return;
        }
        viewPager.setAdapter(fragmentPagerAdapter);
    }

    public final void R(Runnable runnable, View view) {
        if (BuildCompat.isAtLeastU()) {
            try {
                view.setHandwritingDelegatorCallback(runnable);
            } catch (LinkageError unused) {
            }
        }
    }

    public final void S(Integer num, View view) {
        ViewParent parent = view.getParent();
        int iIntValue = num == null ? -1 : num.intValue();
        if (iIntValue == view.getId()) {
            return;
        }
        if (!(parent instanceof com.google.android.libraries.navigation.internal.mx.x)) {
            view.setId(iIntValue);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(view);
        viewGroup.removeViewAt(iIndexOfChild);
        view.setId(iIntValue);
        viewGroup.addView(view, iIndexOfChild);
    }

    public final void T(Matrix matrix, ImageView imageView) {
        imageView.setImageMatrix(matrix);
    }

    public final void U(ColorStateList colorStateList, ImageView imageView) {
        ImageViewCompat.setImageTintList(imageView, colorStateList);
    }

    public final void V(ColorFilter colorFilter, ProgressBar progressBar) {
        progressBar.getIndeterminateDrawable().setColorFilter(colorFilter);
    }

    public final void W(ab abVar, DatePicker datePicker) {
        datePicker.init(abVar.d().intValue(), abVar.c().intValue(), abVar.b().intValue(), abVar.a());
    }

    public final void X(boolean z, View view) {
        if (BuildCompat.isAtLeastU()) {
            try {
                view.setIsHandwritingDelegate(z);
            } catch (LinkageError unused) {
            }
        }
    }

    public final void Y(int i, View view) {
        view.setLayerType(i, null);
    }

    public final void Z(float f, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new GridLayout.LayoutParams();
        }
        if (layoutParams instanceof GridLayout.LayoutParams) {
            ((GridLayout.LayoutParams) layoutParams).columnSpec = GridLayout.spec(Integer.MIN_VALUE, f);
            view.setLayoutParams(layoutParams);
        }
    }

    public final void aA(TextView.OnEditorActionListener onEditorActionListener, TextView textView) {
        textView.setOnEditorActionListener(onEditorActionListener);
    }

    public final void aB(View.OnFocusChangeListener onFocusChangeListener, View view) {
        view.setOnFocusChangeListener(onFocusChangeListener);
    }

    public final void aC(View.OnGenericMotionListener onGenericMotionListener, View view) {
        view.setOnGenericMotionListener(onGenericMotionListener);
    }

    public final void aD(View.OnLayoutChangeListener onLayoutChangeListener, View view) {
        View.OnLayoutChangeListener onLayoutChangeListener2 = (View.OnLayoutChangeListener) view.getTag(2131230773);
        if (onLayoutChangeListener2 != null) {
            view.removeOnLayoutChangeListener(onLayoutChangeListener2);
        }
        view.setTag(2131230773, onLayoutChangeListener);
        if (onLayoutChangeListener != null) {
            view.addOnLayoutChangeListener(onLayoutChangeListener);
        }
    }

    public final void aE(View view) {
        cn.a(view).c(a, null);
    }

    public final void aF(c cVar, View view, ck ckVar) {
        int i = k.a;
        bq bqVar = c;
        k kVar = (k) ckVar.l(bqVar);
        if (kVar != null) {
            kVar.a();
        }
        if (cVar != null) {
            ckVar.o(bqVar, new k(cVar, ckVar));
            view.invalidate();
        }
    }

    public final void aG(d dVar, View view, ck ckVar) {
        int i = l.c;
        bq bqVar = d;
        l lVar = (l) ckVar.l(bqVar);
        if (lVar != null) {
            lVar.b.removeOnAttachStateChangeListener(lVar);
            lVar.onViewDetachedFromWindow(null);
            lVar.a.o(bqVar, null);
        }
        if (dVar != null) {
            ckVar.o(bqVar, new l(dVar, ckVar));
            view.invalidate();
        }
    }

    public final void aH(SwipeRefreshLayout.OnRefreshListener onRefreshListener, SwipeRefreshLayout swipeRefreshLayout) {
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
    }

    public final void aI(TextWatcher textWatcher, TextView textView, ck ckVar) {
        int i = i.c;
        i iVar = (i) textView.getTag(R.drawable.abc_textfield_search_material);
        if (iVar == null) {
            iVar = new i(ckVar);
            textView.addTextChangedListener(iVar);
            textView.setTag(R.drawable.abc_textfield_search_material, iVar);
            textView.addOnAttachStateChangeListener(iVar);
        }
        iVar.b = textView.isAttachedToWindow();
        iVar.a = textWatcher;
    }

    public final void aJ(TimePicker.OnTimeChangedListener onTimeChangedListener, TimePicker timePicker) {
        timePicker.setOnTimeChangedListener(onTimeChangedListener);
    }

    public final void aK(View.OnTouchListener onTouchListener, View view) {
        cz czVar = (cz) view.getTag(R.drawable.advise_container_background_selector_dark);
        if (czVar == null) {
            czVar = new cz();
            view.setOnTouchListener(czVar);
            view.setTag(R.drawable.advise_container_background_selector_dark, czVar);
        }
        bq bqVar = b;
        if (onTouchListener == null) {
            czVar.a.remove(bqVar);
        } else {
            czVar.a.put(bqVar, onTouchListener);
        }
    }

    public final void aL(Integer num, View view) {
        if (Build.VERSION.SDK_INT >= 28) {
            view.setOutlineAmbientShadowColor(num == null ? 0 : num.intValue());
        }
    }

    public final void aM(Integer num, View view) {
        if (Build.VERSION.SDK_INT >= 28) {
            view.setOutlineSpotShadowColor(num == null ? 0 : num.intValue());
        }
    }

    public final void aN(Object[] objArr, View view) {
        view.setPadding(a(objArr[0], view), a(objArr[1], view), a(objArr[2], view), a(objArr[3], view));
    }

    public final void aO(Object obj, View view) {
        if (view.isPaddingRelative()) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), a(obj, view));
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), a(obj, view));
        }
    }

    public final void aP(Object obj, View view) {
        ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), view.getPaddingTop(), a(obj, view), view.getPaddingBottom());
    }

    public final void aQ(Object obj, View view) {
        view.setPadding(a(obj, view), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
    }

    public final void aR(Object obj, View view) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), a(obj, view), view.getPaddingBottom());
    }

    public final void aS(Object obj, View view) {
        ViewCompat.setPaddingRelative(view, a(obj, view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
    }

    public final void aT(Object obj, View view) {
        if (view.isPaddingRelative()) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), a(obj, view), ViewCompat.getPaddingEnd(view), view.getPaddingBottom());
        } else {
            view.setPadding(view.getPaddingLeft(), a(obj, view), view.getPaddingRight(), view.getPaddingBottom());
        }
    }

    public final void aU(Boolean bool, VideoView videoView) {
        if (bool.booleanValue()) {
            videoView.start();
        } else {
            videoView.pause();
        }
    }

    public final void aV(com.google.android.libraries.navigation.internal.nc.ap apVar, SwipeRefreshLayout swipeRefreshLayout) {
        if (apVar != null) {
            int progressViewEndOffset = swipeRefreshLayout.getProgressViewEndOffset() - swipeRefreshLayout.getProgressViewStartOffset();
            int iE = apVar.e(swipeRefreshLayout.getContext());
            swipeRefreshLayout.setProgressViewOffset(false, iE, progressViewEndOffset + iE);
        }
    }

    public final void aW(ca caVar, View view) {
        int id;
        this.f.d();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams != null) {
            List listA = caVar.a();
            int size = listA.size();
            for (int i = 0; i < size; i++) {
                bz bzVar = (bz) listA.get(i);
                if (bzVar == null) {
                    id = 0;
                } else {
                    cc ccVarB = bzVar.b();
                    if (ccVarB != null) {
                        View viewA = be.a((View) view.getParent(), ccVarB);
                        com.google.android.libraries.navigation.internal.yx.ar.q(viewA);
                        id = viewA.getId();
                    } else {
                        id = -1;
                    }
                }
                layoutParams.addRule(i, id);
            }
            view.setLayoutParams(layoutParams);
        }
    }

    public final void aX(Boolean bool, View view) {
        if (bool == null || !bool.booleanValue()) {
            view.setSystemUiVisibility(view.getSystemUiVisibility() & (-5));
        } else {
            view.setSystemUiVisibility(view.getSystemUiVisibility() | 4);
        }
    }

    public final void aZ(boolean z, View view) {
        ViewCompat.setScreenReaderFocusable(view, z);
    }

    public final void aa(int i, View view) {
        try {
            view.setLayoutDirection(i);
        } catch (NoSuchMethodError unused) {
        }
    }

    public final void ab(int i, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).gravity = i;
            view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = i;
            view.setLayoutParams(layoutParams);
        } else if (layoutParams instanceof DrawerLayout.LayoutParams) {
            ((DrawerLayout.LayoutParams) layoutParams).gravity = i;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void ac(int i, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.height = i;
        view.setLayoutParams(layoutParams);
    }

    public final void ad(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.setMargins(i, i, i, i);
        view.setLayoutParams(marginLayoutParams);
    }

    public final void ae(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.bottomMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public final void af(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.setMarginEnd(i);
        view.setLayoutParams(marginLayoutParams);
    }

    public final void ag(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.leftMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public final void ah(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.rightMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public final void ai(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.setMarginStart(i);
        view.setLayoutParams(marginLayoutParams);
    }

    public final void aj(int i, View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        if (marginLayoutParams == null) {
            return;
        }
        marginLayoutParams.topMargin = i;
        view.setLayoutParams(marginLayoutParams);
    }

    public final void ak(float f, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new GridLayout.LayoutParams();
        }
        if (layoutParams instanceof GridLayout.LayoutParams) {
            ((GridLayout.LayoutParams) layoutParams).rowSpec = GridLayout.spec(Integer.MIN_VALUE, f);
            view.setLayoutParams(layoutParams);
        }
    }

    public final void al(float f, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LinearLayout.LayoutParams(0, 0);
        }
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) layoutParams).weight = f;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void am(int i, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = i;
        view.setLayoutParams(layoutParams);
    }

    public final void an(float f, TextView textView) {
        textView.setLetterSpacing(f);
    }

    public final void ao(float f, TextView textView) {
        textView.setTag(R.drawable.abc_ratingbar_indicator_material, Float.valueOf(f));
        textView.setLineSpacing(f, textView.getLineSpacingMultiplier());
    }

    public final void ap(Number number, TextView textView) {
        textView.setTag(R.drawable.abc_ratingbar_material, number);
        textView.setLineSpacing(textView.getLineSpacingExtra(), number.floatValue());
    }

    public final void aq(int i, TextView textView) {
        textView.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void ar(int i, View view) {
        view.setMinimumHeight(i);
        if (view instanceof TextView) {
            ((TextView) view).setMinHeight(i);
        }
        if (view instanceof com.google.android.libraries.navigation.internal.mx.p) {
            ((com.google.android.libraries.navigation.internal.mx.p) view).a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void as(int i, View view) {
        if (view instanceof TextView) {
            ((TextView) view).setMinWidth(i);
        }
        if (view instanceof com.google.android.libraries.navigation.internal.mx.p) {
            ((com.google.android.libraries.navigation.internal.mx.p) view).b();
        }
        view.setMinimumWidth(i);
    }

    public final void at(Object obj, View view) {
        view.setNextFocusDownId(bF(obj, view));
    }

    public final void au(Object obj, View view) {
        view.setNextFocusForwardId(bF(obj, view));
    }

    public final void av(Object obj, View view) {
        view.setNextFocusLeftId(bF(obj, view));
    }

    public final void aw(Object obj, View view) {
        view.setNextFocusRightId(bF(obj, view));
    }

    public final void ax(Object obj, View view) {
        view.setNextFocusUpId(bF(obj, view));
    }

    public final void ay(View.OnAttachStateChangeListener onAttachStateChangeListener, View view) {
        if (onAttachStateChangeListener == null) {
            c(view);
            return;
        }
        View.OnAttachStateChangeListener onAttachStateChangeListener2 = (View.OnAttachStateChangeListener) view.getTag(2131230772);
        if (onAttachStateChangeListener2 != null) {
            if ((onAttachStateChangeListener2 instanceof j) && onAttachStateChangeListener2 != onAttachStateChangeListener) {
                ((j) onAttachStateChangeListener2).a();
            }
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener2);
        }
        view.setTag(2131230772, onAttachStateChangeListener);
        view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        if (view.getWindowToken() == null || onAttachStateChangeListener2 == onAttachStateChangeListener) {
            return;
        }
        onAttachStateChangeListener.onViewAttachedToWindow(view);
    }

    public final void az(CalendarView.OnDateChangeListener onDateChangeListener, CalendarView calendarView) {
        calendarView.setOnDateChangeListener(onDateChangeListener);
    }

    public final void bA(PagerAdapter pagerAdapter, ViewPager viewPager) {
        if (Objects.equals(pagerAdapter, viewPager.getAdapter())) {
            return;
        }
        viewPager.setAdapter(pagerAdapter);
    }

    public final void bB(bt btVar, ViewPager viewPager) {
        viewPager.setAdapter(new com.google.android.libraries.navigation.internal.mt.k(this.f.l(), btVar));
    }

    public final void bC(List list, ViewPager viewPager) {
        com.google.android.libraries.navigation.internal.mt.b bVar = (com.google.android.libraries.navigation.internal.mt.b) viewPager.getAdapter();
        if (bVar != null) {
            bVar.b(list);
        }
    }

    public final void bD(ViewPager.PageTransformer pageTransformer, ViewPager viewPager) {
        viewPager.setPageTransformer(false, pageTransformer);
    }

    public final void bE(String str, WebView webView) {
        webView.loadData(str, "text/html", null);
    }

    public final void ba(boolean z, View view) {
        view.setHorizontalScrollBarEnabled(z);
        view.setVerticalScrollBarEnabled(z);
    }

    public final void bb(Integer num, VideoView videoView) {
        if (num != null) {
            videoView.seekTo(num.intValue());
        }
    }

    public final void bc(int i, TextView textView) {
        textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDx(), textView.getShadowDy(), i);
    }

    public final void bd(float f, TextView textView) {
        textView.setShadowLayer(textView.getShadowRadius(), f, textView.getShadowDy(), textView.getShadowColor());
    }

    public final void be(float f, TextView textView) {
        textView.setShadowLayer(textView.getShadowRadius(), textView.getShadowDy(), f, textView.getShadowColor());
    }

    public final void bf(float f, TextView textView) {
        textView.setShadowLayer(f, textView.getShadowDy(), textView.getShadowDx(), textView.getShadowColor());
    }

    public final void bg(Integer[] numArr, TableLayout tableLayout) {
        for (Integer num : numArr) {
            tableLayout.setColumnShrinkable(num.intValue(), true);
        }
    }

    public final void bh(Integer[] numArr, TableLayout tableLayout) {
        for (Integer num : numArr) {
            tableLayout.setColumnStretchable(num.intValue(), true);
        }
    }

    public final void bi(CharSequence charSequence, TextView textView) {
        CharSequence text = textView.getText();
        if (charSequence == null && text == null) {
            return;
        }
        if ((charSequence instanceof String) && (text instanceof String) && charSequence.equals(text)) {
            return;
        }
        if ((textView instanceof EditText) && TextUtils.equals(text, charSequence)) {
            return;
        }
        textView.setText(charSequence);
    }

    public final void bj(ac acVar, TextView textView) {
        boolean z;
        if (acVar == null) {
            return;
        }
        boolean z2 = textView instanceof EditText;
        if (z2 && TextUtils.equals(textView.getText(), acVar.a())) {
            z = false;
        } else {
            textView.setText(acVar.a());
            z = true;
        }
        if (z2) {
            if (!(!z && acVar.c().intValue() == textView.getSelectionStart() && acVar.b().intValue() == textView.getSelectionEnd()) && acVar.c().intValue() >= 0 && acVar.b().intValue() >= 0) {
                try {
                    ((EditText) textView).setSelection(acVar.c().intValue(), acVar.b().intValue());
                } catch (IndexOutOfBoundsException e2) {
                    acVar.c();
                    acVar.b();
                    acVar.a();
                    e2.getMessage();
                }
            }
        }
    }

    public final void bk(CharSequence charSequence, TextView textView) {
        bi(charSequence, textView);
        int i = 8;
        if (charSequence != null && charSequence.length() != 0) {
            i = 0;
        }
        textView.setVisibility(i);
    }

    public final void bl(int i, TextView textView) {
        textView.setTextAppearance(textView.getContext(), i);
    }

    public final void bm(b bVar, TextView textView) {
        TypedValue typedValue = new TypedValue();
        textView.getContext().getTheme().resolveAttribute(bVar.a, typedValue, true);
        textView.setTextAppearance(textView.getContext(), typedValue.data);
    }

    public final void bn(int i, View view) {
        view.setTextDirection(i);
    }

    public final void bo(CharSequence charSequence, TextView textView) {
        if ((textView instanceof EditText) && TextUtils.equals(textView.getText(), charSequence)) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        textView.setTextKeepState(charSequence);
    }

    public final void bp(CharSequence charSequence, ToggleButton toggleButton) {
        toggleButton.setTextOff(charSequence);
        toggleButton.setChecked(toggleButton.isChecked());
    }

    public final void bq(CharSequence charSequence, ToggleButton toggleButton) {
        toggleButton.setTextOn(charSequence);
        toggleButton.setChecked(toggleButton.isChecked());
    }

    public final void br(float f, TextView textView) {
        textView.setTextSize(0, f);
    }

    public final void bs(int i, TextView textView) {
        textView.setTypeface(Typeface.create(textView.getTypeface(), i), i);
    }

    public final void bt(com.google.android.libraries.navigation.internal.nc.bh bhVar, TextView textView) {
        textView.setTypeface(bhVar.a(textView.getContext()));
    }

    public final void bu(Drawable drawable, AbsSeekBar absSeekBar) {
        absSeekBar.setThumb(drawable);
    }

    public final void bv(Integer num, ImageView imageView) {
        if (num != null) {
            imageView.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_ATOP);
        } else {
            imageView.clearColorFilter();
        }
    }

    public final void bw(Integer num, ImageView imageView) {
        if (num != null) {
            imageView.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        } else {
            imageView.clearColorFilter();
        }
    }

    public final void bx(String str, View view) {
        ViewCompat.setTransitionName(view, str);
    }

    public final void by(com.google.android.libraries.navigation.internal.nc.ap apVar, View view) {
        view.setTranslationX(apVar.a(view.getContext()));
    }

    public final void bz(Number number, View view) {
        view.setTranslationX(number.floatValue());
    }

    public final boolean e(boolean z, View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof RelativeLayout.LayoutParams)) {
            return false;
        }
        ((RelativeLayout.LayoutParams) layoutParams).alignWithParent = z;
        return true;
    }

    public final boolean f(Object obj, View view) {
        ListAdapter listAdapterBG;
        if (view instanceof AbsListView) {
            ListAdapter listAdapterBG2 = bG(obj);
            if (listAdapterBG2 == null) {
                return false;
            }
            AbsListView absListView = (AbsListView) view;
            ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
            if (bH(listAdapter, listAdapterBG2)) {
                ((com.google.android.libraries.navigation.internal.mt.i) listAdapter).a((com.google.android.libraries.navigation.internal.mt.i) listAdapterBG2);
            } else {
                absListView.setAdapter(listAdapterBG2);
            }
            if (listAdapterBG2 instanceof AbsListView.RecyclerListener) {
                absListView.setRecyclerListener((AbsListView.RecyclerListener) listAdapterBG2);
            }
            return true;
        }
        if (view instanceof AutoCompleteTextView) {
            ListAdapter listAdapterBG3 = bG(obj);
            if (listAdapterBG3 == null) {
                return false;
            }
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) view;
            ListAdapter adapter = autoCompleteTextView.getAdapter();
            if (bH(adapter, listAdapterBG3)) {
                ((com.google.android.libraries.navigation.internal.mt.i) adapter).a((com.google.android.libraries.navigation.internal.mt.i) listAdapterBG3);
            } else {
                autoCompleteTextView.setAdapter((com.google.android.libraries.navigation.internal.mt.c) listAdapterBG3);
            }
            return true;
        }
        if (!(view instanceof ViewPager)) {
            if (!(view instanceof ViewGroup) || (listAdapterBG = bG(obj)) == null) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            d(viewGroup);
            for (int i = 0; i < listAdapterBG.getCount(); i++) {
                viewGroup.addView(listAdapterBG.getView(i, null, viewGroup));
            }
            return true;
        }
        if (obj instanceof bs) {
            com.google.android.libraries.navigation.internal.mt.j jVar = new com.google.android.libraries.navigation.internal.mt.j(this.f.l());
            Iterator it2 = ((bs) obj).b.iterator();
            while (it2.hasNext()) {
                jVar.a.f((bu) it2.next());
                jVar.notifyDataSetChanged();
            }
            ((ViewPager) view).setAdapter(jVar);
            return true;
        }
        return false;
    }

    public final boolean g(Object obj, View view) {
        cn cnVarA = cn.a(view);
        bq bqVar = a;
        Boolean bool = true;
        if (obj == null) {
            cnVarA.b(bqVar, null);
        } else if (obj instanceof View.OnClickListener) {
            cnVarA.b(bqVar, new cl(view, obj));
        } else if (obj instanceof cs.b) {
            cnVarA.b(bqVar, new cm(view, obj));
        } else {
            bool = false;
        }
        return bool.booleanValue();
    }

    public final boolean h(Object obj, View view) {
        try {
            if (obj == null) {
                view.setStateListAnimator(null);
                return true;
            }
            if (!(obj instanceof StateListAnimator)) {
                return false;
            }
            view.setStateListAnimator((StateListAnimator) obj);
            return true;
        } catch (NoSuchMethodError unused) {
            return true;
        }
    }

    public final boolean i(int i, View view) {
        try {
            view.setTextAlignment(i);
            return true;
        } catch (NoSuchMethodError unused) {
            if (!(view instanceof TextView)) {
                return false;
            }
            int i2 = 8388611;
            if (i != 2) {
                if (i == 3) {
                    i2 = 8388613;
                } else if (i == 4) {
                    i2 = 1;
                } else if (i != 5) {
                    if (i != 6) {
                        return false;
                    }
                    i2 = 8388613;
                }
            }
            ((TextView) view).setGravity(i2);
            return true;
        }
    }

    public final boolean j(Object obj, Switch r5) {
        if (obj == null) {
            r5.setThumbResource(0);
            return true;
        }
        if (!(obj instanceof Integer)) {
            return false;
        }
        r5.setThumbResource(((Integer) obj).intValue());
        return true;
    }

    public final boolean k(Object obj, View view) {
        if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
            view.setTranslationY(((com.google.android.libraries.navigation.internal.nc.ap) obj).a(view.getContext()));
            return true;
        }
        if (!(obj instanceof Number)) {
            return false;
        }
        view.setTranslationY(((Number) obj).floatValue());
        return true;
    }

    public final boolean l(Object obj, View view) {
        try {
            if (obj instanceof com.google.android.libraries.navigation.internal.nc.ap) {
                view.setTranslationZ(((com.google.android.libraries.navigation.internal.nc.ap) obj).a(view.getContext()));
                return true;
            }
            if (!(obj instanceof Number)) {
                return false;
            }
            view.setTranslationZ(((Number) obj).floatValue());
            return true;
        } catch (NoSuchMethodError unused) {
            return true;
        }
    }

    public final void m(View.AccessibilityDelegate accessibilityDelegate, View view) {
        try {
            view.setAccessibilityDelegate(accessibilityDelegate);
        } catch (NoSuchMethodError unused) {
        }
    }

    public final void n(AccessibilityDelegateCompat accessibilityDelegateCompat, View view) {
        ViewCompat.setAccessibilityDelegate(view, accessibilityDelegateCompat);
    }

    public final void o(boolean z, View view) {
        ViewCompat.setAccessibilityHeading(view, z);
    }

    public final void p(int i, View view) {
        ViewCompat.setAccessibilityLiveRegion(view, i);
    }

    public final void q(CharSequence charSequence, View view) {
        ViewCompat.setAccessibilityPaneTitle(view, charSequence);
    }

    public final void r(cc ccVar, View view) {
        this.f.d();
        view.setAccessibilityTraversalAfter(be.a(view.getRootView(), ccVar).getId());
    }

    public final void s(Integer num, View view) {
        view.setAccessibilityTraversalAfter(num.intValue());
    }

    public final void t(cc ccVar, View view) {
        this.f.d();
        view.setAccessibilityTraversalBefore(be.a(view.getRootView(), ccVar).getId());
    }

    public final void u(Integer num, View view) {
        view.setAccessibilityTraversalBefore(num.intValue());
    }

    public final void v(Number number, View view) {
        view.setAlpha(number == null ? 1.0f : number.floatValue());
    }

    public final void w(final ag agVar, View view) {
        if (agVar == null) {
            view.animate().cancel();
        } else {
            aF(new c() { // from class: com.google.android.libraries.navigation.internal.ms.g
                @Override // com.google.android.libraries.navigation.internal.ms.c
                public final void a(View view2, boolean z) {
                    ck ckVarJ = ck.j(view2);
                    cs csVar = ckVarJ != null ? ckVarJ.j : null;
                    ag agVar2 = agVar;
                    ViewPropertyAnimator viewPropertyAnimatorAnimate = view2.animate();
                    if (agVar2.g != null) {
                        viewPropertyAnimatorAnimate.withEndAction(new ae(agVar2, view2, csVar));
                    }
                    Float f = agVar2.a;
                    if (f != null) {
                        viewPropertyAnimatorAnimate.alpha(f.floatValue());
                    }
                    Float f2 = agVar2.e;
                    if (f2 != null) {
                        viewPropertyAnimatorAnimate.scaleX(f2.floatValue());
                    }
                    Float f3 = agVar2.f;
                    if (f3 != null) {
                        viewPropertyAnimatorAnimate.scaleY(f3.floatValue());
                    }
                    TimeInterpolator timeInterpolator = agVar2.b;
                    if (timeInterpolator != null) {
                        viewPropertyAnimatorAnimate.setInterpolator(timeInterpolator);
                    }
                    dd ddVar = agVar2.c;
                    if (ddVar == null || csVar == null) {
                        viewPropertyAnimatorAnimate.setDuration(300L);
                    } else {
                        viewPropertyAnimatorAnimate.setDuration(((Integer) ddVar.a(csVar)).intValue());
                    }
                    dd ddVar2 = agVar2.d;
                    if (ddVar2 != null && csVar != null) {
                        viewPropertyAnimatorAnimate.setStartDelay(((Long) ddVar2.a(csVar)).longValue());
                    }
                    viewPropertyAnimatorAnimate.start();
                }
            }, view, ck.j(view));
        }
        view.invalidate();
    }

    public final void x(boolean z, ViewGroup viewGroup) {
        viewGroup.setLayoutTransition(z ? new LayoutTransition() : null);
    }

    public final void y(boolean z, View view, ck ckVar) {
        bq bqVar = e;
        View.OnAttachStateChangeListener onAttachStateChangeListener = (View.OnAttachStateChangeListener) ckVar.l(bqVar);
        if (onAttachStateChangeListener == null && z) {
            h hVar = new h();
            view.addOnAttachStateChangeListener(hVar);
            ckVar.o(bqVar, hVar);
        } else {
            if (onAttachStateChangeListener == null || z) {
                return;
            }
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            ckVar.o(bqVar, null);
        }
    }

    public final void z(Integer num, View view) {
        if (num == null) {
            view.setBackgroundResource(0);
        } else {
            view.setBackgroundColor(num.intValue());
        }
    }
}
