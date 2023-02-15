/*
 * Copyright (C) 2007 - 2023 SafeCharge International Group Limited.
 */

package com.safecharge.model;

import javax.validation.Valid;

/**
 * <p>
 * Local payment info specific for some clients. Part of {@link Addendums}.
 *
 * @author <a mailto:bozhidarsh@safecharge.com>Bozhidar Shumanov</a>
 * @see Addendums
 * @since 8/8/2018
 */
public class AddendumsAirlines {

    @Valid
    private AddendumsAirlinesReservationDetails reservationDetails;

    public AddendumsAirlinesReservationDetails getReservationDetails() {
        return reservationDetails;
    }

    public void setReservationDetails(AddendumsAirlinesReservationDetails reservationDetails) {
        this.reservationDetails = reservationDetails;
    }
}
