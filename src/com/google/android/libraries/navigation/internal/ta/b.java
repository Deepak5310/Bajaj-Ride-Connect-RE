package com.google.android.libraries.navigation.internal.ta;

import com.google.android.libraries.geo.navcore.guidance.impl.NavApiImpl;
import com.google.android.libraries.geo.navcore.jni.NavCppInstance;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bn;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public b(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        bj bjVar = (bj) this.a.a();
        bn bnVarA = ((com.google.android.libraries.navigation.internal.hy.x) this.b).a();
        final NavApiImpl navApiImpl = new NavApiImpl(bnVarA);
        synchronized (navApiImpl) {
            navApiImpl.a = com.google.android.libraries.navigation.internal.yu.a.b(bjVar).c(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.ae
                @Override // com.google.android.libraries.navigation.internal.yx.aa
                public final Object ak(Object obj) {
                    NavApiImpl.nativeInitClass();
                    return Long.valueOf(navApiImpl.nativeAllocateAndSubscribe(((NavCppInstance) obj).a()));
                }
            }, bnVarA);
        }
        return navApiImpl;
    }
}
