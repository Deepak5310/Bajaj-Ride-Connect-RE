package com.google.android.libraries.navigation.internal.vi;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.be;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.vf.ab;
import com.google.android.libraries.navigation.internal.vf.ac;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class o implements com.google.android.libraries.navigation.internal.vj.c {
    private final at a;
    private final aa b;
    private final com.google.android.libraries.navigation.internal.nc.t c;
    private final a d;
    private final com.google.android.libraries.navigation.internal.ms.c e;
    private final com.google.android.libraries.navigation.internal.ms.c f;
    private final com.google.android.libraries.navigation.internal.vj.c.a g;
    private Boolean h = false;

    /* JADX INFO: compiled from: PG */
    public interface a {
    }

    /* JADX INFO: compiled from: PG */
    public interface b {
    }

    public o(at atVar, Context context, aa aaVar, a aVar, com.google.android.libraries.navigation.internal.nc.t tVar, int i, int i2, com.google.android.libraries.navigation.internal.vj.c.a aVar2, final b bVar) {
        this.a = atVar;
        this.b = aaVar;
        this.d = aVar;
        this.c = tVar;
        this.g = aVar2;
        be beVar = new be();
        this.e = new ac(context, beVar);
        Handler handler = new Handler(Looper.getMainLooper());
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate = AnimatedVectorDrawableCompat.create(context, i);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompatCreate2 = AnimatedVectorDrawableCompat.create(context, i2);
        Objects.requireNonNull(bVar);
        this.f = new ab(handler, context, beVar, animatedVectorDrawableCompatCreate, animatedVectorDrawableCompatCreate2, new Runnable() { // from class: com.google.android.libraries.navigation.internal.vi.n
            @Override // java.lang.Runnable
            public final void run() {
                ((r) bVar).a.L();
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.vj.c
    public aa a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.c
    public com.google.android.libraries.navigation.internal.ms.c b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.c
    public com.google.android.libraries.navigation.internal.ms.c c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.c
    public cs.a d() {
        u uVar;
        com.google.android.libraries.navigation.internal.so.a aVar;
        if (!this.h.booleanValue() && ((aVar = (uVar = ((p) this.d).a).B) == null || !aVar.e(uVar.A))) {
            this.h = true;
            this.g.a();
        }
        this.a.a(this);
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.c
    public com.google.android.libraries.navigation.internal.nc.t e() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.c
    public Boolean f() {
        return this.h;
    }
}
