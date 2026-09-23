package com.google.android.libraries.navigation.internal.cl;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements br {
    public boolean a = false;
    private final br b;

    public h(final com.google.android.libraries.navigation.internal.afo.a aVar, final Context context) {
        this.b = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.cl.g
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return new bo((com.google.android.libraries.navigation.internal.ol.ax) aVar.a(), context.getResources());
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.yx.br
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final bo a() {
        this.a = true;
        return (bo) this.b.a();
    }
}
