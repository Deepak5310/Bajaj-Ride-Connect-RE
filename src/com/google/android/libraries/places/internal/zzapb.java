package com.google.android.libraries.places.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzapb {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzaoz zzaozVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzaozVar, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                zzb(sb, i, str, it2.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it3 = ((Map) obj).entrySet().iterator();
            while (it3.hasNext()) {
                zzb(sb, i, str, (Map.Entry) it3.next());
            }
            return;
        }
        sb.append('\n');
        zzc(i, sb);
        if (!str.isEmpty()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Character.toLowerCase(str.charAt(0)));
            for (int i2 = 1; i2 < str.length(); i2++) {
                char cCharAt = str.charAt(i2);
                if (Character.isUpperCase(cCharAt)) {
                    sb2.append("_");
                }
                sb2.append(Character.toLowerCase(cCharAt));
            }
            str = sb2.toString();
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(zzaqb.zza(new zzami(((String) obj).getBytes(zzaoa.zzb))));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzaml) {
            sb.append(": \"");
            sb.append(zzaqb.zza((zzaml) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof zzanr) {
            sb.append(" {");
            zzd((zzanr) obj, sb, i + 2);
            sb.append("\n");
            zzc(i, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        int i3 = i + 2;
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        zzb(sb, i3, "key", entry.getKey());
        zzb(sb, i3, "value", entry.getValue());
        sb.append("\n");
        zzc(i, sb);
        sb.append("}");
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0203  */
    private static void zzd(zzaoz zzaozVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzaozVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i3 = 0;
        while (true) {
            i2 = 3;
            if (i3 >= length) {
                break;
            }
            Method method3 = declaredMethods[i3];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        map.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i3++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String strSubstring = ((String) entry.getKey()).substring(i2);
            if (strSubstring.endsWith("List") && !strSubstring.endsWith("OrBuilderList") && !strSubstring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 4), zzanr.zzaw(method2, zzaozVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i, strSubstring.substring(0, strSubstring.length() - 3), zzanr.zzaw(method, zzaozVar, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(strSubstring))) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                if (method4 != null) {
                    Object objZzaw = zzanr.zzaw(method4, zzaozVar, new Object[0]);
                    if (method5 == null) {
                        if (objZzaw instanceof Boolean) {
                            if (((Boolean) objZzaw).booleanValue()) {
                                zzb(sb, i, strSubstring, objZzaw);
                            }
                        } else if (objZzaw instanceof Integer) {
                            if (((Integer) objZzaw).intValue() != 0) {
                                zzb(sb, i, strSubstring, objZzaw);
                            }
                        } else if (objZzaw instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objZzaw).floatValue()) != 0) {
                                zzb(sb, i, strSubstring, objZzaw);
                            }
                        } else if (!(objZzaw instanceof Double)) {
                            if (objZzaw instanceof String) {
                                zEquals = objZzaw.equals("");
                            } else if (objZzaw instanceof zzaml) {
                                zEquals = objZzaw.equals(zzaml.zzb);
                            } else if (objZzaw instanceof zzaoz) {
                                if (objZzaw != ((zzaoz) objZzaw).zzaE()) {
                                    zzb(sb, i, strSubstring, objZzaw);
                                }
                            } else if (!(objZzaw instanceof Enum) || ((Enum) objZzaw).ordinal() != 0) {
                                zzb(sb, i, strSubstring, objZzaw);
                            }
                            if (!zEquals) {
                                zzb(sb, i, strSubstring, objZzaw);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objZzaw).doubleValue()) != 0) {
                            zzb(sb, i, strSubstring, objZzaw);
                        }
                    } else if (((Boolean) zzanr.zzaw(method5, zzaozVar, new Object[0])).booleanValue()) {
                        zzb(sb, i, strSubstring, objZzaw);
                    }
                }
            }
            i2 = 3;
        }
        if (zzaozVar instanceof zzano) {
            zzani zzaniVar = ((zzano) zzaozVar).zzb;
            throw null;
        }
        zzaqh zzaqhVar = ((zzanr) zzaozVar).zzc;
        if (zzaqhVar != null) {
            zzaqhVar.zzi(sb, i);
        }
    }
}
