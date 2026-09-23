package com.mappls.android.util;

import android.content.Context;
import android.os.Build;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$CellInfoCallback;
import androidx.autofill.HintConstants;
import com.mappls.android.lms.MapplsLMSManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import kotlin.io.path.PathTreeWalk$$ExternalSyntheticApiModelOutline0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class NetworkUtility {
    public static JSONArray getCellInfo(List<CellInfo> list) {
        JSONObject jSONObject;
        StringBuilder sb;
        String string;
        JSONObject jSONObject2;
        JSONArray jSONArray = new JSONArray();
        HashMap map = new HashMap();
        if (list != null) {
            String strValueOf = null;
            String strValueOf2 = null;
            for (CellInfo cellInfo : list) {
                try {
                    int i = Build.VERSION.SDK_INT;
                    if (i < 29 || !PathTreeWalk$$ExternalSyntheticApiModelOutline0.m$1(cellInfo)) {
                        if (cellInfo instanceof CellInfoLte) {
                            CellIdentityLte cellIdentity = ((CellInfoLte) cellInfo).getCellIdentity();
                            jSONObject = new JSONObject();
                            jSONObject.put("cell_id", cellIdentity.getCi());
                            jSONObject.put("lac", cellIdentity.getTac());
                            if (i >= 28) {
                                if (cellIdentity.getMncString() != null) {
                                    strValueOf = cellIdentity.getMncString();
                                }
                                if (cellIdentity.getMccString() != null) {
                                    strValueOf2 = cellIdentity.getMccString();
                                }
                            } else {
                                strValueOf = String.valueOf(cellIdentity.getMnc());
                                strValueOf2 = String.valueOf(cellIdentity.getMcc());
                            }
                            if (strValueOf != null) {
                                jSONObject.put("mnc", strValueOf);
                            }
                            if (strValueOf2 != null) {
                                jSONObject.put("mcc", strValueOf2);
                            }
                            jSONObject.put("cell_type", "LTE");
                            sb = new StringBuilder();
                            sb.append(cellIdentity.getCi());
                            sb.append("_");
                            sb.append(cellIdentity.getTac());
                        } else if (cellInfo instanceof CellInfoWcdma) {
                            CellIdentityWcdma cellIdentity2 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                            jSONObject = new JSONObject();
                            jSONObject.put("cell_id", cellIdentity2.getCid());
                            jSONObject.put("lac", cellIdentity2.getLac());
                            if (i >= 28) {
                                if (cellIdentity2.getMncString() != null) {
                                    strValueOf = cellIdentity2.getMncString();
                                }
                                if (cellIdentity2.getMccString() != null) {
                                    strValueOf2 = cellIdentity2.getMccString();
                                }
                            } else {
                                strValueOf = String.valueOf(cellIdentity2.getMnc());
                                strValueOf2 = String.valueOf(cellIdentity2.getMcc());
                            }
                            if (strValueOf != null) {
                                jSONObject.put("mnc", strValueOf);
                            }
                            if (strValueOf2 != null) {
                                jSONObject.put("mcc", strValueOf2);
                            }
                            jSONObject.put("cell_type", "WCDMA");
                            sb = new StringBuilder();
                            sb.append(cellIdentity2.getCid());
                            sb.append("_");
                            sb.append(cellIdentity2.getLac());
                        } else if (cellInfo instanceof CellInfoGsm) {
                            CellIdentityGsm cellIdentity3 = ((CellInfoGsm) cellInfo).getCellIdentity();
                            jSONObject = new JSONObject();
                            jSONObject.put("cell_id", cellIdentity3.getCid());
                            jSONObject.put("lac", cellIdentity3.getLac());
                            if (i >= 28) {
                                if (cellIdentity3.getMncString() != null) {
                                    strValueOf = cellIdentity3.getMncString();
                                }
                                if (cellIdentity3.getMccString() != null) {
                                    strValueOf2 = cellIdentity3.getMccString();
                                }
                            } else {
                                strValueOf = String.valueOf(cellIdentity3.getMnc());
                                strValueOf2 = String.valueOf(cellIdentity3.getMcc());
                            }
                            if (strValueOf != null) {
                                jSONObject.put("mnc", strValueOf);
                            }
                            if (strValueOf2 != null) {
                                jSONObject.put("mcc", strValueOf2);
                            }
                            jSONObject.put("cell_type", "Gsm");
                            sb = new StringBuilder();
                            sb.append(cellIdentity3.getCid());
                            sb.append("_");
                            sb.append(cellIdentity3.getLac());
                        }
                        string = sb.toString();
                        jSONObject2 = jSONObject;
                    } else {
                        CellIdentityNr cellIdentityNrM = PathTreeWalk$$ExternalSyntheticApiModelOutline0.m((Object) PathTreeWalk$$ExternalSyntheticApiModelOutline0.m3534m((Object) cellInfo).getCellIdentity());
                        jSONObject2 = new JSONObject();
                        jSONObject2.put("cell_id", cellIdentityNrM.getNci());
                        jSONObject2.put("lac", cellIdentityNrM.getTac());
                        if (cellIdentityNrM.getMncString() != null) {
                            strValueOf = cellIdentityNrM.getMncString();
                        }
                        if (cellIdentityNrM.getMccString() != null) {
                            strValueOf2 = cellIdentityNrM.getMccString();
                        }
                        if (strValueOf != null) {
                            jSONObject2.put("mnc", strValueOf);
                        }
                        if (strValueOf2 != null) {
                            jSONObject2.put("mcc", strValueOf2);
                        }
                        jSONObject2.put("cell_type", "NR");
                        string = cellIdentityNrM.getNci() + "_" + cellIdentityNrM.getTac();
                    }
                    map.put(string, jSONObject2);
                } catch (JSONException unused) {
                }
            }
        }
        Iterator it2 = map.values().iterator();
        while (it2.hasNext()) {
            jSONArray.put((JSONObject) it2.next());
        }
        return jSONArray;
    }

    public static void listenCellInfoChange(Context context) {
        int i = Build.VERSION.SDK_INT;
        try {
            if (context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 && context.getPackageManager().hasSystemFeature("android.hardware.telephony")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                if (i >= 29) {
                    telephonyManager.requestCellInfoUpdate(Executors.newSingleThreadExecutor(), new TelephonyManager$CellInfoCallback() { // from class: com.mappls.android.util.NetworkUtility.1
                        public void onCellInfo(List<CellInfo> list) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("cell_info", NetworkUtility.getCellInfo(list));
                                MapplsLMSManager.getInstance().add("cell_info_change", "mappls-lms", "1.0.4", jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                    });
                } else if (context.checkSelfPermission("android.permission.READ_PHONE_STATE") == 0) {
                    telephonyManager.listen(new PhoneStateListener() { // from class: com.mappls.android.util.NetworkUtility.2
                        @Override // android.telephony.PhoneStateListener
                        public void onCellInfoChanged(List<CellInfo> list) {
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.put("cell_info", NetworkUtility.getCellInfo(list));
                                MapplsLMSManager.getInstance().add("cell_info_change", "mappls-lms", "1.0.4", jSONObject);
                            } catch (JSONException unused) {
                            }
                        }
                    }, 1024);
                }
            }
        } catch (Exception e) {
            MPLog.e("NetworkUtility", "listenCellInfoChange Exception", e);
        }
    }
}
