package com.google.android.libraries.navigation.internal.abg;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.b.aa;
import com.google.android.libraries.navigation.internal.b.ad;
import com.google.android.libraries.navigation.internal.b.z;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class v implements aa {
    public static final String c = "v";

    public static String d(ad adVar) {
        String str;
        com.google.android.libraries.navigation.internal.b.o oVar = adVar.a;
        if (oVar == null) {
            return "VolleyError(\"" + adVar.getMessage() + "\")";
        }
        aj ajVarC = aj.f(adVar).c("ResponseCode", oVar.a);
        ajVarC.g("Headers", String.valueOf(oVar.c));
        byte[] bArr = oVar.b;
        if (bArr == null) {
            str = "<empty>";
        } else {
            str = "[" + bArr.length + " bytes]";
        }
        ajVarC.g("Data", str);
        return ajVarC.toString();
    }

    public static void e(com.google.android.libraries.navigation.internal.b.t tVar) {
        String str;
        String strValueOf;
        try {
            byte[] bArrO = tVar.o();
            if (bArrO == null) {
                str = "<empty>";
            } else {
                str = "[" + bArrO.length + " bytes]";
            }
        } catch (com.google.android.libraries.navigation.internal.b.a unused) {
            str = "[Error retrieving body]";
        }
        try {
            strValueOf = String.valueOf(tVar.e());
        } catch (com.google.android.libraries.navigation.internal.b.a unused2) {
            strValueOf = "[Error retrieving headers]";
        }
        aj ajVarF = aj.f(tVar);
        ajVarF.g("URL", tVar.c);
        ajVarF.g("Headers", strValueOf);
        ajVarF.g("Method", tVar.b != 0 ? "POST" : "GET");
        ajVarF.g("Body", str);
        ajVarF.g("BodyContentType", tVar.c());
        ajVarF.toString();
    }

    public static void f(z zVar) {
        if (zVar.a()) {
            return;
        }
        d(zVar.c);
    }

    @Override // com.google.android.libraries.navigation.internal.b.aa
    public void a(com.google.android.libraries.navigation.internal.b.t tVar, ad adVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.b.aa
    public void b(com.google.android.libraries.navigation.internal.b.t tVar, z zVar) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.b.aa
    public final void c(com.google.android.libraries.navigation.internal.b.t tVar, z zVar, Runnable runnable) {
        throw null;
    }
}
