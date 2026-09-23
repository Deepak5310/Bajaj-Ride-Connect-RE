package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class IndoorLevel {
    private final com.google.android.libraries.navigation.internal.lz.l a;

    public IndoorLevel(com.google.android.libraries.navigation.internal.lz.l lVar) {
        be.j(lVar);
        this.a = lVar;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IndoorLevel)) {
            return false;
        }
        try {
            return this.a.e(((IndoorLevel) obj).a);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getName() {
        try {
            return this.a.b();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public String getShortName() {
        try {
            return this.a.c();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public int hashCode() {
        try {
            return this.a.a();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    public void activate() {
        try {
            this.a.d();
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }
}
