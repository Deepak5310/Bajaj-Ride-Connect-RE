package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.be;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.renderer.ez;
import com.google.android.libraries.navigation.internal.px.bk;
import com.google.android.libraries.navigation.internal.px.cq;
import com.google.android.libraries.navigation.internal.px.cr;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class aw implements com.google.android.libraries.navigation.internal.qi.e, cr {
    private boolean b = true;
    private boolean c = false;
    private final fd d = ma.b;
    private final com.google.android.libraries.navigation.internal.qi.f e = com.google.android.libraries.navigation.internal.qi.f.g(com.google.android.libraries.navigation.internal.oe.ap.a(), cg.s, com.google.android.libraries.geo.mapcore.internal.model.aq.a, com.google.android.libraries.navigation.internal.rq.a.a, 0, null);
    private final cd a = new cd(0, 0, 0);

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final boolean A() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final boolean B() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final boolean C() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final boolean D(com.google.android.libraries.navigation.internal.mj.a aVar) {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final boolean E(ez ezVar) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final void H(Collection collection) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final boolean Z() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d, com.google.android.libraries.navigation.internal.oz.e
    public final cd a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final void aa(cq cqVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d, com.google.android.libraries.navigation.internal.px.cr
    public final com.google.android.libraries.navigation.internal.adi.an ab() {
        return com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE;
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final void ac(bk bkVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.cr
    public final void d(bk bkVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final int g() {
        return -1;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final int h() {
        return 100;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final int i() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final int j() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final long k() {
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final com.google.android.libraries.navigation.internal.qi.c l(be beVar, com.google.android.libraries.navigation.internal.ol.w wVar) {
        return com.google.android.libraries.navigation.internal.qi.c.RESTYLE;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final com.google.android.libraries.navigation.internal.qi.f m() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final fd n() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final void o(com.google.android.libraries.navigation.internal.pb.t tVar, Collection collection) {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.e
    public final void p() {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final void q() {
        this.b = false;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.e
    public final void s() {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final void t(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final void v() {
        this.c = true;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final void w(com.google.android.libraries.navigation.internal.pb.t tVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final void x(long j) {
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final boolean y(long j) {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qi.d
    public final boolean z() {
        return true;
    }
}
