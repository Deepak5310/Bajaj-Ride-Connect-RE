package com.bajajconnect.enums;

/* JADX INFO: loaded from: classes3.dex */
public enum PrimaryTurns {
    TURN_LEFT(73),
    TURN_RIGHT(74),
    TURN_SLIGHT_LEFT(67),
    TURN_SLIGHT_RIGHT(68),
    TURN_SHARP_LEFT(69),
    TURN_SHARP_RIGHT(70),
    STRAIGHT(71),
    MERGE(86),
    KEEP_LEFT(90),
    KEEP_RIGHT(88),
    RAMP_LEFT(75),
    RAMP_RIGHT(76),
    ROUNDABOUT_LEFT(85),
    ROUNDABOUT_RIGHT(78),
    U_TURN_LEFT(79),
    U_TURN_RIGHT(80),
    FORK_LEFT(81),
    FORK_RIGHT(82),
    FERRY(89),
    FERRY_TRAIN(84),
    DESTINATION_REACHED(72),
    WRONG_WAY(66);

    private final int value;

    PrimaryTurns(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
