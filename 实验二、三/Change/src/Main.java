
public class Main {
	public static void main(String [] args)
	{
		double [] score={58,35,75,43,75,46,78,98};
		Change ch=new Change();
		for(int i=0;i<score.length;i++){
			System.out.print(score[i]+" ");
			ch.setScore(score[i]);
			ch.ToGradeScore();
		}
	}
}
