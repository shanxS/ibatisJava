import java.io.Reader;


import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class TestMain {
	public static void main(String[] args) throws Exception 
	{
		UserDao manager = new UserDaoIbatis();
		
		Reader reader = Resources.getResourceAsReader("sql-maps-config.xml");
		SqlMapClient sqlmapClient = SqlMapClientBuilder.buildSqlMapClient (reader);
		
		UserTEO user = new UserTEO();
		user.setId(1);
		user.setLastName("Dem");
		user.setFirstName("de");
		
		manager.addUser(user,sqlmapClient);
		
		//UserTEO createdUser = manager.getUserById(1, sqlmapClient);
		//System.out.println(createdUser.getFirstName());
		
		//manager.deleteUserById(1, sqlmapClient);
	}
}
