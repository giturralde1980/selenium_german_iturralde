package practicos.claseCuatro.listas.com;
//Crear un método llamado listaEstaVacia que imprima si la lista esta vacia o no. El
//método debe recibir una lista de Strings.
import java.util.ArrayList;
import java.util.List;
public class ejercicioCuatro
{
    public static void main(String args[]){
        List<String> nom = new ArrayList<String>();
        //nom.add("german");
        esVacia(nom);
    }

    public static void esVacia(List<String> nombres)
    {
        if (nombres.isEmpty()) {
            System.out.println("lista vacia");
        }else
        {
            System.out.println("lista con datos");
        }
    }
}
