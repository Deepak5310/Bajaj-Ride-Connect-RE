package com.google.android.libraries.navigation.internal.yx;

import java.io.IOException;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ah {
    public final String c;

    public ah(ah ahVar) {
        this.c = ahVar.c;
    }

    public ah(String str) {
        ar.q(str);
        this.c = str;
    }

    public static ah e(char c) {
        return new ah(String.valueOf(c));
    }

    public CharSequence a(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public ah b() {
        return new ae(this, this);
    }

    public void c(Appendable appendable, Iterator it2) throws IOException {
        ar.q(appendable);
        if (it2.hasNext()) {
            appendable.append(a(it2.next()));
            while (it2.hasNext()) {
                appendable.append(this.c);
                appendable.append(a(it2.next()));
            }
        }
    }

    public final ag d(String str) {
        return new ag(this, str);
    }

    public final String f(Iterable iterable) {
        return g(iterable.iterator());
    }

    public final String g(Iterator it2) {
        StringBuilder sb = new StringBuilder();
        i(sb, it2);
        return sb.toString();
    }

    public final StringBuilder h(StringBuilder sb, Iterable iterable) {
        i(sb, iterable.iterator());
        return sb;
    }

    public final void i(StringBuilder sb, Iterator it2) {
        try {
            c(sb, it2);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
