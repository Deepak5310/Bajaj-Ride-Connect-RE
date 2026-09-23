package com.swmansion.rnscreens.ext;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.views.scroll.ReactHorizontalScrollView;
import com.facebook.react.views.scroll.ReactScrollView;
import com.swmansion.rnscreens.ScreenStack;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ViewExt.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000¢\u0006\u0002\u0010\u0005\u001a\u000e\u0010\u0006\u001a\u0004\u0018\u00010\u0002*\u00020\u0002H\u0000\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0000¨\u0006\n"}, d2 = {"isInsideScrollViewWithRemoveClippedSubviews", "", "Landroid/view/View;", "maybeBgColor", "", "(Landroid/view/View;)Ljava/lang/Integer;", "parentAsView", "parentAsViewGroup", "Landroid/view/ViewGroup;", "recycle", "react-native-screens_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ViewExtKt {
    public static final View parentAsView(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    public static final ViewGroup parentAsViewGroup(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    public static final View recycle(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup viewGroupParentAsViewGroup = parentAsViewGroup(view);
        if (viewGroupParentAsViewGroup != null) {
            viewGroupParentAsViewGroup.endViewTransition(view);
            viewGroupParentAsViewGroup.removeView(view);
        }
        view.setVisibility(0);
        return view;
    }

    public static final Integer maybeBgColor(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Drawable background = view.getBackground();
        if (background instanceof ColorDrawable) {
            return Integer.valueOf(((ColorDrawable) background).getColor());
        }
        return null;
    }

    public static final boolean isInsideScrollViewWithRemoveClippedSubviews(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        if (!(view instanceof ReactHorizontalScrollView) && !(view instanceof ReactScrollView)) {
            ViewParent parent = view.getParent();
            while ((parent instanceof ViewGroup) && !(parent instanceof ScreenStack)) {
                ViewGroup viewGroup = (ViewGroup) parent;
                if (viewGroup instanceof ReactHorizontalScrollView) {
                    return ((ReactHorizontalScrollView) parent).getRemoveClippedSubviews();
                }
                if (viewGroup instanceof ReactScrollView) {
                    return ((ReactScrollView) parent).getRemoveClippedSubviews();
                }
                parent = viewGroup.getParent();
            }
        }
        return false;
    }
}
