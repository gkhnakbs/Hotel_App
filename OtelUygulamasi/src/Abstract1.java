import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

public abstract class Abstract1 {
    public void updateTime(String timeTerm,String stuffUsername){
        Connection connection;
        PreparedStatement statement = null;
        try {
            connection = DbHelper.getConnection();// db bağlantısı için gerekli
            statement = connection.prepareStatement("UPDATE stuff SET stuff_"+timeTerm+"='" + LocalDateTime.now().toString().substring(0,19) + "' WHERE stuff_username='" + stuffUsername+"'");
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
