package com.mappls.sdk.navigation.session;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavLocation;
import com.mappls.sdk.navigation.NavigationConstants;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.data.WayPoint;
import com.mappls.sdk.navigation.iface.IStopSession;
import com.mappls.sdk.navigation.model.NavigationResponse;
import com.mappls.sdk.navigation.util.AuthenticationError;
import com.mappls.sdk.navigation.util.ErrorType;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import com.mappls.sdk.services.api.directions.models.DirectionsWaypoint;
import com.mappls.sdk.services.api.session.create.MapplsCreateSession;
import com.mappls.sdk.services.api.session.create.model.SessionRequestModel;
import com.mappls.sdk.services.api.session.create.model.SessionResponse;
import com.mappls.sdk.services.api.session.delete.MapplsDeleteSession;
import com.mappls.sdk.services.api.session.endsession.MapplsEndSession;
import com.mappls.sdk.services.api.session.endsession.MapplsEndSessionManager;
import com.mappls.sdk.services.api.session.update.MapplsUpdateSession;
import java.lang.reflect.Field;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    private Context a;
    private SessionResponse b;

    /* JADX INFO: renamed from: com.mappls.sdk.navigation.session.a$a, reason: collision with other inner class name */
    final class C0102a implements Callback<SessionResponse> {
        C0102a() {
        }

        @Override // retrofit2.Callback
        public final void onFailure(Call<SessionResponse> call, Throwable th) {
        }

        @Override // retrofit2.Callback
        public final void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
            a.this.b = response.body();
        }
    }

    final class b implements Callback<SessionResponse> {
        b() {
        }

        @Override // retrofit2.Callback
        public final void onFailure(Call<SessionResponse> call, Throwable th) {
            if (call.isCanceled()) {
                return;
            }
            a.this.b = null;
        }

        @Override // retrofit2.Callback
        public final void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
            a.this.b = null;
        }
    }

    final class c implements OnResponseCallback<Void> {
        final /* synthetic */ IStopSession a;

        c(IStopSession iStopSession) {
            this.a = iStopSession;
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onError(int i, String str) {
            IStopSession iStopSession;
            if (i == 0 || (iStopSession = this.a) == null) {
                return;
            }
            iStopSession.onFailure();
        }

        @Override // com.mappls.sdk.services.api.OnResponseCallback
        public final void onSuccess(Void r2) {
            a.this.b = null;
            IStopSession iStopSession = this.a;
            if (iStopSession != null) {
                iStopSession.onSuccess();
            }
        }
    }

    public a(Context context) {
        this.a = context;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x021b A[Catch: Exception -> 0x0228, TRY_LEAVE, TryCatch #3 {Exception -> 0x0228, blocks: (B:29:0x0155, B:32:0x015e, B:34:0x01c7, B:36:0x01d2, B:38:0x021b), top: B:66:0x0155 }] */
    public final NavigationResponse a(DirectionsResponse directionsResponse, int i, LatLng latLng, WayPoint wayPoint, String str) {
        String str2;
        AuthenticationError authenticationError;
        JSONObject jSONObject;
        SessionRequestModel sessionRequestModel = new SessionRequestModel();
        sessionRequestModel.setDeviceFingerprint(NavigationContext.getNavigationContext().b());
        sessionRequestModel.setSdkVersion("0.14.2");
        sessionRequestModel.setNst(Long.valueOf(System.currentTimeMillis() / 1000));
        if (MapplsAccountManager.getInstance().getDeviceAlias() != null) {
            sessionRequestModel.setDeviceAlias(MapplsAccountManager.getInstance().getDeviceAlias());
        }
        sessionRequestModel.setStartPoint(latLng.getLatitude() + "," + latLng.getLongitude());
        if (wayPoint.isValidCoordinates()) {
            str2 = wayPoint.getEntryLatitude() + "," + wayPoint.getEntryLongitude();
        } else {
            if (directionsResponse.waypoints() == null || directionsResponse.waypoints().size() <= 1) {
                return new NavigationResponse(new AuthenticationError(6, "Something went wrong-101"), null);
            }
            DirectionsWaypoint directionsWaypoint = directionsResponse.waypoints().get(directionsResponse.waypoints().size() - 1);
            str2 = directionsWaypoint.location().latitude() + "," + directionsWaypoint.location().longitude();
        }
        sessionRequestModel.setEndPoint(str2);
        try {
            DirectionsRoute selectedTrip = MapplsNavigationHelper.getInstance().getSelectedTrip(directionsResponse, i);
            if (selectedTrip.legs() != null && selectedTrip.legs().size() > 0) {
                sessionRequestModel.setTripDistance(Long.valueOf(selectedTrip.distance().longValue()));
                sessionRequestModel.setTripDuration(Long.valueOf(selectedTrip.duration().longValue()));
            }
        } catch (Exception e) {
            NavigationLogger.e(e);
        }
        if (MapplsAccountManager.getInstance().getAssociationId() != null) {
            sessionRequestModel.setAssociationId(MapplsAccountManager.getInstance().getAssociationId());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            Response<SessionResponse> responseExecuteCall = MapplsCreateSession.builder().sessionType("navigation").sessionRequest(sessionRequestModel).clusterId(str).build().executeCall();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            if (responseExecuteCall.code() != 200) {
                try {
                    if (responseExecuteCall.code() == 201) {
                        this.b = responseExecuteCall.body();
                        jSONObject = new JSONObject();
                        jSONObject.put("response_time", jCurrentTimeMillis2 + " ms");
                        jSONObject.put("source", latLng.getLatitude() + "," + latLng.getLongitude());
                        jSONObject.put(FirebaseAnalytics.Param.DESTINATION, wayPoint.getVisualValue());
                        if (MapplsLMSManager.isInitialised()) {
                            MapplsLMSManager.getInstance().add("navigation-session-success", "navigation-sdk", "0.14.2", jSONObject);
                        }
                        e = null;
                        authenticationError = null;
                    } else {
                        AuthenticationError authenticationError2 = new AuthenticationError(responseExecuteCall.code(), responseExecuteCall.headers().get(StackTraceHelper.MESSAGE_KEY));
                        this.b = null;
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("response_time", jCurrentTimeMillis2 + " ms");
                        jSONObject2.put("source", latLng.getLatitude() + "," + latLng.getLongitude());
                        jSONObject2.put(FirebaseAnalytics.Param.DESTINATION, wayPoint.getVisualValue());
                        jSONObject2.put("response_code", responseExecuteCall.code());
                        jSONObject2.put(StackTraceHelper.MESSAGE_KEY, responseExecuteCall.headers().get(StackTraceHelper.MESSAGE_KEY));
                        if (MapplsLMSManager.isInitialised()) {
                            MapplsLMSManager.getInstance().add("navigation-session-failed", "navigation-sdk", "0.14.2", jSONObject2);
                        }
                        authenticationError = authenticationError2;
                        e = null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    long jCurrentTimeMillis3 = System.currentTimeMillis() - jCurrentTimeMillis;
                    this.b = null;
                    AuthenticationError authenticationError3 = (NavigationConstants.getFailureType(e) == 0 || NavigationConstants.getFailureType(e) == 1) ? ErrorType.NETWORK_ERROR : ErrorType.SERVER_ERROR;
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("response_time", jCurrentTimeMillis3 + " ms");
                        jSONObject3.put("source", latLng.getLatitude() + "," + latLng.getLongitude());
                        jSONObject3.put(FirebaseAnalytics.Param.DESTINATION, wayPoint.getVisualValue());
                        jSONObject3.put(StackTraceHelper.MESSAGE_KEY, e.getMessage());
                        if (MapplsLMSManager.isInitialised()) {
                            MapplsLMSManager.getInstance().add("navigation-session-failed", "navigation-sdk", "0.14.2", jSONObject3);
                        }
                    } catch (JSONException unused) {
                    }
                    NavigationLogger.d(e);
                    authenticationError = authenticationError3;
                }
            } else {
                this.b = responseExecuteCall.body();
                jSONObject = new JSONObject();
                jSONObject.put("response_time", jCurrentTimeMillis2 + " ms");
                jSONObject.put("source", latLng.getLatitude() + "," + latLng.getLongitude());
                jSONObject.put(FirebaseAnalytics.Param.DESTINATION, wayPoint.getVisualValue());
                if (MapplsLMSManager.isInitialised()) {
                    MapplsLMSManager.getInstance().add("navigation-session-success", "navigation-sdk", "0.14.2", jSONObject);
                }
                e = null;
                authenticationError = null;
            }
        } catch (Exception e3) {
            e = e3;
        }
        return new NavigationResponse(authenticationError, e);
    }

    public final void a() {
        SessionResponse sessionResponse = this.b;
        if (sessionResponse == null) {
            return;
        }
        MapplsDeleteSession.builder().hyperlink(sessionResponse.passportLink).build().enqueueCall(new b());
    }

    public final void a(NavLocation navLocation) {
        SessionResponse sessionResponse = this.b;
        if (sessionResponse == null) {
            return;
        }
        String str = sessionResponse.passportLink;
        SessionRequestModel sessionRequestModel = new SessionRequestModel();
        sessionRequestModel.setDeviceFingerprint(Build.BRAND + ':' + Build.MODEL + ':' + Settings.Secure.getString(this.a.getContentResolver(), "android_id"));
        sessionRequestModel.setOsName(Build.VERSION.CODENAME);
        Field[] fields = Build.VERSION_CODES.class.getFields();
        int i = Build.VERSION.SDK_INT;
        sessionRequestModel.setSdkVersion(fields[i + (-1)].getName());
        sessionRequestModel.setOsVersion(String.valueOf(i));
        sessionRequestModel.setNst(Long.valueOf(System.currentTimeMillis() / 1000));
        if (NavigationContext.getNavigationContext().getCurrentLocation() != null) {
            sessionRequestModel.setStartPoint(NavigationContext.getNavigationContext().getCurrentLocation().getLatitude() + "," + NavigationContext.getNavigationContext().getCurrentLocation().getLongitude());
        }
        if (navLocation != null) {
            sessionRequestModel.setEndPoint(navLocation.getLatitude() + "," + navLocation.getLongitude());
        }
        if (MapplsNavigationHelper.getInstance().getCurrentRoute() != null) {
            sessionRequestModel.setTripDistance(Long.valueOf(MapplsNavigationHelper.getInstance().getCurrentRoute().distance().longValue()));
            sessionRequestModel.setTripDuration(Long.valueOf(MapplsNavigationHelper.getInstance().getCurrentRoute().duration().longValue()));
        }
        if (MapplsAccountManager.getInstance().getAssociationId() != null) {
            sessionRequestModel.setAssociationId(MapplsAccountManager.getInstance().getAssociationId());
        }
        MapplsUpdateSession.builder().sessionRequest(sessionRequestModel).hyperlink(str).build().enqueueCall(new C0102a());
    }

    public final void a(String str, IStopSession iStopSession) {
        MapplsEndSessionManager.newInstance(MapplsEndSession.builder().clusterId(str).sessionType("navigation").build()).call(new c(iStopSession));
    }
}
