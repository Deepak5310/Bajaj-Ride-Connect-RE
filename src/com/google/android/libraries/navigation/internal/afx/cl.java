package com.google.android.libraries.navigation.internal.afx;

import com.mappls.sdk.navigation.util.SavingTrackHelper;
import com.spotify.sdk.android.auth.AccountsQueryParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cl {
    public static final List a;
    public static final cl b;
    public static final cl c;
    public static final cl d;
    public static final cl e;
    public static final cl f;
    private static final bn j;
    public final ci g;
    public final String h;
    public final Throwable i;

    static {
        TreeMap treeMap = new TreeMap();
        for (ci ciVar : ci.values()) {
            cl clVar = (cl) treeMap.put(Integer.valueOf(ciVar.r), new cl(ciVar, null, null));
            if (clVar != null) {
                throw new IllegalStateException("Code value duplication between " + clVar.g.name() + " & " + ciVar.name());
            }
        }
        a = Collections.unmodifiableList(new ArrayList(treeMap.values()));
        b = ci.OK.a();
        ci.CANCELLED.a();
        c = ci.UNKNOWN.a();
        ci.INVALID_ARGUMENT.a();
        ci.DEADLINE_EXCEEDED.a();
        ci.NOT_FOUND.a();
        ci.ALREADY_EXISTS.a();
        ci.PERMISSION_DENIED.a();
        ci.UNAUTHENTICATED.a();
        ci.RESOURCE_EXHAUSTED.a();
        d = ci.FAILED_PRECONDITION.a();
        ci.ABORTED.a();
        ci.OUT_OF_RANGE.a();
        ci.UNIMPLEMENTED.a();
        e = ci.INTERNAL.a();
        f = ci.UNAVAILABLE.a();
        ci.DATA_LOSS.a();
        cj cjVar = new cj();
        int i = bl.b;
        new bm("grpc-status", false, cjVar);
        ck ckVar = new ck();
        j = ckVar;
        new bm("grpc-message", false, ckVar);
    }

    private cl(ci ciVar, String str, Throwable th) {
        com.google.android.libraries.navigation.internal.yx.ar.r(ciVar, AccountsQueryParameters.CODE);
        this.g = ciVar;
        this.h = str;
        this.i = th;
    }

    public final cl a(Throwable th) {
        return com.google.android.libraries.navigation.internal.yx.am.a(this.i, th) ? this : new cl(this.g, this.h, th);
    }

    public final cl b(String str) {
        return com.google.android.libraries.navigation.internal.yx.am.a(this.h, str) ? this : new cl(this.g, str, this.i);
    }

    public final boolean c() {
        return ci.OK == this.g;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g(AccountsQueryParameters.CODE, this.g.name());
        akVarB.g(SavingTrackHelper.POINT_COL_DESCRIPTION, this.h);
        Throwable th = this.i;
        Object objA = th;
        if (th != null) {
            objA = com.google.android.libraries.navigation.internal.yx.bx.a(th);
        }
        akVarB.g("cause", objA);
        return akVarB.toString();
    }
}
