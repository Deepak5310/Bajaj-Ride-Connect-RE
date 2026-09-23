package com.spotify.sdk.android.auth;

import android.app.Activity;

/* JADX INFO: loaded from: classes4.dex */
public interface AuthorizationHandler {

    public interface OnCompleteListener {
        void onCancel();

        void onComplete(AuthorizationResponse authorizationResponse);

        void onError(Throwable th);
    }

    boolean isAuthInProgress();

    void setOnCompleteListener(OnCompleteListener onCompleteListener);

    boolean start(Activity activity, AuthorizationRequest authorizationRequest);

    void stop();
}
