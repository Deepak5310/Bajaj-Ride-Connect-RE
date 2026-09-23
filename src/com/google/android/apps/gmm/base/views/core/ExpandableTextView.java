package com.google.android.apps.gmm.base.views.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.libraries.navigation.internal.f.j;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class ExpandableTextView extends AppCompatTextView {
    public boolean a;
    public boolean b;
    public int c;

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.i);
        this.c = typedArrayObtainStyledAttributes.getInt(j.j, 0);
        typedArrayObtainStyledAttributes.recycle();
        setOnClickListener(new a(this));
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        setMaxLines(this.b ? Integer.MAX_VALUE : this.c);
    }

    public final void setExpanded$ar$ds(boolean z) {
        if (this.a || z == this.b) {
            return;
        }
        this.b = z;
        setMaxLines(z ? Integer.MAX_VALUE : this.c);
    }
}
