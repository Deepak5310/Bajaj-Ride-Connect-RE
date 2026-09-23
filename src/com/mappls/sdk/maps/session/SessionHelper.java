package com.mappls.sdk.maps.session;

import android.content.Context;
import android.os.Build;
import androidx.work.PeriodicWorkRequest;
import com.facebook.react.devsupport.StackTraceHelper;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.maps.BuildConfig;
import com.mappls.sdk.services.account.MapplsAccountManager;
import com.mappls.sdk.services.api.OnResponseCallback;
import com.mappls.sdk.services.api.session.create.MapplsCreateSession;
import com.mappls.sdk.services.api.session.create.model.SessionRequestModel;
import com.mappls.sdk.services.api.session.create.model.SessionResponse;
import com.mappls.sdk.services.api.session.delete.MapplsDeleteSession;
import com.mappls.sdk.services.api.session.endsession.MapplsEndSession;
import com.mappls.sdk.services.api.session.endsession.MapplsEndSessionManager;
import com.mappls.sdk.services.api.session.update.MapplsUpdateSession;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class SessionHelper {
    public static int CONNECTION_ERROR = 0;
    public static int PERMANENT_ERROR = 2;
    public static int TEMPORARY_ERROR = 1;
    private long activeSessionTime;

    /* JADX INFO: renamed from: app, reason: collision with root package name */
    private Context f704app;
    private SessionResponse sessionResponse;

    public SessionHelper(Context context) {
        this.f704app = context;
    }

    public static int getFailureType(Throwable th) {
        if ((th instanceof UnknownHostException) || (th instanceof SocketException) || (th instanceof ProtocolException) || (th instanceof SSLException)) {
            return CONNECTION_ERROR;
        }
        if (th instanceof InterruptedIOException) {
            return TEMPORARY_ERROR;
        }
        return PERMANENT_ERROR;
    }

    public void startGlobalSession(final InitializationListener initializationListener) {
        if (this.sessionResponse == null) {
            MapplsCreateSession.builder().clusterId(MapplsAccountManager.getInstance().getClusterId()).sessionType("global").sessionRequest(getSessionRequest()).build().enqueueCall(new Callback<SessionResponse>() { // from class: com.mappls.sdk.maps.session.SessionHelper.1
                @Override // retrofit2.Callback
                public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                    if (response.code() == 200 || response.code() == 201) {
                        SessionHelper.this.sessionResponse = response.body();
                        InitializationListener initializationListener2 = initializationListener;
                        if (initializationListener2 != null) {
                            initializationListener2.onSuccess();
                        }
                        SessionHelper.this.activeSessionTime = System.currentTimeMillis();
                        if (MapplsLMSManager.isInitialised()) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (response.body() != null) {
                                    jSONObject.put("session_expiry", response.body().expiresAfter);
                                    jSONObject.put("session_passport", response.body().passport);
                                }
                                MapplsLMSManager.getInstance().add("session-api-success", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                                return;
                            } catch (JSONException unused) {
                                return;
                            }
                        }
                        return;
                    }
                    AuthenticationError authenticationError = new AuthenticationError(response.code(), response.headers().get(StackTraceHelper.MESSAGE_KEY));
                    if (MapplsLMSManager.isInitialised()) {
                        try {
                            JSONObject jSONObject2 = new JSONObject();
                            if (response.body() != null) {
                                jSONObject2.put("error_code", response.code());
                                jSONObject2.put("error_message", response.headers().get(StackTraceHelper.MESSAGE_KEY));
                                if (MapplsAccountManager.getInstance().getClusterId() != null) {
                                    jSONObject2.put("cluster_id", MapplsAccountManager.getInstance().getClusterId());
                                }
                            }
                            MapplsLMSManager.getInstance().add("session-api-err", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject2);
                        } catch (JSONException unused2) {
                        }
                    }
                    SessionHelper.this.sessionResponse = null;
                    InitializationListener initializationListener3 = initializationListener;
                    if (initializationListener3 != null) {
                        initializationListener3.onFailure(authenticationError, null);
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<SessionResponse> call, Throwable th) {
                    AuthenticationError authenticationError;
                    Exception exc;
                    SessionHelper.this.sessionResponse = null;
                    if (SessionHelper.getFailureType(th) == SessionHelper.CONNECTION_ERROR || SessionHelper.getFailureType(th) == SessionHelper.TEMPORARY_ERROR) {
                        authenticationError = ErrorType.NETWORK_ERROR;
                        exc = new Exception(th);
                    } else {
                        authenticationError = ErrorType.SERVER_ERROR;
                        exc = new Exception(th);
                    }
                    InitializationListener initializationListener2 = initializationListener;
                    if (initializationListener2 != null) {
                        initializationListener2.onFailure(authenticationError, exc);
                    }
                    if (MapplsLMSManager.isInitialised()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("error_code", authenticationError.errorCode);
                            jSONObject.put("error_message", authenticationError.errorMessage);
                            if (MapplsAccountManager.getInstance().getClusterId() != null) {
                                jSONObject.put("cluster_id", MapplsAccountManager.getInstance().getClusterId());
                            }
                            MapplsLMSManager.getInstance().add("session-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                }
            });
            return;
        }
        if (initializationListener != null) {
            initializationListener.onSuccess();
        }
        if (this.activeSessionTime + PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS < System.currentTimeMillis()) {
            updateGlobalSession(MapplsAccountManager.getInstance().getClusterId());
        }
    }

    public void updateGlobalSession(String str) {
        SessionResponse sessionResponse = this.sessionResponse;
        if (sessionResponse == null) {
            return;
        }
        MapplsUpdateSession.builder().clusterId(str).hyperlink(sessionResponse.passportLink).sessionRequest(getSessionRequest()).build().enqueueCall(new Callback<SessionResponse>() { // from class: com.mappls.sdk.maps.session.SessionHelper.2
            @Override // retrofit2.Callback
            public void onFailure(Call<SessionResponse> call, Throwable th) {
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                SessionHelper.this.sessionResponse = response.body();
                SessionHelper.this.activeSessionTime = System.currentTimeMillis();
            }
        });
    }

    public void endSession() {
        SessionResponse sessionResponse = this.sessionResponse;
        if (sessionResponse == null) {
            return;
        }
        String str = sessionResponse.passportLink;
        SessionRequestModel sessionRequestModel = new SessionRequestModel();
        sessionRequestModel.setDeviceFingerprint(SessionConstants.deviceFingerPrint(this.f704app));
        sessionRequestModel.setSdkVersion(BuildConfig.VERSION_NAME);
        MapplsDeleteSession.builder().hyperlink(str).build().enqueueCall(new Callback<SessionResponse>() { // from class: com.mappls.sdk.maps.session.SessionHelper.3
            @Override // retrofit2.Callback
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                SessionHelper.this.sessionResponse = null;
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<SessionResponse> call, Throwable th) {
                if (call.isCanceled()) {
                    return;
                }
                SessionHelper.this.sessionResponse = null;
            }
        });
    }

    public void deleteNavigationSession(final IStopSession iStopSession) {
        MapplsEndSessionManager.newInstance(MapplsEndSession.builder().clusterId(MapplsAccountManager.getInstance().getClusterId()).sessionType("global").build()).call(new OnResponseCallback<Void>() { // from class: com.mappls.sdk.maps.session.SessionHelper.4
            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onSuccess(Void r2) {
                SessionHelper.this.sessionResponse = null;
                IStopSession iStopSession2 = iStopSession;
                if (iStopSession2 != null) {
                    iStopSession2.onSuccess();
                }
            }

            @Override // com.mappls.sdk.services.api.OnResponseCallback
            public void onError(int i, String str) {
                if (i == 204 || i == 410) {
                    SessionHelper.this.sessionResponse = null;
                    IStopSession iStopSession2 = iStopSession;
                    if (iStopSession2 != null) {
                        iStopSession2.onSuccess();
                        return;
                    }
                    return;
                }
                if (i != 0) {
                    SessionHelper.this.sessionResponse = null;
                    IStopSession iStopSession3 = iStopSession;
                    if (iStopSession3 != null) {
                        iStopSession3.onFailure();
                    }
                }
            }
        });
    }

    SessionRequestModel getSessionRequest() {
        SessionRequestModel sessionRequestModel = new SessionRequestModel();
        sessionRequestModel.setDeviceFingerprint(SessionConstants.deviceFingerPrint(this.f704app));
        sessionRequestModel.setSdkVersion(BuildConfig.MAPPLS_SDK_VERSION);
        sessionRequestModel.setOsName("Android");
        sessionRequestModel.setRequestedTTL(900);
        sessionRequestModel.setDeviceAlias(MapplsAccountManager.getInstance().getDeviceAlias());
        sessionRequestModel.setOsVersion(Build.VERSION.SDK_INT + "");
        sessionRequestModel.setAssociationId(MapplsAccountManager.getInstance().getAssociationId());
        return sessionRequestModel;
    }

    public boolean isSessionActive() {
        return this.sessionResponse != null;
    }
}
