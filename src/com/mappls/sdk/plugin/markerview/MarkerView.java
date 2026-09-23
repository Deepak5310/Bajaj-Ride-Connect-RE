package com.mappls.sdk.plugin.markerview;

import android.graphics.PointF;
import android.view.View;
import com.mappls.sdk.maps.CoordinateCallback;
import com.mappls.sdk.maps.CoordinateResult;
import com.mappls.sdk.maps.Projection;
import com.mappls.sdk.maps.geometry.LatLng;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public class MarkerView {
    private LatLng latLng;
    private String mapplsPin;
    private OnPositionUpdateListener onPositionUpdateListener;
    private Projection projection;
    private final View view;

    public interface OnPositionUpdateListener {
        PointF onUpdate(PointF pointF);
    }

    public MarkerView(LatLng latLng, View view) {
        this.latLng = latLng;
        this.view = view;
    }

    public MarkerView(String str, View view) {
        this.mapplsPin = str;
        this.view = view;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
        update();
    }

    public void setMapplsPin(String str) {
        this.mapplsPin = str;
    }

    public void setOnPositionUpdateListener(OnPositionUpdateListener onPositionUpdateListener) {
        this.onPositionUpdateListener = onPositionUpdateListener;
    }

    void setProjection(Projection projection) {
        this.projection = projection;
    }

    View getView() {
        return this.view;
    }

    void update() {
        if (this.mapplsPin != null) {
            try {
                Class<?> cls = Class.forName("com.mappls.sdk.maps.BaseMapplsHelper");
                Object objNewInstance = cls.newInstance();
                Method declaredMethod = cls.getDeclaredMethod("getAnnotation", String.class, CoordinateCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(objNewInstance, this.mapplsPin, new CoordinateCallback() { // from class: com.mappls.sdk.plugin.markerview.MarkerView.1
                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void coordinateResultSuccess(List<CoordinateResult> list) {
                        if (list.size() > 0) {
                            PointF screenLocation = MarkerView.this.projection.toScreenLocation(new LatLng(list.get(0).getLatitude().doubleValue(), list.get(0).getLongitude().doubleValue()));
                            if (MarkerView.this.onPositionUpdateListener != null) {
                                screenLocation = MarkerView.this.onPositionUpdateListener.onUpdate(screenLocation);
                            }
                            MarkerView.this.view.setX(screenLocation.x);
                            MarkerView.this.view.setY(screenLocation.y);
                            return;
                        }
                        Timber.e("FAILURE to evaluate Mappls Pin", new Object[0]);
                    }

                    @Override // com.mappls.sdk.maps.CoordinateCallback
                    public void onFailure() {
                        Timber.e("FAILURE to evaluate Mappls Pin", new Object[0]);
                    }
                });
                return;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return;
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
                return;
            } catch (InstantiationException e3) {
                e3.printStackTrace();
                return;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return;
            }
        }
        PointF screenLocation = this.projection.toScreenLocation(this.latLng);
        OnPositionUpdateListener onPositionUpdateListener = this.onPositionUpdateListener;
        if (onPositionUpdateListener != null) {
            screenLocation = onPositionUpdateListener.onUpdate(screenLocation);
        }
        this.view.setX(screenLocation.x);
        this.view.setY(screenLocation.y);
    }
}
