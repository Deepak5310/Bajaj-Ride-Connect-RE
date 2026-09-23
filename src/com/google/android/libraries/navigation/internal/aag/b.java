package com.google.android.libraries.navigation.internal.aag;

import android.content.Context;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends i {
    public final String a;
    public final boolean b;
    private final Context c;
    private final boolean d;
    private final boolean e;
    private final int f;
    private final String g;
    private final j h;
    private final int i;

    public b(Context context, String str, boolean z, boolean z2, boolean z3, int i, String str2, j jVar, int i2) {
        this.c = context;
        this.a = str;
        this.d = z;
        this.b = z2;
        this.e = z3;
        this.f = i;
        this.g = str2;
        this.h = jVar;
        this.i = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final int a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final int b() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final Context c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final j d() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final String e() {
        return this.g;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            Context context = this.c;
            if (context != null ? context.equals(iVar.c()) : iVar.c() == null) {
                String str = this.a;
                if (str != null ? str.equals(iVar.f()) : iVar.f() == null) {
                    if (this.d == iVar.i()) {
                        iVar.j();
                        if (this.b == iVar.g()) {
                            iVar.k();
                            if (this.e == iVar.h() && this.f == iVar.a()) {
                                iVar.l();
                                iVar.m();
                                String str2 = this.g;
                                if (str2 != null ? str2.equals(iVar.e()) : iVar.e() == null) {
                                    j jVar = this.h;
                                    if (jVar != null ? jVar.equals(iVar.d()) : iVar.d() == null) {
                                        if (this.i == iVar.b()) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final String f() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final boolean g() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final boolean h() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final boolean i() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final void k() {
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final void l() {
    }

    @Override // com.google.android.libraries.navigation.internal.aag.i
    public final void m() {
    }

    public final String toString() {
        j jVar = this.h;
        return "CronetConfig{context=" + String.valueOf(this.c) + ", storagePath=" + this.a + ", enableQuic=" + this.d + ", enableBrotli=false, enableCertificateCache=" + this.b + ", enableHttpCache=false, enableNetworkQualityEstimator=" + this.e + ", diskCacheSizeBytes=" + this.f + ", inMemoryFallbackCacheSizeBytes=0, libraryLoader=null, experimentalOptions=" + this.g + ", cronetEngineBuilderFactory=" + String.valueOf(jVar) + ", threadPriority=" + this.i + "}";
    }

    public final int hashCode() {
        Context context = this.c;
        int iHashCode = context == null ? 0 : context.hashCode();
        String str = this.a;
        int iHashCode2 = (((((((((((((iHashCode ^ 1000003) * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ 1237) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003;
        int i = this.f;
        String str2 = this.g;
        int iHashCode3 = (((iHashCode2 ^ i) * 583896283) ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        j jVar = this.h;
        return ((iHashCode3 ^ (jVar != null ? jVar.hashCode() : 0)) * 1000003) ^ this.i;
    }
}
