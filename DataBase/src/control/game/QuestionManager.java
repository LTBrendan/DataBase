package control.game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class QuestionManager {
	private int questionNumber;
	private HashMap<String, ArrayList<String>> questionList;
	private HashMap<String, ArrayList<String>> allQuestion;

	public QuestionManager(int questionNumber) {
		this.generateQuestions();
		this.setQuestionNumber (questionNumber);
		this.fillQuestionList();
	}

	public int getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}

	private void fillQuestionList() {
		this.questionList = new HashMap<String, ArrayList<String>>();
		Object[] question = this.allQuestion.keySet().toArray();
		for (int i = 1; i <= this.questionNumber; i++) {
			int index = (int)Math.random()*50;
			String s = (String)question[index];
			if (!questionList.containsKey(s)) {
				questionList.put(s, this.allQuestion.get(s));
			}
		}
	}

	public HashMap<String, ArrayList<String>> getQuestionList() {
		return this.questionList;
	}
	
	public HashMap<String, ArrayList<String>> getAllQuestion() {
		return this.allQuestion;
	}

	private void generateQuestions() {
		this.allQuestion = new HashMap<String, ArrayList<String>>();
		try {
			FileReader fr = new FileReader("source/questionAndAnswer.txt");
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
