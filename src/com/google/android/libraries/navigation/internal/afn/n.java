package com.google.android.libraries.navigation.internal.afn;

import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n {
    HashMap a = new HashMap();

    public n(String str) {
        for (String str2 : str.split(";")) {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length == 2) {
                this.a.put(strArrSplit[0], strArrSplit[1]);
            }
        }
    }

    public final String a(String str) {
        return (String) this.a.get(str);
    }
}
