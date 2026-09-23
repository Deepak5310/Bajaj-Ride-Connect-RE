package com.google.android.libraries.navigation.internal.sy;

import android.content.Context;
import com.google.android.libraries.navigation.internal.hh.i;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static com.google.android.libraries.navigation.internal.bv.d a;
    public final Context b;
    public final com.google.android.libraries.navigation.internal.by.b c;
    public final i d;

    public b(i iVar, Context context, Executor executor) {
        ar.r(iVar, PlaceTypes.STORAGE);
        this.d = iVar;
        this.b = context;
        this.c = new com.google.android.libraries.navigation.internal.by.b(context, executor);
    }
}
