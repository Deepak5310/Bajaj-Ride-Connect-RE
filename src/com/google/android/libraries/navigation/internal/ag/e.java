package com.google.android.libraries.navigation.internal.ag;

import android.animation.ValueAnimator;
import android.view.animation.LinearInterpolator;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hx.n;
import com.google.android.libraries.navigation.internal.ms.cy;
import com.google.android.libraries.navigation.internal.nj.i;
import com.google.android.libraries.navigation.internal.yr.am;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class e implements com.google.android.libraries.navigation.internal.ah.a {
    public int a;
    public ValueAnimator b;
    private final com.google.android.libraries.navigation.internal.ah.a.InterfaceC0032a c;
    private final bn d;
    private final Executor e;
    private com.google.android.libraries.navigation.internal.hx.e f;
    private boolean g;

    public e(com.google.android.libraries.navigation.internal.ah.a.InterfaceC0032a interfaceC0032a, bn bnVar, Executor executor) {
        this.c = interfaceC0032a;
        this.d = bnVar;
        this.e = executor;
    }

    public static /* synthetic */ void c(e eVar) {
        eVar.g = true;
        eVar.c.a();
        cy.a(eVar);
    }

    @Override // com.google.android.libraries.navigation.internal.ah.a
    public Integer a() {
        return 1000;
    }

    @Override // com.google.android.libraries.navigation.internal.ah.a
    public Integer b() {
        return Integer.valueOf(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.ah.a
    public void d() {
        i.b();
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        com.google.android.libraries.navigation.internal.hx.e eVar = this.f;
        if (eVar != null) {
            eVar.a();
        }
    }

    public void e() {
        d();
        this.a = 0;
        this.g = false;
    }

    public void f() {
        e();
        cy.a(this);
    }

    public void g(long j) {
        h(j, null);
    }

    public void h(long j, Float f) {
        i.b();
        d();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 1000);
        this.b = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(j);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.addUpdateListener(new c(this));
        this.b.addListener(am.a(new d(this)));
        this.b.start();
        com.google.android.libraries.navigation.internal.hx.e eVar = new com.google.android.libraries.navigation.internal.hx.e(new Runnable() { // from class: com.google.android.libraries.navigation.internal.ag.b
            @Override // java.lang.Runnable
            public final void run() {
                e.c(this.a);
            }
        });
        this.f = eVar;
        this.g = false;
        n.a(this.d.e(eVar, j, TimeUnit.MILLISECONDS), this.e);
    }

    public boolean i() {
        return this.g;
    }

    public boolean j() {
        ValueAnimator valueAnimator = this.b;
        return valueAnimator != null && valueAnimator.isStarted();
    }
}
