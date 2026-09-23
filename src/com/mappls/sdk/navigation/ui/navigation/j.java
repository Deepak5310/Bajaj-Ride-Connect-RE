package com.mappls.sdk.navigation.ui.navigation;

import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationFormatter;
import com.mappls.sdk.navigation.model.NavigationSummary;
import com.mappls.sdk.plugin.directions.DirectionFormatter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class j implements com.mappls.sdk.navigation.ui.navigation.finished.a {
    public final /* synthetic */ NavigationView a;

    public j(NavigationView navigationView) {
        this.a = navigationView;
    }

    public final void a() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("event_view", "Navigation-Finished");
            NavigationSummary navigationSummary = MapplsNavigationHelper.getInstance().getNavigationSummary();
            if (navigationSummary != null && this.a.getContext() != null) {
                jSONObject.put("average_speed", NavigationFormatter.getFormattedSpeed(navigationSummary.getAverageSpeed(), this.a.getContext()));
                jSONObject.put("total_time_taken", DirectionFormatter.getFormattedDuration(navigationSummary.getTotalTimeTaken()));
                jSONObject.put("total_distance_travel", DirectionFormatter.getFormattedDistance(navigationSummary.getTotalDistance()));
            }
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "navigation-ui", "1.2.3", jSONObject);
            }
        } catch (JSONException unused) {
        }
        NavigationViewCallback navigationViewCallback = this.a.navigationViewCallback;
        if (navigationViewCallback != null) {
            navigationViewCallback.onNavigationEnd();
        }
    }
}
