package gradle_multi.common.dao;

import java.util.List;

import gradle_multi.common.dto.Criteria;
import gradle_multi.common.dto.Post;

public interface PostDao {
	List<Post> selectPostByAll();
	
	List<Post> listCriteria(Criteria cri) ;
	int countPaging();
}
