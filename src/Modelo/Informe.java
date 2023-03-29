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

    @Override
    public String toString() {
        return "\nInforme{" +
                "idInforme=" + idInforme +
                ", idCliente=" + idCliente +
                ", idOrden=" + idOrden +
                ", idPago=" + idPago +
                ", idProducto=" + idProducto +
                "}";
    }
}
