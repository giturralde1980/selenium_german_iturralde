package practicos.claseCuatro.arrays.com;
//Crear un array de booleanos con 10 posiciones llamado asientosLibres y colocar todos
//sus elementos en true.
public class ejercicioCinco {
    public static void main(String args[])
    {
        boolean[] asientosLibres = new boolean[10];
        for(int i=0;i< asientosLibres.length;i++)
        {
            asientosLibres[i]=true;
        }
        for(int i=0;i< asientosLibres.length;i++) {
            System.out.println(asientosLibres[i]);
        }

    }


}
