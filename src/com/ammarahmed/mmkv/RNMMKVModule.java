package com.ammarahmed.mmkv;

import android.os.Bundle;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.module.annotations.ReactModule;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
@ReactModule(name = RNMMKVModule.NAME)
public class RNMMKVModule extends MmkvStorageSpec {
    public static final String NAME = "MMKVStorage";
    private final ReactApplicationContext reactContext;
    private SecureKeystore secureKeystore;

    private native void destroy();

    private native void nativeInstall(long j, String str);

    public void installLib(JavaScriptContextHolder javaScriptContextHolder, String str) {
    }

    static {
        System.loadLibrary("rnmmkv");
    }

    public RNMMKVModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.secureKeystore = new SecureKeystore(reactApplicationContext);
    }

    @Override // com.ammarahmed.mmkv.MmkvStorageSpec
    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean install() {
        String str = this.reactContext.getFilesDir().getAbsolutePath() + "/mmkv";
        JavaScriptContextHolder javaScriptContextHolder = getReactApplicationContext().getJavaScriptContextHolder();
        if (javaScriptContextHolder.get() != 0) {
            migrate();
            nativeInstall(javaScriptContextHolder.get(), str);
            return true;
        }
        Log.e("RNMMKVModule", "JSI Runtime is not available in debug mode");
        return false;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        super.initialize();
    }

    public void migrate() {
        MMKV.initialize(this.reactContext);
        MMKV mmkvMmkvWithID = MMKV.mmkvWithID("mmkvIDStore");
        boolean zContainsKey = mmkvMmkvWithID.containsKey("mmkvIdStore");
        new HashMap();
        if (zContainsKey) {
            HashMap map = (HashMap) ((Bundle) mmkvMmkvWithID.decodeParcelable("mmkvIdStore", Bundle.class)).getSerializable("mmkvIdStore");
            for (String str : map.keySet()) {
                HashMap map2 = (HashMap) map.get(str);
                boolean zBooleanValue = map2.containsKey("encrypted") ? ((Boolean) map2.get("encrypted")).booleanValue() : false;
                if (zBooleanValue && !map2.containsKey("alias")) {
                    Set<String> setKeySet = map2.keySet();
                    String str2 = (String) map2.get("alias");
                    for (String str3 : setKeySet) {
                        if (str3 != null && !str3.equals("ID") && !str3.equals("encrypted")) {
                            str2 = (String) map2.get(str3);
                        }
                    }
                    map2.put("alias", str2);
                }
                mmkvMmkvWithID.encode(str, new Gson().toJson(map2));
                if (zBooleanValue) {
                    String str4 = (String) map2.get("alias");
                    if (this.secureKeystore.secureKeyExists(str4)) {
                        writeToJSON(MMKV.mmkvWithID(str, 1, this.secureKeystore.getSecureKey(str4)));
                    }
                } else {
                    writeToJSON(MMKV.mmkvWithID(str, 1));
                }
            }
            mmkvMmkvWithID.removeValueForKey("mmkvIdStore");
        }
    }

    public void writeToJSON(MMKV mmkv) {
        Gson gson = new Gson();
        Set<String> setDecodeStringSet = mmkv.decodeStringSet("mapIndex", new HashSet());
        if (setDecodeStringSet != null) {
            for (String str : setDecodeStringSet) {
                Bundle bundle = (Bundle) mmkv.decodeParcelable(str, Bundle.class);
                if (bundle != null) {
                    mmkv.encode(str, gson.toJson(Arguments.fromBundle(bundle).toHashMap()));
                }
            }
        }
        Set<String> setDecodeStringSet2 = mmkv.decodeStringSet("arrayIndex", new HashSet());
        if (setDecodeStringSet2 != null) {
            for (String str2 : setDecodeStringSet2) {
                Bundle bundle2 = (Bundle) mmkv.decodeParcelable(str2, Bundle.class);
                if (bundle2 != null) {
                    WritableMap writableMapFromBundle = Arguments.fromBundle(bundle2);
                    if (writableMapFromBundle.getArray(str2) != null) {
                        mmkv.encode(str2, gson.toJson(writableMapFromBundle.getArray(str2).toArrayList()));
                    }
                }
            }
        }
        Set<String> setDecodeStringSet3 = mmkv.decodeStringSet("intIndex", new HashSet());
        for (String str3 : setDecodeStringSet3) {
            mmkv.encode(str3, mmkv.decodeInt(str3));
        }
        mmkv.encode("numberIndex", setDecodeStringSet3);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "MMKVNative";
    }

    public boolean secureKeyExists(String str) {
        return this.secureKeystore.secureKeyExists(str);
    }

    public void removeSecureKey(String str) {
        this.secureKeystore.removeSecureKey(str);
    }

    public void setSecureKey(String str, String str2) {
        this.secureKeystore.setSecureKey(str, str2);
    }

    public String getSecureKey(String str) {
        return this.secureKeystore.getSecureKey(str);
    }
}
