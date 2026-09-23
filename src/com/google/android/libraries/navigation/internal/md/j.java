package com.google.android.libraries.navigation.internal.md;

import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.libraries.navigation.internal.ld.q;
import com.google.android.libraries.navigation.internal.ld.r;
import com.google.android.libraries.navigation.internal.ld.z;
import com.google.android.libraries.navigation.internal.lh.ab;
import com.google.android.libraries.navigation.internal.lh.be;
import com.google.android.libraries.navigation.internal.lh.bg;
import com.google.android.libraries.navigation.internal.lh.p;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.locks.Lock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j extends ab implements com.google.android.libraries.navigation.internal.mc.e {
    private final boolean t;
    private final p u;
    private final Bundle v;
    private final Integer w;

    public j(Context context, Looper looper, boolean z, p pVar, Bundle bundle, q qVar, r rVar) {
        super(context, looper, 44, pVar, qVar, rVar);
        this.t = true;
        this.u = pVar;
        this.v = bundle;
        this.w = pVar.g;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.ab, com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final int a() {
        return 12451000;
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final /* synthetic */ IInterface b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof g ? (g) iInterfaceQueryLocalInterface : new f(iBinder);
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String c() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final String d() {
        return "com.google.android.gms.signin.service.START";
    }

    @Override // com.google.android.libraries.navigation.internal.mc.e
    public final void e() {
        h(new com.google.android.libraries.navigation.internal.lh.h(this));
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k, com.google.android.libraries.navigation.internal.ld.i
    public final boolean n() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.mc.e
    public final void s(e eVar) {
        com.google.android.libraries.navigation.internal.kw.a aVar;
        try {
            Account account = this.u.a;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            if ("<<default account>>".equals(account.name)) {
                Context context = this.b;
                Lock lock = com.google.android.libraries.navigation.internal.kx.a.a;
                be.j(context);
                com.google.android.libraries.navigation.internal.kx.a.a.lock();
                try {
                    try {
                        if (com.google.android.libraries.navigation.internal.kx.a.b == null) {
                            com.google.android.libraries.navigation.internal.kx.a.b = new com.google.android.libraries.navigation.internal.kx.a(context.getApplicationContext());
                        }
                        com.google.android.libraries.navigation.internal.kx.a aVar2 = com.google.android.libraries.navigation.internal.kx.a.b;
                        com.google.android.libraries.navigation.internal.kx.a.a.unlock();
                        String strA = aVar2.a("defaultGoogleSignInAccount");
                        if (!TextUtils.isEmpty(strA)) {
                            String strA2 = aVar2.a("googleSignInAccount:" + strA);
                            if (strA2 != null) {
                                try {
                                    if (!TextUtils.isEmpty(strA2)) {
                                        JSONObject jSONObject = new JSONObject(strA2);
                                        String strOptString = jSONObject.optString("photoUrl");
                                        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
                                        long j = Long.parseLong(jSONObject.getString("expirationTime"));
                                        HashSet hashSet = new HashSet();
                                        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
                                        int length = jSONArray.length();
                                        for (int i = 0; i < length; i++) {
                                            hashSet.add(new z(jSONArray.getString(i)));
                                        }
                                        String strOptString2 = jSONObject.optString("id");
                                        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
                                        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
                                        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
                                        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
                                        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
                                        Long lValueOf = Long.valueOf(j);
                                        String string = jSONObject.getString("obfuscatedIdentifier");
                                        lValueOf.getClass();
                                        be.h(string);
                                        aVar = new com.google.android.libraries.navigation.internal.kw.a(strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
                                        aVar.f = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
                                    }
                                } catch (JSONException unused) {
                                }
                            }
                        }
                        aVar = null;
                    } catch (RemoteException unused2) {
                        return;
                    }
                } catch (Throwable th) {
                    com.google.android.libraries.navigation.internal.kx.a.a.unlock();
                    throw th;
                }
            } else {
                aVar = null;
            }
            Integer num = this.w;
            be.j(num);
            ((g) u()).e(new k(1, new bg(2, account, num.intValue(), aVar)), eVar);
        } catch (RemoteException unused3) {
            eVar.c(new m(1, new com.google.android.libraries.navigation.internal.lc.a(8, null), null));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lh.k
    protected final Bundle t() {
        if (!this.b.getPackageName().equals(this.u.d)) {
            this.v.putString("com.google.android.gms.signin.internal.realClientPackageName", this.u.d);
        }
        return this.v;
    }
}
