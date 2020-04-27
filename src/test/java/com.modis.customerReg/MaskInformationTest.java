package com.modis.customerReg;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaskInformationTest {

    MaskInformation maskInformation = new MaskInformation();

    @Test
    public void testEmailMasking() {
        String result = null;
        try {
            result = maskInformation.maskContactInfo("something@gmail.com");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("s*******g@gmail.com", result);
    }

    @Test
    public void testPhoneNumberMasking() {
        String result = null;
        try {
            result = maskInformation.maskContactInfo("9877636354");
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("987***6354", result);
    }

    @Test(expected = Exception.class)
    public void testEmptyString() throws Exception {
        maskInformation.maskContactInfo("");
    }

    @Test(expected = Exception.class)
    public void testWithoutUserNameInEmailAddress() throws Exception {
        maskInformation.maskContactInfo("@gmail.com");
    }

    @Test(expected = Exception.class)
    public void testInvalidPhNumberLength() throws Exception {
        maskInformation.maskContactInfo("01234567891");
    }
}
