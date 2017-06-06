import com.safecharge.biz.SafechargeRequestExecutor;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.CancelSubscriptionRequest;
import com.safecharge.request.CreateSubscriptionRequest;
import com.safecharge.request.GetSubscriptionListRequest;
import com.safecharge.request.GetSubscriptionPlansRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.response.CreateSubscriptionResponse;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.util.Constants;

/**
 * Copyright (C) 2007-2017 SafeCharge International Group Limited.
 *
 * @author <a mailto:nikolad@safecharge.com>Nikola Dichev</a>
 * @since 6/6/2017
 */
public class TestClass {

    public static void main(String[] args) {
        MerchantInfo merchantInfo = new MerchantInfo("KjAZp2gfHN4PJf4mWJUmBmJkfltxycYF7JYQJCOK2ZOaeGQGAA6GI0eg2WXgxXZDY", "5137702336228767168", "23",
                "http://192.168.103.237:8080/ppp/", Constants.HashAlgorithm.MD5);

        SafechargeRequest getSubscriptionPlansRequest = GetSubscriptionPlansRequest.builder()
                                                                                   .addMerchantInfo(merchantInfo)
                                                                                   .build();

        SafechargeResponse response = SafechargeRequestExecutor.getInstance()
                                                               .executeRequest(getSubscriptionPlansRequest);

        System.out.println(response);

        SafechargeRequest getSubscriptionsList = GetSubscriptionListRequest.builder()
                                                                           .addMerchantInfo(merchantInfo)
                                                                           .addUserTokenId("Test_0065")
                                                                           .addFirstResult(10)
                                                                           .addMaxResults(100)
                                                                           .build();
        response = SafechargeRequestExecutor.getInstance()
                                            .executeRequest(getSubscriptionsList);

        System.out.println(response);

        SafechargeRequest createSubscriptionRequest = CreateSubscriptionRequest.builder()
                                                                               .addMerchantInfo(merchantInfo)
                                                                               .addUserTokenId("Test_0065")
                                                                               .addSubscriptionPlanId("62306")
                                                                               .addCardData("4012001037141112", "Ime Ime", "05", "2020", null, "567")
                                                                               .addDeviceDetails("SMARTPHONE", "iPhone 5s", "iOS 10.2", "browser",
                                                                                       "192.168.102.155")
                                                                               .addUserDetails("3531 Passaic Street 5", "California", null,
                                                                                       "testthat@mail.com", "NaiNovo", "NaiNovo", "202-252-1266",
                                                                                       null, null)
                                                                               .addDynamicDescriptor("API testMERCHANT", "897512344")
                                                                               .addURLDetails(
                                                                                       "https://srv-bsf-devppptrunk.gw-4u.com/ppp/defaultCancel.do",
                                                                                       "https://srv-bsf-devppptrunk.gw-4u.com/ppp/defaultPending.do",
                                                                                       "https://srv-bsf-devppptrunk.gw-4u.com/ppp/defaultSuccess.do",
                                                                                       "https://olga.com")
                                                                               .build();
        response = SafechargeRequestExecutor.getInstance()
                                            .executeRequest(createSubscriptionRequest);

        System.out.println(response);

        SafechargeRequest cancelSubscriptionRequest = CancelSubscriptionRequest.builder()
                                                                               .addMerchantInfo(merchantInfo)
                                                                               .addUserTokenId("Test_0065")
                                                                               .addSubscriptionId(
                                                                                       ((CreateSubscriptionResponse) response).getSubscriptionId())
                                                                               .build();
        response = SafechargeRequestExecutor.getInstance()
                                            .executeRequest(cancelSubscriptionRequest);

        System.out.println(response);
    }

}
