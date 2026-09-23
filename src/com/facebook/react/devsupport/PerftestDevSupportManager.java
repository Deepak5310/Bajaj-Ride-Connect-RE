package com.facebook.react.devsupport;

import android.content.Context;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;

/* JADX INFO: loaded from: classes3.dex */
public final class PerftestDevSupportManager extends ReleaseDevSupportManager {
    private final DevServerHelper mDevServerHelper;
    private final DeveloperSettings mDevSettings;

    public PerftestDevSupportManager(Context context) {
        DevInternalSettings devInternalSettings = new DevInternalSettings(context, new DevInternalSettings.Listener() { // from class: com.facebook.react.devsupport.PerftestDevSupportManager.1
            @Override // com.facebook.react.devsupport.DevInternalSettings.Listener
            public void onInternalSettingsChanged() {
            }
        });
        this.mDevSettings = devInternalSettings;
        this.mDevServerHelper = new DevServerHelper(devInternalSettings, context, devInternalSettings.getPackagerConnectionSettings());
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public DeveloperSettings getDevSettings() {
        return this.mDevSettings;
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public void startInspector() {
        this.mDevServerHelper.openInspectorConnection();
    }

    @Override // com.facebook.react.devsupport.ReleaseDevSupportManager, com.facebook.react.devsupport.interfaces.DevSupportManager
    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }
}
