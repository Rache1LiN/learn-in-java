
public class Change {
	private double score;

	public void ToGradeScore(){
		if(score<=100 && score>=90)
			System.out.println("��");
		else if(score<90 && score>=80)
			System.out.println("��");
		else if(score<80 && score>=70)
			System.out.println("��");
		else if(score<70 && score>=60)
			System.out.println("����");
		else if(score<60 && score>=0)
			System.out.println("������");
		else
			System.out.println("error!");
	}
	public void setScore(double score){
		this.score=score;
	}
}
