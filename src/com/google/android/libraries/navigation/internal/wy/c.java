package com.google.android.libraries.navigation.internal.wy;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private final Map a;

    public c(Map map) {
        this.a = map;
    }

    public final ArrayList a(int i) {
        Integer numValueOf = Integer.valueOf(i);
        ArrayList arrayList = new ArrayList();
        while (this.a.containsKey(numValueOf)) {
            arrayList.add(numValueOf);
            numValueOf = (Integer) this.a.get(numValueOf);
            if (numValueOf == null) {
                return arrayList;
            }
        }
        throw new IllegalArgumentException("Error: " + numValueOf + " was not found in the table.");
    }
}
