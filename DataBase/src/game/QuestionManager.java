package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class QuestionManager {
	private HashMap<String, ArrayList<String>> questionList;
	private HashMap<String, ArrayList<String>> allQuestion;

	public QuestionManager() {
		this.generateQuestions();
	}

	public static void fillQuestionList(int questionNumber) {

	}

	public HashMap<String, ArrayList<String>> getQuestionList() {
		return this.questionList;
	}

	private void generateQuestions() {
		this.allQuestion = new HashMap<String, ArrayList<String>>();
		try {
			FileReader fr = new FileReader("questionAndAnswer.twt");
			BufferedReader bf = new BufferedReader(fr);
			Scanner sc = new Scanner(bf);
			sc.useDelimiter("\\s*:\\s*");
			String question = null;
			ArrayList<String> answers = new ArrayList<String>();
			String s;
			while (sc.hasNext() && (s = sc.next()) != null) {
				if (s.matches("[0-9].+")) {
					if (question != null) {
						this.allQuestion.put(question, answers);
						answers = new ArrayList<String>();
					}
					question = s;
				} else {
					answers.add(s);
				}
			}
			sc.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
