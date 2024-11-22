# SafeCharge REST API SDK for Java.

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.safecharge/safecharge-sdk-java/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.safecharge/safecharge-sdk-java)
[![codecov](https://codecov.io/gh/SafeChargeInternational/safecharge-java/branch/development/graph/badge.svg)](https://codecov.io/gh/SafeChargeInternational/safecharge-java)

SafeCharge’s REST API SDK for Java provides developer tools for accessing Safecharge's REST API. SafeCharge’s REST API is a simple, easy to use, secure and stateless API, which enables online merchants and service providers to process consumer payments through SafeCharge’s payment gateway. The API supports merchants of all levels of PCI certification, from their online and mobile merchant applications, and is compatible with a large variety of payment options, i.e. payment cards, alternative payment methods, etc. For SafeCharge REST API documentation, please see: https://www.safecharge.com/docs/api/
 
## Requirements

Java 1.7 or later.

### Maven

If your application is going to be deployed on a Java EE server add the following dependency:

```xml
<dependency>    
    <groupId>com.safecharge</groupId>
    <artifactId>safecharge-sdk-java</artifactId>
    <version>1.7.11</version>
</dependency>
```

If you are going to use the SDK in Java SE or a non Java EE server please add a Bean Validation API Implementation dependency. Certified implementations of Bean Validation API can be found here: http://beanvalidation.org/certified/ (v.1.1 implementation required). 

For example:

 ```xml
<dependencies>
    ...
    <dependency>    
        <groupId>com.safecharge</groupId>
        <artifactId>safecharge-sdk-java</artifactId>
        <version>1.7.11</version>
    </dependency>
    <dependency>
        <groupId>org.apache.bval</groupId>
        <artifactId>bval-jsr</artifactId>
        <version>1.1.2</version>
    </dependency>
</dependencies>
 ```

## Running your first request

You only need to setup a HTTP Client and to provide the SafeCharge API host to the request executor and then you can start building requests and send them to the SafeCharge API. 

Check how simple it is trough this sample:

```java
import com.safecharge.biz.SafechargeRequestExecutor;
import com.safecharge.model.MerchantInfo;
import com.safecharge.request.GetSessionTokenRequest;
import com.safecharge.request.SafechargeRequest;
import com.safecharge.response.SafechargeResponse;
import com.safecharge.util.APIConstants;
import com.safecharge.util.Constants;

public class Sample {

    public static void main(String[] args) {
        SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

        MerchantInfo merchantInfo = new MerchantInfo("MERCHANT_KEY_PROVIDED_BY_SAFECHARGE", "MERCHANT_ID_PROVIDED_BY_SAFECHARGE",
                "MERCHANT_SITE_ID_PROVIDED_BY_SAFECHARGE", APIConstants.INTEGRATION_HOST, Constants.HashAlgorithm.SHA256);

        SafechargeBaseRequest safechargeRequest = GetSessionTokenRequest.builder()
                                                                    .addMerchantInfo(merchantInfo)
                                                                    .build();

        SafechargeResponse response = requestExecutor.executeRequest(safechargeRequest);
        System.out.println("Received sessionToken = " + response.getSessionToken());
    }
}
```
More samples tests can be found [here](https://github.com/SafeChargeInternational/safecharge-java/tree/master/src/test/java/com/safecharge/test/workflow/).
