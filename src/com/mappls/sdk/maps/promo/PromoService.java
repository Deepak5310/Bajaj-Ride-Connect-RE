package com.mappls.sdk.maps.promo;

import com.mappls.sdk.maps.promo.model.Promo;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

/* JADX INFO: loaded from: classes4.dex */
interface PromoService {
    @GET("api/transpromos")
    Call<List<Promo>> getCall();
}
