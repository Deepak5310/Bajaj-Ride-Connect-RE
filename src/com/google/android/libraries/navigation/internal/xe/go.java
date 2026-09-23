package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.TimeAndDistance;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class go implements com.google.android.libraries.navigation.internal.aac.as {
    final /* synthetic */ gp a;

    public go(gp gpVar) {
        this.a = gpVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final void a(Throwable th) {
    }

    @Override // com.google.android.libraries.navigation.internal.aac.as
    public final /* bridge */ /* synthetic */ void b(Object obj) {
        List list = (List) obj;
        this.a.b.g(list.isEmpty() ? 0 : Math.max(0, ((TimeAndDistance) com.google.android.libraries.navigation.internal.yz.gs.d(list)).getMeters()));
    }
}
