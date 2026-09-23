package com.google.android.libraries.navigation.internal.nf;

import android.accounts.Account;
import com.google.android.libraries.navigation.internal.aac.be;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.google.android.libraries.navigation.internal.ng.b {
    public static final Account a = new Account("signedout@", "com.google.android.apps.maps");
    private final com.google.android.libraries.navigation.internal.agl.a b;
    private final an c;
    private final an d;

    public c(com.google.android.libraries.navigation.internal.agl.a aVar, an anVar, an anVar2) {
        this.b = aVar;
        this.c = anVar;
        this.d = anVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.ng.b
    public final Account a() {
        return (Account) ((an) this.b.a()).d(new br() { // from class: com.google.android.libraries.navigation.internal.nf.a
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return c.a;
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.ng.b
    public final an b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ng.b
    public final bj c() {
        return ((com.google.android.libraries.navigation.internal.ng.a) this.d.e(new com.google.android.libraries.navigation.internal.ng.a() { // from class: com.google.android.libraries.navigation.internal.nf.b
            @Override // com.google.android.libraries.navigation.internal.ng.a
            public final bj a() {
                return be.a;
            }
        })).a();
    }
}
