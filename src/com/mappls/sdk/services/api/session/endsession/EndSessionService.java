package com.mappls.sdk.services.api.session.endsession;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
interface EndSessionService {
    @DELETE("api/security/sessions/{sessionType}")
    Call<Void> getCall(@Path("sessionType") String str, @Query("sessionDevice") String str2);
}
