package com.google.android.libraries.navigation.internal.abn;

import android.os.RemoteException;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class av {
    public final com.google.android.libraries.navigation.internal.ly.g a;

    public av(com.google.android.libraries.navigation.internal.ly.g gVar) {
        this.a = gVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof av) {
            return com.google.android.libraries.navigation.internal.abf.r.a(this.a, ((av) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("callback", this.a);
        return ajVarF.toString();
    }

    public final void a() {
        try {
            this.a.a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public final void b() {
        try {
            this.a.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
