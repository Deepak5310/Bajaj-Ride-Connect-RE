package com.reactnativecommunity.geolocation;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.devsupport.StackTraceHelper;
import com.google.android.gms.iid.InstanceID;
import com.spotify.sdk.android.auth.AccountsQueryParameters;

/* JADX INFO: loaded from: classes4.dex */
public class PositionError {
    public static int ACTIVITY_NULL = 4;
    public static int PERMISSION_DENIED = 1;
    public static int POSITION_UNAVAILABLE = 2;
    public static int TIMEOUT = 3;

    public static WritableMap buildError(int i, String str) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putInt(AccountsQueryParameters.CODE, i);
        if (str != null) {
            writableMapCreateMap.putString(StackTraceHelper.MESSAGE_KEY, str);
        }
        writableMapCreateMap.putInt("PERMISSION_DENIED", PERMISSION_DENIED);
        writableMapCreateMap.putInt("POSITION_UNAVAILABLE", POSITION_UNAVAILABLE);
        writableMapCreateMap.putInt(InstanceID.ERROR_TIMEOUT, TIMEOUT);
        writableMapCreateMap.putInt("ACTIVITY_NULL", ACTIVITY_NULL);
        return writableMapCreateMap;
    }
}
