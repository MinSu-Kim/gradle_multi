package gradle_multi.api.dao;

import java.util.List;

import org.junit.Test;

import gradle_multi.api.AbstractTest;
import gradle_multi.api.daoImpl.PostDaoImpl;
import gradle_multi.common.dto.Criteria;
import gradle_multi.common.dto.PageMaker;
import gradle_multi.common.dto.Post;

public class PostDaoTest extends AbstractTest {
	private static PostDao postDao = new PostDaoImpl();
	
	@Test
	public void testSelectPostByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Post> list = postDao.selectPostByAll();
		log.debug("list.size() : " + list.size() );
	}

	@Test
	public void testListCriteria() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Criteria cri = new Criteria();
		cri.setPage(1);	//1page
		cri.setPerPageNum(20);//1page에 20개
		 try {
				List<Post> list = postDao.listCriteria(cri);
				for(Post p : list) {
					log.debug(p.toString());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Test
	public void testCountPaging() {

		Criteria cri = new Criteria();
		cri.setPage(10);	//10page
		cri.setPerPageNum(20);//1page당 20개
		
		
		try {
			int cnt = postDao.countPaging();
			log.debug("총 페이지 수 " + cnt);
			
			PageMaker pm = new PageMaker();
			pm.setCri(cri);
			pm.setTotalCount(cnt);
			
			log.debug(pm.toString());
			
			
			cri.setPage(1);	//10page
			cri.setPerPageNum(20);//1page당 20개
			pm.setCri(cri);
			pm.setTotalCount(cnt);
			log.debug(pm.toString());
			
			cri.setPage(20);	//10page
			cri.setPerPageNum(20);//1page당 20개
			pm.setCri(cri);
			pm.setTotalCount(cnt);
			log.debug(pm.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
