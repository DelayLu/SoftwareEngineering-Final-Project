import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuizDataManager {
	private Connection con;

	public QuizDataManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.err.println(e.toString());
		}
		String url = "jdbc:mysql://isel.cs.unb.ca:3306/cs2043team17aDB";
		try {
			con = DriverManager.getConnection(url, "cs2043team17a",
					"cs2043team17a");
		} catch (SQLException e) {
			System.err.println("Database connection error.");
		}
	}

	public ArrayList<QuizListObj> getAllQuizzes() {
		ArrayList<QuizListObj> quizlist = new ArrayList<QuizListObj>();

		try {
			Statement st = con.createStatement();
			String sqlQuery = "select * from QuizListTable;";
			ResultSet rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				QuizListObj quiz = new QuizListObj();
				quiz.QuizDescription = rs.getString(2);
				quiz.QuizType = rs.getString(3);
				quizlist.add(quiz);
			}

		} catch (SQLException e) {
			System.err.println("SQL error: getAllQuizzes");
		}
		return quizlist;
	}

	public ArrayList<QuestionObj> getAllQuestions() {
		ArrayList<QuestionObj> questionlist = new ArrayList<QuestionObj>();

		try {
			Statement st = con.createStatement();
			String sqlQuery = "select * from QuizQuestionTable;";
			ResultSet rs = st.executeQuery(sqlQuery);
			while (rs.next()) {
				QuestionObj question = new QuestionObj();
				question.QuestionId = rs.getInt(1);
				question.QuizId = rs.getInt(2);
				question.Answer1 = rs.getString(3);
				question.Answer2 = rs.getString(4);
				question.Answer3 = rs.getString(5);
				question.Answer4 = rs.getString(6);
				question.CorrectAnswer = rs.getString(7);
				question.Question = rs.getString(8);

				questionlist.add(question);
			}

		} catch (SQLException e) {
			System.err.println("SQL error: getAllQuestions");
		}
		return questionlist;
	}

	public void createQuiz(QuestionObj question) {
		try {
			Statement st = con.createStatement();
			String sqlQuery = "insert into QuizQuestionTable(Answer1, Answer2, Answer3, Answer4, CorrectAnswer, Question) values "
					+ "('"
					+ question.Answer1
					+ "', '"
					+ question.Answer2
					+ "', '"
					+ question.Answer3
					+ "', '"
					+ question.Answer4
					+ "', '"
					+ question.CorrectAnswer
					+ "', '"
					+ question.Question + "');";
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
		} catch (SQLException e) {
			System.err.println("SQL error: addQuizInfo");
		}

	}

	public boolean checkCorrectAnswer(int questionid, String answer) {
		boolean result = false;
		String correctAnswer;

		try {
			Statement st = con.createStatement();
			String sqlQuery = "select * from QuizQuestionTable where QuestionId = "
					+ questionid + ";";
			ResultSet rs = st.executeQuery(sqlQuery);
			correctAnswer = rs.getString(8);

			if (correctAnswer.equals(answer)) {
				result = true;
			} else {
				result = false;
			}

		} catch (SQLException e) {
			System.err.println("SQL error: getAllQuizzes");
		}
		return result;
	}

	public void addQuizInfo(QuizListObj quiz) {
		try {
			Statement st = con.createStatement();
			String sqlQuery = "insert into QuizListTable(QuizDescription, QuizType) values "
					+ "('"
					+ quiz.QuizDescription
					+ "','"
					+ quiz.QuizType
					+ "');";
			System.out.println(sqlQuery);
			st.executeUpdate(sqlQuery);
		} catch (SQLException e) {
			System.err.println("SQL error: addQuizInfo");
		}
	}

}
