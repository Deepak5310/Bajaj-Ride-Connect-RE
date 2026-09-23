package com.mappls.sdk.navigation.ui.views.turnlane;

/* JADX INFO: loaded from: classes4.dex */
public class TurnLaneViewData {
    static final String DRAW_LANE_RIGHT = "draw_lane_right";
    static final String DRAW_LANE_RIGHT_ONLY = "draw_lane_right_only";
    static final String DRAW_LANE_SLIGHT_RIGHT = "draw_lane_slight_right";
    static final String DRAW_LANE_STRAIGHT = "draw_lane_straight";
    static final String DRAW_LANE_STRAIGHT_ONLY = "draw_lane_straight_only";
    static final String DRAW_LANE_STRAIGHT_RIGHT = "draw_lane_straight_right";
    static final String DRAW_LANE_UTURN = "draw_lane_uturn";
    private String drawMethod;
    private boolean shouldFlip;

    TurnLaneViewData(String str, String str2) {
        buildDrawData(str, str2);
    }

    private void buildDrawData(String str, String str2) {
        if (str.contentEquals("uturn")) {
            this.drawMethod = DRAW_LANE_UTURN;
            this.shouldFlip = true;
            return;
        }
        if (str.contentEquals("straight")) {
            this.drawMethod = DRAW_LANE_STRAIGHT;
            return;
        }
        if (str.contentEquals("right")) {
            this.drawMethod = DRAW_LANE_RIGHT;
            return;
        }
        if (str.contentEquals("left")) {
            this.drawMethod = DRAW_LANE_RIGHT;
            this.shouldFlip = true;
            return;
        }
        if (str.contentEquals("slight right")) {
            this.drawMethod = DRAW_LANE_SLIGHT_RIGHT;
            return;
        }
        if (str.contentEquals("slight left")) {
            this.drawMethod = DRAW_LANE_SLIGHT_RIGHT;
            this.shouldFlip = true;
        } else if (isStraightPlusIndication(str, "right")) {
            setDrawMethodWithModifier(str2);
        } else if (isStraightPlusIndication(str, "left")) {
            setDrawMethodWithModifier(str2);
            this.shouldFlip = true;
        }
    }

    private boolean isStraightPlusIndication(String str, String str2) {
        return str.contains("straight") && str.contains(str2);
    }

    private void setDrawMethodWithModifier(String str) {
        String str2;
        if (str.contains("right")) {
            str2 = DRAW_LANE_RIGHT_ONLY;
        } else {
            str2 = str.contains("straight") ? DRAW_LANE_STRAIGHT_ONLY : DRAW_LANE_STRAIGHT_RIGHT;
        }
        this.drawMethod = str2;
    }

    String getDrawMethod() {
        return this.drawMethod;
    }

    boolean shouldBeFlipped() {
        return this.shouldFlip;
    }
}
