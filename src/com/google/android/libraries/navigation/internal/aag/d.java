package com.google.android.libraries.navigation.internal.aag;

import android.content.Context;
import android.os.StrictMode;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Iterator;
import java.util.Set;
import org.chromium.net.ExperimentalCronetEngine;
import org.chromium.net.NetworkQualityRttListener;
import org.chromium.net.NetworkQualityThroughputListener;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class d {
    public static ExperimentalCronetEngine.Builder a(Context context, Set set, Set set2, an anVar, an anVar2, com.google.android.libraries.navigation.internal.agl.a aVar) {
        ExperimentalCronetEngine.Builder builder = null;
        if (anVar.g()) {
            i iVar = (i) anVar.c();
            if (iVar.c() != null) {
                context = iVar.c();
            }
            if (iVar.d() != null) {
                builder = iVar.d().a();
            }
        }
        if (builder == null) {
            builder = new ExperimentalCronetEngine.Builder(context);
        }
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            l lVar = (l) it2.next();
            builder.addQuicHint(lVar.c(), lVar.b(), lVar.a());
        }
        an anVar3 = (an) ((com.google.android.libraries.navigation.internal.afr.g) aVar).a;
        if (anVar3.g() && set2.isEmpty()) {
            throw new IllegalArgumentException("Google digests were provided, but no hostnames were pinned - this is either a security vulnerability or a waste of APK size. Add hostnames, or remove the dep on google digests.");
        }
        if (!set2.isEmpty() && !anVar3.g()) {
            throw new IllegalArgumentException("Pinning was requested, but digests weren't provided. Add a dependency on the google digests.");
        }
        if (anVar2.g()) {
            ar.l(!set2.isEmpty(), "Local trust anchor bypass was specified, but no pinned hostnames were provided.");
            builder.enablePublicKeyPinningBypassForLocalTrustAnchors(((Boolean) anVar2.c()).booleanValue());
        }
        Iterator it3 = set2.iterator();
        while (it3.hasNext()) {
            k kVar = (k) it3.next();
            builder.addPublicKeyPins(kVar.a(), (Set<byte[]>) anVar3.c(), kVar.c(), kVar.b());
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        try {
            StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
            if (anVar.g()) {
                i iVar2 = (i) anVar.c();
                builder.enableQuic(iVar2.i());
                builder.enableBrotli(false);
                if (iVar2.e() != null) {
                    builder.setExperimentalOptions(iVar2.e());
                }
                if (iVar2.b() != 20) {
                    builder.setThreadPriority(iVar2.b());
                }
            } else {
                builder.enableQuic(true);
            }
            return builder;
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void b(an anVar, ExperimentalCronetEngine.Builder builder) {
        if (anVar.g()) {
            builder.enableNetworkQualityEstimator(((i) anVar.c()).h());
        }
    }

    public static void c(an anVar, ExperimentalCronetEngine experimentalCronetEngine, com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2) {
        if (anVar.g() && ((i) anVar.c()).h()) {
            Iterator it2 = ((Set) aVar.a()).iterator();
            while (it2.hasNext()) {
                experimentalCronetEngine.addRttListener((NetworkQualityRttListener) it2.next());
            }
            Iterator it3 = ((Set) ((com.google.android.libraries.navigation.internal.afr.g) aVar2).a).iterator();
            while (it3.hasNext()) {
                experimentalCronetEngine.addThroughputListener((NetworkQualityThroughputListener) it3.next());
            }
        }
    }

    public static void d(an anVar, ExperimentalCronetEngine.Builder builder) {
        if (anVar.g()) {
            builder.enableHttpCache(0, 0L);
        }
    }
}
