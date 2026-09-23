package com.mappls.sdk.navigation.ui.views.maneuver;

import com.mappls.sdk.navigation.R;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
class ManeuverMap {
    private Map<String, Integer> maneuverMap;

    ManeuverMap() {
        HashMap map = new HashMap();
        this.maneuverMap = map;
        map.put("turnuturn", Integer.valueOf(R.drawable.ic_maneuver_turn_180));
        this.maneuverMap.put("continueuturn", Integer.valueOf(R.drawable.ic_maneuver_turn_180));
        this.maneuverMap.put("continuestraight", Integer.valueOf(R.drawable.ic_maneuver_turn_0));
        this.maneuverMap.put("arriveleft", Integer.valueOf(R.drawable.ic_maneuver_arrive_left));
        this.maneuverMap.put("arriveright", Integer.valueOf(R.drawable.ic_maneuver_arrive_right));
        this.maneuverMap.put("arrive", Integer.valueOf(R.drawable.ic_maneuver_arrive));
        this.maneuverMap.put("departleft", Integer.valueOf(R.drawable.ic_maneuver_depart_left));
        this.maneuverMap.put("departright", Integer.valueOf(R.drawable.ic_maneuver_depart_right));
        this.maneuverMap.put("depart", Integer.valueOf(R.drawable.ic_maneuver_depart));
        this.maneuverMap.put("turnsharp right", Integer.valueOf(R.drawable.ic_maneuver_turn_75));
        this.maneuverMap.put("turnright", Integer.valueOf(R.drawable.ic_maneuver_turn_45));
        this.maneuverMap.put("turnslight right", Integer.valueOf(R.drawable.ic_maneuver_turn_30));
        this.maneuverMap.put("turnsharp left", Integer.valueOf(R.drawable.ic_maneuver_turn_75_left));
        this.maneuverMap.put("turnleft", Integer.valueOf(R.drawable.ic_maneuver_turn_45_left));
        this.maneuverMap.put("turnslight left", Integer.valueOf(R.drawable.ic_maneuver_turn_30_left));
        this.maneuverMap.put("mergeleft", Integer.valueOf(R.drawable.ic_maneuver_merge_left));
        this.maneuverMap.put("mergeslight left", Integer.valueOf(R.drawable.ic_maneuver_merge_left));
        this.maneuverMap.put("mergeright", Integer.valueOf(R.drawable.ic_maneuver_merge_right));
        this.maneuverMap.put("mergeslight right", Integer.valueOf(R.drawable.ic_maneuver_merge_right));
        this.maneuverMap.put("mergestraight", Integer.valueOf(R.drawable.ic_maneuver_turn_0));
        this.maneuverMap.put("on rampsharp left", Integer.valueOf(R.drawable.ic_maneuver_turn_75_left));
        this.maneuverMap.put("on rampleft", Integer.valueOf(R.drawable.ic_maneuver_turn_45_left));
        this.maneuverMap.put("on rampslight left", Integer.valueOf(R.drawable.ic_maneuver_turn_30_left));
        this.maneuverMap.put("on rampsharp right", Integer.valueOf(R.drawable.ic_maneuver_turn_75));
        this.maneuverMap.put("on rampright", Integer.valueOf(R.drawable.ic_maneuver_turn_45));
        this.maneuverMap.put("on rampslight right", Integer.valueOf(R.drawable.ic_maneuver_turn_30));
        this.maneuverMap.put("off rampleft", Integer.valueOf(R.drawable.ic_maneuver_off_ramp_left));
        this.maneuverMap.put("off rampslight left", Integer.valueOf(R.drawable.ic_maneuver_off_ramp_slight_left));
        this.maneuverMap.put("off rampright", Integer.valueOf(R.drawable.ic_maneuver_off_ramp_right));
        this.maneuverMap.put("off rampslight right", Integer.valueOf(R.drawable.ic_maneuver_off_ramp_slight_right));
        this.maneuverMap.put("forkleft", Integer.valueOf(R.drawable.ic_maneuver_fork_left));
        this.maneuverMap.put("forkslight left", Integer.valueOf(R.drawable.ic_maneuver_fork_slight_left));
        this.maneuverMap.put("forkright", Integer.valueOf(R.drawable.ic_maneuver_fork_right));
        this.maneuverMap.put("forkslight right", Integer.valueOf(R.drawable.ic_maneuver_fork_slight_right));
        this.maneuverMap.put("forkstraight", Integer.valueOf(R.drawable.ic_maneuver_fork_straight));
        this.maneuverMap.put("fork", Integer.valueOf(R.drawable.ic_maneuver_fork));
        this.maneuverMap.put("end of roadleft", Integer.valueOf(R.drawable.ic_maneuver_end_of_road_left));
        this.maneuverMap.put("end of roadright", Integer.valueOf(R.drawable.ic_maneuver_end_of_road_right));
        this.maneuverMap.put("roundaboutleft", Integer.valueOf(R.drawable.ic_maneuver_roundabout_left));
        this.maneuverMap.put("roundaboutsharp left", Integer.valueOf(R.drawable.ic_maneuver_roundabout_sharp_left));
        this.maneuverMap.put("roundaboutslight left", Integer.valueOf(R.drawable.ic_maneuver_roundabout_slight_left));
        this.maneuverMap.put("roundaboutright", Integer.valueOf(R.drawable.ic_maneuver_roundabout_right));
        this.maneuverMap.put("roundaboutsharp right", Integer.valueOf(R.drawable.ic_maneuver_roundabout_sharp_right));
        this.maneuverMap.put("roundaboutslight right", Integer.valueOf(R.drawable.ic_maneuver_roundabout_slight_right));
        this.maneuverMap.put("roundaboutstraight", Integer.valueOf(R.drawable.ic_maneuver_roundabout_straight));
        this.maneuverMap.put("roundabout", Integer.valueOf(R.drawable.ic_maneuver_roundabout));
        this.maneuverMap.put("rotaryleft", Integer.valueOf(R.drawable.ic_maneuver_roundabout_left));
        this.maneuverMap.put("rotarysharp left", Integer.valueOf(R.drawable.ic_maneuver_roundabout_sharp_left));
        this.maneuverMap.put("rotaryslight left", Integer.valueOf(R.drawable.ic_maneuver_roundabout_slight_left));
        this.maneuverMap.put("rotaryright", Integer.valueOf(R.drawable.ic_maneuver_roundabout_right));
        this.maneuverMap.put("rotarysharp right", Integer.valueOf(R.drawable.ic_maneuver_roundabout_sharp_right));
        this.maneuverMap.put("rotaryslight right", Integer.valueOf(R.drawable.ic_maneuver_roundabout_slight_right));
        this.maneuverMap.put("rotarystraight", Integer.valueOf(R.drawable.ic_maneuver_roundabout_straight));
        this.maneuverMap.put("rotary", Integer.valueOf(R.drawable.ic_maneuver_roundabout));
        this.maneuverMap.put("roundabout turnleft", Integer.valueOf(R.drawable.ic_maneuver_turn_45_left));
        this.maneuverMap.put("roundabout turnright", Integer.valueOf(R.drawable.ic_maneuver_turn_45));
        this.maneuverMap.put("notificationleft", Integer.valueOf(R.drawable.ic_maneuver_turn_45_left));
        this.maneuverMap.put("notificationsharp left", Integer.valueOf(R.drawable.ic_maneuver_turn_75_left));
        this.maneuverMap.put("notificationslight left", Integer.valueOf(R.drawable.ic_maneuver_turn_30_left));
        this.maneuverMap.put("notificationright", Integer.valueOf(R.drawable.ic_maneuver_turn_45));
        this.maneuverMap.put("notificationsharp right", Integer.valueOf(R.drawable.ic_maneuver_turn_75));
        this.maneuverMap.put("notificationslight right", Integer.valueOf(R.drawable.ic_maneuver_turn_30));
        this.maneuverMap.put("notificationstraight", Integer.valueOf(R.drawable.ic_maneuver_turn_0));
        this.maneuverMap.put("new namestraight", Integer.valueOf(R.drawable.ic_maneuver_turn_0));
    }

    public int getManeuverResource(String str) {
        return this.maneuverMap.get(str) != null ? this.maneuverMap.get(str).intValue() : R.drawable.ic_maneuver_turn_0;
    }
}
