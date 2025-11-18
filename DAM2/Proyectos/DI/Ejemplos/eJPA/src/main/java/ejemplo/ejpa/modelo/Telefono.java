package ejemplo.ejpa.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "telefonos")
public class Telefono {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUMERO")
    private String numero;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PERSONA_ID")
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
}
