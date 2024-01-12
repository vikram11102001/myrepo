package com.myproject.business;

import com.myproject.entities.CustomerEntity;
import com.myproject.exception.MastercardNotAllowedException;
import com.myproject.model.KarnatakaPincodes;
import com.myproject.model.KeralaPincodes;
import com.myproject.model.TamilnaduPincodes;

public class CustomerBusiness {

    public String saveCust(CustomerEntity cust) {
        String customerPincode = cust.getPinCode(); 
        if (isPincodeInTamilnadu(customerPincode)) {
            throw new MastercardNotAllowedException("Mastercard not allowed for Tamilnadu customers.");
        }

        

        return "Customer saved successfully";
    }

    private boolean isPincodeInTamilnadu(String pincode) {
        for (TamilnaduPincodes tamilnaduPin : TamilnaduPincodes.values()) {
            if (tamilnaduPin.equals(pincode)) {
                return true;
            }
        }
        return false;
    }
    
}
