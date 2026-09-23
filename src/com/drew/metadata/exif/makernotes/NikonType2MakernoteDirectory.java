package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.metadata.Directory;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.facebook.imageutils.JfifUtil;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import com.mappls.sdk.navigation.camera.NavigationConstants;
import java.util.HashMap;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public class NikonType2MakernoteDirectory extends Directory {
    public static final int TAG_ACTIVE_D_LIGHTING = 34;
    public static final int TAG_ADAPTER = 130;
    public static final int TAG_AE_BRACKET_COMPENSATION = 25;
    public static final int TAG_AF_FOCUS_POSITION = 136;
    public static final int TAG_AF_INFO_2 = 183;
    public static final int TAG_AF_RESPONSE = 173;
    public static final int TAG_AF_TUNE = 185;
    public static final int TAG_AF_TYPE = 7;
    public static final int TAG_AUTO_FLASH_COMPENSATION = 18;
    public static final int TAG_AUTO_FLASH_MODE = 9;
    public static final int TAG_CAMERA_COLOR_MODE = 141;
    public static final int TAG_CAMERA_HUE_ADJUSTMENT = 146;
    public static final int TAG_CAMERA_SERIAL_NUMBER = 29;
    public static final int TAG_CAMERA_SERIAL_NUMBER_2 = 160;
    public static final int TAG_CAMERA_SHARPENING = 6;
    public static final int TAG_CAMERA_TONE_COMPENSATION = 129;
    public static final int TAG_CAMERA_WHITE_BALANCE = 5;
    public static final int TAG_CAMERA_WHITE_BALANCE_FINE = 11;
    public static final int TAG_CAMERA_WHITE_BALANCE_RB_COEFF = 12;
    public static final int TAG_COLOR_BALANCE = 151;
    public static final int TAG_COLOR_MODE = 3;
    public static final int TAG_COLOR_SPACE = 30;
    public static final int TAG_CONTRAST_CURVE = 140;
    public static final int TAG_CROP_HIGH_SPEED = 27;
    public static final int TAG_DATA_DUMP = 16;
    public static final int TAG_DELETED_IMAGE_COUNT = 166;
    public static final int TAG_DIGITAL_VARI_PROGRAM = 171;
    public static final int TAG_DIGITAL_ZOOM = 134;
    public static final int TAG_EXPOSURE_DIFFERENCE = 14;
    public static final int TAG_EXPOSURE_SEQUENCE_NUMBER = 167;
    public static final int TAG_EXPOSURE_TUNING = 28;
    public static final int TAG_FILE_INFO = 184;
    public static final int TAG_FIRMWARE_VERSION = 1;
    public static final int TAG_FLASH_BRACKET_COMPENSATION = 24;
    public static final int TAG_FLASH_EXPOSURE_COMPENSATION = 23;
    public static final int TAG_FLASH_INFO = 168;
    public static final int TAG_FLASH_MODE = 26;
    public static final int TAG_FLASH_SYNC_MODE = 8;
    public static final int TAG_FLASH_USED = 135;
    public static final int TAG_HIGH_ISO_NOISE_REDUCTION = 177;
    public static final int TAG_IMAGE_ADJUSTMENT = 128;
    public static final int TAG_IMAGE_AUTHENTICATION = 32;
    public static final int TAG_IMAGE_BOUNDARY = 22;
    public static final int TAG_IMAGE_COUNT = 165;
    public static final int TAG_IMAGE_DATA_SIZE = 162;
    public static final int TAG_IMAGE_OPTIMISATION = 169;
    public static final int TAG_IMAGE_STABILISATION = 172;
    public static final int TAG_ISO_1 = 2;
    public static final int TAG_ISO_INFO = 37;
    public static final int TAG_ISO_MODE = 15;
    public static final int TAG_ISO_REQUESTED = 19;
    public static final int TAG_LENS = 132;
    public static final int TAG_LENS_DATA = 152;
    public static final int TAG_LENS_STOPS = 139;
    public static final int TAG_LENS_TYPE = 131;
    public static final int TAG_LIGHT_SOURCE = 144;
    public static final int TAG_LINEARIZATION_TABLE = 150;
    public static final int TAG_MANUAL_FOCUS_DISTANCE = 133;
    public static final int TAG_MULTI_EXPOSURE = 176;
    public static final int TAG_NEF_BIT_DEPTH = 3618;
    public static final int TAG_NEF_COMPRESSION = 147;
    public static final int TAG_NEF_THUMBNAIL_SIZE = 153;
    public static final int TAG_NIKON_CAPTURE_DATA = 3585;
    public static final int TAG_NIKON_CAPTURE_OFFSETS = 3598;
    public static final int TAG_NIKON_CAPTURE_VERSION = 3593;
    public static final int TAG_NIKON_SCAN = 3600;
    public static final int TAG_NOISE_REDUCTION = 149;
    public static final int TAG_PICTURE_CONTROL = 35;
    public static final int TAG_POWER_UP_TIME = 182;
    public static final int TAG_PREVIEW_IFD = 17;
    public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
    public static final int TAG_PROGRAM_SHIFT = 13;
    public static final int TAG_QUALITY_AND_FILE_FORMAT = 4;
    public static final int TAG_RETOUCH_HISTORY = 158;
    public static final int TAG_SATURATION = 148;
    public static final int TAG_SATURATION_2 = 170;
    public static final int TAG_SCENE_ASSIST = 156;
    public static final int TAG_SCENE_MODE = 143;
    public static final int TAG_SENSOR_PIXEL_SIZE = 154;
    public static final int TAG_SHOOTING_MODE = 137;
    public static final int TAG_SHOT_INFO = 145;
    public static final int TAG_UNKNOWN_10 = 155;
    public static final int TAG_UNKNOWN_11 = 157;
    public static final int TAG_UNKNOWN_12 = 159;
    public static final int TAG_UNKNOWN_20 = 138;
    public static final int TAG_UNKNOWN_27 = 163;
    public static final int TAG_UNKNOWN_28 = 164;
    public static final int TAG_UNKNOWN_29 = 174;
    public static final int TAG_UNKNOWN_30 = 175;
    public static final int TAG_UNKNOWN_31 = 178;
    public static final int TAG_UNKNOWN_32 = 179;
    public static final int TAG_UNKNOWN_33 = 180;
    public static final int TAG_UNKNOWN_34 = 10;
    public static final int TAG_UNKNOWN_35 = 33;
    public static final int TAG_UNKNOWN_36 = 38;
    public static final int TAG_UNKNOWN_37 = 39;
    public static final int TAG_UNKNOWN_38 = 40;
    public static final int TAG_UNKNOWN_39 = 41;
    public static final int TAG_UNKNOWN_40 = 43;
    public static final int TAG_UNKNOWN_41 = 44;
    public static final int TAG_UNKNOWN_42 = 45;
    public static final int TAG_UNKNOWN_43 = 46;
    public static final int TAG_UNKNOWN_44 = 47;
    public static final int TAG_UNKNOWN_45 = 48;
    public static final int TAG_UNKNOWN_46 = 49;
    public static final int TAG_UNKNOWN_47 = 142;
    public static final int TAG_UNKNOWN_48 = 181;
    public static final int TAG_UNKNOWN_49 = 187;
    public static final int TAG_UNKNOWN_50 = 189;
    public static final int TAG_UNKNOWN_51 = 259;
    public static final int TAG_UNKNOWN_52 = 3589;
    public static final int TAG_UNKNOWN_53 = 3592;
    public static final int TAG_UNKNOWN_54 = 3609;
    public static final int TAG_UNKNOWN_55 = 3619;
    public static final int TAG_VIGNETTE_CONTROL = 42;
    public static final int TAG_VR_INFO = 31;
    public static final int TAG_WORLD_TIME = 36;
    private static final int[] _decTable1;
    private static final int[] _decTable2;
    protected static final HashMap<Integer, String> _tagNameMap;

    static {
        HashMap<Integer, String> map = new HashMap<>();
        _tagNameMap = map;
        map.put(1, "Firmware Version");
        map.put(2, ExifInterface.TAG_RW2_ISO);
        map.put(4, "Quality & File Format");
        map.put(5, "White Balance");
        map.put(6, "Sharpening");
        map.put(7, "AF Type");
        map.put(11, "White Balance Fine");
        map.put(12, "White Balance RB Coefficients");
        map.put(19, ExifInterface.TAG_RW2_ISO);
        map.put(15, "ISO Mode");
        map.put(16, "Data Dump");
        map.put(13, "Program Shift");
        map.put(14, "Exposure Difference");
        map.put(17, "Preview IFD");
        map.put(131, "Lens Type");
        map.put(Integer.valueOf(TAG_FLASH_USED), "Flash Used");
        map.put(136, "AF Focus Position");
        map.put(137, "Shooting Mode");
        map.put(Integer.valueOf(TAG_LENS_STOPS), "Lens Stops");
        map.put(140, "Contrast Curve");
        map.put(144, "Light source");
        map.put(145, "Shot Info");
        map.put(151, "Color Balance");
        map.put(152, "Lens Data");
        map.put(153, "NEF Thumbnail Size");
        map.put(154, "Sensor Pixel Size");
        map.put(Integer.valueOf(TAG_UNKNOWN_10), "Unknown 10");
        map.put(Integer.valueOf(TAG_SCENE_ASSIST), "Scene Assist");
        map.put(157, "Unknown 11");
        map.put(158, "Retouch History");
        map.put(159, "Unknown 12");
        map.put(8, "Flash Sync Mode");
        map.put(9, "Auto Flash Mode");
        map.put(18, "Auto Flash Compensation");
        map.put(Integer.valueOf(TAG_EXPOSURE_SEQUENCE_NUMBER), "Exposure Sequence Number");
        map.put(3, "Color Mode");
        map.put(138, "Unknown 20");
        map.put(22, "Image Boundary");
        map.put(23, "Flash Exposure Compensation");
        map.put(24, "Flash Bracket Compensation");
        map.put(25, "AE Bracket Compensation");
        map.put(26, "Flash Mode");
        map.put(27, "Crop High Speed");
        map.put(28, "Exposure Tuning");
        map.put(29, "Camera Serial Number");
        map.put(30, "Color Space");
        map.put(31, "VR Info");
        map.put(32, "Image Authentication");
        map.put(33, "Unknown 35");
        map.put(34, "Active D-Lighting");
        map.put(35, "Picture Control");
        map.put(36, "World Time");
        map.put(37, "ISO Info");
        map.put(38, "Unknown 36");
        map.put(39, "Unknown 37");
        map.put(40, "Unknown 38");
        map.put(41, "Unknown 39");
        map.put(42, "Vignette Control");
        map.put(43, "Unknown 40");
        map.put(44, "Unknown 41");
        map.put(45, "Unknown 42");
        map.put(46, "Unknown 43");
        map.put(47, "Unknown 44");
        map.put(48, "Unknown 45");
        map.put(49, "Unknown 46");
        map.put(142, "Unknown 47");
        map.put(143, "Scene Mode");
        map.put(160, "Camera Serial Number");
        map.put(162, "Image Data Size");
        map.put(163, "Unknown 27");
        map.put(164, "Unknown 28");
        map.put(Integer.valueOf(TAG_IMAGE_COUNT), "Image Count");
        map.put(Integer.valueOf(TAG_DELETED_IMAGE_COUNT), "Deleted Image Count");
        map.put(170, ExifInterface.TAG_SATURATION);
        map.put(171, "Digital Vari Program");
        map.put(Integer.valueOf(TAG_IMAGE_STABILISATION), "Image Stabilisation");
        map.put(Integer.valueOf(TAG_AF_RESPONSE), "AF Response");
        map.put(174, "Unknown 29");
        map.put(Integer.valueOf(TAG_UNKNOWN_30), "Unknown 30");
        map.put(176, "Multi Exposure");
        map.put(177, "High ISO Noise Reduction");
        map.put(178, "Unknown 31");
        map.put(179, "Unknown 32");
        map.put(180, "Unknown 33");
        map.put(Integer.valueOf(TAG_UNKNOWN_48), "Unknown 48");
        map.put(182, "Power Up Time");
        map.put(Integer.valueOf(TAG_AF_INFO_2), "AF Info 2");
        map.put(Integer.valueOf(TAG_FILE_INFO), "File Info");
        map.put(Integer.valueOf(TAG_AF_TUNE), "AF Tune");
        map.put(168, "Flash Info");
        map.put(169, "Image Optimisation");
        map.put(128, "Image Adjustment");
        map.put(129, "Tone Compensation");
        map.put(Integer.valueOf(TAG_ADAPTER), "Adapter");
        map.put(Integer.valueOf(TAG_LENS), "Lens");
        map.put(Integer.valueOf(TAG_MANUAL_FOCUS_DISTANCE), "Manual Focus Distance");
        map.put(Integer.valueOf(TAG_DIGITAL_ZOOM), "Digital Zoom");
        map.put(141, "Colour Mode");
        map.put(146, "Camera Hue Adjustment");
        map.put(147, "NEF Compression");
        map.put(148, ExifInterface.TAG_SATURATION);
        map.put(149, "Noise Reduction");
        map.put(150, "Linearization Table");
        map.put(Integer.valueOf(TAG_NIKON_CAPTURE_DATA), "Nikon Capture Data");
        map.put(Integer.valueOf(TAG_UNKNOWN_49), "Unknown 49");
        map.put(Integer.valueOf(TAG_UNKNOWN_50), "Unknown 50");
        map.put(259, "Unknown 51");
        map.put(3584, "Print IM");
        map.put(Integer.valueOf(TAG_UNKNOWN_52), "Unknown 52");
        map.put(Integer.valueOf(TAG_UNKNOWN_53), "Unknown 53");
        map.put(Integer.valueOf(TAG_NIKON_CAPTURE_VERSION), "Nikon Capture Version");
        map.put(Integer.valueOf(TAG_NIKON_CAPTURE_OFFSETS), "Nikon Capture Offsets");
        map.put(3600, "Nikon Scan");
        map.put(Integer.valueOf(TAG_UNKNOWN_54), "Unknown 54");
        map.put(Integer.valueOf(TAG_NEF_BIT_DEPTH), "NEF Bit Depth");
        map.put(Integer.valueOf(TAG_UNKNOWN_55), "Unknown 55");
        _decTable1 = new int[]{193, 191, 109, 13, 89, 197, 19, 157, 131, 97, 107, 79, 199, 127, 61, 61, 83, 89, 227, 199, 233, 47, 149, TAG_EXPOSURE_SEQUENCE_NUMBER, 149, 31, 223, 127, 43, 41, 199, 13, 223, 7, 239, 113, 137, 61, 19, 61, 59, 19, 251, 13, 137, 193, 101, 31, 179, 13, 107, 41, 227, 251, 239, 163, 107, 71, 127, 149, 53, TAG_EXPOSURE_SEQUENCE_NUMBER, 71, 79, 199, 241, 89, 149, 53, 17, 41, 97, 241, 61, 179, 43, 13, 67, 137, 193, 157, 157, 137, 101, 241, 233, 223, 191, 61, 127, 83, 151, 229, 233, 149, 23, 29, 61, TAG_LENS_STOPS, 251, 199, 227, 103, TAG_EXPOSURE_SEQUENCE_NUMBER, 7, 241, 113, TAG_EXPOSURE_SEQUENCE_NUMBER, 83, TAG_UNKNOWN_48, 41, 137, 229, 43, TAG_EXPOSURE_SEQUENCE_NUMBER, 23, 41, 233, 79, 197, 101, 109, 107, 239, 13, 137, 73, 47, 179, 67, 83, 101, 29, 73, 163, 19, 137, 89, 239, 107, 239, 101, 29, 11, 89, 19, 227, 79, 157, 179, 41, 67, 43, 7, 29, 149, 89, 89, 71, 251, 229, 233, 97, 71, 47, 53, 127, 23, 127, 239, 127, 149, 149, 113, Mp4VideoDirectory.TAG_GRAPHICS_MODE, 163, 11, 113, 163, TAG_AF_RESPONSE, 11, 59, TAG_UNKNOWN_48, 251, 163, 191, 79, 131, 29, TAG_AF_RESPONSE, 233, 47, 113, 101, 163, 229, 7, 53, 61, 13, TAG_UNKNOWN_48, 233, 229, 71, 59, 157, 239, 53, 163, 191, 179, 223, 83, Mp4VideoDirectory.TAG_GRAPHICS_MODE, 151, 83, 73, 113, 7, 53, 97, 113, 47, 67, 47, 17, 223, 23, 151, 251, 149, 59, 127, 107, Mp4VideoDirectory.TAG_GRAPHICS_MODE, 37, 191, TAG_AF_RESPONSE, 199, 197, 197, TAG_UNKNOWN_48, TAG_LENS_STOPS, 239, 47, Mp4VideoDirectory.TAG_GRAPHICS_MODE, 7, 107, 37, 73, 149, 37, 73, 109, 113, 199};
        _decTable2 = new int[]{TAG_EXPOSURE_SEQUENCE_NUMBER, 188, 201, TAG_AF_RESPONSE, 145, 223, TAG_MANUAL_FOCUS_DISTANCE, 229, Mp4VideoDirectory.TAG_OPCOLOR, 120, Mp4VideoDirectory.TAG_COLOR_TABLE, 23, 70, PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH, 41, 76, 77, 3, 233, 37, 104, 17, TAG_DIGITAL_ZOOM, 179, TAG_UNKNOWN_50, 247, PanasonicMakernoteDirectory.TAG_LANDMARK, 97, 34, 162, 38, 52, 42, 190, 30, 70, 20, 104, 157, 68, 24, 194, 64, 244, WebSocketProtocol.PAYLOAD_SHORT, 95, 27, TAG_AF_RESPONSE, 11, 148, 182, 103, 180, 11, JfifUtil.MARKER_APP1, 234, 149, TAG_SCENE_ASSIST, 102, 220, 231, 93, 108, 5, JfifUtil.MARKER_SOS, Mp4VideoDirectory.TAG_COLOR_TABLE, 223, 122, 239, 246, 219, 31, TAG_ADAPTER, 76, JfifUtil.MARKER_SOFn, 104, 71, CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE, TAG_UNKNOWN_50, 238, 57, 80, 86, 74, 221, 223, TAG_IMAGE_COUNT, 248, 198, JfifUtil.MARKER_SOS, 202, 144, 202, 1, 66, 157, TAG_LENS_STOPS, 12, 115, 67, 117, 5, 148, 222, 36, 179, 128, 52, 229, 44, 220, TAG_UNKNOWN_10, 63, 202, 51, 69, 208, 219, 95, 245, 82, 195, 33, JfifUtil.MARKER_SOS, 226, 34, 114, 107, 62, 208, 91, 168, TAG_FLASH_USED, 140, 6, 93, 15, 221, 9, 25, 147, 208, TAG_AF_TUNE, 252, TAG_LENS_STOPS, 15, TAG_LENS, 96, 51, 28, TAG_UNKNOWN_10, 69, 241, 240, 163, 148, 58, 18, PanasonicMakernoteDirectory.TAG_BURST_SPEED, 51, 77, 68, 120, 40, 60, 158, 253, 101, 87, 22, 148, 107, 251, 89, 208, 200, 34, 54, 219, Mp4VideoDirectory.TAG_COMPRESSION_TYPE, 99, 152, 67, CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE, 4, TAG_FLASH_USED, TAG_DIGITAL_ZOOM, 247, TAG_DELETED_IMAGE_COUNT, 38, TAG_UNKNOWN_49, Mp4VideoDirectory.TAG_FRAME_RATE, 89, 77, 191, RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN, 46, 170, 43, 239, 230, 120, 182, 78, CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY, 47, 220, PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH, 190, 87, 25, 50, WebSocketProtocol.PAYLOAD_SHORT, 42, 208, TAG_FILE_INFO, 186, 41, 0, 60, 82, NavigationConstants.NAVIGATION_LOW_ALERT_DURATION, 168, 73, 59, 45, 235, 37, 73, 250, 163, 170, 57, TAG_EXPOSURE_SEQUENCE_NUMBER, 197, TAG_EXPOSURE_SEQUENCE_NUMBER, 80, 17, 54, 251, 198, 103, 74, 245, TAG_IMAGE_COUNT, 18, 101, WebSocketProtocol.PAYLOAD_SHORT, 176, 223, TAG_UNKNOWN_30, 78, 179, 97, 127, 47};
    }

    public NikonType2MakernoteDirectory() {
        setDescriptor(new NikonType2MakernoteDescriptor(this));
    }

    @Override // com.drew.metadata.Directory
    public String getName() {
        return "Nikon Makernote";
    }

    @Override // com.drew.metadata.Directory
    protected HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    public int[] getDecryptedIntArray(int i) {
        int i2;
        int[] intArray = getIntArray(i);
        Integer integer = getInteger(29);
        Integer integer2 = getInteger(TAG_EXPOSURE_SEQUENCE_NUMBER);
        if (intArray == null || integer == null || integer2 == null) {
            return null;
        }
        int i3 = 0;
        int iIntValue = 0;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            iIntValue ^= (integer2.intValue() >> (i3 * 8)) & 255;
            i3++;
        }
        int i4 = _decTable1[integer.intValue() & 255];
        int i5 = _decTable2[iIntValue];
        int i6 = 96;
        for (i2 = 4; i2 < intArray.length; i2++) {
            i5 = (i5 + (i4 * i6)) & 255;
            i6 = (i6 + 1) & 255;
            intArray[i2] = intArray[i2] ^ i5;
        }
        return intArray;
    }
}
