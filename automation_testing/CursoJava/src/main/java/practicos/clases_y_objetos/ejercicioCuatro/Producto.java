package practicos.clases_y_objetos.ejercicioCuatro;
//4) Ejercicio
//Crear clase llamada Producto.
//○ Agregar los siguientes atributos: Nombre (String), Codigo (int), Importado
//(boolean), NroLote (String), NroProducto (int)
//○ Crear los constructores con parámetros y sin parámetros. El sin parámetros
//deberá asignar un valor a cada atributo:
//■ Nombre: Desconocido
//■ Codigo: 0
//■ Importado = false
//■ NroLote = Desconocido
//○ Crear los métodos setter y getter para cada uno de los atributos
//○ Mostrar todos los atributos en el método toString. Si el producto es importado, se
//debe mostrar. “Este producto es importado”, sino, “Producto nacional”
//○ Se debe crear una clase llamada GestionarProductos que permita crear 3
//productos
//○ Cuando termine el ingreso de los productos, se debe mostrar todos los
//productos en pantalla

public class Producto {
    private String Nombre;
    private int Codigo;
    private boolean Importado;
    private String NroLote;
    private int NroProducto;

    public Producto(){
        this.Nombre="desconocido";
        this.Codigo=0;
        this.Importado=false;
        this.NroLote="desconocido";
    }

    public Producto (String nom, int cod, boolean importado,String lote, int nprod)
    {
        this.Nombre=nom;
        this.Codigo=cod;
        this.Importado=importado;
        this.NroLote=lote;
        this.NroProducto=nprod;
    }

    public String getNombre()
    {return this.Nombre;}

    public void setNombre(String nom)
    {
        this.Nombre=nom;
    }
    public int getCodigo()
    {
        return this.Codigo;
    }
    public void setCodigo(int cod)
    {
        this.Codigo=cod;
    }

    public boolean getImportado(){
        return this.Importado;
    }

    public boolean setImportado (boolean imp)
    {
        return this.Importado = imp;
    }

    public String getNroLote()
    {
        return this.NroLote;
    }
    public void setNroLote (String lote)
    {
        this.NroLote=lote;
    }

    public String toString()
    {
        String resultado = this.Nombre;
        // “Este producto es importado”, sino, “Producto nacional”
        if (this.Importado)
        {
            resultado=resultado+" Producto importado.";
        }else
        {
            resultado=resultado+" Producto nacional.";

        }

        return resultado;
    }
}
