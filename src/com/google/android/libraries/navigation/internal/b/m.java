package com.google.android.libraries.navigation.internal.b;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import com.google.common.net.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.google.maps.android.BuildConfig;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.BlockingQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class m extends Thread {
    public volatile boolean a = false;
    private final BlockingQueue b;
    private final l c;
    private final c d;
    private final aa e;

    public m(BlockingQueue blockingQueue, l lVar, c cVar, aa aaVar) {
        this.b = blockingQueue;
        this.c = lVar;
        this.d = cVar;
        this.e = aaVar;
    }

    /* JADX WARN: Code duplicated, block: B:134:0x02dc A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:144:0x030d A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TRY_ENTER, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:166:0x0361 A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TRY_LEAVE, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:183:0x0387 A[Catch: IOException -> 0x038b, all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TRY_ENTER, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:190:0x0393 A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:191:0x03a0 A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:193:0x03a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:194:0x03a6 A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:196:0x03b9 A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:210:0x03f5 A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:214:0x041d A[Catch: all -> 0x0461, Exception -> 0x0465, ad -> 0x0486, LOOP:0: B:8:0x0032->B:214:0x041d, LOOP_END, TRY_ENTER, TRY_LEAVE, TryCatch #14 {Exception -> 0x0465, blocks: (B:3:0x0011, B:5:0x001c, B:7:0x0027, B:8:0x0032, B:10:0x0037, B:12:0x003b, B:20:0x006b, B:48:0x0149, B:49:0x014c, B:51:0x0154, B:53:0x015d, B:121:0x02bd, B:123:0x02c6, B:124:0x02c8, B:128:0x02ce, B:133:0x02db, B:134:0x02dc, B:136:0x02e9, B:138:0x02ed, B:139:0x02fd, B:140:0x0307, B:144:0x030d, B:146:0x0311, B:149:0x031c, B:150:0x0320, B:154:0x032f, B:156:0x0333, B:157:0x0344, B:158:0x0348, B:160:0x034e, B:165:0x0360, B:166:0x0361, B:171:0x036b, B:54:0x0170, B:56:0x017d, B:57:0x0181, B:59:0x0187, B:60:0x0193, B:62:0x019c, B:64:0x01a2, B:65:0x01a8, B:67:0x01ae, B:69:0x01bc, B:78:0x0200, B:70:0x01c0, B:72:0x01c8, B:73:0x01d2, B:75:0x01d8, B:77:0x01e8, B:79:0x0216, B:83:0x021d, B:90:0x023d, B:93:0x0248, B:105:0x026a, B:119:0x02a7, B:172:0x036c, B:173:0x0371, B:111:0x027d, B:113:0x0285, B:115:0x028d, B:188:0x038f, B:190:0x0393, B:211:0x0401, B:212:0x0407, B:214:0x041d, B:216:0x0432, B:219:0x0435, B:220:0x0448, B:191:0x03a0, B:194:0x03a6, B:196:0x03b9, B:205:0x03dc, B:206:0x03e1, B:207:0x03e2, B:208:0x03e7, B:209:0x03e8, B:210:0x03f5, B:221:0x0449, B:222:0x044e, B:223:0x044f, B:224:0x0460, B:92:0x0241, B:99:0x0256, B:102:0x0261, B:103:0x0267, B:101:0x025a, B:104:0x0268, B:183:0x0387, B:184:0x038a, B:13:0x0040, B:15:0x0049, B:16:0x004e, B:18:0x0056), top: B:243:0x0011, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:247:0x0308 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:271:0x044f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:272:0x0449 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:274:0x0432 A[SYNTHETIC] */
    private void a() throws Throwable {
        int i;
        Throwable th;
        IOException iOException;
        com.google.android.libraries.navigation.internal.c.j jVar;
        byte[] bArr;
        int i2;
        com.google.android.libraries.navigation.internal.c.n nVar;
        o oVar;
        g gVar;
        int iA;
        ad adVar;
        int i3;
        Map mapEmptyMap;
        Throwable th2;
        com.google.android.libraries.navigation.internal.c.j jVar2;
        o oVar2;
        z zVarB;
        s sVar;
        b bVar;
        List list;
        boolean z;
        byte[] bArr2;
        Throwable th3;
        byte[] bArrB;
        t tVar = (t) this.b.take();
        SystemClock.elapsedRealtime();
        tVar.l(3);
        try {
            try {
                try {
                    tVar.f("network-queue-take");
                    if (tVar.n()) {
                        tVar.i("network-discard-cancelled");
                        tVar.k();
                    } else {
                        TrafficStats.setThreadStatsTag(tVar.d);
                        l lVar = this.c;
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        while (true) {
                            Collections.emptyList();
                            try {
                                b bVar2 = tVar.k;
                                if (bVar2 == null) {
                                    mapEmptyMap = Collections.emptyMap();
                                } else {
                                    HashMap map = new HashMap();
                                    String str = bVar2.b;
                                    if (str != null) {
                                        map.put(HttpHeaders.IF_NONE_MATCH, str);
                                    }
                                    long j = bVar2.d;
                                    if (j > 0) {
                                        map.put(HttpHeaders.IF_MODIFIED_SINCE, com.google.android.libraries.navigation.internal.c.i.c("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j)));
                                    }
                                    mapEmptyMap = map;
                                }
                                com.google.android.libraries.navigation.internal.c.a aVar = ((com.google.android.libraries.navigation.internal.c.b) lVar).a;
                                String str2 = tVar.c;
                                HashMap map2 = new HashMap();
                                map2.putAll(mapEmptyMap);
                                map2.putAll(tVar.e());
                                URL url = new URL(str2);
                                HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                                httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
                                int iA2 = tVar.a();
                                httpURLConnection.setConnectTimeout(iA2);
                                httpURLConnection.setReadTimeout(iA2);
                                boolean z2 = false;
                                httpURLConnection.setUseCaches(false);
                                httpURLConnection.setDoInput(true);
                                url.getProtocol();
                                try {
                                    for (String str3 : map2.keySet()) {
                                        httpURLConnection.setRequestProperty(str3, (String) map2.get(str3));
                                    }
                                    if (tVar.b != 0) {
                                        httpURLConnection.setRequestMethod("POST");
                                        byte[] bArrO = tVar.o();
                                        if (bArrO != null) {
                                            httpURLConnection.setDoOutput(true);
                                            if (!httpURLConnection.getRequestProperties().containsKey("Content-Type")) {
                                                httpURLConnection.setRequestProperty("Content-Type", tVar.c());
                                            }
                                            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                                            dataOutputStream.write(bArrO);
                                            dataOutputStream.close();
                                        }
                                    } else {
                                        httpURLConnection.setRequestMethod("GET");
                                    }
                                    int responseCode = httpURLConnection.getResponseCode();
                                    if (responseCode == -1) {
                                        throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                                    }
                                    int i4 = tVar.b;
                                    if ((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) {
                                        jVar2 = new com.google.android.libraries.navigation.internal.c.j(responseCode, com.google.android.libraries.navigation.internal.c.l.a(httpURLConnection.getHeaderFields()), -1, null);
                                        httpURLConnection.disconnect();
                                    } else {
                                        try {
                                            jVar2 = new com.google.android.libraries.navigation.internal.c.j(responseCode, com.google.android.libraries.navigation.internal.c.l.a(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new com.google.android.libraries.navigation.internal.c.k(httpURLConnection));
                                        } catch (Throwable th4) {
                                            th2 = th4;
                                            z2 = true;
                                            if (!z2) {
                                                httpURLConnection.disconnect();
                                            }
                                            throw th2;
                                        }
                                    }
                                    try {
                                        int i5 = jVar2.a;
                                        List listA = jVar2.a();
                                        if (i5 == 304) {
                                            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            b bVar3 = tVar.k;
                                            if (bVar3 != null) {
                                                TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                                                if (!listA.isEmpty()) {
                                                    Iterator it2 = listA.iterator();
                                                    while (it2.hasNext()) {
                                                        treeSet.add(((k) it2.next()).a);
                                                    }
                                                }
                                                ArrayList arrayList = new ArrayList(listA);
                                                List list2 = bVar3.h;
                                                if (list2 != null) {
                                                    if (!list2.isEmpty()) {
                                                        for (k kVar : bVar3.h) {
                                                            if (!treeSet.contains(kVar.a)) {
                                                                arrayList.add(kVar);
                                                            }
                                                        }
                                                    }
                                                } else if (!bVar3.g.isEmpty()) {
                                                    for (Map.Entry entry : bVar3.g.entrySet()) {
                                                        if (!treeSet.contains(entry.getKey())) {
                                                            arrayList.add(new k((String) entry.getKey(), (String) entry.getValue()));
                                                        }
                                                    }
                                                }
                                                oVar2 = new o(304, bVar3.a, true, jElapsedRealtime2, (List) arrayList);
                                                break;
                                            }
                                            oVar2 = new o(304, (byte[]) null, true, jElapsedRealtime2, listA);
                                            break;
                                        }
                                        InputStream inputStream = jVar2.c;
                                        if (inputStream == null) {
                                            inputStream = null;
                                        }
                                        if (inputStream != null) {
                                            int i6 = jVar2.b;
                                            com.google.android.libraries.navigation.internal.c.d dVar = ((com.google.android.libraries.navigation.internal.c.b) lVar).b;
                                            com.google.android.libraries.navigation.internal.c.o oVar3 = new com.google.android.libraries.navigation.internal.c.o(dVar, i6);
                                            try {
                                                bArrB = dVar.b(1024);
                                                while (true) {
                                                    try {
                                                        int i7 = inputStream.read(bArrB);
                                                        if (i7 == -1) {
                                                            break;
                                                        } else {
                                                            oVar3.write(bArrB, 0, i7);
                                                        }
                                                    } catch (Throwable th5) {
                                                        th3 = th5;
                                                        try {
                                                            inputStream.close();
                                                        } catch (IOException unused) {
                                                            ag.a("Error occurred when closing InputStream", new Object[0]);
                                                        }
                                                        dVar.a(bArrB);
                                                        oVar3.close();
                                                        throw th3;
                                                    }
                                                }
                                                byte[] byteArray = oVar3.toByteArray();
                                                try {
                                                    inputStream.close();
                                                } catch (IOException unused2) {
                                                    ag.a("Error occurred when closing InputStream", new Object[0]);
                                                }
                                                dVar.a(bArrB);
                                                oVar3.close();
                                                bArr2 = byteArray;
                                            } catch (Throwable th6) {
                                                th3 = th6;
                                                bArrB = null;
                                            }
                                        } else {
                                            bArr2 = new byte[0];
                                        }
                                        try {
                                            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                                            if (ag.b || jElapsedRealtime3 > 3000) {
                                                ag.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", tVar, Long.valueOf(jElapsedRealtime3), bArr2 != null ? Integer.valueOf(bArr2.length) : BuildConfig.TRAVIS, Integer.valueOf(i5), Integer.valueOf(tVar.m.b));
                                            }
                                            if (i5 >= 200 && i5 <= 299) {
                                                oVar2 = new o(i5, bArr2, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listA);
                                                break;
                                            }
                                            throw new IOException();
                                        } catch (IOException e) {
                                            iOException = e;
                                            bArr = bArr2;
                                            jVar = jVar2;
                                            if (iOException instanceof SocketTimeoutException) {
                                                nVar = new com.google.android.libraries.navigation.internal.c.n("socket", new ac());
                                            } else {
                                                if (!(iOException instanceof MalformedURLException)) {
                                                    throw new RuntimeException("Bad URL ".concat(String.valueOf(tVar.c)), iOException);
                                                }
                                                if (jVar != null) {
                                                    throw new p(iOException);
                                                }
                                                i2 = jVar.a;
                                                ag.b("Unexpected response code %d for %s", Integer.valueOf(i2), tVar.c);
                                                if (bArr != null) {
                                                    oVar = new o(i2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, jVar.a());
                                                    if (i2 != 401) {
                                                        if (i2 < 400) {
                                                        }
                                                        throw new ab(oVar);
                                                    }
                                                    nVar = new com.google.android.libraries.navigation.internal.c.n(com.spotify.sdk.android.auth.BuildConfig.FLAVOR, new a(oVar));
                                                } else {
                                                    nVar = new com.google.android.libraries.navigation.internal.c.n("network", new n());
                                                }
                                            }
                                            gVar = tVar.m;
                                            iA = tVar.a();
                                            try {
                                                adVar = nVar.b;
                                                i3 = gVar.b + 1;
                                                gVar.b = i3;
                                                int i8 = gVar.a;
                                                gVar.a = i8 + ((int) (i8 * gVar.d));
                                                if (i3 <= gVar.c) {
                                                    throw adVar;
                                                }
                                                tVar.f(String.format("%s-retry [timeout=%s]", nVar.a, Integer.valueOf(iA)));
                                            } catch (ad e2) {
                                                tVar.f(String.format("%s-timeout-giveup [timeout=%s]", nVar.a, Integer.valueOf(iA)));
                                                throw e2;
                                            }
                                        }
                                    } catch (IOException e3) {
                                        iOException = e3;
                                        jVar = jVar2;
                                        bArr = null;
                                        if (iOException instanceof SocketTimeoutException) {
                                            nVar = new com.google.android.libraries.navigation.internal.c.n("socket", new ac());
                                        } else {
                                            if (!(iOException instanceof MalformedURLException)) {
                                                throw new RuntimeException("Bad URL ".concat(String.valueOf(tVar.c)), iOException);
                                            }
                                            if (jVar != null) {
                                                throw new p(iOException);
                                            }
                                            i2 = jVar.a;
                                            ag.b("Unexpected response code %d for %s", Integer.valueOf(i2), tVar.c);
                                            if (bArr != null) {
                                                oVar = new o(i2, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, jVar.a());
                                                if (i2 != 401 && i2 != 403) {
                                                    if (i2 < 400 && i2 <= 499) {
                                                        throw new f(oVar);
                                                    }
                                                    throw new ab(oVar);
                                                }
                                                nVar = new com.google.android.libraries.navigation.internal.c.n(com.spotify.sdk.android.auth.BuildConfig.FLAVOR, new a(oVar));
                                            } else {
                                                nVar = new com.google.android.libraries.navigation.internal.c.n("network", new n());
                                            }
                                        }
                                        gVar = tVar.m;
                                        iA = tVar.a();
                                        adVar = nVar.b;
                                        i3 = gVar.b + 1;
                                        gVar.b = i3;
                                        int i9 = gVar.a;
                                        gVar.a = i9 + ((int) (i9 * gVar.d));
                                        if (i3 <= gVar.c) {
                                            throw adVar;
                                        }
                                        tVar.f(String.format("%s-retry [timeout=%s]", nVar.a, Integer.valueOf(iA)));
                                    }
                                } catch (Throwable th7) {
                                    th2 = th7;
                                }
                                if (!z2) {
                                    httpURLConnection.disconnect();
                                }
                                throw th2;
                            } catch (IOException e4) {
                                iOException = e4;
                                jVar = null;
                            }
                            tVar.f(String.format("%s-retry [timeout=%s]", nVar.a, Integer.valueOf(iA)));
                        }
                        tVar.f("network-http-complete");
                        if (oVar2.e) {
                            synchronized (tVar.e) {
                                z = tVar.j;
                            }
                            if (z) {
                                tVar.i("not-modified");
                                tVar.k();
                            } else {
                                zVarB = tVar.b(oVar2);
                                tVar.f("network-parse-complete");
                                if (tVar.i && zVarB.b != null) {
                                    this.d.c(tVar.d(), zVarB.b);
                                    tVar.f("network-cache-written");
                                }
                                tVar.j();
                                this.e.b(tVar, zVarB);
                                synchronized (tVar.e) {
                                    sVar = tVar.l;
                                }
                                if (sVar != null) {
                                    bVar = zVarB.b;
                                    if (bVar != null || bVar.a(System.currentTimeMillis())) {
                                        ((ah) sVar).a(tVar);
                                    } else {
                                        String strD = tVar.d();
                                        synchronized (sVar) {
                                            list = (List) ((ah) sVar).a.remove(strD);
                                        }
                                        if (list != null) {
                                            if (ag.b) {
                                                ag.a("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), strD);
                                            }
                                            Iterator it3 = list.iterator();
                                            while (it3.hasNext()) {
                                                ((ah) sVar).b.b((t) it3.next(), zVarB);
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            zVarB = tVar.b(oVar2);
                            tVar.f("network-parse-complete");
                            if (tVar.i) {
                                this.d.c(tVar.d(), zVarB.b);
                                tVar.f("network-cache-written");
                            }
                            tVar.j();
                            this.e.b(tVar, zVarB);
                            synchronized (tVar.e) {
                                sVar = tVar.l;
                                if (sVar != null) {
                                    bVar = zVarB.b;
                                    if (bVar != null) {
                                        ((ah) sVar).a(tVar);
                                    } else {
                                        ((ah) sVar).a(tVar);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th8) {
                    th = th8;
                    i = 4;
                    tVar.l(i);
                    throw th;
                }
            } catch (ad e5) {
                try {
                    SystemClock.elapsedRealtime();
                    this.e.a(tVar, e5);
                    tVar.k();
                } catch (Throwable th9) {
                    i = 4;
                    th = th9;
                    tVar.l(i);
                    throw th;
                }
            }
        } catch (Exception e6) {
            ag.b("Unhandled exception %s", e6.toString());
            ad adVar2 = new ad(e6);
            SystemClock.elapsedRealtime();
            this.e.a(tVar, adVar2);
            tVar.k();
        }
        tVar.l(4);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        Process.setThreadPriority(10);
        while (true) {
            try {
                a();
            } catch (InterruptedException unused) {
                if (this.a) {
                    Thread.currentThread().interrupt();
                    return;
                }
                ag.b("Ignoring spurious interrupt of NetworkDispatcher thread; use quit() to terminate it", new Object[0]);
            }
        }
    }
}
