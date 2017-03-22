package com.marketplace.spring.dao.oracleDAO;

import com.marketplace.spring.dao.BidDAO;
import com.marketplace.spring.models.Bid;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public class OracleBidDAO implements BidDAO {
    public long insert(Bid bid) {

        Connection conn = null;
        PreparedStatement ps = null;
        long bidId=0;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "INSERT INTO Bids(bidder_Id,item_Id,bid) VALUES(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, bid.getBidderId());
            ps.setLong(2, bid.getItemId());
            ps.setDouble(3, bid.getBid());
            ps.executeUpdate();
            bidId=getIdOfNewBid(conn);
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

        return bidId;
    }

    public void update(Bid bid){

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "UPDATE Bids SET bidder_Id=?, item_Id=?, bid=? WHERE bid_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, bid.getBidderId());
            ps.setLong(2, bid.getItemId());
            ps.setDouble(3, bid.getBid());
            ps.setLong(4, bid.getBidId());
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

    public void delete(Bid bid) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "DELETE FROM Bids WHERE bid_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, bid.getBidId());
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

    public void deleteByItemID(long id){
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "DELETE FROM Bids WHERE item_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
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

    public Bid getById(long id){

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Bid bid=null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "SELECT * FROM Bids WHERE bid_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            if(rs.next()) {
                bid=new Bid();
                bid.setBidId(rs.getLong("bid_Id"));
                bid.setBidderId(rs.getLong("bidder_Id"));
                bid.setItemId(rs.getLong("item_Id"));
                bid.setBid(rs.getDouble("bid"));
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

        return bid;
    }

    public ArrayList<Bid> getAll(){

        ArrayList<Bid> listBids=new ArrayList<Bid>();
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql="SELECT * FROM Bids";
            st=conn.createStatement();
            rs=st.executeQuery(sql);

            while (rs.next()) {
                Bid bid=new Bid();
                bid.setBidId(rs.getLong("bid_Id"));
                bid.setBidderId(rs.getLong("bidder_Id"));
                bid.setItemId(rs.getLong("item_Id"));
                bid.setBid(rs.getDouble("bid"));
                listBids.add(bid);
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

        return listBids;
    }

    public ArrayList<Bid> getAllByItemId(long id){

        ArrayList<Bid> listBids=new ArrayList<Bid>();
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql="SELECT * FROM Bids WHERE item_Id=?";
            ps=conn.prepareStatement(sql);
            ps.setLong(1,id);
            rs=ps.executeQuery();

            while (rs.next()) {
                Bid bid=new Bid();
                bid.setBidId(rs.getLong("bid_Id"));
                bid.setBidderId(rs.getLong("bidder_Id"));
                bid.setItemId(rs.getLong("item_Id"));
                bid.setBid(rs.getDouble("bid"));
                listBids.add(bid);
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

        return listBids;
    }

    public Bid getBestBidByItemId(long id){

        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Bid bid=null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql="SELECT * FROM Bids WHERE item_Id=? ORDER BY bid DESC";

            ps=conn.prepareStatement(sql);
            ps.setLong(1,id);
            rs=ps.executeQuery();
            bid=new Bid();

            if(rs.next()){
                bid.setBidId(rs.getLong("bid_Id"));
                bid.setBidderId(rs.getLong("bidder_Id"));
                bid.setItemId(rs.getLong("item_Id"));
                bid.setBid(rs.getDouble("bid"));
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

        return bid;
    }

    private long getIdOfNewBid(Connection conn) throws SQLException {
        String sql="SELECT bid_seq.currval FROM dual";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        rs.next();
        long bid_id=rs.getLong(1);
        return bid_id;
    }
}
