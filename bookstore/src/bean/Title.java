package bean;

public class Title {
	private String isbn;				//ISBN��
	private String title;				//����
	private String copyright;			//��Ȩ
	private String imageFile;			//����ͼ���ļ�����
	private int editionNumber;			//�汾��
	private int publisherId;			//������
	private float price;				//�۸�
	//get ��  set������ͨ��source���ģ���Զ����ɣ����ٳ�����
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCopyright() {
		return copyright;
	}
	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}
	public String getImageFile() {
		return imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	public int getEditionNumber() {
		return editionNumber;
	}
	public void setEditionNumber(int editionNumber) {
		this.editionNumber = editionNumber;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
}
