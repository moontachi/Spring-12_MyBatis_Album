package album.model;


import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// AlbumDao myAlbumDao = new AlbumDao();
@Component("myAlbumDao")
public class AlbumDao {
	
	@Autowired    //다른 곳에서 만든 객체를 이 변수에 넣어라
	SqlSessionTemplate sqlSessionTemplate; //root-context.xml에서 객체는 생성해놓은 상태이다
	
	public int insertAlbum(AlbumBean ab) {
		
		int cnt = sqlSessionTemplate.insert("album.AlbumBean.InsertAlbum",ab);
		//album.xml에 있는 namespace가 album.AlbumBean인 InserAlbum을 실행해라
		System.out.println("insertAlbum cnt : "+ cnt);
		
		return cnt;
	}
  
	public List<AlbumBean> getAlbumList() {
		List<AlbumBean> lists = new ArrayList<AlbumBean>();
		
		lists = sqlSessionTemplate.selectList("album.AlbumBean.GetAlbumList");
			
		return lists;
	}

	public int delete(int num) {
		
		int cnt = sqlSessionTemplate.delete("album.AlbumBean.DeleteAlbum", num);
		System.out.println("deleteAlbum cnt : " + cnt);
		return cnt;
	}

	public AlbumBean selectAlbum(int num) {
		// TODO Auto-generated method stub
		AlbumBean bean = sqlSessionTemplate.selectOne("album.AlbumBean.selectAlbum", num);
		return bean;
	}

	public int updateAlbum(AlbumBean ab) {
		
		int cnt =
			sqlSessionTemplate.update("album.AlbumBean.UpdateAlbum", ab);
		System.out.println("updateAlbum cnt : "+cnt );
		
		return cnt;
	}
	
	
	
	
	
}

//select의 경우 여러개는 selectList     <->    한개 경우  selectOne
