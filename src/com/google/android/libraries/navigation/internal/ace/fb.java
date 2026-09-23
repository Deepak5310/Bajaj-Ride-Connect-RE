package com.google.android.libraries.navigation.internal.ace;

import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fb implements oe {
    private final od a;
    private final com.google.android.libraries.navigation.internal.hp.d b;
    private final com.google.android.libraries.navigation.internal.hp.e c;

    public fb(od odVar, com.google.android.libraries.navigation.internal.hp.d dVar, com.google.android.libraries.navigation.internal.hp.e eVar) {
        this.a = odVar;
        this.b = dVar;
        this.c = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.ael.cy al() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ael.cz
    public final boolean am() {
        return this.a.am();
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final nq c() {
        this.b.a(CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE).c(this.c);
        nq nqVar = this.a.e;
        return nqVar == null ? nq.a : nqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final ns d() {
        this.b.a(142).c(this.c);
        ns nsVar = this.a.d;
        return nsVar == null ? ns.a : nsVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final oc e() {
        this.b.a(PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH).c(this.c);
        oc ocVar = this.a.c;
        return ocVar == null ? oc.a : ocVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final List f() {
        this.b.a(109).c(this.c);
        return this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final boolean g() {
        this.b.a(160).c(this.c);
        return this.a.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final boolean h() {
        this.b.a(159).c(this.c);
        return this.a.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ace.oe
    public final boolean i() {
        this.b.a(117).c(this.c);
        return this.a.f;
    }
}
