package com.mappls.sdk.services.api.session.removedevice;

import retrofit2.Call;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;

/* JADX INFO: loaded from: classes4.dex */
interface DeactivateDeviceService {
    @PATCH("api/security/sessions/{sessionType}")
    Call<Void> getCall(@Path("sessionType") String str, @Query("sessionDevice") String str2, @Query("deviceFingerprint") String str3);
}
