package com.google.android.libraries.navigation.internal.mz;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends LinearSmoothScroller {
    public c(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.LinearSmoothScroller
    protected final int getVerticalSnapPreference() {
        return -1;
    }
}
