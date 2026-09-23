package com.mappls.sdk.navigation.model;

import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.util.AuthenticationError;

/* JADX INFO: loaded from: classes4.dex */
public class NavigationResponse {
    AuthenticationError error;
    Exception exception;

    public NavigationResponse(AuthenticationError authenticationError, Exception exc) {
        this.error = authenticationError;
        this.exception = exc;
    }

    public AuthenticationError getError() {
        return this.error;
    }

    public Exception getException() {
        return this.exception;
    }

    public String toString() {
        StringBuilder sbA = h.a("NavigationResponse{error=");
        sbA.append(this.error);
        sbA.append(", exception=");
        sbA.append(this.exception);
        sbA.append('}');
        return sbA.toString();
    }
}
