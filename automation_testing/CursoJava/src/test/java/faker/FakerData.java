package faker;


import com.github.javafaker.Faker;

import java.util.Random;

public class FakerData {

    public String getName()
    {
        return new Faker().name().firstName();
    }

    public String getLastName()
    {
        return new Faker().name().lastName();

    }

    public String getEmail()
    {
        return new Faker().internet().emailAddress();
    }

    public String getPassword()
    {
        Random random = new Random();
        return String.valueOf(random.nextInt(1000000)+1000000000);
    }

    public String getAddress()
    {
        return new Faker().address().fullAddress();
    }

    public String getCountry()
    {
        return new Faker().address().country();
    }


}
