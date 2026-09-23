package com.mappls.sdk.services.api.session.update;

import com.mappls.sdk.services.api.session.create.model.SessionRequestModel;
import com.mappls.sdk.services.api.session.create.model.SessionResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

/* JADX INFO: loaded from: classes4.dex */
interface UpdateSessionService {
    @PUT
    Call<SessionResponse> getCall(@Url String str, @Query("sessionDevice") String str2, @Body SessionRequestModel sessionRequestModel);
}
