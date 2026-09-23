package com.google.android.libraries.navigation.internal.mt;

import android.animation.LayoutTransition;
import android.content.res.ColorStateList;
import android.graphics.Picture;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import android.view.View;
import android.view.animation.Animation;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.ay;
import com.google.android.libraries.navigation.internal.nc.bd;
import com.google.android.libraries.navigation.internal.nc.t;
import com.google.android.libraries.navigation.internal.nc.x;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final a a = new a();

    private static final void x(View view, Drawable drawable) {
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        drawable.setState(view.getDrawableState());
        drawable.jumpToCurrentState();
    }

    public final float a(View view, ap apVar) {
        return apVar.a(view.getContext());
    }

    public final int b(View view, x xVar) {
        return xVar.b(view.getContext());
    }

    public final int c(View view, ap apVar) {
        return apVar.d(view.getContext());
    }

    public final int d(View view, ap apVar) {
        return apVar.e(view.getContext());
    }

    public final int e(View view, ap apVar) {
        return d(view, apVar);
    }

    public final LayoutTransition f(View view, ay ayVar) {
        view.getContext();
        LayoutTransition layoutTransitionA = ayVar.a();
        ar.q(layoutTransitionA);
        return layoutTransitionA;
    }

    public final ColorStateList g(View view, x xVar) {
        return xVar == null ? ColorStateList.valueOf(0) : xVar.c(view.getContext());
    }

    public final Drawable h(View view, int i) {
        if (i == 0) {
            return null;
        }
        Drawable drawable = view.getResources().getDrawable(i);
        x(view, drawable);
        ar.q(drawable);
        return drawable;
    }

    public final Drawable i(View view, Picture picture) {
        PictureDrawable pictureDrawable = new PictureDrawable(picture);
        x(view, pictureDrawable);
        return pictureDrawable;
    }

    public final Drawable j(View view, Drawable drawable) {
        x(view, drawable);
        return drawable;
    }

    public final Drawable k(View view, ah ahVar) {
        Drawable drawableA = ahVar.a(view.getContext());
        x(view, drawableA);
        ar.q(drawableA);
        return drawableA;
    }

    public final CharSequence l(View view, int i) {
        return view.getResources().getText(i);
    }

    public final CharSequence m(View view, t tVar) {
        return tVar.b(view.getContext());
    }

    public final Animation n(View view, com.google.android.libraries.navigation.internal.nc.k kVar) {
        return kVar.a(view.getContext());
    }

    public final int o(Number number) {
        return number.intValue();
    }

    public final ColorStateList p(Number number) {
        return ColorStateList.valueOf(number.intValue());
    }

    public final float q(Number number) {
        return number.floatValue();
    }

    public final int r(Integer num) {
        return num.intValue();
    }

    public final int s(Integer num) {
        return num.intValue();
    }

    public final int t(bd bdVar) {
        return bdVar.a();
    }

    public final int u(Integer num) {
        return num.intValue();
    }

    public final void v(Number number) {
        ar.l(number == null, "Previous converters should have matched.");
    }

    public final void w(Integer num) {
        ar.l(num == null, "Previous converters should have matched.");
    }
}
