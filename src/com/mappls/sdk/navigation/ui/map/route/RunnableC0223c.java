package com.mappls.sdk.navigation.ui.map.route;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.CoordinateCallback;
import com.mappls.sdk.services.api.directions.models.DirectionsRoute;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: com.mappls.sdk.navigation.ui.map.route.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes4.dex */
public final class RunnableC0223c implements Runnable {
    public final /* synthetic */ E a;
    public final /* synthetic */ C0224d b;

    public RunnableC0223c(C0224d c0224d, E e) {
        this.b = c0224d;
        this.a = e;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.e.get()) {
            return;
        }
        E e = this.a;
        C0224d c0224d = this.b;
        ArrayList arrayList = c0224d.b;
        HashMap map = c0224d.d;
        u uVar = (u) e;
        uVar.a.b.addAll(arrayList);
        uVar.a.a.putAll(map);
        z zVar = uVar.a;
        zVar.getClass();
        ArrayList arrayList2 = new ArrayList();
        int i = 1;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList2.addAll(((FeatureCollection) arrayList.get(size)).features());
        }
        FeatureCollection featureCollectionFromFeatures = FeatureCollection.fromFeatures(arrayList2);
        zVar.x = featureCollectionFromFeatures;
        zVar.t.setGeoJson(featureCollectionFromFeatures);
        z zVar2 = uVar.a;
        DirectionsRoute directionsRoute = (DirectionsRoute) zVar2.c.get(zVar2.u);
        ArrayList arrayList3 = new ArrayList();
        if (directionsRoute == null || directionsRoute.routeOptions() == null || directionsRoute.routeOptions().coordinates() == null) {
            FeatureCollection featureCollectionFromFeatures2 = FeatureCollection.fromFeatures(arrayList3);
            zVar2.y = featureCollectionFromFeatures2;
            zVar2.s.setGeoJson(featureCollectionFromFeatures2);
        } else {
            ArrayList<y> arrayList4 = new ArrayList();
            int i2 = 1;
            while (i2 < directionsRoute.routeOptions().coordinates().size()) {
                if (i2 == directionsRoute.routeOptions().coordinates().size() - i) {
                    String str = directionsRoute.routeOptions().coordinates().get(i2);
                    if (str.contains(",")) {
                        String[] strArrSplit = str.split(",");
                        Feature featureFromGeometry = Feature.fromGeometry(Point.fromLngLat(Double.parseDouble(strArrSplit[0]), Double.parseDouble(strArrSplit[i])));
                        featureFromGeometry.addStringProperty("wayPoint", FirebaseAnalytics.Param.DESTINATION);
                        arrayList3.add(featureFromGeometry);
                    } else {
                        y yVar = new y();
                        yVar.b = str;
                        yVar.a = FirebaseAnalytics.Param.DESTINATION;
                        arrayList4.add(yVar);
                    }
                } else {
                    String str2 = directionsRoute.routeOptions().coordinates().get(i2);
                    if (str2.contains(",")) {
                        String[] strArrSplit2 = str2.split(",");
                        Feature featureFromGeometry2 = Feature.fromGeometry(Point.fromLngLat(Double.parseDouble(strArrSplit2[0]), Double.parseDouble(strArrSplit2[1])));
                        i2 = i2;
                        if (i2 == 1) {
                            featureFromGeometry2.addStringProperty("wayPoint", "origin_1");
                        } else if (i2 == 2) {
                            featureFromGeometry2.addStringProperty("wayPoint", "origin_2");
                        } else if (i2 == 3) {
                            featureFromGeometry2.addStringProperty("wayPoint", "origin_3");
                        }
                        arrayList3.add(featureFromGeometry2);
                    } else {
                        y yVar2 = new y();
                        yVar2.b = str2;
                        if (i2 == 1) {
                            yVar2.a = "origin_1";
                        } else if (i2 == 2) {
                            yVar2.a = "origin_2";
                        } else if (i2 == 3) {
                            yVar2.a = "origin_3";
                        }
                        arrayList4.add(yVar2);
                    }
                }
                i2++;
                i = 1;
            }
            if (arrayList4.size() > 0) {
                ArrayList arrayList5 = new ArrayList();
                HashMap map2 = new HashMap();
                for (y yVar3 : arrayList4) {
                    arrayList5.add(yVar3.b);
                    map2.put(yVar3.b, yVar3.a);
                }
                x xVar = new x(zVar2, map2, arrayList3);
                try {
                    Class<?> cls = Class.forName("com.mappls.sdk.maps.BaseMapplsHelper");
                    Object objNewInstance = cls.newInstance();
                    Method declaredMethod = cls.getDeclaredMethod("getAnnotation", List.class, CoordinateCallback.class);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(objNewInstance, arrayList5, xVar);
                } catch (ClassNotFoundException e2) {
                    e2.printStackTrace();
                    xVar.onFailure();
                } catch (IllegalAccessException e3) {
                    e3.printStackTrace();
                    xVar.onFailure();
                } catch (InstantiationException e4) {
                    e4.printStackTrace();
                    xVar.onFailure();
                } catch (NoSuchMethodException e5) {
                    e5.printStackTrace();
                    xVar.onFailure();
                } catch (InvocationTargetException e6) {
                    e6.printStackTrace();
                    xVar.onFailure();
                }
            } else {
                FeatureCollection featureCollectionFromFeatures3 = FeatureCollection.fromFeatures(arrayList3);
                zVar2.y = featureCollectionFromFeatures3;
                zVar2.s.setGeoJson(featureCollectionFromFeatures3);
            }
        }
        z zVar3 = uVar.a;
        zVar3.r.getStyle(new w(zVar3));
        uVar.a.r.getStyle(new t(uVar));
    }
}
