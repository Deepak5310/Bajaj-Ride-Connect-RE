package com.google.android.libraries.navigation.internal.su;

import com.google.android.libraries.navigation.internal.ady.al;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d implements Serializable {
    public static d d(al alVar) {
        al alVar2;
        List list;
        a aVar = new a();
        List listEmptyList = Collections.emptyList();
        Objects.requireNonNull(listEmptyList);
        aVar.b = listEmptyList;
        aVar.c = (byte) 1;
        Objects.requireNonNull(alVar);
        aVar.a = alVar;
        if (aVar.c != 1 || (alVar2 = aVar.a) == null || (list = aVar.b) == null) {
            throw new IllegalStateException();
        }
        return new b(alVar2, list);
    }

    public abstract al a();

    public abstract List b();

    public abstract void c();
}
