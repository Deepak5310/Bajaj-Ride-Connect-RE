package com.mappls.sdk.services.api.session.delete;

import com.mappls.sdk.services.api.session.create.model.SessionResponse;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes4.dex */
interface DeleteSessionService {
    @DELETE
    Call<SessionResponse> getCall(@Url String str);
}
