package Modelo;

import java.util.ArrayList;

public interface DAO {
    public ArrayList<Informe> SelectAll();
    public Informe SelectByPay(int idPago);
    public Informe SelectByClient(int idCliente);
    public Informe SelectByOrder(int idOrden);
    public Informe SelectByProduct(int idProducto);
    public Informe SelectByInform(int idInforme);
    public boolean InsertInforme(int idInforme, int idCliente, int idOrden, int idPago, int idProducto);
    public boolean UpdateInformeById(int idInforme, int idCliente, int idOrden, int idPago, int idProducto);
    public boolean UpdateInformePagoById(int idCliente, int idInforme);
    public boolean UpdateInformeClienteById(int idCliente, int idInforme);
    public boolean UpdateInformeOrdenById(int idOrden, int idInforme);
    public boolean UpdateInformeProductoById(int idProducto, int idInforme);
    public boolean DeleteInformeById(int idInforme);

}
