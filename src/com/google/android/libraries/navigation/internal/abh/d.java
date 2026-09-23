package com.google.android.libraries.navigation.internal.abh;

import android.os.Build;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final /* synthetic */ int b = 0;
    private static final Set c = new HashSet(Arrays.asList("anthias", "carp", "smelt", "sparrow", "sprat", "tetra", "wren"));
    public final boolean a;

    public d(c cVar) {
        if (cVar.a.contains("IsLowBitDisplay")) {
            this.a = cVar.a.getBoolean("IsLowBitDisplay", false);
        } else {
            this.a = c.contains(Build.DEVICE);
        }
    }
}
