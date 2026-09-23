package com.mappls.sdk.plugin.annotation;

import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import com.mappls.sdk.geojson.Geometry;
import com.mappls.sdk.gestures.AndroidGesturesManager;
import com.mappls.sdk.gestures.MoveDistancesObject;
import com.mappls.sdk.gestures.MoveGestureDetector;
import com.mappls.sdk.maps.MapView;
import com.mappls.sdk.maps.MapplsMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class d {
    private static d j;
    private MapView a;
    private MapplsMap b;
    private List<AnnotationManager> c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private Annotation h;
    private AnnotationManager i;

    class a implements View.OnTouchListener {
        final /* synthetic */ AndroidGesturesManager a;

        a(AndroidGesturesManager androidGesturesManager) {
            this.a = androidGesturesManager;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            Annotation annotation = d.this.h;
            this.a.onTouchEvent(motionEvent);
            return (d.this.h == null && annotation == null) ? false : true;
        }
    }

    private class b implements MoveGestureDetector.OnMoveGestureListener {
        private b() {
        }

        /* synthetic */ b(d dVar, a aVar) {
            this();
        }

        @Override // com.mappls.sdk.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2) {
            return d.this.a(moveGestureDetector);
        }

        @Override // com.mappls.sdk.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            return d.this.b(moveGestureDetector);
        }

        @Override // com.mappls.sdk.gestures.MoveGestureDetector.OnMoveGestureListener
        public void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2) {
            d.this.b();
        }
    }

    d(MapView mapView, MapplsMap mapplsMap) {
        this(mapView, mapplsMap, new AndroidGesturesManager(mapView.getContext(), false), mapView.getScrollX(), mapView.getScrollY(), mapView.getMeasuredWidth(), mapView.getMeasuredHeight());
    }

    public d(MapView mapView, MapplsMap mapplsMap, AndroidGesturesManager androidGesturesManager, int i, int i2, int i3, int i4) {
        this.c = new ArrayList();
        this.a = mapView;
        this.b = mapplsMap;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        androidGesturesManager.setMoveGestureListener(new b(this, null));
        mapView.setOnTouchListener(new a(androidGesturesManager));
    }

    public static d a(MapView mapView, MapplsMap mapplsMap) {
        d dVar = j;
        if (dVar == null || dVar.a != mapView || dVar.b != mapplsMap) {
            j = new d(mapView, mapplsMap);
        }
        return j;
    }

    private static void a() {
        d dVar = j;
        if (dVar != null) {
            dVar.a = null;
            dVar.b = null;
            j = null;
        }
    }

    void a(AnnotationManager annotationManager) {
        this.c.add(annotationManager);
    }

    boolean a(MoveGestureDetector moveGestureDetector) {
        if (this.h == null || (moveGestureDetector.getPointersCount() <= 1 && this.h.isDraggable())) {
            if (this.h != null) {
                MoveDistancesObject moveObject = moveGestureDetector.getMoveObject(0);
                PointF pointF = new PointF(moveObject.getCurrentX() - this.d, moveObject.getCurrentY() - this.e);
                float f = pointF.x;
                if (f >= 0.0f) {
                    float f2 = pointF.y;
                    if (f2 >= 0.0f && f <= this.f && f2 <= this.g) {
                        Geometry offsetGeometry = this.h.getOffsetGeometry(this.b.getProjection(), moveObject, this.d, this.e);
                        if (offsetGeometry != null) {
                            this.h.setGeometry(offsetGeometry);
                            this.i.internalUpdateSource();
                            Iterator it2 = this.i.getDragListeners().iterator();
                            while (it2.hasNext()) {
                                ((OnAnnotationDragListener) it2.next()).onAnnotationDrag(this.h);
                            }
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        b(this.h, this.i);
        return true;
    }

    boolean a(Annotation annotation, AnnotationManager annotationManager) {
        if (!annotation.isDraggable()) {
            return false;
        }
        Iterator it2 = annotationManager.getDragListeners().iterator();
        while (it2.hasNext()) {
            ((OnAnnotationDragListener) it2.next()).onAnnotationDragStarted(annotation);
        }
        this.h = annotation;
        this.i = annotationManager;
        return true;
    }

    void b() {
        b(this.h, this.i);
    }

    void b(Annotation annotation, AnnotationManager annotationManager) {
        if (annotation != null && annotationManager != null) {
            Iterator it2 = annotationManager.getDragListeners().iterator();
            while (it2.hasNext()) {
                ((OnAnnotationDragListener) it2.next()).onAnnotationDragFinished(annotation);
            }
        }
        this.h = null;
        this.i = null;
    }

    void b(AnnotationManager annotationManager) {
        this.c.remove(annotationManager);
        if (this.c.isEmpty()) {
            a();
        }
    }

    boolean b(MoveGestureDetector moveGestureDetector) {
        Annotation annotationQueryMapForFeatures;
        for (AnnotationManager annotationManager : this.c) {
            if (moveGestureDetector.getPointersCount() == 1 && (annotationQueryMapForFeatures = annotationManager.queryMapForFeatures(moveGestureDetector.getFocalPoint())) != null && a(annotationQueryMapForFeatures, annotationManager)) {
                return true;
            }
        }
        return false;
    }

    void c() {
        b(this.h, this.i);
    }
}
