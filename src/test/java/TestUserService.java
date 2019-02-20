import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationcontext.xml")
public class TestUserService {
	@Autowired
	UserService us;
	
	public void testHello() {
		us.hello();
	}
	
	
	public void testlogin() {
		List<TPermission> list1=us.queryByUid(3084);
		for(TPermission per:list1) {
			System.out.println(per.getPname());
		}
		System.out.println("------------------整理后的---------------------");
		for(TPermission per1:us.genMenu(list1)) {
			//一级权限
			System.out.println(per1.getPname());
				for(TPermission per2:per1.getChildren()) {
					System.out.println("----"+per2.getPname());
				}
			
		}
		
	}
	
	
	public void testQuery() {
		//创建查询对象
		QueryUser query=new QueryUser();
		query.setSex("男");
		for(TUser user:us.queryByPage(2, query)) {
			System.out.println(user.getId()+"、"+user.getLoginname());
		}
		System.out.println("共"+us.queryPageCont(query)+"页");
	}
	
	
	public void testDeletes() {
		int[] ids= {3109,3141,3391};
		us.deleteByIds(ids);
	}
	
	
	public void testUpdate() {
		TUser user=new TUser();
		user.setId(3370);
//		TDep dep=new TDep();
//		dep.setId(6);
//		user.setDept(dep);
//		user.setEmail("update@123.com");
		user.setIsenabled(1);
//		user.setLoginname("update123");
//		user.setPassword("udpate123123");
//		user.setPicurl("update123.jpg");
//		user.setRealname("修改数据123");
//		user.setSex("女");
//		user.setUpdator(2000);
//		
//		user.setBirthday(new Date());
		try {
			us.updateUser(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testInsert() {
		TUser user=new TUser();
		TDep dep=new TDep();
		dep.setId(6);
		user.setDept(dep);
		user.setEmail("insert@123.com");
		user.setIsenabled(1);
		user.setLoginname("insert123-trans");
		user.setPassword("insert123123");
		user.setPicurl("insert123.jpg");
		user.setRealname("新增数据123");
		user.setSex("男");
		user.setCreator(1000);
		
		user.setBirthday(new Date());
		
		try {
			System.out.println(us.insertUser(user));
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
