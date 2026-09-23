package com.google.android.libraries.navigation.internal.ael;

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

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class da {
    public static final /* synthetic */ int a = 0;
    private static final char[] b;

    static {
        char[] cArr = new char[80];
        b = cArr;
        Arrays.fill(cArr, ' ');
    }

    static void a(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                a(sb, i, str, it2.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it3 = ((Map) obj).entrySet().iterator();
            while (it3.hasNext()) {
                a(sb, i, str, (Map.Entry) it3.next());
            }
            return;
        }
        sb.append('\n');
        c(i, sb);
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
            sb.append(eb.a(x.v((String) obj)));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof x) {
            sb.append(": \"");
            sb.append(eb.a((x) obj));
            sb.append(Typography.quote);
            return;
        }
        if (obj instanceof bi) {
            sb.append(" {");
            b((bi) obj, sb, i + 2);
            sb.append("\n");
            c(i, sb);
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
        a(sb, i3, "key", entry.getKey());
        a(sb, i3, "value", entry.getValue());
        sb.append("\n");
        c(i, sb);
        sb.append("}");
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0203  */
    public static void b(cy cyVar, StringBuilder sb, int i) {
        int i2;
        boolean zEquals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap map = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = cyVar.getClass().getDeclaredMethods();
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
                a(sb, i, strSubstring.substring(0, strSubstring.length() - 4), bi.C(method2, cyVar, new Object[0]));
            } else if (strSubstring.endsWith("Map") && !strSubstring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                a(sb, i, strSubstring.substring(0, strSubstring.length() - 3), bi.C(method, cyVar, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(strSubstring))) && (!strSubstring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(strSubstring.substring(0, strSubstring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) map.get("has".concat(String.valueOf(strSubstring)));
                if (method4 != null) {
                    Object objC = bi.C(method4, cyVar, new Object[0]);
                    if (method5 == null) {
                        if (objC instanceof Boolean) {
                            if (((Boolean) objC).booleanValue()) {
                                a(sb, i, strSubstring, objC);
                            }
                        } else if (objC instanceof Integer) {
                            if (((Integer) objC).intValue() != 0) {
                                a(sb, i, strSubstring, objC);
                            }
                        } else if (objC instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) objC).floatValue()) != 0) {
                                a(sb, i, strSubstring, objC);
                            }
                        } else if (!(objC instanceof Double)) {
                            if (objC instanceof String) {
                                zEquals = objC.equals("");
                            } else if (objC instanceof x) {
                                zEquals = objC.equals(x.b);
                            } else if (objC instanceof cy) {
                                if (objC != ((cy) objC).al()) {
                                    a(sb, i, strSubstring, objC);
                                }
                            } else if (!(objC instanceof Enum) || ((Enum) objC).ordinal() != 0) {
                                a(sb, i, strSubstring, objC);
                            }
                            if (!zEquals) {
                                a(sb, i, strSubstring, objC);
                            }
                        } else if (Double.doubleToRawLongBits(((Double) objC).doubleValue()) != 0) {
                            a(sb, i, strSubstring, objC);
                        }
                    } else if (((Boolean) bi.C(method5, cyVar, new Object[0])).booleanValue()) {
                        a(sb, i, strSubstring, objC);
                    }
                }
            }
            i2 = 3;
        }
        if (cyVar instanceof be) {
            Iterator itD = ((be) cyVar).w.d();
            while (itD.hasNext()) {
                Map.Entry entry2 = (Map.Entry) itD.next();
                a(sb, i, "[" + ((bg) entry2.getKey()).b + "]", entry2.getValue());
            }
        }
        eg egVar = ((bi) cyVar).an;
        if (egVar != null) {
            for (int i4 = 0; i4 < egVar.b; i4++) {
                a(sb, i, String.valueOf(eu.a(egVar.c[i4])), egVar.d[i4]);
            }
        }
    }

    private static void c(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(b, 0, i2);
            i -= i2;
        }
    }
}
