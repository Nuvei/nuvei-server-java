# Safecharge REST API SDK for Java

SafeCharge’s REST API SDK for Java provides developer tools for accessing Safecharge's API. Safecharge API is a simple, easy to use, secured and stateless API. 
                                                                                                     It is an online solution which enables merchants selling products and services over the web to process online customer payments etc. though SafeCahrge’s payments gateway.
                                                                                                     It supports both PCI and non-PCI certified merchants, both online and mobile merchants applications and offer a large verity of payment options: cards, alternative payment methods etc.  

## Requirements

Java 1.7 or later.

### Maven

If your application is going to be deployed on a Java EE server add the following dependency:

```xml
<dependency>    
    <groupId>com.safecharge</groupId>
    <artifactId>safecharge-retail-sdk-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

If you are going to use the SDK in Java SE or a non Java EE server please add a Bean Validation API Implementation dependency. Certified implementations of Bean Validation API can be found here: http://beanvalidation.org/1.1/certified/. 

For example:

 ```xml
<dependency>    
    <groupId>com.safecharge</groupId>
    <artifactId>safecharge-retail-sdk-java</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
<dependency>
    <groupId>org.apache.bval</groupId>
    <artifactId>bval-jsr</artifactId>
    <version>1.1.2</version>
</dependency>
 ```

## Running your first request

You only need to setup a HTTP Client and to provide the SafeCharge API host to the request executor and then you can start building requests and send them to the SafeCharge API. 

Check how simple it is trough this sample:

```java
import com.safecharge.retail.biz.SafechargeConfiguration;
import com.safecharge.retail.biz.SafechargeHttpClient;
import com.safecharge.retail.biz.SafechargeRequestExecutor;
import com.safecharge.retail.model.MerchantInfo;
import com.safecharge.retail.request.GetSessionTokenRequest;
import com.safecharge.retail.request.SafechargeRequest;
import com.safecharge.retail.response.SafechargeResponse;
import com.safecharge.retail.util.APIConstants;
import com.safecharge.retail.util.Constants;

public class Sample {

    public static void main(String[] args) {
        SafechargeRequestExecutor requestExecutor = SafechargeRequestExecutor.getInstance();

        MerchantInfo merchantInfo = new MerchantInfo("MERCHANT_KEY_PROVIDED_BY_SAFECHARGE", "MERCHANT_ID_PROVIDED_BY_SAFECHARGE",
                "MERCHANT_SITE_ID_PROVIDED_BY_SAFECHARGE", Constants.HashAlgorithm.SHA256);

        SafechargeConfiguration.init(merchantInfo, APIConstants.INTEGRATION_HOST, SafechargeHttpClient.createDefault());

        SafechargeRequest safechargeRequest = new GetSessionTokenRequest.Builder().build();

        SafechargeResponse response = requestExecutor.executeRequest(safechargeRequest);
        System.out.println("Received sessionToken = " + response.getSessionToken());
    }
}
```
More samples tests can be found [here](https://github.com/SafechargeBulgaria/safecharge-retail-java/tree/master/src/test/java/com/safecharge/retail/test/workflow/).