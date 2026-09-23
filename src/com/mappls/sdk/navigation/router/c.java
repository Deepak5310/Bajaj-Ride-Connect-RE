package com.mappls.sdk.navigation.router;

import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.h;
import com.mappls.sdk.navigation.n;

/* JADX INFO: loaded from: classes4.dex */
public final class c {
    private final int a;
    private int b;
    private float c;
    private int[] d;

    private c(int i) {
        this.a = i;
    }

    public static c a(int i, float f, boolean z) {
        c cVarA = a(68, z);
        cVarA.b = i;
        cVarA.c = f;
        return cVarA;
    }

    public static c a(int i, boolean z) {
        if (i == 6 && z) {
            i = 41;
        } else if (i == 68 && z) {
            i = 69;
        }
        return new c(i);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    public static c a(String str, boolean z) {
        c cVarA;
        int i;
        if ("CONTINUE".equalsIgnoreCase(str)) {
            i = 7;
        } else if ("TURN_LEFT".equalsIgnoreCase(str)) {
            i = 0;
        } else if ("TURN_SLIGHTLY_LEFT".equalsIgnoreCase(str)) {
            i = 2;
        } else if ("TURN_SHARPLY_LEFT".equalsIgnoreCase(str)) {
            i = 1;
        } else if ("TURN_RIGHT".equalsIgnoreCase(str)) {
            i = 3;
        } else {
            if (!"TURN_SLIGHTLY_RIGHT".equalsIgnoreCase(str)) {
                if ("TURN_SHARPLY_RIGHT".equalsIgnoreCase(str)) {
                    cVarA = a(4, z);
                } else if ("KEEP_LEFT".equalsIgnoreCase(str)) {
                    i = 9;
                } else if ("KEEP_RIGHT".equalsIgnoreCase(str)) {
                    i = 10;
                } else if ("U_TURN".equalsIgnoreCase(str)) {
                    i = 6;
                } else if ("RIGHT_U_TURN".equalsIgnoreCase(str)) {
                    i = 41;
                } else if ("OFF_ROUTE".equalsIgnoreCase(str)) {
                    i = 12;
                } else if (str == null || !(str.toUpperCase().startsWith("EXIT") || str.toUpperCase().startsWith("ROUNDABOUT") || str.toUpperCase().startsWith("ROUNDABOUT_LEFT"))) {
                    cVarA = null;
                } else {
                    try {
                        cVarA = a(Integer.parseInt(str.substring(4)), 0.0f, z);
                    } catch (NumberFormatException e) {
                        NavigationLogger.d(e);
                        cVarA = null;
                    }
                }
                if (cVarA == null) {
                    return h();
                }
                return cVarA;
            }
            i = 5;
        }
        cVarA = a(i, z);
        if (cVarA == null) {
            return h();
        }
        return cVarA;
    }

    public static c h() {
        return a(7, false);
    }

    public final int a() {
        return this.b;
    }

    public final void a(float f) {
        this.c = f;
    }

    public final void a(int[] iArr) {
        this.d = iArr;
    }

    public final float b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final boolean d() {
        return this.a == 7;
    }

    public final boolean e() {
        int i = this.a;
        return i == 68 || i == 69;
    }

    public final boolean f() {
        return this.a == 9;
    }

    public final boolean g() {
        return this.a == 10;
    }

    public final String i() {
        int i = this.a;
        if (i == 9) {
            return "KEEP_LEFT";
        }
        if (i == 10) {
            return "KEEP_RIGHT";
        }
        if (i == 12) {
            return "OFF_ROUTE";
        }
        if (i == 41) {
            return "RIGHT_U_TURN";
        }
        if (i == 68) {
            StringBuilder sbA = h.a("ROUNDABOUT");
            sbA.append(this.b);
            return sbA.toString();
        }
        if (i == 69) {
            StringBuilder sbA2 = h.a("ROUNDABOUT_LEFT");
            sbA2.append(this.b);
            return sbA2.toString();
        }
        switch (i) {
            case 0:
                return "TURN_LEFT";
            case 1:
                return "TURN_SHARPLY_LEFT";
            case 2:
                return "TURN_SLIGHTLY_LEFT";
            case 3:
                return "TURN_RIGHT";
            case 4:
                return "TURN_SHARPLY_RIGHT";
            case 5:
                return "TURN_SLIGHTLY_RIGHT";
            case 6:
                return "U_TURN";
            default:
                return "CONTINUE";
        }
    }

    public final String toString() {
        String string;
        if (e()) {
            StringBuilder sbA = h.a("Take ");
            sbA.append(this.b);
            sbA.append(" exit");
            string = sbA.toString();
        } else {
            int i = this.a;
            if (i == 7) {
                string = "Go ahead";
            } else if (i == 2) {
                string = "Turn slightly left";
            } else if (i == 0) {
                string = "Turn left";
            } else if (i == 1) {
                string = "Turn sharply left";
            } else if (i == 5) {
                string = "Turn slightly right";
            } else if (i == 3) {
                string = "Turn right";
            } else if (i == 4) {
                string = "Turn sharply right";
            } else if (i == 6 || i == 41) {
                string = "Make uturn";
            } else if (i == 9) {
                string = "Keep left";
            } else if (i == 10) {
                string = "Keep right";
            } else {
                string = i == 12 ? "Off route" : null;
            }
        }
        if (string == null) {
            return super.toString();
        }
        if (this.d == null) {
            return string;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("(");
        int[] iArr = this.d;
        String string2 = "";
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 > 0) {
                string2 = n.a(string2, "|");
            }
            if (iArr[i2] % 2 == 1) {
                string2 = n.a(string2, "+");
            }
            int i3 = (iArr[i2] >> 1) & 15;
            if (i3 == 0) {
                i3 = 1;
            }
            StringBuilder sbA2 = h.a(string2);
            sbA2.append(a(i3, false).i());
            string2 = sbA2.toString();
            int i4 = (iArr[i2] >> 5) & 31;
            if (i4 != 0) {
                string2 = string2 + "," + a(i4, false).i();
            }
            int i5 = iArr[i2] >> 10;
            if (i5 != 0) {
                string2 = string2 + "," + a(i5, false).i();
            }
        }
        sb.append(string2 + "");
        sb.append(")");
        return sb.toString();
    }
}
