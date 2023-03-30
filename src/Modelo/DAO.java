package Modelo;

import java.util.ArrayList;

public interface DAO {
    ArrayList<Informe> SelectAll();
    ArrayList<Informe> SelectByPay(int idPago);
    ArrayList<Informe> SelectByClient(int idCliente);
    ArrayList<Informe> SelectByOrder(int idOrden);
    ArrayList<Informe> SelectByProduct(int idProducto);
    ArrayList<Informe> SelectByInform(int idInforme);
    boolean InsertInforme(int idInforme, int idCliente, int idOrden, int idPago, int idProducto);
    boolean UpdateInformePagoById(int idCliente, int idInforme);
    boolean UpdateInformeClienteById(int idCliente, int idInforme);
    boolean UpdateInformeOrdenById(int idOrden, int idInforme);
    boolean UpdateInformeProductoById(int idProducto, int idInforme);
    boolean DeleteInformeById(int idInforme);

}
