package com.mappls.sdk.maps.snapshotter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.mappls.sdk.maps.Image;
import com.mappls.sdk.maps.R;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.attribution.AttributionLayout;
import com.mappls.sdk.maps.attribution.AttributionMeasure;
import com.mappls.sdk.maps.attribution.AttributionParser;
import com.mappls.sdk.maps.camera.CameraPosition;
import com.mappls.sdk.maps.constants.MapplsConstants;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.storage.FileSource;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.sources.Source;
import com.mappls.sdk.maps.utils.FontUtils;
import com.mappls.sdk.maps.utils.ThreadUtils;

/* JADX INFO: loaded from: classes4.dex */
public class MapSnapshotter {
    private static final int LOGO_MARGIN_DP = 4;
    private static final String TAG = "Mbgl-MapSnapshotter";
    private SnapshotReadyCallback callback;
    private final Context context;
    private ErrorHandler errorHandler;
    private Observer observer;
    private Options options;
    private long nativePtr = 0;
    private boolean fullyLoaded = false;

    public interface ErrorHandler {
        void onError(String str);
    }

    public interface Observer {
        void onDidFinishLoadingStyle();

        void onStyleImageMissing(String str);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(MapSnapshot mapSnapshot);
    }

    private native void nativeAddImages(Image[] imageArr);

    private native void nativeAddLayerAbove(long j, String str);

    private native void nativeAddLayerAt(long j, int i);

    private native void nativeAddLayerBelow(long j, String str);

    private native void nativeAddSource(Source source, long j);

    private native Layer nativeGetLayer(String str);

    private native Source nativeGetSource(String str);

    protected native void finalize() throws Throwable;

    protected native void nativeCancel();

    protected native void nativeInitialize(MapSnapshotter mapSnapshotter, FileSource fileSource, float f, int i, int i2, String str, String str2, LatLngBounds latLngBounds, CameraPosition cameraPosition, boolean z, String str3);

    protected native void nativeStart();

    public native void setCameraPosition(CameraPosition cameraPosition);

    public native void setRegion(LatLngBounds latLngBounds);

    public native void setSize(int i, int i2);

    public native void setStyleJson(String str);

    public native void setStyleUrl(String str);

    public static class Options {
        private String apiBaseUrl;
        private Style.Builder builder;
        private CameraPosition cameraPosition;
        private int height;
        private LatLngBounds region;
        private int width;
        private float pixelRatio = 1.0f;
        private boolean showLogo = true;
        private String localIdeographFontFamily = MapplsConstants.DEFAULT_FONT;

        public Options(int i, int i2) {
            if (i == 0 || i2 == 0) {
                throw new IllegalArgumentException("Unable to create a snapshot with width or height set to 0");
            }
            this.width = i;
            this.height = i2;
        }

        public Options withStyleBuilder(Style.Builder builder) {
            this.builder = builder;
            return this;
        }

        public Style.Builder getBuilder() {
            return this.builder;
        }

        public Options withMapplsStyle(String str) {
            withStyleBuilder(new Style.Builder().fromMapplsStyle(str));
            return this;
        }

        public Options withStyleJson(String str) {
            withStyleBuilder(new Style.Builder().fromJson(str));
            return this;
        }

        public Options withRegion(LatLngBounds latLngBounds) {
            this.region = latLngBounds;
            return this;
        }

        public Options withPixelRatio(float f) {
            this.pixelRatio = f;
            return this;
        }

        public Options withCameraPosition(CameraPosition cameraPosition) {
            this.cameraPosition = cameraPosition;
            return this;
        }

        public Options withLogo(boolean z) {
            this.showLogo = z;
            return this;
        }

        public Options withLocalIdeographFontFamily(String str) {
            this.localIdeographFontFamily = FontUtils.extractValidFont(str);
            return this;
        }

        public Options withLocalIdeographFontFamily(String... strArr) {
            this.localIdeographFontFamily = FontUtils.extractValidFont(strArr);
            return this;
        }

