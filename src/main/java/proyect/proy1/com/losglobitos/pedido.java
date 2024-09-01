package proyect.proy1.com.losglobitos;

import java.util.List;

public class pedido {
    private cliente cliente;
    private List<producto> productos;              
    private String estado;

    // Constructor
    public pedido(cliente cliente, List<producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
        this.estado = "En proceso";
    }

    // Getters y Setters
    public cliente getCliente() {
        return cliente;
    }

    public void setCliente(cliente cliente) {
        this.cliente = cliente;
    }

    public List<producto> getProductos() {
        return productos;
    }

    public void setProductos(List<producto> productos) {
        this.productos = productos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Método para actualizar estado del pedido
    public void actualizarEstado(String nuevoEstado) {
        this.estado = nuevoEstado;
    }
}
