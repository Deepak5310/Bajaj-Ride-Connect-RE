package com.google.android.libraries.geo.navcore.ui.header.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class NextTurnTextView extends AppCompatTextView {
    public static final /* synthetic */ int a = 0;
    private final com.google.android.libraries.navigation.internal.hf.n b;
    private com.google.android.libraries.navigation.internal.bl.d.a c;
    private int d;
    private float e;
    private float f;
    private float g;

    public NextTurnTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.c = null;
        this.d = -1;
        this.e = 1.8f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.b = new com.google.android.libraries.navigation.internal.hf.n(context.getResources());
    }

    private final void a() {
        Drawable drawableD = com.google.android.libraries.navigation.internal.bl.d.d(this.c, this.d);
        if (drawableD == null) {
            setText("");
            return;
        }
        Spannable spannableA = this.b.a(drawableD, this.e);
        com.google.android.libraries.navigation.internal.hf.l lVarE = this.b.e(com.google.android.libraries.navigation.internal.dw.h.I);
        lVarE.a(spannableA);
        setText(lVarE.b());
    }

    public final void setColor(int i) {
        this.d = i;
        a();
    }

    public final void setManeuver(com.google.android.libraries.navigation.internal.bl.d.a aVar) {
        this.c = aVar;
        a();
    }

    public final void setStyle(i iVar) {
        float f = iVar.a;
        this.e = 1.4f;
        this.f = 0.0f;
        this.g = 0.0f;
        a();
    }
}
