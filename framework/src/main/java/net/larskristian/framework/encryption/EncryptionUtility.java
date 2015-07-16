package net.larskristian.framework.encryption;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @author Lars K. Johansen
 */
public final class EncryptionUtility {

    enum HashAlgorithm {
        MD5, SHA1, SHA256, SHA384, SHA512
    }

    private static final HashAlgorithm CURRENT_ALGORITHM = HashAlgorithm.SHA1;

    private EncryptionUtility() {
        // Utility class
    }

    public static String hash(String string) {
        switch (CURRENT_ALGORITHM) {
            case MD5:
                return DigestUtils.md5Hex(string);
            case SHA1:
                return DigestUtils.sha1Hex(string);
            case SHA256:
                return DigestUtils.sha256Hex(string);
            case SHA384:
                return DigestUtils.sha384Hex(string);
            case SHA512:
                return DigestUtils.sha512Hex(string);
            default:
                return DigestUtils.sha1Hex(string);
        }
    }

}
