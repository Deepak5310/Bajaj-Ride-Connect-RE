package com.google.android.libraries.navigation.internal.ps;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a implements f {
    final /* synthetic */ com.google.android.libraries.geo.mapcore.renderer.v a;
    final /* synthetic */ b b;

    public a(b bVar, com.google.android.libraries.geo.mapcore.renderer.v vVar) {
        this.a = vVar;
        this.b = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ps.f
    public final void a(cd cdVar, int i, Collection collection) {
        boolean zContains;
        if (this.a == this.b.g && i == 0 && collection != null) {
            synchronized (this.b) {
                zContains = this.b.d.contains(cdVar);
                if (zContains) {
                    this.b.c.put(cdVar, collection);
                    this.b.f = true;
                }
            }
            if (zContains) {
                this.b.b(this.a);
            }
        }
    }
}
