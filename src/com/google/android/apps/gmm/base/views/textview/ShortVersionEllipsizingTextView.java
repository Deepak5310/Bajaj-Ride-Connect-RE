package com.google.android.apps.gmm.base.views.textview;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes3.dex */
public final class ShortVersionEllipsizingTextView extends AppCompatTextView {
    public CharSequence a;
    private CharSequence b;

    public ShortVersionEllipsizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected final void onMeasure(int i, int i2) {
        Layout layout;
        int lineCount;
        CharSequence charSequence = this.b;
        if (charSequence != null) {
            super.setText(charSequence);
        }
        super.onMeasure(i, i2);
        if (length() != 0 && (layout = getLayout()) != null && (lineCount = layout.getLineCount()) > 0 && layout.getEllipsisCount(lineCount - 1) > 0) {
            super.setText(this.a);
            super.onMeasure(i, i2);
        }
    }

    public final void setOriginalText(CharSequence charSequence) {
        this.b = charSequence;
        super.setText(charSequence);
    }

    public ShortVersionEllipsizingTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
