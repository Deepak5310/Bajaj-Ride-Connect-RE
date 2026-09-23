package com.google.android.gms.maps;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class aa extends com.google.android.libraries.navigation.internal.ly.f {
    private final GoogleMap.CancelableCallback a;

    public aa(GoogleMap.CancelableCallback cancelableCallback) {
        this.a = cancelableCallback;
    }

    @Override // com.google.android.libraries.navigation.internal.ly.g
    public final void a() {
        this.a.onCancel();
    }

    @Override // com.google.android.libraries.navigation.internal.ly.g
    public final void b() {
        this.a.onFinish();
    }
}
