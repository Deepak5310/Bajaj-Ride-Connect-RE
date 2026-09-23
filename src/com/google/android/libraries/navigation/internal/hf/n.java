package com.google.android.libraries.navigation.internal.hf;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import java.util.ArrayList;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    public static final Pattern a = Pattern.compile("%(\\d+\\$)?([-#+ 0,(\\<]*)?(\\d+)?(\\.\\d+)?([tT])?([a-zA-Z%])");
    private final Resources b;

    /* JADX INFO: compiled from: PG */
    public class a {
        public final ArrayList a = new ArrayList();
        final ArrayList b = new ArrayList();

        public final void a(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            for (int i4 = 0; i4 < size; i4++) {
                spannableStringBuilder.setSpan(CharacterStyle.wrap((CharacterStyle) arrayList.get(i4)), i2, i3, (i << 16) | 33);
            }
        }

        public final void b(a aVar) {
            this.a.addAll(aVar.a);
            this.b.addAll(aVar.b);
        }

        public final void c() {
            this.a.add(new StyleSpan(1));
        }

        public final void d(int i) {
            this.a.add(new ForegroundColorSpan(i));
        }

        public final void e(float f) {
            this.a.add(new RelativeSizeSpan(f));
        }
    }

    public n(Resources resources) {
        this.b = resources;
    }

    public static final Spannable g(com.google.android.libraries.navigation.internal.nv.a aVar, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(aVar, 0, str.length(), 33);
        return spannableStringBuilder;
    }

    public final Spannable a(Drawable drawable, float f) {
        return c(drawable, f, " ");
    }

    public final Spannable b(Drawable drawable, float f, float f2) {
        return d(drawable, 0.0f, 0.0f, " ");
    }

    public final Spannable c(Drawable drawable, float f, String str) {
        return g(new com.google.android.libraries.navigation.internal.nv.a(drawable, f), str);
    }

    public final Spannable d(Drawable drawable, float f, float f2, String str) {
        return g(new com.google.android.libraries.navigation.internal.nv.a(drawable, f, f2), str);
    }

    public final l e(int i) {
        return new l(this, this.b.getString(i));
    }

    public final l f(int i, int i2) {
        return new l(this, this.b.getQuantityString(i, i2));
    }
}
