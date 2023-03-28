package Modelo;

public class Informe {
    int idInforme;
    int idCliente;
    int idOrden;
    int idPago;
    int idProducto;

    public Informe(int idInforme, int idCliente, int idOrden, int idPago, int idProducto) {
        this.idInforme = idInforme;
        this.idCliente = idCliente;
        this.idOrden = idOrden;
        this.idPago = idPago;
        this.idProducto = idProducto;
    }

    public int getIdInforme() {
        return idInforme;
    }

    public void setIdInforme(int idInforme) {
        this.idInforme = idInforme;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public String toString() {
        return "Informe{" +
                "idInforme=" + idInforme +
                ", idCliente=" + idCliente +
                ", idOrden=" + idOrden +
                ", idPago=" + idPago +
                ", idProducto=" + idProducto +
                '}';
    }
}
