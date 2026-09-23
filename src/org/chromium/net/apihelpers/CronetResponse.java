package org.chromium.net.apihelpers;

import java.util.Objects;
import org.chromium.net.UrlResponseInfo;

/* JADX INFO: loaded from: classes5.dex */
public class CronetResponse<T> {
    private final T mResponseBody;
    private final UrlResponseInfo mUrlResponseInfo;

    CronetResponse(UrlResponseInfo urlResponseInfo, T t) {
        this.mUrlResponseInfo = urlResponseInfo;
        this.mResponseBody = t;
    }

    public UrlResponseInfo getUrlResponseInfo() {
        return this.mUrlResponseInfo;
    }

    public T getResponseBody() {
        return this.mResponseBody;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CronetResponse)) {
            return false;
        }
        CronetResponse cronetResponse = (CronetResponse) obj;
        return Objects.equals(this.mUrlResponseInfo, cronetResponse.mUrlResponseInfo) && Objects.equals(this.mResponseBody, cronetResponse.mResponseBody);
    }

    public int hashCode() {
        return Objects.hash(this.mUrlResponseInfo, this.mResponseBody);
    }
}
