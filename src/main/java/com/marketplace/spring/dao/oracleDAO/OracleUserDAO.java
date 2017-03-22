package com.marketplace.spring.dao.oracleDAO;

import com.marketplace.spring.dao.UserDAO;
import com.marketplace.spring.models.User;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public class OracleUserDAO implements UserDAO {

    public long insert(User user){
        Connection conn = null;
        PreparedStatement ps = null;
        Statement st=null;
        long idNewUser=0;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "INSERT INTO Users(full_name,billing_Address,login,password) VALUES(?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getBillingAddress());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            idNewUser=getIdOfNewUser(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null) {
                    ps.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return idNewUser;
    }

    public void update(User user){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "UPDATE Users SET full_name=?,billing_Address=?,login=?,password=? WHERE user_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, user.getFullName());
            ps.setString(2, user.getBillingAddress());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.setLong(5, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null) {
                    ps.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(User user){

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "DELETE FROM Users WHERE user_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(ps!=null) {
                    ps.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public User getById(long id){

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;

        try{
            conn= OracleDAOFactory.createConnection();
            String sql="SELECT * FROM Users WHERE user_Id=?";
            ps=conn.prepareStatement(sql);
            ps.setLong(1,id);
            rs=ps.executeQuery();

            user=new User();
            if(rs.next()){
                user.setUserId(rs.getLong("user_Id"));
                user.setFullName(rs.getString("full_Name"));
                user.setBillingAddress(rs.getString("billing_Address"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
                if(ps!=null) {
                    ps.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public User getByLogin(String login) {

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;

        try{
            conn= OracleDAOFactory.createConnection();
            String sql="SELECT * FROM Users WHERE login=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,login);
            rs=ps.executeQuery();

            if(rs.next()) {
                user=new User();
                user.setUserId(rs.getLong("user_Id"));
                user.setFullName(rs.getString("full_Name"));
                user.setBillingAddress(rs.getString("billing_Address"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {

            try {
                if(rs!=null) {
                    rs.close();
                }
                if(ps!=null) {
                    ps.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }

    public ArrayList<User> getAll(){

        ArrayList<User>listUsers=new ArrayList<User>();
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try{
            conn= OracleDAOFactory.createConnection();
            String sql="SELECT * FROM Users";
            st=conn.createStatement();
            rs=st.executeQuery(sql);

            while(rs.next()){
                User user=new User();
                user.setUserId(rs.getLong("user_Id"));
                user.setFullName(rs.getString("full_Name"));
                user.setBillingAddress(rs.getString("billing_Address"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                listUsers.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs!=null) {
                    rs.close();
                }
                if(st!=null) {
                    st.close();
                }
                if(conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listUsers;
    }

    private long getIdOfNewUser(Connection conn) throws SQLException {
        String sql="SELECT user_seq.currval FROM dual";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        rs.next();
        long user_id=rs.getLong(1);
        return user_id;
    }
}
