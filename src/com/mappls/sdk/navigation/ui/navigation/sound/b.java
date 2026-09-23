package com.mappls.sdk.navigation.ui.navigation.sound;

import android.view.View;
import com.mappls.sdk.navigation.MapplsNavigationHelper;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ SoundControllerView a;

    public b(SoundControllerView soundControllerView) {
        this.a = soundControllerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (MapplsNavigationHelper.getInstance().isMute()) {
            this.a.unmute();
        } else {
            this.a.mute();
        }
    }
}
