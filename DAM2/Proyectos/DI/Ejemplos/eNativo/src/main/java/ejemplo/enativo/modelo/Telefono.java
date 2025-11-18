package ejemplo.enativo.modelo;


public class Telefono {

    private Long id;
    private String numero;
    private Persona persona;

    public Telefono() {
    }

    public Telefono(String numero) {
        this.numero = numero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Telefono)) return false;
        Telefono other = (Telefono) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Telefono{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                '}';
    }
}

