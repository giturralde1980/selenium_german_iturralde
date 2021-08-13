package pruebas.test.org;

import com.github.javafaker.Faker;
import okhttp3.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class DataFaker {

    public static int getRandomDeductible() {
        List<Integer> deductibles = new ArrayList<Integer>();
        deductibles.add(0);
        //deductibles.add(150); me lo cargo porque no esta includo en suiza, para considerar en refactor
        deductibles.add(300);
        deductibles.add(500);
        deductibles.add(1000);
        Random r= new Random();
        return deductibles.get(r.nextInt(deductibles.size()));
    }

    public static String getRandomPaymentFrequency() {
        List<String> paymentTerms = new ArrayList<String>();
        paymentTerms.add("yearly");
        paymentTerms.add("half-Yearly");
        paymentTerms.add("monthly");
        paymentTerms.add("quarterly");
        Random r= new Random();
        return paymentTerms.get(r.nextInt(paymentTerms.size()));
    }

    public static String getRandomProductType() {
        List<String> productType = new ArrayList<String>();
        productType.add("vehicle-liability");
        productType.add("partial-comprehensive");
        productType.add("fully-comprehensive");
        Random r= new Random();
        return productType.get(r.nextInt(productType.size()));
    }

    public static String getRandomCustomerSex() {
        List<String> customer_sex = new ArrayList<String>();
        customer_sex.add("0");
        customer_sex.add("1");
        Random r= new Random();
        return customer_sex.get(r.nextInt(customer_sex.size()));
    }

    public static String getRandomPackage(String product) {
        List<String> productType = new ArrayList();
        productType.add("Compact");
        productType.add("Comfort");
        productType.add("Comfort+");
        if (!product.equals("liabilityv2021")) {
            productType.add("Green_Compact");
            productType.add("Green_Comfort");
            productType.remove("Comfort+");
        }
        Random r = new Random();
        return productType.get(r.nextInt(productType.size()));
    }

    private static String calculateVehicleId() {
        Random r = new Random();
        int n = r.nextInt(99999);
        //return (int)(100000 * Math.random());
        String vehicle_id= getStringNumber(17);
        return vehicle_id;
    }

    public static String contract_body(String country, String product)
    {
        //Set parameters
        String product_motor_product_type = getRandomProductType();
        String contract_package = getRandomPackage("csuite");

        int tk_deductible=getRandomDeductible();
        int vk_deductible=getRandomDeductible();


        //RANDOM VALUES LIKE LICENSE AND SERIALS
        String external_id= calculateExternalId();
        int _serial_number = calculateSerialNumber();
        String licence_plate= calculateLicencePlate();
        String vehicle_id=calculateVehicleId();

        String payment_frequency=getRandomPaymentFrequency();

        int day = LocalDate.now().getDayOfMonth();
        int month = LocalDate.now().getMonthValue();
        int year = LocalDate.now().getYear();

        String _day = "";
        if (day < 10)
        {
            _day="0"+String.valueOf(day);
        }
        else {
            _day = String.valueOf(day);
        }

        String _month = "";
        if (month < 10)
        {
            _month="0"+String.valueOf(month);
        }
        else {
            _month = String.valueOf(month);
        }

        String start_date = String.valueOf(year)+"-"+_month+"-"+_day;

        //POLICY LANGUAGE
        String policy_language = "EN";

        //String customerEmail="german.iturralde@live.com";


        String customerEmail="german.iturralde+"+start_date+"_" + getStringNumber(3) + "@wefox.com";

         boolean has_assistance=false;
         boolean has_new_value_compensation=false;
         boolean has_parkingDamage=false;
         boolean has_extendedGlassDamage=false;
         boolean has_personalBelongs=false;
         boolean has_grossNegligence=false;
         boolean has_firstPartyDamage=false;
         boolean has_passengerCover=false;

        Faker f;
        if (country=="DE") {
            f = new Faker(new Locale("de-DE"));
        }else
        {
            f= new Faker(new Locale("de-CH"));
        }

        String address_postal_code = f.address().zipCode();
        String address_street_name = f.address().streetName();
        String address_street_number = f.address().buildingNumber();
        String address_city = f.address().city();

        String bank_account_owner_name = f.name().fullName();

        String previous_amount = "1000";

        String customer_name = f.name().firstName();
        String customer_lastname = f.name().lastName();
        String customer_sex = getRandomCustomerSex();

        int number_of_children=0;
        int number_of_adults=1;
        String product_Non_motor_type = getRandomPackage("liabilityv2021");
        String body="";
        if (product== "csuite") {
            //String contract_package = getRandomPackage("csuite");
            body="{\"calculation\":{\"inputs\":[{\"validation\":[\"required\",\"string\",\"in:Compact,Comfort,Green_Compact,Green_Comfort\"],\"type\":\"String\",\"label\":\"Product Package\",\"name\":\"product.motor.package\",\"value\":\""+contract_package+"\"},{\"validation\":[\"required\",\"string\",\"in:vehicle-liability,partial-comprehensive,fully-comprehensive\"],\"type\":\"String\",\"label\":\"Product Type\",\"name\":\"product.motor.product-type\",\"value\":\""+product_motor_product_type+"\"},{\"validation\":[\"integer\",\"in:0,150,300,500,1000\",\"requiredIf:product.motor.product-type,partial-comprehensive\",\"requiredIf:product.motor.product-type,fully-comprehensive\"],\"type\":\"Integer\",\"label\":\"Deductible for partial comprehensive\",\"name\":\"product.motor.coverage.comprehensive.partial.deductible\",\"value\":"+tk_deductible+"},{\"validation\":[\"integer\",\"in:0,150,300,500,1000,2500\",\"requiredIf:product.motor.product-type,fully-comprehensive\"],\"type\":\"Integer\",\"label\":\"Deductible for Fully comprehensive\",\"name\":\"product.motor.coverage.comprehensive.fully.deductible\",\"value\":"+vk_deductible+"},{\"validation\":[\"required\",\"string\",\"regex:^[0-9]{4}$\"],\"type\":\"string\",\"label\":\"Manufacturer key number \",\"name\":\"object.vehicle.hsn\",\"value\":\"0588\"},{\"validation\":[\"required\",\"string\",\"regex:^[A-Za-z0-9]{3}$\"],\"type\":\"string\",\"label\":\"Type ID of car\",\"name\":\"object.vehicle.tsn\",\"value\":\"588\"},{\"validation\":[\"required\",\"dateFormat:YYYY-MM-DD\",\"dateYearsBeforeToday:-18\",\"dateYearsAfterToday:-99\"],\"type\":\"Date\",\"label\":\"Birthdate of policy holder \\/ insured\",\"name\":\"product.motor.policyholder.birthdate\",\"value\":\"1993-10-10\"},{\"validation\":[\"required\",\"boolean\"],\"type\":\"Boolean\",\"label\":\"Additional drivers, covered in the insurance\",\"name\":\"product.motor.coverage.additional-driver.is-included\",\"value\":true},{\"validation\":[\"requiredIf:car.vehicle.driver.other,true\",\"integer\",\"between:18,99\"],\"type\":\"Integer\",\"label\":\"Age of youngest driver\",\"name\":\"object.vehicle.driver.youngest.age\",\"value\":22},{\"validation\":[\"required\",\"string\",\"regex:^(?!01000|99999)(0[1-9]\\\\d{3}|[1-9]\\\\d{4})$\"],\"type\":\"string\",\"label\":\"Postal Code of the insured person\",\"name\":\"product.motor.policyholder.address.postcode\",\"value\":\"59439\"},{\"validation\":[\"required\",\"integer\",\"between:0,100000\"],\"type\":\"Integer\",\"label\":\"Yearly usage of the car in kilometers\",\"name\":\"object.vehicle.yearly-mileage\",\"value\":\"99999\"},{\"validation\":[\"string\",\"in:S,M,0,SF1\\/2,SF1,SF2,SF3,SF4,SF5,SF6,SF7,SF8,SF9,SF10,SF11,SF12,SF13,SF14,SF15,SF16,SF17,SF18,SF19,SF20,SF21,SF22,SF23,SF24,SF25,SF26,SF27,SF28,SF29,SF30,SF31,SF32,SF33,SF34,SF35,SF36,SF37,SF38,SF39,SF40,SF41,SF42,SF43,SF44,SF45,SF46,SF47,SF48,SF49,SF50\",\"requiredIf:product.motor.product-type,fully-comprehensive\"],\"type\":\"String\",\"label\":\"No-claims discount for fully-comprehensive \",\"name\":\"product.motor.no-claims-discount-comprehensive.level\",\"value\":\"SF28\"},{\"validation\":[\"required\",\"string\",\"in:S,M,0,SF1\\/2,SF1,SF2,SF3,SF4,SF5,SF6,SF7,SF8,SF9,SF10,SF11,SF12,SF13,SF14,SF15,SF16,SF17,SF18,SF19,SF20,SF21,SF22,SF23,SF24,SF25,SF26,SF27,SF28,SF29,SF30,SF31,SF32,SF33,SF34,SF35,SF36,SF37,SF38,SF39,SF40,SF41,SF42,SF43,SF44,SF45,SF46,SF47,SF48,SF49,SF50\"],\"type\":\"String\",\"label\":\"No-claims discount for vehicle-liability\",\"name\":\"product.motor.no-claims-discount-liability.level\",\"value\":\"SF50\"},{\"validation\":[\"required\",\"dateFormat:YYYY-MM-DD\",\"dateYearsAfterToday:-40\"],\"type\":\"Date\",\"label\":\"Date of first car registration\",\"name\":\"object.vehicle.first-registration\",\"value\":\"1990-10-12\"},{\"validation\":[\"required\",\"dateFormat:YYYY-MM-DD\",\"dateYearsAfterToday:-40\",\"ifThisDateIs:>=,object.vehicle.registration.first.date\"],\"type\":\"Date\",\"label\":\"First car registration by insured\",\"name\":\"object.vehicle.first-registration-by-policyholder\",\"value\":\"1993-10-12\"},{\"validation\":[\"required\",\"boolean\"],\"type\":\"Boolean\",\"label\":\"Coverage No Claims Discount protection\",\"name\":\"product.motor.coverage.discount-protection.is-included\",\"value\":true},{\"validation\":[\"boolean\",\"requiredIf:product.motor.product-type,fully-comprehensive\"],\"type\":\"Boolean\",\"label\":\"Coverage Leasing Car Gap coverage\",\"name\":\"product.motor.coverage.comprehensive.fully.gap-coverage.is-included\",\"value\":true},{\"validation\":[\"required\",\"boolean\"],\"type\":\"Boolean\",\"label\":\"Coverage Motor assistance\",\"name\":\"product.motor.coverage.vehicle-assistance.is-included\",\"value\":true}],\"payment_frequency\":\"monthly\",\"product_version\":3},\"customer\":{\"first_name\":\"german\",\"last_name\":\"iturralde\",\"gender\":\"0\",\"birthdate\":\"1991-11-15\",\"mobile_number\":\"234567888\",\"phone_number\":\"123567889\",\"email\":\""+customerEmail+"\",\"address\":{\"street\":\"Conradtystra\\u00dfe\",\"house_number\":\"1\",\"postal_code\":\"90441\",\"place\":\"N\\u00fcrnberg\",\"country\":\"DE\",\"main_address\":true}},\"insured_object\":{\"inputs\":[{\"validation\":[\"string\",\"required\"],\"type\":\"String\",\"label\":\"License plate of the vehicle\",\"name\":\"object.vehicle.license-plate\",\"value\":\""+licence_plate+"\"},{\"validation\":[\"required\",\"string\",\"regex:^([a-zA-Z0-9_.-]{17})*$\"],\"type\":\"String\",\"label\":\"Vehicle - ID\",\"name\":\"object.vehicle.id\",\"value\":\""+vehicle_id+"\"},{\"validation\":[\"required\",\"integer\",\"between:0,1000000\"],\"name\":\"object.vehicle.current-mileage\",\"label\":\"Current Mileage in kilometer\",\"type\":\"Integer\",\"value\":999999},{\"validation\":[\"required\",\"string\",\"maxLength:4\"],\"label\":\"Previous Insurance Company\",\"type\":\"String\",\"name\":\"product.motor.previous-insurer-id\",\"value\":\"5342\"},{\"validation\":[\"required\",\"string\"],\"label\":\"Previous Insurance Policy ID\",\"type\":\"String\",\"name\":\"product.motor.previous-policy-number\",\"value\":\"ABgfds1234\"},{\"validation\":[\"required\",\"boolean\"],\"type\":\"Boolean\",\"label\":\"Is the policy holder and the car holder the same person?\",\"name\":\"object.vehicle.holder.is-policyholder\",\"value\":true},{\"validation\":[\"string\",\"requiredIf:object.vehicle.holder.is-policyholder,false\"],\"type\":\"String\",\"label\":\"Last name of the car holder\",\"name\":\"object.vehicle.holder.last-name\",\"value\":\"Helm\"},{\"validation\":[\"string\",\"requiredIf:object.vehicle.holder.is-policyholder,false\"],\"type\":\"String\",\"label\":\"First name of the car holder\",\"name\":\"object.vehicle.holder.first-name\",\"value\":\"Sturz\"},{\"validation\":[\"dateFormat:YYYY-MM-DD\",\"requiredIf:object.vehicle.holder.is-policyholder,false\"],\"type\":\"Date\",\"label\":\"Date of birth of the car holder\",\"name\":\"object.vehicle.holder.birthdate\",\"value\":\"1940-10-12\"},{\"validation\":[\"string\",\"requiredIf:object.vehicle.holder.is-policyholder,false\"],\"type\":\"String\",\"label\":\"Street name of the car holder\",\"name\":\"object.vehicle.holder.address.street\",\"value\":10},{\"validation\":[\"string\",\"requiredIf:object.vehicle.holder.is-policyholder,false\"],\"type\":\"String\",\"label\":\"House number of the car holder\",\"name\":\"object.vehicle.holder.address.house-number\",\"value\":\"123\"},{\"validation\":[\"string\",\"regex:^(?!01000|99999)(0[1-9]\\\\d{3}|[1-9]\\\\d{4})$\",\"requiredIf:object.vehicle.holder.is-policyholder,false\"],\"type\":\"String\",\"label\":\"Postal Code of the car holder\",\"name\":\"object.vehicle.holder.address.postcode\",\"value\":\"10245\"},{\"validation\":[\"string\",\"requiredIf:object.vehicle.holder.is-policyholder,false\"],\"type\":\"String\",\"label\":\"City of the car holder\",\"name\":\"object.vehicle.holder.address.city\",\"value\":10234},{\"validation\":[\"string\",\"in:BP,BP-B2C,BP-B2B\"],\"type\":\"String\",\"label\":\"Channel Id\",\"name\":\"object.channel-id\",\"value\":\"BP\"}],\"type\":\"car\"},\"payment_details\":{\"type\":\"DirectDebit\",\"direct_debit_iban\":\"DE89370400440532013000\",\"direct_debit_iban_name_holder\":\"John Doe\"}}";

        }else if (product =="switch") {
            body = "{\"portfolio_owners\":[{\"_id\":\"6045c060ff4b30128f8fe728\",\"code\":\" \",\"legal_id\":\"50212916118529PZEUTSSOR1J\",\"type\":\"BROKER\"}],\"insured_object\":{\"type\":\"car\",\"inputs\":[{\"name\":\"object.vehicle.license-plate\",\"value\":\""+licence_plate+"\"},{\"value\":\"5342\",\"name\":\"product.motor.previous-insurer-id\"},{\"name\":\"object.vehicle.id\",\"value\":\""+vehicle_id+"\"},{\"name\":\"product.motor.previous-insurer-id\",\"value\":\"5342\"},{\"name\":\"product.motor.previous-policy-number\",\"value\":\"43523424235236\"}]},\"customer\":{\"first_name\":\""+customer_name+"\",\"last_name\":\""+customer_lastname+"\",\"gender\":\""+customer_sex+"\",\"birthdate\":\"1991-11-15\",\"mobile_number\":\"234567888\",\"phone_number\":\"123567889\",\"email\":\""+customerEmail+"\",\"address\":{\"street\":\""+address_street_name+"\",\"house_number\":\""+address_street_number+"\",\"postal_code\":\""+address_postal_code+"\",\"place\":\""+address_city+"\",\"country\":\"DE\"}},\"payment_details\":{\"type\":\"DirectDebit\",\"direct_debit_iban\":\"DE89370400440532013000\",\"direct_debit_iban_name_holder\":\""+bank_account_owner_name+"\"},\"calculation\":{\"product_version\":\"3\",\"payment_frequency\":\""+payment_frequency+"\",\"inputs\":[{\"name\":\"product.motor.switch-discount\",\"value\":\"0.1\"},{\"name\":\"product.motor.package\",\"value\":\"car-switch\"},{\"name\":\"product.motor.product-type\",\"value\":\""+product_motor_product_type+"\"},{\"name\":\"product.motor.coverage.comprehensive.partial.deductible\",\"value\":"+tk_deductible+"},{\"name\":\"product.motor.coverage.comprehensive.fully.deductible\",\"value\":"+vk_deductible+"},{\"name\":\"product.motor.policyholder.birthdate\",\"value\":\"1991-11-15" +
                    "\"},{\"name\":\"product.motor.coverage.discount-protection.is-included\",\"value\":false},{\"name\":\"product.motor.coverage.comprehensive.fully.gap-coverage.is-included\",\"value\":false},{\"name\":\"product.motor.coverage.vehicle-assistance.is-included\",\"value\":false},{\"name\":\"product.motor.previous-premium-amount\",\"value\":"+previous_amount+"},{\"name\":\"product.motor.previous-premium-payment-interval\",\"value\":\"yearly\"}]},\"documents\":[]}";
        }else if (product == "household")
        {
            body = "{\"insured_object\":{\"type\":\"house\",\"inputs\":[{\"validation\":[\"integer\"],\"type\":\"Integer\",\"label\":\"House number\",\"name\":\"object.home.address.streetnumber\",\"value\":"+address_street_number+"},{\"validation\":[\"string\"],\"type\":\"String\",\"label\":\"House city\",\"name\":\"object.home.address.city\",\"value\":\"Berlin\"},{\"validation\":[\"string\"],\"type\":\"String\",\"label\":\"House street\",\"name\":\"object.home.address.street\",\"value\":\""+address_street_name+"\"}]},\"customer\":{\"first_name\":\""+customer_name+"\",\"last_name\":\""+customer_lastname+"\",\"gender\":\""+customer_sex+"\",\"birthdate\":\"1991-11-15\",\"mobile_number\":\"234567889\",\"phone_number\":\"123567880\",\"email\":\""+customerEmail+"\",\"address\":{\"street\":\""+address_street_name+"\",\"house_number\":\""+address_street_number+"\",\"postal_code\":\""+address_postal_code+"\",\"place\":\"Nürnberg\",\"country\":\"DE\",\"main_address\":true}},\"payment_details\":{\"type\":\"DirectDebit\",\"direct_debit_iban\":\"DE89370400440532013000\",\"direct_debit_iban_name_holder\":\"Sergi Baños Lara\"},\"calculation\":{\"product_version\":6,\"payment_frequency\":\"Monthly\",\"inputs\":[{\"validation\":[\"required\",\"string\",\"in:Comfort+,Compact,Comfort\"],\"type\":\"String\",\"label\":\"Product Package\",\"name\":\"household.package\",\"value\":\"Comfort+\"},{\"validation\":[\"required\",\"integer\",\"in:0,150,300,500,1000\"],\"type\":\"Integer\",\"label\":\"Deductible\",\"name\":\"household.deductible\",\"value\":150},{\"validation\":[\"required\",\"integer\",\"between:16,300\"],\"type\":\"Integer\",\"label\":\"House square meters\",\"name\":\"object.home.size.total\",\"value\":222},{\"validation\":[\"required\",\"string\",\"regex:^(?!01000|99999)(0[1-9]\\\\d{3}|[1-9]\\\\d{4})$\"],\"type\":\"String\",\"label\":\"House postal code\",\"name\":\"object.home.address.postalcode\",\"value\":\"10247\"},{\"validation\":[\"integer\",\"between:10000,200000\"],\"type\":\"Integer\",\"label\":\"Household insured amount\",\"name\":\"household.sum-insured\",\"value\":25000},{\"validation\":[\"required\",\"integer\",\"between:0,5000\"],\"type\":\"Integer\",\"label\":\"Bicycle insured amount\",\"name\":\"household.bike.sum-insured\",\"value\":0},{\"validation\":[\"integer\",\"between:2000,80000\"],\"type\":\"Integer\",\"label\":\"Valuables insured amount\",\"name\":\"household.valuables.sum-insured\",\"value\":2000},{\"validation\":[\"required\",\"boolean\"],\"type\":\"Boolean\",\"label\":\"Elemental coverage Included\",\"name\":\"household.elemental.yes\",\"value\":false},{\"validation\":[\"required\",\"boolean\"],\"type\":\"Boolean\",\"label\":\"Glass Included\",\"name\":\"household.glass.yes\",\"value\":false},{\"validation\":[\"required\",\"boolean\"],\"type\":\"Boolean\",\"label\":\"Mobility Included\",\"name\":\"household.mobility.yes\",\"value\":false}]}}";
        }else if (product =="offerDE") {
            body="{\"portfolio_owner_id\":\"KFZ-2004\",\"portfolio_owners\":[{\"type\":\"BROKER\",\"legal_id\":\"45222816418545P8A4DCAZQG6\",\"code\":\" \"}],\"customer\":{\"first_name\":\""+customer_name+"\",\"last_name\":\""+customer_lastname+"\",\"gender\":\""+customer_sex+"\",\"birthdate\":\"1991-11-15\",\"mobile_number\":\"1233212\",\"phone_number\":\"321122\",\"email\":\""+customerEmail+"\",\"address\":{\"street\":\""+address_street_name+"\",\"house_number\":\""+address_street_number+"\",\"postal_code\":\""+address_postal_code+"\",\"place\":\""+address_city+"\",\"country\":\"DE\"}},\"insured_object\":{\"type\":\"car\",\"inputs\":[{\"name\":\"person.car-holder-is-policy-holder.yes\",\"value\":true},{\"name\":\"person.car-holder.firstname\",\"value\":\"puca\"},{\"name\":\"person.car-holder.lastname\",\"value\":\"puca\"},{\"name\":\"person.car-holder.birthdate\",\"value\":\"1991-11-15\"},{\"name\":\"person.car-holder.street\",\"value\":\""+address_street_name+"\"},{\"name\":\"person.car-holder.housenumber\",\"value\":\""+address_street_number+"\"},{\"name\":\"person.car-holder.postcode\",\"value\":\""+address_postal_code+"\"},{\"name\":\"person.car-holder.city\",\"value\":\""+address_city+"\"},{\"name\":\"object.vehicle.license-plate\",\"value\":\""+licence_plate+"\"},{\"name\":\"object.vehicle.registration.area\",\"value\":\"Berlin\"},{\"name\":\"object.vehicle.id\",\"value\":\""+vehicle_id+"\"},{\"name\":\"object.vehicle.previous-insurer.id\",\"value\":\"1234\"},{\"name\":\"object.vehicle.previous-insurer.policy-number\",\"value\":\"test policy number\"},{\"name\":\"object.channel-id\",\"value\":\"BP\"}]},\"start_date\":\""+start_date+"\",\"payment_details\":{\"type\":\"DirectDebit\",\"direct_debit_iban\":\"DE89370400440532013000\",\"direct_debit_iban_name_holder\":\"Test it tralala\"},\"calculation\":{\"product_version\":3,\"payment_frequency\":\""+payment_frequency+"\",\"inputs\":[{\"name\":\"car.package\",\"value\":\""+contract_package+"\"},{\"name\":\"car.product-type\",\"value\":\"fully-comprehensive\"},{\"name\":\"object.vehicle.hsn\",\"value\":\"0588\"},{\"name\":\"object.vehicle.tsn\",\"value\":\"588\"},{\"name\":\"person.birthdate\",\"value\":\"1991-11-15\"},{\"name\":\"car.vehicle.driver.other\",\"value\":false},{\"name\":\"person.address.postcode\",\"value\":\""+address_postal_code+"\"},{\"name\":\"car.vehicle.kilometers.yearly\",\"value\":10000},{\"name\":\"object.vehicle.registration.first.date\",\"value\":\"2000-01-22\"},{\"name\":\"object.vehicle.insured.first.date\",\"value\":\"2001-01-22\"},{\"name\":\"car.discount-protection.yes\",\"value\":true},{\"name\":\"car.gap-coverage.yes\",\"value\":false},{\"name\":\"car.assistance.yes\",\"value\":true},{\"name\":\"car.partial-comprehensive.deductible\",\"value\":"+tk_deductible+"},{\"name\":\"car.fully-comprehensive.deductible\",\"value\":"+vk_deductible+"},{\"name\":\"car.vehicle.driver.youngest.age\"},{\"name\":\"object.secondary-car.vehicle-liability.no-claim-discount\",\"value\":\"SF18\"},{\"name\":\"object.secondary-car.fully-comprehensive.no-claim-discount\",\"value\":\"SF19\"},{\"name\":\"object.previous-insurance.vehicle-liability.no-claim-discount\",\"value\":\"SF30\"},{\"name\":\"object.previous-insurance.fully-comprehensive.no-claim-discount\",\"value\":\"SF31\"}]}}";
        }else if (product=="liabilityv2021")
        {
            body="{\"portfolio_owners\":[{\"type\":\"BROKER\",\"legal_id\":\"45222816418545P8A4DCAZQG6\",\"code\":\" \"}],\"customer\":{\"type\":\"natural_person\",\"first_name\":\""+customer_name+"\",\"last_name\":\""+customer_lastname+"\",\"gender\":\""+customer_sex+"\",\"birthdate\":\"1999-02-15\",\"mobile_number\":\"88888888\",\"phone_number\":\"77777777\",\"email\":\""+customerEmail+"\",\"address\":{\"state\":null,\"street\":\""+address_street_name+"\",\"house_number\":\""+address_street_number+"\",\"postal_code\":\"10178\",\"place\":\"Berlin\",\"country\":\"DE\"}},\"payment_details\":{\"type\":\"DirectDebit\",\"direct_debit_iban\":\"DE19600100700488436700\",\"direct_debit_iban_name_holder\":\"AQAONE AQAONE\"},\"calculation\":{\"product_version\":2021,\"payment_frequency\":\""+payment_frequency+"\",\"inputs\":[{\"validation\":[\"required\",\"string\",\"in:Compact,Comfort,Comfort+\"],\"type\":\"string\",\"label\":\"Product Package\",\"name\":\"product.private-liability.package\",\"value\":\""+product_Non_motor_type+"\"},{\"validation\":[\"required\",\"integer\",\"in:0,150,300,500,1000\"],\"type\":\"number\",\"label\":\"Deductible\",\"name\":\"product.private-liability.deductible\",\"value\":\"150\"},{\"validation\":[\"required\",\"integer\",\"min:0\",\"max:10\"],\"type\":\"integer\",\"label\":\"Number of insured children\",\"name\":\"product.private-liability.number-insured-children\",\"value\":\""+number_of_children+"\"},{\"validation\":[\"required\",\"integer\",\"min:1\",\"max:2\"],\"type\":\"integer\",\"label\":\"Number of insured adults\",\"name\":\"product.private-liability.number-insured-adults\",\"value\":\""+number_of_adults+"\"},{\"validation\":[\"required\",\"dateFormat:YYYY-MM-DD\",\"dateYearsBeforeToday:-18\"],\"type\":\"Date\",\"label\":\"Birthdate\",\"name\":\"product.private-liability.policyholder.birthdate\",\"value\":\"1999-02-15\"}]}}";

        }else if (product=="csuite_comfort_ch")
        {
            body= "{\"start_date\":\""+start_date+"\",\"portfolio_owners\":[{\"type\":\"BROKER\",\"legal_id\":\"21242616418537PRVIEN808HG\",\"code\":\" \"}],\"calculation\":{\"inputs\":[{\"validation\":[\"required\",\"string\",\"in:Comfort,Comfort+\"],\"label\":\"Product motor package\",\"name\":\"product.motor.package\",\"type\":\"string\",\"value\":\"Comfort+\"},{\"validation\":[\"required\",\"string\",\"in:vehicle-liability,partial-comprehensive,fully-comprehensive\"],\"label\":\"Product motor product type\",\"name\":\"product.motor.product-type\",\"type\":\"string\",\"value\":\""+product_motor_product_type+"\"},{\"validation\":[\"required\",\"integer\",\"in:0,250,500,1000\"],\"label\":\"Deductible for vehicle liability \",\"name\":\"product.motor.coverage.liability.deductible\",\"type\":\"number\",\"value\":\"0\"},{\"validation\":[\"requiredIf:product.motor.product-type,partial-comprehensive\",\"integer\",\"in:0,200,300,500,1000,2000\"],\"label\":\"Deductible for Partial Comprehensive Insurance\",\"name\":\"product.motor.coverage.comprehensive.partial.deductible\",\"type\":\"number\",\"value\":\""+tk_deductible+"\"},{\"validation\":[\"requiredIf:product.motor.product-type,fully-comprehensive\",\"integer\",\"in:0,200,300,500,1000,2000,2500,3000,4000,5000\"],\"label\":\"Deductible for Fully comprehensive insurance\",\"name\":\"product.motor.coverage.comprehensive.fully.deductible\",\"type\":\"number\",\"value\":\""+vk_deductible+"\"},{\"validation\":[\"requiredIf:product.motor.product-type,vehicle-liability\",\"requiredIf:product.motor.product-type,fully-comprehensive\"],\"label\":\"Discount Protection\",\"name\":\"product.motor.coverage.discount-protection.is-included\",\"type\":\"boolean\",\"value\":\"true\"},{\"validation\":[\"required\"],\"label\":\"Assistance\",\"name\":\"product.motor.coverage.vehicle-assistance.is-included\",\"type\":\"boolean\",\"value\":\""+has_assistance+"\"},{\"validation\":[\"requiredIf:product.motor.product-type,partial-comprehensive\",\"requiredIf:product.motor.product-type,fully-comprehensive\"],\"label\":\"Current Value Supplemental Damage\",\"name\":\"product.motor.coverage.comprehensive.compensation-new-value.is-included\",\"type\":\"boolean\",\"value\":\""+has_new_value_compensation+"\"},{\"validation\":[\"requiredIf:product.motor.product-type,fully-comprehensive\",\"boolean\"],\"label\":\"Parking Damage Coverage Is Included\",\"name\":\"product.motor.coverage.comprehensive.fully.parking-damage.is-included\",\"type\":\"boolean\",\"value\":\""+has_parkingDamage+"\"},{\"validation\":[\"requiredIf:product.motor.coverage.comprehensive.fully.parking-damage.is-included,true\",\"integer\",\"in:1000,2000,3000,4000,5000\"],\"label\":\"Parking Damage Coverage Sum Insured\",\"name\":\"product.motor.coverage.comprehensive.fully.parking-damage.sum-insured\",\"type\":\"number\",\"value\":\"3000\"},{\"validation\":[\"requiredIf:product.motor.product-type,partial-comprehensive\",\"requiredIf:product.motor.product-type,fully-comprehensive\"],\"label\":\"Extended glass damage Is Included\",\"name\":\"product.motor.coverage.comprehensive.glass-damage-extended.is-included\",\"type\":\"boolean\",\"value\":\""+has_extendedGlassDamage+"\"},{\"validation\":[\"requiredIf:product.motor.product-type,partial-comprehensive\",\"requiredIf:product.motor.product-type,fully-comprehensive\",\"boolean\"],\"label\":\"Personal Belongings Is Included\",\"name\":\"product.motor.coverage.comprehensive.partial.personal-effects.is-included\",\"type\":\"boolean\",\"value\":\""+has_personalBelongs+"\"},{\"validation\":[\"requiredIf:product.motor.coverage.comprehensive.partial.personal-effects.is-included,true\",\"integer\",\"in:1000,2000,3000,5000\"],\"label\":\"Personal Belongings Sum Insured\",\"name\":\"product.motor.coverage.comprehensive.partial.personal-effects.sum-insured\",\"type\":\"number\",\"value\":\"2000\"},{\"validation\":[\"required\",\"boolean\"],\"label\":\"Gross negligence\",\"name\":\"product.motor.coverage.comprehensive.gross-negligence.is-included\",\"type\":\"boolean\",\"value\":\""+has_grossNegligence+"\"},{\"validation\":[\"required\",\"boolean\"],\"label\":\"First Party Damage\",\"name\":\"product.motor.coverage.liability.first-party-damage.is-included\",\"type\":\"boolean\",\"value\":\""+has_firstPartyDamage+"\"},{\"validation\":[\"required\",\"boolean\"],\"label\":\"Passenger Cover\",\"name\":\"product.motor.coverage.passenger-cover.is-included\",\"type\":\"boolean\",\"value\":\""+has_passengerCover+"\"},{\"validation\":[\"required\",\"min:0\",\"max:100000\"],\"label\":\"Yearly usage of the car in kilometers\",\"name\":\"object.vehicle.yearly-mileage\",\"type\":\"integer\",\"value\":\"3000\"},{\"validation\":[\"required\",\"dateFormat:YYYY-MM-DD\"],\"label\":\"Date of first car registration\",\"name\":\"object.vehicle.first-registration\",\"type\":\"Date\",\"value\":\"2015-04-30\"},{\"validation\":[\"required\",\"dateFormat:YYYY\"],\"label\":\"Date of first car registration for insured\",\"name\":\"object.vehicle.first-registration-by-policyholder\",\"type\":\"Date\",\"value\":\"2016-08-02\"},{\"validation\":[\"string\",\"regex:^([0-9]{9})$\"],\"type\":\"String\",\"label\":\"Vehicle (Eurotax) NatCode\",\"name\":\"object.vehicle.eurotax-id\",\"value\":\"100100012\"},{\"validation\":[\"string\"],\"type\":\"string\",\"label\":\"Vehicle Brand / Make\",\"name\":\"object.vehicle.brand\",\"value\":\"RENAULT\"},{\"validation\":[\"string\"],\"type\":\"string\",\"label\":\"Vehicle Model\",\"name\":\"object.vehicle.model\",\"value\":\"RENAULT\"},{\"label\":\"Vehicle Price With Tax\",\"name\":\"object.vehicle.price-with-tax\",\"value\":\"16990\"},{\"label\":\"Vehicle Horse Power\",\"name\":\"object.vehicle.horse-power\",\"value\":\"75\"},{\"label\":\"Vehicle Tare (Empty) Weight\",\"name\":\"object.vehicle.tare-weight\",\"value\":\"1060\"},{\"label\":\"Vehicle Total Weight\",\"name\":\"object.vehicle.total-weight\",\"value\":\"1060\"},{\"label\":\"Vehicle Engine Displacement\",\"name\":\"object.vehicle.engine-displacement\",\"value\":\"1149\"},{\"validation\":[\"string\"],\"type\":\"String\",\"label\":\"Vehicle Engine Type\",\"name\":\"object.vehicle.engine\",\"value\":\"Benzin\"},{\"validation\":[\"string\"],\"type\":\"string\",\"label\":\"Vehicle Body Type\",\"name\":\"object.vehicle.body-type\",\"value\":\"Limousine\"},{\"validation\":[\"string\"],\"type\":\"String\",\"label\":\"Vehicle Body Type Detailed\",\"name\":\"object.vehicle.body-type-detailed\",\"value\":\"Kleinwagen\"},{\"validation\":[\"required\",\"integer\",\"min:0\"],\"label\":\"Special equipment\",\"name\":\"object.special-equipment-vehicle.value\",\"type\":\"number\",\"value\":\"0\"},{\"validation\":[\"required\",\"string\"],\"label\":\"Postal code - frequent driver\",\"name\":\"object.vehicle.driver.address.postcode\",\"type\":\"string\",\"value\":\"5412\"},{\"validation\":[\"required\",\"dateFormat:YYYY-MM-DD\"],\"label\":\"License date - frequent driver\",\"name\":\"object.vehicle.driver.driving-license.issue-date\",\"type\":\"Date\",\"value\":\"1984-08-02\"},{\"validation\":[\"required\",\"string\",\"in:w,m,d\"],\"label\":\"Gender - frequent driver\",\"name\":\"object.vehicle.driver.gender\",\"type\":\"string\",\"value\":\"w\"},{\"validation\":[\"required\",\"string\"],\"label\":\"Nationality - frequent driver\",\"name\":\"object.vehicle.driver.nationality\",\"type\":\"string\",\"value\":\"DE\"},{\"validation\":[\"string\",\"in:C,B,L\"],\"label\":\"Residence permit - frequent driver\",\"name\":\"object.vehicle.driver.residence-permit.type\",\"type\":\"string\",\"value\":\"C\"},{\"validation\":[\"required\",\"dateFormat:YYYY-MM-DD\"],\"label\":\"Birthdate - frequent driver\",\"name\":\"object.vehicle.driver.birthdate\",\"type\":\"Date\",\"value\":\"1965-09-01\"},{\"validation\":[\"required\",\"string\",\"in:private,private and commute\"],\"label\":\"Usage type of vehicle\",\"name\":\"object.vehicle.usage-type\",\"type\":\"string\",\"value\":\"private\"},{\"validation\":[\"required\",\"boolean\"],\"label\":\"Loss of license (in last 3 years) - frequent driver\",\"name\":\"object.vehicle.driver.driving-license.loss\",\"type\":\"boolean\",\"value\":\"false\"},{\"validation\":[\"required\",\"boolean\"],\"label\":\"Cancellation by previous insurer - frequent driver\",\"name\":\"product.motor.previous-policy-cancellation-insurer\",\"type\":\"boolean\",\"value\":\"false\"},{\"validation\":[\"required\",\"integer\",\"min:0\",\"max:10\"],\"label\":\"Number of MTPL claims (last 3 years) - frequent driver\",\"name\":\"product.motor.previous-claims-number\",\"type\":\"integer\",\"value\":\"2\"}],\"payment_frequency\":\"yearly\",\"product_version\":\"2021_wipo_v1\"},\"customer\":{\"address\":{\"country\":\"CH\",\"house_number\":\"1\",\"place\":\"Bern\",\"postal_code\":\"3005\",\"street\":\"Tierparkweg\"},\"email\":\""+customerEmail+"\",\"mobile_number\":\"6036736235\",\"phone_number\":\"936474832\",\"birthdate\":\"1993-01-18\",\"first_name\":\"german\",\"gender\":\"1\",\"last_name\":\"iturralde\",\"type\":\"natural_person\"},\"documents\":[],\"insured_object\":{\"inputs\":[{\"validation\":[\"required\",\"string\"],\"label\":\"Current Mileage\",\"name\":\"object.vehicle.current-mileage\",\"type\":\"string\",\"value\":\"3000\"},{\"validation\":[\"required\",\"string\",\"in:DE,EN,FR,IT\"],\"type\":\"String\",\"label\":\"Preferred language of the policy holder\",\"name\":\"product.motor.policy-language\",\"value\":\"EN\"},{\"validation\":[\"required\",\"string\",\"regex:^([0-9]{9})$\"],\"type\":\"String\",\"label\":\"Vehicle - Swiss Serial Number (Stammnummer)\",\"name\":\"object.vehicle.national-type-code\",\"value\":\"213456789\"},{\"validation\":[\"required\",\"string\",\"in:57\"],\"type\":\"String\",\"label\":\"Insurance reason (IVGrund)\",\"name\":\"object.insurance-reason\",\"value\":\"57\"}]},\"payment_details\":{\"type\":\"invoice\"},\"s3_attachment_url\":[]}";
        }else
        {
            //liability
            body ="{\"customer\":{\"first_name\":\""+customer_name+"\",\"last_name\":\""+customer_lastname+"\",\"gender\":\""+customer_sex+"\",\"birthdate\":\"1991-11-15\",\"mobile_number\":\"234567889\",\"phone_number\":\"123567880\",\"email\":\""+customerEmail+"\",\"address\":{\"street\":\""+address_street_name+"\",\"house_number\":\""+address_street_number+"\",\"postal_code\":\""+address_postal_code+"\",\"place\":\""+address_city+"\",\"country\":\"DE\"}},\"payment_details\":{\"type\":\"DirectDebit\",\"direct_debit_iban\":\"DE19600100700488436700\",\"direct_debit_iban_name_holder\":\""+bank_account_owner_name+"\"},\"calculation\":{\"product_version\":6,\"payment_frequency\":\"Monthly\",\"inputs\":[{\"name\":\"private-liability.package\",\"value\":\"Compact\"},{\"name\":\"private-liability.adults.number\",\"value\":1},{\"name\":\"private-liability.children.number\",\"value\":0},{\"name\":\"person.birthdate\",\"value\":\"1988-08-03\"},{\"name\":\"private-liability.deductible\",\"value\":300}]}}";
        }

        return body;
        //return "";
    }

    public static String calculateExternalId()
    {
        Random r = new Random();
        return "CAR_" + LocalDate.now().getYear() +  r.nextInt(10000);
    }

    public static int calculateSerialNumber()
    {
        Random r = new Random();
        return r.nextInt(999999999);
    }

    public static String calculateLicencePlate()
    {
        String licence_plate= getStringNonNumericCharacters(3) + "-"+getStringNonNumericCharacters(2) + getStringNumber(4);
        return licence_plate;
    }

    static String getStringNumber(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = //"ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "0123456789";
        //+ "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    static String getStringNonNumericCharacters(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //+ "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
