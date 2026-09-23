package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.content.res.ColorStateList;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ae extends x {
    public final int a;

    public ae(int i) {
        super(new Object[]{Integer.valueOf(i)});
        this.a = i;
    }

    public static ae d(int i) {
        return new ae(i | ViewCompat.MEASURED_STATE_MASK);
    }

    public static ae e() {
        return new ae(0);
    }

    public static ae g() {
        return new ae(-1);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final int b(Context context) {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final ColorStateList c(Context context) {
        return ColorStateList.valueOf(this.a);
    }
}
