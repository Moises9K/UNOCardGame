package moises.Base;

public abstract class Carta {
    private String name;
    private Tipo tipo;

    public Carta(String name, Tipo tipo) {
        this.name = name;
        this.tipo = tipo;
    }

    public String getName() {
        return name;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Carta{" +
                "name='" + name + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
