package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class w extends x {
    private final j a;

    public w(j jVar) {
        super(new Object[]{jVar});
        this.a = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final int b(Context context) {
        return ContextCompat.getColor(context, this.a.g);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final ColorStateList c(Context context) {
        return AppCompatResources.getColorStateList(context, this.a.g);
    }
}
