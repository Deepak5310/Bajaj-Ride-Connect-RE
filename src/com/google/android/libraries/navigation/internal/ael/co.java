package com.google.android.libraries.navigation.internal.ael;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class co implements cw {
    private final cw[] a;

    public co(cw... cwVarArr) {
        this.a = cwVarArr;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cw
    public final cv a(Class cls) {
        for (int i = 0; i < 2; i++) {
            cw cwVar = this.a[i];
            if (cwVar.b(cls)) {
                return cwVar.a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cw
    public final boolean b(Class cls) {
        for (int i = 0; i < 2; i++) {
            if (this.a[i].b(cls)) {
                return true;
            }
        }
        return false;
    }
}
