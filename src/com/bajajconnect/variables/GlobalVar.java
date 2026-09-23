package com.bajajconnect.variables;

import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import com.bajajconnect.enums.CallState;
import com.bajajconnect.enums.GpsStatus;
import com.bajajconnect.enums.VehicleType;
import com.bajajconnect.enums.music.PlayStatus;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class GlobalVar {
    public static final String ALERTS_INFO = "0410676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic ALERTS_INFO_CHAR = null;
    public static final String CONTROL = "0a10676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic CONTROL_CHAR = null;
    public static final String FAV_CONTACTS = "0910676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic FAV_CONTACTS_CHAR = null;
    public static final String GENERAL = "0210676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic GENERAL_CHAR = null;
    public static int LAST_SHUFFLE_STATUS = 0;
    public static final String MAIN_SERVICE = "0010676e-6972-6565-6e69-676e4543544f";
    public static final String MEDIA_INFO = "0610676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic MEDIA_INFO_CHAR = null;
    public static final String MISSED_CALL = "0310676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic MISSED_CALL_CHAR = null;
    public static final String PLAYLIST_INFO = "0510676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic PLAYLIST_INFO_CHAR = null;
    public static final String RECENT_CALLS = "0b10676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic RECENT_CALLS_CHAR = null;
    public static final String TBT_DATA = "0210676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic TBT_DATA_CHAR = null;
    public static final String TBT_INFO = "0110676e-6972-6565-6e69-676e4543544f";
    public static BluetoothGattCharacteristic TBT_INFO_CHAR = null;
    private static final String THEME_KEY_DARK = "app_dark_mode";
    private static final String THEME_PREFS = "bajaj_app_theme";
    public static int birthdayDay;
    public static int birthdayMonth;
    public static PlayStatus lastSpotifyPlaySate;
    public static String lastSpotifySong;
    public static Double lat;
    public static Double lng;
    public static String locationString;
    public static String mapplsPin;
    public static boolean spotifyPlaylistUriChange;
    public static boolean spotifySongOneFlag;
    public static Double takeMeHomeLat;
    public static Double takeMeHomeLng;
    public static VehicleType vehicleType = VehicleType.UNKNOWN;
    public static GpsStatus gpsStatus = GpsStatus.ACTIVE;
    public static boolean isBlueToothConnected = false;
    public static String bleDeviceAddress = "";
    public static String bleDeviceName = "";
    public static int signalStrength = 0;
    public static int smsCount = 0;
    public static int missedCallCount = 0;
    public static int batteryPercentage = 0;
    public static CallState callState = CallState.NO_CALL;
    public static String callerName = "";
    public static String callerNumber = "";
    public static PlayStatus playStatus = PlayStatus.PAUSED;
    public static String songName = "";
    public static String songAlbum = "";
    public static String songArtist = "";
    public static int currentMusicDuration = 0;
    public static int currentMusicTotalDuration = 0;
    public static ArrayList<ArrayList<BluetoothGattCharacteristic>> mGattCharacteristics = new ArrayList<>();
    public static int socailMediaAlert = 0;
    public static int callProgressCount = 0;
    public static int currentVolume = 5;
    public static int callAccept = 0;
    public static int callReject = 0;
    public static int callRejectWithSms = 0;
    public static int pagePlaylist = 0;
    public static int takeMeHome = 0;
    public static int resumeSong = 0;
    public static int pauseSong = 0;
    public static int skipToNext = 0;
    public static int skipToPrev = 0;
    public static int stopSong = 0;
    public static int missedCallGet = 0;
    public static int alertGet = 0;
    public static int launchMediaPlayer = 0;
    public static int volumeToSet = 0;
    public static int selectePlaylistSongAck = 0;
    public static int userChangePlaylistCounter = 0;
    public static int pagePlaylistAck = 0;
    public static int newPlaylistReq = 0;
    public static int newPlaylistAck = 0;
    public static int olderplaylistAck = 0;
    public static int selectedPlaylistSong = 0;
    public static String missedCallName = "";
    public static String missedCallNumber = "";
    public static String smsName = "";
    public static String lastWAPPName = "";
    public static String lastMessage = "";
    public static String lastSmsKey = "";
    public static String callRejectMsg = "";
    public static boolean isDndEnabled = false;
    public static boolean isMTUIncreased = false;
    public static int negotiatedMTU = 23;
    public static int SHUFFLE_STATUS = 0;
    public static int takeMeHomeAck = 0;
    public static int callAcceptAck = 0;
    public static int callRejectAck = 0;
    public static int callRejectWithSmsAck = 0;
    public static int resumeSongAck = 0;
    public static int pauseSongAck = 0;
    public static int skipToNextAck = 0;
    public static int skipToPrevAck = 0;
    public static int stopSongAck = 0;
    public static int launchMediaPlayerAck = 0;
    public static int missedCallGetAck = 0;
    public static int alertsGetAck = 0;
    public static int volumeToSetAck = 0;
    public static boolean isNavigationActive = false;
    public static int inbuiltMusicTotalDuration = 0;
    public static boolean isHeadsetConnected = false;
    public static String takeMeHomeActionStart = "ActionTakeMeHome";
    public static boolean isIsTakeMeHomeNavStarting = false;
    public static List<ELocation> waypoints = new ArrayList();
    public static String vehcileVin = "";
    public static String wifiPassword = "";
    public static boolean isGoogleNavigation = false;
    public static volatile boolean appThemeIsDark = false;
    public static boolean pauseBleReading = false;
    public static String MMI_AREA_CODE = "";
    public static String takeMeHomeAddress = "";
    public static String takeMeHomeMapplsPin = "";

    static {
        Double dValueOf = Double.valueOf(0.0d);
        takeMeHomeLat = dValueOf;
        takeMeHomeLng = dValueOf;
        birthdayDay = 0;
        birthdayMonth = 0;
        LAST_SHUFFLE_STATUS = 0;
        spotifyPlaylistUriChange = false;
        lastSpotifySong = "";
        lastSpotifyPlaySate = PlayStatus.PAUSED;
        spotifySongOneFlag = false;
    }

    public static String mapplsStyleForAppTheme() {
        return appThemeIsDark ? "standard_night" : "standard_day";
    }

    public static void setAppThemeIsDark(Context context, boolean z) {
        appThemeIsDark = z;
        if (context == null) {
            return;
        }
        try {
            context.getApplicationContext().getSharedPreferences(THEME_PREFS, 0).edit().putBoolean(THEME_KEY_DARK, z).apply();
        } catch (Exception unused) {
        }
    }

    public static void hydrateAppThemeFromPrefs(Context context) {
        if (context == null) {
            return;
        }
        try {
            appThemeIsDark = context.getApplicationContext().getSharedPreferences(THEME_PREFS, 0).getBoolean(THEME_KEY_DARK, false);
        } catch (Exception unused) {
        }
    }
}
