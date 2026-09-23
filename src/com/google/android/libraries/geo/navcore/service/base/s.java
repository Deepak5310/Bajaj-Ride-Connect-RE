package com.google.android.libraries.geo.navcore.service.base;

import android.app.Application;
import android.content.Intent;
import android.os.Build;
import com.google.android.libraries.navigation.internal.aac.bn;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements com.google.android.libraries.navigation.internal.so.f, com.google.android.libraries.navigation.internal.so.g {
    private final Application a;
    private final bn b;
    private int d = 1;
    private volatile boolean c = false;

    public s(Application application, bn bnVar) {
        this.a = application;
        this.b = bnVar;
    }

    @Override // com.google.android.libraries.navigation.internal.so.f
    public final void a() {
        this.c = true;
        e();
    }

    @Override // com.google.android.libraries.navigation.internal.so.f
    public final void b() {
        if (this.d == 2) {
            this.d = 4;
            return;
        }
        Application application = this.a;
        application.stopService(new Intent(application, (Class<?>) NavigationService.class));
        this.c = false;
    }

    @Override // com.google.android.libraries.navigation.internal.so.g
    public final void c() {
        this.d = 1;
    }

    @Override // com.google.android.libraries.navigation.internal.so.g
    public final void d() {
        if (this.d == 4) {
            b();
        } else {
            this.d = 3;
        }
    }

    public final void e() {
        try {
            Intent intent = new Intent(this.a, (Class<?>) NavigationService.class);
            if (Build.VERSION.SDK_INT < 31) {
                this.a.startService(intent);
            } else {
                this.a.startForegroundService(intent);
                this.d = 2;
            }
        } catch (IllegalStateException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1593)).p("Failed to start service.");
            if (this.c) {
                com.google.android.libraries.navigation.internal.hx.n.a(this.b.schedule(new Runnable() { // from class: com.google.android.libraries.geo.navcore.service.base.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.e();
                    }
                }, 1L, TimeUnit.SECONDS), this.b);
            }
        }
    }
}
