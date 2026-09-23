package com.mappls.sdk.maps.rctmgl.components.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.core.content.res.ResourcesCompat;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.rctmgl.R;
import com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature;
import com.mappls.sdk.maps.rctmgl.components.mapview.RCTMGLMapView;
import com.mappls.sdk.maps.rctmgl.events.ImageMissingEvent;
import com.mappls.sdk.maps.rctmgl.utils.DownloadMapImageTask;
import com.mappls.sdk.maps.rctmgl.utils.ImageEntry;
import com.mappls.sdk.maps.utils.BitmapUtils;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLImages extends AbstractMapFeature {
    private static Bitmap mImagePlaceholder;
    Set<String> mCurrentImages;
    protected String mID;
    private Map<String, ImageEntry> mImages;
    private RCTMGLImagesManager mManager;
    private MapplsMap mMap;
    private Map<String, BitmapDrawable> mNativeImages;
    private boolean mSendMissingImageEvents;

    public String getID() {
        return this.mID;
    }

    public void setID(String str) {
        this.mID = str;
    }

    public RCTMGLImages(Context context, RCTMGLImagesManager rCTMGLImagesManager) {
        super(context);
        this.mSendMissingImageEvents = false;
        this.mManager = rCTMGLImagesManager;
        this.mCurrentImages = new HashSet();
        this.mImages = new HashMap();
        this.mNativeImages = new HashMap();
        if (mImagePlaceholder == null) {
            mImagePlaceholder = BitmapUtils.getBitmapFromDrawable(ResourcesCompat.getDrawable(context.getResources(), R.drawable.empty_drawable, null));
        }
    }

    public void setImages(List<Map.Entry<String, ImageEntry>> list) {
        HashMap map = new HashMap();
        for (Map.Entry<String, ImageEntry> entry : list) {
            String key = entry.getKey();
            ImageEntry value = entry.getValue();
            if (this.mImages.put(key, value) == null) {
                map.put(key, value);
            }
        }
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null || mapplsMap.getStyle() == null) {
            return;
        }
        addImagesToStyle(map, this.mMap);
    }

    public void setNativeImages(List<Map.Entry<String, BitmapDrawable>> list) {
        HashMap map = new HashMap();
        for (Map.Entry<String, BitmapDrawable> entry : list) {
            String key = entry.getKey();
            BitmapDrawable value = entry.getValue();
            if (this.mNativeImages.put(key, value) == null) {
                map.put(key, value);
            }
        }
        MapplsMap mapplsMap = this.mMap;
        if (mapplsMap == null || mapplsMap.getStyle() == null) {
            return;
        }
        addNativeImagesToStyle(map, this.mMap);
    }

    public void setHasOnImageMissing(boolean z) {
        this.mSendMissingImageEvents = z;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void removeFromMap(RCTMGLMapView rCTMGLMapView) {
        removeImages(rCTMGLMapView);
        this.mMap = null;
        this.mNativeImages = new HashMap();
        this.mImages = new HashMap();
        this.mCurrentImages = new HashSet();
    }

    private void removeImages(RCTMGLMapView rCTMGLMapView) {
        rCTMGLMapView.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.images.RCTMGLImages.1
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                if (RCTMGLImages.this.hasImages()) {
                    Iterator it2 = RCTMGLImages.this.mImages.entrySet().iterator();
                    while (it2.hasNext()) {
                        style.removeImage((String) ((Map.Entry) it2.next()).getKey());
                    }
                }
                if (RCTMGLImages.this.hasNativeImages()) {
                    Iterator it3 = RCTMGLImages.this.mNativeImages.entrySet().iterator();
                    while (it3.hasNext()) {
                        style.removeImage((String) ((Map.Entry) it3.next()).getKey());
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasImages() {
        Map<String, ImageEntry> map = this.mImages;
        return map != null && map.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasNativeImages() {
        Map<String, BitmapDrawable> map = this.mNativeImages;
        return map != null && map.size() > 0;
    }

    static <K, V> List<Map.Entry<K, V>> entry(K k, V v) {
        return Collections.singletonList(new AbstractMap.SimpleEntry(k, v));
    }

    public boolean addMissingImageToStyle(String str, MapplsMap mapplsMap) {
        ImageEntry imageEntry;
        BitmapDrawable bitmapDrawable;
        Map<String, BitmapDrawable> map = this.mNativeImages;
        if (map != null && (bitmapDrawable = map.get(str)) != null) {
            addNativeImages(entry(str, bitmapDrawable), mapplsMap);
            return true;
        }
        Map<String, ImageEntry> map2 = this.mImages;
        if (map2 == null || (imageEntry = map2.get(str)) == null) {
            return false;
        }
        addRemoteImages(entry(str, imageEntry), mapplsMap);
        return true;
    }

    public void addImagesToStyle(Map<String, ImageEntry> map, MapplsMap mapplsMap) {
        if (map != null) {
            addRemoteImages(new ArrayList(map.entrySet()), mapplsMap);
        }
    }

    public void addNativeImagesToStyle(Map<String, BitmapDrawable> map, MapplsMap mapplsMap) {
        if (map != null) {
            addNativeImages(new ArrayList(map.entrySet()), mapplsMap);
        }
    }

    public void sendImageMissingEvent(String str, MapplsMap mapplsMap) {
        if (this.mSendMissingImageEvents) {
            this.mManager.handleEvent(ImageMissingEvent.makeImageMissingEvent(this, str));
        }
    }

    private boolean hasImage(String str, MapplsMap mapplsMap) {
        Style style = mapplsMap.getStyle();
        return (style == null || style.getImage(str) == null) ? false : true;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.AbstractMapFeature
    public void addToMap(final RCTMGLMapView rCTMGLMapView) {
        rCTMGLMapView.getStyle(new Style.OnStyleLoaded() { // from class: com.mappls.sdk.maps.rctmgl.components.images.RCTMGLImages.2
            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                MapplsMap mapplsMap = rCTMGLMapView.getMapplsMap();
                RCTMGLImages.this.mMap = mapplsMap;
                RCTMGLImages rCTMGLImages = RCTMGLImages.this;
                rCTMGLImages.addNativeImagesToStyle(rCTMGLImages.mNativeImages, mapplsMap);
                RCTMGLImages rCTMGLImages2 = RCTMGLImages.this;
                rCTMGLImages2.addImagesToStyle(rCTMGLImages2.mImages, mapplsMap);
            }
        });
    }

    private void addNativeImages(List<Map.Entry<String, BitmapDrawable>> list, MapplsMap mapplsMap) {
        Style style = mapplsMap.getStyle();
        if (style == null || list == null) {
            return;
        }
        for (Map.Entry<String, BitmapDrawable> entry : list) {
            if (!hasImage(entry.getKey(), mapplsMap)) {
                style.addImage(entry.getKey(), entry.getValue());
                this.mCurrentImages.add(entry.getKey());
            }
        }
    }

    private void addRemoteImages(List<Map.Entry<String, ImageEntry>> list, MapplsMap mapplsMap) {
        Style style = mapplsMap.getStyle();
        if (style == null || list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, ImageEntry> entry : list) {
            if (!hasImage(entry.getKey(), mapplsMap)) {
                style.addImage(entry.getKey(), mImagePlaceholder);
                arrayList.add(entry);
                this.mCurrentImages.add(entry.getKey());
            }
        }
        if (arrayList.size() > 0) {
            new DownloadMapImageTask(getContext(), mapplsMap, null).execute((Map.Entry[]) arrayList.toArray(new Map.Entry[arrayList.size()]));
        }
    }
}
