package com.google.android.libraries.navigation.internal.ht;

import com.google.android.libraries.navigation.internal.afl.ha;
import java.util.EnumSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public f(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Object objOf = ((Boolean) this.a.a()).booleanValue() ? com.google.android.libraries.navigation.internal.hn.s.a : EnumSet.of(ha.ENABLE_FEATURES, ha.EXPERIMENT_ATTRIBUTION_MAP, ha.LOGGING, ha.MAPS_ACTIVITIES, ha.PAINT_PARAMETERS, ha.PARTNER_APPS, ha.PHENOTYPE_MIGRATION, ha.TRIGGER_EXPERIMENT_ID, ha.VECTOR_MAPS);
        com.google.android.libraries.navigation.internal.afr.j.d(objOf);
        return objOf;
    }
}
