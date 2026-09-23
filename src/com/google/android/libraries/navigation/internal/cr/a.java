package com.google.android.libraries.navigation.internal.cr;

import com.google.android.libraries.navigation.internal.op.g;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends c {
    private final g a;

    public a(g gVar) {
        this.a = gVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cr.c, com.google.android.libraries.navigation.internal.cr.e
    public final g a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cr.e
    public final int b() {
        return 2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (eVar.b() == 2 && this.a.equals(eVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "RegistrationId{callout=" + String.valueOf(this.a) + "}";
    }
}
