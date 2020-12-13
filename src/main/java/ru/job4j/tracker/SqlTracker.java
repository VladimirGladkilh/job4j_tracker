package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {
    private Connection cn;

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }
    public SqlTracker() {
        init();
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement st = cn.prepareStatement("insert into items (name) values (?)", Statement.RETURN_GENERATED_KEYS);){
            st.setString(1, item.getName());
            st.executeUpdate();
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getString(1));
                    return item;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new IllegalStateException("Could not create new user");
    }

    @Override
    public boolean replace(String id, Item item) {
        try (PreparedStatement st = cn.prepareStatement("update items set name=? where id=?", Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, item.getName());
            st.setInt(2, Integer.valueOf(id));
            int res = st.executeUpdate();
            if (res > 0) {
                item.setId(id);
            }
            return res > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try (PreparedStatement st = cn.prepareStatement("delete from items where id=?")){
            st.setInt(1, Integer.valueOf(id));
            int rs = st.executeUpdate();
            return rs > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return false;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items");){
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Item item = new Item(rs.getString(2));
                item.setId(rs.getString(1));
                itemList.add(item);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return itemList;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> itemList = new ArrayList<>();
        try (PreparedStatement st = cn.prepareStatement("select * from items where name = ?");){
            st.setString(1, key);
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                Item item = new Item(rs.getString(2));
                item.setId(rs.getString(1));
                itemList.add(item);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return itemList;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try (PreparedStatement st = cn.prepareStatement("select * from items where id = ?");){
            st.setInt(1, Integer.valueOf(id));
            st.executeQuery();
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                item = new Item( rs.getString(2));
                item.setId(rs.getString(1));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
        return item;
    }
}