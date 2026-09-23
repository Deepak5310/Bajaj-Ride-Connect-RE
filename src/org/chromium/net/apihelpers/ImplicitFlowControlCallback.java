package org.chromium.net.apihelpers;

import java.nio.ByteBuffer;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ImplicitFlowControlCallback extends UrlRequest.Callback {
    private static final int BYTE_BUFFER_CAPACITY = 32768;

    protected abstract void onBodyChunkRead(UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception;

    protected abstract void onCanceled(UrlResponseInfo urlResponseInfo);

    protected abstract void onFailed(UrlResponseInfo urlResponseInfo, CronetException cronetException);

    protected abstract void onResponseStarted(UrlResponseInfo urlResponseInfo) throws Exception;

    protected abstract void onSucceeded(UrlResponseInfo urlResponseInfo);

    protected abstract boolean shouldFollowRedirect(UrlResponseInfo urlResponseInfo, String str) throws Exception;

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        onResponseStarted(urlResponseInfo);
        urlRequest.read(ByteBuffer.allocateDirect(32768));
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        if (shouldFollowRedirect(urlResponseInfo, str)) {
            urlRequest.followRedirect();
        } else {
            urlRequest.cancel();
        }
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onReadCompleted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, ByteBuffer byteBuffer) throws Exception {
        onBodyChunkRead(urlResponseInfo, byteBuffer);
        urlRequest.read(byteBuffer);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        onSucceeded(urlResponseInfo);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        onFailed(urlResponseInfo, cronetException);
    }

    @Override // org.chromium.net.UrlRequest.Callback
    public final void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        onCanceled(urlResponseInfo);
    }
}
