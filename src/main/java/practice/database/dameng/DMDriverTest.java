package practice.database.dameng;

import java.sql.*;

/**
 * @author zhaoxu
 * @date 2022/4/25 13:49
 * @since
 */
public class DMDriverTest {

    //mysql
    private static final String DRIVER =  "com.mysql.cj.jdbc.Driver";

    private static final String URL = "jdbc:mysql://localhost:3306/chart?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "root";

    //dm
    private static final String DRIVER_DM =  "dm.jdbc.driver.DmDriver";

    private static final String URL_DM = "jdbc:dm://10.7.212.101:5236/dmdbms?zeroDateTimeBehavior=convertToNull&useUnicode=true&characterEncoding=utf-8";

    private static final String USER_NAME_DM = "SYSDBA";

    private static final String PASSWORD_DM = "SYSDBA";


    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            // load drivers
            Class.forName(DRIVER_DM);
            connection = DriverManager.getConnection(URL_DM,USER_NAME_DM,PASSWORD_DM);
            //sql

            //String sql = "select dbms_metadata.get_ddl('TABLE','TEST_BIG_DATA','wilkinson') from dual";

            String sql = "select txt from wilkinson.TEST_BIG_DATA";

            //创建preparedStatement
            preparedStatement = connection.prepareStatement(sql);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                //System.out.println(resultSet.getString("id"));
                System.out.println(resultSet.getString(1));

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();

        }
    }
}
