package dao;

import dao.oracleDAO.OracleDAOFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.fail;

/**
 * Created by Aleksandr_Vaniukov on 2/15/2017.
 */
public class TestOracleDAOFactory {
    @Test
    public void getConnect(){
        try {
            OracleDAOFactory.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            fail();
        }
    }
}
