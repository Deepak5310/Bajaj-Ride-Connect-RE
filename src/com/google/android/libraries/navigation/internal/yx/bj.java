package com.google.android.libraries.navigation.internal.yx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bj {
    public final s a;
    public final boolean b;
    private final bi c;

    public bj(bi biVar) {
        this(biVar, false, p.a);
    }

    private bj(bi biVar, boolean z, s sVar) {
        this.c = biVar;
        this.b = z;
        this.a = sVar;
    }

    public static bj b(char c) {
        return c(new m(c));
    }

    public static bj c(s sVar) {
        return new bj(new az(sVar));
    }

    public static bj d(String str) {
        ar.b(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? b(str.charAt(0)) : new bj(new bb(str));
    }

    public static bj e(String str) {
        ad adVar = new ad(Pattern.compile(str));
        ar.f(!((ac) adVar.a("")).a.matches(), "The pattern may not match the empty string: %s", adVar);
        return new bj(new bd(adVar));
    }

    public final bj a() {
        return new bj(this.c, true, this.a);
    }

    public final bj f() {
        s sVar = r.b;
        ar.q(sVar);
        return new bj(this.c, this.b, sVar);
    }

    public final Iterable g(CharSequence charSequence) {
        ar.q(charSequence);
        return new bg(this, charSequence);
    }

    public final Iterator h(CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }

    public final List i(CharSequence charSequence) {
        ar.q(charSequence);
        Iterator itH = h(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itH.hasNext()) {
            arrayList.add((String) itH.next());
        }
        return Collections.unmodifiableList(arrayList);
    }
}
