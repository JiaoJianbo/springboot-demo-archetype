#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.jasypt.util.text.BasicTextEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void encryptPwd(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor(); // with algorithm "PBEWithMD5AndDES"
        // 加密所需的salt(盐)
        textEncryptor.setPassword("MY_SECRET");
        String password = textEncryptor.encrypt("sa");
        System.out.println("password = " + password);

        StrongTextEncryptor strongTextEncryptor = new StrongTextEncryptor(); // with algorithm "PBEWithMD5AndTripleDES"
        // 加密所需的salt(盐)
        strongTextEncryptor.setPassword("MY_SECRET");
        password = strongTextEncryptor.encrypt("sa");
        System.out.println("password = " + password);
    }
}
