package practicos.claseSeis_Herencia_Polimorfismo.ejercicioDos;

public class Tester extends Empleado
{
    private boolean Manual;
    private boolean Automatizador;

    public boolean getManual()
    {
        return this.Manual;
    }

    public boolean getAutomatizador()
    {
        return this.Automatizador;
    }

    public void setManual(boolean _manual)
    {
        this.Manual=_manual;
    }

    public void setAutomatizador(boolean _automatizador)
    {
        this.Automatizador=_automatizador;
    }

    public Tester(boolean _manual, boolean _automatizador){
        super("Mario Gomez",10000,245322);
        if (this.Automatizador=_automatizador) {
            this.Manual = true;
        }
        this.Manual=_manual;
    }

    public Tester()
    {

    }

}

