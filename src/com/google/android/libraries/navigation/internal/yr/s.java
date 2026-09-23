package com.google.android.libraries.navigation.internal.yr;

import com.google.android.libraries.navigation.internal.yz.fy;
import java.util.UUID;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s extends e implements d {
    public final boolean b;
    private final Exception c;
    private final boolean d;

    public s(String str, d dVar, z zVar, boolean z, ae aeVar) {
        super("<missing root>:".concat(String.valueOf(str)), dVar, z.a(zVar, y.b), aeVar);
        this.c = dVar.f();
        this.b = dVar.g();
        this.d = z;
    }

    public static void k(final UUID uuid, final Exception exc) {
        fy fyVarF = i.f();
        if (fyVarF.isEmpty()) {
            return;
        }
        fyVarF.forEach(new Consumer() { // from class: com.google.android.libraries.navigation.internal.yr.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((aj) obj).a();
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.yr.d
    public final ag e(String str, z zVar, boolean z, ae aeVar) {
        if (z && !this.d) {
            i.j();
        }
        return new s(str, this, zVar, (z && !this.d) || this.d, aeVar);
    }

    @Override // com.google.android.libraries.navigation.internal.yr.d
    public final Exception f() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.d
    public final boolean g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final z i() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ag
    public final ag j(String str, z zVar, ae aeVar) {
        return e(str, zVar, true, aeVar);
    }

    public s(UUID uuid, String str, z zVar, Exception exc, boolean z, boolean z2, ae aeVar) {
        super("<missing root>:".concat(String.valueOf(str)), uuid, z.a(zVar, y.b), aeVar);
        this.b = z2;
        this.c = exc;
        this.d = z;
    }
}
