package com.las.learn.h264;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * @author las
 * @date 18-10-23
 */
public class H264Test {

    @Test
    public void testProfile() {
        //profile-level-id=4D001F;sprop-parameter-sets=Z00AH9oBQBbpUgAAAwACAAADAGTAgAC7fgAD9H973wvCIRqA,aM48gA==
        String sps = "Z00AH9oBQBbpUgAAAwACAAADAGTAgAC7fgAD9H973wvCIRqA";
        String profile = "4D001F";
        byte[] spsBytes = Base64.decodeBase64(sps);
        System.out.println(Hex.encodeHexString(spsBytes));
        System.out.println(new byte[6].length);
    }
}
