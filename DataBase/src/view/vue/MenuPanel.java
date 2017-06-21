package view.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import control.controller.MenuPanelMouseListener;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel upPanel;
	private JLabel avatarLabel;
	private JLabel userNameLabel;
	private JSeparator separator;

	private JPanel downPanel;
	private JLabel home;
	private JLabel editor;
	private JLabel search;
	private JLabel visual;
	private JLabel stats;
	private JLabel game;
	private JLabel export;
	private JLabel admin;
	
	public static int height = LoginFrame.height;
	public static int width = LoginFrame.width / 100 * 6;

	private static MenuPanel menuPanel;

	public MenuPanel() {

		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		this.setLayout(new BorderLayout());

		this.add(createUpPanel(), BorderLayout.NORTH);
		this.add(createDownPanel(), BorderLayout.CENTER);

		menuPanel = this;
	}

	private JPanel createDownPanel() {

		downPanel = new JPanel(new GridLayout(8, 0));
		downPanel.setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));

		home = new JLabel();
		home.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		home.setToolTipText("Home");
		home.setHorizontalAlignment(downPanel.getWidth() / 2);
		home.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			home.setIcon(new ImageIcon("rsc\\stateBar\\homeWhite.PNG"));
		else
			home.setIcon(new ImageIcon("rsc\\stateBar\\homeBlack.PNG"));

		editor = new JLabel();
		editor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		editor.setToolTipText("editor");
		editor.setHorizontalAlignment(downPanel.getWidth() / 2);
		editor.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			editor.setIcon(new ImageIcon("rsc\\stateBar\\editorWhite.PNG"));
		else
			editor.setIcon(new ImageIcon("rsc\\stateBar\\editorBlack.PNG"));

		search = new JLabel();
		search.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		search.setToolTipText("search");
		search.setHorizontalAlignment(downPanel.getWidth() / 2);
		search.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			search.setIcon(new ImageIcon("rsc\\stateBar\\searchWhite.PNG"));
		else
			search.setIcon(new ImageIcon("rsc\\stateBar\\searchBlack.PNG"));

		visual = new JLabel();
		visual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		visual.setToolTipText("visual");
		visual.setHorizontalAlignment(downPanel.getWidth() / 2);
		visual.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			visual.setIcon(new ImageIcon("rsc\\stateBar\\visualWhite.PNG"));
		else
			visual.setIcon(new ImageIcon("rsc\\stateBar\\visualBlack.PNG"));

		stats = new JLabel();
		stats.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		stats.setToolTipText("Stats");
		stats.setHorizontalAlignment(downPanel.getWidth() / 2);
		stats.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			stats.setIcon(new ImageIcon("rsc\\stateBar\\statsWhite.PNG"));
		else
			stats.setIcon(new ImageIcon("rsc\\stateBar\\statsBlack.PNG"));

		game = new JLabel();
		game.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		game.setToolTipText("game");
		game.setHorizontalAlignment(downPanel.getWidth() / 2);
		game.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			game.setIcon(new ImageIcon("rsc\\stateBar\\gameWhite.PNG"));
		else
			game.setIcon(new ImageIcon("rsc\\stateBar\\gameBlack.PNG"));

		export = new JLabel();
		export.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		export.setToolTipText("export");
		export.setHorizontalAlignment(downPanel.getWidth() / 2);
		export.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			export.setIcon(new ImageIcon("rsc\\stateBar\\exportWhite.PNG"));
		else
			export.setIcon(new ImageIcon("rsc\\stateBar\\exportBlack.PNG"));

		admin = new JLabel();
		admin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		admin.setToolTipText("admin");
		admin.setHorizontalAlignment(downPanel.getWidth() / 2);
		admin.addMouseListener(new MenuPanelMouseListener());
		if (AppFrame.color == 54)
			admin.setIcon(new ImageIcon("rsc\\stateBar\\adminWhite.PNG"));
		else
			admin.setIcon(new ImageIcon("rsc\\stateBar\\adminBlack.PNG"));

		downPanel.add(home);
		downPanel.add(editor);
		downPanel.add(search);
		downPanel.add(visual);
		downPanel.add(stats);
		downPanel.add(game);
		downPanel.add(export);

		if (AppFrame.getAppFrame().getLauncherControler().getCurrentUserName().equals("admin"))
			downPanel.add(admin);

		return downPanel;
	}

	private JPanel createUpPanel() {

		upPanel = new JPanel(new BorderLayout());
		upPanel.setBackground(new Color(AppFrame.color - 24, AppFrame.color - 21, AppFrame.color - 18));
		upPanel.add(createAvatarLanel(), BorderLayout.NORTH);
		upPanel.add(createUserNameLabel(), BorderLayout.CENTER);
		upPanel.add(createSeparator(), BorderLayout.SOUTH);

		return upPanel;
	}

	private JLabel createAvatarLanel() {

		this.avatarLabel = new JLabel();
		this.avatarLabel.setHorizontalAlignment(SwingConstants.CENTER);
		this.avatarLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		this.avatarLabel.setIcon(new ImageIcon("rsc\\user-16.png"));
		this.avatarLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.avatarLabel.addMouseListener(new MenuPanelMouseListener());

		return this.avatarLabel;
	}

	private JLabel createUserNameLabel() {

		this.userNameLabel = new JLabel(AppFrame.getAppFrame().getLauncherControler().getCurrentUserName());
		if (AppFrame.color == 54)
			this.userNameLabel.setForeground(Color.WHITE);
		else
			this.userNameLabel.setForeground(Color.BLACK);
		this.userNameLabel.setFont(new Font("Calibri", Font.PLAIN, 15));
		this.userNameLabel.setHorizontalAlignment(SwingConstants.CENTER);

		return this.userNameLabel;
	}

	public JSeparator createSeparator() {

		this.separator = new JSeparator();

		return this.separator;
	}

	public static MenuPanel getMenuPanel() {
		return menuPanel;
	}

	public JComponent getAvatarLabel() {
		return menuPanel.avatarLabel;
	}

	public JComponent getUserNameLabel() {
		return menuPanel.userNameLabel;
	}

	public JLabel getHome() {
		return menuPanel.home;
	}

	public JLabel getEditor() {
		return menuPanel.editor;
	}

	public JLabel getSearch() {
		return menuPanel.search;
	}

	public JLabel getVisual() {
		return menuPanel.visual;
	}

	public JLabel getStats() {
		return menuPanel.stats;
	}

	public JLabel getGame() {
		return menuPanel.game;
	}

	public JLabel getExport() {
		return menuPanel.export;
	}

	public JLabel getAdmin() {
		return menuPanel.admin;
	}
}
