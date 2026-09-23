package com.google.android.libraries.navigation.internal.ab;

import android.view.View;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.jy.t;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final t a;

    public a(t tVar) {
        this.a = tVar;
    }

    public static final void b(View view) {
        c cVar = (c) view.getTag(c.a);
        if (cVar != null) {
            view.setTag(c.a, null);
            cVar.b();
            c.a(view);
            view.removeOnAttachStateChangeListener(cVar);
        }
    }

    public final void a(View view) {
        c cVar = (c) view.getTag(c.a);
        if (cVar == null) {
            c cVar2 = new c(view, this.a);
            view.setTag(c.a, cVar2);
            view.addOnAttachStateChangeListener(cVar2);
            if (ViewCompat.isAttachedToWindow(view)) {
                cVar2.onViewAttachedToWindow(view);
            }
            cVar = cVar2;
        }
        cVar.b = false;
    }
}
