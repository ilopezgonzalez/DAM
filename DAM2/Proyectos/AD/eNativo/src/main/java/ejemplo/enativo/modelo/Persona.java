package ejemplo.enativo.modelo;


import java.util.HashSet;
import java.util.Set;

public class Persona {

    private Long id;
    private String nombre;
    private Integer edad;
    private Direccion direccion;
    private Set<Telefono> telefonos;

    public Persona() {
        telefonos = new HashSet<>();
    }

    public Persona(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
         telefonos = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Set<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(Set<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public void addTelefono(Telefono t) {
        t.setPersona(this);
        telefonos.add(t);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false; // soporta proxies
        Persona other = (Persona) o;
        return id != null && id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                '}';
    }
}
