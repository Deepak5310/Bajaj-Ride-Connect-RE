package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class u extends x {
    private final int a;

    public u(int i) {
        super(new Object[]{Integer.valueOf(i)}, null);
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final int b(Context context) {
        int i = this.a;
        TypedValue typedValueB = com.google.android.libraries.navigation.internal.my.b.b(i, context);
        if (typedValueB.type == 1) {
            return typedValueB.data;
        }
        if (com.google.android.libraries.navigation.internal.my.b.a(typedValueB)) {
            return typedValueB.data;
        }
        if (typedValueB.type == 3) {
            return ContextCompat.getColor(context, typedValueB.resourceId);
        }
        throw new IllegalArgumentException(String.format("%s holds an unexpected type: %s (TypedValue.type = %d)", com.google.android.libraries.navigation.internal.my.g.a(i, context), typedValueB.coerceToString(), Integer.valueOf(typedValueB.type)));
    }

    @Override // com.google.android.libraries.navigation.internal.nc.x
    public final ColorStateList c(Context context) {
        int i = this.a;
        TypedValue typedValueB = com.google.android.libraries.navigation.internal.my.b.b(i, context);
        if (typedValueB.type == 3) {
            return AppCompatResources.getColorStateList(context, typedValueB.resourceId);
        }
        if (typedValueB.type == 1) {
            return ColorStateList.valueOf(typedValueB.data);
        }
        if (com.google.android.libraries.navigation.internal.my.b.a(typedValueB)) {
            return ColorStateList.valueOf(typedValueB.data);
        }
        throw new IllegalArgumentException(String.format("%s holds an unexpected type: %s (TypedValue.type = %d)", com.google.android.libraries.navigation.internal.my.g.a(i, context), typedValueB.coerceToString(), Integer.valueOf(typedValueB.type)));
    }
}
