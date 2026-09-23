package com.mappls.android.util;

import android.content.Context;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes6.dex */
public interface RemoteService {

    public class ServiceUnavailableException extends Exception {
        private final int mRetryAfter;

        public ServiceUnavailableException(String str, String str2) {
            int i;
            super(str);
            try {
                i = Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                i = 0;
            }
            this.mRetryAfter = i;
        }

        public int getRetryAfter() {
            return this.mRetryAfter;
        }
    }

    void checkIsMapplsAnalyticsBlocked();

    boolean isOnline(Context context, OfflineMode offlineMode);

    byte[] performRequest(String str, Map<String, Object> map, SSLSocketFactory sSLSocketFactory);
}
