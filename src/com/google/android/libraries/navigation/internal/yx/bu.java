package com.google.android.libraries.navigation.internal.yx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bu implements br {
    private static final br a = new br() { // from class: com.google.android.libraries.navigation.internal.yx.bt
        @Override // com.google.android.libraries.navigation.internal.yx.br
        public final Object a() {
            throw new IllegalStateException();
        }
    };
    private final cc b = new cc();
    private volatile br c;
    private Object d;

    public bu(br brVar) {
        ar.q(brVar);
        this.c = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    public final Object a() {
        br brVar = this.c;
        br brVar2 = a;
        if (brVar != brVar2) {
            synchronized (this.b) {
                if (this.c != brVar2) {
                    Object objA = this.c.a();
                    this.d = objA;
                    this.c = brVar2;
                    return objA;
                }
            }
        }
        return this.d;
    }

    public final String toString() {
        Object obj = this.c;
        if (obj == a) {
            obj = "<supplier that returned " + String.valueOf(this.d) + ">";
        }
        return com.google.android.libraries.navigation.internal.b.b.e(obj, "Suppliers.memoize(", ")");
    }
}
