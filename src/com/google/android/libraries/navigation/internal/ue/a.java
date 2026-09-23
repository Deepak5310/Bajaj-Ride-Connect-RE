package com.google.android.libraries.navigation.internal.ue;

import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class a {
    public static b a(f fVar) {
        boolean zY = fVar.y(ab.ac, false);
        boolean zY2 = fVar.y(ab.ab, false);
        if (zY) {
            return b.OVERVIEW;
        }
        return zY2 ? b.NORTH_UP : b.HEADING_UP;
    }
}
