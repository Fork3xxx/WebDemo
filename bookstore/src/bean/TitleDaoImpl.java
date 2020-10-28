package bean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;


public class TitleDaoImpl implements TitleDao {
	private Connection connection;
	private PreparedStatement titlesQuery;
	private ResultSet results;
	//获取图书表Title中的所有图书，返回所有的图书Bean的列表集合
	public List<Title>getTitles(){
		List<Title> titlesList = new ArrayList<Title>();
		try {  						//获取图书表数据集ResultSet results
			connection = DBcon.getConnection();
			titlesQuery = connection.prepareStatement("SELECT isbn,title,editionNumber,copyright,publisherID,imageFile,price FROM titles ORDER BY title");
			ResultSet results = titlesQuery.executeQuery();
			while(results.next()) {			//循环逐行读取数据
				Title book = new Title();  //每行创建一个封装图书信息的Bean
				//将图书表中的每条记录封装为数据Bean并添加到集合类中
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditionNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherId(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));
				titlesList.add(book);     //将图书Bean添加到集合类中				
			}
		}
		catch(SQLException exception) {exception.printStackTrace();}
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		
		}
		return titlesList;	
	}
	//在图书表titles中插入新纪录，将给定的图书Bean添加到图书表titles中
	public int add(Title titlebean) {
		int result = 0;
		try {
			connection = DBcon.getConnection();
			String sql = "insert into titles(isbn,titile,editionNumber,";
			sql +="copyright,publicsherID,imageFile,price) values(?,?,?,?,?,?,?)";
			titlesQuery = connection.prepareStatement(sql);
			titlesQuery.setString(1, titlebean.getIsbn());
			titlesQuery.setString(2, titlebean.getTitle());
			titlesQuery.setInt(3, titlebean.getEditionNumber());
			titlesQuery.setString(4, titlebean.getCopyright());
			titlesQuery.setInt(5, titlebean.getPublisherId());
			titlesQuery.setString(6, titlebean.getImageFile());
			titlesQuery.setFloat(7, titlebean.getPrice());
			result = titlesQuery.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//释放资源
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}
		return result;
		
	}
	//根据图书ISBN删除记录
	public int delete(String isbn) {
		int result = 0;
		try {
			connection = DBcon.getConnection();
			String sql = "delete from titles where isbn = '"+ isbn +"'";
			titlesQuery = connection.prepareStatement(sql);
			result = titlesQuery.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		//释放资源
				finally {
					DBcon.closeResultSet(results);
					DBcon.closeStatement(titlesQuery);
					DBcon.closeConnection(connection);
				}
				return result;	
	}
	//根据图书Bean更新图书表titles中的图书记录
	public int update(Title titlebean) {
		int result = 0;
		try {
			connection = DBcon.getConnection();
			String sql = "update titles set title = ?, editionNumber = ?,";
			titlesQuery = connection.prepareStatement(sql);
			titlesQuery.setString(1, titlebean.getIsbn());
			titlesQuery.setString(2, titlebean.getTitle());
			titlesQuery.setInt(3, titlebean.getEditionNumber());
			titlesQuery.setString(4, titlebean.getCopyright());
			titlesQuery.setInt(5, titlebean.getPublisherId());
			titlesQuery.setString(6, titlebean.getImageFile());
			titlesQuery.setFloat(7, titlebean.getPrice());
			result = titlesQuery.executeUpdate();				
		}catch(Exception e) {
			e.printStackTrace();
		}
		//释放资源
				finally {
					DBcon.closeResultSet(results);
					DBcon.closeStatement(titlesQuery);
					DBcon.closeConnection(connection);
				}
				return result;	
	}
	//根据ISBN查找图书，返回找到的图书Bean
	public Title findByIsbn(String isbn) {
		Title book = null;
		try {
			connection = DBcon.getConnection();
			titlesQuery = connection.prepareStatement("SELECT isbn,title,editionNumber,copyright,publisherID,imageFile,price FROM titles WHERE ISBN=? ORDER BY title");
			titlesQuery.setString(1, isbn);
			ResultSet results = titlesQuery.executeQuery();
			if(results.next()) {			
				book = new Title();  //每行创建一个封装类的实例
				//将数据表中的一条记录数据添加到封装类中
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditionNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherId(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));
					
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//释放资源
				finally {
					DBcon.closeResultSet(results);
					DBcon.closeStatement(titlesQuery);
					DBcon.closeConnection(connection);
				}
				return book;	
	}
	
	}
	

	

  
