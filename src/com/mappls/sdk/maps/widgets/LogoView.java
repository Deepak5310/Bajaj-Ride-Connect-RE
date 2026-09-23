package com.mappls.sdk.maps.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.mappls.sdk.maps.LogoImageLoadCallback;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.Mappls;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.R;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;

/* JADX INFO: loaded from: classes4.dex */
public class LogoView extends ImageView implements MapplsMap.OnCameraIdleListener, MapView.OnDidFinishLoadingStyleListener {
    static final LatLngBounds INDIA_BOUNDS = new LatLngBounds.Builder().include(new LatLng(37.238124d, 64.805223d)).include(new LatLng(5.100697d, 98.574512d)).build();
    private MapView mapView;
    private MapplsMap mapplsMap;
    private IRefreshListener refreshListener;

    public interface IRefreshListener {
        void refresh();
    }

    public LogoView(Context context) {
        super(context);
    }

    public LogoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LogoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void injectLogoView(MapView mapView, MapplsMap mapplsMap) {
        this.mapplsMap = mapplsMap;
        this.mapView = mapView;
        mapplsMap.addOnCameraIdleListener(this);
        mapView.addOnDidFinishLoadingStyleListener(this);
        setImage();
    }

    public void setRefreshListener(IRefreshListener iRefreshListener) {
        this.refreshListener = iRefreshListener;
    }

    private void setImage() {
        LogoImageLoadCallback logoImageLoadCallback = new LogoImageLoadCallback() { // from class: com.mappls.sdk.maps.widgets.LogoView.1
            @Override // com.mappls.sdk.maps.LogoImageLoadCallback
            public void onSuccess(final Bitmap bitmap) {
                LogoView.this.post(new Runnable() { // from class: com.mappls.sdk.maps.widgets.LogoView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (bitmap == null) {
                            if (LogoView.INDIA_BOUNDS.contains(LogoView.this.mapplsMap.getCameraPosition().target)) {
                                LogoView.this.setImageDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon));
                            } else {
                                LogoView.this.setImageDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon_global));
                            }
                        } else {
                            LogoView.this.setImageBitmap(bitmap);
                        }
                        if (LogoView.this.refreshListener != null) {
                            LogoView.this.refreshListener.refresh();
                        }
                    }
                });
            }

            @Override // com.mappls.sdk.maps.LogoImageLoadCallback
            public void onFailure() {
                LogoView.this.post(new Runnable() { // from class: com.mappls.sdk.maps.widgets.LogoView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (LogoView.INDIA_BOUNDS.contains(LogoView.this.mapplsMap.getCameraPosition().target)) {
                            LogoView.this.setImageDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon));
                        } else {
                            LogoView.this.setImageDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon_global));
                        }
                        LogoView.this.mapView.measure(View.MeasureSpec.makeMeasureSpec(LogoView.this.mapView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(LogoView.this.mapView.getMeasuredHeight(), 1073741824));
                        LogoView.this.mapView.layout(LogoView.this.mapView.getLeft(), LogoView.this.mapView.getTop(), LogoView.this.mapView.getRight(), LogoView.this.mapView.getBottom());
                    }
                });
            }
        };
        if (this.mapplsMap.getStyle() != null) {
            if (INDIA_BOUNDS.contains(this.mapplsMap.getCameraPosition().target)) {
                Mappls.getStyleHelper().getBitmapLogo(this.mapplsMap.getStyle().getMapplsStyle(), logoImageLoadCallback);
                return;
            } else {
                Mappls.getStyleHelper().getGlobalBitmapLogo(this.mapplsMap.getStyle().getMapplsStyle(), logoImageLoadCallback);
                return;
            }
        }
        if (INDIA_BOUNDS.contains(this.mapplsMap.getCameraPosition().target)) {
            setImageDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon));
        } else {
            setImageDrawable(ContextCompat.getDrawable(Mappls.getApplicationContext(), R.drawable.mappls_maps_logo_icon_global));
        }
        MapView mapView = this.mapView;
        mapView.measure(View.MeasureSpec.makeMeasureSpec(mapView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mapView.getMeasuredHeight(), 1073741824));
        MapView mapView2 = this.mapView;
        mapView2.layout(mapView2.getLeft(), this.mapView.getTop(), this.mapView.getRight(), this.mapView.getBottom());
    }

    @Override // com.mappls.sdk.maps.MapplsMap.OnCameraIdleListener
    public void onCameraIdle() {
        setImage();
    }

    @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
    public void onDidFinishLoadingStyle() {
        setImage();
    }
}
