package practicos.clases_y_objetos.ejercicioCuatro;

public class GestionarProductos {
    public static void main (String args[])
    {
        Producto p = new Producto();
        p.setCodigo(198);
        p.setNombre("Banana");
        p.setNroLote("ABC-4330");
        p.setImportado(true);

        Producto p1 = new Producto();
        p1.setCodigo(77);
        p1.setNombre("Pera");
        p1.setNroLote("ABC-4330");
        p1.setImportado(true);

        Producto p2 = new Producto();
        p2.setCodigo(89);
        p2.setNombre("Manzana");
        p2.setNroLote("ABC-4330");
        p2.setImportado(false);

        System.out.println(p);
        System.out.println(p1);
        System.out.println(p2);

    }
}