        @Deprecated
        public Options withApiBaseUrl(String str) {
            this.apiBaseUrl = str;
            return this;
        }

        public Options withApiBaseUri(String str) {
            this.apiBaseUrl = str;
            return this;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public float getPixelRatio() {
            return this.pixelRatio;
        }

        public LatLngBounds getRegion() {
            return this.region;
        }

        public String getMapplsStyle() {
            Style.Builder builder = this.builder;
            if (builder == null) {
                return null;
            }
            return builder.getMapplsStyle();
        }

        public String getStyleJson() {
            Style.Builder builder = this.builder;
            if (builder == null) {
                return null;
            }
            return builder.getJson();
        }

        public CameraPosition getCameraPosition() {
            return this.cameraPosition;
        }

        public String getLocalIdeographFontFamily() {
            return this.localIdeographFontFamily;
        }

        @Deprecated
        public String getApiBaseUrl() {
            return this.apiBaseUrl;
        }

        public String getApiBaseUri() {
            return this.apiBaseUrl;
        }
    }

    public MapSnapshotter(Context context, Options options) {
        checkThread();
        this.context = context.getApplicationContext();
        this.options = options;
        FileSource fileSource = FileSource.getInstance(context);
        String apiBaseUrl = options.getApiBaseUrl();
        if (!TextUtils.isEmpty(apiBaseUrl)) {
            fileSource.setApiBaseUrl(apiBaseUrl);
        }
        nativeInitialize(this, fileSource, options.pixelRatio, options.width, options.height, options.getMapplsStyle(), options.getStyleJson(), options.region, options.cameraPosition, options.showLogo, options.localIdeographFontFamily);
    }

    public void start(SnapshotReadyCallback snapshotReadyCallback) {
        start(snapshotReadyCallback, null);
    }

    public void start(SnapshotReadyCallback snapshotReadyCallback, ErrorHandler errorHandler) {
        if (this.callback != null) {
            throw new IllegalStateException("Snapshotter was already started");
        }
        checkThread();
        this.callback = snapshotReadyCallback;
        this.errorHandler = errorHandler;
        nativeStart();
    }

    private void addLayerBelow(Layer layer, String str) {
        nativeAddLayerBelow(layer.getNativePtr(), str);
    }

    private void addLayerAbove(Layer layer, String str) {
        nativeAddLayerAbove(layer.getNativePtr(), str);
    }

    private void addLayerAt(Layer layer, int i) {
        nativeAddLayerAt(layer.getNativePtr(), i);
    }

    private void addSource(Source source) {
        nativeAddSource(source, source.getNativePtr());
    }

    public void addImage(String str, Bitmap bitmap, boolean z) {
        nativeAddImages(new Image[]{Style.toImage(new Style.Builder.ImageWrapper(str, bitmap, z))});
    }

    public void cancel() {
        checkThread();
        reset();
        nativeCancel();
    }

    public void setObserver(Observer observer) {
        checkThread();
        this.observer = observer;
    }

    protected void addOverlay(MapSnapshot mapSnapshot) {
        Bitmap bitmap = mapSnapshot.getBitmap();
        drawOverlay(mapSnapshot, bitmap, new Canvas(bitmap), ((int) this.context.getResources().getDisplayMetrics().density) * 4);
    }

    private void drawOverlay(MapSnapshot mapSnapshot, Bitmap bitmap, Canvas canvas, int i) {
        AttributionMeasure attributionMeasure = getAttributionMeasure(mapSnapshot, bitmap, i);
        AttributionLayout attributionLayoutMeasure = attributionMeasure.measure();
        drawLogo(mapSnapshot, canvas, i, attributionLayoutMeasure);
        drawAttribution(mapSnapshot, canvas, attributionMeasure, attributionLayoutMeasure);
    }

