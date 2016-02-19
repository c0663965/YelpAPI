package YelpData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBconnection {

    private String db = "test";
    private String table = "bistro";

    public String getDb() {
        return db;
    }

    public String getTable() {
        return table;
    }

    private Connection getConnection() throws SQLException {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

//        String host=System.getenv("OPENSHIFT_MYSQL_DB_HOST");
//        String port=System.getenv("OPENSHIFT_MYSQL_DB_PORT");
//        String username=System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
//        String password=System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
//        String name = "dbsample";
        String url = "jdbc:mysql://localhost:3306/" + db;

        return DriverManager.getConnection(url, "root", "");
    }

    public void createTable() {
        try {
            Connection connection = getConnection();

            Statement stmt = connection.createStatement();

            stmt.executeUpdate("DROP TABLE IF EXISTS " + table);

            String sql = "CREATE TABLE IF NOT EXISTS " + table
                    + "(ID INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,"
                    + "NAME VARCHAR(50),"
                    + "MENU VARCHAR(50),"
                    + "PHONE VARCHAR(20),"
                    + "ADDRESS VARCHAR(100),"
                    + "POSTAL_CODE VARCHAR(20),"
                    + "COUNTRY_CODE VARCHAR(3),"
                    + "LATITUDE DECIMAL(20,17),"
                    + "LONGITUDE DECIMAL(20,17),"
                    + "MOBILE_URL VARCHAR(200),"
                    + "RATING VARCHAR(4),"
                    + "RATING_IMAGE_URL VARCHAR(200),"
                    + "SNIPPET_TEXT VARCHAR(300));";

            stmt.executeUpdate(sql);

            connection.close();
        } catch (SQLException ex) {
            System.out.println("SQL Exception" + ex.getMessage());
        }
    }

    public void insertData(List<Restaurant> data) {

        try {
            Connection connection = getConnection();

            String sql = "insert into " + db + "." + table
                    + " (NAME,MENU,PHONE,ADDRESS,POSTAL_CODE,COUNTRY_CODE,LATITUDE,LONGITUDE,MOBILE_URL,RATING,RATING_IMAGE_URL,SNIPPET_TEXT)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement ps = connection.prepareStatement(sql);

            int batchSize=data.size();
            
            for (int i=0;i<batchSize;i++) 
            {
                ps.setString(1,data.get(i).getNAME());
                ps.setString(2,data.get(i).getMENU());
                ps.setString(3,data.get(i).getPHONE());
                ps.setString(4,data.get(i).getADDRESS());
                ps.setString(5,data.get(i).getPOSTAL_CODE());
                ps.setString(6,data.get(i).getCOUNTRY_CODE());
                ps.setDouble(7,data.get(i).getLATITUDE());
                ps.setDouble(8,data.get(i).getLONGITUDE());
                ps.setString(9,data.get(i).getMOBILE_URL());
                ps.setString(10,data.get(i).getRATING());
                ps.setString(11,data.get(i).getRATING_IMAGE_URL());
                ps.setString(12,data.get(i).getSNIPPET_TEXT());
                
                ps.addBatch();
                
                if((i+1)%batchSize==0)
                    ps.executeBatch();
            }

            ps.close();

            connection.close();
            
        } catch (SQLException ex) {
            System.out.println("SQL Exception" + ex.getMessage());
        }
    }

//    public List<Restaurant> retrieveData() {
//
//        List<Restaurant> list = new ArrayList<>();
//
//        try {
//            Connection conn = getConnection();
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM " + table);
//
//            while (rs.next()) {
//                Restaurant bistro = new Restaurant();
//
//                bistro.setNAME(rs.getString("NAME"));
//                bistro.setMENU(rs.getString("MENU"));
//                bistro.setPHONE(rs.getString("PHONE"));
//                bistro.setADDRESS(rs.getString("ADDRESS"));
//                bistro.setPOSTAL_CODE(rs.getString("POSTAL_CODE"));
//                bistro.setLATITUDE(rs.getDouble("LATITUDE"));
//                bistro.setLONGITUDE(rs.getDouble("LONGITUDE"));
//                bistro.setMOBILE_URL(rs.getString("MOBILE_URL"));
//                bistro.setRATING(rs.getString("RATING"));
//                bistro.setRATING_IMAGE_URL(rs.getString("RATING_IMAGE_URL"));
//                bistro.setSNIPPET_TEXT(rs.getString("SNIPPET_TEXT"));
//
//                list.add(bistro);
//            }
//
//            conn.close();
//            
//        } catch (SQLException ex) {
//            System.out.println("SQL Exception" + ex.getMessage());
//        }
//
//        return list;
//    }
}