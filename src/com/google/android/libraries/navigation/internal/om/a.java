package com.google.android.libraries.navigation.internal.om;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends i {
    private float a;
    private boolean b;
    private byte c;

    @Override // com.google.android.libraries.navigation.internal.om.i
    public final j a() {
        if (this.c == 3) {
            return new b(this.a, this.b);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.om.i
    public final void b(boolean z) {
        this.b = z;
        this.c = (byte) (this.c | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.om.i
    public final void c(float f) {
        this.a = f;
        this.c = (byte) (this.c | 1);
    }
}
