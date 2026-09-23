package com.google.android.libraries.navigation.internal.agi;

import java.util.AbstractCollection;
import java.util.Spliterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class m extends AbstractCollection implements gf {
    protected m() {
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public abstract gi iterator();

    public /* synthetic */ hj c() {
        throw null;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public /* bridge */ /* synthetic */ Spliterator spliterator() {
        return c();
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        gi it2 = iterator();
        int size = size();
        boolean z = true;
        while (size != 0) {
            if (!z) {
                sb.append(", ");
            }
            size--;
            Object next = it2.next();
            if (this == next) {
                sb.append("(this collection)");
            } else {
                sb.append(String.valueOf(next));
            }
            z = false;
        }
        sb.append("}");
        return sb.toString();
    }
}
