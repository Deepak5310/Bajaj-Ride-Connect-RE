package com.bajajconnect;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class CustomModulePackage implements ReactPackage {
    @Override // com.facebook.react.ReactPackage
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return Collections.singletonList(new MyViewManager(reactApplicationContext));
    }

    @Override // com.facebook.react.ReactPackage
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new EnableLocation(reactApplicationContext));
        arrayList.add(new MulesoftEncrypt(reactApplicationContext));
        arrayList.add(new RNBleCustomModule(reactApplicationContext));
        arrayList.add(new GooglePlacesModule(reactApplicationContext));
        arrayList.add(new GoogleDirectionsModule(reactApplicationContext));
        return arrayList;
    }
}
