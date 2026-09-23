package com.mappls.sdk.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.core.content.ContextCompat;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mappls.android.lms.MapplsLMSManager;
import com.mappls.sdk.maps.style.IStyleListener;
import com.mappls.sdk.maps.style.model.MapplsStyle;
import com.mappls.sdk.maps.utils.BitmapUtils;
import com.mappls.sdk.services.utils.MapplsUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsStylesHelper {
    private static final String STYLE_ERROR_CODE = "Something went wrong - 101";
    private String baseUrl;
    private MapplsStyle defaultStyle;
    private String logoBaseUrl;
    private final Context mContext;
    private final PreferenceHelper preferenceHelper;
    private final List<MapplsStyle> styleList = new ArrayList();
    private final HashMap<String, StyleData> styleHashMap = new HashMap<>();
    private final HashMap<String, Bitmap> logoHashMap = new HashMap<>();
    private final HashMap<String, LogoData> logoDataHashMap = new HashMap<>();

    public MapplsStylesHelper(Context context) {
        this.mContext = context;
        this.preferenceHelper = new PreferenceHelper(context);
    }

    MapplsStyle getStyle(String str) {
        MapplsStyle mapplsStyle = null;
        if (str != null) {
            for (MapplsStyle mapplsStyle2 : this.styleList) {
                if (mapplsStyle2.getName().equalsIgnoreCase(str)) {
                    mapplsStyle = mapplsStyle2;
                }
            }
        }
        return mapplsStyle;
    }

    public synchronized void getGlobalBitmapLogo(String str, LogoImageLoadCallback logoImageLoadCallback) {
        StyleData styleData = this.styleHashMap.get(str);
        if (styleData != null && styleData.getGlobalLogoId() != null) {
            if (this.logoHashMap.containsKey(styleData.getGlobalLogoId())) {
                logoImageLoadCallback.onSuccess(this.logoHashMap.get(styleData.getGlobalLogoId()));
            } else if (this.logoDataHashMap.containsKey(styleData.getGlobalLogoId())) {
                downloadImage(this.logoBaseUrl, this.logoDataHashMap.get(styleData.getGlobalLogoId()), logoImageLoadCallback);
            } else {
                logoImageLoadCallback.onFailure();
            }
        } else {
            logoImageLoadCallback.onSuccess(BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon)));
        }
    }

    public synchronized void getBitmapLogo(String str, LogoImageLoadCallback logoImageLoadCallback) {
        StyleData styleData = this.styleHashMap.get(str);
        if (styleData != null && styleData.getLogoIdIndia() != null) {
            if (this.logoHashMap.containsKey(styleData.getLogoIdIndia())) {
                logoImageLoadCallback.onSuccess(this.logoHashMap.get(styleData.getLogoIdIndia()));
            } else if (this.logoDataHashMap.containsKey(styleData.getLogoIdIndia())) {
                downloadImage(this.logoBaseUrl, this.logoDataHashMap.get(styleData.getLogoIdIndia()), logoImageLoadCallback);
            } else {
                logoImageLoadCallback.onFailure();
            }
        } else {
            logoImageLoadCallback.onSuccess(BitmapUtils.getBitmapFromDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon)));
        }
    }

    MapplsStyle getDefaultStyle() {
        return this.defaultStyle;
    }

    void setSelectedStyle(String str) {
        this.preferenceHelper.setLastSelectedStyle(str);
    }

    MapplsStyle getLastSelectedStyle() {
        return getStyle(this.preferenceHelper.getLastSelectedStyle());
    }

    private String getBaseUrl() {
        return this.baseUrl;
    }

    public String getStyleUrl(MapplsStyle mapplsStyle) {
        if (!this.styleHashMap.containsKey(mapplsStyle.getName())) {
            return null;
        }
        StyleData styleData = this.styleHashMap.get(mapplsStyle.getName());
        if (styleData.getStyleUrl().startsWith("https://") || styleData.getStyleUrl().startsWith("http://")) {
            return styleData.getStyleUrl();
        }
        return this.baseUrl + styleData.getStyleUrl();
    }

    List<MapplsStyle> getStyleList() {
        return this.styleList;
    }

    private void getBitmap(final String str, final OnImageAdded onImageAdded) {
        Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.mappls.sdk.maps.MapplsStylesHelper.1
            @Override // java.lang.Runnable
            public void run() {
                URL url;
                Bitmap bitmapDecodeStream = null;
                try {
                    url = new URL(str);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    url = null;
                }
                try {
                    bitmapDecodeStream = BitmapFactory.decodeStream(((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection())).getInputStream());
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                onImageAdded.getBitmap(bitmapDecodeStream);
            }
        });
    }

    private void downloadImage(String str, final LogoData logoData, final LogoImageLoadCallback logoImageLoadCallback) {
        File file = new File(this.mContext.getFilesDir(), logoData.getLogoId());
        file.mkdir();
        final File file2 = new File(file, logoData.getModified() + ".jpg");
        if (file2.exists()) {
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file2.getAbsolutePath());
            this.logoHashMap.put(logoData.getLogoId(), bitmapDecodeFile);
            if (logoImageLoadCallback != null) {
                logoImageLoadCallback.onSuccess(bitmapDecodeFile);
                return;
            }
            return;
        }
        for (File file3 : file.listFiles()) {
            if (file3 != null) {
                file3.delete();
            }
        }
        getBitmap(str + logoData.getLogoUrl(), new OnImageAdded() { // from class: com.mappls.sdk.maps.MapplsStylesHelper.2
            @Override // com.mappls.sdk.maps.OnImageAdded
            public void getBitmap(Bitmap bitmap) throws Throwable {
                MapplsStylesHelper.this.logoHashMap.put(logoData.getLogoId(), bitmap);
                MapplsStylesHelper.this.saveImageToFile(bitmap, file2.getAbsolutePath());
                LogoImageLoadCallback logoImageLoadCallback2 = logoImageLoadCallback;
                if (logoImageLoadCallback2 != null) {
                    logoImageLoadCallback2.onSuccess(bitmap);
                }
            }
        });
    }

    private void getLogos(String str, List<LogoData> list) {
        if (list == null) {
            return;
        }
        for (LogoData logoData : list) {
            this.logoDataHashMap.put(logoData.getLogoId(), logoData);
            downloadImage(str, logoData, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveImageToFile(Bitmap bitmap, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(str);
                    try {
                        bitmap.setHasAlpha(true);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                        fileOutputStream2.close();
                    } catch (Exception e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        e.printStackTrace();
                        if (fileOutputStream == null) {
                        } else {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e3) {
                    e = e3;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initStyles(GetStylesResponse getStylesResponse) {
        this.baseUrl = getStylesResponse.getBaseUrl();
        this.logoBaseUrl = getStylesResponse.getBaseUrlLogo();
        this.styleList.clear();
        for (StyleData styleData : getStylesResponse.getData()) {
            MapplsStyle mapplsStyle = new MapplsStyle(styleData.getName(), styleData.getDisplayName(), styleData.getDescription(), this.baseUrl + styleData.getImageUrl(), styleData.isDefault());
            this.styleList.add(mapplsStyle);
            this.styleHashMap.put(styleData.getName(), styleData);
            if (styleData.isDefault().intValue() == 1) {
                this.defaultStyle = mapplsStyle;
            }
        }
        getLogos(getStylesResponse.getBaseUrlLogo(), getStylesResponse.getLogoData());
    }

    void initialiseStyles(final IStyleListener iStyleListener) {
        if (this.baseUrl != null && this.styleList != null && this.defaultStyle != null) {
            if (iStyleListener != null) {
                iStyleListener.onSuccess();
            }
        } else {
            MapplsGetStyle.builder().logoResolution("drawable-" + MapplsUtils.getDensityName()).build().enqueueCall(new Callback<GetStylesResponse>() { // from class: com.mappls.sdk.maps.MapplsStylesHelper.3
                @Override // retrofit2.Callback
                public void onResponse(Call<GetStylesResponse> call, Response<GetStylesResponse> response) {
                    if (response.code() == 200) {
                        GetStylesResponse getStylesResponseBody = response.body();
                        MapplsStylesHelper.this.preferenceHelper.setMapplsStyle(getStylesResponseBody);
                        MapplsStylesHelper.this.initStyles(getStylesResponseBody);
                        if (MapplsLMSManager.isInitialised()) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                if (MapplsStylesHelper.this.defaultStyle != null) {
                                    jSONObject.put("default_style", MapplsStylesHelper.this.defaultStyle.getName());
                                }
                                if (MapplsStylesHelper.this.getLastSelectedStyle() != null) {
                                    jSONObject.put("last_selected_style", MapplsStylesHelper.this.getLastSelectedStyle().getName());
                                }
                                MapplsLMSManager.getInstance().add("style-api-success", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                        IStyleListener iStyleListener2 = iStyleListener;
                        if (iStyleListener2 != null) {
                            iStyleListener2.onSuccess();
                            return;
                        }
                        return;
                    }
                    if (response.code() == 7 || response.code() == 8 || response.code() == 9 || response.code() == 101 || response.code() == 102 || response.code() == 103) {
                        if (MapplsLMSManager.isInitialised()) {
                            try {
                                JSONObject jSONObject2 = new JSONObject();
                                jSONObject2.put("error_code", response.code());
                                jSONObject2.put("error_message", response.message());
                                MapplsLMSManager.getInstance().add("style-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject2);
                            } catch (JSONException unused2) {
                            }
                        }
                        IStyleListener iStyleListener3 = iStyleListener;
                        if (iStyleListener3 != null) {
                            iStyleListener3.onFailure(response.code(), response.message());
                            return;
                        }
                        return;
                    }
                    if (response.code() != 401) {
                        if (MapplsStylesHelper.this.preferenceHelper.getMapplsStyle() != null) {
                            MapplsStylesHelper.this.initStyles(MapplsStylesHelper.this.preferenceHelper.getMapplsStyle());
                            IStyleListener iStyleListener4 = iStyleListener;
                            if (iStyleListener4 != null) {
                                iStyleListener4.onSuccess();
                            }
                        } else {
                            IStyleListener iStyleListener5 = iStyleListener;
                            if (iStyleListener5 != null) {
                                iStyleListener5.onFailure(5, MapplsStylesHelper.STYLE_ERROR_CODE);
                            }
                        }
                        if (MapplsLMSManager.isInitialised()) {
                            try {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put("error_code", response.code());
                                jSONObject3.put("error_message", response.message());
                                MapplsLMSManager.getInstance().add("style-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject3);
                                return;
                            } catch (JSONException unused3) {
                                return;
                            }
                        }
                        return;
                    }
                    if (MapplsLMSManager.isInitialised()) {
                        try {
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("error_code", response.code());
                            jSONObject4.put("error_message", response.message());
                            MapplsLMSManager.getInstance().add("style-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject4);
                        } catch (JSONException unused4) {
                        }
                    }
                    IStyleListener iStyleListener6 = iStyleListener;
                    if (iStyleListener6 != null) {
                        iStyleListener6.onFailure(response.code(), MapplsStylesHelper.STYLE_ERROR_CODE);
                    }
                }

                @Override // retrofit2.Callback
                public void onFailure(Call<GetStylesResponse> call, Throwable th) {
                    th.printStackTrace();
                    if (MapplsStylesHelper.this.preferenceHelper.getMapplsStyle() != null) {
                        MapplsStylesHelper.this.initStyles(MapplsStylesHelper.this.preferenceHelper.getMapplsStyle());
                        IStyleListener iStyleListener2 = iStyleListener;
                        if (iStyleListener2 != null) {
                            iStyleListener2.onSuccess();
                        }
                    } else {
                        IStyleListener iStyleListener3 = iStyleListener;
                        if (iStyleListener3 != null) {
                            iStyleListener3.onFailure(5, MapplsStylesHelper.STYLE_ERROR_CODE);
                        }
                    }
                    if (MapplsLMSManager.isInitialised()) {
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("error_code", 5);
                            jSONObject.put("error_message", th.getMessage());
                            jSONObject.put("is_load_from_cache", MapplsStylesHelper.this.preferenceHelper.getMapplsStyle() != null);
                            MapplsLMSManager.getInstance().add("style-api-error", BuildConfig.MAPPLS_SDK_NAME, BuildConfig.MAPPLS_SDK_VERSION, jSONObject);
                        } catch (JSONException unused) {
                        }
                    }
                }
            });
        }
    }
}
