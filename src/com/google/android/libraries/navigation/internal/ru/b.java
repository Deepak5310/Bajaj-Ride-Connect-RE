package com.google.android.libraries.navigation.internal.ru;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.View;
import com.google.android.libraries.geo.mapcore.internal.ui.CompassButtonView;
import com.google.android.libraries.geo.mapcore.internal.ui.i;
import com.google.android.libraries.geo.navcore.ui.header.views.ManeuverImageView;
import com.google.android.libraries.geo.navcore.ui.header.views.MultiIconView;
import com.google.android.libraries.geo.navcore.ui.header.views.NextTurnTextView;
import com.google.android.libraries.geo.navcore.ui.header.views.StepCueView;
import com.google.android.libraries.geo.navcore.ui.header.views.k;
import com.google.android.libraries.geo.navcore.ui.header.views.l;
import com.google.android.libraries.geo.navcore.ui.header.views.m;
import com.google.android.libraries.navigation.internal.ms.ck;
import com.google.android.libraries.navigation.internal.ms.cw;
import com.google.android.libraries.navigation.internal.ms.cx;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.nc.ap;
import com.google.android.libraries.navigation.internal.nc.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements cx {
    final com.google.android.libraries.navigation.internal.mt.a a;

    public b(com.google.android.libraries.navigation.internal.mt.a aVar) {
        this.a = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        if ((r5 instanceof com.google.android.libraries.geo.mapcore.internal.ui.a) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0057, code lost:
    
        if ((r5 instanceof java.lang.Float) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006b, code lost:
    
        if ((r5 instanceof java.lang.Boolean) != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x007f, code lost:
    
        if ((r5 instanceof com.google.android.libraries.navigation.internal.kj.a) != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0093, code lost:
    
        if ((r5 instanceof com.google.android.libraries.navigation.internal.nc.ah) != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00a7, code lost:
    
        if ((r5 instanceof com.google.android.libraries.navigation.internal.nc.ah) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00bb, code lost:
    
        if ((r5 instanceof com.google.android.libraries.navigation.internal.nc.ah) != false) goto L80;
     */
    @Override // com.google.android.libraries.navigation.internal.ms.cx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(cw cwVar, Object obj, ck ckVar) {
        boolean z = cwVar instanceof i;
        View view = ckVar.c;
        if (z) {
            switch ((i) cwVar) {
                case COMPASS_BUTTON_NEEDLE:
                    if (view instanceof CompassButtonView) {
                        if (obj != null) {
                            break;
                        } else {
                            obj = null;
                        }
                        ((CompassButtonView) view).d((ah) obj);
                        return true;
                    }
                    break;
                case COMPASS_BUTTON_NORTH:
                    if (view instanceof CompassButtonView) {
                        if (obj != null) {
                            break;
                        } else {
                            obj = null;
                        }
                        ((CompassButtonView) view).e((ah) obj);
                        return true;
                    }
                    break;
                case COMPASS_BUTTON_OVERVIEW:
                    if (view instanceof CompassButtonView) {
                        if (obj != null) {
                            break;
                        } else {
                            obj = null;
                        }
                        ((CompassButtonView) view).f((ah) obj);
                        return true;
                    }
                    break;
                case COMPASS_SIZE:
                    if (view instanceof CompassButtonView) {
                        if (obj != null) {
                            break;
                        } else {
                            obj = null;
                        }
                        ((CompassButtonView) view).g((com.google.android.libraries.navigation.internal.kj.a) obj);
                        return true;
                    }
                    break;
                case IS_NIGHT_MODE:
                    if (view instanceof CompassButtonView) {
                        if (obj != null) {
                            break;
                        } else {
                            obj = null;
                        }
                        ((CompassButtonView) view).i((Boolean) obj);
                        return true;
                    }
                    break;
                case CAMERA_BEARING:
                    if (view instanceof CompassButtonView) {
                        if (obj != null) {
                            break;
                        } else {
                            obj = null;
                        }
                        ((CompassButtonView) view).c((Float) obj);
                        return true;
                    }
                    break;
                case VISIBILITY_MODE:
                    if (view instanceof CompassButtonView) {
                        if (obj != null) {
                            break;
                        } else {
                            obj = null;
                        }
                        ((CompassButtonView) view).k((com.google.android.libraries.geo.mapcore.internal.ui.a) obj);
                        return true;
                    }
                    break;
                case USE_CHEAP_ROTATION:
                    if ((view instanceof CompassButtonView) && (obj instanceof Boolean)) {
                        ((CompassButtonView) view).j(((Boolean) obj).booleanValue());
                        return true;
                    }
                    break;
                case IS_NAVIGATION_MODE:
                    if ((view instanceof CompassButtonView) && (obj instanceof Boolean)) {
                        ((Boolean) obj).booleanValue();
                        ((CompassButtonView) view).h();
                        return true;
                    }
                    break;
            }
        }
        if (!(cwVar instanceof com.google.android.libraries.geo.navcore.ui.header.views.b)) {
            return false;
        }
        switch ((com.google.android.libraries.geo.navcore.ui.header.views.b) cwVar) {
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
                if ((view instanceof ManeuverImageView) && (obj == null || (obj instanceof com.google.android.libraries.navigation.internal.bl.d.a))) {
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
                    boolean z2 = obj instanceof Number;
                    if (z2) {
                        ((ManeuverImageView) view).setColor(((Number) obj).intValue());
                        return true;
                    }
                    if (obj == null || z2) {
                        this.a.v((Number) obj);
                    }
                    if (obj == null || z2) {
                        this.a.v((Number) obj);
                    }
                    if (obj == null || z2) {
                        this.a.v((Number) obj);
                    }
                    if (obj == null || z2) {
                        this.a.v((Number) obj);
                    }
                    if (obj == null || z2) {
                        this.a.v((Number) obj);
                    }
                }
                if (!(view instanceof NextTurnTextView)) {
                    return false;
                }
                if (obj instanceof x) {
                    ((NextTurnTextView) view).setColor(this.a.b(view, (x) obj));
                    return true;
                }
                boolean z3 = obj instanceof Number;
                if (z3) {
                    ((NextTurnTextView) view).setColor(((Number) obj).intValue());
                    return true;
                }
                if (obj == null || z3) {
                    this.a.v((Number) obj);
                }
                if (obj == null || z3) {
                    this.a.v((Number) obj);
                }
                if (obj == null || z3) {
                    this.a.v((Number) obj);
                }
                if (obj == null || z3) {
                    this.a.v((Number) obj);
                }
                if (obj != null && !z3) {
                    return false;
                }
                this.a.v((Number) obj);
                return false;
            case MULTI_ICON_VIEW_ICONS:
                if (!(view instanceof MultiIconView)) {
                    return false;
                }
                if (obj != null && !(obj instanceof com.google.android.libraries.geo.navcore.ui.header.views.d)) {
                    return false;
                }
                ((MultiIconView) view).setIconsFromProvider$ar$class_merging((com.google.android.libraries.geo.navcore.ui.header.views.d) obj);
                return true;
            case NEXT_TURN_TEXT_VIEW_STYLE:
                if (!(view instanceof NextTurnTextView) || !(obj instanceof com.google.android.libraries.geo.navcore.ui.header.views.i)) {
                    return false;
                }
                ((NextTurnTextView) view).setStyle((com.google.android.libraries.geo.navcore.ui.header.views.i) obj);
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
                if (obj != null && !(obj instanceof l)) {
                    return false;
                }
                ((StepCueView) view).setProperties((l) obj);
                return true;
            case STEP_CUE_FIRST_ROW_TEXT_SIZE:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj != null && !(obj instanceof ap)) {
                    return false;
                }
                ((StepCueView) view).setFirstRowTextSize((ap) obj);
                return true;
            case STEP_CUE_SECOND_ROW_TEXT_SIZE:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj != null && !(obj instanceof ap)) {
                    return false;
                }
                ((StepCueView) view).setSecondRowTextSize((ap) obj);
                return true;
            case STEP_CUE_SECONDARY_TEXT_COLOR:
                if (!(view instanceof StepCueView)) {
                    return false;
                }
                if (obj == null || (obj instanceof x)) {
                    ((StepCueView) view).setSecondaryTextColor(this.a.g(view, (x) obj));
                    return true;
                }
                if (obj instanceof Number) {
                    ((StepCueView) view).setSecondaryTextColor(this.a.p((Number) obj));
                    return true;
                }
                if (!(obj instanceof ColorStateList)) {
                    return false;
                }
                ((StepCueView) view).setSecondaryTextColor((ColorStateList) obj);
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
                if (obj == null || (obj instanceof x)) {
                    ((StepCueView) view).setTextColor(this.a.g(view, (x) obj));
                    return true;
                }
                if (obj instanceof Number) {
                    ((StepCueView) view).setTextColor(this.a.p((Number) obj));
                    return true;
                }
                if (!(obj instanceof ColorStateList)) {
                    return false;
                }
                ((StepCueView) view).setTextColor((ColorStateList) obj);
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
