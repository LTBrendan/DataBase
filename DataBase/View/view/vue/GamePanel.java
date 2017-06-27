package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import control.controller.GamePanelMouseListener;

/**
 * The panel where the player can execute the game
 */
public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel questionPanel;
	private JLabel questionLabel;

	private JPanel answerPanel;

	private JPanel answer1Panel;
	private JLabel answer1Label;
	private JLabel answer1CheckLabel;

	private JPanel answer2Panel;
	private JLabel answer2Label;
	private JLabel answer2CheckLabel;

	private JPanel answer3Panel;
	private JLabel answer3Label;
	private JLabel answer3CheckLabel;

	private JPanel answer4Panel;
	private JLabel answer4Label;
	private JLabel answer4CheckLabel;

	private JPanel validatePanel;
	private JLabel validateLabel;

	private JPanel selectedPanel;

	private int questionXP = 5;

	/**
	 * Generate the gamePanel with the question and the answers
	 * @param question the question
	 * @param answer1 the first answer
	 * @param answer2 the second answer
	 * @param answer3 the third answer
	 * @param answer4 the fourth answer
	 */
	public GamePanel(String question, String answer1, String answer2, String answer3, String answer4) {

		setLayout(new BorderLayout());
		setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		questionLabel = new JLabel("Question : " + question);
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE));
		questionLabel.setForeground(Color.WHITE);
		questionLabel.setPreferredSize(new Dimension(WorkPanel.width, WorkPanel.height / 15));

		answerPanel = new JPanel();
		answerPanel.setLayout(new GridLayout(2, 2, 0, 0));

		answer1Panel = new JPanel(new BorderLayout());
		answer1Panel.setPreferredSize(
				new Dimension(WorkPanel.width / 2, (WorkPanel.height - ((WorkPanel.height / 15) * 2)) / 2));
		answer1Panel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		answer1Label = new JLabel(answer1.substring(0, answer1.length() - 1));
		answer1Label.setHorizontalAlignment(SwingConstants.CENTER);
		answer1Label.setPreferredSize(new Dimension(answer1Panel.getWidth() / 2, answer1Panel.getHeight() / 2));
		answer1Label.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 2, Color.WHITE));
		answer1Label.setForeground(Color.WHITE);
		answer1Panel.addMouseListener(new GamePanelMouseListener());
		answer1Panel.add(answer1Label);

		answer1CheckLabel = new JLabel(answer1.substring(answer1.length() - 1));
		answer1CheckLabel.setVisible(false);
		answer1Panel.add(answer1CheckLabel, BorderLayout.SOUTH);

		answer2Panel = new JPanel(new BorderLayout());
		answer2Panel.setPreferredSize(
				new Dimension(WorkPanel.width / 2, (WorkPanel.height - ((WorkPanel.height / 15) * 2)) / 2));
		answer2Panel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		answer2Label = new JLabel(answer2.substring(0, answer2.length() - 1));
		answer2Label.setHorizontalAlignment(SwingConstants.CENTER);
		answer2Label.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 0, Color.WHITE));
		answer2Label.setForeground(Color.WHITE);
		answer2Panel.addMouseListener(new GamePanelMouseListener());
		answer2Panel.add(answer2Label);

		answer2CheckLabel = new JLabel(answer2.substring(answer2.length() - 1));
		answer2CheckLabel.setVisible(false);
		answer2Panel.add(answer2CheckLabel, BorderLayout.SOUTH);

		answer3Panel = new JPanel(new BorderLayout());
		answer3Panel.setPreferredSize(
				new Dimension(WorkPanel.width / 2, (WorkPanel.height - ((WorkPanel.height / 15) * 2)) / 2));
		answer3Panel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		answer3Label = new JLabel(answer3.substring(0, answer3.length() - 1));
		answer3Label.setHorizontalAlignment(SwingConstants.CENTER);
		answer3Label.setPreferredSize(new Dimension(answer3Panel.getWidth() / 2, answer3Panel.getHeight() / 2));
		answer3Label.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 2, Color.WHITE));
		answer3Label.setForeground(Color.WHITE);
		answer3Panel.addMouseListener(new GamePanelMouseListener());
		answer3Panel.add(answer3Label);

		answer3CheckLabel = new JLabel(answer3.substring(answer3.length() - 1));
		answer3CheckLabel.setVisible(false);
		answer3Panel.add(answer3CheckLabel, BorderLayout.SOUTH);

		answer4Panel = new JPanel(new BorderLayout());
		answer4Panel.setPreferredSize(
				new Dimension(WorkPanel.width / 2, (WorkPanel.height - ((WorkPanel.height / 15) * 2)) / 2));
		answer4Panel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		answer4Label = new JLabel(answer4.substring(0, answer4.length() - 1));
		answer4Label.setHorizontalAlignment(SwingConstants.CENTER);
		answer4Label.setPreferredSize(new Dimension(answer4Panel.getWidth() / 2, answer4Panel.getHeight() / 2));
		answer4Label.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 0, Color.WHITE));
		answer4Label.setForeground(Color.WHITE);
		answer4Panel.addMouseListener(new GamePanelMouseListener());
		answer4Panel.add(answer4Label);

		answer4CheckLabel = new JLabel(answer4.substring(answer4.length() - 1));
		answer4CheckLabel.setVisible(false);
		answer4Panel.add(answer4CheckLabel, BorderLayout.SOUTH);

		validatePanel = new JPanel(new BorderLayout());
		validatePanel.addMouseListener(new GamePanelMouseListener());
		validatePanel.setPreferredSize(new Dimension(WorkPanel.width, WorkPanel.height / 15));
		validatePanel.setBackground(new Color(AppFrame.color, AppFrame.color + 3, AppFrame.color + 8));

		validateLabel = new JLabel("Validate");
		validateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		validateLabel.setForeground(Color.WHITE);
		validateLabel.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.WHITE));
		validatePanel.add(validateLabel, BorderLayout.CENTER);

		answerPanel.add(answer1Panel);
		answerPanel.add(answer2Panel);
		answerPanel.add(answer3Panel);
		answerPanel.add(answer4Panel);

		add(questionLabel, BorderLayout.NORTH);
		add(answerPanel, BorderLayout.CENTER);
		add(validatePanel, BorderLayout.SOUTH);
	}

	/**
	 * Getter for the validateLabel
	 * @return the validataLabel
	 */
	public JLabel getValidateLabel() {
		return validateLabel;
	}

	/**
	 * Setter for the validateLabel
	 * @param validateLabel the new validateLabel
	 */
	public void setValidateLabel(JLabel validateLabel) {
		this.validateLabel = validateLabel;
	}

	/**
	 * Getter for the questionPanel
	 * @return the questionPanel
	 */
	public JPanel getQuestionPanel() {
		return questionPanel;
	}

	/**
	 * Getter for the questionLabel
	 * @return the questionLabel
	 */
	public JLabel getQuestionLabel() {
		return questionLabel;
	}

	/**
	 * Getter for the answerPanel
	 * @return the answerPanel
	 */
	public JPanel getAnswerPanel() {
		return answerPanel;
	}

	/**
	 * Getter for the answer1Panel
	 * @return the answer1Panel
	 */
	public JPanel getAnswer1Panel() {
		return answer1Panel;
	}

	/**
	 * Getter for the answer1Label
	 * @return the answer1Label
	 */
	public JLabel getAnswer1Label() {
		return answer1Label;
	}

	/**
	 * Getter for the answer1CheckLabel
	 * @return the answer1CheckLabel
	 */
	public JLabel getAnswer1CheckLabel() {
		return answer1CheckLabel;
	}

	/**
	 * Getter for the answer2Panel
	 * @return the answer2Panel
	 */
	public JPanel getAnswer2Panel() {
		return answer2Panel;
	}

	/**
	 * Getter for the answer2Label
	 * @return the answer2Label
	 */
	public JLabel getAnswer2Label() {
		return answer2Label;
	}

	/**
	 * Getter for the answer2CheckLabel
	 * @return the answer2CheckLabel
	 */
	public JLabel getAnswer2CheckLabel() {
		return answer2CheckLabel;
	}

	/**
	 * Getter for the answer3Panel
	 * @return the answer3Panel
	 */
	public JPanel getAnswer3Panel() {
		return answer3Panel;
	}

	/**
	 * Getter for the answer3Label
	 * @return the answer3Label
	 */
	public JLabel getAnswer3Label() {
		return answer3Label;
	}

	/**
	 * Getter for the answer3CheckLabel
	 * @return the answer3CheckLabel
	 */
	public JLabel getAnswer3CheckLabel() {
		return answer3CheckLabel;
	}

	/**
	 * Getter for the answer4Panel
	 * @return the answer4Panel
	 */
	public JPanel getAnswer4Panel() {
		return answer4Panel;
	}

	/**
	 * Getter for the answer4Label
	 * @return the answer4Label
	 */
	public JLabel getAnswer4Label() {
		return answer4Label;
	}

	/**
	 * Getter for the answer4CheckLabel
	 * @return the answer4CheckLabel
	 */
	public JLabel getAnswer4CheckLabel() {
		return answer4CheckLabel;
	}

	/**
	 * Getter for the validatePanel
	 * @return the validatePanel
	 */
	public JPanel getValidatePanel() {
		return validatePanel;
	}

	/**
	 * Getter for the selectedPanel
	 * @return the selectedPanel
	 */
	public JPanel getSelectedPanel() {
		return selectedPanel;
	}

	/**
	 * Setter for the selectedPanel
	 * @param selectedLabel the new selectedPanel
	 */
	public void setSelectedPanel(JPanel selectedPanel) {
		this.selectedPanel = selectedPanel;
	}

	/**
	 * Getter for the questionXP
	 * @return he questionXP
	 */
	public int getQuestionXP() {
		return questionXP;
	}

	/**
	 * Setter for the questionXP
	 * @param questionXP the new questionXP
	 */
	public void setQuestionXP(int questionXP) {
		this.questionXP = questionXP;
	}
}