package com.mappls.sdk.maps.rctmgl.components.styles.sources;

import android.content.Context;
import com.mappls.sdk.maps.style.sources.RasterSource;

/* JADX INFO: loaded from: classes4.dex */
public class RCTMGLRasterSource extends RCTMGLTileSource<RasterSource> {
    private Integer mTileSize;

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTSource
    public boolean hasPressListener() {
        return false;
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTSource
    public void onPress(RCTSource.OnPressEvent onPressEvent) {
    }

    public RCTMGLRasterSource(Context context) {
        super(context);
    }

    @Override // com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTSource
    public RasterSource makeSource() {
        String url = getURL();
        Integer num = this.mTileSize;
        int iIntValue = num == null ? 512 : num.intValue();
        if (url != null) {
            return new RasterSource(this.mID, url, iIntValue);
        }
        return new RasterSource(this.mID, buildTileset(), iIntValue);
    }

    public void setTileSize(int i) {
        this.mTileSize = Integer.valueOf(i);
    }
}