    private AttributionMeasure getAttributionMeasure(MapSnapshot mapSnapshot, Bitmap bitmap, int i) {
        Logo logoCreateScaledLogo = createScaledLogo(bitmap);
        return new AttributionMeasure.Builder().setSnapshot(bitmap).setLogo(logoCreateScaledLogo.getLarge()).setLogoSmall(logoCreateScaledLogo.getSmall()).setTextView(createTextView(mapSnapshot, false, logoCreateScaledLogo.getScale())).setTextViewShort(createTextView(mapSnapshot, true, logoCreateScaledLogo.getScale())).setMarginPadding(i).build();
    }

    private void drawLogo(MapSnapshot mapSnapshot, Canvas canvas, int i, AttributionLayout attributionLayout) {
        if (mapSnapshot.isShowLogo()) {
            drawLogo(mapSnapshot.getBitmap(), canvas, i, attributionLayout);
        }
    }

    private void drawLogo(Bitmap bitmap, Canvas canvas, int i, AttributionLayout attributionLayout) {
        Bitmap logo = attributionLayout.getLogo();
        if (logo != null) {
            canvas.drawBitmap(logo, i, (bitmap.getHeight() - logo.getHeight()) - i, (Paint) null);
        }
    }

    private void drawAttribution(MapSnapshot mapSnapshot, Canvas canvas, AttributionMeasure attributionMeasure, AttributionLayout attributionLayout) {
        PointF anchorPoint = attributionLayout.getAnchorPoint();
        if (anchorPoint != null) {
            drawAttribution(canvas, attributionMeasure, anchorPoint);
        } else {
            Bitmap bitmap = mapSnapshot.getBitmap();
            Logger.e(TAG, String.format("Could not generate attribution for snapshot size: %s x %s. You are required to provide your own attribution for the used sources: %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), mapSnapshot.getAttributions()));
        }
    }

    private void drawAttribution(Canvas canvas, AttributionMeasure attributionMeasure, PointF pointF) {
        canvas.save();
        canvas.translate(pointF.x, pointF.y);
        attributionMeasure.getTextView().draw(canvas);
        canvas.restore();
    }

    private TextView createTextView(MapSnapshot mapSnapshot, boolean z, float f) {
        int color = ResourcesCompat.getColor(this.context.getResources(), R.color.mappls_maps_gray_dark, this.context.getTheme());
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        TextView textView = new TextView(this.context);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        textView.setSingleLine(true);
        textView.setTextSize(f * 10.0f);
        textView.setTextColor(color);
        textView.setBackgroundResource(R.drawable.mappls_maps_rounded_corner);
        textView.setText(Html.fromHtml(createAttributionString(mapSnapshot, z)));
        textView.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        textView.layout(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
        return textView;
    }

    private String createAttributionString(MapSnapshot mapSnapshot, boolean z) {
        return new AttributionParser.Options(this.context).withAttributionData(mapSnapshot.getAttributions()).withCopyrightSign(false).withImproveMap(false).build().createAttributionString(z);
    }

    private Logo createScaledLogo(Bitmap bitmap) {
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.mappls_maps_logo_icon, null);
        float fCalculateLogoScale = calculateLogoScale(bitmap, bitmapDecodeResource);
        Matrix matrix = new Matrix();
        matrix.postScale(fCalculateLogoScale, fCalculateLogoScale);
        Bitmap bitmapDecodeResource2 = BitmapFactory.decodeResource(this.context.getResources(), R.drawable.mappls_maps_logo_icon, null);
        return new Logo(Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), bitmapDecodeResource.getHeight(), matrix, true), Bitmap.createBitmap(bitmapDecodeResource2, 0, 0, bitmapDecodeResource2.getWidth(), bitmapDecodeResource2.getHeight(), matrix, true), fCalculateLogoScale);
    }

    private float calculateLogoScale(Bitmap bitmap, Bitmap bitmap2) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        float fMin = Math.min((bitmap2.getWidth() / (displayMetrics.widthPixels / bitmap.getWidth())) / bitmap2.getWidth(), (bitmap2.getHeight() / (displayMetrics.heightPixels / bitmap.getHeight())) / bitmap2.getHeight()) * 2.0f;
        float f = 1.0f;
        if (fMin <= 1.0f) {
            f = 0.6f;
            if (fMin >= 0.6f) {
                return fMin;
            }
        }
        return f;
    }

