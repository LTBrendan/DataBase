package controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;


/**
 * The WindowResizer is used to resize the window when the user grab the edges
 * of the window it can't be instanced, so only {@link #WINDOW_RESIZER} is
 * usable
 * 
 * @author Daphnis
 *
 */
public final class WindowResizer extends MouseMovementAdapter implements SwingConstants {

	/**
	 * The only usable WindowResizer
	 */
	public static final WindowResizer WINDOW_RESIZER = new WindowResizer();

	/**
	 * The width of the border allowing the user to resize the window, default
	 * is 5
	 */
	public static final int BORDER_WIDTH = 5;

	/**
	 * The border that will be set on the Window, the color is transparent so it
	 * looks like the mouse is not in the window
	 */
	private static final LineBorder RESIZE_BORDER = new LineBorder(new Color(0, 0, 0, 1), BORDER_WIDTH);

	/**
	 * The frame that the WindowResizer will handle and resize according to the
	 * events dispensed
	 */
	private JFrame frame;

	/**
	 * Tell whether the frame is in full screen mode or not
	 */
	private boolean fullScreen;

	/**
	 * Tell if the user is currently resizing the window
	 */
	private boolean resizing;

	/**
	 * Last known X location of the mouse
	 */
	private int prevX = -1;

	/**
	 * Last known Y location of the mouse
	 */
	private int prevY = -1;

	/**
	 * The side the user picked to resize the window
	 */
	private int resizeSide = 0;

	/**
	 * Private constructor to restrict the number of WindowResizer to
	 * {@link #WINDOW_RESIZER}
	 */
	private WindowResizer() {
		super(false);
	}

	/**
	 * Register the window to handle to the WindowResizer
	 * Can only be set once
	 * @param frame the frame to handle
	 * @throws Exception if the WindowResizer already handle a frame
	 */
	public void register(JFrame frame) throws Exception {
		if (this.frame == null) {
			this.frame = frame;
			frame.getRootPane().setBorder(RESIZE_BORDER);
			frame.addMouseListener(this);
			frame.addMouseMotionListener(this);
		}else{
			throw new Exception("Window resizer already set");
		}
	}

	/**
	 * Toggle full screen mode so the window cannot be resized when in full screen
	 * works in pair with TitleBarAdapter
	 * If the frame is not null, 
	 * switching to full screen will remove the border to make the window
	 * bigger
	 * switching back to window state will re set the border
	 * @see TitleBarAdapter
	 */
	public void toggleFullScreen() {
		fullScreen = !fullScreen;
		if (frame != null)
			if (fullScreen)
				frame.getRootPane().setBorder(null);
			else
				frame.getRootPane().setBorder(RESIZE_BORDER);

	}

