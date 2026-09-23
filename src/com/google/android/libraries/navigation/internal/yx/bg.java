package com.google.android.libraries.navigation.internal.yx;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bg implements Iterable {
    final /* synthetic */ CharSequence a;
    final /* synthetic */ bj b;

    public bg(bj bjVar, CharSequence charSequence) {
        this.a = charSequence;
        this.b = bjVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.b.h(this.a);
    }

    public final String toString() {
        ah ahVar = new ah(", ");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        StringBuilder sbH = ahVar.h(sb, this);
        sbH.append(']');
        return sbH.toString();
    }
}
