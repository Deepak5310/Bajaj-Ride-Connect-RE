package com.h6ah4i.android.widget.advrecyclerview.swipeable;

import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
class InternalHelperKK {
    InternalHelperKK() {
    }

    public static void clearViewPropertyAnimatorUpdateListener(View view) {
        view.animate().setUpdateListener(null);
    }
}
