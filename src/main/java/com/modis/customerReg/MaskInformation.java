package com.modis.customerReg;

public class MaskInformation {
    private String maskEmail(String email){
        return email.replaceAll("(?<=.{1}).(?=[^@]*?.@)", "*");
    }

    private String maskPhoneNumber(String number){
        return number.replaceAll("(?<=.{3}).(?=.{4})", "*");
    }

    public String maskContactInfo(String contactInfo) throws Exception {
        if (contactInfo.length() != 0) {
            if (contactInfo.contains("@")){
                if (contactInfo.split("@")[0].length() > 0) {
                    return maskEmail(contactInfo);
                }
                // we are looking out for 10 because we are assuming we will get number without country code.
                // We can add additional logic for country code.
            }else if (contactInfo.length() == 10){
                return maskPhoneNumber(contactInfo);
            }
        }
        throw new Exception("Invalid input.");
    }
}

