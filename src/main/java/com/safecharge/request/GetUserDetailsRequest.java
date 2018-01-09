package com.safecharge.request;

import com.safecharge.request.basic.BaseCashierUserRequest;
import com.safecharge.util.Constants;
import com.safecharge.util.ValidChecksum;

@ValidChecksum(orderMappingName = Constants.ChecksumOrderMapping.GET_CASHIER_USER_INFO)
public class GetUserDetailsRequest extends BaseCashierUserRequest {

}
