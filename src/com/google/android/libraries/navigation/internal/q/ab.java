package com.google.android.libraries.navigation.internal.q;

import android.view.View;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.google.android.libraries.navigation.internal.ms.cc;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.nc.ap;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    public static final cc a = new cc();
    public static final cc b = new cc();
    public static final com.google.android.libraries.navigation.internal.ms.c c = new aa(false);
    public static final View.AccessibilityDelegate d = new w();

    public static com.google.android.libraries.navigation.internal.ms.c a(boolean z) {
        return new y(true != z ? 8 : 0, true != z ? 0.0f : 1.0f, true != z ? 0.5f : 1.0f, true != z ? NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER : 250);
    }

    public static ap b() {
        return com.google.android.libraries.navigation.internal.nc.a.g(8);
    }

    public static boolean c(View view) {
        Set set = cy.a;
        ck ckVarJ = ck.j(view);
        return (ckVarJ == null ? null : ckVarJ.j) != null;
    }
}
