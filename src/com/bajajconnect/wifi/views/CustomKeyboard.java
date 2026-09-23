package com.bajajconnect.wifi.views;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.core.widget.ImageViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bajajconnect.R;
import com.bajajconnect.wifi.StreamingImageHandler;
import com.bajajconnect.wifi.TouchPoint;
import com.bajajconnect.wifi.UdpServerService;
import com.drew.metadata.mp4.media.Mp4VideoDirectory;
import com.facebook.common.callercontext.ContextChain;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.mappls.sdk.services.api.weather.WeatherCriteria;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes3.dex */
public class CustomKeyboard {
    public LinearLayout alphalayout;
    final Context context;
    private KeyPressCallback keyPressCallback;
    private Drawable keybackground;
    private Drawable keybackgroundHightlighted;
    private Bitmap keyboardImage;
    public LinearLayout numericlayout;
    private LinearLayout spacebar;
    private final View view;
    private String[] keyArray = {"q", "w", "e", "r", "t", "y", "u", ContextChain.TAG_INFRA, "o", ContextChain.TAG_PRODUCT};
    private String[] keyArrayTwo = {"a", "s", "d", "f", "g", "h", "j", "k", "l"};
    private String[] keyArrayThree = {"caps", "z", "x", "c", "v", "b", "n", "m"};
    private final String[] keyArrayCaps = {"Q", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, "R", ExifInterface.GPS_DIRECTION_TRUE, "Y", "U", "I", "O", "P"};
    private final String[] keyArrayTwoCaps = {ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, ExifInterface.LATITUDE_SOUTH, "D", WeatherCriteria.UNIT_FARENHEIT, "G", "H", "J", "K", "L"};
    private final String[] keyArrayThreeCaps = {"caps", "Z", "X", WeatherCriteria.UNIT_CELSIUS, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "B", "N", "M"};
    private final String[] keyArraySmall = {"q", "w", "e", "r", "t", "y", "u", ContextChain.TAG_INFRA, "o", ContextChain.TAG_PRODUCT};
    private final String[] keyArrayTwoSmall = {"a", "s", "d", "f", "g", "h", "j", "k", "l"};
    private final String[] keyArrayThreeSmall = {"caps", "z", "x", "c", "v", "b", "n", "m"};
    private final String[] numArray = {"1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "0"};
    private final String[] numArrayTwo = {"@", "#", "_", "&", "-", "+", "(", ")", RemoteSettings.FORWARD_SLASH_STRING};
    private final String[] numArrayThree = {"", "*", "'", String.valueOf(Typography.quote), ":", ";", "!", "?"};
    int keyboarStarting_y_axis = 188;
    public Boolean isNumericKeyboard = false;
    public Boolean touchKeyboard = true;
    public boolean isCapsOn = false;

    public interface KeyPressCallback {
        void onEnter();

        void onKeyboardStatusChange(boolean z);

        void onSpace();

        void onkeyPress(String str);
    }

    public CustomKeyboard(Context context) {
        this.context = context;
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.keyboard_custom, (ViewGroup) null);
        this.view = viewInflate;
        viewInflate.measure(View.MeasureSpec.getSize(viewInflate.getMeasuredWidth()), View.MeasureSpec.getSize(viewInflate.getMeasuredHeight()));
        viewInflate.layout(0, 188, 800, StreamingImageHandler.TFT_HEIGHT);
        initVariables();
    }

    public void initVariables() {
        this.numericlayout = (LinearLayout) this.view.findViewById(R.id.linearLayout_2);
        this.alphalayout = (LinearLayout) this.view.findViewById(R.id.linearLayout_1);
        this.spacebar = (LinearLayout) this.view.findViewById(R.id.btn_spacebar);
        changeKeyboard(false);
    }

    public void changeKeyboard(Boolean bool) {
        if (bool.booleanValue()) {
            this.isNumericKeyboard = true;
            this.numericlayout.setVisibility(0);
            this.alphalayout.setVisibility(8);
            this.touchKeyboard = false;
            return;
        }
        this.isNumericKeyboard = false;
        this.alphalayout.setVisibility(0);
        this.numericlayout.setVisibility(8);
        this.touchKeyboard = true;
    }

