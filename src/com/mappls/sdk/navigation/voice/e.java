package com.mappls.sdk.navigation.voice;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.speech.tts.TextToSpeech;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import androidx.core.app.ActivityCompat;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.navigation.NavigationContext;
import com.mappls.sdk.navigation.R;
import com.mappls.sdk.navigation.apis.NavigationLogger;
import com.mappls.sdk.navigation.routing.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
import timber.log.Timber;

/* JADX INFO: loaded from: classes4.dex */
public final class e extends com.mappls.sdk.navigation.voice.a {
    private static TextToSpeech j = null;
    private static String k = "";
    private static int l;
    private Context e;
    private HashMap<String, String> f;
    private h g;
    private float h;
    private boolean i;

    final class a implements TextToSpeech.OnInitListener {
        final /* synthetic */ Locale a;
        final /* synthetic */ float b;

        a(Locale locale, Context context, float f) {
            this.a = locale;
            this.b = f;
        }

        private static void a() {
            try {
                if (e.j == null || e.j.getVoice() == null) {
                    return;
                }
                e.j.getVoice().toString();
            } catch (RuntimeException e) {
                NavigationLogger.d(e);
            }
        }

        /* JADX WARN: Code duplicated, block: B:33:0x009e  */
        /* JADX WARN: Code duplicated, block: B:36:0x00b1  */
        /* JADX WARN: Code duplicated, block: B:37:0x00c2  */
        @Override // android.speech.tts.TextToSpeech.OnInitListener
        public final void onInit(int i) {
            StringBuilder sb;
            String str;
            String string;
            String str2;
            if (i != 0) {
                e.k = "NO INIT SUCCESS";
                e.a(e.this);
                return;
            }
            if (e.j != null) {
                e.this.i = true;
                int iIsLanguageAvailable = e.j.isLanguageAvailable(this.a);
                if (iIsLanguageAvailable == -2) {
                    sb = new StringBuilder();
                    sb.append(this.a.getDisplayName());
                    str = ": LANG_NOT_SUPPORTED";
                } else {
                    if (iIsLanguageAvailable != -1) {
                        try {
                            if (iIsLanguageAvailable != 0) {
                                if (iIsLanguageAvailable != 1) {
                                    if (iIsLanguageAvailable != 2) {
                                        return;
                                    }
                                }
                                e.j.setLanguage(this.a);
                                if (this.b != 1.0f) {
                                    e.j.setSpeechRate(this.b);
                                }
                                if ("".equals(e.k)) {
                                    sb = new StringBuilder();
                                    sb.append(this.a.getDisplayName());
                                    str = ": LANG_COUNTRY_VAR_AVAILABLE";
                                } else {
                                    string = e.k;
                                }
                                e.k = string;
                                a();
                            }
                            e.k = this.a.getDisplayName() + ": LANG_AVAILABLE";
                            e.j.setLanguage(this.a);
                        } catch (Exception e) {
                            NavigationLogger.d(e);
                            try {
                                e.j.setLanguage(Locale.getDefault());
                            } catch (Exception e2) {
                                NavigationLogger.e(e2);
                            }
                        }
                        if ("".equals(e.k)) {
                            str2 = this.a.getDisplayName() + ": LANG_COUNTRY_AVAILABLE";
                        } else {
                            str2 = e.k;
                        }
                        e.k = str2;
                        if (this.b != 1.0f) {
                            e.j.setSpeechRate(this.b);
                        }
                        if ("".equals(e.k)) {
                            sb = new StringBuilder();
                            sb.append(this.a.getDisplayName());
                            str = ": LANG_COUNTRY_VAR_AVAILABLE";
                        } else {
                            string = e.k;
                        }
                        e.k = string;
                        a();
                    }
                    sb = new StringBuilder();
                    sb.append(this.a.getDisplayName());
                    str = ": LANG_MISSING_DATA";
                }
                sb.append(str);
                string = sb.toString();
                e.k = string;
                a();
            }
        }
    }

