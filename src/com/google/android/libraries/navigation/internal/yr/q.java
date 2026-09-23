package com.google.android.libraries.navigation.internal.yr;

import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.UUID;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q extends a implements d {
    static final b b = new c();
    public static final /* synthetic */ int c = 0;
    private final Exception d;
    private final boolean e;

    public q(UUID uuid, Exception exc, boolean z, ae aeVar) {
        super("<missing root>", uuid, aeVar);
        this.d = exc;
        this.e = z;
    }

    public static void k(final UUID uuid, final Exception exc) {
        fy fyVarF = i.f();
        if (fyVarF.isEmpty()) {
            return;
        }
        fyVarF.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.yr.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                int i = q.c;
                ((aj) obj).a();
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.yr.d
    public final ag e(String str, z zVar, boolean z, ae aeVar) {
        if (z) {
            i.j();
        }
        return new s(str, this, zVar, z, aeVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yr.d
    public final Exception f() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.d
    public final boolean g() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final z h() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final z i() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final ag j(String str, z zVar, ae aeVar) {
        i.j();
        return e(str, zVar, true, aeVar);
    }
}
