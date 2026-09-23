package com.google.android.libraries.navigation.internal.ac;

import android.view.View;
import com.google.android.libraries.navigation.internal.ms.ck;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements View.OnLayoutChangeListener {
    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Number number = (Number) ck.j(view).l(f.a);
        view.setTranslationY(view.getMeasuredHeight() * (number == null ? 0.0f : number.floatValue()));
    }
}
