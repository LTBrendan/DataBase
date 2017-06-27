package control.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * This class get the the questions from a file and put them into a list
 */
public class QuestionManager {
	
	private int questionNumber;
	private HashMap<String, ArrayList<String>> questionList;
	private HashMap<String, ArrayList<String>> allQuestion;

	/**
	 * The constructor
	 * @param questionNumber the number of question
	 */
	public QuestionManager(int questionNumber) {
		this.generateQuestions();
		this.setQuestionNumber(questionNumber);
		this.fillQuestionList();
	}

	/**
	 * Getter for the questionNumber
	 * @return the questionNumber
	 */
	public int getQuestionNumber() {
		return questionNumber;
	}

	/**
	 * Setter for the questionNumber
	 * @param questionNumber the new number of question
	 */
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	/**
	 * Fill the questionList with the right number of question
	 */
	private void fillQuestionList() {
		this.questionList = new HashMap<String, ArrayList<String>>();
		Object[] question = this.allQuestion.keySet().toArray();
		for (int i = 1; i <= this.questionNumber; i++) {
			String s = (String) question[i - 1];
			questionList.put(s, this.allQuestion.get(s));
		}
	}

	/**
	 * Getter for the questionList
	 * @return the questionList
	 */
	public HashMap<String, ArrayList<String>> getQuestionList() {
		return this.questionList;
	}

	/**
	 * Getter for all the questions
	 * @return all the questions
	 */
	public HashMap<String, ArrayList<String>> getAllQuestion() {
		return this.allQuestion;
	}

	/**
	 * This method generate all the questions and put them in a list
	 */
	private void generateQuestions() {
		this.allQuestion = new HashMap<String, ArrayList<String>>();
		try {
			FileReader fr = new FileReader("rsc/source/questionAndAnswer.txt");
			BufferedReader bf = new BufferedReader(fr);
			Scanner sc = new Scanner(bf);
			sc.useDelimiter("\\s*:\\s*");
			String question = null;
			ArrayList<String> answers = new ArrayList<String>();
			String s;
			while (sc.hasNext() && (s = sc.next()) != null) {
				if (s.matches("[A-Z].+")) {
					if (question != null) {
						this.allQuestion.put(question, answers);
						answers = new ArrayList<String>();
					}
					question = s;
				} else {
					answers.add(s);
				}
			}
			this.allQuestion.put(question, answers);
			sc.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
