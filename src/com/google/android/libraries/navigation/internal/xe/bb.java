package com.google.android.libraries.navigation.internal.xe;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.libraries.navigation.TermsAndConditionsCheckOption;
import com.google.android.libraries.navigation.TermsAndConditionsUIParams;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bb extends DialogFragment {
    public static final ba d = new ba();
    public String a;
    public String b;
    public TermsAndConditionsUIParams c;
    private final com.google.android.libraries.navigation.internal.xd.a e;
    private final TermsAndConditionsCheckOption f;
    private AlertDialog g;
    private View h;
    private final gj i;

    public bb() {
        this.e = null;
        this.i = null;
        this.f = null;
    }

    private final CharSequence b(Activity activity, boolean z) {
        Context applicationContext;
        ApplicationInfo applicationInfo;
        PackageManager packageManager;
        az azVar = new az(activity, String.format("https://www.google.com/intl/%s/help/terms_maps/", com.google.android.libraries.navigation.internal.kj.b.a(Locale.getDefault())));
        az azVar2 = new az(activity, "https://myaccount.google.com/privacypolicy");
        az azVar3 = new az(activity, String.format("https://support.google.com/maps/answer/10565726?hl=%s", com.google.android.libraries.navigation.internal.kj.b.a(Locale.getDefault())));
        com.google.android.libraries.navigation.internal.hf.n nVar = new com.google.android.libraries.navigation.internal.hf.n(activity.getResources());
        CharSequence string = this.a;
        if (string == null && ((applicationContext = activity.getApplicationContext()) == null || (applicationInfo = applicationContext.getApplicationInfo()) == null || (packageManager = applicationContext.getPackageManager()) == null || (string = packageManager.getApplicationLabel(applicationInfo)) == null)) {
            string = activity.getString(com.google.android.libraries.navigation.internal.jg.a.b);
        }
        if (!z) {
            com.google.android.libraries.navigation.internal.hf.l lVarE = nVar.e(com.google.android.libraries.navigation.internal.jg.a.f);
            com.google.android.libraries.navigation.internal.hf.l lVarE2 = nVar.e(com.google.android.libraries.navigation.internal.jg.a.j);
            lVarE2.h(azVar);
            com.google.android.libraries.navigation.internal.hf.l lVarE3 = nVar.e(com.google.android.libraries.navigation.internal.jg.a.i);
            lVarE3.h(azVar2);
            lVarE.a(lVarE2, lVarE3, string, string);
            return lVarE.b();
        }
        com.google.android.libraries.navigation.internal.hf.l lVarE4 = nVar.e(com.google.android.libraries.navigation.internal.jg.a.e);
        com.google.android.libraries.navigation.internal.hf.l lVarE5 = nVar.e(com.google.android.libraries.navigation.internal.jg.a.g);
        lVarE5.g();
        com.google.android.libraries.navigation.internal.hf.l lVarE6 = nVar.e(com.google.android.libraries.navigation.internal.jg.a.a);
        lVarE6.h(azVar3);
        com.google.android.libraries.navigation.internal.hf.l lVarE7 = nVar.e(com.google.android.libraries.navigation.internal.jg.a.h);
        lVarE7.g();
        lVarE4.a(lVarE5, string, lVarE6, lVarE7);
        return lVarE4.b();
    }

    private final boolean c() {
        return this.e == null && this.i == null && this.f == null;
    }

    final void a(boolean z) {
        TermsAndConditionsCheckOption termsAndConditionsCheckOption = TermsAndConditionsCheckOption.ENABLED;
        if (!c()) {
            this.e.e();
        }
        if (c()) {
            return;
        }
        this.i.a(z);
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        a(this.f == TermsAndConditionsCheckOption.SKIPPED);
    }

    @Override // android.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        setRetainInstance(true);
        if (c()) {
            AlertDialog alertDialogCreate = new AlertDialog.Builder(getActivity()).setMessage(com.google.android.libraries.navigation.internal.jg.a.l).setPositiveButton(com.google.android.libraries.navigation.internal.jg.a.k, new DialogInterface.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.xe.aw
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.a.getActivity().finishAndRemoveTask();
                    System.exit(0);
                }
            }).create();
            this.g = alertDialogCreate;
            alertDialogCreate.setCanceledOnTouchOutside(false);
            return this.g;
        }
        View viewInflate = getActivity().getLayoutInflater().inflate(com.google.android.libraries.navigation.internal.f.f.a, (ViewGroup) null, false);
        this.h = viewInflate;
        TextView textView = (TextView) viewInflate.findViewById(com.google.android.libraries.navigation.internal.f.e.b);
        String string = this.b;
        if (string == null) {
            string = getActivity().getString(com.google.android.libraries.navigation.internal.jg.a.m);
        }
        textView.setText(string);
        ((TextView) this.h.findViewById(com.google.android.libraries.navigation.internal.f.e.a)).setText(getActivity().getString(com.google.android.libraries.navigation.internal.jg.a.c));
        AlertDialog.Builder view = new AlertDialog.Builder(getActivity()).setView(this.h);
        if (this.f == TermsAndConditionsCheckOption.ENABLED) {
            TextView textView2 = (TextView) this.h.findViewById(com.google.android.libraries.navigation.internal.f.e.h);
            textView2.setText(b(getActivity(), true));
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            TextView textView3 = (TextView) this.h.findViewById(com.google.android.libraries.navigation.internal.f.e.g);
            textView3.setText(b(getActivity(), false));
            textView3.setMovementMethod(LinkMovementMethod.getInstance());
            view.setPositiveButton(com.google.android.libraries.navigation.internal.jg.a.d, new DialogInterface.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.xe.ax
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.a.a(true);
                }
            });
        } else {
            view.setPositiveButton(com.google.android.libraries.navigation.internal.jg.a.d, new DialogInterface.OnClickListener() { // from class: com.google.android.libraries.navigation.internal.xe.ay
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.a.a(true);
                }
            });
        }
        AlertDialog alertDialogCreate2 = view.create();
        this.g = alertDialogCreate2;
        alertDialogCreate2.setCanceledOnTouchOutside(this.f == TermsAndConditionsCheckOption.SKIPPED);
        return this.g;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
        TermsAndConditionsUIParams termsAndConditionsUIParams = this.c;
        if (termsAndConditionsUIParams == null || c()) {
            return;
        }
        AlertDialog alertDialog = this.g;
        View view = this.h;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(termsAndConditionsUIParams.backgroundColor));
        view.setBackgroundColor(termsAndConditionsUIParams.backgroundColor);
        TextView textView = (TextView) view.findViewById(com.google.android.libraries.navigation.internal.f.e.b);
        textView.setTextColor(termsAndConditionsUIParams.titleColor);
        textView.setTypeface(termsAndConditionsUIParams.titleTypeface);
        textView.setTextSize(termsAndConditionsUIParams.titleTextSize);
        TextView textView2 = (TextView) view.findViewById(com.google.android.libraries.navigation.internal.f.e.a);
        textView2.setTextColor(termsAndConditionsUIParams.mainTextColor);
        textView2.setTypeface(termsAndConditionsUIParams.mainTextTypeface);
        textView2.setTextSize(termsAndConditionsUIParams.mainTextTextSize);
        TextView textView3 = (TextView) view.findViewById(com.google.android.libraries.navigation.internal.f.e.g);
        textView3.setTextColor(termsAndConditionsUIParams.mainTextColor);
        textView3.setTypeface(termsAndConditionsUIParams.mainTextTypeface);
        textView3.setTextSize(termsAndConditionsUIParams.mainTextTextSize);
        Button button = alertDialog.getButton(-1);
        button.setTextColor(termsAndConditionsUIParams.acceptButtonTextColor);
        button.setTypeface(termsAndConditionsUIParams.buttonsTypeface);
        button.setTextSize(termsAndConditionsUIParams.buttonsTextSize);
        Button button2 = alertDialog.getButton(-2);
        button2.setTextColor(termsAndConditionsUIParams.cancelButtonTextColor);
        button2.setTypeface(termsAndConditionsUIParams.buttonsTypeface);
        button2.setTextSize(termsAndConditionsUIParams.buttonsTextSize);
    }

    public bb(com.google.android.libraries.navigation.internal.xd.a aVar, gj gjVar, TermsAndConditionsCheckOption termsAndConditionsCheckOption) {
        this.e = aVar;
        this.i = gjVar;
        this.f = termsAndConditionsCheckOption;
    }
}
