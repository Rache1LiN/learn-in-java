import java.io.Serializable;
public class Student implements Serializable, Comparable<Student>{
	private static final long serialVersionUID = 1234L;
	private String name;
	private long studentID;
	private String sex;
	Student()
	{
		
	}
	Student(long StudentId,String name,String sex)
	{
		this.studentID=StudentId;
		this.name=name;
		this.sex=sex;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setNumber(long studentID)
	{
		this.studentID=studentID;
	}
	public void setSex(String sex)
	{
		this.sex=sex;
	}
	public String getName()
	{
		return name;
	}
	public long getNumber()
	{
		return studentID;
	}
	public String getSex()
	{
		return sex;
	}
	public int compareTo(Student s)
	{
		return Long.compare(studentID, s.studentID);
	}
}
