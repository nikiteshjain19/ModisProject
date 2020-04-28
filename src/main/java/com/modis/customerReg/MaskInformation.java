package com.modis.customerReg;

public class MaskInformation {

    /**
     * @param email: string
     * @return masked string
     *  This method uses regex pattern to mask everything but first and last char before @ to *
     */
    private String maskEmail(String email){
        return email.replaceAll("(?<=.{1}).(?=[^@]*?.@)", "*");
    }

    /**
     * @param number : string
     * @return masked string
     *  This method uses regex pattern to mask everything except first 3 digits and last 4 digits.
     */
    private String maskPhoneNumber(String number){
        return number.replaceAll("(?<=.{3}).(?=.{4})", "*");
    }

    /**
     * @param email : string
     * @return boolean
     *  Checks if input is a valid email id
     */
    private Boolean isEmailValid(String email){
        if (email.split("@")[0].length() > 0){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    /**
     * @param number : string
     * @return boolean
     *  Checks if input is a valid phone number
     */
    private Boolean isPhoneNumberlValid(String number){
        if (number.length() == 10){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

    /**
     * @param contactInfo : string
     * @return masked string
     *  This method identifies if the given string is an emailId or a phoneNumber.
     *  Checks if its a valid email address.
     *  Assumes phone number is of length 10 with country code.
     */
    public String maskContactInfo(String contactInfo) throws Exception {
        if (contactInfo.length() != 0) {
            if (contactInfo.contains("@")){
                if (isEmailValid(contactInfo)) {
                    return maskEmail(contactInfo);
                }
            }else if (isPhoneNumberlValid(contactInfo)){
                return maskPhoneNumber(contactInfo);
            }
        }
        throw new Exception("Invalid input.");
    }
}

