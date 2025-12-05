/*
 * Copyright (C) 2007 - 2024 Nuvei Corporation.
 */

package com.nuvei.model;

import javax.validation.Valid;

/**
 * <p>
 * Local payment info specific for some clients. Part of {@link Addendums}.
 *
 * @author <a mailto:bozhidarsh@nuvei.com>Bozhidar Shumanov</a>
 * @see Addendums
 * @since 8/8/2018
 */
public class AddendumsAirlines {

    @Valid
    private AddendumsAirlinesReservationDetails reservationDetails;

    private String ancillaryServicesInfo;

    public AddendumsAirlinesReservationDetails getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(AddendumsAirlinesReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
    }

    public String getAncillaryServicesInfo() {
        return ancillaryServicesInfo;
    }

    public void setAncillaryServicesInfo(String ancillaryServicesInfo) {
        this.ancillaryServicesInfo = ancillaryServicesInfo;
    }
}
