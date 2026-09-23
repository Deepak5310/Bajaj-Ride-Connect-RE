package com.google.android.libraries.navigation.internal.dz;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.libraries.navigation.internal.ms.bt;
import com.google.android.libraries.navigation.internal.ms.by;
import com.google.android.libraries.navigation.internal.ms.ch;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.ms.dd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n extends bt<com.google.android.libraries.navigation.internal.vj.a> implements com.google.android.libraries.navigation.internal.yt.e {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dz.n");
    private static final com.google.android.libraries.navigation.internal.xn.a b = com.google.android.libraries.navigation.internal.xn.a.d("ReportIncidentPromptConfirmationLayout");
    private static final com.google.android.libraries.navigation.internal.nc.ap c = com.google.android.libraries.navigation.internal.nc.z.b(54.0d);

    private static com.google.android.libraries.navigation.internal.mx.g c(com.google.android.libraries.navigation.internal.mx.m mVar) {
        return new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.w.c.k()), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.w.c.k()), com.google.android.libraries.navigation.internal.ms.ah.aO(4), com.google.android.libraries.navigation.internal.w.e.k(), com.google.android.libraries.navigation.internal.w.e.j(), com.google.android.libraries.navigation.internal.ms.ah.aT(com.google.android.libraries.navigation.internal.nc.a.i(18)), mVar);
    }

    private static com.google.android.libraries.navigation.internal.mx.k h(dd ddVar) {
        com.google.android.libraries.navigation.internal.ms.ag agVarA = com.google.android.libraries.navigation.internal.ab.d.a();
        agVarA.a = Float.valueOf(1.0f);
        agVarA.c(300L);
        agVarA.b(300);
        agVarA.g = new com.google.android.libraries.navigation.internal.ms.af() { // from class: com.google.android.libraries.navigation.internal.dz.f
            @Override // com.google.android.libraries.navigation.internal.ms.af
            public final void a(View view, cs csVar) {
                com.google.android.libraries.navigation.internal.zb.j jVar = n.a;
                view.sendAccessibilityEvent(8);
                ((com.google.android.libraries.navigation.internal.vj.a) csVar).e();
            }
        };
        com.google.android.libraries.navigation.internal.mx.w wVarA = agVarA.a();
        com.google.android.libraries.navigation.internal.ms.ag agVarA2 = com.google.android.libraries.navigation.internal.ab.d.a();
        agVarA2.a = Float.valueOf(0.0f);
        agVarA2.b(0);
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.l(0), new com.google.android.libraries.navigation.internal.mx.r(ddVar, wVarA, agVarA2.a())});
    }

    private static com.google.android.libraries.navigation.internal.mx.k i(dd ddVar, com.google.android.libraries.navigation.internal.ms.af afVar) {
        Float fValueOf = Float.valueOf(0.0f);
        com.google.android.libraries.navigation.internal.ms.ag agVar = new com.google.android.libraries.navigation.internal.ms.ag();
        Float fValueOf2 = Float.valueOf(1.0f);
        agVar.e = fValueOf2;
        agVar.f = fValueOf2;
        agVar.c(400L);
        agVar.b(300);
        agVar.b = new OvershootInterpolator();
        agVar.g = afVar;
        com.google.android.libraries.navigation.internal.mx.w wVarA = agVar.a();
        com.google.android.libraries.navigation.internal.ms.ag agVarA = com.google.android.libraries.navigation.internal.ab.d.a();
        agVarA.e = fValueOf;
        agVarA.f = fValueOf;
        agVarA.b(0);
        return new com.google.android.libraries.navigation.internal.mx.k(new com.google.android.libraries.navigation.internal.mx.m[]{com.google.android.libraries.navigation.internal.ms.ah.aE(fValueOf), com.google.android.libraries.navigation.internal.ms.ah.aF(fValueOf), new com.google.android.libraries.navigation.internal.mx.r(ddVar, wVarA, agVarA.a())});
    }

    @Override // com.google.android.libraries.navigation.internal.ms.bt
    protected final com.google.android.libraries.navigation.internal.mx.g a() {
        com.google.android.libraries.navigation.internal.nc.ap apVar = c;
        com.google.android.libraries.navigation.internal.mx.j jVarD = com.google.android.libraries.navigation.internal.ms.ah.d(new m(), new dd() { // from class: com.google.android.libraries.navigation.internal.dz.c
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).a();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.mx.m[0]);
        jVarD.a(ch.c(com.google.android.libraries.navigation.internal.ms.e.PROGRESS_DRAWABLE, new by() { // from class: com.google.android.libraries.navigation.internal.dz.d
            @Override // com.google.android.libraries.navigation.internal.ms.by
            public final Object a(cs csVar, Context context) {
                com.google.android.libraries.navigation.internal.zb.j jVar = n.a;
                return new com.google.android.libraries.navigation.internal.ur.n.a(((com.google.android.libraries.navigation.internal.vj.a) csVar).j(), com.google.android.libraries.navigation.internal.nc.a.g(8), com.google.android.libraries.navigation.internal.nc.a.g(4), com.google.android.libraries.navigation.internal.w.a.h());
            }
        }), i(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, null));
        com.google.android.libraries.navigation.internal.mx.m[] mVarArr = {com.google.android.libraries.navigation.internal.ms.ah.O(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.aA(apVar), com.google.android.libraries.navigation.internal.ms.ah.au(apVar), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.v(false), h(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), jVarD, c(com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.e
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).i();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.Q(17), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ad.a.a(com.google.android.libraries.navigation.internal.jy.aa.k(com.google.android.libraries.navigation.internal.afe.i.y)), com.google.android.libraries.navigation.internal.ms.ah.s(com.google.android.libraries.navigation.internal.ju.b.a), new com.google.android.libraries.navigation.internal.mx.e(TextView.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-2), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.w.e.h(), com.google.android.libraries.navigation.internal.ms.ah.C(TextUtils.TruncateAt.END), com.google.android.libraries.navigation.internal.ms.ah.aj(1), com.google.android.libraries.navigation.internal.ms.ah.aO(4), com.google.android.libraries.navigation.internal.ms.ah.aR(com.google.android.libraries.navigation.internal.ju.b.d), com.google.android.libraries.navigation.internal.ms.ah.aN(Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.be))), com.google.android.libraries.navigation.internal.ms.ah.ay(com.google.android.libraries.navigation.internal.nc.a.g(20)), com.google.android.libraries.navigation.internal.ms.ah.aw(com.google.android.libraries.navigation.internal.nc.a.g(20)), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.w.c.d()), com.google.android.libraries.navigation.internal.ms.ah.Z(com.google.android.libraries.navigation.internal.nc.a.g(20)), com.google.android.libraries.navigation.internal.ms.ah.X(com.google.android.libraries.navigation.internal.nc.a.g(20)), com.google.android.libraries.navigation.internal.ms.ah.am(com.google.android.libraries.navigation.internal.nc.a.g(90)), com.google.android.libraries.navigation.internal.ms.ah.ak(com.google.android.libraries.navigation.internal.w.c.b()), com.google.android.libraries.navigation.internal.ms.ah.an(new com.google.android.libraries.navigation.internal.ms.o(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.a
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).f();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        })))};
        com.google.android.libraries.navigation.internal.nc.a aVarG = com.google.android.libraries.navigation.internal.nc.a.g(16);
        return new com.google.android.libraries.navigation.internal.mx.e(FrameLayout.class, com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ad.a.a(com.google.android.libraries.navigation.internal.jy.aa.k(com.google.android.libraries.navigation.internal.afe.i.i)), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, mVarArr), new com.google.android.libraries.navigation.internal.mx.e(LinearLayout.class, com.google.android.libraries.navigation.internal.ms.ah.N(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.b
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).k();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.aq(1), com.google.android.libraries.navigation.internal.ms.ah.ag(-1), com.google.android.libraries.navigation.internal.ms.ah.T(-2), com.google.android.libraries.navigation.internal.ms.ah.I(17), com.google.android.libraries.navigation.internal.ms.ah.aA(apVar), com.google.android.libraries.navigation.internal.ms.ah.au(apVar), com.google.android.libraries.navigation.internal.ms.ah.E(true), com.google.android.libraries.navigation.internal.ms.ah.v(false), h(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.g
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.zb.j jVar = n.a;
                return Boolean.valueOf(!((com.google.android.libraries.navigation.internal.vj.a) csVar).k().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }), new com.google.android.libraries.navigation.internal.mx.e(ImageView.class, com.google.android.libraries.navigation.internal.ms.ah.S(com.google.android.libraries.navigation.internal.nc.a.g(64)), com.google.android.libraries.navigation.internal.ms.ah.af(com.google.android.libraries.navigation.internal.nc.a.g(64)), com.google.android.libraries.navigation.internal.ms.ah.ab(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.V(com.google.android.libraries.navigation.internal.nc.a.g(8)), com.google.android.libraries.navigation.internal.ms.ah.ar(aVarG, aVarG, aVarG, aVarG), i(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.h
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                com.google.android.libraries.navigation.internal.zb.j jVar = n.a;
                return Boolean.valueOf(!((com.google.android.libraries.navigation.internal.vj.a) csVar).k().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }, new com.google.android.libraries.navigation.internal.ms.af() { // from class: com.google.android.libraries.navigation.internal.dz.i
            @Override // com.google.android.libraries.navigation.internal.ms.af
            public final void a(View view, cs csVar) {
                com.google.android.libraries.navigation.internal.zb.j jVar = n.a;
                AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(view.getContext(), com.google.android.libraries.navigation.internal.dw.c.a);
                if (animatedVectorDrawableCompatCreate == null) {
                    ((com.google.android.libraries.navigation.internal.zb.h) n.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(TypedValues.CycleType.TYPE_WAVE_PHASE)).p("Animated drawable not found. Cannot perform animation.");
                } else {
                    ((ImageView) view).setImageDrawable(animatedVectorDrawableCompatCreate);
                    animatedVectorDrawableCompatCreate.start();
                }
            }
        }), com.google.android.libraries.navigation.internal.ms.ah.p(com.google.android.libraries.navigation.internal.nc.aj.a(com.google.android.libraries.navigation.internal.w.a.c()))), c(com.google.android.libraries.navigation.internal.ms.ah.aM(new dd() { // from class: com.google.android.libraries.navigation.internal.dz.j
            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final Object a(cs csVar) {
                return ((com.google.android.libraries.navigation.internal.vj.a) csVar).h();
            }

            @Override // com.google.android.libraries.navigation.internal.ms.dd
            public final /* synthetic */ boolean b() {
                return false;
            }
        }))));
    }

    @Override // com.google.android.libraries.navigation.internal.yt.e
    public final com.google.android.libraries.navigation.internal.xn.a b() {
        return b;
    }
}
