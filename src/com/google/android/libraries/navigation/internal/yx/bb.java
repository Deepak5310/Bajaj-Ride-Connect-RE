package com.google.android.libraries.navigation.internal.yx;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bb implements bi {
    final /* synthetic */ String a;

    public bb(String str) {
        this.a = str;
    }

    @Override // com.google.android.libraries.navigation.internal.yx.bi
    public final /* bridge */ /* synthetic */ Iterator a(bj bjVar, CharSequence charSequence) {
        return new ba(bjVar, charSequence, this.a);
    }
}
