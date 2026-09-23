package com.google.android.libraries.navigation.internal.mn;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends e {
    public final Context a;
    public final an b;
    private final an c;
    private final an d;

    public b(Context context, an anVar, an anVar2, an anVar3) {
        this.a = context;
        this.c = anVar;
        this.d = anVar2;
        this.b = anVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.mn.e
    public final Context a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.mn.e
    public final an b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.mn.e
    public final an c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.mn.e
    public final an d() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.mn.e
    public final void e() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            if (this.a.equals(eVar.a()) && this.c.equals(eVar.b()) && this.d.equals(eVar.d())) {
                eVar.e();
                if (this.b.equals(eVar.c())) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ 2040732332) * 1000003) ^ this.d.hashCode()) * 1000003) ^ 1237) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        an anVar = this.b;
        an anVar2 = this.d;
        an anVar3 = this.c;
        return "CollectionBasisContext{context=" + String.valueOf(this.a) + ", accountNames=" + String.valueOf(anVar3) + ", stacktrace=" + String.valueOf(anVar2) + ", googlerOverridesCheckbox=false, executor=" + String.valueOf(anVar) + "}";
    }
}
