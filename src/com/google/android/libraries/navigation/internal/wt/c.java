package com.google.android.libraries.navigation.internal.wt;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements Iterable {
    public int a = 0;
    public int b = 0;
    public b c = null;
    public b d = null;

    public final Object a(b bVar) {
        if (bVar == null) {
            throw new NoSuchElementException();
        }
        this.a--;
        this.b++;
        b bVar2 = bVar.c;
        b bVar3 = bVar.b;
        if (bVar2 != null) {
            bVar2.b = bVar3;
        } else {
            this.c = bVar3;
        }
        b bVar4 = bVar.b;
        if (bVar4 != null) {
            bVar4.c = bVar2;
        } else {
            this.d = bVar2;
        }
        bVar.b = null;
        bVar.c = null;
        return bVar.a;
    }

    public final Object b() {
        return a(this.d);
    }

    public final boolean c(b bVar) {
        return bVar.c == null && this.c != bVar && bVar.b == null && this.d != bVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a(this);
    }
}
