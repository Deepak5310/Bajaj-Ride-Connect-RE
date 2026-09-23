package com.mappls.sdk.navigation.camera;

import com.mappls.sdk.geojson.Point;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: Camera.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/mappls/sdk/navigation/camera/Camera;", "", "()V", "overview", "", "Lcom/mappls/sdk/geojson/Point;", "routeInformation", "Lcom/mappls/sdk/navigation/camera/RouteInformation;", "tilt", "", "zoom", "navigation-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class Camera {
    public abstract List<Point> overview(RouteInformation routeInformation);

    public abstract double tilt(RouteInformation routeInformation);

    public abstract double zoom(RouteInformation routeInformation);
}
