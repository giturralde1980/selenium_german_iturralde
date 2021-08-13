package practicos.selenium.practico13.factorias;
import org.testng.annotations.Factory;

public class SpotifyFactory {
    @Factory
    public Object[] TestFactory()
    {
        return new Object[]{
                new SpotifyRegistrationFactory("pepe","gomes","pepe@pepe.net","666666"),
                new SpotifyRegistrationFactory("popo","rodrigues","popo@pepe.net","777777"),
                new SpotifyRegistrationFactory("pipi","gonsales","pipo@pepe.net","888888"),
                new SpotifyRegistrationFactory("papa","ramires","papa@pepe.net","999999"),
                new SpotifyRegistrationFactory("pipo","peres","pepi@pepe.net","000000"),

        };
    }

}