    private void changeKeyboardToCaps(boolean z) {
        this.isCapsOn = z;
        if (z) {
            this.view.findViewById(R.id.btn_caps).setBackground(AppCompatResources.getDrawable(this.context, R.drawable.tft_caps_bg_blue));
            ImageViewCompat.setImageTintList((ImageView) this.view.findViewById(R.id.btn_caps_iv), ColorStateList.valueOf(ContextCompat.getColor(this.context, R.color.black)));
            this.keyArray = this.keyArrayCaps;
            this.keyArrayTwo = this.keyArrayTwoCaps;
            this.keyArrayThree = this.keyArrayThreeCaps;
            ((TextView) this.view.findViewById(R.id.bq)).setText(this.keyArrayCaps[0]);
            ((TextView) this.view.findViewById(R.id.bw)).setText(this.keyArrayCaps[1]);
            ((TextView) this.view.findViewById(R.id.be)).setText(this.keyArrayCaps[2]);
            ((TextView) this.view.findViewById(R.id.br)).setText(this.keyArrayCaps[3]);
            ((TextView) this.view.findViewById(R.id.bt)).setText(this.keyArrayCaps[4]);
            ((TextView) this.view.findViewById(R.id.by)).setText(this.keyArrayCaps[5]);
            ((TextView) this.view.findViewById(R.id.bu)).setText(this.keyArrayCaps[6]);
            ((TextView) this.view.findViewById(R.id.bi)).setText(this.keyArrayCaps[7]);
            ((TextView) this.view.findViewById(R.id.bo)).setText(this.keyArrayCaps[8]);
            ((TextView) this.view.findViewById(R.id.bp)).setText(this.keyArrayCaps[9]);
            ((TextView) this.view.findViewById(R.id.ba)).setText(this.keyArrayTwoCaps[0]);
            ((TextView) this.view.findViewById(R.id.bs)).setText(this.keyArrayTwoCaps[1]);
            ((TextView) this.view.findViewById(R.id.bd)).setText(this.keyArrayTwoCaps[2]);
            ((TextView) this.view.findViewById(R.id.bf)).setText(this.keyArrayTwoCaps[3]);
            ((TextView) this.view.findViewById(R.id.bg)).setText(this.keyArrayTwoCaps[4]);
            ((TextView) this.view.findViewById(R.id.bh)).setText(this.keyArrayTwoCaps[5]);
            ((TextView) this.view.findViewById(R.id.bj)).setText(this.keyArrayTwoCaps[6]);
            ((TextView) this.view.findViewById(R.id.bk)).setText(this.keyArrayTwoCaps[7]);
            ((TextView) this.view.findViewById(R.id.bl)).setText(this.keyArrayTwoCaps[8]);
            ((TextView) this.view.findViewById(R.id.bz)).setText(this.keyArrayThreeCaps[1]);
            ((TextView) this.view.findViewById(R.id.bx)).setText(this.keyArrayThreeCaps[2]);
            ((TextView) this.view.findViewById(R.id.bc)).setText(this.keyArrayThreeCaps[3]);
            ((TextView) this.view.findViewById(R.id.bv)).setText(this.keyArrayThreeCaps[4]);
            ((TextView) this.view.findViewById(R.id.bb)).setText(this.keyArrayThreeCaps[5]);
            ((TextView) this.view.findViewById(R.id.bn)).setText(this.keyArrayThreeCaps[6]);
            ((TextView) this.view.findViewById(R.id.bm)).setText(this.keyArrayThreeCaps[7]);
            return;
        }
        this.view.findViewById(R.id.btn_caps).setBackground(AppCompatResources.getDrawable(this.context, R.drawable.key_background));
        ImageViewCompat.setImageTintList((ImageView) this.view.findViewById(R.id.btn_caps_iv), ColorStateList.valueOf(ContextCompat.getColor(this.context, R.color.white)));
        this.keyArray = this.keyArraySmall;
        this.keyArrayTwo = this.keyArrayTwoSmall;
        this.keyArrayThree = this.keyArrayThreeSmall;
        ((TextView) this.view.findViewById(R.id.bq)).setText(this.keyArraySmall[0]);
        ((TextView) this.view.findViewById(R.id.bw)).setText(this.keyArraySmall[1]);
        ((TextView) this.view.findViewById(R.id.be)).setText(this.keyArraySmall[2]);
        ((TextView) this.view.findViewById(R.id.br)).setText(this.keyArraySmall[3]);
        ((TextView) this.view.findViewById(R.id.bt)).setText(this.keyArraySmall[4]);
        ((TextView) this.view.findViewById(R.id.by)).setText(this.keyArraySmall[5]);
        ((TextView) this.view.findViewById(R.id.bu)).setText(this.keyArraySmall[6]);
        ((TextView) this.view.findViewById(R.id.bi)).setText(this.keyArraySmall[7]);
        ((TextView) this.view.findViewById(R.id.bo)).setText(this.keyArraySmall[8]);
        ((TextView) this.view.findViewById(R.id.bp)).setText(this.keyArraySmall[9]);
        ((TextView) this.view.findViewById(R.id.ba)).setText(this.keyArrayTwoSmall[0]);
        ((TextView) this.view.findViewById(R.id.bs)).setText(this.keyArrayTwoSmall[1]);
        ((TextView) this.view.findViewById(R.id.bd)).setText(this.keyArrayTwoSmall[2]);
        ((TextView) this.view.findViewById(R.id.bf)).setText(this.keyArrayTwoSmall[3]);
        ((TextView) this.view.findViewById(R.id.bg)).setText(this.keyArrayTwoSmall[4]);
        ((TextView) this.view.findViewById(R.id.bh)).setText(this.keyArrayTwoSmall[5]);
        ((TextView) this.view.findViewById(R.id.bj)).setText(this.keyArrayTwoSmall[6]);
        ((TextView) this.view.findViewById(R.id.bk)).setText(this.keyArrayTwoSmall[7]);
        ((TextView) this.view.findViewById(R.id.bl)).setText(this.keyArrayTwoSmall[8]);
        ((TextView) this.view.findViewById(R.id.bz)).setText(this.keyArrayThreeSmall[1]);
        ((TextView) this.view.findViewById(R.id.bx)).setText(this.keyArrayThreeSmall[2]);
        ((TextView) this.view.findViewById(R.id.bc)).setText(this.keyArrayThreeSmall[3]);
        ((TextView) this.view.findViewById(R.id.bv)).setText(this.keyArrayThreeSmall[4]);
        ((TextView) this.view.findViewById(R.id.bb)).setText(this.keyArrayThreeSmall[5]);
        ((TextView) this.view.findViewById(R.id.bn)).setText(this.keyArrayThreeSmall[6]);
        ((TextView) this.view.findViewById(R.id.bm)).setText(this.keyArrayThreeSmall[7]);
    }

