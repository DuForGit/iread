package iread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import com.iread.font.beans.po.UserPo;
import com.iread.font.beans.vo.RegisterVo;
import com.iread.font.beans.vo.SearchVo;
import com.iread.font.dao.RegisterUserMapper;
import com.iread.font.dao.SearchBooksMapper;
import com.iread.font.dao.SearchPublishMapper;
import com.iread.font.dao.SearchTypeMapper;
import com.iread.font.dao.SearchWriterMapper;
import com.iread.font.mvc.SearchBooksController;
import com.iread.font.service.SearchService;
import com.iread.font.service.impl.RegisterServiceImpl;
import com.iread.utils.SensitiveWordInTxtToSet;
import com.iread.utils.SensitiveWordUtil;

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
	public static void main(String[] args) throws Exception {
		String string = "你是不是傻逼，神经病，6666666666，火花火花或或，哈哈哈哈哈,习近平";
		Set<String> set =  SensitiveWordInTxtToSet.SENSITIVE_WORD_SET;
		SensitiveWordUtil.init(set);
		 System.out.println("语句中包含敏感词的个数为：" + set.size());
		 String filterStr = SensitiveWordUtil.replaceSensitiveWord(string, '*');
		 String filterStr2 = SensitiveWordUtil.replaceSensitiveWord(string, '*',SensitiveWordUtil.MaxMatchType);
		 System.out.println("filterStr: " + filterStr);
		 System.out.println("filterStr2: " + filterStr2);
		/*Set<String> s =  SensitiveWordInTxtToSet.SENSITIVE_WORD_SET;
		Iterator<String> its = s.iterator();
		while(its.hasNext()){
			System.out.println(its.next());
		}*/
		/*System.out.println(SensitiveWordUtil.class.getClassLoader());
		String t = SensitiveWordUtil.class.getClassLoader().getResource("sensitive.txt").getFile();
		String nt = t.replace("%20", " ");
		System.out.println(t);
		System.out.println(nt);
		//String t = "D:\\Program Files\\eclipse\\workspace\\iread\\target\\classes\\sensitive.txt";
		File f = new File(nt);
		InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk"); 
		BufferedReader buff = new BufferedReader(read);*/
		//String s;
		/*while((s=buff.readLine()) != null){
			System.out.println(s);
		}*/
	//	buff.close();
		//System.out.println(u);
		/*String t = "C:\\Users\\Administrator\\Desktop\\sensitive.txt";
		File f = new File(t);
		//BufferedReader buff = new BufferedReader(new FileReader(f));
		InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk"); 
		BufferedReader buff = new BufferedReader(read);
		String s;
		while((s=buff.readLine()) != null){
			System.out.println(s);
		}
		buff.close();*/
		//System.out.println(Thread.currentThread().getContextClassLoader().getResource("com.iread.utils.SensitiveWordUtil").getPath());
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
		
		//ApplicationContext fileContext = new ClassPathXmlApplicationContext("application.xml");
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
		//RegisterUserMapper.class
	//	RegisterServiceImpl reg = fileContext.getBean(RegisterServiceImpl.class);
		//System.out.println(reg.regisetUser("f", "5586", "6s56d"));
		/*UserPo p = new UserPo();
		RegisterVo v = new RegisterVo();
		v.setEmail("email");
		v.setName("name");
		v.setPassword("pass");
		int id = reg.register(v);
		System.out.println(id);*/
		/*p.setEmail("email");
		p.setName("name");
		p.setPass("pass");
		System.out.println(reg.regisetUser(p));
		System.out.println(p.getId());*/
		/*User u = new User();
		u.setName("方2");
		
		u.setEmail("2@qq.com");
		
		System.out.println(reg.regisetUser(u));
		int id= u.getId();
		System.out.println(id);
		UserInfomations ui = new UserInfomations();
		ui.setId(id);
		ui.setNickName("嘟嘟");
		ui.setGender("男");
		ui.setImageUri("1235484");
		UserIdentify uid = new UserIdentify();
		uid.setId(1);
		System.out.println(reg.regisetInfo(ui));
		System.out.println(uid.getId());*/
		
	}
}



















