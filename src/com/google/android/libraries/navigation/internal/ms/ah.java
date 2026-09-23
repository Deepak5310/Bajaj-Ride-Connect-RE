package com.google.android.libraries.navigation.internal.ms;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah {
    public static com.google.android.libraries.navigation.internal.mx.w A(Integer num) {
        return ch.e(e.CONTENT_DESCRIPTION, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w B(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.ELEVATION, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w C(TextUtils.TruncateAt truncateAt) {
        return ch.e(e.ELLIPSIZE, truncateAt);
    }

    public static com.google.android.libraries.navigation.internal.mx.w D(dd ddVar) {
        return ch.d(e.FOCUSABLE, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w E(Boolean bool) {
        return ch.e(e.FOCUSABLE, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w F(com.google.android.libraries.navigation.internal.nc.ah ahVar) {
        return ch.e(e.FOREGROUND, ahVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w G(final dd ddVar) {
        return bb(new dd() { // from class: com.google.android.libraries.navigation.internal.ms.w
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) ddVar.a(csVar)).booleanValue() ? 0 : 8);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
    }

    public static com.google.android.libraries.navigation.internal.mx.w H(final dd ddVar) {
        return bb(new dd() { // from class: com.google.android.libraries.navigation.internal.ms.r
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) ddVar.a(csVar)).booleanValue() ? 8 : 0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
    }

    public static com.google.android.libraries.navigation.internal.mx.w I(Integer num) {
        return ch.e(e.GRAVITY, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w J(Integer num) {
        return ch.e(e.ID, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w K(dd ddVar) {
        return ch.d(e.IMPORTANT_FOR_ACCESSIBILITY, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w L(Integer num) {
        return ch.e(e.IMPORTANT_FOR_ACCESSIBILITY, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w M(Boolean bool) {
        return ch.e(e.INCLUDE_FONT_PADDING, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w N(final dd ddVar) {
        return bb(new dd() { // from class: com.google.android.libraries.navigation.internal.ms.aa
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) ddVar.a(csVar)).booleanValue() ? 0 : 4);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
    }

    public static com.google.android.libraries.navigation.internal.mx.w O(final dd ddVar) {
        return bb(new dd() { // from class: com.google.android.libraries.navigation.internal.ms.y
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return Integer.valueOf(true != ((Boolean) ddVar.a(csVar)).booleanValue() ? 4 : 0);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        });
    }

    public static com.google.android.libraries.navigation.internal.mx.w P(dd ddVar) {
        return ch.d(e.LAYOUT_GRAVITY, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w Q(Integer num) {
        return ch.e(e.LAYOUT_GRAVITY, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w R(dd ddVar) {
        return ch.d(e.LAYOUT_HEIGHT, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w S(com.google.android.libraries.navigation.internal.nc.ag agVar) {
        return ch.e(e.LAYOUT_HEIGHT, agVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w T(Integer num) {
        return ch.e(e.LAYOUT_HEIGHT, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w U(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.LAYOUT_MARGIN, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w V(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.LAYOUT_MARGIN_BOTTOM, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w W(dd ddVar) {
        return ch.d(e.LAYOUT_MARGIN_END, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w X(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.LAYOUT_MARGIN_END, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w Y(dd ddVar) {
        return ch.d(e.LAYOUT_MARGIN_START, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w Z(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.LAYOUT_MARGIN_START, apVar);
    }

    public static bu a(bt btVar, cs csVar) {
        return bu.e(btVar, csVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aA(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.PADDING_TOP, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aB(dd ddVar) {
        return ch.d(e.PROGRESS, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aC(dd ddVar) {
        return ch.d(e.PROGRESS_DRAWABLE, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aD(ImageView.ScaleType scaleType) {
        return ch.e(e.SCALE_TYPE, scaleType);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aE(Float f) {
        return ch.e(e.SCALE_X, f);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aF(Float f) {
        return ch.e(e.SCALE_Y, f);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aG(Boolean bool) {
        return ch.e(e.SCROLLBARS, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aH(Boolean bool) {
        return ch.e(e.SINGLE_LINE, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aI(dd ddVar) {
        return ch.d(e.SRC, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aJ(com.google.android.libraries.navigation.internal.nc.ah ahVar) {
        return ch.e(e.SRC, ahVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aK(Integer num) {
        return ch.e(e.SRC, num);
    }

    @Deprecated
    public static com.google.android.libraries.navigation.internal.mx.w aL(by byVar) {
        return ch.c(e.TEXT, byVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aM(dd ddVar) {
        return ch.d(e.TEXT, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aN(Integer num) {
        return ch.e(e.TEXT, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aO(Integer num) {
        return ch.e(e.TEXT_ALIGNMENT, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aP(Integer num) {
        return ch.e(e.TEXT_APPEARANCE, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aQ(dd ddVar) {
        return ch.d(e.TEXT_COLOR, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aR(com.google.android.libraries.navigation.internal.nc.x xVar) {
        return ch.e(e.TEXT_COLOR, xVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aS(dd ddVar) {
        return ch.d(e.TEXT_SIZE, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aT(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.TEXT_SIZE, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aU(dd ddVar) {
        return ch.d(e.TEXT_STYLE, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aV(Integer num) {
        return ch.e(e.TEXT_STYLE, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aW(dd ddVar) {
        return ch.d(e.TEXT_TYPEFACE, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aX(com.google.android.libraries.navigation.internal.nc.bh bhVar) {
        return ch.e(e.TEXT_TYPEFACE, bhVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aY(dd ddVar) {
        return ch.d(e.TINT, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aZ(com.google.android.libraries.navigation.internal.nc.x xVar) {
        return ch.e(e.TINT, xVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aa(dd ddVar) {
        return ch.d(e.LAYOUT_MARGIN_TOP, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ab(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.LAYOUT_MARGIN_TOP, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ac(bz... bzVarArr) {
        e eVar = e.RELATIVE_LAYOUT_RULES;
        bz[] bzVarArr2 = new bz[ca.a];
        for (bz bzVar : bzVarArr) {
            bzVarArr2[bzVar.a()] = bzVar;
        }
        return new com.google.android.libraries.navigation.internal.mx.t(eVar, new aj(Arrays.asList(bzVarArr2)), false);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ad(Float f) {
        return ch.e(e.LAYOUT_WEIGHT, f);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ae(dd ddVar) {
        return ch.d(e.LAYOUT_WIDTH, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w af(com.google.android.libraries.navigation.internal.nc.ag agVar) {
        return ch.e(e.LAYOUT_WIDTH, agVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ag(Integer num) {
        return ch.e(e.LAYOUT_WIDTH, num);
    }

    @Deprecated
    public static com.google.android.libraries.navigation.internal.mx.w ah(by byVar) {
        return ch.c(e.LIST_ADAPTER, byVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ai(dd ddVar) {
        return ch.d(e.MAX, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aj(Integer num) {
        return ch.e(e.MAX_LINES, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ak(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.MIN_HEIGHT, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w al(dd ddVar) {
        return ch.d(e.MIN_WIDTH, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w am(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.MIN_WIDTH, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w an(dd ddVar) {
        return ch.d(e.ON_CLICK, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ao(dd ddVar) {
        return ch.d(e.ON_PRE_DRAW_APPLY_CALLBACK, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ap(dd ddVar) {
        return ch.d(e.ON_TOUCH, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aq(Integer num) {
        return ch.e(e.ORIENTATION, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ar(com.google.android.libraries.navigation.internal.nc.ap apVar, com.google.android.libraries.navigation.internal.nc.ap apVar2, com.google.android.libraries.navigation.internal.nc.ap apVar3, com.google.android.libraries.navigation.internal.nc.ap apVar4) {
        e eVar = e.PADDING;
        boolean z = false;
        com.google.android.libraries.navigation.internal.nc.ap[] apVarArr = {apVar, apVar2, apVar3, apVar4};
        if (com.google.android.libraries.navigation.internal.nc.bi.a(apVar) && com.google.android.libraries.navigation.internal.nc.bi.a(apVar2) && com.google.android.libraries.navigation.internal.nc.bi.a(apVar3) && com.google.android.libraries.navigation.internal.nc.bi.a(apVar4)) {
            z = true;
        }
        return new com.google.android.libraries.navigation.internal.mx.t(eVar, apVarArr, z);
    }

    @Deprecated
    public static com.google.android.libraries.navigation.internal.mx.w as(Object obj, Object obj2, Object obj3, Object obj4) {
        e eVar = e.PADDING;
        Object[] objArr = {obj, obj2, obj3, obj4};
        boolean z = false;
        if (com.google.android.libraries.navigation.internal.nc.bi.a(obj) && com.google.android.libraries.navigation.internal.nc.bi.a(obj2) && com.google.android.libraries.navigation.internal.nc.bi.a(obj3) && com.google.android.libraries.navigation.internal.nc.bi.a(obj4)) {
            z = true;
        }
        return new com.google.android.libraries.navigation.internal.mx.t(eVar, objArr, z);
    }

    public static com.google.android.libraries.navigation.internal.mx.w at(dd ddVar) {
        return ch.d(e.PADDING_BOTTOM, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w au(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.PADDING_BOTTOM, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w av(dd ddVar) {
        return ch.d(e.PADDING_END, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w aw(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.PADDING_END, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ax(dd ddVar) {
        return ch.d(e.PADDING_START, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w ay(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return ch.e(e.PADDING_START, apVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w az(dd ddVar) {
        return ch.d(e.PADDING_TOP, ddVar);
    }

    @SafeVarargs
    public static com.google.android.libraries.navigation.internal.mx.g b(bt btVar, final dd ddVar, final dd ddVar2, com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, new com.google.android.libraries.navigation.internal.mx.j(btVar, new by() { // from class: com.google.android.libraries.navigation.internal.ms.s
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return (cs) ddVar.a(csVar);
            }
        }, mVarArr), bk.a(new dd() { // from class: com.google.android.libraries.navigation.internal.ms.t
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                boolean z = true;
                if (!ch.g(ddVar.a(csVar)) && !((Boolean) ddVar2.a(csVar)).booleanValue()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]));
    }

    public static com.google.android.libraries.navigation.internal.mx.w ba(dd ddVar) {
        return ch.d(e.TRANSLATION_Y, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w bb(dd ddVar) {
        return ch.d(e.VISIBILITY, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w bc(Integer num) {
        return ch.e(e.VISIBILITY, num);
    }

    @SafeVarargs
    public static com.google.android.libraries.navigation.internal.mx.j c(bt btVar, final dd ddVar, com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        return new com.google.android.libraries.navigation.internal.mx.j(btVar, new by() { // from class: com.google.android.libraries.navigation.internal.ms.x
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return (cs) ddVar.a(csVar);
            }
        }, mVarArr);
    }

    @SafeVarargs
    public static com.google.android.libraries.navigation.internal.mx.j d(bt btVar, final dd ddVar, com.google.android.libraries.navigation.internal.mx.m... mVarArr) {
        com.google.android.libraries.navigation.internal.mx.j jVar = new com.google.android.libraries.navigation.internal.mx.j(btVar, new by() { // from class: com.google.android.libraries.navigation.internal.ms.v
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                return (cs) ddVar.a(csVar);
            }
        }, mVarArr);
        jVar.b(G(new cg(ddVar)));
        return jVar;
    }

    public static com.google.android.libraries.navigation.internal.mx.k e(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{Z(apVar), X(apVar)});
    }

    public static com.google.android.libraries.navigation.internal.mx.k f(com.google.android.libraries.navigation.internal.nc.ag agVar) {
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{af(agVar), S(agVar)});
    }

    public static com.google.android.libraries.navigation.internal.mx.k g(com.google.android.libraries.navigation.internal.nc.ap apVar) {
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{ay(apVar), aw(apVar)});
    }

    public static com.google.android.libraries.navigation.internal.mx.w h(View.AccessibilityDelegate accessibilityDelegate) {
        return ch.e(e.ACCESSIBILITY_DELEGATE, accessibilityDelegate);
    }

    public static com.google.android.libraries.navigation.internal.mx.w i(dd ddVar) {
        return ch.d(e.ACCESSIBILITY_DELEGATE, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w j(Boolean bool) {
        return ch.e(e.ALL_CAPS, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w k(dd ddVar) {
        return ch.d(e.ALPHA, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w l(Number number) {
        return ch.e(e.ALPHA, number);
    }

    public static com.google.android.libraries.navigation.internal.mx.w m(Boolean bool) {
        return ch.e(e.ANIMATE_LAYOUT_CHANGES, bool);
    }

    @Deprecated
    public static com.google.android.libraries.navigation.internal.mx.w n(by byVar) {
        return ch.c(e.BACKGROUND, byVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w o(dd ddVar) {
        return ch.d(e.BACKGROUND, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w p(com.google.android.libraries.navigation.internal.nc.ah ahVar) {
        return ch.e(e.BACKGROUND, ahVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w q(Integer num) {
        return ch.e(e.BACKGROUND, num);
    }

    public static com.google.android.libraries.navigation.internal.mx.w r(dd ddVar) {
        return ch.d(e.BACKGROUND_COLOR, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w s(com.google.android.libraries.navigation.internal.nc.x xVar) {
        return ch.e(e.BACKGROUND_COLOR, xVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w t(dd ddVar) {
        return ch.d(e.CLICKABLE, ddVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w u(Boolean bool) {
        return ch.e(e.CLICKABLE, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w v(Boolean bool) {
        return ch.e(e.CLIP_CHILDREN, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w w(Boolean bool) {
        return ch.e(e.CLIP_TO_OUTLINE, bool);
    }

    public static com.google.android.libraries.navigation.internal.mx.w x(Boolean bool) {
        return ch.e(e.CLIP_TO_PADDING, bool);
    }

    @Deprecated
    public static com.google.android.libraries.navigation.internal.mx.w y(by byVar) {
        return ch.c(e.CONTENT_DESCRIPTION, byVar);
    }

    public static com.google.android.libraries.navigation.internal.mx.w z(dd ddVar) {
        return ch.d(e.CONTENT_DESCRIPTION, ddVar);
    }
}
