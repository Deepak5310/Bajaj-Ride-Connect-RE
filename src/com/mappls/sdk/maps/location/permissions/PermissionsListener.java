package com.mappls.sdk.maps.location.permissions;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface PermissionsListener {
    void onExplanationNeeded(List<String> list);

    void onPermissionResult(boolean z);
}
