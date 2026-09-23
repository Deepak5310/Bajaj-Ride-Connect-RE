package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class ah extends Exception {
    public ah(aj ajVar, String str, int i) {
        super(String.format(Locale.US, "More %s styles in %s than limit (%d)", str, ajVar.b, Integer.valueOf(i)));
    }
}