    final class b implements TextToSpeech.OnUtteranceCompletedListener {
        b() {
        }

        @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
        public final synchronized void onUtteranceCompleted(String str) {
            if (e.g() <= 0) {
                e.this.a();
            }
            StringBuilder sbA = com.mappls.sdk.navigation.h.a("ttsRequests=");
            sbA.append(e.l);
            NavigationLogger.d(sbA.toString(), new Object[0]);
            if (e.l < 0) {
                e.l = 0;
            }
        }
    }

    public e(Context context, h hVar, String str) throws d {
        super(context, str);
        this.f = new HashMap<>();
        this.h = 1.0f;
        this.i = false;
        this.g = hVar;
        if (com.mappls.sdk.navigation.util.a.a("en")) {
            throw new d(context.getString(R.string.mappls_voice_data_corrupted));
        }
        if (NavigationContext.getNavigationContext().a()) {
            this.h = ((Float) NavigationContext.getNavigationContext().k().j.get()).floatValue();
        }
        if (PreferenceManager.getDefaultSharedPreferences(context).getBoolean("bluetooth_phone_call_switch_preference", false) && i()) {
            NavigationContext.getNavigationContext().k().l0.a(com.mappls.sdk.navigation.d.i, (Integer) 0);
        } else {
            NavigationContext.getNavigationContext().k().l0.a(com.mappls.sdk.navigation.d.i, (Integer) 3);
        }
        a(context, context);
        this.f.put("streamType", ((Integer) NavigationContext.getNavigationContext().k().l0.a(com.mappls.sdk.navigation.d.i)).toString());
    }

