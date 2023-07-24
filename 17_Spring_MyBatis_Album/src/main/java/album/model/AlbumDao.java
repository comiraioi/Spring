package album.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utility.Paging;

/* AlbumDao myAlbumDao = new AlbumDao(); */
@Component("myAlbumDao")
public class AlbumDao {
	
	/* mapper ����(album.xml) => namespace: album.AlbumBean */
	private String namespace = "album.AlbumBean";

	@Autowired	/* �ڵ����� ��ü(root-context.xml���� ����) ���� */
	SqlSessionTemplate sqlSessionTemplate;
		
	public AlbumDao() {
		System.out.println("������: AlbumDao()");
	}//������
	
	/* select, search */
	public List<AlbumBean> getAlbumList(Map<String, String> map, Paging pageInfo){
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		
		RowBounds rowBounds = new RowBounds(pageInfo.getOffset(), pageInfo.getLimit());
		System.out.println("offset:"+pageInfo.getOffset());	//�ǳʶ� ���ڵ� ��
		System.out.println("limit:"+pageInfo.getLimit());	//�� �������� ������ ���ڵ� ��(=pageSize)
		
		lists = sqlSessionTemplate.selectList(namespace+".GetAlbumList",map,rowBounds);
		System.out.println("lists.size(): "+lists.size());
		
		return lists;
	}
	
	public int getTotalCount(Map<String, String> map) {
		int totalCount = sqlSessionTemplate.selectOne(namespace+".GetTotalCount", map);
		
		return totalCount;
	}
	
	
	/* insert */
	public int insertAlbum(AlbumBean album) {
		int cnt = -1;
		//mapper ����(album.xml) => namespace: album.AlbumBean / id: InsertAlbum
		cnt = sqlSessionTemplate.insert(namespace+".InsertAlbum",album);	//��Ʈ�ѷ����� �ѱ� album ��ü
		
		return cnt;
	}
	
	/* select by num */
	public AlbumBean selectAlbumbyNum(int num) {
		AlbumBean album = null;
		album = sqlSessionTemplate.selectOne(namespace+".GetAlbum", num);	//��Ʈ�ѷ����� �ѱ� num
		
		return album;
	}
	
	/* update */
	public int updateAlbum(AlbumBean album) throws ParseException {
		/* �߸��� �ð� ������ �ֱ�
		String day = album.getDay();
		day = day.substring(0, day.indexOf(" "));
		album.setDay(day); */
		
		int cnt = -1;
		cnt = sqlSessionTemplate.update(namespace+".UpdateAlbum", album);	
		
		return cnt;
	}
	
	/* delete */
	public int deleteAlbum(int num) {
		int cnt = -1;
		cnt = sqlSessionTemplate.delete(namespace+".DeleteAlbum", num);		
		
		return cnt;
	}
	
	
}
