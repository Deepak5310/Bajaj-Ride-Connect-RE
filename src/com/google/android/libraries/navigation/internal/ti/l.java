package com.google.android.libraries.navigation.internal.ti;

import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ p a;

    public l(p pVar) {
        this.a = pVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        Optional optional = this.a.s;
        if (optional != null) {
            optional.isPresent();
        }
    }
}