    static void a(e eVar) {
        eVar.getClass();
        l = 0;
        eVar.i = false;
        TextToSpeech textToSpeech = j;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            j = null;
        }
        eVar.a();
        eVar.e = null;
        k = "";
    }

    static /* synthetic */ int g() {
        int i = l - 1;
        l = i;
        return i;
    }

    public static boolean i() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled() && defaultAdapter.getProfileConnectionState(1) == 2;
    }

    public final synchronized void a(com.mappls.sdk.navigation.voice.b bVar) {
        if (MapplsNavigationHelper.getInstance().getVoiceCommandListener() != null) {
            ArrayList arrayListA = bVar.a();
            StringBuilder sb = new StringBuilder();
            Iterator it2 = arrayListA.iterator();
            while (it2.hasNext()) {
                sb.append((String) it2.next());
                sb.append(' ');
            }
            MapplsNavigationHelper.getInstance().getVoiceCommandListener().speak(sb.toString());
        }
        if (this.e != null && ((Boolean) NavigationContext.getNavigationContext().k().q0.get()).booleanValue()) {
            a(bVar, false);
        }
    }

    public final void h() {
        if (this.a != null && NavigationContext.getNavigationContext().k() != null) {
            NavigationContext.getNavigationContext().k().I0.a(this);
        }
        a();
        this.a = null;
        l = 0;
        this.i = false;
        TextToSpeech textToSpeech = j;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            j = null;
        }
        a();
        this.e = null;
        k = "";
    }

    public final void j() {
        l = 0;
        TextToSpeech textToSpeech = j;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        a();
    }

    private void a(Context context, Context context2) {
        if (this.e != context) {
            l = 0;
            this.i = false;
            TextToSpeech textToSpeech = j;
            if (textToSpeech != null) {
                textToSpeech.shutdown();
                j = null;
            }
            a();
            this.e = null;
            k = "";
        }
        if (j == null) {
            this.e = context;
            k = "";
            l = 0;
            TextToSpeech textToSpeech2 = new TextToSpeech(context, new a(new Locale("en", "IN"), context2, this.h));
            j = textToSpeech2;
            textToSpeech2.setOnUtteranceCompletedListener(new b());
        }
    }

    public final void a(com.mappls.sdk.navigation.voice.b bVar, boolean z) {
        if (this.e != null) {
            if (!MapplsNavigationHelper.getInstance().isPlayDuringPhoneCallEnabled()) {
                TelephonyManager telephonyManager = (TelephonyManager) this.e.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                if (Build.VERSION.SDK_INT < 31) {
                    if (telephonyManager != null && telephonyManager.getCallState() != 0) {
                        return;
                    }
                } else if (ActivityCompat.checkSelfPermission(this.e, "android.permission.READ_PHONE_STATE") == 0 && telephonyManager != null && telephonyManager.getCallStateForSubscription() != 0) {
                    return;
                }
            }
            try {
                this.g.getClass();
                if (h.e() || ((Boolean) NavigationContext.getNavigationContext().k().p0.get()).booleanValue()) {
                    return;
                }
            } catch (Exception e) {
                Timber.d(e);
            }
            ArrayList arrayListA = bVar.a();
            StringBuilder sb = new StringBuilder();
            Iterator it2 = arrayListA.iterator();
            while (it2.hasNext()) {
                sb.append((String) it2.next());
                sb.append(' ');
            }
            String string = sb.toString();
            Intent intent = new Intent("com.getpebble.action.SEND_NOTIFICATION");
            HashMap map = new HashMap();
            map.put("title", "Voice");
            if (MapplsNavigationHelper.getInstance().getVoiceCommandListener() != null) {
                String strWillSpeak = MapplsNavigationHelper.getInstance().getVoiceCommandListener().willSpeak(string);
                if (strWillSpeak == null) {
                    strWillSpeak = string;
                }
                map.put("body", strWillSpeak);
            } else {
                map.put("body", string);
            }
            String string2 = new JSONArray().put(new JSONObject(map)).toString();
            intent.putExtra("messageType", "PEBBLE_ALERT");
            intent.putExtra("sender", "OsmAnd");
            intent.putExtra("notificationData", string2);
            Context context = this.a;
            if (context != null) {
                context.sendBroadcast(intent);
                NavigationLogger.i("Send message to pebble " + string, new Object[0]);
            }
            boolean z2 = ((Boolean) NavigationContext.getNavigationContext().k().q0.get()).booleanValue() || z;
            if (j == null || !z2 || !this.i) {
                if (this.a != null) {
                    this.g.getClass();
                    return;
                }
                return;
            }
            int i = l;
            l = i + 1;
            if (i == 0) {
                b();
                if (((Integer) NavigationContext.getNavigationContext().k().l0.a(com.mappls.sdk.navigation.d.i)).intValue() == 0) {
                    l++;
                    TextToSpeech textToSpeech = j;
                    long jIntValue = ((Integer) NavigationContext.getNavigationContext().k().n0.get()).intValue();
                    StringBuilder sbA = com.mappls.sdk.navigation.h.a("");
                    sbA.append(System.currentTimeMillis());
                    textToSpeech.playSilentUtterance(jIntValue, 1, sbA.toString());
                }
            }
            NavigationLogger.d("ttsRequests = %d", Integer.valueOf(l));
            HashMap<String, String> map2 = this.f;
            StringBuilder sbA2 = com.mappls.sdk.navigation.h.a("");
            sbA2.append(System.currentTimeMillis());
            map2.put("utteranceId", sbA2.toString());
            if (MapplsNavigationHelper.getInstance().getVoiceCommandListener() == null) {
                NavigationLogger.d("TTS speak result = %d", Integer.valueOf(j.speak(sb.toString(), 1, this.f)));
                return;
            }
            String strWillSpeak2 = MapplsNavigationHelper.getInstance().getVoiceCommandListener().willSpeak(sb.toString());
            TextToSpeech textToSpeech2 = j;
            if (strWillSpeak2 == null) {
                strWillSpeak2 = sb.toString();
            }
            NavigationLogger.d("TTS speak result = %d", Integer.valueOf(textToSpeech2.speak(strWillSpeak2, 1, this.f)));
        }
    }

    public final void a(int i) {
        this.b = i;
        this.f.put("streamType", i + "");
    }
}
