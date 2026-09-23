package com.google.android.libraries.navigation.internal.uo;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.apps.gmm.base.views.viewpager.ArrowViewPager;
import com.google.android.libraries.geo.navcore.ui.header.views.SwipeableHeaderView;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.da;
import com.google.android.libraries.navigation.internal.ms.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends bt<com.google.android.libraries.navigation.internal.uk.b> implements com.google.android.libraries.navigation.internal.yt.e {
    private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("QuantumNavigationHeaderLayout");
    public static final dd a = da.b(new by() { // from class: com.google.android.libraries.navigation.internal.uo.g
        @Override // com.google.android.libraries.navigation.internal.ms.by
        public final Object a(cs csVar, Context context) {
            dd ddVar = k.a;
            return Boolean.valueOf(bg.i(context));
        }
    });

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.N(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                dd ddVar = k.a;
                return ((com.google.android.libraries.navigation.internal.uk.b) csVar).d();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })};
        com.google.android.libraries.navigation.internal.mx.e eVar = new com.google.android.libraries.navigation.internal.mx.e(SwipeableHeaderView.class, com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.B)), com.google.android.libraries.navigation.internal.ms.ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.d
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) k.a.a((com.google.android.libraries.navigation.internal.uk.b) csVar)).booleanValue() ? new com.google.android.libraries.navigation.internal.nc.o(bg.a, com.google.android.libraries.navigation.internal.nc.a.g(51)) : new com.google.android.libraries.navigation.internal.nc.o(bg.b, com.google.android.libraries.navigation.internal.nc.a.g(3));
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.L(2), ch.f(com.google.android.libraries.navigation.internal.ad.b.ARROW_PAGER_ADAPTER, new bg(), ArrowViewPager.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.navigation.internal.ad.b.ARROW_PAGER_ITEMS, new dd() { // from class: com.google.android.libraries.navigation.internal.uo.h
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.b) csVar).g();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, ArrowViewPager.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.navigation.internal.ad.b.ARROW_PAGER_CURRENT_ITEM, new dd() { // from class: com.google.android.libraries.navigation.internal.uo.i
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.b) csVar).c();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, ArrowViewPager.a), ch.f(com.google.android.libraries.navigation.internal.ad.b.ARROWS_VISIBLE, false, ArrowViewPager.a), new com.google.android.libraries.navigation.internal.mx.ac(com.google.android.libraries.navigation.internal.ad.b.ON_PAGE_SELECTED_LISTENER, new dd() { // from class: com.google.android.libraries.navigation.internal.uo.j
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.b) csVar).b();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, ArrowViewPager.a), ch.b(com.google.android.libraries.navigation.internal.ms.aq.a(), SwipeableHeaderView.h(400L), SwipeableHeaderView.h(200L)));
        eVar.e(mVarArr);
        com.google.android.libraries.navigation.internal.mx.e eVar2 = new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.G(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.a
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                dd ddVar = k.a;
                return Boolean.valueOf(!((com.google.android.libraries.navigation.internal.uk.b) csVar).d().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.R(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.f
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((Boolean) k.a.a((com.google.android.libraries.navigation.internal.uk.b) csVar)).booleanValue() ? bg.a : bg.c;
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.u(true), com.google.android.libraries.navigation.internal.ms.ah.r(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                dd ddVar = k.a;
                return ((com.google.android.libraries.navigation.internal.uk.b) csVar).e().booleanValue() ? com.google.android.libraries.navigation.internal.w.a.j() : com.google.android.libraries.navigation.internal.w.a.i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.uo.c
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.uk.b) csVar).f();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(27)), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.w.a.r()), com.google.android.libraries.navigation.internal.ms.ah.aX(new com.google.android.libraries.navigation.internal.nc.bg(com.google.android.libraries.navigation.internal.ms.ad.a))), new com.google.android.libraries.navigation.internal.mx.e(View.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(3)), com.google.android.libraries.navigation.internal.ms.ah.q(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.c.x))));
        eVar2.e(new com.google.android.libraries.navigation.internal.mx.m[0]);
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.L(0), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.v(false), com.google.android.libraries.navigation.internal.ms.ah.w(false), com.google.android.libraries.navigation.internal.ms.ah.J(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.d.o)), eVar, eVar2);
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return b;
    }
}
