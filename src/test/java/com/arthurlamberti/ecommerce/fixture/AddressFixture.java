package com.arthurlamberti.ecommerce.fixture;

import com.arthurlamberti.ecommerce.enums.UserTypeEnum;
import com.arthurlamberti.ecommerce.vo.address.CreateAddressRequest;

public class AddressFixture {

    public static CreateAddressRequest createAddressRequest() {
        return new CreateAddressRequest(
                "country", "state", "city", "street", "04123", "123", "", UserTypeEnum.CUSTOMER
        );
    }

}
