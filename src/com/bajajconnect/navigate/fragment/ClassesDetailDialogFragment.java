package com.bajajconnect.navigate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bajajconnect.R;
import com.mappls.sdk.navigation.MapplsNavigationHelper;
import com.mappls.sdk.services.api.directions.models.RouteClasses;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class ClassesDetailDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.routeSummaryDialog);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().requestFeature(1);
            getDialog().getWindow().setLayout(-2, -2);
        }
        return layoutInflater.inflate(R.layout.fragment_classes_detail, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        TextView textView = (TextView) view.findViewById(R.id.tv_route_class_detail);
        if (MapplsNavigationHelper.getInstance().getCurrentRoute() != null && MapplsNavigationHelper.getInstance().getCurrentRoute().routeClasses() != null) {
            RouteClasses routeClasses = MapplsNavigationHelper.getInstance().getCurrentRoute().routeClasses();
            ArrayList arrayList = new ArrayList();
            if (routeClasses.toll() != null && routeClasses.toll().intValue() == 1) {
                arrayList.add("Toll");
            }
            if (routeClasses.ferry() != null && routeClasses.ferry().intValue() == 1) {
                arrayList.add("Ferry");
            }
            if (routeClasses.ferry() != null && routeClasses.ferry().intValue() == 1) {
                arrayList.add("Tunnel");
            }
            if (routeClasses.motorway() != null && routeClasses.motorway().intValue() == 1) {
                arrayList.add("Motorway");
            }
            if (routeClasses.restricted() != null && routeClasses.restricted().intValue() == 1) {
                arrayList.add("Restricted");
            }
            if (arrayList.size() > 0) {
                StringBuilder sb = new StringBuilder("This route contains ");
                if (arrayList.size() == 1) {
                    sb.append((String) arrayList.get(0));
                } else {
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (i == arrayList.size() - 1) {
                            sb.append(" & ");
                            sb.append((String) arrayList.get(i));
                        } else if (i == 0) {
                            sb.append((String) arrayList.get(i));
                        } else {
                            sb.append(", ");
                            sb.append((String) arrayList.get(i));
                        }
                    }
                }
                textView.setText(sb.toString());
                return;
            }
            textView.setText("This route does not contains any classes");
            return;
        }
        textView.setText("This route does not contains any classes");
    }
}
