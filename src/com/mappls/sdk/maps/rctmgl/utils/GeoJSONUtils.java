package com.mappls.sdk.maps.rctmgl.utils;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.maps.android.data.kml.KmlPolygon;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.geojson.GeometryCollection;
import com.mappls.sdk.geojson.LineString;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.geojson.Polygon;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.geometry.LatLngBounds;
import com.mappls.sdk.maps.geometry.LatLngQuad;
import com.mappls.sdk.turf.TurfMeasurement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GeoJSONUtils {
    public static WritableMap fromFeature(Feature feature) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "Feature");
        writableMapCreateMap.putString("id", feature.id());
        writableMapCreateMap.putMap("geometry", fromGeometry(feature.geometry()));
        writableMapCreateMap.putMap("properties", ConvertUtils.toWritableMap(feature.properties()));
        return writableMapCreateMap;
    }

    public static WritableMap fromGeometry(Geometry geometry) {
        String strType = geometry.type();
        strType.hashCode();
        switch (strType) {
            case "Point":
                return fromPoint((Point) geometry);
            case "Polygon":
                return fromPolygon((Polygon) geometry);
            case "LineString":
                return fromLineString((LineString) geometry);
            default:
                return null;
        }
    }

    public static WritableMap fromPoint(Point point) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "Point");
        writableMapCreateMap.putArray("coordinates", getCoordinates(point));
        return writableMapCreateMap;
    }

    public static WritableMap fromLineString(LineString lineString) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", "LineString");
        writableMapCreateMap.putArray("coordinates", getCoordinates(lineString));
        return writableMapCreateMap;
    }

    public static WritableMap fromPolygon(Polygon polygon) {
        WritableMap writableMapCreateMap = Arguments.createMap();
        writableMapCreateMap.putString("type", KmlPolygon.GEOMETRY_TYPE);
        writableMapCreateMap.putArray("coordinates", getCoordinates(polygon));
        return writableMapCreateMap;
    }

    public static WritableArray getCoordinates(Point point) {
        return Arguments.fromArray(pointToDoubleArray(point));
    }

    public static WritableArray getCoordinates(LineString lineString) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        Iterator<Point> it2 = lineString.coordinates().iterator();
        while (it2.hasNext()) {
            writableArrayCreateArray.pushArray(Arguments.fromArray(pointToDoubleArray(it2.next())));
        }
        return writableArrayCreateArray;
    }

    public static WritableArray getCoordinates(Polygon polygon) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        List<List<Point>> listCoordinates = polygon.coordinates();
        if (listCoordinates == null) {
            return writableArrayCreateArray;
        }
        for (List<Point> list : listCoordinates) {
            WritableArray writableArrayCreateArray2 = Arguments.createArray();
            Iterator<Point> it2 = list.iterator();
            while (it2.hasNext()) {
                writableArrayCreateArray2.pushArray(Arguments.fromArray(pointToDoubleArray(it2.next())));
            }
            writableArrayCreateArray.pushArray(writableArrayCreateArray2);
        }
        return writableArrayCreateArray;
    }

    public static WritableMap toPointFeature(LatLng latLng, WritableMap writableMap) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("type", "Feature");
        writableNativeMap.putMap("geometry", toPointGeometry(latLng));
        writableNativeMap.putMap("properties", writableMap);
        return writableNativeMap;
    }

    public static WritableMap toPointGeometry(LatLng latLng) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("type", "Point");
        writableNativeMap.putArray("coordinates", fromLatLng(latLng));
        return writableNativeMap;
    }

    public static WritableArray fromLatLng(LatLng latLng) {
        double[] dArr = {latLng.getLongitude(), latLng.getLatitude()};
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        writableNativeArray.pushDouble(dArr[0]);
        writableNativeArray.pushDouble(dArr[1]);
        return writableNativeArray;
    }

    public static LatLng toLatLng(Point point) {
        if (point == null) {
            return null;
        }
        return new LatLng(point.latitude(), point.longitude());
    }

    public static LatLng toLatLng(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() < 2) {
            return null;
        }
        return new LatLng(readableArray.getDouble(1), readableArray.getDouble(0));
    }

    public static Point toPointGeometry(String str) {
        Feature featureFromJson = Feature.fromJson(str);
        if (featureFromJson == null) {
            return null;
        }
        return (Point) featureFromJson.geometry();
    }

    public static WritableArray fromLatLngBounds(LatLngBounds latLngBounds) {
        WritableArray writableArrayCreateArray = Arguments.createArray();
        for (LatLng latLng : latLngBounds.toLatLngs()) {
            writableArrayCreateArray.pushArray(fromLatLng(latLng));
        }
        return writableArrayCreateArray;
    }

    private static GeometryCollection toGeometryCollection(List<Feature> list) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(list.size());
        Iterator<Feature> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(it2.next().geometry());
        }
        return GeometryCollection.fromGeometries(arrayList);
    }

    public static LatLngBounds toLatLngBounds(FeatureCollection featureCollection) {
        double[] dArrBbox = TurfMeasurement.bbox((Geometry) toGeometryCollection(featureCollection.features()));
        return LatLngBounds.from(dArrBbox[3], dArrBbox[2], dArrBbox[1], dArrBbox[0]);
    }

    public static LatLngQuad toLatLngQuad(ReadableArray readableArray) {
        if (readableArray == null || readableArray.size() < 4) {
            return null;
        }
        return new LatLngQuad(toLatLng(readableArray.getArray(0)), toLatLng(readableArray.getArray(1)), toLatLng(readableArray.getArray(2)), toLatLng(readableArray.getArray(3)));
    }

    public static double[] pointToDoubleArray(Point point) {
        if (point == null) {
            return new double[]{0.0d, 0.0d};
        }
        return new double[]{point.longitude(), point.latitude()};
    }
}
