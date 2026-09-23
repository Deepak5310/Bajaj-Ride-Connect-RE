package com.mappls.sdk.plugin.annotation;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.gestures.MoveDistancesObject;
import com.mappls.sdk.maps.Projection;

/* JADX INFO: loaded from: classes4.dex */
public abstract class Annotation<T extends Geometry> {
    static final String ID_DATA = "custom_data";
    static final String ID_KEY = "id";
    protected T geometry;
    private boolean isDraggable;
    protected JsonObject jsonObject;

    Annotation(long j, JsonObject jsonObject, T t) {
        this.jsonObject = jsonObject;
        jsonObject.addProperty("id", Long.valueOf(j));
        this.geometry = t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        if (this.isDraggable == annotation.isDraggable && this.jsonObject.equals(annotation.jsonObject)) {
            return this.geometry.equals(annotation.geometry);
        }
        return false;
    }

    public JsonElement getData() {
        return this.jsonObject.get(ID_DATA);
    }

    JsonObject getFeature() {
        return this.jsonObject;
    }

    public T getGeometry() {
        T t = this.geometry;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException();
    }

    public long getId() {
        return this.jsonObject.get("id").getAsLong();
    }

    abstract String getName();

    abstract Geometry getOffsetGeometry(Projection projection, MoveDistancesObject moveDistancesObject, float f, float f2);

    public int hashCode() {
        return (((this.jsonObject.hashCode() * 31) + this.geometry.hashCode()) * 31) + (this.isDraggable ? 1 : 0);
    }

    public boolean isDraggable() {
        return this.isDraggable;
    }

    public void setData(JsonElement jsonElement) {
        this.jsonObject.add(ID_DATA, jsonElement);
    }

    public void setDraggable(boolean z) {
        this.isDraggable = z;
    }

    public void setGeometry(T t) {
        this.geometry = t;
    }

    abstract void setUsedDataDrivenProperties();

    public String toString() {
        return getName() + "{geometry=" + this.geometry + ", properties=" + this.jsonObject + ", isDraggable=" + this.isDraggable + '}';
    }
}
