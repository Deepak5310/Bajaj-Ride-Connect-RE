package com.google.android.libraries.navigation.internal.uw;

import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.f.g;
import com.google.android.libraries.navigation.internal.si.h;
import com.google.android.libraries.navigation.internal.ux.e;
import java.util.Optional;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements e {
    private final h a;

    public c(h hVar, boolean z, boolean z2) {
        this.a = hVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public Boolean a() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public Boolean b() {
        return Boolean.valueOf(this.a.c);
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public Boolean c() {
        return (Boolean) this.a.b.map(new Function() { // from class: com.google.android.libraries.navigation.internal.uw.b
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() >= 100);
            }
        }).orElse(false);
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public Boolean d() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public Integer e() {
        return Integer.valueOf(this.a.d == bm.a.MILES ? g.f426n : g.m);
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public Integer f() {
        return Integer.valueOf(this.a.d == bm.a.MILES ? com.google.android.libraries.navigation.internal.dw.h.bo : com.google.android.libraries.navigation.internal.dw.h.bn);
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public String g() {
        return (String) this.a.b.map(new Function() { // from class: com.google.android.libraries.navigation.internal.uw.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Integer.toString(((Integer) obj).intValue());
            }
        }).orElse("--");
    }

    @Override // com.google.android.libraries.navigation.internal.ux.e
    public Optional<Integer> h() {
        return this.a.b;
    }
}
