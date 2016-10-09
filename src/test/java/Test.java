import com.cvnchina.emsquartz.service.business.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Primo on 2016/8/24.
 * project: EMSQuartz
 * package: PACKAGE_NAME
 * COPYRIGHT BY CVNCHINA 2016.
 */
public class Test {
    public static void main(String[] args) throws Exception {
//        String currentPath1=Test.class.getResource("../").getFile().toString();
//        System.out.println(currentPath1);
//        ApplicationContext ac = new ClassPathXmlApplicationContext("../EMSQuartz/WEB-INF/spring/business-config.xml");
//        UserServiceImpl userService = (UserServiceImpl) ac.getBean("userService");
//        userService.add();
//        System.out.println(userService.get2(1));

//        FlowService flowService = (FlowService) ac.getBean("flowService");
//        System.out.println(flowService.get("94003d29-a7b0-42f0-839c-fa609b209ff1"));

        //      User user = new User();
        //      user.setId(100);
        //      user.setUserName("admin100");
        //      user.setPassword("password100");
        //      user.setTrueName("小李4");
        //      user.setCreateTime(new Date());
        //
        //      userService.insert(user);   //受事务管理,抛出Exception时将回滚  (rollbackFor)
        Date date=new Date();//取时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
        date=calendar.getTime(); //这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);

        System.out.println(dateString);
    }
}
