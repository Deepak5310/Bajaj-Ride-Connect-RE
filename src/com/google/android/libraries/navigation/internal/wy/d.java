package com.google.android.libraries.navigation.internal.wy;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.libraries.mapsplatform.turnbyturn.TurnByTurnManager;
import com.google.android.libraries.mapsplatform.turnbyturn.model.Lane;
import com.google.android.libraries.mapsplatform.turnbyturn.model.LaneDirection;
import com.google.android.libraries.mapsplatform.turnbyturn.model.NavInfo;
import com.google.android.libraries.mapsplatform.turnbyturn.model.StepInfo;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends TurnByTurnManager {
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static Bundle a(StepInfo stepInfo) {
        Bundle bundle = new Bundle();
        bundle.putString("si_1", stepInfo.getFullRoadName());
        bundle.putString("si_2", stepInfo.getSimpleRoadName());
        bundle.putString("si_3", stepInfo.getFullInstructionText());
        bundle.putString("si_4", stepInfo.getExitNumber());
        bundle.putIntegerArrayList("si_0", a.a().b.a(stepInfo.getManeuver()));
        bundle.putIntegerArrayList("si_5", a.a().a.a(stepInfo.getDrivingSide()));
        c(bundle, "si_6", stepInfo.getRoundaboutTurnNumber());
        c(bundle, "si_7", stepInfo.getStepNumber());
        c(bundle, "si_8", stepInfo.getDistanceFromPrevStepMeters());
        c(bundle, "si_9", stepInfo.getTimeFromPrevStepSeconds());
        if (stepInfo.getLanes() != null) {
            List<Lane> lanes = stepInfo.getLanes();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
            for (Lane lane : lanes) {
                Bundle bundle2 = new Bundle();
                ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
                for (LaneDirection laneDirection : lane.laneDirections()) {
                    Bundle bundle3 = new Bundle();
                    bundle3.putInt("ld_0", laneDirection.laneShape());
                    bundle3.putBoolean("ld_1", laneDirection.isRecommended().booleanValue());
                    arrayList2.add(bundle3);
                }
                bundle2.putParcelableArrayList("la_0", arrayList2);
                arrayList.add(bundle2);
            }
            bundle.putParcelableArrayList("si_10", arrayList);
        }
        if (stepInfo.getManeuverBitmap() != null) {
            bundle.putParcelable("si_11", stepInfo.getManeuverBitmap());
        }
        if (stepInfo.getLanesBitmap() != null) {
            bundle.putParcelable("si_12", stepInfo.getLanesBitmap());
        }
        return bundle;
    }

    static StepInfo b(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StepInfo.Builder builder = StepInfo.builder();
        builder.setFullRoadName(bundle.getString("si_1", null));
        builder.setSimpleRoadName(bundle.getString("si_2", null));
        builder.setFullInstructionText(bundle.getString("si_3", null));
        builder.setExitNumber(bundle.getString("si_4", null));
        builder.setDrivingSide(a.c(bundle.getIntegerArrayList("si_5"), 2));
        builder.setManeuver(a.c(bundle.getIntegerArrayList("si_0"), 64));
        if (bundle.containsKey("si_6")) {
            builder.setRoundaboutTurnNumber(Integer.valueOf(bundle.getInt("si_6")));
        }
        if (bundle.containsKey("si_7")) {
            builder.setStepNumber(Integer.valueOf(bundle.getInt("si_7")));
        }
        if (bundle.containsKey("si_8")) {
            builder.setDistanceFromPrevStepMeters(Integer.valueOf(bundle.getInt("si_8")));
        }
        if (bundle.containsKey("si_9")) {
            builder.setTimeFromPrevStepSeconds(Integer.valueOf(bundle.getInt("si_9")));
        }
        if (bundle.containsKey("si_7")) {
            builder.setStepNumber(Integer.valueOf(bundle.getInt("si_7")));
        }
        if (bundle.containsKey("si_10")) {
            int i = ev.d;
            eq eqVar = new eq();
            ArrayList parcelableArrayList = bundle.getParcelableArrayList("si_10");
            int size = parcelableArrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                Bundle bundle2 = (Bundle) parcelableArrayList.get(i2);
                Lane.Builder builder2 = Lane.builder();
                eq eqVar2 = new eq();
                if (bundle2.containsKey("la_0")) {
                    ArrayList parcelableArrayList2 = bundle2.getParcelableArrayList("la_0");
                    int size2 = parcelableArrayList2.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        Bundle bundle3 = (Bundle) parcelableArrayList2.get(i3);
                        LaneDirection.Builder builder3 = LaneDirection.builder();
                        builder3.setLaneShape(bundle3.getInt("ld_0"));
                        builder3.setIsRecommended(Boolean.valueOf(bundle3.getBoolean("ld_1")));
                        eqVar2.h(builder3.build());
                    }
                }
                builder2.setLaneDirections(eqVar2.g());
                eqVar.h(builder2.build());
            }
            builder.setLanes(eqVar.g());
        }
        if (bundle.containsKey("si_11")) {
            builder.setManeuverBitmap((Bitmap) bundle.getParcelable("si_11"));
        }
        if (bundle.containsKey("si_12")) {
            builder.setLanesBitmap((Bitmap) bundle.getParcelable("si_12"));
        }
        return builder.build();
    }

    public static void c(Bundle bundle, String str, Integer num) {
        if (num != null) {
            bundle.putInt(str, num.intValue());
        }
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.TurnByTurnManager
    public final NavInfo readNavInfoFromBundle(Bundle bundle) {
        NavInfo.Builder builder = NavInfo.builder();
        builder.setCurrentStep(b(bundle.getBundle("ni_1")));
        builder.setRouteChanged(bundle.getBoolean("ni_3"));
        builder.setNavState(a.c(bundle.getIntegerArrayList("ni_0"), 3));
        if (bundle.containsKey("ni_2")) {
            bundle.setClassLoader(Bundle.class.getClassLoader());
            Bundle[] bundleArr = (Bundle[]) bundle.getParcelableArray("ni_2");
            int length = bundleArr.length;
            StepInfo[] stepInfoArr = new StepInfo[length];
            for (int i = 0; i < length; i++) {
                stepInfoArr[i] = b(bundleArr[i]);
            }
            builder.setRemainingSteps(stepInfoArr);
        }
        if (bundle.containsKey("ni_4")) {
            builder.setTimeToCurrentStepSeconds(Integer.valueOf(bundle.getInt("ni_4")));
        }
        if (bundle.containsKey("ni_5")) {
            builder.setDistanceToCurrentStepMeters(Integer.valueOf(bundle.getInt("ni_5")));
        }
        if (bundle.containsKey("ni_8")) {
            builder.setTimeToNextDestinationSeconds(Integer.valueOf(bundle.getInt("ni_8")));
        }
        if (bundle.containsKey("ni_9")) {
            builder.setDistanceToNextDestinationMeters(Integer.valueOf(bundle.getInt("ni_9")));
        }
        if (bundle.containsKey("ni_6")) {
            builder.setTimeToFinalDestinationSeconds(Integer.valueOf(bundle.getInt("ni_6")));
        }
        if (bundle.containsKey("ni_7")) {
            builder.setDistanceToFinalDestinationMeters(Integer.valueOf(bundle.getInt("ni_7")));
        }
        return builder.build();
    }

    @Override // com.google.android.libraries.mapsplatform.turnbyturn.TurnByTurnManager
    public final Bundle writeNavInfoToBundle(NavInfo navInfo) {
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("ni_0", a.a().b(navInfo.getNavState()));
        if (navInfo.getCurrentStep() != null) {
            bundle.putBundle("ni_1", a(navInfo.getCurrentStep()));
        }
        Bundle[] bundleArr = new Bundle[navInfo.getRemainingSteps().length];
        for (int i = 0; i < navInfo.getRemainingSteps().length; i++) {
            bundleArr[i] = a(navInfo.getRemainingSteps()[i]);
        }
        bundle.putParcelableArray("ni_2", bundleArr);
        bundle.putBoolean("ni_3", navInfo.getRouteChanged());
        c(bundle, "ni_4", navInfo.getTimeToCurrentStepSeconds());
        c(bundle, "ni_5", navInfo.getDistanceToCurrentStepMeters());
        c(bundle, "ni_8", navInfo.getTimeToNextDestinationSeconds());
        c(bundle, "ni_9", navInfo.getDistanceToNextDestinationMeters());
        c(bundle, "ni_6", navInfo.getTimeToFinalDestinationSeconds());
        c(bundle, "ni_7", navInfo.getDistanceToFinalDestinationMeters());
        return bundle;
    }
}
