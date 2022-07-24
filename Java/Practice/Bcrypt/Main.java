package Practice.Bcrypt;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

class Main {
    public static void main(String[] args) {
        String pwd = "1111"; 
        // $2a$10$bLPqCSuqvz.Z1zoFzQQCgu6gbMnFgAS/LPDwp3Ywe9w2H7qYGJZYS
        // String pwd = "1234";
        // $2a$10$jEx/0Wc2Sp38r56yp7L06eDW/TAyUXSq.th2NMQk1aVYCb.Q0P6X2

        // Spring Boot 등이 아니어서 사용이 안되는듯
        // BCryptPasswordEncoder bcrypCryptPasswordEncoder = new BCryptPasswordEncoder();
        // String envPwd = bcrypCryptPasswordEncoder.encode(pwd);
        // System.out.println(envPwd);     

        String envPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());

        System.out.println(envPwd);

        pwd = "1234";
        String hash = "$2a$10$HkUPQhZhBBXR7iwdHBO5cOndgVXXsTcF6HoQ6NUcGVY1H9V7.6XYK";
        boolean isValid = BCrypt.checkpw(pwd, hash);
        System.out.println(isValid);

        
    }
}