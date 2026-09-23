package com.google.android.libraries.navigation.internal.yh;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends m {
    public final Uri a;
    public final cy b;
    public final com.google.android.libraries.navigation.internal.yx.an c;
    public final ev d;
    public final ah e;
    public final boolean f;

    public b(Uri uri, cy cyVar, com.google.android.libraries.navigation.internal.yx.an anVar, ev evVar, ah ahVar, boolean z) {
        this.a = uri;
        this.b = cyVar;
        this.c = anVar;
        this.d = evVar;
        this.e = ahVar;
        this.f = z;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.m
    public final Uri a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.m
    public final ah b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.m
    public final com.google.android.libraries.navigation.internal.yx.an c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.m
    public final ev d() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.m
    public final cy e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.a.equals(mVar.a()) && this.b.equals(mVar.e()) && this.c.equals(mVar.c()) && hx.i(this.d, mVar.d()) && this.e.equals(mVar.b()) && this.f == mVar.f()) {
                mVar.g();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.m
    public final boolean f() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.m
    public final void g() {
    }

    public final int hashCode() {
        return ((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ (true != this.f ? 1237 : 1231)) * 1000003) ^ 1237;
    }

    public final String toString() {
        ah ahVar = this.e;
        ev evVar = this.d;
        com.google.android.libraries.navigation.internal.yx.an anVar = this.c;
        cy cyVar = this.b;
        return "ProtoDataStoreConfig{uri=" + String.valueOf(this.a) + ", schema=" + String.valueOf(cyVar) + ", handler=" + String.valueOf(anVar) + ", migrations=" + String.valueOf(evVar) + ", variantConfig=" + String.valueOf(ahVar) + ", useGeneratedExtensionRegistry=" + this.f + ", enableTracing=false}";
    }
}
