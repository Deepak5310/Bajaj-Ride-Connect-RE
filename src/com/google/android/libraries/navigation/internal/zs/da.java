package com.google.android.libraries.navigation.internal.zs;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class da {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    public static final int j = 10;
    public static final int k = 11;
    public static final int l = 12;
    public static final int m = 13;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f675n = 14;
    public static final int o = 15;
    public static final int p = 16;
    public static final int q = 17;
    public static final int r = 18;
    public static final int s = 19;
    public static final int t = 20;
    public static final int u = 21;
    public static final int v = 22;
    public static final int w = 23;
    public static final int x = 24;
    public static final int y = 25;
    public static final int z = 26;
    public static final int A = 27;
    public static final int B = 28;
    public static final int C = 29;
    public static final int D = 30;
    public static final int E = 31;
    public static final int F = 32;
    public static final int G = 33;
    public static final int H = 34;
    public static final int I = 35;
    public static final int J = 36;
    public static final int K = 37;
    public static final int L = 38;
    public static final int M = 39;
    public static final int N = 40;
    public static final int O = 41;
    public static final int P = 42;
    public static final int Q = 43;
    public static final int R = 44;
    public static final int S = 45;
    public static final int T = 46;
    public static final int U = 47;
    public static final int V = 48;
    public static final int W = 49;
    public static final int X = 50;
    public static final int Y = 51;
    public static final int Z = 52;
    public static final int aa = 53;
    public static final int ab = 54;
    public static final int ac = 55;
    public static final int ad = 56;
    public static final int ae = 57;
    public static final int af = 58;
    public static final int ag = 59;
    public static final int ah = 60;
    public static final int ai = 61;
    public static final int aj = 62;
    public static final int ak = 63;
    public static final int al = 64;
    public static final int am = 65;
    private static final /* synthetic */ int[] an = {a, b, c, d, e, f, g, h, i, j, k, l, m, f675n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am};

    public static /* synthetic */ String a(int i2) {
        switch (i2) {
            case 1:
                return "LOCATION_PIPELINE";
            case 2:
                return "GUIDANCE_STARTED";
            case 3:
                return "GUIDANCE_STOPPED";
            case 4:
                return "STEP_CHANGED";
            case 5:
                return "ACTIVE_TRIP_CHANGED";
            case 6:
                return "TRAFFIC_UPDATED";
            case 7:
                return "ALTERNATE_TRIP_OFFERED";
            case 8:
                return "ALTERNATE_TRIP_ACCEPTED";
            case 9:
                return "ALTERNATE_TRIP_SELECTED";
            case 10:
                return "REROUTE_REQUESTED";
            case 11:
                return "DROVE_ONTO_ALTERNATIVE";
            case 12:
                return "PROMPT_SHOWN";
            case 13:
                return "ARRIVED";
            case 14:
                return "DEVICE";
            case 15:
                return "GPS_AVAILABILITY";
            case 16:
                return "FOREGROUND";
            case 17:
                return "SESSION_ENDED";
            case 18:
                return "START_RECORDING";
            case 19:
                return "STOP_RECORDING";
            case 20:
                return "FEEDBACK";
            case 21:
                return "PICKUP";
            case 22:
                return "DROPOFF";
            case 23:
                return "ANDROID_ACTIVITY_RECOGNITION";
            case 24:
                return "TRANSIT_TRIP_STARTED";
            case 25:
                return "ASSISTANT_VOICE_ACTION";
            case 26:
                return "ASSISTANT_STATE";
            case 27:
                return "TRAFFIC_RADAR_STATE";
            case 28:
                return "INCIDENT_REPORT";
            case 29:
                return "MAP_VERSUS_SENSOR_INCONSISTENCY";
            case 30:
                return "ACCELERATION_EVENT";
            case 31:
                return "UI_MODE_STATE";
            case 32:
                return "TRANSACTION_IDS_CHANGE";
            case 33:
                return "PROJECTED_SENSOR_STATE";
            case 34:
                return "POST_TRIP_UGC_ANSWER";
            case 35:
                return "ASSISTED_DRIVING_EVENT";
            case 36:
                return "CHARGING_PORT_CONNECTED_EVENT";
            case 37:
                return "NAVIGATION_AD_EVENT";
            case 38:
                return "WEATHER_STATE_EVENT";
            case 39:
                return "VEHICLE_STATE_EVENT";
            case 40:
                return "SENSOR_OBSERVATION_EVENT";
            case 41:
                return "PREDICTED_CURVATURE_EVENT";
            case 42:
                return "MOST_PROBABLE_PATH_UPDATE_EVENT";
            case 43:
                return "LEAST_SURPRISING_PATH_UPDATE_EVENT";
            case 44:
                return "AR_MODE_STATE_EVENT";
            case 45:
                return "AR_LOCALIZATION_CHANGE_EVENT";
            case 46:
                return "AR_INDOOR_STATE_EVENT";
            case 47:
                return "AR_ELEMENT_PLACED_EVENT";
            case 48:
                return "BASELINE_BATTERY_USAGE_EVENT";
            case 49:
                return "BATTERY_CONSUMPTION_EVENT";
            case 50:
                return "SEMANTIC_LOCATION_EVENT";
            case 51:
                return "CAMERA_POSITION_DELTA_EVENT";
            case 52:
                return "CAMERA_FRAMING_CHANGED_EVENT";
            case 53:
                return "ROAD_VIEW_METRIC_EVENT";
            case 54:
                return "RAW_GNSS_MEASUREMENT_EVENT";
            case 55:
                return "FEATURE_CHANGED_EVENT";
            case 56:
                return "ANDROID_THERMAL_STATE_EVENT";
            case 57:
                return "IOS_THERMAL_STATE_EVENT";
            case 58:
                return "CPU_USAGE_STATE_EVENT";
            case 59:
                return "FPS_STATE_EVENT";
            case 60:
                return "LITE_NAV_TRANSIT_USAGE_EVENT";
            case 61:
                return "LAP_SUMMARY_EVENT";
            case 62:
                return "STOP_EVENT";
            case 63:
                return "STOP_REASON_EVENT";
            case 64:
                return "CUSTOM_CHEVRON_USAGE_EVENT";
            case 65:
                return "DETAILS_NOT_SET";
            default:
                return BuildConfig.TRAVIS;
        }
    }

    public static int b(int i2) {
        if (i2 == 0) {
            return am;
        }
        switch (i2) {
            case 5:
                return a;
            case 6:
                return b;
            case 7:
                return c;
            case 8:
                return d;
            case 9:
                return e;
            case 10:
                return f;
            case 11:
                return g;
            case 12:
                return h;
            case 13:
                return i;
            case 14:
                return j;
            case 15:
                return k;
            case 16:
                return l;
            case 17:
                return m;
            case 18:
                return f675n;
            case 19:
                return o;
            case 20:
                return p;
            case 21:
                return q;
            case 22:
                return r;
            case 23:
                return s;
            case 24:
                return t;
            case 25:
                return u;
            case 26:
                return v;
            case 27:
                return w;
            case 28:
                return x;
            case 29:
                return y;
            case 30:
                return z;
            case 31:
                return A;
            case 32:
                return B;
            case 33:
                return C;
            case 34:
                return D;
            case 35:
                return E;
            case 36:
                return F;
            case 37:
                return G;
            case 38:
                return H;
            case 39:
                return I;
            case 40:
                return J;
            case 41:
                return K;
            case 42:
                return L;
            case 43:
                return M;
            case 44:
                return N;
            case 45:
                return O;
            case 46:
                return P;
            case 47:
                return Q;
            case 48:
                return R;
            case 49:
                return S;
            case 50:
                return T;
            case 51:
                return U;
            case 52:
                return V;
            case 53:
                return W;
            case 54:
                return X;
            case 55:
                return Y;
            case 56:
                return Z;
            case 57:
                return aa;
            case 58:
                return ab;
            case 59:
                return ac;
            case 60:
                return ad;
            case 61:
                return ae;
            case 62:
                return af;
            case 63:
                return ag;
            case 64:
                return ah;
            case 65:
                return ai;
            case 66:
                return aj;
            case 67:
                return ak;
            case 68:
                return al;
            default:
                return 0;
        }
    }

    public static int[] values$ar$edu$e32b67f6_0() {
        return new int[]{a, b, c, d, e, f, g, h, i, j, k, l, m, f675n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, aa, ab, ac, ad, ae, af, ag, ah, ai, aj, ak, al, am};
    }
}
