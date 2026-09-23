package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class h implements com.mappls.sdk.navigation.ui.navigation.sound.a {
    public final void a(boolean z) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Mute-Button");
            jSONObject.put("isMute", !MapplsNavigationHelper.getInstance().isMute());
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "navigation-ui", "1.2.3", jSONObject);
            }
        } catch (JSONException unused) {
        }
        MapplsNavigationHelper.getInstance().setMute(z);
    }
}
