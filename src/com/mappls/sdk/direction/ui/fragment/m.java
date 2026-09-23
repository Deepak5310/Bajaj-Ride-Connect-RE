package com.mappls.sdk.direction.ui.fragment;

import com.google.android.material.tabs.TabLayout;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.direction.ui.DirectionViewModel;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
final class m implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ l a;

    m(l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab tab) {
    }

    /* JADX WARN: Code duplicated, block: B:18:0x003d  */
    /* JADX WARN: Code duplicated, block: B:21:0x0072 A[Catch: Exception -> 0x007f, TRY_LEAVE, TryCatch #0 {Exception -> 0x007f, blocks: (B:19:0x004e, B:21:0x0072), top: B:27:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:24:0x0087  */
    /* JADX WARN: Code duplicated, block: B:29:? A[RETURN, SYNTHETIC] */
    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab tab) {
        DirectionViewModel directionViewModel;
        String str;
        JSONObject jSONObject;
        int position = tab.getPosition();
        try {
            if (position == 0) {
                directionViewModel = this.a.e;
                str = "driving";
            } else if (position == 1) {
                directionViewModel = this.a.e;
                str = "biking";
            } else {
                if (position != 2) {
                    if (position == 3) {
                        directionViewModel = this.a.e;
                        str = "walking";
                    }
                    if (this.a.f699n != null) {
                        this.a.f699n.onProfileUpdate(this.a.e.profile);
                    }
                    jSONObject = new JSONObject();
                    jSONObject.put("event_view", "Profile-Selection-Tab");
                    this.a.a(jSONObject);
                    jSONObject.put("select_profile", this.a.e.profile);
                    if (MapplsLMSManager.isInitialised()) {
                        MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
                    }
                    if (this.a.i != null) {
                        this.a.a();
                    }
                }
                directionViewModel = this.a.e;
                str = "trucking";
            }
            jSONObject = new JSONObject();
            jSONObject.put("event_view", "Profile-Selection-Tab");
            this.a.a(jSONObject);
            jSONObject.put("select_profile", this.a.e.profile);
            if (MapplsLMSManager.isInitialised()) {
                MapplsLMSManager.getInstance().add("click", "direction-ui", "2.3.0", jSONObject);
            }
        } catch (Exception unused) {
        }
        directionViewModel.profile = str;
        if (this.a.f699n != null) {
            this.a.f699n.onProfileUpdate(this.a.e.profile);
        }
        if (this.a.i != null) {
            this.a.a();
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab tab) {
    }
}
