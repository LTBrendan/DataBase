package controller;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Define a MouseAdapter that can re-dispatch events to the main frame in order
 * to make the WindowResizer work in every case
 * 
 * @see WindowResizer
 * @author Daphnis
 *
 */
public abstract class MouseMovementAdapter extends MouseAdapter {

	/**
	 * The frame where the events should be re-dispatched
	 */
	protected static JFrame MAIN_FRAME;

	/**
	 * Tell whether the events needs to be re-dispatched or not
	 */
	private final boolean reDispatch;

	/**
	 * Create an new MouseMovementAdapter that will always re-dispatch events
	 */
	public MouseMovementAdapter() {
		this(true);
	}

	/**
	 * Create a MouseMovementAdapter where it is possible to choose whether to
	 * re-dispatch the events to the main frame or just use them as they should
	 * be by default
	 * 
	 * @param reDispatch
	 *            true if events needs to be re-dispatched, false otherwise
	 */
	public MouseMovementAdapter(boolean redispatch) {
		this.reDispatch = redispatch;
	}

	/**
	 * Override MouseAdapter mouseClicked method and make it final so the user
	 * of the class cannot redefine it and are obliged to use onMouseClicked
	 */
	@Override
	public final void mouseClicked(MouseEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMouseClicked(e);
	}

	/**
	 * Override MouseAdapter mouseDragged method and make it final so the user
	 * of the class cannot redefine it and are obliged to use onMouseDragged
	 */
	@Override
	public final void mouseDragged(MouseEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMouseDragged(e);
	}

	/**
	 * Override MouseAdapter mouseEntered method and make it final so the user
	 * of the class cannot redefine it and are obliged to use onMouseEntered
	 */
	@Override
	public final void mouseEntered(MouseEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMouseEntered(e);
	}

	/**
	 * Override MouseAdapter mouseExited method and make it final so the user of
	 * the class cannot redefine it and are obliged to use onMouseExited
	 */
	@Override
	public final void mouseExited(MouseEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMouseExited(e);
	}

	/**
	 * Override MouseAdapter mouseMoved method and make it final so the user of
	 * the class cannot redefine it and are obliged to use onMouseMoved
	 */
	@Override
	public final void mouseMoved(MouseEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMouseMoved(e);
	}

	/**
	 * Override MouseAdapter mousePressed method and make it final so the user
	 * of the class cannot redefine it and are obliged to use onMousePressed
	 */
	@Override
	public final void mousePressed(MouseEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMousePressed(e);
	}

	/**
	 * Override MouseAdapter mouseReleased method and make it final so the user
	 * of the class cannot redefine it and are obliged to use onMouseReleased
	 */
	@Override
	public final void mouseReleased(MouseEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMouseReleased(e);
	}

	/**
	 * Override MouseAdapter mouseWheelMoved method and make it final so the
	 * user of the class cannot redefine it and are obliged to use
	 * onMouseWheelMoved
	 */
	@Override
	public final void mouseWheelMoved(MouseWheelEvent e) {
		if (reDispatch)
			redispatchToMainFrame(e);
		onMouseWheelMoved(e);
	}

	/**
	 * Called when there is a mousePressed event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMousePressed(MouseEvent e) {
	}

	/**
	 * Called when there is a mouseReleased event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMouseReleased(MouseEvent e) {
	}

	/**
	 * Called when there is a mouseWheelMoved event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMouseWheelMoved(MouseEvent e) {
	}

	/**
	 * Called when there is a mouseMoved event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMouseMoved(MouseEvent e) {
	}

	/**
	 * Called when there is a mouseEntered event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMouseEntered(MouseEvent e) {
	}

	/**
	 * Called when there is a mouseExited event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMouseExited(MouseEvent e) {
	}

	/**
	 * Called when there is a mouseDragged event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMouseDragged(MouseEvent e) {
	}

	/**
	 * Called when there is a mouseClicked event Can be overridden in the
	 * subclasses
	 * 
	 * @param e
	 *            the mouse event
	 */
	public void onMouseClicked(MouseEvent e) {
	}

	/**
	 * If reDispatch is equal to true every mouseListener and
	 * mouseMotionListener of the main frame is updated with the right event
	 * 
	 * @param e the mouseEvent
	 */
	private final void redispatchToMainFrame(MouseEvent e) {
		if (MAIN_FRAME != null) {
			int id = e.getID();

			Point p = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), MAIN_FRAME);
			MouseEvent event = new MouseEvent(MAIN_FRAME, id, e.getWhen(), e.getModifiers(), p.x, p.y,
					e.getClickCount(), e.isPopupTrigger(), e.getButton());

			for (MouseMotionListener listener : MAIN_FRAME.getMouseMotionListeners()) {
				if (id == MouseEvent.MOUSE_DRAGGED)
					listener.mouseDragged(event);
				else if (id == MouseEvent.MOUSE_MOVED)
					listener.mouseMoved(event);

			}

			for (MouseListener listener : MAIN_FRAME.getMouseListeners()) {
				if (id == MouseEvent.MOUSE_CLICKED)
					listener.mouseClicked(event);
				else if (id == MouseEvent.MOUSE_ENTERED)
					listener.mouseEntered(event);
				else if (id == MouseEvent.MOUSE_EXITED)
					listener.mouseExited(event);
				else if (id == MouseEvent.MOUSE_PRESSED)
					listener.mousePressed(event);
				else if (id == MouseEvent.MOUSE_RELEASED)
					listener.mouseReleased(event);
			}
		}
	}

	/**
	 * Set the Main frame for the WindowResizer Can only be set once
	 * 
	 * @param FRAME
	 *            the main frame where the events are re-dispatched
	 */
	public static void setMAIN_FRAME(JFrame FRAME) {
		if (MAIN_FRAME == null)
			MAIN_FRAME = FRAME;
	}

}
