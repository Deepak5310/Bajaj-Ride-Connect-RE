package com.mappls.sdk.navigation.ui.views.turnlane;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.mappls.sdk.services.api.directions.models.IntersectionLanes;
import java.util.Iterator;

/* JADX INFO: loaded from: classes4.dex */
public class TurnLaneView extends View {
    private TurnLaneViewData drawData;
    private boolean isValid;
    private int primaryColor;
    private int secondaryColor;
    private PointF size;

    public TurnLaneView(Context context) {
        super(context);
    }

    public TurnLaneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TurnLaneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            LanesStyleKit.drawLaneStraight(canvas, this.primaryColor, this.size);
            return;
        }
        TurnLaneViewData turnLaneViewData = this.drawData;
        if (turnLaneViewData == null || TextUtils.isEmpty(turnLaneViewData.getDrawMethod())) {
            return;
        }
        String drawMethod = this.drawData.getDrawMethod();
        drawMethod.getClass();
        drawMethod.hashCode();
        byte b = -1;
        switch (drawMethod.hashCode()) {
            case -1838029873:
                if (drawMethod.equals("draw_lane_straight_right")) {
                    b = 0;
                }
                break;
            case -1315366105:
                if (drawMethod.equals("draw_lane_right_only")) {
                    b = 1;
                }
                break;
            case -1167754343:
                if (drawMethod.equals("draw_lane_straight_only")) {
                    b = 2;
                }
                break;
            case 665526424:
                if (drawMethod.equals("draw_lane_slight_right")) {
                    b = 3;
                }
                break;
            case 1235586020:
                if (drawMethod.equals("draw_lane_right")) {
                    b = 4;
                }
                break;
            case 1238698042:
                if (drawMethod.equals("draw_lane_uturn")) {
                    b = 5;
                }
                break;
        }
        int i = this.primaryColor;
        switch (b) {
            case 0:
                LanesStyleKit.drawLaneStraightRight(canvas, i, this.size);
                break;
            case 1:
                LanesStyleKit.drawLaneRightOnly(canvas, i, this.secondaryColor, this.size);
                break;
            case 2:
                LanesStyleKit.drawLaneStraightOnly(canvas, i, this.secondaryColor, this.size);
                break;
            case 3:
                LanesStyleKit.drawLaneSlightRight(canvas, i, this.size);
                break;
            case 4:
                LanesStyleKit.drawLaneRight(canvas, i, this.size);
                break;
            case 5:
                LanesStyleKit.drawLaneUturn(canvas, i, this.size);
                break;
            default:
                LanesStyleKit.drawLaneStraight(canvas, i, this.size);
                break;
        }
        setAlpha(!this.isValid ? 0.4f : 1.0f);
        setScaleX(this.drawData.shouldBeFlipped() ? -1.0f : 1.0f);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        setLayerType(1, null);
        updateManeuverColor(Color.parseColor("#FFFFFF"), Color.parseColor("#AAFFFFFF"));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.size == null) {
            this.size = new PointF(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void updateLaneView(IntersectionLanes intersectionLanes, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it2 = intersectionLanes.indications().iterator();
        if (it2.hasNext()) {
            sb.append(it2.next());
        }
        this.drawData = new TurnLaneViewData(sb.toString(), str);
        this.isValid = intersectionLanes.valid().booleanValue();
        invalidate();
    }

    void updateManeuverColor(int i, int i2) {
        this.primaryColor = i;
        this.secondaryColor = i2;
    }
}
