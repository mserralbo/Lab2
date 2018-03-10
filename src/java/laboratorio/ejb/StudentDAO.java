
package laboratorio.ejb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.sql.DataSource;
import laboratorio.Student;

@Stateless
@LocalBean
public class StudentDAO {
   @Resource(name="jdbc/estudiante")
   private DataSource ds;
   
   public void addStudent(Student student){
       String sql="INSERT INTO ESTUDIANTE VALUES('"+ student.getId()+"','"+ student.getName()+"','"+ student.getSurname()+"','"+ student.getAge()+"','"+ student.getGroup()+"','"+ student.getSpecialty()+"'";
       executeModifyQuery(sql);
      }
   public void editStudent(Student student){
       String sql="UPDATE ESTUDIANTE SET NAME='"+ student.getName()+"', SURNAME='"+ student.getSurname()+"',AGE='"+ student.getAge()+"',GROUP= '"+ student.getGroup()+"',SPECIALTY= '"+ student.getSpecialty()+"' WHERE ID='"+ student.getId()+"'";
       executeModifyQuery(sql);
   
   }
   public void deleteStudent(Student student){
       String sql="DELETE FROM ESTUDIANTE WHERE ID='"+ student.getId()+"'";
       executeModifyQuery(sql);
   
   }
   public Student getStudent(int id){
   Student student= new Student();
   String sql= "SELECT * FROM ESTUDIANTE WHERE ID='"+ id+"'";
   System.out.println(sql);
   ResultSet rs= executeFetchQuery(sql);
   try{
    if(rs.next()){
    student.setId(rs.getInt("ID"));
    student.setName(rs.getString("NAME"));
    student.setSurname(rs.getString("SURNAME"));
    student.setAge(rs.getInt("AGE"));
    student.setGroup(rs.getString("GROUP"));
    student.setSpecialty(rs.getString("SPECIALTY"));
    }
   }catch (SQLException ex) {
   System.err.println("GS" + ex.getMessage());
   }
   return student;
  }
   
   public ArrayList<Student> getAllStudent(){
   ArrayList<Student> list= new ArrayList<Student>();
   String sql= "SELECT * FROM ESTUDIANTE";
   ResultSet rs= executeFetchQuery(sql);
   try{
     while(rs.next()){
     Student student=new Student();
     student.setId(rs.getInt("ID"));
     student.setName(rs.getString("NAME"));
     student.setSurname(rs.getString("SURNAME"));
     student.setAge(rs.getInt("AGE"));
     student.setGroup(rs.getString("GROUP"));
     student.setSpecialty(rs.getString("SPECIALTY"));
     list.add(student);
     }
   } catch (SQLException ex){
   System.err.println(ex.getMessage());
   }
   return list;
   }
   
      public void executeModifyQuery(String sql){
   try{
     Connection conn=ds.getConnection();
     conn.createStatement().execute(sql);
     conn.close();
   } catch (SQLException e){
   System.err.println(e.getMessage());
   }
    
    
   }
   public ResultSet executeFetchQuery(String sql){
       ResultSet rs=null;
   try{
     Connection conn=ds.getConnection();
     rs=conn.createStatement().executeQuery(sql);
     conn.close();
   } catch (SQLException e){
   System.err.println(e.getMessage());
   }    
    
    return rs;
   }
    
}
