package com.google.android.libraries.navigation.internal.si;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends c {
    private boolean a;
    private byte b;

    @Override // com.google.android.libraries.navigation.internal.si.c
    public final d a() {
        if (this.b == 1) {
            return new b(this.a);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.si.c
    public final void b(boolean z) {
        this.a = z;
        this.b = (byte) 1;
    }
}
