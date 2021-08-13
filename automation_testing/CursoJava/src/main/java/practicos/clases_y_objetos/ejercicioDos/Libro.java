package practicos.clases_y_objetos.ejercicioDos;
//Crear una clase Libro que contenga los siguientes atributos:
//
//● ISBN: int
//● Titulo: String
//● Autor: String
//● Número de páginas: int
//
//Crear sus respectivos métodos get y set para cada atributo. Crear el método toString()
//para mostrar la información relativa al libro con el siguiente formato:
//“El libro con ISBN xxxx creado por el autor yyyy tiene zz páginas”


//b) Crear un constructor sin parámetros, y un constructor que contenga todos los
//parámetros del libro. El constructor sin parámetros, debe setear el título del libro como
//“Sin título”.
//c) Crear una clase llamada Librería que contenga el main, y cree 2 objetos Libro (los
//valores que serán ingresados por el usuario) y mostrarlos por pantalla.

public class Libro {
    private int Isbn;
    private String Titulo;
    private String Autor;
    private int Numero_de_Paginas;

    public Libro()
    {
        this.Titulo="sin titulo";
    }

    public Libro(int isbn, String titulo, String autor, int num_pag)
    {
        this.Isbn=isbn;
        this.Titulo=titulo;
        this.Autor=autor;
        this.Numero_de_Paginas=num_pag;
    }

    public int getIsbn()
    {
        return this.Isbn;
    }

    public void setIsbn(int isbn){
        this.Isbn = isbn;
    }

    public String getTitulo () {
        return this.Titulo;
    }

    public void setTitulo (String titulo){
        this.Titulo=titulo;
    }

    public String getAutor(){
        return this.Autor;
    }

    public void setAutor(String autor){
        this.Autor=autor;
    }

    public int getNumeroPaginas()
    {
        return this.Numero_de_Paginas;
    }

    public void setNumero_de_Paginas(int num_paginas)
    {
        this.Numero_de_Paginas=num_paginas;
    }
    //“El libro con ISBN xxxx creado por el autor yyyy tiene zz páginas”
    public String toString()
    {
        return "El libro con ISBN " + this.Isbn + "con titulo " + this.getTitulo()+ " creado por el autor " + this.Autor + " tiene " + this.Numero_de_Paginas +" paginas.";
    }
}
