package com.google.android.libraries.navigation.internal.hx;

import android.os.Handler;
import android.os.Looper;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aa extends b {
    public final Looper f;
    private final Handler g;

    /* JADX WARN: Illegal instructions before constructor call */
    public aa(Looper looper, ap apVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        String str = apVar.N;
        apVar.b();
        super(str, apVar.a(), aVar, null);
        this.f = looper;
        this.g = new Handler(looper);
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b
    protected final void h(b.a aVar) {
        this.g.postDelayed(aVar, aVar.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override // com.google.android.libraries.navigation.internal.hx.b
    public final void j() {
        ar.k(this.f != Looper.getMainLooper());
        this.g.post(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.hx.y
            @Override // java.lang.Runnable
            public final void run() {
                this.a.i();
            }
        }));
        this.f.quitSafely();
    }
}
