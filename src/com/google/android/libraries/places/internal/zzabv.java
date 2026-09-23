package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzabv implements zzanv {
    static final zzanv zza = new zzabv();

    private zzabv() {
    }

    @Override // com.google.android.libraries.places.internal.zzanv
    public final boolean zza(int i) {
        if (i == 0) {
            return true;
        }
        switch (i) {
            case 1000:
            case 1001:
            case 1002:
            case 1003:
                return true;
            default:
                return false;
        }
    }
}
