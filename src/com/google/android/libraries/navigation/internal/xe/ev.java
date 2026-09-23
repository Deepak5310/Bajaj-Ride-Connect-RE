package com.google.android.libraries.navigation.internal.xe;

import com.google.android.libraries.navigation.TimeAndDistance;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ev implements com.google.android.libraries.navigation.internal.vp.f {
    final /* synthetic */ m a;
    final /* synthetic */ fi b;

    public ev(fi fiVar, m mVar) {
        this.a = mVar;
        this.b = fiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.vp.f
    public final void a(com.google.android.libraries.navigation.internal.vp.c cVar) {
        this.a.d(fy.a);
    }

    @Override // com.google.android.libraries.navigation.internal.vp.f
    public final void b(com.google.android.libraries.navigation.internal.bp.ai aiVar) {
        List listD = aiVar.d(this.b.e);
        int i = ((com.google.android.libraries.navigation.internal.bp.bg) listD.get(0)).i();
        TimeAndDistance timeAndDistance = new TimeAndDistance((int) com.google.android.libraries.navigation.internal.ja.a.b(((com.google.android.libraries.navigation.internal.bp.bg) listD.get(0)).L(0.0d)), i, ((com.google.android.libraries.navigation.internal.bp.bg) listD.get(0)).E().e);
        int i2 = i;
        int i3 = 0;
        for (int i4 = 0; i4 < ((lv) listD).c; i4++) {
            int i5 = ((com.google.android.libraries.navigation.internal.bp.bg) listD.get(i4)).i();
            if (i5 < i2) {
                i3 = i4;
            }
            if (i5 < i2) {
                i2 = i5;
            }
        }
        this.a.d(new fy(timeAndDistance, i3 != 0 ? new TimeAndDistance((int) com.google.android.libraries.navigation.internal.ja.a.b(((com.google.android.libraries.navigation.internal.bp.bg) listD.get(i3)).L(0.0d)), i2, ((com.google.android.libraries.navigation.internal.bp.bg) listD.get(i3)).E().e) : timeAndDistance));
    }
}