	/**
	 * If the mouse is pressed and the window is not in full screen,
	 * the resizing boolean is set to true to indicate that the window 
	 * can be resized
	 */
	public void onMousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e) && !fullScreen)
			resizing = true;
	}

	/**
	 * Change the cursor appearance according to the location of the mouse
	 */
	public void onMouseMoved(MouseEvent e) {
		if (!fullScreen) {
			prevX = e.getXOnScreen();
			prevY = e.getYOnScreen();
			resizeSide = 0;
			if (prevX < frame.getX() + BORDER_WIDTH)
				resizeSide = WEST;

			else if (prevX > frame.getX() + frame.getWidth() - BORDER_WIDTH)
				resizeSide = EAST;

			if (prevY < frame.getY() + BORDER_WIDTH)
				resizeSide = resizeSide == 3 ? NORTH_EAST : resizeSide == 7 ? NORTH_WEST : NORTH;

			else if (prevY > frame.getY() + frame.getHeight() - BORDER_WIDTH)
				resizeSide = resizeSide == 3 ? SOUTH_EAST : resizeSide == 7 ? SOUTH_WEST : SOUTH;

			frame.setCursor(getCursor());
		}
	}

	/**
	 * Resize the window according to the movement of the mouse and the resizeSide selected
	 * If the resize request is bigger than the maximum size or smaller than the minimum size
	 * the window won't be resized
	 */
	public void onMouseDragged(MouseEvent e) {
		if (prevX != -1 && prevY != -1 && resizing) {
			Rectangle rect = frame.getBounds();
			int x_movement = e.getXOnScreen() - prevX;
			int y_movement = e.getYOnScreen() - prevY;

			if (resizeSide == WEST || resizeSide == NORTH_WEST || resizeSide == SOUTH_WEST) {
				if (prevX > rect.x  - BORDER_WIDTH)
					x_movement = 0;
			} else if (resizeSide == EAST || resizeSide == NORTH_EAST || resizeSide == SOUTH_EAST) {
				if (prevX < rect.x + rect.width - BORDER_WIDTH)
					x_movement = 0;
			}

			if (resizeSide == NORTH || resizeSide == NORTH_EAST || resizeSide == NORTH_WEST) {
				if (prevY > rect.y - BORDER_WIDTH)
					y_movement = 0;
			} else if (resizeSide == SOUTH || resizeSide == SOUTH_EAST || resizeSide == SOUTH_WEST) {
				if (prevY < rect.y + rect.height - BORDER_WIDTH)
					y_movement = 0;
			}

			if (x_movement != 0 || y_movement != 0) {
				int new_width = rect.width;
				int new_height = rect.height;
				int new_x = rect.x;
				int new_y = rect.y;

				if (resizeSide == EAST || resizeSide == NORTH_EAST || resizeSide == SOUTH_EAST) {
					new_width = rect.width + x_movement;
				} else if (resizeSide == WEST || resizeSide == NORTH_WEST || resizeSide == SOUTH_WEST) {
					new_width = rect.width - x_movement;
					new_x = rect.x + x_movement;
				}

				if (resizeSide == NORTH || resizeSide == NORTH_WEST || resizeSide == NORTH_EAST) {
					new_height = rect.height - y_movement;
					new_y = rect.y + y_movement;
				}

				else if (resizeSide == SOUTH || resizeSide == SOUTH_WEST || resizeSide == SOUTH_EAST) {
					new_height = rect.height + y_movement;
				}

				if (new_height <= frame.getMaximumSize().height && new_height >= frame.getMinimumSize().height
						&& new_width <= frame.getMaximumSize().width && new_width >= frame.getMinimumSize().width)
					frame.setBounds(new_x, new_y, new_width, new_height);
				else {
					if (new_height > frame.getMaximumSize().height)
						frame.setBounds(rect.x, rect.y, rect.width, frame.getMaximumSize().height);
					if (new_height < frame.getMinimumSize().height)
						frame.setBounds(rect.x, rect.y, rect.width, frame.getMinimumSize().height);
					if (new_width > frame.getMaximumSize().width)
						frame.setBounds(rect.x, rect.y, frame.getMaximumSize().width, rect.height);
					if (new_width < frame.getMinimumSize().width)
						frame.setBounds(rect.x, rect.y, frame.getMinimumSize().width, rect.height);
				}

			}

		}

		prevX = e.getXOnScreen();
		prevY = e.getYOnScreen();

	}

	/**
	 * Set the resizing boolean to false
	 * The left button needs to be pressed to resize the window
	 * Reset the cursor appearance by invoking {@link #onMouseMoved}
	 */
	public void onMouseReleased(MouseEvent e) {
		resizing = false;
		onMouseMoved(e);
	}

	/**
	 * Get the Cursor appearance according to the resizeSide choosen 
	 * @return the new cursor
	 */
	private Cursor getCursor() {
		Cursor cursor = null;

		switch (resizeSide) {
		case EAST:
			cursor = new Cursor(Cursor.E_RESIZE_CURSOR);
			break;
		case WEST:
			cursor = new Cursor(Cursor.W_RESIZE_CURSOR);
			break;
		case NORTH:
			cursor = new Cursor(Cursor.N_RESIZE_CURSOR);
			break;
		case SOUTH:
			cursor = new Cursor(Cursor.S_RESIZE_CURSOR);
			break;
		case NORTH_WEST:
			cursor = new Cursor(Cursor.NW_RESIZE_CURSOR);
			break;
		case NORTH_EAST:
			cursor = new Cursor(Cursor.NE_RESIZE_CURSOR);
			break;
		case SOUTH_WEST:
			cursor = new Cursor(Cursor.SW_RESIZE_CURSOR);
			break;
		case SOUTH_EAST:
			cursor = new Cursor(Cursor.SE_RESIZE_CURSOR);
			break;
		}

		return cursor;
	}

}