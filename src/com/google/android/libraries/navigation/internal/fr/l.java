package com.google.android.libraries.navigation.internal.fr;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements d {
    public static final k a = new k();
    private static final com.google.android.libraries.navigation.internal.zb.j d;
    public final Context b;
    public final com.google.android.libraries.navigation.internal.nm.a c;
    private final d e;

    static {
        com.google.android.libraries.navigation.internal.zb.j jVarE = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.fr.l");
        Intrinsics.checkNotNullExpressionValue(jVarE, "forInjectedClassName(...)");
        d = jVarE;
    }

    public l(Context applicationContext, d networkState, com.google.android.libraries.navigation.internal.nm.a gservicesWrapper) {
        Intrinsics.checkNotNullParameter(applicationContext, "applicationContext");
        Intrinsics.checkNotNullParameter(networkState, "networkState");
        Intrinsics.checkNotNullParameter(gservicesWrapper, "gservicesWrapper");
        this.b = applicationContext;
        this.e = networkState;
        this.c = gservicesWrapper;
        new j(applicationContext);
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final c a() {
        return this.e.a();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final void b() {
        this.e.b();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean c() {
        return this.e.c();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean d() {
        return this.e.d();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean e() {
        return this.e.e();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean f() {
        return this.e.f();
    }

    @Override // com.google.android.libraries.navigation.internal.fr.d
    public final boolean g() {
        return this.e.g();
    }

    public final List h() {
        try {
            Set<String> setKeySet = this.c.a("user_location_reporting:experiment:").keySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setKeySet, 10));
            for (String str : setKeySet) {
                Intrinsics.checkNotNull(str);
                arrayList.add(StringsKt.replace$default(str, "user_location_reporting:experiment:", "", false, 4, (Object) null));
            }
            return arrayList;
        } catch (SecurityException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(514)).p("Failed to read from GServices. Missing READ_GSERVICES permission?");
            return CollectionsKt.emptyList();
        }
    }
}
