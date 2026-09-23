package com.google.android.libraries.navigation.internal.abh;

import android.view.animation.AlphaAnimation;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dn extends ListView {
    int a;
    public com.google.android.libraries.navigation.internal.abm.ag b;
    public com.google.android.libraries.navigation.internal.abm.aj c;
    private dl d;
    private final be e;
    private final com.google.android.libraries.navigation.internal.abf.z f;

    public dn(be beVar) {
        super(beVar.a, null);
        this.a = -1;
        this.e = beVar;
        this.f = com.google.android.libraries.navigation.internal.abf.z.a;
    }

    public static boolean f(com.google.android.libraries.navigation.internal.abm.ag agVar, com.google.android.libraries.navigation.internal.abm.ag agVar2) {
        if (agVar == agVar2) {
            return true;
        }
        if (agVar == null || agVar2 == null) {
            return false;
        }
        return agVar.c().equals(agVar2.c());
    }

    public final void a() {
        post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.dh
            @Override // java.lang.Runnable
            public final void run() {
                dn dnVar = this.a;
                com.google.android.libraries.navigation.internal.abm.aj ajVar = dnVar.c;
                if (ajVar != null) {
                    com.google.android.libraries.navigation.internal.abm.ag agVarC = ajVar.c();
                    int iB = agVarC != null ? ajVar.b(agVarC) : -1;
                    com.google.android.libraries.navigation.internal.abf.p.f("INDOOR", 3);
                    dnVar.e(agVarC, iB);
                }
            }
        });
    }

    public final void b() {
        int i = this.a;
        if (i != -1) {
            smoothScrollToPosition(i);
        }
    }

    public final void c(int i) {
        if (i == this.a) {
            return;
        }
        this.a = i;
        this.d.notifyDataSetChanged();
        if (i == -1 || this.c == null) {
            return;
        }
        dm dmVar = (dm) getItemAtPosition(i);
        if (dmVar == null) {
            com.google.android.libraries.navigation.internal.abf.p.f("INDOOR", 3);
            return;
        }
        com.google.android.libraries.navigation.internal.abm.ah ahVar = dmVar.a;
        if (ahVar != null) {
            this.c.a(ahVar.a());
            return;
        }
        com.google.android.libraries.navigation.internal.abm.ag agVar = this.b;
        if (agVar != null) {
            com.google.android.libraries.navigation.internal.abm.aj ajVar = this.c;
            Object objC = agVar.c();
            com.google.android.libraries.navigation.internal.abf.s.b(true, "buildingId type: %s", objC.getClass().getName());
            ajVar.a.e((com.google.android.libraries.navigation.internal.oe.i) objC);
        }
    }

    public final void d(com.google.android.libraries.navigation.internal.abm.aj ajVar) {
        if (ajVar != null) {
            a();
        }
        this.c = ajVar;
    }

    public final void e(com.google.android.libraries.navigation.internal.abm.ag agVar, int i) {
        this.f.a();
        if (!f(agVar, this.b)) {
            clearAnimation();
            this.b = null;
            this.a = -1;
            if (agVar != null) {
                if (agVar.b().size() >= (true != agVar.d() ? 2 : 1)) {
                    this.b = agVar;
                    setVisibility(0);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setFillAfter(true);
                    alphaAnimation.setDuration(500L);
                    alphaAnimation.setAnimationListener(new dj(this));
                    startAnimation(alphaAnimation);
                    dl dlVar = new dl(this, this.e, this.b);
                    this.d = dlVar;
                    setAdapter((ListAdapter) dlVar);
                }
            }
            if (this.b == null && getVisibility() == 0) {
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation2.setDuration(500L);
                alphaAnimation2.setAnimationListener(new dk(this));
                startAnimation(alphaAnimation2);
            }
        }
        if (this.b != null) {
            if (i == -1 || i < 0) {
                i = -1;
            }
            c(i);
            b();
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abh.di
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b();
            }
        });
    }
}
