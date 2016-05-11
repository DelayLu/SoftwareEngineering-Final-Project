public class adminMakeQuizControl {
	private QuizDataManager dm;

	public adminMakeQuizControl(QuizDataManager dm) {
		this.dm = dm;
	}

	public boolean processQuiz(QuizListObj quiz) {
		dm.addQuizInfo(quiz);

		return true;
	}

	public boolean processQuestion(QuestionObj questionInfo) {
		dm.createQuiz(questionInfo);

		return true;
	}

}