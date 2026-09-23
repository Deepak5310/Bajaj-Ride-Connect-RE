package com.mappls.sdk.navigation.iface;

import com.mappls.sdk.services.api.session.devicelist.model.Device;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface DeviceListListener {
    void onError(String str);

    void onList(List<Device> list);
}
