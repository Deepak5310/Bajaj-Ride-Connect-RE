package com.google.android.libraries.geo.navcore.ui.header.views;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.libraries.navigation.internal.ms.dd;
import com.google.android.libraries.navigation.internal.mx.ac;
import com.google.android.libraries.navigation.internal.mx.w;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ManeuverImageView extends AppCompatImageView {
    private com.google.android.libraries.navigation.internal.bl.d.a a;
    private int b;

    public ManeuverImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -1;
    }

    public static w a(dd ddVar) {
        return new ac(b.MANEUVER, ddVar, a.a);
    }

    public static w b(dd ddVar) {
        return new ac(b.MANEUVER_COLOR, ddVar, a.a);
    }

    private final void c() {
        com.google.android.libraries.navigation.internal.bl.d.a aVar = this.a;
        if (aVar == null) {
            setImageDrawable(null);
        } else {
            setImageDrawable(com.google.android.libraries.navigation.internal.bl.d.d(aVar, this.b));
        }
    }

    public final void setColor(int i) {
        this.b = i;
        c();
    }

    public final void setManeuver(com.google.android.libraries.navigation.internal.bl.d.a aVar) {
        this.a = aVar;
        c();
    }
}
