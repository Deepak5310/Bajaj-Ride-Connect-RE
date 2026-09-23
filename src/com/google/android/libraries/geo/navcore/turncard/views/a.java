package com.google.android.libraries.geo.navcore.turncard.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends LinearLayout.LayoutParams {
    public int a;

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = Integer.MAX_VALUE;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.google.android.libraries.navigation.internal.ty.a.a);
        this.a = typedArrayObtainStyledAttributes.getInt(com.google.android.libraries.navigation.internal.ty.a.b, Integer.MAX_VALUE);
        typedArrayObtainStyledAttributes.recycle();
    }
}
