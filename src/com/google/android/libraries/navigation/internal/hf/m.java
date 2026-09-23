package com.google.android.libraries.navigation.internal.hf;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ClickableSpan;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class m {
    Object b;
    ClickableSpan d;
    int e = 1;
    public n.a c = new n.a();

    public m(Object obj) {
        this.b = obj;
    }

    public final Spannable b() {
        return c("%s");
    }

    public final SpannableStringBuilder c(String str) {
        SpannableStringBuilder spannableStringBuilder;
        Object obj = this.b;
        if (obj instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) obj;
        } else {
            spannableStringBuilder = (str.equals("%s") && (obj instanceof CharSequence)) ? new SpannableStringBuilder((CharSequence) obj) : new SpannableStringBuilder(String.format(str, obj));
        }
        this.c.a(spannableStringBuilder, this.e, 0, spannableStringBuilder.length());
        n.a aVar = this.c;
        aVar.a.clear();
        aVar.b.clear();
        ClickableSpan clickableSpan = this.d;
        if (clickableSpan != null) {
            spannableStringBuilder.setSpan(clickableSpan, 0, spannableStringBuilder.length(), 33);
        }
        return spannableStringBuilder;
    }

    public final void d(n.a aVar) {
        n.a aVar2 = this.c;
        aVar2.b(aVar);
        this.c = aVar2;
    }

    public final void e(m mVar) {
        SpannableStringBuilder spannableStringBuilderC = c("%s");
        spannableStringBuilderC.append((CharSequence) mVar.b());
        this.b = spannableStringBuilderC;
    }

    public final void f(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilderC = c("%s");
        spannableStringBuilderC.append(charSequence);
        this.b = spannableStringBuilderC;
    }

    public final void g() {
        n.a aVar = this.c;
        aVar.c();
        this.c = aVar;
    }

    public final void h(ClickableSpan clickableSpan) {
        ar.l(this.d == null, "Cannot add multiple click listeners to the same span.");
        this.d = clickableSpan;
    }

    public final void i(int i) {
        n.a aVar = this.c;
        aVar.d(i);
        this.c = aVar;
    }
}
