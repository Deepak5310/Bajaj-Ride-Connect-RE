package com.google.android.libraries.geo.navcore.ui.header.views;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.View;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements cx {
    final com.google.android.libraries.navigation.internal.mt.a a;

    public c(com.google.android.libraries.navigation.internal.mt.a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:154:0x01dd, code lost:
    
        if ((r5 instanceof com.google.android.libraries.navigation.internal.bl.d.a) != false) goto L157;
     */
    @Override // com.google.android.libraries.navigation.internal.ms.cx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        if (!(cwVar instanceof b)) {
            return false;
        }
        View view = ckVar.c;
        switch ((b) cwVar) {
            case ALLOW_TWO_LINES:
                if (!(view instanceof StepCueView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((StepCueView) view).setAllowTwoLines(((Boolean) obj).booleanValue());
                return true;
            case INCLUDE_FONT_PADDING:
                if (!(view instanceof StepCueView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((StepCueView) view).setIncludeFontPadding((Boolean) obj);
                return true;
            case MANEUVER:
                if (view instanceof ManeuverImageView) {
                    if (obj != null) {
                        break;
                    } else {
                        obj = null;
                    }
                    ((ManeuverImageView) view).setManeuver((com.google.android.libraries.navigation.internal.bl.d.a) obj);
                    return true;
                }
                if (!(view instanceof NextTurnTextView)) {
                    return false;
                }
                if (obj != null && !(obj instanceof com.google.android.libraries.navigation.internal.bl.d.a)) {
                    return false;
                }
                ((NextTurnTextView) view).setManeuver((com.google.android.libraries.navigation.internal.bl.d.a) obj);
                return true;
            case MANEUVER_COLOR:
                if (view instanceof ManeuverImageView) {
                    if (obj instanceof x) {
                        ((ManeuverImageView) view).setColor(this.a.b(view, (x) obj));
                        return true;
                    }
                    if (obj instanceof Number) {
                        ((ManeuverImageView) view).setColor(((Number) obj).intValue());
                        return true;
                    }
                    if (obj == null) {
                        this.a.v(null);
                        obj = null;
                    }
                    if (obj instanceof x) {
                        ((ManeuverImageView) view).setColor(this.a.b(view, (x) obj));
                        return true;
                    }
                    if (obj instanceof Number) {
                        ((ManeuverImageView) view).setColor(((Number) obj).intValue());
                        return true;
                    }
                    if (obj == null) {
                        this.a.v((Number) obj);
                    }
                    if (obj == null) {
                        this.a.v((Number) obj);
                        obj = null;
                    }
                }
                if (!(view instanceof NextTurnTextView)) {
                    return false;
                }
                if (obj instanceof x) {
                    ((NextTurnTextView) view).setColor(this.a.b(view, (x) obj));
                    return true;
                }
                boolean z = obj instanceof Number;
                if (z) {
                    ((NextTurnTextView) view).setColor(((Number) obj).intValue());
                    return true;
                }
                if (obj == null || z) {
                    this.a.v((Number) obj);
                }
                if (obj == null || z) {
                    this.a.v((Number) obj);
                }
                if (obj != null && !z) {
                    return false;
                }
                this.a.v((Number) obj);
                return false;
            case MULTI_ICON_VIEW_ICONS:
                if (!(view instanceof MultiIconView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof d)) {
                    return false;
                }
                ((MultiIconView) view).setIconsFromProvider$ar$class_merging((d) obj);
                return true;
            case NEXT_TURN_TEXT_VIEW_STYLE:
                if (!(view instanceof NextTurnTextView) || !(obj instanceof i)) {
                    return false;
                }
                ((NextTurnTextView) view).setStyle((i) obj);
                return true;
            case SHOW_SINGLE_CUE:
                if (!(view instanceof StepCueView) || !(obj instanceof Boolean)) {
                    return false;
                }
                ((StepCueView) view).setShowSingleCue(((Boolean) obj).booleanValue());
                return true;
            case STEP_CUE:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof l)) {
                    return false;
                }
                ((StepCueView) view).setProperties((l) obj);
                return true;
            case STEP_CUE_FIRST_ROW_TEXT_SIZE:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ap)) {
                    return false;
                }
                ((StepCueView) view).setFirstRowTextSize((ap) obj);
                return true;
            case STEP_CUE_SECOND_ROW_TEXT_SIZE:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof ap)) {
                    return false;
                }
                ((StepCueView) view).setSecondRowTextSize((ap) obj);
                return true;
            case STEP_CUE_SECONDARY_TEXT_COLOR:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof x)) {
                    if (obj instanceof Number) {
                        ((StepCueView) view).setSecondaryTextColor(this.a.p((Number) obj));
                        return true;
                    }
                    if (!(obj instanceof ColorStateList)) {
                        return false;
                    }
                    ((StepCueView) view).setSecondaryTextColor((ColorStateList) obj);
                    return true;
                }
                ((StepCueView) view).setSecondaryTextColor(this.a.g(view, (x) obj));
                return true;
            case STEP_CUE_SHOWING_POLICY:
                if (!(view instanceof StepCueView) || !(obj instanceof k)) {
                    return false;
                }
                ((StepCueView) view).setStepCueShowingPolicy((k) obj);
                return true;
            case STEP_CUE_VIEW_STYLE:
                if (!(view instanceof StepCueView) || !(obj instanceof m)) {
                    return false;
                }
                ((StepCueView) view).setStyle((m) obj);
                return true;
            case TEXT_COLOR:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj == null) {
                    obj = null;
                } else if (!(obj instanceof x)) {
                    if (obj instanceof Number) {
                        ((StepCueView) view).setTextColor(this.a.p((Number) obj));
                        return true;
                    }
                    if (!(obj instanceof ColorStateList)) {
                        return false;
                    }
                    ((StepCueView) view).setTextColor((ColorStateList) obj);
                    return true;
                }
                ((StepCueView) view).setTextColor(this.a.g(view, (x) obj));
                return true;
            case TYPEFACE:
                if (!(view instanceof StepCueView) || !(obj instanceof Typeface)) {
                    return false;
                }
                ((StepCueView) view).setTypeface((Typeface) obj);
                return true;
            default:
                return false;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ms.cx
    public final boolean b(cw cwVar, ck ckVar) {
        return false;
    }
}
