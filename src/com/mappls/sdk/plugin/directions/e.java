package com.mappls.sdk.plugin.directions;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.mappls.sdk.services.api.directions.models.IntersectionLanes;
import com.mappls.sdk.services.api.directions.models.LegStep;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: loaded from: classes4.dex */
class e {
    private static final Logger c = Logger.getLogger("e");
    private JsonObject a;
    private JsonObject b;

    public e(String str, String str2) {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(String.format("translations/%s.json", str));
        if (resourceAsStream == null) {
            throw new RuntimeException("Translation not found for language: " + str);
        }
        JsonObject asJsonObject = JsonParser.parseReader(new InputStreamReader(resourceAsStream)).getAsJsonObject();
        this.a = asJsonObject;
        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject(str2);
        this.b = asJsonObject2;
        if (asJsonObject2 != null) {
            return;
        }
        throw new RuntimeException("Version not found for value: " + str2);
    }

    public static String a(String str) {
        if (str.length() == 0) {
            return "";
        }
        if (str.length() == 1) {
            return str.toUpperCase();
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public JsonObject b() {
        return this.b;
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00e6 A[PHI: r1 r5 r8
      0x00e6: PHI (r1v34 com.google.gson.JsonObject) = (r1v2 com.google.gson.JsonObject), (r1v2 com.google.gson.JsonObject), (r1v37 com.google.gson.JsonObject) binds: [B:61:0x0129, B:51:0x0105, B:44:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x00e6: PHI (r5v24 java.lang.String) = (r5v19 java.lang.String), (r5v23 java.lang.String), (r5v25 java.lang.String) binds: [B:61:0x0129, B:51:0x0105, B:44:0x00dc] A[DONT_GENERATE, DONT_INLINE]
      0x00e6: PHI (r8v2 com.google.gson.JsonPrimitive) = (r8v0 com.google.gson.JsonPrimitive), (r8v0 com.google.gson.JsonPrimitive), (r8v5 com.google.gson.JsonPrimitive) binds: [B:61:0x0129, B:51:0x0105, B:44:0x00dc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:53:0x0108  */
    /* JADX WARN: Code duplicated, block: B:58:0x0119  */
    /* JADX WARN: Code duplicated, block: B:60:0x0123  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public String a(LegStep legStep, boolean z) {
        String str;
        if (legStep.maneuver() == null) {
            throw new RuntimeException("No step maneuver provided.");
        }
        String strType = legStep.maneuver().type();
        String strModifier = legStep.maneuver().modifier();
        String strMode = legStep.mode();
        if (TextUtils.isEmpty(strType)) {
            throw new RuntimeException("Missing step maneuver type.");
        }
        if (!strType.equals("depart") && !strType.equals("arrive") && TextUtils.isEmpty(strModifier)) {
            throw new RuntimeException("Missing step maneuver modifier.");
        }
        if (b().getAsJsonObject(strType) == null) {
            c.log(Level.FINE, "Encountered unknown instruction type: " + strType);
            strType = "turn";
        }
        JsonObject asJsonObject = b().getAsJsonObject("modes").getAsJsonObject(strMode);
        if (asJsonObject == null && (asJsonObject = b().getAsJsonObject(strType).getAsJsonObject(strModifier)) == null) {
            asJsonObject = b().getAsJsonObject(strType).getAsJsonObject("default");
        }
        strType.hashCode();
        byte b = -1;
        switch (strType.hashCode()) {
            case -925180623:
                if (strType.equals("rotary")) {
                    b = 0;
                }
                break;
            case -341501723:
                if (strType.equals("use lane")) {
                    b = 1;
                }
                break;
            case -144622913:
                if (strType.equals("roundabout")) {
                    b = 2;
                }
                break;
        }
        JsonPrimitive asJsonPrimitive = null;
        switch (b) {
            case 0:
            case 2:
                if (!TextUtils.isEmpty(legStep.rotaryName()) && legStep.maneuver().exit() != null) {
                    str = "name_exit";
                    if (asJsonObject.getAsJsonObject("name_exit") != null) {
                        asJsonObject = asJsonObject.getAsJsonObject(str);
                    } else if (legStep.rotaryName() == null) {
                        if (legStep.maneuver().exit() != null) {
                            str = "exit";
                            if (asJsonObject.getAsJsonObject("exit") != null) {
                                asJsonObject = asJsonObject.getAsJsonObject(str);
                            }
                        }
                        asJsonObject = asJsonObject.getAsJsonObject("default");
                    } else {
                        if (legStep.maneuver().exit() != null) {
                            str = "exit";
                            if (asJsonObject.getAsJsonObject("exit") != null) {
                                asJsonObject = asJsonObject.getAsJsonObject(str);
                            }
                        }
                        asJsonObject = asJsonObject.getAsJsonObject("default");
                    }
                    break;
                } else if (legStep.rotaryName() == null || asJsonObject.getAsJsonObject("name") == null) {
                    if (legStep.maneuver().exit() != null) {
                        str = "exit";
                        if (asJsonObject.getAsJsonObject("exit") != null) {
                            asJsonObject = asJsonObject.getAsJsonObject(str);
                        }
                    }
                    asJsonObject = asJsonObject.getAsJsonObject("default");
                } else {
                    asJsonObject = asJsonObject.getAsJsonObject("name");
                }
                break;
            case 1:
                asJsonPrimitive = b().getAsJsonObject("constants").getAsJsonObject("lanes").getAsJsonPrimitive(a(legStep));
                if (asJsonPrimitive == null) {
                    asJsonObject = b().getAsJsonObject("use lane");
                    str = "no_lanes";
                    asJsonObject = asJsonObject.getAsJsonObject(str);
                }
                break;
        }
        String strName = TextUtils.isEmpty(legStep.name()) ? "" : legStep.name();
        String str2 = TextUtils.isEmpty(legStep.ref()) ? "" : legStep.ref().split(";")[0];
        if (strName.equals(legStep.ref())) {
            strName = "";
        }
        String strReplace = strName.replace(" (" + legStep.ref() + ")", "");
        if (!TextUtils.isEmpty(strReplace) && !TextUtils.isEmpty(str2) && !strReplace.equals(str2)) {
            str2 = strReplace + " (" + str2 + ")";
        } else if (!TextUtils.isEmpty(strReplace) || TextUtils.isEmpty(str2)) {
            str2 = strReplace;
        }
        String asString = ((TextUtils.isEmpty(legStep.destinations()) || asJsonObject.getAsJsonPrimitive(FirebaseAnalytics.Param.DESTINATION) == null) ? (TextUtils.isEmpty(str2) || asJsonObject.getAsJsonPrimitive("name") == null) ? asJsonObject.getAsJsonPrimitive("default") : asJsonObject.getAsJsonPrimitive("name") : asJsonObject.getAsJsonPrimitive(FirebaseAnalytics.Param.DESTINATION)).getAsString();
        JsonPrimitive asJsonPrimitive2 = b().getAsJsonObject("constants").getAsJsonObject("modifier").getAsJsonPrimitive(strModifier);
        String strReplaceAll = asString.replace("{way_name}", str2).replace("{destination}", TextUtils.isEmpty(legStep.destinations()) ? "" : legStep.destinations().split(",")[0]).replace("{exit_number}", a(legStep.maneuver().exit() == null ? 1 : legStep.maneuver().exit())).replace("{rotary_name}", TextUtils.isEmpty(legStep.rotaryName()) ? "" : legStep.rotaryName()).replace("{lane_instruction}", asJsonPrimitive == null ? "" : asJsonPrimitive.getAsString()).replace("{modifier}", asJsonPrimitive2 == null ? "" : asJsonPrimitive2.getAsString()).replace("{direction}", a(legStep.maneuver().bearingAfter())).replace("{nth}", "").replaceAll("\\s+", StringUtils.SPACE);
        return a().getAsJsonObject("meta").getAsJsonPrimitive("capitalizeFirstLetter").getAsBoolean() ? a(strReplaceAll) : strReplaceAll;
    }

    public String a(Double d) {
        JsonObject asJsonObject;
        String str;
        JsonPrimitive asJsonPrimitive;
        if (d == null) {
            return "";
        }
        if (d.doubleValue() < 0.0d || d.doubleValue() > 20.0d) {
            if (d.doubleValue() > 20.0d && d.doubleValue() < 70.0d) {
                asJsonObject = b().getAsJsonObject("constants").getAsJsonObject("direction");
                str = "northeast";
            } else if (d.doubleValue() >= 70.0d && d.doubleValue() <= 110.0d) {
                asJsonObject = b().getAsJsonObject("constants").getAsJsonObject("direction");
                str = "east";
            } else if (d.doubleValue() > 110.0d && d.doubleValue() < 160.0d) {
                asJsonObject = b().getAsJsonObject("constants").getAsJsonObject("direction");
                str = "southeast";
            } else if (d.doubleValue() >= 160.0d && d.doubleValue() <= 200.0d) {
                asJsonObject = b().getAsJsonObject("constants").getAsJsonObject("direction");
                str = "south";
            } else if (d.doubleValue() > 200.0d && d.doubleValue() < 250.0d) {
                asJsonObject = b().getAsJsonObject("constants").getAsJsonObject("direction");
                str = "southwest";
            } else if (d.doubleValue() >= 250.0d && d.doubleValue() <= 290.0d) {
                asJsonObject = b().getAsJsonObject("constants").getAsJsonObject("direction");
                str = "west";
            } else if (d.doubleValue() <= 290.0d || d.doubleValue() >= 340.0d) {
                if (d.doubleValue() < 340.0d || d.doubleValue() > 360.0d) {
                    throw new RuntimeException("Degree is invalid: " + d);
                }
                asJsonPrimitive = b().getAsJsonObject("constants").getAsJsonObject("direction").getAsJsonPrimitive("north");
            } else {
                asJsonObject = b().getAsJsonObject("constants").getAsJsonObject("direction");
                str = "northwest";
            }
            asJsonPrimitive = asJsonObject.getAsJsonPrimitive(str);
        } else {
            asJsonPrimitive = b().getAsJsonObject("constants").getAsJsonObject("direction").getAsJsonPrimitive("north");
        }
        return asJsonPrimitive.getAsString();
    }

    public JsonObject a() {
        return this.a;
    }

    public String a(LegStep legStep) {
        if (legStep.intersections() == null || legStep.intersections().size() == 0 || legStep.intersections().get(0).lanes() == null || legStep.intersections().get(0).lanes().size() == 0) {
            throw new RuntimeException("No lanes object");
        }
        StringBuilder sb = new StringBuilder();
        Boolean boolValid = null;
        for (IntersectionLanes intersectionLanes : legStep.intersections().get(0).lanes()) {
            if (boolValid == null || boolValid != intersectionLanes.valid()) {
                sb.append(intersectionLanes.valid().booleanValue() ? "o" : "x");
                boolValid = intersectionLanes.valid();
            }
        }
        return sb.toString();
    }

    public String a(Integer num) {
        try {
            return b().getAsJsonObject("constants").getAsJsonObject("ordinalize").getAsJsonPrimitive(String.valueOf(num)).getAsString();
        } catch (Exception unused) {
            return "";
        }
    }
}
