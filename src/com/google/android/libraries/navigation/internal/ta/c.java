package com.google.android.libraries.navigation.internal.ta;

import com.google.android.apps.gmm.jni.util.NativeHelper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;

    public c(com.google.android.libraries.navigation.internal.agl.a aVar) {
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        return com.google.android.libraries.navigation.internal.yu.a.b(NativeHelper.a(null)).c(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.geo.navcore.jni.a
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                if (!NavCppInstance.nativeInitClass()) {
                    throw new IllegalStateException("Failed to initialize NavCppInstance");
                }
                NavCppInstance navCppInstance = new NavCppInstance();
                navCppInstance.a = navCppInstance.nativeAllocate();
                return navCppInstance;
            }
        }, ((com.google.android.libraries.navigation.internal.hy.x) this.a).a());
    }
}
