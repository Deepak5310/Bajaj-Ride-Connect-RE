package com.google.android.libraries.navigation.internal.yh;

import android.net.Uri;
import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends l {
    public com.google.android.libraries.navigation.internal.yx.an a = com.google.android.libraries.navigation.internal.yx.a.a;
    public ah b;
    public boolean c;
    public byte d;
    private Uri e;
    private cy f;
    private ev g;

    @Override // com.google.android.libraries.navigation.internal.yh.l
    public final m a() {
        Uri uri;
        cy cyVar;
        ah ahVar;
        if (this.g == null) {
            int i = ev.d;
            this.g = lv.a;
        }
        if (this.d == 3 && (uri = this.e) != null && (cyVar = this.f) != null && (ahVar = this.b) != null) {
            return new b(uri, cyVar, this.a, this.g, ahVar, this.c);
        }
        StringBuilder sb = new StringBuilder();
        if (this.e == null) {
            sb.append(" uri");
        }
        if (this.f == null) {
            sb.append(" schema");
        }
        if (this.b == null) {
            sb.append(" variantConfig");
        }
        if ((this.d & 1) == 0) {
            sb.append(" useGeneratedExtensionRegistry");
        }
        if ((this.d & 2) == 0) {
            sb.append(" enableTracing");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.libraries.navigation.internal.yh.l
    public final void b() {
        this.d = (byte) (this.d | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.yh.l
    public final void c(cy cyVar) {
        if (cyVar == null) {
            throw new NullPointerException("Null schema");
        }
        this.f = cyVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yh.l
    public final void d(Uri uri) {
        if (uri == null) {
            throw new NullPointerException("Null uri");
        }
        this.e = uri;
    }
}
