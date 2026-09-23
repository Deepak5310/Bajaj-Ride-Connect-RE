package com.google.android.libraries.navigation.internal.abh;

import android.view.View;
import android.widget.ImageView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fc {
    public final ImageView a;

    public fc(ImageView imageView) {
        this.a = imageView;
    }

    public final void a(View.OnClickListener onClickListener) {
        this.a.setOnClickListener(onClickListener);
    }
}
