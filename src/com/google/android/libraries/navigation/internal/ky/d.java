package com.google.android.libraries.navigation.internal.ky;

import android.content.Context;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class d {
    protected final Context a;
    protected final String b;
    protected p c;
    protected final br d = new br() { // from class: com.google.android.libraries.navigation.internal.ky.c
        @Override // com.google.android.libraries.navigation.internal.yx.br
        public final Object a() {
            return d.c();
        }
    };
    protected aw e = aw.a;
    public r f;

    protected d(Context context, String str) {
        be.j(context);
        this.a = context;
        be.h(str);
        this.b = str;
    }

    public static /* synthetic */ Boolean c() {
        return false;
    }

    public final d a(p pVar) {
        be.j(pVar);
        this.c = pVar;
        return this;
    }

    public final d b(aw awVar) {
        be.j(awVar);
        this.e = awVar;
        e.b(awVar);
        return this;
    }
}
