package com.google.android.libraries.places.api.net;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class IsOpenResponse {
    public static IsOpenResponse newInstance(Boolean bool) {
        return new zzt(bool);
    }

    public abstract Boolean isOpen();
}
