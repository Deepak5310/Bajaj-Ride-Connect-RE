package com.mappls.sdk.services.api.directions.predictive;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class MapplsDirectionDateTimeSpecified implements MapplsDirectionDateTime {
    private Long timeInMillis;
    private Integer type;

    public MapplsDirectionDateTimeSpecified(Integer num, Long l) {
        this.type = num;
        this.timeInMillis = l;
    }

    @Override // com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTime
    public Integer type() {
        return this.type;
    }

    @Override // com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTime
    public String dateTime() {
        return new SimpleDateFormat("yyyy-MM-dd'T'hh:mm").format(new Date(this.timeInMillis.longValue()));
    }

    @Override // com.mappls.sdk.services.api.directions.predictive.MapplsDirectionDateTime
    public String dateTimeInMillis() {
        return (this.timeInMillis.longValue() / 1000) + "";
    }
}
