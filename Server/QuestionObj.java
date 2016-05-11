public class QuestionObj {
	public int QuestionId;
	public int QuizId;
	public String Answer1;
	public String Answer2;
	public String Answer3;
	public String Answer4;
	public String CorrectAnswer;
	public String Question;
	
	public void putData(String Answer1, String Answer2, String Answer3, String Answer4, String CorrectAnswer, String Question){
		this.Answer1 = Answer1;
		this.Answer2 = Answer2;
		this.Answer3 = Answer3;
		this.Answer4 = Answer4;
		this.CorrectAnswer = CorrectAnswer;
		this.Question = Question;
	}
}
