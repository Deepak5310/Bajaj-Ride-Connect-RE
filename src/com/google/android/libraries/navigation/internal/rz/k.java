package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.yx.br;
import java.util.Objects;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends af {
    public int a;
    public boolean b;
    public Optional c = Optional.empty();
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    public br h;
    public br i;
    public ae j;
    public t k;
    public String l;
    public String m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte f570n;

    @Override // com.google.android.libraries.navigation.internal.rz.af
    public final void a(boolean z) {
        this.g = z;
        this.f570n = (byte) (this.f570n | 32);
    }

    @Override // com.google.android.libraries.navigation.internal.rz.af
    public final void b(Optional optional) {
        Objects.requireNonNull(optional);
        this.c = optional;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.af
    public final void c(ae aeVar) {
        Objects.requireNonNull(aeVar);
        this.j = aeVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.af
    public final void d(br brVar) {
        Objects.requireNonNull(brVar);
        this.h = brVar;
    }
}
