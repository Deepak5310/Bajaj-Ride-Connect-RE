package com.google.android.libraries.places.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzmj implements Comparator {
    protected zzmj() {
    }

    public static zzmj zza(Comparator comparator) {
        return new zzlk(comparator);
    }
}
