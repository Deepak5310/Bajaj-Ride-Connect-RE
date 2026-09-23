package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x extends ah {
    public x(Object[] objArr, byte[] bArr) {
        super(objArr, null);
    }

    @Override // com.google.android.libraries.navigation.internal.nc.ah
    public Drawable a(Context context) {
        return new ColorDrawable(b(context));
    }

    public abstract int b(Context context);

    public abstract ColorStateList c(Context context);

    public x(Object[] objArr) {
        super(objArr);
    }
}
