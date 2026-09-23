package com.google.android.libraries.navigation.internal.zh;

import com.google.android.libraries.navigation.internal.zd.l;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends c {
    private final a c;

    public b(com.google.android.libraries.navigation.internal.zd.c cVar, int i, a aVar) {
        super(cVar, i);
        this.c = aVar;
        StringBuilder sb = new StringBuilder("%");
        cVar.f(sb);
        sb.append(true != cVar.d() ? 't' : 'T');
        sb.append(aVar.G);
    }

    @Override // com.google.android.libraries.navigation.internal.zh.c
    public final void a(d dVar, Object obj) {
        a aVar = this.c;
        if (!(obj instanceof Date) && !(obj instanceof Calendar) && !(obj instanceof Long)) {
            com.google.android.libraries.navigation.internal.zd.a.c(((com.google.android.libraries.navigation.internal.zd.a) dVar).b, obj, "%t" + aVar.G);
            return;
        }
        com.google.android.libraries.navigation.internal.zd.c cVar = this.b;
        StringBuilder sb = new StringBuilder("%");
        cVar.f(sb);
        sb.append(true != cVar.d() ? 't' : 'T');
        sb.append(aVar.G);
        ((com.google.android.libraries.navigation.internal.zd.a) dVar).b.append(String.format(l.a, sb.toString(), obj));
    }
}
