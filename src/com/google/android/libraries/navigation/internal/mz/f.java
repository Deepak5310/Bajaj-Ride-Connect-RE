package com.google.android.libraries.navigation.internal.mz;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class f extends h {
    public f(Object... objArr) {
        super(objArr);
    }

    @Override // com.google.android.libraries.navigation.internal.mz.h
    public final RecyclerView.LayoutManager a(Context context) {
        return new GridLayoutManager(context, 2);
    }
}
