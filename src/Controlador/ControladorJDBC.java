package Controlador;

import Modelo.Informe;
import Modelo.Conexion;
import Modelo.DAO;

import java.sql.*;
import java.util.ArrayList;

public class ControladorJDBC implements DAO {
    public final String SELECT_ALL = "SELECT * FROM informe";
    public final String SELECT_BY_INFORM = "SELECT * FROM informe WHERE idInforme = ?";
    public final String SELECT_BY_CLIENT = "SELECT * FROM informe WHERE idCliente = ?";
    public final String SELECT_BY_ORDER = "SELECT * FROM informe WHERE idOrden = ?";
    public final String SELECT_BY_PAY = "SELECT * FROM informe WHERE idPago = ?";
    public final String SELECT_BY_PRODUCT = "SELECT * FROM informe WHERE idProducto = ?";
    public final String INSERT_INFORME = "INSERT INTO informe (idInforme, idCliente, idOrden, idPago, idProducto) VALUES (?, ?, ?, ?, ?)";
    public final String UPDATE_INFORME_PAGO_BY_ID = "UPDATE informe SET idPago = ? WHERE idInforme = ?";
    public final String UPDATE_INFORME_CLIENTE_BY_ID = "UPDATE informe SET idCliente = ? WHERE idInforme = ?";
    public final String UPDATE_INFORME_ORDEN_BY_ID = "UPDATE informe SET idOrden = ? WHERE idInforme = ?";
    public final String UPDATE_INFORME_PRODUCTO_BY_ID = "UPDATE informe SET idProducto = ? WHERE idInforme = ?";
    public final String DELETE_INFORME_BY_ID = "DELETE FROM informe WHERE idInforme = ?";

    private Connection conexion;

    public ControladorJDBC() {
        Conexion conector = new Conexion("root", "3306", "127.0.0.1", "jdbc:mysql:", "tiendaonline", "root", "jdbc:mysql://127.0.0.1:3306/tiendaonline");
        try {
            conexion = conector.AbrirConexion();
        } catch (Exception e) {
            e.printStackTrace();
            conexion = null;
        }
    }
    @Override
    public ArrayList<Informe> SelectAll() {
        ArrayList<Informe> lista = new ArrayList<>();
        try {
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Informe b = new Informe(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            lista = null;
        }
        return lista;
    }

    @Override
    public ArrayList<Informe> SelectByPay(int idPago) {
        return getInforme(idPago, SELECT_BY_PAY);

    }
    @Override
    public ArrayList<Informe> SelectByClient(int idCliente) {
        return getInforme(idCliente, SELECT_BY_CLIENT);
    }

    @Override
    public ArrayList<Informe> SelectByOrder(int idOrden) {
        return getInforme(idOrden, SELECT_BY_ORDER);
    }

    @Override
    public ArrayList<Informe> SelectByProduct(int idProducto) {
        return getInforme(idProducto, SELECT_BY_PRODUCT);
    }

    @Override
    public ArrayList<Informe> SelectByInform(int idInforme) {
        return getInforme(idInforme, SELECT_BY_INFORM);
    }

    public ArrayList<Informe> getInforme(int id, String selectBy) {
        ArrayList<Informe> lista = new ArrayList<>();
        try {
            PreparedStatement ps = conexion.prepareStatement(selectBy);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Informe b = new Informe(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return lista;
    }

    @Override
    public boolean InsertInforme(int idInforme, int idCliente, int idOrden, int idPago, int idProducto) {
        try {
            PreparedStatement ps = conexion.prepareStatement(INSERT_INFORME);
            ps.setInt(1, idInforme);
            ps.setInt(2, idCliente);
            ps.setInt(3, idOrden);
            ps.setInt(4, idPago);
            ps.setInt(5, idProducto);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UpdateInformePagoById(int idPago, int idInforme) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_INFORME_PAGO_BY_ID);
            ps.setInt(1, idPago);
            ps.setInt(2, idInforme);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UpdateInformeClienteById(int idCliente, int idInforme) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_INFORME_CLIENTE_BY_ID);
            ps.setInt(1, idCliente);
            ps.setInt(2, idInforme);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UpdateInformeOrdenById(int idOrden, int idInforme) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_INFORME_ORDEN_BY_ID);
            ps.setInt(1, idOrden);
            ps.setInt(2, idInforme);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean UpdateInformeProductoById(int idProducto, int idInforme) {
        try {
            PreparedStatement ps = conexion.prepareStatement(UPDATE_INFORME_PRODUCTO_BY_ID);
            ps.setInt(1, idProducto);
            ps.setInt(2, idInforme);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean DeleteInformeById(int idInforme) {
        try {
            PreparedStatement ps = conexion.prepareStatement(DELETE_INFORME_BY_ID);
            ps.setInt(1, idInforme);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
