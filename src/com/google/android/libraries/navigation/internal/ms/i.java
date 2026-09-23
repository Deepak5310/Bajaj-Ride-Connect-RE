package com.google.android.libraries.navigation.internal.ms;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i implements TextWatcher, View.OnAttachStateChangeListener {
    public static final /* synthetic */ int c = 0;
    TextWatcher a;
    public boolean b;
    private final ck d;

    public i(ck ckVar) {
        this.d = ckVar;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        TextWatcher textWatcher;
        if (!this.b || this.d.j == null || (textWatcher = this.a) == null) {
            return;
        }
        textWatcher.afterTextChanged(editable);
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        if (!this.b || this.d.j == null || (textWatcher = this.a) == null) {
            return;
        }
        textWatcher.beforeTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        TextWatcher textWatcher;
        if (!this.b || this.d.j == null || (textWatcher = this.a) == null) {
            return;
        }
        textWatcher.onTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.b = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.b = false;
    }
}
