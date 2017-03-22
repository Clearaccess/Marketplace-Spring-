package com.marketplace.spring.dao.oracleDAO;
import com.marketplace.spring.dao.ItemDAO;
import com.marketplace.spring.models.Item;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Aleksandr_Vaniukov on 1/17/2017.
 */
public class OracleItemDAO implements ItemDAO {
    public long insert(Item item) {
        Connection conn = null;
        PreparedStatement ps = null;
        long itemId = 0;
        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "INSERT INTO Items(seller_Id, title, description, start_Price, time_Left, start_Bidding_Date, buy_It_Now, bid_Increment) VALUES(?,?,?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, item.getSellerId());
            ps.setString(2, item.getTitle());
            ps.setString(3, item.getDescription());
            ps.setDouble(4, item.getStartPrice());
            ps.setLong(5, item.getTimeLeft());
            ps.setDate(6, item.getStartBiddingDate());
            ps.setBoolean(7, item.isBuyItNow());
            ps.setDouble(8, item.getBidIncrement());
            ps.executeUpdate();
            itemId = getIdOfNewItem(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return itemId;
    }

    public void update(Item item) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "UPDATE Items SET seller_Id=?, title=?, description=?, start_Price=?, time_Left=?, start_Bidding_Date=?, buy_It_Now=?, bid_Increment=? WHERE item_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, item.getSellerId());
            ps.setString(2, item.getTitle());
            ps.setString(3, item.getDescription());
            ps.setDouble(4, item.getStartPrice());
            ps.setLong(5, item.getTimeLeft());
            ps.setDate(6, item.getStartBiddingDate());
            ps.setBoolean(7, item.isBuyItNow());
            ps.setDouble(8, item.getBidIncrement());
            ps.setLong(9, item.getItemId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Item item) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "DELETE FROM Items WHERE item_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, item.getItemId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Item getById(long id) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Item item = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "SELECT * FROM Items WHERE item_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            item = new Item();
            if (rs.next()) {
                item.setItemId(rs.getLong("item_Id"));
                item.setSellerId(rs.getLong("seller_Id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setTimeLeft(rs.getLong("time_Left"));
                item.setStartPrice(rs.getDouble("start_Price"));
                item.setStartBiddingDate(rs.getDate("start_Bidding_Date"));
                item.setBuyItNow(rs.getBoolean("buy_It_Now"));
                item.setBidIncrement(rs.getDouble("bid_Increment"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return item;
    }

    // 1 - UID
    // 2 - Title
    // 3 - Description
    public ArrayList<Item> getItemsBySubstr(int field, String substr) {

        ArrayList<Item> listItems = new ArrayList<Item>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "SELECT * FROM Items WHERE " + defRow(field) + " LIKE ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + substr + "%");
            rs = ps.executeQuery();

            while (rs.next()) {

                Item item = new Item();

                item.setItemId(rs.getLong("item_Id"));
                item.setSellerId(rs.getLong("seller_Id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setTimeLeft(rs.getLong("time_Left"));
                item.setStartPrice(rs.getDouble("start_Price"));
                item.setStartBiddingDate(rs.getDate("start_Bidding_Date"));
                item.setBuyItNow(rs.getBoolean("buy_It_Now"));
                item.setBidIncrement(rs.getDouble("bid_Increment"));

                listItems.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listItems;
    }

    public ArrayList<Item> getItemsBySellerId(long id) {

        ArrayList<Item> listItemsOfSeller = new ArrayList<Item>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "SELECT * FROM Items WHERE seller_Id=?";
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {

                Item item = new Item();

                item.setItemId(rs.getLong("item_Id"));
                item.setSellerId(rs.getLong("seller_Id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setTimeLeft(rs.getLong("time_Left"));
                item.setStartPrice(rs.getDouble("start_Price"));
                item.setStartBiddingDate(rs.getDate("start_Bidding_Date"));
                item.setBuyItNow(rs.getBoolean("buy_It_Now"));
                item.setBidIncrement(rs.getDouble("bid_Increment"));

                listItemsOfSeller.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listItemsOfSeller;
    }

    public ArrayList<Item> getAll() {

        ArrayList<Item> listItems = new ArrayList<Item>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = OracleDAOFactory.createConnection();
            String sql = "SELECT * FROM Items";
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Item item = new Item();

                item.setItemId(rs.getLong("item_Id"));
                item.setSellerId(rs.getLong("seller_Id"));
                item.setTitle(rs.getString("title"));
                item.setDescription(rs.getString("description"));
                item.setTimeLeft(rs.getLong("time_Left"));
                item.setStartPrice(rs.getDouble("start_Price"));
                item.setStartBiddingDate(rs.getDate("start_Bidding_Date"));
                item.setBuyItNow(rs.getBoolean("buy_It_Now"));
                item.setBidIncrement(rs.getDouble("bid_Increment"));

                listItems.add(item);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return listItems;
    }

    private long getIdOfNewItem(Connection conn) throws SQLException {
        String sql = "SELECT item_seq.currval FROM dual";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        rs.next();
        long item_id = rs.getLong(1);
        return item_id;
    }

    private String defRow(int value) {
        switch (value) {
            case 1:
                return "item_Id";
            case 2:
                return "title";
            default:
                return "description";
        }
    }
}
