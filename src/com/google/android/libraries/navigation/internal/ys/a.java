package com.google.android.libraries.navigation.internal.ys;

import com.google.android.libraries.navigation.internal.yr.at;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yr.i;
import java.nio.ByteBuffer;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends UrlRequest.Callback {
    private final UrlRequest.Callback a;
    private final at b = new at(i.c());

    public a(UrlRequest.Callback callback) {
        this.a = callback;
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        at atVarA = at.a(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        at.b(this.b);
        try {
            this.a.onCanceled(urlRequest, urlResponseInfo);
        } finally {
            at.b(atVarA);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        at atVarA = at.a(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        at.b(this.b);
        try {
            this.a.onFailed(urlRequest, urlResponseInfo, cronetException);
        } finally {
            at.b(atVarA);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        at atVarA = at.a(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        at.b(this.b);
        try {
            this.a.onReadCompleted(urlRequest, urlResponseInfo, byteBuffer);
        } finally {
            at.b(atVarA);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        at atVarA = at.a(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        at.b(this.b);
        try {
            this.a.onRedirectReceived(urlRequest, urlResponseInfo, str);
        } finally {
            at.b(atVarA);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        at atVarA = at.a(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        at.b(this.b);
        try {
            this.a.onResponseStarted(urlRequest, urlResponseInfo);
        } finally {
            at.b(atVarA);
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        at atVarA = at.a(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        at.b(this.b);
        try {
            this.a.onSucceeded(urlRequest, urlResponseInfo);
        } finally {
            at.b(atVarA);
        }
    }
}
