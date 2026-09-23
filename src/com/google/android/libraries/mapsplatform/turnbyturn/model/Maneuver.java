package com.google.android.libraries.mapsplatform.turnbyturn.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
@Retention(RetentionPolicy.SOURCE)
public @interface Maneuver {
    public static final int DEPART = 1;
    public static final int DESTINATION = 2;
    public static final int DESTINATION_LEFT = 3;
    public static final int DESTINATION_RIGHT = 4;
    public static final int FERRY_BOAT = 63;
    public static final int FERRY_TRAIN = 64;
    public static final int FORK_LEFT = 19;
    public static final int FORK_RIGHT = 20;
    public static final int MERGE_LEFT = 17;
    public static final int MERGE_RIGHT = 18;
    public static final int MERGE_UNSPECIFIED = 16;
    public static final int NAME_CHANGE = 65;
    public static final int OFF_RAMP_KEEP_LEFT = 35;
    public static final int OFF_RAMP_KEEP_RIGHT = 36;
    public static final int OFF_RAMP_LEFT = 33;
    public static final int OFF_RAMP_RIGHT = 34;
    public static final int OFF_RAMP_SHARP_LEFT = 39;
    public static final int OFF_RAMP_SHARP_RIGHT = 40;
    public static final int OFF_RAMP_SLIGHT_LEFT = 37;
    public static final int OFF_RAMP_SLIGHT_RIGHT = 38;
    public static final int OFF_RAMP_UNSPECIFIED = 32;
    public static final int OFF_RAMP_U_TURN_CLOCKWISE = 41;
    public static final int OFF_RAMP_U_TURN_COUNTERCLOCKWISE = 42;
    public static final int ON_RAMP_KEEP_LEFT = 24;
    public static final int ON_RAMP_KEEP_RIGHT = 25;
    public static final int ON_RAMP_LEFT = 22;
    public static final int ON_RAMP_RIGHT = 23;
    public static final int ON_RAMP_SHARP_LEFT = 28;
    public static final int ON_RAMP_SHARP_RIGHT = 29;
    public static final int ON_RAMP_SLIGHT_LEFT = 26;
    public static final int ON_RAMP_SLIGHT_RIGHT = 27;
    public static final int ON_RAMP_UNSPECIFIED = 21;
    public static final int ON_RAMP_U_TURN_CLOCKWISE = 30;
    public static final int ON_RAMP_U_TURN_COUNTERCLOCKWISE = 31;
    public static final int ROUNDABOUT_CLOCKWISE = 43;
    public static final int ROUNDABOUT_COUNTERCLOCKWISE = 44;
    public static final int ROUNDABOUT_EXIT_CLOCKWISE = 61;
    public static final int ROUNDABOUT_EXIT_COUNTERCLOCKWISE = 62;
    public static final int ROUNDABOUT_LEFT_CLOCKWISE = 47;
    public static final int ROUNDABOUT_LEFT_COUNTERCLOCKWISE = 48;
    public static final int ROUNDABOUT_RIGHT_CLOCKWISE = 49;
    public static final int ROUNDABOUT_RIGHT_COUNTERCLOCKWISE = 50;
    public static final int ROUNDABOUT_SHARP_LEFT_CLOCKWISE = 55;
    public static final int ROUNDABOUT_SHARP_LEFT_COUNTERCLOCKWISE = 56;
    public static final int ROUNDABOUT_SHARP_RIGHT_CLOCKWISE = 57;
    public static final int ROUNDABOUT_SHARP_RIGHT_COUNTERCLOCKWISE = 58;
    public static final int ROUNDABOUT_SLIGHT_LEFT_CLOCKWISE = 51;
    public static final int ROUNDABOUT_SLIGHT_LEFT_COUNTERCLOCKWISE = 52;
    public static final int ROUNDABOUT_SLIGHT_RIGHT_CLOCKWISE = 53;
    public static final int ROUNDABOUT_SLIGHT_RIGHT_COUNTERCLOCKWISE = 54;
    public static final int ROUNDABOUT_STRAIGHT_CLOCKWISE = 45;
    public static final int ROUNDABOUT_STRAIGHT_COUNTERCLOCKWISE = 46;
    public static final int ROUNDABOUT_U_TURN_CLOCKWISE = 59;
    public static final int ROUNDABOUT_U_TURN_COUNTERCLOCKWISE = 60;
    public static final int STRAIGHT = 5;
    public static final int TURN_KEEP_LEFT = 8;
    public static final int TURN_KEEP_RIGHT = 9;
    public static final int TURN_LEFT = 6;
    public static final int TURN_RIGHT = 7;
    public static final int TURN_SHARP_LEFT = 12;
    public static final int TURN_SHARP_RIGHT = 13;
    public static final int TURN_SLIGHT_LEFT = 10;
    public static final int TURN_SLIGHT_RIGHT = 11;
    public static final int TURN_U_TURN_CLOCKWISE = 14;
    public static final int TURN_U_TURN_COUNTERCLOCKWISE = 15;
    public static final int UNKNOWN = 0;
}