    protected void onSnapshotReady(final MapSnapshot mapSnapshot) {
        new Handler().post(new Runnable() { // from class: com.mappls.sdk.maps.snapshotter.MapSnapshotter.1
            @Override // java.lang.Runnable
            public void run() {
                if (MapSnapshotter.this.callback != null) {
                    MapSnapshotter.this.addOverlay(mapSnapshot);
                    MapSnapshotter.this.callback.onSnapshotReady(mapSnapshot);
                    MapSnapshotter.this.reset();
                }
            }
        });
    }

    protected void onSnapshotFailed(final String str) {
        new Handler().post(new Runnable() { // from class: com.mappls.sdk.maps.snapshotter.MapSnapshotter.2
            @Override // java.lang.Runnable
            public void run() {
                if (MapSnapshotter.this.errorHandler != null) {
                    MapSnapshotter.this.errorHandler.onError(str);
                    MapSnapshotter.this.reset();
                }
            }
        });
    }

    protected void onDidFailLoadingStyle(String str) {
        onSnapshotFailed(str);
    }

    protected void onDidFinishLoadingStyle() {
        if (!this.fullyLoaded) {
            this.fullyLoaded = true;
            Style.Builder builder = this.options.getBuilder();
            if (builder != null) {
                for (Source source : builder.getSources()) {
                    nativeAddSource(source, source.getNativePtr());
                }
                for (Style.Builder.LayerWrapper layerWrapper : builder.getLayers()) {
                    if (layerWrapper instanceof Style.Builder.LayerAtWrapper) {
                        addLayerAt(layerWrapper.getLayer(), ((Style.Builder.LayerAtWrapper) layerWrapper).getIndex());
                    } else if (layerWrapper instanceof Style.Builder.LayerAboveWrapper) {
                        addLayerAbove(layerWrapper.getLayer(), ((Style.Builder.LayerAboveWrapper) layerWrapper).getAboveLayer());
                    } else if (layerWrapper instanceof Style.Builder.LayerBelowWrapper) {
                        addLayerBelow(layerWrapper.getLayer(), ((Style.Builder.LayerBelowWrapper) layerWrapper).getBelowLayer());
                    } else {
                        addLayerBelow(layerWrapper.getLayer(), MapplsConstants.LAYER_ID_ANNOTATIONS);
                    }
                }
                for (Style.Builder.ImageWrapper imageWrapper : builder.getImages()) {
                    addImage(imageWrapper.getId(), imageWrapper.getBitmap(), imageWrapper.isSdf());
                }
            }
        }
        Observer observer = this.observer;
        if (observer != null) {
            observer.onDidFinishLoadingStyle();
        }
    }

    public Layer getLayer(String str) {
        checkThread();
        if (this.fullyLoaded) {
            return nativeGetLayer(str);
        }
        return null;
    }

    public Source getSource(String str) {
        checkThread();
        if (this.fullyLoaded) {
            return nativeGetSource(str);
        }
        return null;
    }

    protected void onStyleImageMissing(String str) {
        Observer observer = this.observer;
        if (observer != null) {
            observer.onStyleImageMissing(str);
        }
    }

    private void checkThread() {
        ThreadUtils.checkThread(TAG);
    }

    protected void reset() {
        this.callback = null;
        this.errorHandler = null;
    }

    private class Logo {
        private Bitmap large;
        private float scale;
        private Bitmap small;

        Logo(Bitmap bitmap, Bitmap bitmap2, float f) {
            this.large = bitmap;
            this.small = bitmap2;
            this.scale = f;
        }

        public Bitmap getLarge() {
            return this.large;
        }

        public Bitmap getSmall() {
            return this.small;
        }

        public float getScale() {
            return this.scale;
        }
    }
}
