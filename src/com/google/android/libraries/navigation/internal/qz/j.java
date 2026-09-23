package com.google.android.libraries.navigation.internal.qz;

import android.graphics.Picture;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.yx.aa;
import java.io.ByteArrayInputStream;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends f {
    final /* synthetic */ k a;
    private final byte[] c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, byte[] bArr) {
        super(kVar);
        this.a = kVar;
        this.c = bArr;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.f
    protected final /* synthetic */ aa a(Object obj) {
        final Picture picture = (Picture) obj;
        return new aa() { // from class: com.google.android.libraries.navigation.internal.qz.h
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj2) {
                x xVar = (x) obj2;
                return new i(new Object[]{this.a.a.f, xVar}, picture, xVar);
            }
        };
    }

    @Override // com.google.android.libraries.navigation.internal.qz.f
    protected final /* bridge */ /* synthetic */ Object b() {
        try {
            com.google.android.libraries.navigation.internal.afn.e eVar = new com.google.android.libraries.navigation.internal.afn.e();
            eVar.b();
            eVar.a = new ByteArrayInputStream(this.c);
            eVar.b = true;
            return eVar.a().a;
        } catch (com.google.android.libraries.navigation.internal.afn.d e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) k.a.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1295)).p("Cannot parse SVG.");
            return null;
        }
    }
}
