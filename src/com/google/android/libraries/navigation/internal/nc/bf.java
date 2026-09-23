package com.google.android.libraries.navigation.internal.nc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import androidx.core.content.res.ResourcesCompat;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf extends j implements bh {
    private final Typeface h;

    public bf(int i, Typeface typeface) {
        super(i);
        this.h = typeface;
    }

    @Override // com.google.android.libraries.navigation.internal.nc.bh
    public final Typeface a(Context context) {
        try {
            Typeface font = ResourcesCompat.getFont(context, this.g);
            return font != null ? font : this.h;
        } catch (Resources.NotFoundException unused) {
            return this.h;
        }
    }
}
