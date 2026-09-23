package com.mappls.sdk.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class MoveGestureDetector extends ProgressiveGesture<OnMoveGestureListener> {
    private static final int MOVE_REQUIRED_POINTERS_COUNT = 1;
    private static final Set<Integer> handledTypes;
    float lastDistanceX;
    float lastDistanceY;
    private final Map<Integer, MoveDistancesObject> moveDistancesObjectMap;
    private float moveThreshold;
    private RectF moveThresholdRect;
    private PointF previousFocalPoint;
    private boolean resetFocal;

    public interface OnMoveGestureListener {
        boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2);

        boolean onMoveBegin(MoveGestureDetector moveGestureDetector);

        void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2);
    }

    public static class SimpleOnMoveGestureListener implements OnMoveGestureListener {
        @Override // com.mappls.sdk.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMove(MoveGestureDetector moveGestureDetector, float f, float f2) {
            return false;
        }

        @Override // com.mappls.sdk.gestures.MoveGestureDetector.OnMoveGestureListener
        public boolean onMoveBegin(MoveGestureDetector moveGestureDetector) {
            return true;
        }

        @Override // com.mappls.sdk.gestures.MoveGestureDetector.OnMoveGestureListener
        public void onMoveEnd(MoveGestureDetector moveGestureDetector, float f, float f2) {
        }
    }

    @Override // com.mappls.sdk.gestures.MultiFingerGesture
    protected int getRequiredPointersCount() {
        return 1;
    }

    static {
        HashSet hashSet = new HashSet();
        handledTypes = hashSet;
        hashSet.add(13);
    }

    public MoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        this.moveDistancesObjectMap = new HashMap();
    }

    @Override // com.mappls.sdk.gestures.ProgressiveGesture
    protected Set<Integer> provideHandledTypes() {
        return handledTypes;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    @Override // com.mappls.sdk.gestures.ProgressiveGesture, com.mappls.sdk.gestures.MultiFingerGesture, com.mappls.sdk.gestures.BaseGesture
    protected boolean analyzeEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.resetFocal = true;
            this.moveDistancesObjectMap.put(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())), new MoveDistancesObject(motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex())));
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.moveDistancesObjectMap.clear();
        } else if (actionMasked == 5) {
            this.resetFocal = true;
            this.moveDistancesObjectMap.put(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())), new MoveDistancesObject(motionEvent.getX(motionEvent.getActionIndex()), motionEvent.getY(motionEvent.getActionIndex())));
        } else if (actionMasked == 6) {
            this.resetFocal = true;
            this.moveDistancesObjectMap.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        }
        return super.analyzeEvent(motionEvent);
    }

    @Override // com.mappls.sdk.gestures.MultiFingerGesture
    protected boolean analyzeMovement() {
        super.analyzeMovement();
        updateMoveDistancesObjects();
        if (isInProgress()) {
            PointF focalPoint = getFocalPoint();
            this.lastDistanceX = this.previousFocalPoint.x - focalPoint.x;
            this.lastDistanceY = this.previousFocalPoint.y - focalPoint.y;
            this.previousFocalPoint = focalPoint;
            if (this.resetFocal) {
                this.resetFocal = false;
                return ((OnMoveGestureListener) this.listener).onMove(this, 0.0f, 0.0f);
            }
            return ((OnMoveGestureListener) this.listener).onMove(this, this.lastDistanceX, this.lastDistanceY);
        }
        if (!canExecute(13) || !((OnMoveGestureListener) this.listener).onMoveBegin(this)) {
            return false;
        }
        gestureStarted();
        this.previousFocalPoint = getFocalPoint();
        this.resetFocal = false;
        return true;
    }

    private void updateMoveDistancesObjects() {
        for (Integer num : this.pointerIdList) {
            int iIntValue = num.intValue();
            this.moveDistancesObjectMap.get(num).addNewPosition(getCurrentEvent().getX(getCurrentEvent().findPointerIndex(iIntValue)), getCurrentEvent().getY(getCurrentEvent().findPointerIndex(iIntValue)));
        }
    }

    boolean checkAnyMoveAboveThreshold() {
        Iterator<MoveDistancesObject> it2 = this.moveDistancesObjectMap.values().iterator();
        if (!it2.hasNext()) {
            return false;
        }
        MoveDistancesObject next = it2.next();
        boolean z = Math.abs(next.getDistanceXSinceStart()) >= this.moveThreshold || Math.abs(next.getDistanceYSinceStart()) >= this.moveThreshold;
        RectF rectF = this.moveThresholdRect;
        return (rectF == null || !rectF.contains(getFocalPoint().x, getFocalPoint().y)) && z;
    }

    @Override // com.mappls.sdk.gestures.MultiFingerGesture, com.mappls.sdk.gestures.BaseGesture
    protected boolean canExecute(int i) {
        return super.canExecute(i) && checkAnyMoveAboveThreshold();
    }

    @Override // com.mappls.sdk.gestures.MultiFingerGesture
    protected void reset() {
        super.reset();
    }

    @Override // com.mappls.sdk.gestures.ProgressiveGesture
    protected void gestureStopped() {
        super.gestureStopped();
        ((OnMoveGestureListener) this.listener).onMoveEnd(this, this.velocityX, this.velocityY);
    }

    public float getMoveThreshold() {
        return this.moveThreshold;
    }

    public void setMoveThreshold(float f) {
        this.moveThreshold = f;
    }

    public RectF getMoveThresholdRect() {
        return this.moveThresholdRect;
    }

    public void setMoveThresholdRect(RectF rectF) {
        this.moveThresholdRect = rectF;
    }

    public void setMoveThresholdResource(int i) {
        setMoveThreshold(this.context.getResources().getDimension(i));
    }

    public float getLastDistanceX() {
        return this.lastDistanceX;
    }

    public float getLastDistanceY() {
        return this.lastDistanceY;
    }

    public MoveDistancesObject getMoveObject(int i) {
        if (!isInProgress() || i < 0 || i >= getPointersCount()) {
            return null;
        }
        return this.moveDistancesObjectMap.get(this.pointerIdList.get(i));
    }
}
