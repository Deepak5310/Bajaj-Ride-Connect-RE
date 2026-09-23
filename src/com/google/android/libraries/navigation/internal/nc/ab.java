package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab extends ac {
    @Override // com.google.android.libraries.navigation.internal.nc.ap
    public final float a(Context context) {
        return context.getResources().getConfiguration().screenWidthDp * context.getResources().getDisplayMetrics().density;
    }
}
