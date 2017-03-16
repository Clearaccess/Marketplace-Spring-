package dao;

import dao.oracleDAO.OracleDAOFactory;
import dao.oracleDAO.OracleItemDAO;
import org.junit.Test;
import to.Item;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Aleksandr_Vaniukov on 2/15/2017.
 */
public class TestOracleItemDAO {
    @Test
    public void getConnect() {
        DAOFactory oracleDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE);
        ItemDAO itemDAO = oracleDAO.getItemDAO();
        itemDAO.getAll();
    }

    @Test
    public void getAllItemsBySubstr() {
        DAOFactory oracleDAO = DAOFactory.getDAOFactory(DAOFactory.ORACLE);
        ItemDAO itemDAO = oracleDAO.getItemDAO();
        ArrayList<Item> items=itemDAO.getItemsBySubstr(1,"3");
        assertTrue(items.size()!=0);
    }
}
