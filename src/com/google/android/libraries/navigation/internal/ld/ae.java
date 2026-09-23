package com.google.android.libraries.navigation.internal.ld;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae extends UnsupportedOperationException {
    private final com.google.android.libraries.navigation.internal.lc.d a;

    public ae(com.google.android.libraries.navigation.internal.lc.d dVar) {
        this.a = dVar;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(String.valueOf(this.a)));
    }
}
