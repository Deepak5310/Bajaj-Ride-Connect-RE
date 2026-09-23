package com.bajajconnect.navigate.viewmodel;

import androidx.lifecycle.ViewModel;
import com.mappls.sdk.services.api.autosuggest.model.ELocation;
import com.mappls.sdk.services.api.directions.models.DirectionsResponse;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RouteViewModel extends ViewModel {
    private ELocation eLocation;
    private List<ELocation> eLocations;
    private String fromLocation;
    private int selectedIndex = 0;
    private DirectionsResponse trip;

    public ELocation geteLocation() {
        return this.eLocation;
    }

    public void seteLocation(ELocation eLocation) {
        this.eLocation = eLocation;
    }

    public DirectionsResponse getTrip() {
        return this.trip;
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public void setSelectedIndex(int i) {
        this.selectedIndex = i;
    }

    public void setTrip(DirectionsResponse directionsResponse) {
        this.trip = directionsResponse;
    }

    public List<ELocation> geteLocations() {
        return this.eLocations;
    }

    public void seteLocations(List<ELocation> list) {
        this.eLocations = list;
    }

    public String getFromLocation() {
        return this.fromLocation;
    }

    public void setFromLocation(String str) {
        this.fromLocation = str;
    }
}
