package com.google.android.libraries.navigation.internal.jj;

import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.f.h;
import com.google.android.libraries.navigation.internal.gg.i;
import com.google.android.libraries.navigation.internal.gg.o;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements com.google.android.libraries.navigation.internal.gg.e {
    final /* synthetic */ f a;

    public e(f fVar) {
        this.a = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final void a(i iVar, o oVar) {
        c(oVar.p);
    }

    @Override // com.google.android.libraries.navigation.internal.gg.e
    public final /* bridge */ /* synthetic */ void b(i iVar, Object obj) {
        c(null);
    }

    public final void c(com.google.android.libraries.navigation.internal.fw.g gVar) {
        if (this.a.q.a() && this.a.x().booleanValue()) {
            if (gVar == null) {
                f fVar = this.a;
                fVar.o = true;
                fVar.e.a(fVar);
                return;
            }
            f fVar2 = this.a;
            fVar2.k = false;
            fVar2.l = false;
            fVar2.m = false;
            fVar2.f456n = false;
            fVar2.e.a(fVar2);
            String string = this.a.d.getString(h.F);
            if (string != null) {
                TextUtils.isEmpty(string);
            }
        }
    }
}
