package com.google.android.libraries.navigation.internal.yz;

import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hg extends nh {
    final /* synthetic */ hl a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hg(ListIterator listIterator, hl hlVar) {
        super(listIterator);
        this.a = hlVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ng
    public final /* bridge */ /* synthetic */ Object a(Object obj) {
        return ((Map.Entry) obj).getValue();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.nh, java.util.ListIterator
    public final void set(Object obj) {
        hl hlVar = this.a;
        com.google.android.libraries.navigation.internal.yx.ar.k(hlVar.c != null);
        hlVar.c.b = obj;
    }
}
