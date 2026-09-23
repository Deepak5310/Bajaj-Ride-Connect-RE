package com.google.android.libraries.navigation.internal.ru;

import android.content.Context;
import com.google.android.libraries.navigation.internal.iv.f;
import com.google.android.libraries.navigation.internal.jy.af;
import com.google.android.libraries.navigation.internal.ms.bg;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.mz.a {
    private final af b;
    private final f c;
    private final com.google.android.libraries.navigation.internal.ab.a d;
    private final br e;

    public a(Context context, bg bgVar, af afVar, f fVar, com.google.android.libraries.navigation.internal.ab.a aVar, br brVar) {
        super(context, bgVar);
        this.b = afVar;
        this.c = fVar;
        this.d = aVar;
        this.e = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.mz.a, com.google.android.libraries.navigation.internal.ms.bm
    protected final void q(List list) {
        list.add(new b(new com.google.android.libraries.navigation.internal.mt.a()));
        list.add(new com.google.android.libraries.navigation.internal.ac.f(this.b, this.c, this.d));
        br brVar = this.e;
        if (brVar != null && ((Boolean) brVar.a()).booleanValue()) {
            list.add(new com.google.android.libraries.navigation.internal.ce.a(new com.google.android.libraries.navigation.internal.ce.c(this.b, this.c)));
        }
        super.q(list);
    }
}
