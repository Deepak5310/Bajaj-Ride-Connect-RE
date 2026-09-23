package com.google.android.libraries.navigation.internal.yx;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bd implements bi {
    final /* synthetic */ u a;

    public bd(u uVar) {
        this.a = uVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.bi
    public final /* bridge */ /* synthetic */ Iterator a(bj bjVar, CharSequence charSequence) {
        return new bc(bjVar, charSequence, this.a.a(charSequence));
    }
}
