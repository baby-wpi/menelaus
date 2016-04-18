package menelaus.controllers;

import menelaus.model.basic.Point;
import menelaus.view.KabasujiPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

/**
 * Created by frankegan on 4/16/16.
 */
public class MouseManager {

    /** Handle Clicked, Pressed, Released, Entered, Exited. */
    protected MouseAdapter eventManager = null;

    /** Handle Moved, Dragged. */
    protected MouseMotionAdapter moveEventManager = null;

    /** Remember our home. */
    protected KabasujiPanel home = null;

    /** Determines whether there is a drag in progress. */
    protected boolean dragging = false;

    /** Coordinates of the last Drag event. */
    protected java.awt.Point lastDrag;

    /** The undo adapter associated with this mouseManager. */
    protected UndoAdapter undoAdapter;

    /**
     * MouseManager constructor comment.
     */
    public MouseManager(KabasujiPanel c) {
        super();

        // Always remember our KabasujiPanel structure so we can propagate state.
        home = c;
    }

    /**
     * Return point of last drag from the KabasujiPanel.
     */
    protected Point getLastDrag() {
        if (home == null) {
            throw new IllegalArgumentException ("MouseManager::getLastDrag() called when no KabasujiPanel is set.");
        }

        // return KabasujiPanel status
        return home.getLastDrag();
    }

    /**
     * Returns the Undo Adapter already in place.
     *
     * @return UndoAdapter
     */
    public UndoAdapter getUndoAdapter() {
        return undoAdapter;
    }

    /**
     * Deliver the event to the proper controller.
     * <p>
     * Also maintain the state value of 'dragging'.
     * <p>
     * Mouse clicks with the Right button are converted into UNDO events;
     * <p>
     * To enable troubleshooting, all Exceptions are caught here...
     * @param me java.awt.event.MouseEvent
     */
    public void handleMouseEvent(MouseEvent me) {

        // deal with RIGHT button events separately
        if ((me.getModifiers() & MouseEvent.BUTTON3_MASK) == MouseEvent.BUTTON3_MASK) {
            if (me.getID() == MouseEvent.MOUSE_PRESSED) {

                // ignore undo requests if a drag is in process...
                if (getLastDrag() != null) {
                    // alert user that something will not be processed.
                    java.awt.Toolkit.getDefaultToolkit().beep();
                    return;
                }

                // undo right away
                if (undoAdapter != null)
                    undoAdapter.undoRequested();
            }
            return;
        }

        try {
            switch (me.getID()) {
                /** MouseListener events. */
                case MouseEvent.MOUSE_CLICKED:
                    if (eventManager != null) eventManager.mouseClicked(me);
                    setLastDrag (null);  // certainly no dragging going on here.
                    return;

                case MouseEvent.MOUSE_ENTERED:
                    if (eventManager != null) eventManager.mouseEntered(me);
                    return;

                case MouseEvent.MOUSE_EXITED:
                    if (eventManager != null) eventManager.mouseExited(me);
                    return;

                case MouseEvent.MOUSE_RELEASED:
                    if (eventManager != null) eventManager.mouseReleased(me);
                    setLastDrag (null);  // cancel dragging AFTER processing release
                    return;

                case MouseEvent.MOUSE_PRESSED:
                    // at this point, we don't know if user is dragging, so we
                    // place our bets wisely: First we handle the press event, then
                    // we would like to call the initDrag() method, which should take
                    // care to draw the moving widget directly on the screen. However,
                    // because of a delay in processing, the mouse button may have been
                    // rapidly dragged to a new location. Since there is no ability to
                    // find where the mouse currently is, we will defer this capability
                    // Serious flicker will only occur in those widgets that have both 
                    // mouseClicked and mousePressed routines, if not coded properly.
                    if (eventManager != null) eventManager.mousePressed(me);
                    return;

                /** MouseMotionListener events. */
                case MouseEvent.MOUSE_MOVED:
                    if (moveEventManager != null) moveEventManager.mouseMoved (me);
                    return;

                case MouseEvent.MOUSE_DRAGGED:
                    if (moveEventManager != null) moveEventManager.mouseDragged(me);

                    // record last drag event (must be AFTER processing) and remember that we are in a drag session.
                    setLastDrag (new Point (me.getX(), me.getY()));
                    return;
            }
        } catch (RuntimeException e) {
            // To enable troubleshooting, any runtime exceptions are trapped and output
            System.err.println ("MouseManager::handleMouseEvent trapped Runtime Exception.");
            e.printStackTrace();
        }
    }

    /**
     * Update the status in the KabasujiPanel for this MouseManager
     * @param newLastDrag Point
     */
    protected void setLastDrag(Point newLastDrag) {
        if (home == null) {
            throw new IllegalArgumentException ("MouseManager::setLastDrag(Point) called when no KabasujiPanel is set.");
        }

        // update in KabasujiPanel.
        home.setLastDrag (newLastDrag);
    }

    /**
     * Deploy this Mouse Adapter to handle (Click, Press, Release, Entered, Exit)
     * @param ma java.awt.event.MouseAdapter
     */
    public void setMouseAdapter(MouseAdapter ma) {
        eventManager = ma;
    }

    /**
     * Deploy this Mouse Motion Adapter to handle (Move, Drag)
     * @param ma java.awt.event.MouseMotionAdapter
     */
    public void setMouseMotionAdapter(MouseMotionAdapter ma) {
        moveEventManager = ma;
    }

    /**
     * Sets the Undo Adapter.
     * @param newUndoAdapter UndoAdapter
     */
    public void setUndoAdapter(UndoAdapter newUndoAdapter) {
        undoAdapter = newUndoAdapter;
    }
}
