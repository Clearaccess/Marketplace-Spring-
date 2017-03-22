package com.marketplace.spring.dao.oracleDAO;

import com.marketplace.spring.dao.BidDAO;
import com.marketplace.spring.dao.DAOFactory;
import com.marketplace.spring.dao.ItemDAO;
import com.marketplace.spring.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public class OracleDAOFactory extends DAOFactory {

    private static DataSource dataSource;

    public synchronized static Connection createConnection() throws SQLException, NamingException {
        Connection conn = dataSource.getConnection();
        return conn;
    }

    public void setDataSource(DataSource outDataSource){
        dataSource=outDataSource;
    }

    public UserDAO getUserDAO(){
        return new OracleUserDAO();
    }

    public ItemDAO getItemDAO(){
        return new OracleItemDAO();
    }

    public BidDAO getBidDAO(){
        return new OracleBidDAO();
    }
}
