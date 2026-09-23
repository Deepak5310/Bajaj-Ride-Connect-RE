package com.google.android.libraries.navigation.internal.cr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends c {
    private final com.google.android.libraries.navigation.internal.or.c a;

    public b(com.google.android.libraries.navigation.internal.or.c cVar) {
        this.a = cVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cr.e
    public final int b() {
        return 1;
    }

    @Override // com.google.android.libraries.navigation.internal.cr.c, com.google.android.libraries.navigation.internal.cr.e
    public final com.google.android.libraries.navigation.internal.or.c c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.b() == 1 && this.a.equals(eVar.c())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RegistrationId{cvo=" + this.a.toString() + "}";
    }
}
