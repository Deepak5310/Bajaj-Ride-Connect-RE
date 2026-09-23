package com.mappls.sdk.maps.session;

/* JADX INFO: loaded from: classes4.dex */
public interface InitializationListener {
    void onFailure(AuthenticationError authenticationError, Exception exc);

    void onSuccess();
}
