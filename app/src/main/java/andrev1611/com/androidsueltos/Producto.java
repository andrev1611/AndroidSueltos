package andrev1611.com.androidsueltos;

/**
 * Created by Admin on 14/04/2016.
 */
public class Producto {
    private String titulo;
    private String descripcion;
    private int imagen;
    private boolean selected;

    public Producto(String titulo, String descripcion, int imagen) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.selected = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
