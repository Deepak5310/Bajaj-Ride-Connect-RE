package com.google.android.libraries.navigation.internal.aj;

import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.libraries.navigation.internal.gz.i;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements cx {
    final c a;

    public d(c cVar) {
        this.a = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        if (!(cwVar instanceof com.google.android.libraries.navigation.internal.ad.b) || ((com.google.android.libraries.navigation.internal.ad.b) cwVar).ordinal() != 6) {
            return false;
        }
        View view = ckVar.c;
        if (!(view instanceof View)) {
            return false;
        }
        if (obj != null && obj != c.a) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            ViewTreeObserver.OnPreDrawListener onPreDrawListener = (ViewTreeObserver.OnPreDrawListener) ckVar.l(c.b);
            if (onPreDrawListener != null) {
                view.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener);
            }
            a aVar = new a(view, ckVar, cVar);
            view.getViewTreeObserver().addOnPreDrawListener(aVar);
            ckVar.o(c.b, aVar);
            return true;
        }
        view.animate().cancel();
        view.setTranslationX(c.a.c.a(view.getContext()));
        view.setTranslationY(c.a.e.a(view.getContext()));
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
        i.d(view);
        view.setRotation(0.0f);
        ViewTreeObserver.OnPreDrawListener onPreDrawListener2 = (ViewTreeObserver.OnPreDrawListener) ckVar.l(c.b);
        if (onPreDrawListener2 == null) {
            return true;
        }
        view.getViewTreeObserver().removeOnPreDrawListener(onPreDrawListener2);
        ckVar.o(c.b, null);
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        return false;
    }
}
