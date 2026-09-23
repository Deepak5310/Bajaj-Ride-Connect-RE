package com.google.android.libraries.navigation.internal.zt;

import com.google.android.libraries.navigation.internal.ael.bm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public enum as implements bm {
    UNASSIGNED_USER_ACTION_ID(0),
    AUTOMATED(1),
    USER(2),
    GENERIC_CLICK(3),
    TAP(4),
    KEYBOARD_ENTER(5),
    MOUSE_CLICK(6),
    LEFT_CLICK(7),
    RIGHT_CLICK(8),
    HOVER(9),
    INTO_BOUNDING_BOX(10),
    OUT_OF_BOUNDING_BOX(11),
    PINCH(12),
    PINCH_OPEN(13),
    PINCH_CLOSED(14),
    INPUT_TEXT(15),
    INPUT_KEYBOARD(16),
    INPUT_VOICE(17),
    RESIZE_BROWSER(18),
    ROTATE_SCREEN(19),
    DIRECTIONAL_MOVEMENT(20),
    SWIPE(21),
    SCROLL_BAR(22),
    MOUSE_WHEEL(23),
    ARROW_KEYS(24),
    NAVIGATE(25),
    BACK_BUTTON(26),
    UNKNOWN_ACTION(27),
    HEAD_MOVEMENT(28),
    SHAKE(29),
    DRAG(30),
    LONG_PRESS(31),
    KEY_PRESS(32),
    ACTION_BY_TIMER(33),
    DOUBLE_CLICK(34),
    DOUBLE_TAP(35),
    ROLL(36),
    DROP(37),
    FORCE_TOUCH(38),
    MULTI_KEY_PRESS(39),
    TWO_FINGER_DRAG(40),
    ENTER_PROXIMITY(41),
    CAUSAL_USER_ACTION(45),
    CAUSAL_AUTOMATED(46),
    INPUT_STYLUS(47),
    TWO_FINGER_DRAG_UP(48),
    TWO_FINGER_DRAG_DOWN(49),
    BROWSER_ACTION(50),
    VIDEO_STATS(51),
    DRAW_CIRCLE(52),
    DRAW_STRIKETHROUGH(53);

    public final int Z;

    as(int i) {
        this.Z = i;
    }

    public static as b(int i) {
        switch (i) {
            case 0:
                return UNASSIGNED_USER_ACTION_ID;
            case 1:
                return AUTOMATED;
            case 2:
                return USER;
            case 3:
                return GENERIC_CLICK;
            case 4:
                return TAP;
            case 5:
                return KEYBOARD_ENTER;
            case 6:
                return MOUSE_CLICK;
            case 7:
                return LEFT_CLICK;
            case 8:
                return RIGHT_CLICK;
            case 9:
                return HOVER;
            case 10:
                return INTO_BOUNDING_BOX;
            case 11:
                return OUT_OF_BOUNDING_BOX;
            case 12:
                return PINCH;
            case 13:
                return PINCH_OPEN;
            case 14:
                return PINCH_CLOSED;
            case 15:
                return INPUT_TEXT;
            case 16:
                return INPUT_KEYBOARD;
            case 17:
                return INPUT_VOICE;
            case 18:
                return RESIZE_BROWSER;
            case 19:
                return ROTATE_SCREEN;
            case 20:
                return DIRECTIONAL_MOVEMENT;
            case 21:
                return SWIPE;
            case 22:
                return SCROLL_BAR;
            case 23:
                return MOUSE_WHEEL;
            case 24:
                return ARROW_KEYS;
            case 25:
                return NAVIGATE;
            case 26:
                return BACK_BUTTON;
            case 27:
                return UNKNOWN_ACTION;
            case 28:
                return HEAD_MOVEMENT;
            case 29:
                return SHAKE;
            case 30:
                return DRAG;
            case 31:
                return LONG_PRESS;
            case 32:
                return KEY_PRESS;
            case 33:
                return ACTION_BY_TIMER;
            case 34:
                return DOUBLE_CLICK;
            case 35:
                return DOUBLE_TAP;
            case 36:
                return ROLL;
            case 37:
                return DROP;
            case 38:
                return FORCE_TOUCH;
            case 39:
                return MULTI_KEY_PRESS;
            case 40:
                return TWO_FINGER_DRAG;
            case 41:
                return ENTER_PROXIMITY;
            case 42:
            case 43:
            case 44:
            default:
                return null;
            case 45:
                return CAUSAL_USER_ACTION;
            case 46:
                return CAUSAL_AUTOMATED;
            case 47:
                return INPUT_STYLUS;
            case 48:
                return TWO_FINGER_DRAG_UP;
            case 49:
                return TWO_FINGER_DRAG_DOWN;
            case 50:
                return BROWSER_ACTION;
            case 51:
                return VIDEO_STATS;
            case 52:
                return DRAW_CIRCLE;
            case 53:
                return DRAW_STRIKETHROUGH;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ael.bm
    public final int a() {
        return this.Z;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.Z);
    }
}
