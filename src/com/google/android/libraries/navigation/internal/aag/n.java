package com.google.android.libraries.navigation.internal.aag;

import com.google.android.libraries.navigation.internal.afr.p;
import java.util.Iterator;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.RequestFinishedInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;

    public n(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        ExperimentalCronetEngine experimentalCronetEngine = (ExperimentalCronetEngine) this.a.a();
        Iterator it2 = ((p) this.b).a().iterator();
        while (it2.hasNext()) {
            experimentalCronetEngine.addRequestFinishedListener((RequestFinishedInfo.Listener) it2.next());
        }
        com.google.android.libraries.navigation.internal.afr.j.d(experimentalCronetEngine);
        return experimentalCronetEngine;
    }
}
