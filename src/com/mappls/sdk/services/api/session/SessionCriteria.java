package com.mappls.sdk.services.api.session;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes4.dex */
public class SessionCriteria {
    public static final String SESSION_TYPE_GLOBAL = "global";
    public static final String SESSION_TYPE_NAVIGATION = "navigation";

    @Retention(RetentionPolicy.SOURCE)
    public @interface SessionTypeCriteria {
    }
}
