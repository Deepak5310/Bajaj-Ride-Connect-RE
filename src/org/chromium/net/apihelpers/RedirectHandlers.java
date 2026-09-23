package org.chromium.net.apihelpers;

import org.chromium.net.UrlResponseInfo;

/* JADX INFO: loaded from: classes5.dex */
public class RedirectHandlers {
    static /* synthetic */ boolean lambda$alwaysFollow$1(UrlResponseInfo urlResponseInfo, String str) throws Exception {
        return true;
    }

    static /* synthetic */ boolean lambda$neverFollow$0(UrlResponseInfo urlResponseInfo, String str) throws Exception {
        return false;
    }

    public static RedirectHandler neverFollow() {
        return new RedirectHandler() { // from class: org.chromium.net.apihelpers.RedirectHandlers$$ExternalSyntheticLambda0
            @Override // org.chromium.net.apihelpers.RedirectHandler
            public final boolean shouldFollowRedirect(UrlResponseInfo urlResponseInfo, String str) {
                return RedirectHandlers.lambda$neverFollow$0(urlResponseInfo, str);
            }
        };
    }

    public static RedirectHandler alwaysFollow() {
        return new RedirectHandler() { // from class: org.chromium.net.apihelpers.RedirectHandlers$$ExternalSyntheticLambda1
            @Override // org.chromium.net.apihelpers.RedirectHandler
            public final boolean shouldFollowRedirect(UrlResponseInfo urlResponseInfo, String str) {
                return RedirectHandlers.lambda$alwaysFollow$1(urlResponseInfo, str);
            }
        };
    }

    private RedirectHandlers() {
    }
}
