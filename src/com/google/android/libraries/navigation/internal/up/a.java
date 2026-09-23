package com.google.android.libraries.navigation.internal.up;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bs;
import com.google.android.libraries.navigation.internal.hf.m;
import com.google.android.libraries.navigation.internal.hf.n;
import com.google.android.libraries.navigation.internal.qy.i;
import com.google.android.libraries.navigation.internal.qz.k;
import com.google.android.libraries.navigation.internal.yx.aq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements f {
    private static final n.a a;
    private final int b;
    private final int c;
    private final int d;
    private final boolean e;
    private final TextPaint f;
    private final boolean g;
    private final int h;
    private final float i;
    private final float j;
    private final float k;
    private final int l;
    private final com.google.android.libraries.navigation.internal.afo.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final bm.a f621n;
    private final boolean o;
    private final SpannableStringBuilder p;
    private final n.a q;
    private final n r;
    private final List s;
    private boolean t;
    private boolean u;

    static {
        n.a aVar = new n.a();
        aVar.c();
        a = aVar;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0024  */
    public a(Context context, int i, int i2, int i3, boolean z, TextPaint textPaint, boolean z2, int i4, float f, float f2, float f3, int i5, com.google.android.libraries.navigation.internal.afo.a aVar, bm.a aVar2) {
        boolean z3;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = z;
        this.f = textPaint;
        this.g = z2;
        this.h = i4;
        this.i = f;
        this.j = f2;
        this.k = f3;
        this.l = i5;
        this.m = aVar;
        this.f621n = aVar2;
        if (i <= i2) {
            z3 = i > 1;
        }
        this.o = z3;
        n.a aVar3 = new n.a();
        aVar3.e(f2);
        aVar3.d(i4);
        this.q = aVar3;
        this.t = false;
        this.u = false;
        this.p = new SpannableStringBuilder();
        if (context != null) {
            this.r = new n(context.getResources());
        } else {
            this.r = null;
        }
        ArrayList arrayList = new ArrayList();
        this.s = arrayList;
        arrayList.add(new SpannableStringBuilder());
    }

    public static CharSequence k(com.google.android.libraries.navigation.internal.hf.c cVar, int i, bm.a aVar) {
        return cVar.g(i, aVar, a, null);
    }

    public static String n(g gVar, bq bqVar) {
        e eVarF = g.f(gVar.e, bqVar, 3);
        a aVar = new a(null, eVarF.a.size(), 1, 0, true, null, true, 0, 1.0f, 1.0f, 1.0f, 0, null, null);
        gVar.e(eVarF.a, eVarF.c, false, null, aVar);
        ev evVarD = aVar.d();
        return evVarD.isEmpty() ? "" : ((CharSequence) evVarD.get(0)).toString();
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0060  */
    public static Spannable o(Context context, bq bqVar) {
        boolean z;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(bqVar.p);
        com.google.android.libraries.navigation.internal.qy.h hVarP = ((i) com.google.android.libraries.navigation.internal.ii.b.a(i.class)).p();
        boolean z2 = false;
        bs[] bsVarArr = (bs[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), bs.class);
        int length = bsVarArr.length;
        int i = 0;
        while (i < length) {
            bs bsVar = bsVarArr[i];
            String strF = bsVar.f();
            Drawable drawableE = null;
            if (strF != null && hVarP != null) {
                k kVarD = hVarP.d(strF, String.valueOf(g.class.getName()).concat("#formatCuesWithIcons()"), null);
                if (kVarD.p() && (kVarD.a() == 3 || kVarD.a() == 6)) {
                    drawableE = kVarD.e(context);
                }
            }
            if (drawableE != null) {
                int spanStart = spannableStringBuilder.getSpanStart(bsVar);
                int spanEnd = spannableStringBuilder.getSpanEnd(bsVar);
                a aVar = new a(context, 1, 1, -1, true, null, true, 0, 1.0f, 1.0f, 1.0f, 0, null, null);
                g.b(bsVar, aVar, drawableE, strF);
                z = false;
                spannableStringBuilder.replace(spanStart, spanEnd, (CharSequence) aVar.d().get(0));
            } else {
                z = z2;
                spannableStringBuilder.setSpan(new StyleSpan(1), spannableStringBuilder.getSpanStart(bsVar), spannableStringBuilder.getSpanEnd(bsVar), 33);
            }
            spannableStringBuilder.removeSpan(bsVar);
            i++;
            z2 = z;
        }
        return spannableStringBuilder;
    }

    private final void p(String str, String str2, Drawable drawable) {
        n nVar = this.r;
        if (nVar == null) {
            return;
        }
        Spannable spannableC = nVar.c(drawable, 1.2f, str);
        if (aq.c(str2)) {
            s(spannableC, true);
            return;
        }
        m mVar = new m(str2);
        float f = this.k;
        n.a aVar = mVar.c;
        aVar.e(f);
        mVar.c = aVar;
        if (this.g) {
            mVar.g();
        }
        m mVar2 = new m(spannableC);
        mVar2.f(StringUtils.SPACE);
        mVar2.e(mVar);
        s(mVar2.b(), true);
    }

    private final void q(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        r(spannableStringBuilder, 0, spannableStringBuilder.length(), this.h, this.j);
        t(spannableStringBuilder, false, false);
    }

    private static void r(Spannable spannable, int i, int i2, int i3, float f) {
        spannable.setSpan(new RelativeSizeSpan(f), i, i2, 33);
        spannable.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
    }

    private final void s(CharSequence charSequence, boolean z) {
        t(charSequence, z, true);
    }

    private final void t(CharSequence charSequence, boolean z, boolean z2) {
        TextPaint textPaint;
        if (this.u) {
            if (z2) {
                return;
            } else {
                z2 = false;
            }
        }
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) gs.d(this.s);
        int length = spannableStringBuilder.length();
        if (this.p.length() > 0) {
            spannableStringBuilder.append((CharSequence) this.p);
            this.p.clear();
        }
        spannableStringBuilder.append(charSequence);
        if (this.o && z) {
            if (this.s.size() < this.b) {
                this.s.add(new SpannableStringBuilder());
                this.t = false;
                return;
            }
        }
        if (!z2 || !this.t || (textPaint = this.f) == null || Layout.getDesiredWidth(spannableStringBuilder, textPaint) <= this.d) {
            this.t |= z;
            return;
        }
        if (this.s.size() >= this.c) {
            if (!this.e) {
                spannableStringBuilder.delete(length, spannableStringBuilder.length());
            }
            this.u = true;
        } else {
            this.s.add(new SpannableStringBuilder());
            this.t = false;
            spannableStringBuilder.delete(length, spannableStringBuilder.length());
            s(charSequence, z);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void a(String str) {
        if (this.o) {
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        if (!str.trim().isEmpty()) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan(this.h), 0, spannableStringBuilder.length(), 33);
        }
        this.p.append((CharSequence) spannableStringBuilder);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void b(int i) {
        com.google.android.libraries.navigation.internal.afo.a aVar = this.m;
        if (aVar == null || this.f621n == null) {
            return;
        }
        s(((com.google.android.libraries.navigation.internal.hf.c) aVar.a()).g(i, this.f621n, this.g ? a : null, this.q), true);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void c(String str, String str2, hs hsVar, Drawable drawable) {
        p(str, str2, drawable);
    }

    public final ev d() {
        return ev.o(this.s);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void e(String str) {
        s(str, false);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void f(String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        spannableStringBuilder.setSpan(new RelativeSizeSpan(this.j), 0, spannableStringBuilder.length(), 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.h), 0, spannableStringBuilder.length(), 33);
        s(spannableStringBuilder, false);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void g(com.google.android.libraries.navigation.internal.bl.d.a aVar) {
        if (this.r == null) {
            return;
        }
        s(this.r.a(com.google.android.libraries.navigation.internal.bl.d.b(aVar, this.l), 1.0f), true);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void h(String str) {
        q(str);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void i(String str) {
        q(str);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void j(String str, String str2, String str3, Drawable drawable) {
        p(str2, str3, drawable);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void l(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!aq.c(str)) {
            spannableStringBuilder.append((CharSequence) str);
            r(spannableStringBuilder, 0, spannableStringBuilder.length(), this.h, this.i);
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str2);
        if (this.g) {
            spannableStringBuilder.setSpan(new StyleSpan(1), length, spannableStringBuilder.length(), 33);
        }
        int length2 = spannableStringBuilder.length();
        if (!aq.c(str3)) {
            spannableStringBuilder.append((CharSequence) str3);
            r(spannableStringBuilder, length2, spannableStringBuilder.length(), this.h, this.i);
        }
        s(spannableStringBuilder, true);
    }

    @Override // com.google.android.libraries.navigation.internal.up.f
    public final void m(String str, String str2, String str3) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!aq.c(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        int length = spannableStringBuilder.length();
        spannableStringBuilder.append((CharSequence) str2);
        if (this.g) {
            spannableStringBuilder.setSpan(new StyleSpan(1), length, spannableStringBuilder.length(), 33);
        }
        if (!aq.c(str3)) {
            spannableStringBuilder.append((CharSequence) str3);
        }
        s(spannableStringBuilder, true);
    }
}
