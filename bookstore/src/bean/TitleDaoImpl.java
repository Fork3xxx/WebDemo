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
	//��ȡͼ���Title�е�����ͼ�飬�������е�ͼ��Bean���б���
	public List<Title>getTitles(){
		List<Title> titlesList = new ArrayList<Title>();
		try {  						//��ȡͼ������ݼ�ResultSet results
			connection = DBcon.getConnection();
			titlesQuery = connection.prepareStatement("SELECT isbn,title,editionNumber,copyright,publisherID,imageFile,price FROM titles ORDER BY title");
			ResultSet results = titlesQuery.executeQuery();
			while(results.next()) {			//ѭ�����ж�ȡ����
				Title book = new Title();  //ÿ�д���һ����װͼ����Ϣ��Bean
				//��ͼ����е�ÿ����¼��װΪ����Bean����ӵ���������
				book.setIsbn(results.getString("isbn"));
				book.setTitle(results.getString("title"));
				book.setEditionNumber(results.getInt("editionNumber"));
				book.setCopyright(results.getString("copyright"));
				book.setPublisherId(results.getInt("publisherID"));
				book.setImageFile(results.getString("imageFile"));
				book.setPrice(results.getFloat("price"));
				titlesList.add(book);     //��ͼ��Bean��ӵ���������				
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
	//��ͼ���titles�в����¼�¼����������ͼ��Bean��ӵ�ͼ���titles��
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
		//�ͷ���Դ
		finally {
			DBcon.closeResultSet(results);
			DBcon.closeStatement(titlesQuery);
			DBcon.closeConnection(connection);
		}
		return result;
		
	}
	//����ͼ��ISBNɾ����¼
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
		//�ͷ���Դ
				finally {
					DBcon.closeResultSet(results);
					DBcon.closeStatement(titlesQuery);
					DBcon.closeConnection(connection);
				}
				return result;	
	}
	//����ͼ��Bean����ͼ���titles�е�ͼ���¼
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
		//�ͷ���Դ
				finally {
					DBcon.closeResultSet(results);
					DBcon.closeStatement(titlesQuery);
					DBcon.closeConnection(connection);
				}
				return result;	
	}
	//����ISBN����ͼ�飬�����ҵ���ͼ��Bean
	public Title findByIsbn(String isbn) {
		Title book = null;
		try {
			connection = DBcon.getConnection();
			titlesQuery = connection.prepareStatement("SELECT isbn,title,editionNumber,copyright,publisherID,imageFile,price FROM titles WHERE ISBN=? ORDER BY title");
			titlesQuery.setString(1, isbn);
			ResultSet results = titlesQuery.executeQuery();
			if(results.next()) {			
				book = new Title();  //ÿ�д���һ����װ���ʵ��
				//�����ݱ��е�һ����¼������ӵ���װ����
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
		//�ͷ���Դ
				finally {
					DBcon.closeResultSet(results);
					DBcon.closeStatement(titlesQuery);
					DBcon.closeConnection(connection);
				}
				return book;	
	}
	
	}
	

	

  
