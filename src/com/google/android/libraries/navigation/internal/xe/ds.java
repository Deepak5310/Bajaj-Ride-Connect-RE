package com.google.android.libraries.navigation.internal.xe;

import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.Navigator;
import com.google.android.libraries.navigation.SpeedAlertOptions;
import com.google.android.libraries.navigation.SpeedAlertSeverity;
import com.google.android.libraries.navigation.SpeedometerUiOptions;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ds implements Cdo {
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private NavigationView.OnRecenterButtonClickedListener K;
    private SpeedAlertOptions L;
    private com.google.android.libraries.navigation.internal.vc.b M;
    private SpeedometerUiOptions N;
    private com.google.android.libraries.navigation.internal.xj.d O;
    private final gv P;
    private com.google.android.libraries.navigation.internal.xk.a Q;
    private final com.google.android.libraries.navigation.internal.nt.t R;
    private final com.google.android.libraries.navigation.internal.nt.t S;
    private final Runnable T;
    private com.google.android.libraries.navigation.internal.ms.at a;
    private com.google.android.libraries.navigation.internal.vl.c b;
    private com.google.android.libraries.navigation.internal.ux.d c;
    private Navigator d;
    private ai e;
    private com.google.android.libraries.navigation.internal.nt.m f;
    private com.google.android.libraries.navigation.internal.vb.l g;
    private com.google.android.libraries.navigation.internal.vb.d h;
    private com.google.android.libraries.navigation.internal.vb.g i;
    private com.google.android.libraries.navigation.internal.vb.k j;
    private com.google.android.libraries.navigation.internal.tk.e k;
    private com.google.android.libraries.navigation.internal.ed.b l;
    private com.google.android.libraries.navigation.internal.wb.n m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.hn.r f649n;
    private com.google.android.libraries.navigation.internal.dx.o o;
    private boolean p;
    private boolean q;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public ds() {
        this(false);
    }

    public static /* synthetic */ void D(ds dsVar) {
        dsVar.a.a(dsVar);
        dsVar.m.b.p();
    }

    public static /* synthetic */ void E(ds dsVar, com.google.android.libraries.navigation.internal.nt.m mVar) {
        com.google.android.libraries.navigation.internal.yz.ev evVarO;
        com.google.android.libraries.navigation.internal.ms.ck ckVar;
        View rootView;
        Boolean bool = (Boolean) mVar.c();
        com.google.android.libraries.navigation.internal.yx.ar.q(bool);
        dsVar.C = bool.booleanValue();
        Iterator it2 = com.google.android.libraries.navigation.internal.ms.cy.a.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.ms.cv cvVarN = ((com.google.android.libraries.navigation.internal.ms.ax) it2.next()).n();
            HashSet hashSet = new HashSet();
            com.google.android.libraries.navigation.internal.my.l lVar = cvVarN.a;
            synchronized (lVar.b) {
                evVarO = com.google.android.libraries.navigation.internal.yz.ev.o(lVar.b.values());
            }
            int size = evVarO.size();
            for (int i = 0; i < size; i++) {
                List<WeakReference> list = (List) evVarO.get(i);
                if (list != null) {
                    for (WeakReference weakReference : list) {
                        if (weakReference != null && (ckVar = (com.google.android.libraries.navigation.internal.ms.ck) weakReference.get()) != null && (rootView = ckVar.c.getRootView()) != null) {
                            hashSet.add(rootView);
                        }
                    }
                }
            }
            Iterator it3 = hashSet.iterator();
            while (it3.hasNext()) {
                com.google.android.libraries.navigation.internal.ms.cy.e((View) it3.next());
            }
        }
        dsVar.ah();
    }

    private final void ae() {
        if (this.p) {
            this.c.j(this.A);
            this.a.a(this);
        }
    }

    private final void af() {
        if (this.p) {
            this.c.k(this.B);
            this.a.a(this);
        }
    }

    private final void ag() {
        if (this.p) {
            this.c.f(this.N.getBackgroundColorDayMode(SpeedAlertSeverity.MINOR));
            this.c.g(this.N.getBackgroundColorNightMode(SpeedAlertSeverity.MINOR));
            this.c.h(this.N.getTextColorDayMode(SpeedAlertSeverity.MINOR));
            this.c.i(this.N.getTextColorNightMode(SpeedAlertSeverity.MINOR));
            this.c.b(this.N.getBackgroundColorDayMode(SpeedAlertSeverity.MAJOR));
            this.c.c(this.N.getBackgroundColorNightMode(SpeedAlertSeverity.MAJOR));
            this.c.d(this.N.getTextColorDayMode(SpeedAlertSeverity.MAJOR));
            this.c.e(this.N.getTextColorNightMode(SpeedAlertSeverity.MAJOR));
        }
    }

    private final void ah() {
        Typeface typefaceCreateFromFile;
        Typeface typefaceCreateFromFile2;
        Typeface typefaceCreateFromFile3;
        if (this.p) {
            com.google.android.libraries.navigation.internal.xj.b bVar = new com.google.android.libraries.navigation.internal.xj.b();
            Integer num = this.M.a;
            if (num != null) {
                bVar.a(com.google.android.libraries.navigation.internal.xj.a.PRIMARY, com.google.android.libraries.navigation.internal.xj.c.DAY, num.intValue());
            }
            Integer num2 = this.M.b;
            if (num2 != null) {
                bVar.a(com.google.android.libraries.navigation.internal.xj.a.SECONDARY, com.google.android.libraries.navigation.internal.xj.c.DAY, num2.intValue());
            }
            Integer num3 = this.M.c;
            if (num3 != null) {
                bVar.a(com.google.android.libraries.navigation.internal.xj.a.PRIMARY, com.google.android.libraries.navigation.internal.xj.c.NIGHT, num3.intValue());
            }
            Integer num4 = this.M.d;
            if (num4 != null) {
                bVar.a(com.google.android.libraries.navigation.internal.xj.a.SECONDARY, com.google.android.libraries.navigation.internal.xj.c.NIGHT, num4.intValue());
            }
            this.O = new com.google.android.libraries.navigation.internal.xj.d(bVar);
            com.google.android.libraries.navigation.internal.vb.d dVar = this.h;
            com.google.android.libraries.navigation.internal.vc.b bVar2 = this.M;
            com.google.android.libraries.navigation.internal.vb.b bVar3 = new com.google.android.libraries.navigation.internal.vb.b();
            bVar3.c();
            Integer num5 = bVar2.a;
            if (num5 != null) {
                bVar3.a(true, false, false, num5.intValue());
                bVar3.a(true, true, false, num5.intValue());
            }
            Integer num6 = bVar2.b;
            if (num6 != null) {
                bVar3.a(false, false, false, num6.intValue());
                bVar3.a(false, true, false, num6.intValue());
            }
            Integer num7 = bVar2.c;
            if (num7 != null) {
                bVar3.a(true, false, true, num7.intValue());
                bVar3.a(true, true, true, num7.intValue());
            }
            Integer num8 = bVar2.d;
            if (num8 != null) {
                bVar3.a(false, false, true, num8.intValue());
                bVar3.a(false, true, true, num8.intValue());
            }
            dVar.a = new com.google.android.libraries.navigation.internal.vb.c(bVar3);
            com.google.android.libraries.navigation.internal.vb.g gVar = this.i;
            com.google.android.libraries.navigation.internal.vc.b bVar4 = this.M;
            com.google.android.libraries.navigation.internal.vb.e eVar = new com.google.android.libraries.navigation.internal.vb.e();
            eVar.a();
            Integer num9 = bVar4.e;
            if (num9 != null) {
                eVar.a = new com.google.android.libraries.navigation.internal.nc.ae(num9.intValue());
            }
            Integer num10 = bVar4.f;
            if (num10 != null) {
                eVar.b = new com.google.android.libraries.navigation.internal.nc.ae(num10.intValue());
            }
            gVar.a = new com.google.android.libraries.navigation.internal.vb.f(eVar);
            com.google.android.libraries.navigation.internal.vb.k kVar = this.j;
            com.google.android.libraries.navigation.internal.vc.b bVar5 = this.M;
            com.google.android.libraries.navigation.internal.vb.i iVar = new com.google.android.libraries.navigation.internal.vb.i();
            String str = bVar5.g;
            if (str != null) {
                try {
                    typefaceCreateFromFile = Typeface.createFromFile(str);
                } catch (Exception unused) {
                    typefaceCreateFromFile = null;
                }
            } else {
                typefaceCreateFromFile = null;
            }
            iVar.a = typefaceCreateFromFile != null ? new com.google.android.libraries.navigation.internal.nc.bg(typefaceCreateFromFile) : null;
            Integer num11 = bVar5.h;
            iVar.b = num11 != null ? new com.google.android.libraries.navigation.internal.nc.ae(num11.intValue()) : null;
            Float f = bVar5.i;
            iVar.c = f != null ? com.google.android.libraries.navigation.internal.nc.a.h(f.floatValue()) : null;
            Float f2 = bVar5.j;
            iVar.d = f2 != null ? com.google.android.libraries.navigation.internal.nc.a.h(f2.floatValue()) : null;
            String str2 = bVar5.k;
            if (str2 != null) {
                try {
                    typefaceCreateFromFile2 = Typeface.createFromFile(str2);
                } catch (Exception unused2) {
                    typefaceCreateFromFile2 = null;
                }
            } else {
                typefaceCreateFromFile2 = null;
            }
            iVar.e = typefaceCreateFromFile2 != null ? new com.google.android.libraries.navigation.internal.nc.bg(typefaceCreateFromFile2) : null;
            Integer num12 = bVar5.l;
            iVar.f = num12 != null ? new com.google.android.libraries.navigation.internal.nc.ae(num12.intValue()) : null;
            Float f3 = bVar5.m;
            iVar.g = f3 != null ? com.google.android.libraries.navigation.internal.nc.a.h(f3.floatValue()) : null;
            String str3 = bVar5.f634n;
            if (str3 != null) {
                try {
                    typefaceCreateFromFile3 = Typeface.createFromFile(str3);
                } catch (Exception unused3) {
                    typefaceCreateFromFile3 = null;
                }
            } else {
                typefaceCreateFromFile3 = null;
            }
            iVar.h = typefaceCreateFromFile3 != null ? new com.google.android.libraries.navigation.internal.nc.bg(typefaceCreateFromFile3) : null;
            Integer num13 = bVar5.o;
            iVar.i = num13 != null ? new com.google.android.libraries.navigation.internal.nc.ae(num13.intValue()) : null;
            Float f4 = bVar5.p;
            iVar.j = f4 != null ? com.google.android.libraries.navigation.internal.nc.a.h(f4.floatValue()) : null;
            Integer num14 = bVar5.q;
            iVar.k = num14 != null ? new com.google.android.libraries.navigation.internal.nc.ae(num14.intValue()) : null;
            Float f5 = bVar5.r;
            iVar.l = f5 != null ? com.google.android.libraries.navigation.internal.nc.a.h(f5.floatValue()) : null;
            kVar.a = new com.google.android.libraries.navigation.internal.vb.j(iVar);
            com.google.android.libraries.navigation.internal.vb.l lVar = this.g;
            com.google.android.libraries.navigation.internal.vc.b bVar6 = this.M;
            Resources resources = lVar.b.getResources();
            int color = resources.getColor(com.google.android.libraries.navigation.internal.f.b.F);
            Integer num15 = bVar6.s;
            if (num15 != null) {
                color = num15.intValue();
            }
            int i = color;
            int color2 = resources.getColor(com.google.android.libraries.navigation.internal.f.b.m);
            Integer num16 = bVar6.b;
            if (num16 != null) {
                color2 = ColorUtils.compositeColors(com.google.android.libraries.navigation.internal.vb.l.a.intValue(), num16.intValue());
            }
            int i2 = color2;
            int color3 = resources.getColor(com.google.android.libraries.navigation.internal.f.b.x);
            Integer num17 = bVar6.d;
            lVar.c = com.google.android.libraries.navigation.internal.ul.a.b(lVar.b, i, i2, resources.getColor(com.google.android.libraries.navigation.internal.f.b.F), i, num17 != null ? ColorUtils.compositeColors(com.google.android.libraries.navigation.internal.vb.l.a.intValue(), num17.intValue()) : color3, resources.getColor(com.google.android.libraries.navigation.internal.f.b.F));
            if (o().booleanValue()) {
                this.b.u();
                com.google.android.libraries.navigation.internal.ms.cy.a(this);
            }
            Integer num18 = this.C ? this.M.c : this.M.a;
            if (num18 != null) {
                this.k.b = num18.intValue();
            } else {
                com.google.android.libraries.navigation.internal.tk.e eVar2 = this.k;
                eVar2.b = eVar2.a;
            }
        }
    }

    public Boolean A() {
        boolean z = false;
        if (this.q && ((com.google.android.libraries.navigation.internal.afl.fv) this.f649n.b()).h) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public Boolean B() {
        A().booleanValue();
        return false;
    }

    public Boolean C() {
        return Boolean.valueOf(this.s);
    }

    public void F(Boolean bool) {
        this.D = bool.booleanValue();
        f().n(bool.booleanValue());
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void G(Bundle bundle) {
        this.D = bundle.getBoolean("NavigationUiViewModelImpl.hasCustomSecondaryHeader", this.D);
        this.t = bundle.getBoolean("NavigationUiViewModelImpl.headerEnabled", this.t);
        this.u = bundle.getBoolean("NavigationUiViewModelImpl.etaCardEnabled", this.u);
        this.v = bundle.getBoolean("NavigationUiViewModelImpl.compassEnabled", this.v);
        this.w = bundle.getBoolean("NavigationUiViewModelImpl.recenterButtonEnabled", this.w);
        this.x = bundle.getBoolean("NavigationUiViewModelImpl.reportIncidentButtonEnabled", this.x);
        this.y = bundle.getBoolean("NavigationUiViewModelImpl.trafficPromptsEnabled", this.y);
        this.z = bundle.getBoolean("NavigationUiViewModelImpl.tripProgressBarEnabled", this.z);
        this.G = bundle.getInt("NavigationUiViewModelImpl.paddingStart", this.G);
        this.I = bundle.getInt("NavigationUiViewModelImpl.paddingTop", this.I);
        this.H = bundle.getInt("NavigationUiViewModelImpl.paddingEnd", this.H);
        this.J = bundle.getInt("NavigationUiViewModelImpl.paddingBottom", this.J);
        this.A = bundle.getBoolean("NavigationUiViewModelImpl.speedLimitIcon");
        this.B = bundle.getBoolean("NavigationUiViewModelImpl.speedometer");
        SpeedometerUiOptions speedometerUiOptions = (SpeedometerUiOptions) bundle.getParcelable("NavigationUiViewModelImpl.speedometerUiOptions");
        this.N = speedometerUiOptions;
        if (speedometerUiOptions == null) {
            this.N = new SpeedometerUiOptions.Builder().build();
        }
        this.L = (SpeedAlertOptions) bundle.getParcelable("NavigationUiViewModelImpl.speedAlertOptions");
        com.google.android.libraries.navigation.internal.vc.b bVar = (com.google.android.libraries.navigation.internal.vc.b) bundle.getParcelable("NavigationUiViewModelImpl.stylingOptions");
        this.M = bVar;
        if (bVar == null) {
            this.M = new com.google.android.libraries.navigation.internal.vc.b();
        }
        ah();
        this.E = bundle.getBoolean("NavigationUiViewModelImpl.androidAutoStylingEnabled", this.E);
        this.P.c(bundle);
    }

    public void H() {
        if (this.p) {
            this.f.h(this.R);
            this.l.a().h(this.S);
            this.m.a.v(this.T);
        }
    }

    public void I(com.google.android.libraries.navigation.internal.nt.m<Boolean> mVar) {
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void J(Navigator navigator, com.google.android.libraries.navigation.internal.ms.at atVar, ai aiVar, com.google.android.libraries.navigation.internal.nt.m<Boolean> mVar, com.google.android.libraries.navigation.internal.vb.l lVar, com.google.android.libraries.navigation.internal.vb.d dVar, com.google.android.libraries.navigation.internal.vb.g gVar, com.google.android.libraries.navigation.internal.vb.k kVar, com.google.android.libraries.navigation.internal.tk.e eVar, com.google.android.libraries.navigation.internal.ed.b bVar, Executor executor, com.google.android.libraries.navigation.internal.wb.n nVar, com.google.android.libraries.navigation.internal.uu.q qVar, com.google.android.libraries.navigation.internal.hn.r<com.google.android.libraries.navigation.internal.afl.fv> rVar, com.google.android.libraries.navigation.internal.dx.o oVar) {
        this.d = navigator;
        this.a = atVar;
        this.f = mVar;
        this.e = aiVar;
        this.g = lVar;
        this.h = dVar;
        this.i = gVar;
        this.j = kVar;
        this.k = eVar;
        this.l = bVar;
        this.m = nVar;
        this.b = nVar.a;
        this.c = qVar.w;
        this.P.d(atVar);
        this.f649n = rVar;
        this.o = oVar;
        this.p = true;
        this.f.g(this.R, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
        this.l.a().e(this.S, executor);
        this.m.a.r(this.T);
        ah();
        if (this.p) {
            this.d.setSpeedAlertOptions(this.L);
        }
        ag();
        ae();
        af();
    }

    public void K(Bundle bundle) {
        bundle.putBoolean("NavigationUiViewModelImpl.headerEnabled", this.t);
        bundle.putBoolean("NavigationUiViewModelImpl.etaCardEnabled", this.u);
        bundle.putBoolean("NavigationUiViewModelImpl.compassEnabled", this.v);
        bundle.putBoolean("NavigationUiViewModelImpl.recenterButtonEnabled", this.w);
        bundle.putBoolean("NavigationUiViewModelImpl.reportIncidentButtonEnabled", this.x);
        bundle.putBoolean("NavigationUiViewModelImpl.trafficPromptsEnabled", this.y);
        bundle.putBoolean("NavigationUiViewModelImpl.tripProgressBarEnabled", this.z);
        bundle.putInt("NavigationUiViewModelImpl.paddingStart", this.G);
        bundle.putInt("NavigationUiViewModelImpl.paddingTop", this.I);
        bundle.putInt("NavigationUiViewModelImpl.paddingEnd", this.H);
        bundle.putInt("NavigationUiViewModelImpl.paddingBottom", this.J);
        bundle.putParcelable("NavigationUiViewModelImpl.stylingOptions", this.M);
        bundle.putBoolean("NavigationUiViewModelImpl.hasCustomSecondaryHeader", this.D);
        bundle.putBoolean("NavigationUiViewModelImpl.speedLimitIcon", this.A);
        bundle.putBoolean("NavigationUiViewModelImpl.speedometer", this.B);
        bundle.putParcelable("NavigationUiViewModelImpl.speedometerUiOptions", this.N);
        bundle.putParcelable("NavigationUiViewModelImpl.speedAlertOptions", this.L);
        this.P.e(bundle);
        bundle.putBoolean("NavigationUiViewModelImpl.androidAutoStylingEnabled", this.E);
    }

    public void L(boolean z) {
        this.v = z;
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void M(int i) {
        this.F = i;
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void N(boolean z) {
        this.u = z;
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void O(boolean z) {
        this.t = z;
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void P(NavigationView.OnRecenterButtonClickedListener onRecenterButtonClickedListener) {
        this.K = onRecenterButtonClickedListener;
    }

    public void Q(int i, int i2, int i3, int i4) {
        this.G = i;
        this.H = i3;
        this.I = i2;
        this.J = i4;
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
        ai aiVar = this.e;
        if (aiVar == null || !aiVar.c()) {
            return;
        }
        this.e.b(true);
    }

    public void R(boolean z) {
        this.w = z;
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void S(com.google.android.libraries.navigation.internal.xk.a aVar) {
        this.Q = aVar;
    }

    public void T(boolean z) {
        this.A = z;
        ae();
    }

    public void U(boolean z) {
        this.B = z;
        af();
        if (!z || this.A) {
            return;
        }
        T(true);
    }

    public void V(SpeedometerUiOptions speedometerUiOptions) {
        if (speedometerUiOptions == null) {
            this.N = new SpeedometerUiOptions.Builder().build();
        } else {
            this.N = speedometerUiOptions;
        }
        ag();
    }

    public void W(com.google.android.libraries.navigation.internal.vc.b bVar) {
        this.M = new com.google.android.libraries.navigation.internal.vc.b(bVar);
        ah();
    }

    public void X(boolean z) {
        this.s = z;
        com.google.android.libraries.navigation.internal.ms.cy.a(this);
    }

    public void Y(boolean z) {
        this.y = z;
    }

    public void Z(boolean z) {
        this.z = z;
        if (this.p) {
            this.a.a(this);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public int a() {
        return this.F;
    }

    public void aa() {
        this.q = true;
    }

    public void ab() {
        this.q = false;
    }

    public boolean ac() {
        return this.y;
    }

    public boolean ad() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.ms.cs.a b() {
        ah ahVar = this.e.a;
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        ahVar.d(false);
        NavigationView.OnRecenterButtonClickedListener onRecenterButtonClickedListener = this.K;
        if (onRecenterButtonClickedListener == null) {
            return null;
        }
        onRecenterButtonClickedListener.onRecenterButtonClick();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.uk.a.InterfaceC0037a c() {
        com.google.android.libraries.navigation.internal.vb.d dVar = this.h;
        if (dVar != null) {
            return dVar.a;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.uk.a.b d() {
        com.google.android.libraries.navigation.internal.vb.g gVar = this.i;
        if (gVar != null) {
            return gVar.a;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.uk.a.d e() {
        com.google.android.libraries.navigation.internal.vb.k kVar = this.j;
        if (kVar != null) {
            return kVar.a;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.uk.b f() {
        com.google.android.libraries.navigation.internal.vl.c cVar = this.b;
        if (cVar != null) {
            return cVar.n();
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.ux.d g() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.vk.b h() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public gv i() {
        return this.P;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.xj.d j() {
        return this.O;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public com.google.android.libraries.navigation.internal.xk.a k() {
        return this.Q;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean l() {
        return Boolean.valueOf(this.D);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0010  */
    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean m() {
        boolean z = false;
        if (this.v) {
            if (!o().booleanValue() || this.b == null || this.D) {
                z = true;
            } else {
                com.google.android.libraries.navigation.internal.uk.a aVarC = f() != null ? f().c() : null;
                if (aVarC == null || (!aVarC.t().booleanValue() && (aVarC.k() == null || !aVarC.k().t().booleanValue()))) {
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean n() {
        boolean z = false;
        if (this.q && this.u) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean o() {
        boolean z = false;
        if (this.q && this.t && !this.s) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean p(com.google.android.libraries.navigation.internal.afl.fv.a aVar, boolean z) {
        boolean z2 = false;
        if (this.E || !A().booleanValue() || !ad()) {
            return false;
        }
        if (z) {
            if (aVar == com.google.android.libraries.navigation.internal.afl.fv.a.LOWER_RIGHT && !((com.google.android.libraries.navigation.internal.afl.fv) this.f649n.b()).i) {
                z2 = true;
            }
            return Boolean.valueOf(z2);
        }
        com.google.android.libraries.navigation.internal.afl.fv.a aVarB = com.google.android.libraries.navigation.internal.afl.fv.a.b(((com.google.android.libraries.navigation.internal.afl.fv) this.f649n.b()).g);
        if (aVarB == null) {
            aVarB = com.google.android.libraries.navigation.internal.afl.fv.a.LOWER_RIGHT;
        }
        return Boolean.valueOf(aVar == aVarB);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0022  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0051  */
    /* JADX WARN: Code duplicated, block: B:32:0x005b  */
    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean q() {
        ai aiVar;
        com.google.android.libraries.navigation.internal.tj.u uVar;
        boolean z = false;
        if (this.w && (aiVar = this.e) != null) {
            boolean z2 = this.y;
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            ah ahVar = aiVar.a;
            if (ahVar.u) {
                if (ahVar.q()) {
                    if (ahVar.b == null) {
                        com.google.android.libraries.navigation.internal.ui.a aVar = ahVar.s;
                        if (aVar != null) {
                            com.google.android.libraries.navigation.internal.uh.p pVar = ahVar.i;
                            com.google.android.libraries.navigation.internal.yx.ar.q(pVar);
                            com.google.android.libraries.navigation.internal.ue.c cVar = ((com.google.android.libraries.navigation.internal.uh.w) pVar).k;
                            if (z2) {
                                com.google.android.libraries.navigation.internal.tj.u uVar2 = aVar.b;
                                if (uVar2 != null) {
                                    com.google.android.libraries.navigation.internal.yx.ar.q(uVar2);
                                    if (uVar2.j() != com.google.android.libraries.navigation.internal.tj.t.ENROUTE_SEARCH_RESULT_LIST) {
                                        uVar = aVar.b;
                                        if (uVar != null) {
                                            com.google.android.libraries.navigation.internal.yx.ar.q(uVar);
                                            if (uVar.e()) {
                                                if (!com.google.android.libraries.navigation.internal.up.c.a(aVar, cVar)) {
                                                    z = true;
                                                }
                                            }
                                        } else if (!com.google.android.libraries.navigation.internal.up.c.a(aVar, cVar)) {
                                            z = true;
                                        }
                                    } else if (!com.google.android.libraries.navigation.internal.up.c.a(aVar, cVar)) {
                                        z = true;
                                    }
                                } else {
                                    uVar = aVar.b;
                                    if (uVar != null) {
                                        com.google.android.libraries.navigation.internal.yx.ar.q(uVar);
                                        if (uVar.e()) {
                                            if (!com.google.android.libraries.navigation.internal.up.c.a(aVar, cVar)) {
                                                z = true;
                                            }
                                        }
                                    } else if (!com.google.android.libraries.navigation.internal.up.c.a(aVar, cVar)) {
                                        z = true;
                                    }
                                }
                            } else if (!com.google.android.libraries.navigation.internal.up.c.a(aVar, cVar)) {
                                z = true;
                            }
                        }
                    } else if (ahVar.s.c.a != com.google.android.libraries.navigation.internal.uc.g.FOLLOWING) {
                        z = true;
                    }
                } else if (!ahVar.o) {
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean r() {
        boolean z = false;
        if ((this.A || this.B) && !q().booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean s() {
        com.google.android.libraries.navigation.internal.vl.c cVar = this.b;
        boolean z = false;
        if (cVar != null && cVar.o().booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean t() {
        boolean z = false;
        if (this.q && this.z && !this.P.b().booleanValue()) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Boolean u() {
        return Boolean.valueOf(this.C);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Integer v() {
        return Integer.valueOf(this.u ? 0 : this.J);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Integer w() {
        return Integer.valueOf(this.H);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Integer x() {
        return Integer.valueOf(this.G);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public Integer y() {
        return Integer.valueOf(this.t ? 0 : this.I);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.Cdo
    public boolean z() {
        return this.E;
    }

    public ds(boolean z) {
        this.p = false;
        this.t = true;
        this.u = true;
        this.v = true;
        this.w = true;
        this.x = true;
        this.y = true;
        this.z = false;
        this.A = false;
        this.B = false;
        this.E = false;
        this.F = 0;
        this.M = new com.google.android.libraries.navigation.internal.vc.b();
        this.N = new SpeedometerUiOptions.Builder().build();
        this.O = new com.google.android.libraries.navigation.internal.xj.d(new com.google.android.libraries.navigation.internal.xj.b());
        this.R = new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.xe.dp
            @Override // com.google.android.libraries.navigation.internal.nt.t
            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
                this.a.I(mVar);
            }
        };
        this.S = new com.google.android.libraries.navigation.internal.nt.t() { // from class: com.google.android.libraries.navigation.internal.xe.dq
            @Override // com.google.android.libraries.navigation.internal.nt.t
            public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
                ds.E(this.a, mVar);
            }
        };
        this.T = new Runnable() { // from class: com.google.android.libraries.navigation.internal.xe.dr
            @Override // java.lang.Runnable
            public final void run() {
                ds.D(this.a);
            }
        };
        this.P = new gw();
        this.E = z;
    }
}
