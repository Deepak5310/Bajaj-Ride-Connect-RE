package com.mappls.sdk.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class MultiFingerGesture<L> extends BaseGesture<L> {
    private static final int DEFAULT_REQUIRED_FINGERS_COUNT = 2;
    private static final float PRESSURE_THRESHOLD = 0.67f;
    private DisplayMetrics displayMetrics;
    private final float edgeSlop;
    private PointF focalPoint;
    private final PermittedActionsGuard permittedActionsGuard;
    final List<Integer> pointerIdList;
    final HashMap<PointerDistancePair, MultiFingerDistancesObject> pointersDistanceMap;
    private float spanThreshold;

    protected boolean analyzeMovement() {
        return false;
    }

    protected int getRequiredPointersCount() {
        return 2;
    }

    protected void reset() {
    }

    public MultiFingerGesture(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        this.permittedActionsGuard = new PermittedActionsGuard();
        this.pointerIdList = new ArrayList();
        this.pointersDistanceMap = new HashMap<>();
        this.focalPoint = new PointF();
        this.edgeSlop = ViewConfiguration.get(context).getScaledEdgeSlop();
        queryDisplayMetrics();
    }

    @Override // com.mappls.sdk.gestures.BaseGesture
    protected boolean analyzeEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            queryDisplayMetrics();
        }
        boolean z = this.permittedActionsGuard.isMissingActions(actionMasked, motionEvent.getPointerCount(), this.pointerIdList.size()) || (actionMasked == 2 && isMissingPointers(motionEvent));
        if (z) {
            if (this instanceof ProgressiveGesture) {
                ProgressiveGesture progressiveGesture = (ProgressiveGesture) this;
                if (progressiveGesture.isInProgress()) {
                    progressiveGesture.gestureStopped();
                }
            }
            this.pointerIdList.clear();
            this.pointersDistanceMap.clear();
        }
        if (!z || actionMasked == 0) {
            updatePointerList(motionEvent);
        }
        this.focalPoint = Utils.determineFocalPoint(motionEvent);
        if (z) {
            Log.w("MultiFingerGesture", "Some MotionEvents were not passed to the library or events from different view trees are merged.");
            return false;
        }
        if (actionMasked == 2 && this.pointerIdList.size() >= getRequiredPointersCount() && checkPressure()) {
            calculateDistances();
            if (!isSloppyGesture()) {
                return analyzeMovement();
            }
        }
        return false;
    }

    private void queryDisplayMetrics() {
        if (this.windowManager != null) {
            this.displayMetrics = new DisplayMetrics();
            this.windowManager.getDefaultDisplay().getRealMetrics(this.displayMetrics);
        } else {
            this.displayMetrics = this.context.getResources().getDisplayMetrics();
        }
    }

    private void updatePointerList(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            this.pointerIdList.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        } else if (actionMasked == 1 || actionMasked == 6) {
            this.pointerIdList.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        }
    }

    private boolean isMissingPointers(MotionEvent motionEvent) {
        Iterator<Integer> it2 = this.pointerIdList.iterator();
        while (it2.hasNext()) {
            if (motionEvent.findPointerIndex(it2.next().intValue()) == -1) {
                return true;
            }
        }
        return false;
    }

    boolean checkPressure() {
        return getCurrentEvent().getPressure() / getPreviousEvent().getPressure() > PRESSURE_THRESHOLD;
    }

    private boolean checkSpanBelowThreshold() {
        Iterator<MultiFingerDistancesObject> it2 = this.pointersDistanceMap.values().iterator();
        while (it2.hasNext()) {
            if (it2.next().getCurrFingersDiffXY() < this.spanThreshold) {
                return true;
            }
        }
        return false;
    }

    protected boolean isSloppyGesture() {
        float f = this.displayMetrics.widthPixels - this.edgeSlop;
        float f2 = this.displayMetrics.heightPixels;
        float f3 = this.edgeSlop;
        float f4 = f2 - f3;
        Iterator<Integer> it2 = this.pointerIdList.iterator();
        while (it2.hasNext()) {
            int iFindPointerIndex = getCurrentEvent().findPointerIndex(it2.next().intValue());
            float rawX = Utils.getRawX(getCurrentEvent(), iFindPointerIndex);
            float rawY = Utils.getRawY(getCurrentEvent(), iFindPointerIndex);
            if (rawX < f3 || rawY < f3 || rawX > f || rawY > f4) {
                return true;
            }
        }
        return checkSpanBelowThreshold();
    }

    @Override // com.mappls.sdk.gestures.BaseGesture
    protected boolean canExecute(int i) {
        return super.canExecute(i) && !isSloppyGesture();
    }

    private void calculateDistances() {
        this.pointersDistanceMap.clear();
        int i = 0;
        while (i < this.pointerIdList.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.pointerIdList.size(); i3++) {
                Integer num = this.pointerIdList.get(i);
                int iIntValue = num.intValue();
                Integer num2 = this.pointerIdList.get(i3);
                int iIntValue2 = num2.intValue();
                float x = getPreviousEvent().getX(getPreviousEvent().findPointerIndex(iIntValue));
                float y = getPreviousEvent().getY(getPreviousEvent().findPointerIndex(iIntValue));
                this.pointersDistanceMap.put(new PointerDistancePair(num, num2), new MultiFingerDistancesObject(getPreviousEvent().getX(getPreviousEvent().findPointerIndex(iIntValue2)) - x, getPreviousEvent().getY(getPreviousEvent().findPointerIndex(iIntValue2)) - y, getCurrentEvent().getX(getCurrentEvent().findPointerIndex(iIntValue2)) - getCurrentEvent().getX(getCurrentEvent().findPointerIndex(iIntValue)), getCurrentEvent().getY(getCurrentEvent().findPointerIndex(iIntValue2)) - getCurrentEvent().getY(getCurrentEvent().findPointerIndex(iIntValue))));
            }
            i = i2;
        }
    }

    public float getCurrentSpan(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getCurrFingersDiffXY();
    }

    public float getPreviousSpan(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getPrevFingersDiffXY();
    }

    public float getCurrentSpanX(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getCurrFingersDiffX());
    }

    public float getCurrentSpanY(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getCurrFingersDiffY());
    }

    public float getPreviousSpanX(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getPrevFingersDiffX());
    }

    public float getPreviousSpanY(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getPrevFingersDiffY());
    }

    private boolean verifyPointers(int i, int i2) {
        return i != i2 && i >= 0 && i2 >= 0 && i < getPointersCount() && i2 < getPointersCount();
    }

    public int getPointersCount() {
        return this.pointerIdList.size();
    }

    public PointF getFocalPoint() {
        return this.focalPoint;
    }

    public float getSpanThreshold() {
        return this.spanThreshold;
    }

    public void setSpanThreshold(float f) {
        this.spanThreshold = f;
    }

    public void setSpanThresholdResource(int i) {
        setSpanThreshold(this.context.getResources().getDimension(i));
    }
}
