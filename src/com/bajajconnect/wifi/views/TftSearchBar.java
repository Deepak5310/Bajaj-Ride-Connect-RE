package com.bajajconnect.wifi.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.bajajconnect.R;

/* JADX INFO: loaded from: classes3.dex */
public class TftSearchBar {
    final Context context;
    public String searchInput = "";
    public boolean showBack = true;
    public EditText textView;
    private final View view;

    public TftSearchBar(Context context) {
        this.context = context;
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.tft_search_bar_item, (ViewGroup) null);
        this.view = viewInflate;
        viewInflate.measure(View.MeasureSpec.getSize(viewInflate.getMeasuredWidth()), View.MeasureSpec.getSize(viewInflate.getMeasuredHeight()));
        viewInflate.layout(0, 105, 800, 188);
        iniVariables();
    }

    public View getView(boolean z) {
        this.showBack = z;
        if (!z) {
            ((ImageView) this.view.findViewById(R.id.text_back_btn)).setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.tft_keyboard_hidden_icon, null));
        } else {
            ((ImageView) this.view.findViewById(R.id.text_back_btn)).setImageDrawable(ResourcesCompat.getDrawable(this.context.getResources(), R.drawable.tft_text_back_icon, null));
        }
        return this.view;
    }

    private void iniVariables() {
        EditText editText = (EditText) this.view.findViewById(R.id.search_text);
        this.textView = editText;
        editText.requestFocus();
    }

    public void addText(String str) {
        if (this.textView != null) {
            String str2 = this.searchInput + str;
            this.searchInput = str2;
            this.textView.setText(str2);
            EditText editText = this.textView;
            editText.setSelection(editText.getText().length());
        }
    }

    public void removeOneCharacter() {
        if (this.showBack) {
            if (this.textView != null) {
                if (this.searchInput.length() > 1) {
                    String str = this.searchInput;
                    this.searchInput = str.substring(0, str.length() - 1);
                } else {
                    this.searchInput = "";
                }
                this.textView.setText(this.searchInput);
                EditText editText = this.textView;
                editText.extendSelection(editText.getText().length());
                return;
            }
            return;
        }
        if (NavigationSearchScreen.isKeyboardOpen) {
            return;
        }
        NavigationSearchScreen.isKeyboardOpen = true;
        NavigationSearchScreen.searchResultAvailable = false;
    }

    public String getSearchInput() {
        return this.searchInput;
    }
}
