package com.google.android.libraries.navigation.internal.pj;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public interface d {
    public static final Comparator a = new Comparator() { // from class: com.google.android.libraries.navigation.internal.pj.b
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return -Integer.compare(c.a(((d) obj).a()), c.a(((d) obj2).a()));
        }
    };

    int a();
}
