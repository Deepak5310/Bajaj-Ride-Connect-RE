package com.mappls.sdk.services.api;

import android.provider.Settings;
import com.facebook.react.devsupport.StackTraceHelper;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.log.LoggerUtils;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
public class AddParametersInterceptor implements Interceptor {
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z;
        Request request = chain.request();
        Request.Builder builderNewBuilder = request.newBuilder();
        StringBuilder sb = new StringBuilder();
        boolean z2 = true;
        if (MapplsApiConfiguration.getInstance().userId == null) {
            z = false;
        } else if (MapplsAccountManager.getInstance().getUserId() != null) {
            sb.append("userId=");
            sb.append(MapplsAccountManager.getInstance().getUserId());
            z = true;
        } else {
            LoggerUtils.d("AddParametersInterceptor", "No user id found");
            z = false;
        }
        if (MapplsApiConfiguration.getInstance().vin != null) {
            if (MapplsAccountManager.getInstance().getDeviceAlias() != null) {
                if (z) {
                    sb.append(";");
                }
                sb.append("vin=");
                sb.append(MapplsAccountManager.getInstance().getDeviceAlias());
                z = true;
            } else if (MapplsApiConfiguration.getInstance().vin.booleanValue()) {
                return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(103).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "Please set Vin number in MapplsAccountManager").message("Please set Vin number").build();
            }
        }
        if (MapplsApiConfiguration.getInstance().clusterId != null) {
            if (MapplsAccountManager.getInstance().getClusterId() != null) {
                if (z) {
                    sb.append(";");
                }
                sb.append("clusterId=");
                sb.append(MapplsAccountManager.getInstance().getClusterId());
                z = true;
            } else if (MapplsApiConfiguration.getInstance().clusterId.booleanValue()) {
                return new Response.Builder().request(request).protocol(Protocol.HTTP_1_0).code(103).body(ResponseBody.create(MediaType.parse("text"), "")).addHeader(StackTraceHelper.MESSAGE_KEY, "Please set Cluster Id in MapplsAccountManager").message("Please set Cluster Id").build();
            }
        }
        if (MapplsApiConfiguration.getInstance().deviceFingerPrint != null) {
            if (z) {
                sb.append(";");
            }
            String string = Settings.Secure.getString(MapplsUtils.getSDKContext().getContentResolver(), "android_id");
            sb.append("deviceFingerPrint=");
            sb.append(string);
        } else {
            z2 = z;
        }
        if (z2) {
            builderNewBuilder.header("x-custom-mod", sb.toString().replace(StringUtils.CR, "").replace("\n", ""));
        }
        return chain.proceed(builderNewBuilder.build());
    }
}
