package com.mappls.sdk.navigation.iface;

import com.mappls.sdk.services.api.event.route.model.ReportDetails;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface NavigationEventLoadedListener {
    void onNavigationEventsLoaded(List<ReportDetails> list);
}
