package com.mappls.sdk.plugin.annotation;

import android.graphics.PointF;
import androidx.collection.LongSparseArray;
import com.mappls.sdk.geojson.Feature;
import com.mappls.sdk.geojson.FeatureCollection;
import com.mappls.sdk.geojson.Point;
import com.mappls.sdk.maps.CoordinateCallback;
import com.mappls.sdk.maps.CoordinateResult;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import com.mappls.sdk.maps.Style;
import com.mappls.sdk.maps.geometry.LatLng;
import com.mappls.sdk.maps.log.Logger;
import com.mappls.sdk.maps.style.expressions.Expression;
import com.mappls.sdk.maps.style.layers.Layer;
import com.mappls.sdk.maps.style.layers.PropertyValue;
import com.mappls.sdk.maps.style.sources.GeoJsonOptions;
import com.mappls.sdk.maps.style.sources.GeoJsonSource;
import com.mappls.sdk.plugin.annotation.Annotation;
import com.mappls.sdk.plugin.annotation.OnAnnotationClickListener;
import com.mappls.sdk.plugin.annotation.OnAnnotationDragListener;
import com.mappls.sdk.plugin.annotation.OnAnnotationLongClickListener;
import com.mappls.sdk.plugin.annotation.g;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public abstract class AnnotationManager<L extends Layer, T extends Annotation, S extends g<T>, D extends OnAnnotationDragListener<T>, U extends OnAnnotationClickListener<T>, V extends OnAnnotationLongClickListener<T>> {
    private static final String TAG = "AnnotationManager";
    private String belowLayerId;
    private com.mappls.sdk.plugin.annotation.c<L> coreElementProvider;
    private long currentId;
    private d draggableAnnotationController;
    private GeoJsonOptions geoJsonOptions;
    private GeoJsonSource geoJsonSource;
    protected L layer;
    Expression layerFilter;
    private final AnnotationManager<L, T, S, D, U, V>.c mapClickResolver;
    MapView mapView;
    protected final MapplsMap mapplsMap;
    Style style;
    protected final LongSparseArray<T> annotations = new LongSparseArray<>();
    final Map<String, Boolean> dataDrivenPropertyUsageMap = new HashMap();
    final Map<String, PropertyValue> constantPropertyUsageMap = new HashMap();
    private final List<D> dragListeners = new ArrayList();
    private final List<U> clickListeners = new ArrayList();
    private final List<V> longClickListeners = new ArrayList();

    class a implements MapView.OnDidFinishLoadingStyleListener {
        final /* synthetic */ MapplsMap a;
        final /* synthetic */ GeoJsonOptions b;

        /* JADX INFO: renamed from: com.mappls.sdk.plugin.annotation.AnnotationManager$a$a, reason: collision with other inner class name */
        class C0107a implements Style.OnStyleLoaded {
            C0107a() {
            }

            @Override // com.mappls.sdk.maps.Style.OnStyleLoaded
            public void onStyleLoaded(Style style) {
                AnnotationManager.this.style = style;
                for (int i = 0; i < AnnotationManager.this.annotations.size(); i++) {
                    T tValueAt = AnnotationManager.this.annotations.valueAt(i);
                    if ((tValueAt instanceof Symbol) && style.isFullyLoaded()) {
                        Symbol symbol = (Symbol) tValueAt;
                        style.addImage(symbol.getIconImage(), symbol.icon);
                    }
                }
                a aVar = a.this;
                AnnotationManager.this.initializeSourcesAndLayers(aVar.b);
            }
        }

        a(MapplsMap mapplsMap, GeoJsonOptions geoJsonOptions) {
            this.a = mapplsMap;
            this.b = geoJsonOptions;
        }

        @Override // com.mappls.sdk.maps.MapView.OnDidFinishLoadingStyleListener
        public void onDidFinishLoadingStyle() {
            this.a.getStyle(new C0107a());
        }
    }

    class b implements CoordinateCallback {
        final /* synthetic */ List a;
        final /* synthetic */ List b;

        b(List list, List list2) {
            this.a = list;
            this.b = list2;
        }

        @Override // com.mappls.sdk.maps.CoordinateCallback
        public void coordinateResultSuccess(List<CoordinateResult> list) {
            if (list.size() > 0) {
                for (CoordinateResult coordinateResult : list) {
                    for (Symbol symbol : this.a) {
                        if (symbol.mapplsPin.equalsIgnoreCase(coordinateResult.getMapplsPin())) {
                            this.b.add(Feature.fromGeometry(Point.fromLngLat(coordinateResult.getLongitude().doubleValue(), coordinateResult.getLatitude().doubleValue()), symbol.getFeature()));
                            symbol.setUsedDataDrivenProperties();
                        }
                    }
                }
            }
            AnnotationManager.this.geoJsonSource.setGeoJson(FeatureCollection.fromFeatures((List<Feature>) this.b));
        }

        @Override // com.mappls.sdk.maps.CoordinateCallback
        public void onFailure() {
            AnnotationManager.this.geoJsonSource.setGeoJson(FeatureCollection.fromFeatures((List<Feature>) this.b));
        }
    }

    private class c implements MapplsMap.OnMapClickListener, MapplsMap.OnMapLongClickListener {
        private c() {
        }

        /* synthetic */ c(AnnotationManager annotationManager, a aVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mappls.sdk.maps.MapplsMap.OnMapClickListener
        public boolean onMapClick(LatLng latLng) {
            Annotation annotationQueryMapForFeatures;
            if (!AnnotationManager.this.clickListeners.isEmpty() && (annotationQueryMapForFeatures = AnnotationManager.this.queryMapForFeatures(latLng)) != null) {
                Iterator it2 = AnnotationManager.this.clickListeners.iterator();
                while (it2.hasNext()) {
                    if (((OnAnnotationClickListener) it2.next()).onAnnotationClick(annotationQueryMapForFeatures)) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.mappls.sdk.maps.MapplsMap.OnMapLongClickListener
        public boolean onMapLongClick(LatLng latLng) {
            Annotation annotationQueryMapForFeatures;
            if (!AnnotationManager.this.longClickListeners.isEmpty() && (annotationQueryMapForFeatures = AnnotationManager.this.queryMapForFeatures(latLng)) != null) {
                Iterator it2 = AnnotationManager.this.longClickListeners.iterator();
                while (it2.hasNext()) {
                    if (((OnAnnotationLongClickListener) it2.next()).onAnnotationLongClick(annotationQueryMapForFeatures)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    protected AnnotationManager(MapView mapView, MapplsMap mapplsMap, Style style, com.mappls.sdk.plugin.annotation.c<L> cVar, d dVar, String str, GeoJsonOptions geoJsonOptions) {
        this.mapplsMap = mapplsMap;
        this.mapView = mapView;
        this.style = style;
        this.belowLayerId = str;
        this.coreElementProvider = cVar;
        this.geoJsonOptions = geoJsonOptions;
        this.draggableAnnotationController = dVar;
        if (!style.isFullyLoaded()) {
            throw new RuntimeException("The style has to be non-null and fully loaded.");
        }
        AnnotationManager<L, T, S, D, U, V>.c cVar2 = new c(this, null);
        this.mapClickResolver = cVar2;
        mapplsMap.addOnMapClickListener(cVar2);
        mapplsMap.addOnMapLongClickListener(cVar2);
        dVar.a(this);
        initializeSourcesAndLayers(geoJsonOptions);
        mapView.addOnDidFinishLoadingStyleListener(new a(mapplsMap, geoJsonOptions));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initializeSourcesAndLayers(GeoJsonOptions geoJsonOptions) {
        this.geoJsonSource = this.coreElementProvider.a(geoJsonOptions);
        this.layer = (L) this.coreElementProvider.c();
        this.style.addSource(this.geoJsonSource);
        String str = this.belowLayerId;
        if (str == null) {
            this.style.addLayer(this.layer);
        } else {
            this.style.addLayerBelow(this.layer, str);
        }
        initializeDataDrivenPropertyMap();
        this.layer.setProperties((PropertyValue[]) this.constantPropertyUsageMap.values().toArray(new PropertyValue[0]));
        Expression expression = this.layerFilter;
        if (expression != null) {
            setFilter(expression);
        }
        updateSource();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public T queryMapForFeatures(LatLng latLng) {
        return (T) queryMapForFeatures(this.mapplsMap.getProjection().toScreenLocation(latLng));
    }

    public void addClickListener(U u) {
        this.clickListeners.add(u);
    }

    public void addDragListener(D d) {
        this.dragListeners.add(d);
    }

    public void addLongClickListener(V v) {
        this.longClickListeners.add(v);
    }

    public void clear(T t) {
        this.annotations.remove(t.getId());
        updateSource();
    }

    public void clear(List<T> list) {
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            this.annotations.remove(it2.next().getId());
        }
        updateSource();
    }

    public void clearAll() {
        this.annotations.clear();
        updateSource();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public T create(S s) {
        T t = (T) s.build(this.currentId, this);
        this.annotations.put(t.getId(), t);
        this.currentId++;
        updateSource();
        return t;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public List<T> create(List<S> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<S> it2 = list.iterator();
        while (it2.hasNext()) {
            Annotation annotationBuild = it2.next().build(this.currentId, this);
            arrayList.add(annotationBuild);
            this.annotations.put(annotationBuild.getId(), annotationBuild);
            this.currentId++;
        }
        updateSource();
        return arrayList;
    }

    void enableDataDrivenProperty(String str) {
        if (this.dataDrivenPropertyUsageMap.get(str).equals(Boolean.FALSE)) {
            this.dataDrivenPropertyUsageMap.put(str, Boolean.TRUE);
            setDataDrivenPropertyIsUsed(str);
        }
    }

    abstract String getAnnotationIdKey();

    public LongSparseArray<T> getAnnotations() {
        return this.annotations;
    }

    List<U> getClickListeners() {
        return this.clickListeners;
    }

    List<D> getDragListeners() {
        return this.dragListeners;
    }

    public String getLayerId() {
        return this.layer.getId();
    }

    List<V> getLongClickListeners() {
        return this.longClickListeners;
    }

    abstract void initializeDataDrivenPropertyMap();

    void internalUpdateSource() {
        if (this.style.isFullyLoaded()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            for (int i = 0; i < this.annotations.size(); i++) {
                T tValueAt = this.annotations.valueAt(i);
                if ((tValueAt instanceof Symbol) && tValueAt.geometry == 0) {
                    Symbol symbol = (Symbol) tValueAt;
                    arrayList3.add(symbol.mapplsPin);
                    arrayList2.add(symbol);
                } else {
                    arrayList.add(Feature.fromGeometry(tValueAt.getGeometry(), tValueAt.getFeature()));
                    tValueAt.setUsedDataDrivenProperties();
                }
            }
            if (arrayList3.size() == 0) {
                this.geoJsonSource.setGeoJson(FeatureCollection.fromFeatures(arrayList));
                return;
            }
            try {
                Class<?> cls = Class.forName("com.mappls.sdk.maps.BaseMapplsHelper");
                Object objNewInstance = cls.newInstance();
                Method declaredMethod = cls.getDeclaredMethod("getAnnotation", List.class, CoordinateCallback.class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(objNewInstance, arrayList3, new b(arrayList2, arrayList));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e2) {
                e2.printStackTrace();
            } catch (InstantiationException e3) {
                e3.printStackTrace();
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
            }
        }
    }

    public void onDestroy() {
        this.mapplsMap.removeOnMapClickListener(this.mapClickResolver);
        this.mapplsMap.removeOnMapLongClickListener(this.mapClickResolver);
        if (this.style.isFullyLoaded()) {
            this.style.removeLayer(getLayerId());
            this.style.removeSource(this.coreElementProvider.a());
        }
        this.draggableAnnotationController.b(this);
        this.dragListeners.clear();
        this.clickListeners.clear();
        this.longClickListeners.clear();
    }

    T queryMapForFeatures(PointF pointF) {
        List<Feature> listQueryRenderedFeatures = this.mapplsMap.queryRenderedFeatures(pointF, this.coreElementProvider.b());
        if (listQueryRenderedFeatures.isEmpty()) {
            return null;
        }
        return this.annotations.get(listQueryRenderedFeatures.get(0).getProperty(getAnnotationIdKey()).getAsLong());
    }

    public void removeClickListener(U u) {
        this.clickListeners.remove(u);
    }

    public void removeDragListener(D d) {
        this.dragListeners.remove(d);
    }

    public void removeLongClickListener(V v) {
        this.longClickListeners.remove(v);
    }

    protected abstract void setDataDrivenPropertyIsUsed(String str);

    abstract void setFilter(Expression expression);

    public void update(T t) {
        if (!this.annotations.containsValue(t)) {
            Logger.e(TAG, "Can't update annotation: " + t.toString() + ", the annotation isn't active annotation.");
            return;
        }
        if (t instanceof Symbol) {
            Symbol symbol = (Symbol) t;
            symbol.icon = this.style.getImage(symbol.getIconImage());
        }
        this.annotations.put(t.getId(), t);
        updateSource();
    }

    public void update(List<T> list) {
        for (T t : list) {
            this.annotations.put(t.getId(), t);
        }
        updateSource();
    }

    public void updateSource() {
        this.draggableAnnotationController.c();
        internalUpdateSource();
    }
}
