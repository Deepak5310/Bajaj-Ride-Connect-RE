package com.google.android.libraries.navigation.internal.nr;

import android.content.Context;
import com.google.android.libraries.navigation.internal.nk.r;
import com.google.android.libraries.navigation.internal.nk.s;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zb.j;
import com.google.common.primitives.SignedBytes;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.afr.f {
    private final com.google.android.libraries.navigation.internal.agl.a a;
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final com.google.android.libraries.navigation.internal.agl.a c;
    private final com.google.android.libraries.navigation.internal.agl.a d;
    private final com.google.android.libraries.navigation.internal.agl.a e;
    private final com.google.android.libraries.navigation.internal.agl.a f;

    public a(com.google.android.libraries.navigation.internal.agl.a aVar, com.google.android.libraries.navigation.internal.agl.a aVar2, com.google.android.libraries.navigation.internal.agl.a aVar3, com.google.android.libraries.navigation.internal.agl.a aVar4, com.google.android.libraries.navigation.internal.agl.a aVar5, com.google.android.libraries.navigation.internal.agl.a aVar6) {
        this.a = aVar;
        this.b = aVar2;
        this.c = aVar3;
        this.d = aVar4;
        this.e = aVar5;
        this.f = aVar6;
    }

    @Override // com.google.android.libraries.navigation.internal.agl.a, com.google.android.libraries.navigation.internal.agk.a
    public final /* bridge */ /* synthetic */ Object a() {
        Context context = (Context) this.a.a();
        an anVar = (an) this.b.a();
        d dVarA = ((e) this.c).a();
        s sVar = (s) this.d.a();
        Map mapA = ((com.google.android.libraries.navigation.internal.afr.i) this.e).a();
        ((com.google.android.libraries.navigation.internal.nk.h) this.f.a()).a.a();
        com.google.android.libraries.navigation.internal.aag.a aVar = new com.google.android.libraries.navigation.internal.aag.a();
        aVar.c = true;
        aVar.f = (byte) (((byte) (aVar.f | 1)) | 2);
        aVar.c(false);
        aVar.f = (byte) (aVar.f | 8);
        aVar.d(false);
        aVar.b(1000);
        aVar.f = (byte) (aVar.f | SignedBytes.MAX_POWER_OF_TWO);
        aVar.e(20);
        aVar.a = (Context) anVar.e(context);
        aVar.e = dVarA;
        aVar.d(true);
        aVar.c(true);
        aVar.b = "cronet-cache-" + context.getPackageName().hashCode();
        aVar.b(1048576);
        r rVar = sVar.a().c;
        if (rVar == null) {
            rVar = r.a;
        }
        if ((rVar.b & 2) != 0) {
            r rVar2 = sVar.a().c;
            if (rVar2 == null) {
                rVar2 = r.a;
            }
            aVar.e(rVar2.d);
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : mapA.entrySet()) {
            String str = (String) entry.getKey();
            try {
                jSONObject.put(str, entry.getValue());
            } catch (JSONException unused) {
                ((com.google.android.libraries.navigation.internal.zb.h) j.b.F(798)).s("Exception trying to set experimental Cronet option: %s", str);
            }
        }
        if (jSONObject.length() > 0) {
            aVar.d = jSONObject.toString();
        }
        com.google.android.libraries.navigation.internal.aag.i iVarA = aVar.a();
        com.google.android.libraries.navigation.internal.aag.b bVar = (com.google.android.libraries.navigation.internal.aag.b) iVarA;
        if (bVar.b) {
            ar.l(bVar.a != null, "Must specify cache storage path.");
        }
        return iVarA;
    }
}
