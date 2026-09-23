package com.google.android.libraries.navigation.internal.gg;

import com.google.android.libraries.navigation.internal.afx.ci;
import com.google.android.libraries.navigation.internal.km.aq;
import com.google.android.libraries.navigation.internal.yx.ah;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bx;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.mappls.sdk.navigation.util.SavingTrackHelper;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
@Deprecated
public final class o {
    public static final o a = new o(com.google.android.libraries.navigation.internal.fw.g.HTTP_UNKNOWN_STATUS_CODE);
    public static final o b = new o(com.google.android.libraries.navigation.internal.fw.g.REQUEST_TIMEOUT);
    public static final o c = new o(com.google.android.libraries.navigation.internal.fw.g.IO_ERROR);
    public static final o d = new o(com.google.android.libraries.navigation.internal.fw.g.CANCELED);
    public static final o e = new o(com.google.android.libraries.navigation.internal.fw.g.PROTOCOL_ERROR_INVALID_CONTENT_TYPE);
    public static final o f = new o(com.google.android.libraries.navigation.internal.fw.g.PROTOCOL_ERROR_VERSION_MISMATCH);
    public static final o g = new o(com.google.android.libraries.navigation.internal.fw.g.MALFORMED_MESSAGE);
    public static final o h = new o(com.google.android.libraries.navigation.internal.fw.g.HTTP_BAD_REQUEST);
    public static final o i = new o(com.google.android.libraries.navigation.internal.fw.g.INVALID_API_TOKEN);
    public static final o j = new o(com.google.android.libraries.navigation.internal.fw.g.HTTP_SERVER_ERROR);
    public static final o k = new o(com.google.android.libraries.navigation.internal.fw.g.NO_CONNECTIVITY);
    public static final o l = new o(com.google.android.libraries.navigation.internal.fw.g.UNSUPPORTED_REQUEST_TYPE);
    public static final o m = new o(com.google.android.libraries.navigation.internal.fw.g.HTTP_NOT_FOUND);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final o f438n = new o(com.google.android.libraries.navigation.internal.fw.g.INVALID_GAIA_AUTH_TOKEN);
    public static final o o = new o(com.google.android.libraries.navigation.internal.fw.g.CANNOT_CREATE_REQUEST);
    private static final fd u;
    public final com.google.android.libraries.navigation.internal.fw.g p;
    public final String q;
    public final Throwable r;
    public final Integer s;
    public final Map t;

    static {
        ez ezVar = new ez();
        ezVar.f(3, aq.INVALID_ARGUMENT);
        ezVar.f(9, aq.FAILED_PRECONDITION);
        ezVar.f(11, aq.OUT_OF_RANGE);
        ezVar.f(13, aq.INTERNAL);
        ezVar.f(14, aq.UNAVAILABLE);
        ezVar.f(4, aq.DEADLINE_EXCEEDED);
        ezVar.f(7, aq.PERMISSION_DENIED);
        ezVar.f(16, aq.UNAUTHENTICATED);
        u = ezVar.d();
    }

    private o(com.google.android.libraries.navigation.internal.fw.g gVar) {
        this(gVar, null, null, null, ma.b);
    }

    public static o a(int i2) {
        if (i2 == 400) {
            return h;
        }
        if (i2 == 401) {
            return f438n;
        }
        if (i2 == 403) {
            return i;
        }
        if (i2 == 404) {
            return m;
        }
        if (i2 != 500) {
            if (i2 == 501) {
                return f;
            }
            if (i2 != 503) {
                return a;
            }
        }
        return j;
    }

    public static o b(Throwable th) {
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof TimeoutException) {
                return b.c(th);
            }
            if (cause instanceof p) {
                return ((p) cause).a;
            }
            if (cause instanceof CancellationException) {
                return d.c(th);
            }
            if (cause instanceof SecurityException) {
                return b.c(th);
            }
        }
        return a.c(th);
    }

    public final o c(Throwable th) {
        return am.a(this.r, th) ? this : new o(this.p, this.q, th, this.s, this.t);
    }

    public final o d(String str) {
        return am.a(this.q, str) ? this : new o(this.p, str, this.r, this.s, this.t);
    }

    public final aq e() {
        fd fdVar = u;
        if (fdVar.containsKey(this.s)) {
            return (aq) fdVar.get(this.s);
        }
        ci ciVar = ci.OK;
        com.google.android.libraries.navigation.internal.fw.g gVar = com.google.android.libraries.navigation.internal.fw.g.PROTOCOL_ERROR_INVALID_CONTENT_TYPE;
        switch (this.p) {
            case PROTOCOL_ERROR_INVALID_CONTENT_TYPE:
                return aq.PROTOCOL_ERROR_INVALID_CONTENT_TYPE;
            case PROTOCOL_ERROR_VERSION_MISMATCH:
                return aq.PROTOCOL_ERROR_VERSION_MISMATCH;
            case HTTP_BAD_REQUEST:
                return aq.HTTP_BAD_REQUEST;
            case HTTP_NOT_FOUND:
                return aq.HTTP_NOT_FOUND;
            case HTTP_SERVER_ERROR:
                return aq.HTTP_SERVER_ERROR;
            case HTTP_UNKNOWN_STATUS_CODE:
            case SINGLE_REQUEST_ERROR:
            case SINGLE_REQUEST_FATAL_ERROR:
            case CAPACITY_LIMIT_EXCEEDED:
            default:
                return aq.HTTP_UNKNOWN_STATUS_CODE;
            case IO_ERROR:
                return aq.IO_ERROR;
            case NO_CONNECTIVITY:
                return aq.NO_CONNECTIVITY;
            case INVALID_API_TOKEN:
                return aq.INVALID_API_TOKEN;
            case INVALID_GAIA_AUTH_TOKEN:
                return aq.INVALID_GAIA_AUTH_TOKEN;
            case MALFORMED_MESSAGE:
                return aq.MALFORMED_MESSAGE;
            case REQUEST_TIMEOUT:
                return aq.REQUEST_TIMEOUT;
            case CANCELED:
                return aq.CANCELED;
            case UNSUPPORTED_REQUEST_TYPE:
                return aq.UNSUPPORTED_REQUEST_TYPE;
            case CANNOT_CREATE_REQUEST:
                return aq.CANNOT_CREATE_REQUEST;
        }
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof o)) {
            return ((o) obj).p.equals(this.p);
        }
        return false;
    }

    public final int hashCode() {
        return this.p.hashCode();
    }

    public final String toString() {
        ak akVarB = al.b(this);
        akVarB.g("errorCode", this.p);
        akVarB.g(SavingTrackHelper.POINT_COL_DESCRIPTION, this.q);
        Throwable th = this.r;
        akVarB.g("cause", th == null ? "" : bx.a(th));
        akVarB.g("errorDetails", ah.e(',').d(String.valueOf('=')).a(this.t));
        return akVarB.toString();
    }

    public o(com.google.android.libraries.navigation.internal.fw.g gVar, String str, Throwable th, Integer num, Map map) {
        ar.q(gVar);
        this.p = gVar;
        this.q = str;
        this.r = th;
        this.s = num;
        this.t = map;
    }
}
