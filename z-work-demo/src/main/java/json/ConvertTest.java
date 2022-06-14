package json;

import cn.hutool.json.JSONUtil;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxu
 * @date 2022/6/14 13:31
 * @since
 */
public class ConvertTest {

  public static void main(String[] args) {
    //
      List<Student> students  = new ArrayList<>();
      students.add(new Student().setName("张三").setId("1"));
      students.add(new Student().setName("李五").setId("2"));
        System.out.println(JSONUtil.toJsonStr(students));
  }
}
