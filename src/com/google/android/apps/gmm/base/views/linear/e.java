package com.google.android.apps.gmm.base.views.linear;

import android.view.View;
import java.util.Comparator;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
final class e {
    static final Comparator a = Comparator.comparingDouble(new ToDoubleFunction() { // from class: com.google.android.apps.gmm.base.views.linear.c
        @Override // java.util.function.ToDoubleFunction
        public final double applyAsDouble(Object obj) {
            int i = e.e;
            return EllipsizingListLayout.a((View) obj).c;
        }
    }).reversed().thenComparingInt(new ToIntFunction() { // from class: com.google.android.apps.gmm.base.views.linear.d
        @Override // java.util.function.ToIntFunction
        public final int applyAsInt(Object obj) {
            int i = e.e;
            return EllipsizingListLayout.a((View) obj).b;
        }
    });
    public static final /* synthetic */ int e = 0;
    int b;
    float c;
    boolean d = false;
}
