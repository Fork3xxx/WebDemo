package bean;
import java.util.List;
public interface TitleDao {
	public List<Title> getTitles(); //���ͼ���б�
	public int add(Title titlebea); //���ͼ��
	public int delete(String isbn); //ɾ��ͼ��
	public int update(Title titlebean); //�޸�ͼ��
	public Title findByIsbn(String isbn); //������Ų���ͼ��

}
