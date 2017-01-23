package liuyanwei.com.rasdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runRSA();
    }

    public void runRSA(){
        Log.d("main","verify RSA ");

        //公钥文件rsa_public_key.pem
        //私钥文件pkcs8_private_key.pem

//        String public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDJ6/x+Iyaxqb754H8vRL4y+hlQ\n" +
//                            "0rqXxWstpRMI/4SQDlpSYRu7M4Q7SvRs1yzVVV4k0sVg7U+pgm1r5mkKNj3wGlfs\n" +
//                            "Je5vqjcKqrUDzNGLq0x7oKHDK/LmOOtmi8Tt10laE5PCEn77V54u5IsNRIkvmcL2\n" +
//                            "48sYmUx80UIWIz8+gQIDAQAB";
//
//
//        String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAMnr/H4jJrGpvvng\n" +
//                            "fy9EvjL6GVDSupfFay2lEwj/hJAOWlJhG7szhDtK9GzXLNVVXiTSxWDtT6mCbWvm\n" +
//                            "aQo2PfAaV+wl7m+qNwqqtQPM0YurTHugocMr8uY462aLxO3XSVoTk8ISfvtXni7k\n" +
//                            "iw1EiS+ZwvbjyxiZTHzRQhYjPz6BAgMBAAECgYBDb0N44MZoaRc1nkr7f0rB/ZJ8\n" +
//                            "0pOsYiskKFAOHj+oWJLDlljLkS3lG2g7/TSk3oi9ZYKzly2Wn89pTJ7h4TGXqGXV\n" +
//                            "LPFwpx/VTrcKsxBPKWu7V6qpuyfNLoEkE42kNBAnGKKwdzS7g9rOTwN316I9B+nm\n" +
//                            "9xI8jq/DiQcoe4R+QQJBAP8dvgv2H6IJBiZlbvbvb+oEc7rz8mSiIE7oJ2g7ZoMX\n" +
//                            "RgLLkm6ed3qTYCTOZlCI30LamuJ9JtTmzCdwzTsGlkkCQQDKnxEeyxxQvSFXl16K\n" +
//                            "FBirmPAaGjOpk7I5tV1sqqrguWSEIoE8WXijwtBpd3ItdwNjBqSU8j+nmMoMDD2W\n" +
//                            "uIZ5AkEAlTsQsG6IkoA02MD85/WnwXxZNkL8x2EPBRlH8/DLRmOW0IvEXHDV8x3C\n" +
//                            "X8VclD98Wd8GOvZ6gI+BXJDffGeeAQJAO4ccCoX1narS/t7TwZFB5jgaYjDMeMeR\n" +
//                            "lu63sdM6PKd65m8UtNw8WzBC9plHDCBo+FDdTX0WQnDa+0slVQCFUQJBAI+WK3WO\n" +
//                            "bECFqsgIBdeCsIdmd3svZvcZbrgZD0oVr1lzEdBcNXgOj+qKo82bQWCy9Luw3CV/\n" +
//                            "K4HKVM+4P+NXU/U=";
        String public_key = RSAEncryptor.getStringByByte(getResources().openRawResource(R.raw.rsa_public_key));
        String private_key = RSAEncryptor.getStringByByte(getResources().openRawResource(R.raw.pkcs8_private_key));

        try {

            RSAEncryptor rsaEncryptor = new RSAEncryptor(public_key, private_key);

            String test = "hello liuyanwei";
            String testRSAEnWith64 = rsaEncryptor.encryptWithBase64(test);
            String testRSADeWith64 = rsaEncryptor.decryptWithBase64(testRSAEnWith64);

            System.out.println("\n origin: " + test);
            System.out.println("\n Encrypt base64: " + testRSAEnWith64);
            System.out.println("\n Decrypt:" + testRSADeWith64);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
