package iread;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.iread.beans.domain.Book;
import com.iread.beans.domain.Publish;
import com.iread.beans.domain.Type;
import com.iread.beans.domain.User;
import com.iread.beans.domain.UserIdentify;
import com.iread.beans.domain.UserInfomations;
import com.iread.beans.domain.Writer;
import com.iread.font.beans.vo.SearchVo;
import com.iread.font.dao.RegisterUserMapper;
import com.iread.font.dao.SearchBooksMapper;
import com.iread.font.dao.SearchPublishMapper;
import com.iread.font.dao.SearchTypeMapper;
import com.iread.font.dao.SearchWriterMapper;
import com.iread.font.mvc.SearchBooksController;
import com.iread.font.service.SearchService;

/**
 *项目名称: iread
 *类名称: Test
 *类描述: 
 *创建人: Administrator
 *创建时间: 2017年11月13日下午5:16:22
 * @version
 * @author 方秋都
 *
 */
public class Test {
	public static void main(String[] args) {
		/*ApplicationContext fileContext = new ClassPathXmlApplicationContext("application.xml");
		SqlSessionFactory bean = (SqlSessionFactory) fileContext.getBean("sqlSessionFactory");
		SearchBooksMapper booksmapper = (SearchBooksMapper)bean.openSession().getMapper(com.iread.font.dao.SearchBooksMapper.class);
		Book b =  booksmapper.getBooksById(1);
		System.out.println(b);*/
		
		/*ApplicationContext fileContext = new ClassPathXmlApplicationContext("application.xml");
		SqlSession sql = (SqlSession) fileContext.getBean("sqlSession");
		BooksMapper booksmapper = sql.getMapper(com.iread.font.dao.BooksMapper.class);
		List<Book> b =  booksmapper.getBooksById(1);
		System.out.println(b.isEmpty());*/
		
		/*ApplicationContext fileContext = new ClassPathXmlApplicationContext("application.xml");*/
		/*SearchBooksMapper booksMapper = (SearchBooksMapper) fileContext.getBean("searchBooksMapper");
		Writer w = new Writer();
		Publish p = new Publish();
		Type t = new Type();
		w.setName("莫言");
		p.setName("中信");
		Book book = new Book();
		book.setPublish(p);
		book.setWriter(w);
		t.setName("zhic");
		book.setType(t);
		book.setTitle("三体"); 
		List<Book> b =  booksMapper.getBooks(book);
		System.out.println(b.isEmpty());*/
		
		/*Book b = (Book) fileContext.getBean("book");
		System.out.println(b);*/
		
		/*ApplicationContext fileContext = new ClassPathXmlApplicationContext("application.xml");
		SearchTypeMapper mapper = fileContext.getBean(SearchTypeMapper.class);
		List<Integer> tIds = mapper.getIdsByGeneralType("社会科学");
		System.out.println(tIds);
		System.out.println(tIds.isEmpty());
		tIds.add(1);
		tIds.add(2);
		tIds.add(3);
		SearchBooksMapper mapper2 = fileContext.getBean(SearchBooksMapper.class);
		List<Book> books = mapper2.getBooksByIds(tIds);
		System.out.println(books.isEmpty());
		System.out.println(books);*/
		
		ApplicationContext fileContext = new ClassPathXmlApplicationContext("application.xml");
		/*SearchPublishMapper mapper = fileContext.getBean(SearchPublishMapper.class);
		List<Integer> tIds = mapper.getIdsByGeneralPublish("中信");
		System.out.println(tIds);
		System.out.println(tIds.isEmpty());*/
/*		ApplicationContext fileContext = new ClassPathXmlApplicationContext("application.xml");
		SearchWriterMapper mapper = fileContext.getBean(SearchWriterMapper.class);
		List<Integer> tIds = mapper.getWriterIds("莫言");
		System.out.println(tIds);
		System.out.println(tIds.isEmpty());
*/		
		/*SearchService searchService = fileContext.getBean(SearchService.class);
		List<Book> books = searchService.searchBooks("出版社", "..");
		System.out.println(books);*/
		
		/*SearchBooksController search = fileContext.getBean(SearchBooksController.class);
		SearchVo vo = new SearchVo();vo.setInfo("莫言");vo.setTypes("作家");
		List<Book> books = search.searchBooks(vo);
		System.out.println(books);*/
		RegisterUserMapper reg = fileContext.getBean(RegisterUserMapper.class);
		User u = new User();
		u.setName("方2");
		u.setPass("2");
		u.setEmail("2@qq.com");
		u.setPhone(2l);
		System.out.println(reg.regisetUser(u));
		int id= u.getId();
		System.out.println(id);
		UserInfomations ui = new UserInfomations();
		ui.setId(id);
		ui.setNickName("嘟嘟");
		ui.setGender("男");
		ui.setImageUri(1235484L);
		UserIdentify uid = new UserIdentify();
		uid.setId(1);
		ui.setIden(uid);
		System.out.println(reg.regisetInfo(ui));
		System.out.println(uid.getId());
		
	}
}



