    public View getView() {
        return this.view;
    }

    public synchronized void injectTouchEvents(TouchPoint touchPoint) {
        if (touchPoint.y > 410 && touchPoint.y < 480) {
            double d = touchPoint.x;
            if (d > 1.5d && d < 78.5d) {
                changeKeyboard(Boolean.valueOf(!this.isNumericKeyboard.booleanValue()));
                if (this.touchKeyboard.booleanValue()) {
                    animateKey((Button) this.view.findViewById(R.id.btn_num));
                } else {
                    animateKey((Button) this.view.findViewById(R.id.btn_alpha));
                }
            }
            if (touchPoint.x > 195 && touchPoint.x < 593) {
                if (this.touchKeyboard.booleanValue()) {
                    animateBackSpace((LinearLayout) this.view.findViewById(R.id.btn_spacebar));
                } else {
                    animateBackSpace((LinearLayout) this.view.findViewById(R.id.btn_spacebar_2));
                }
                this.keyPressCallback.onSpace();
            } else if (touchPoint.x > 679 && touchPoint.x < 799.5d) {
                this.isNumericKeyboard = false;
                NavigationSearchScreen.isKeyboardOpen = false;
            }
            return;
        }
        if (this.touchKeyboard.booleanValue()) {
            if (touchPoint.y >= this.keyboarStarting_y_axis && touchPoint.y <= this.keyboarStarting_y_axis + 71) {
                double d2 = touchPoint.x;
                if (d2 < 78.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[0]);
                    animateKey((Button) this.view.findViewById(R.id.bq));
                } else if (d2 < 158.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[1]);
                    animateKey((Button) this.view.findViewById(R.id.bw));
                } else if (d2 < 238.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[2]);
                    animateKey((Button) this.view.findViewById(R.id.be));
                } else if (d2 < 318.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[3]);
                    animateKey((Button) this.view.findViewById(R.id.br));
                } else if (d2 < 398.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[4]);
                    animateKey((Button) this.view.findViewById(R.id.bt));
                } else if (d2 < 478.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[5]);
                    animateKey((Button) this.view.findViewById(R.id.by));
                } else if (d2 < 558.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[6]);
                    animateKey((Button) this.view.findViewById(R.id.bu));
                } else if (d2 < 638.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[7]);
                    animateKey((Button) this.view.findViewById(R.id.bi));
                } else if (d2 < 718.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[8]);
                    animateKey((Button) this.view.findViewById(R.id.bo));
                } else if (d2 < 798.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArray[9]);
                    animateKey((Button) this.view.findViewById(R.id.bp));
                }
                return;
            }
            if (touchPoint.y > this.keyboarStarting_y_axis + 71 && touchPoint.y < this.keyboarStarting_y_axis + 141) {
                double d3 = touchPoint.x;
                if (d3 > 36.5d && d3 < 113.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[0]);
                    animateKey((Button) this.view.findViewById(R.id.ba));
                } else if (d3 < 193.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[1]);
                    animateKey((Button) this.view.findViewById(R.id.bs));
                } else if (d3 < 273.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[2]);
                    animateKey((Button) this.view.findViewById(R.id.bd));
                } else if (d3 < 353.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[3]);
                    animateKey((Button) this.view.findViewById(R.id.bf));
                } else if (d3 < 433.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[4]);
                    animateKey((Button) this.view.findViewById(R.id.bg));
                } else if (d3 < 513.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[5]);
                    animateKey((Button) this.view.findViewById(R.id.bh));
                } else if (d3 < 593.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[6]);
                    animateKey((Button) this.view.findViewById(R.id.bj));
                } else if (d3 < 673.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[7]);
                    animateKey((Button) this.view.findViewById(R.id.bk));
                } else if (d3 < 753.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayTwo[8]);
                    animateKey((Button) this.view.findViewById(R.id.bl));
                }
                return;
            }
            if (touchPoint.y > this.keyboarStarting_y_axis + 142 && touchPoint.y < this.keyboarStarting_y_axis + Mp4VideoDirectory.TAG_GRAPHICS_MODE) {
                int i = touchPoint.x;
                double d4 = i;
                if (d4 < 78.5d) {
                    changeKeyboardToCaps(!this.isCapsOn);
                } else if (d4 < 158.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayThree[1]);
                    animateKey((Button) this.view.findViewById(R.id.bz));
                } else if (d4 < 238.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayThree[2]);
                    animateKey((Button) this.view.findViewById(R.id.bx));
                } else if (d4 < 318.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayThree[3]);
                    animateKey((Button) this.view.findViewById(R.id.bc));
                } else if (d4 < 398.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayThree[4]);
                    animateKey((Button) this.view.findViewById(R.id.bv));
                } else if (d4 < 478.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayThree[5]);
                    animateKey((Button) this.view.findViewById(R.id.bb));
                } else if (d4 < 558.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayThree[6]);
                    animateKey((Button) this.view.findViewById(R.id.bn));
                } else if (d4 < 638.5d) {
                    this.keyPressCallback.onkeyPress(this.keyArrayThree[7]);
                    animateKey((Button) this.view.findViewById(R.id.bm));
                } else if (i > 642) {
                    animateBackSpace((LinearLayout) this.view.findViewById(R.id.btn_space));
                    this.keyPressCallback.onEnter();
                }
            }
        }
        if (!this.touchKeyboard.booleanValue()) {
            if (touchPoint.y >= this.keyboarStarting_y_axis && touchPoint.y <= this.keyboarStarting_y_axis + 71) {
                double d5 = touchPoint.x;
                if (d5 < 78.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[0]);
                    animateKey((Button) this.view.findViewById(R.id.btn_1));
                } else if (d5 < 158.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[1]);
                    animateKey((Button) this.view.findViewById(R.id.btn_2));
                } else if (d5 < 238.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[2]);
                    animateKey((Button) this.view.findViewById(R.id.btn_3));
                } else if (d5 < 318.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[3]);
                    animateKey((Button) this.view.findViewById(R.id.btn_4));
                } else if (d5 < 398.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[4]);
                    animateKey((Button) this.view.findViewById(R.id.btn_5));
                } else if (d5 < 478.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[5]);
                    animateKey((Button) this.view.findViewById(R.id.btn_6));
                } else if (d5 < 558.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[6]);
                    animateKey((Button) this.view.findViewById(R.id.btn_7));
                } else if (d5 < 638.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[7]);
                    animateKey((Button) this.view.findViewById(R.id.btn_8));
                } else if (d5 < 753.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[8]);
                    animateKey((Button) this.view.findViewById(R.id.btn_9));
                } else if (d5 < 798.5d) {
                    this.keyPressCallback.onkeyPress(this.numArray[9]);
                    animateKey((Button) this.view.findViewById(R.id.btn_0));
                }
            } else if (touchPoint.y > this.keyboarStarting_y_axis + 71 && touchPoint.y < this.keyboarStarting_y_axis + 141) {
                double d6 = touchPoint.x;
                if (d6 > 41.5d && d6 < 118.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[0]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s1));
                } else if (d6 < 198.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[1]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s2));
                } else if (d6 < 278.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[2]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s3));
                } else if (d6 < 358.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[3]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s4));
                } else if (d6 < 453.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[4]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s5));
                } else if (d6 < 518.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[5]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s6));
                } else if (d6 < 598.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[6]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s7));
                } else if (d6 < 678.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[7]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s8));
                } else if (d6 < 758.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayTwo[8]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s9));
                }
            } else if (touchPoint.y > this.keyboarStarting_y_axis + 142 && touchPoint.y < this.keyboarStarting_y_axis + Mp4VideoDirectory.TAG_GRAPHICS_MODE) {
                int i2 = touchPoint.x;
                double d7 = i2;
                if (d7 < 78.5d) {
                    animateKey((Button) this.view.findViewById(R.id.btn_s10));
                } else if (d7 < 158.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayThree[1]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s11));
                } else if (d7 < 238.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayThree[2]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s12));
                } else if (d7 < 318.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayThree[3]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s13));
                } else if (d7 < 398.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayThree[4]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s14));
                } else if (d7 < 478.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayThree[5]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s15));
                } else if (d7 < 558.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayThree[6]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s16));
                } else if (d7 < 638.5d) {
                    this.keyPressCallback.onkeyPress(this.numArrayThree[7]);
                    animateKey((Button) this.view.findViewById(R.id.btn_s17));
                } else if (i2 > 642) {
                    animateBackSpace((LinearLayout) this.view.findViewById(R.id.btn_enter_2));
                    this.keyPressCallback.onEnter();
                }
            }
        }
    }

    private synchronized void animateKey(final Button button) {
        button.setBackground(AppCompatResources.getDrawable(this.context, R.drawable.focus_key_background));
        UdpServerService.executors.schedule(new TimerTask() { // from class: com.bajajconnect.wifi.views.CustomKeyboard.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    button.setBackground(AppCompatResources.getDrawable(CustomKeyboard.this.context, R.drawable.key_background));
                    StreamingImageHandler.navigationSearchScreen.updateImage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 200L, TimeUnit.MILLISECONDS);
    }

    private synchronized void animateBackSpace(final LinearLayout linearLayout) {
        linearLayout.setBackground(AppCompatResources.getDrawable(this.context, R.drawable.focus_key_background));
        UdpServerService.executors.schedule(new TimerTask() { // from class: com.bajajconnect.wifi.views.CustomKeyboard.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                try {
                    linearLayout.setBackground(AppCompatResources.getDrawable(CustomKeyboard.this.context, R.drawable.key_background));
                    StreamingImageHandler.navigationSearchScreen.updateImage();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 200L, TimeUnit.MILLISECONDS);
    }

    public void registerKeyboardCallback(KeyPressCallback keyPressCallback) {
        this.keyPressCallback = keyPressCallback;
    }
}
