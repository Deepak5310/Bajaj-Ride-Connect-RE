package com.google.android.libraries.places.internal;

import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.KodakMakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import com.facebook.imageutils.JfifUtil;
import com.mappls.sdk.maps.rctmgl.components.styles.sources.RCTMGLShapeSourceManager;
import com.mappls.sdk.navigation.camera.NavigationConstants;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzso implements zzanv {
    static final zzanv zza = new zzso();

    private zzso() {
    }

    @Override // com.google.android.libraries.places.internal.zzanv
    public final boolean zza(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case PanasonicMakernoteDirectory.TAG_WB_ADJUST_GM /* 71 */:
            case 72:
            case 73:
            case ReconyxHyperFireMakernoteDirectory.TAG_BRIGHTNESS /* 74 */:
            case 75:
            case 76:
            case PanasonicMakernoteDirectory.TAG_AF_POINT_POSITION /* 77 */:
            case 78:
            case 79:
            case 80:
            case PanasonicMakernoteDirectory.TAG_LENS_TYPE /* 81 */:
            case 82:
            case PanasonicMakernoteDirectory.TAG_ACCESSORY_TYPE /* 83 */:
            case 84:
            case JpegTranscoderUtils.DEFAULT_JPEG_QUALITY /* 85 */:
            case ReconyxHyperFireMakernoteDirectory.TAG_USER_LABEL /* 86 */:
            case 87:
            case 88:
            case PanasonicMakernoteDirectory.TAG_TRANSFORM /* 89 */:
            case 90:
            case 91:
            case KodakMakernoteDirectory.TAG_FLASH_MODE /* 92 */:
            case 93:
            case KodakMakernoteDirectory.TAG_ISO_SETTING /* 94 */:
            case 95:
            case 96:
            case PanasonicMakernoteDirectory.TAG_FACE_RECOGNITION_INFO /* 97 */:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case RCTMGLShapeSourceManager.METHOD_GET_CLUSTER_CHILDREN /* 106 */:
            case 107:
            case 108:
            case 109:
            case 110:
            case PanasonicMakernoteDirectory.TAG_LANDMARK /* 111 */:
            case PanasonicMakernoteDirectory.TAG_INTELLIGENT_RESOLUTION /* 112 */:
            case 113:
            case 114:
            case 115:
            case 116:
            case 117:
            case 118:
            case PanasonicMakernoteDirectory.TAG_BURST_SPEED /* 119 */:
            case 120:
            case PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE /* 121 */:
            case 122:
            case 123:
            case PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH /* 124 */:
            case NavigationConstants.NAVIGATION_LOW_ALERT_DURATION /* 125 */:
            case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
            case 127:
            case 128:
            case 129:
            case NikonType2MakernoteDirectory.TAG_ADAPTER /* 130 */:
            case 131:
            case NikonType2MakernoteDirectory.TAG_LENS /* 132 */:
            case NikonType2MakernoteDirectory.TAG_MANUAL_FOCUS_DISTANCE /* 133 */:
            case NikonType2MakernoteDirectory.TAG_DIGITAL_ZOOM /* 134 */:
            case NikonType2MakernoteDirectory.TAG_FLASH_USED /* 135 */:
            case 136:
            case 137:
            case 138:
            case NikonType2MakernoteDirectory.TAG_LENS_STOPS /* 139 */:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147:
            case 148:
            case 149:
            case 150:
            case 151:
            case 152:
            case 153:
            case 154:
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_10 /* 155 */:
            case NikonType2MakernoteDirectory.TAG_SCENE_ASSIST /* 156 */:
            case 157:
            case 158:
            case 159:
            case 160:
            case CanonMakernoteDirectory.TAG_TONE_CURVE_TABLE /* 161 */:
            case 162:
            case 163:
            case 164:
            case NikonType2MakernoteDirectory.TAG_IMAGE_COUNT /* 165 */:
            case NikonType2MakernoteDirectory.TAG_DELETED_IMAGE_COUNT /* 166 */:
            case NikonType2MakernoteDirectory.TAG_EXPOSURE_SEQUENCE_NUMBER /* 167 */:
            case 168:
            case 169:
            case 170:
            case 171:
            case NikonType2MakernoteDirectory.TAG_IMAGE_STABILISATION /* 172 */:
            case NikonType2MakernoteDirectory.TAG_AF_RESPONSE /* 173 */:
            case 174:
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_30 /* 175 */:
            case 176:
            case 177:
            case 178:
            case 179:
            case 180:
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_48 /* 181 */:
            case 182:
            case NikonType2MakernoteDirectory.TAG_AF_INFO_2 /* 183 */:
            case NikonType2MakernoteDirectory.TAG_FILE_INFO /* 184 */:
            case NikonType2MakernoteDirectory.TAG_AF_TUNE /* 185 */:
            case 186:
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_49 /* 187 */:
            case 188:
            case NikonType2MakernoteDirectory.TAG_UNKNOWN_50 /* 189 */:
            case 190:
            case 191:
            case JfifUtil.MARKER_SOFn /* 192 */:
            case 193:
            case 194:
            case 195:
            case 196:
            case 197:
            case 198:
            case 199:
            case 200:
                return true;
            default:
                return false;
        }
    }
}
