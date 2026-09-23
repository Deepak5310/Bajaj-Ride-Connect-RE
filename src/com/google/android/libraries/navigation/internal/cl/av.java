package com.google.android.libraries.navigation.internal.cl;

import android.content.res.Resources;
import androidx.camera.view.PreviewView$1$$ExternalSyntheticBackportWithForwarding0;
import com.google.android.libraries.navigation.internal.adg.ex;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av extends at {
    public static final ev e = ev.s(com.google.android.libraries.navigation.internal.adg.b.TOP_RIGHT, com.google.android.libraries.navigation.internal.adg.b.TOP, com.google.android.libraries.navigation.internal.adg.b.TOP_LEFT);

    public av(com.google.android.libraries.navigation.internal.ol.ax axVar, Resources resources, boolean z) {
        super(axVar, resources, z);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.at
    public final com.google.android.libraries.navigation.internal.ol.aq b() {
        return this.a.f(ex.LEGEND_STYLE_MANEUVER_CALLOUT);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.at
    public final com.google.android.libraries.navigation.internal.ol.aq c(bq bqVar) {
        final as asVarA = super.a(bqVar, com.google.android.libraries.navigation.internal.f.b.h);
        AtomicReference atomicReference = asVarA.a;
        br brVarA = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.cl.ar
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                as asVar = asVarA;
                return (com.google.android.libraries.navigation.internal.ol.aq) asVar.a(asVar.b.b);
            }
        });
        while (!PreviewView$1$$ExternalSyntheticBackportWithForwarding0.m(atomicReference, null, brVarA) && atomicReference.get() == null) {
        }
        br brVar = (br) asVarA.a.get();
        com.google.android.libraries.navigation.internal.yx.ar.q(brVar);
        return (com.google.android.libraries.navigation.internal.ol.aq) brVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.cl.at
    public final com.google.android.libraries.navigation.internal.ol.aq d() {
        return this.a.f(ex.LEGEND_STYLE_MANEUVER_CALLOUT_TITLE);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.at
    public final com.google.android.libraries.navigation.internal.oo.f e() {
        return com.google.android.libraries.navigation.internal.rd.e.d(ex.LEGEND_STYLE_MANEUVER_CALLOUT);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.at
    public final com.google.android.libraries.navigation.internal.oo.f f(bq bqVar) {
        return (com.google.android.libraries.navigation.internal.oo.f) super.a(bqVar, com.google.android.libraries.navigation.internal.f.b.h).a(com.google.android.libraries.navigation.internal.oj.l.a);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.at
    public final com.google.android.libraries.navigation.internal.oo.f g() {
        return com.google.android.libraries.navigation.internal.rd.e.d(ex.LEGEND_STYLE_MANEUVER_CALLOUT_TITLE);
    }
}
