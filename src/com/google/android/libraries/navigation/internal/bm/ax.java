package com.google.android.libraries.navigation.internal.bm;

import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ax implements aw {
    public final az a;

    public ax(az azVar) {
        this.a = azVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bm.aw
    public final /* bridge */ /* synthetic */ Object b(boolean z) {
        az azVar = this.a;
        return (z ? azVar.h : azVar.g).a();
    }

    @Override // com.google.android.libraries.navigation.internal.bm.aw
    public final /* bridge */ /* synthetic */ Object c() {
        AtomicReference atomicReference;
        final at atVar = this.a.f;
        br brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.bm.as
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                at atVar2 = atVar;
                return (com.google.android.libraries.navigation.internal.ol.aq) atVar2.a(atVar2.b.c);
            }
        });
        do {
            atomicReference = atVar.a;
            if (PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, brVarA)) {
                break;
            }
        } while (atomicReference.get() == null);
        br brVar = (br) atVar.a.get();
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar);
        return (com.google.android.libraries.navigation.internal.ol.aq) brVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.bm.aw
    public final /* bridge */ /* synthetic */ Object d() {
        return this.a.i.a();
    }

    @Override // com.google.android.libraries.navigation.internal.bm.aw
    public final /* bridge */ /* synthetic */ Object e() {
        return this.a.j.a();
    }

    @Override // com.google.android.libraries.navigation.internal.bm.aw
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public final com.google.android.libraries.navigation.internal.ol.aq a(boolean z) {
        az azVar = this.a;
        return (z ? azVar.e : azVar.d).a();
    }
}
