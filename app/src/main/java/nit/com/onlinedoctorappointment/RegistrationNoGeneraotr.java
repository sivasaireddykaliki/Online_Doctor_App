package nit.com.onlinedoctorappointment;

import java.util.Random;

/**
 * Created by nit on 10/9/2017.
 */

public class RegistrationNoGeneraotr {

    public static void main(String[] args) {
        Random r = new Random(System.currentTimeMillis());
        System.out.println(r.nextInt(100000));
    }

}

