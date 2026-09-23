package com.google.android.libraries.geo.mapcore.internal.ui;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.google.android.libraries.navigation.internal.agi.ha;
import com.google.android.libraries.navigation.internal.agi.hc;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class k {
    public final Resources a;
    public TextView b;
    private final StringBuilder c = new StringBuilder();

    public k(Resources resources) {
        this.a = resources;
    }

    public final String a(Set set) {
        if (set.isEmpty()) {
            return "";
        }
        StringBuilder sb = this.c;
        if (sb.length() > 0) {
            sb.delete(0, sb.length());
        }
        ha haVar = new ha((hc) set);
        boolean z = true;
        while (haVar.hasNext()) {
            if (!z) {
                this.c.append(", ");
            }
            this.c.append((String) haVar.next());
            z = false;
        }
        return this.c.toString();
    }

    public final void b(final TextView textView, final String str, final int i, final int i2) {
        textView.post(new Runnable() { // from class: com.google.android.libraries.geo.mapcore.internal.ui.j
            @Override // java.lang.Runnable
            public final void run() {
                k kVar = this.a;
                Resources resources = kVar.a;
                Resources resources2 = kVar.a;
                int i3 = i2;
                int color = resources.getColor(i);
                int color2 = resources2.getColor(i3);
                float f = kVar.a.getDisplayMetrics().density;
                TextView textView2 = textView;
                textView2.setTextColor(color);
                l lVar = new l(color2, f, textView2.getPaint());
                String str2 = str;
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
                spannableStringBuilder.setSpan(lVar, 0, str2.length(), 33);
                textView2.setText(spannableStringBuilder);
            }
        });
    }
}
