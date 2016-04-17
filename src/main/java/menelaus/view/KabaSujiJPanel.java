package menelaus.view;

import menelaus.model.basic.Point;
import menelaus.model.board.Piece;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * Created by frankegan on 4/15/16.
 */
public class KabaSujiJPanel extends JPanel {
    /**
     * Define the start point for all panels that extend our class
     */
    public static final int START_X = 100;
    /**
     * Define the start point for all panels that extend our class
     */
    public static final int START_Y = 100;
    /**
     * Define the width for all panels that extend our class
     */
    public static final int WIDTH = 1000;
    /**
     * Define the height for all panels that extend our class
     */
    public static final int HEIGHT = 750;
    /**
     * Manage an object that is currently being dragged (if at all).
     */
    protected Piece activeDraggingObject = null;
    /**
     * The source piece from which a drag originated.
     */
    protected Piece dragSource = null;
    /**
     * Has a widget told us that a drag is in progress?
     */
    protected boolean dragging;
    /**
     * if an entity is being dragged, this point reflects the anchor Point within the widget (useful for ensuring smooth drags).
     */
    protected Point draggingAnchor = null;
    /**
     * A special widget to be used to signal that no object is being dragged.
     */
    protected static final Piece nothingBeingDragged = new Piece(null);
    /**
     * What was the point of the last drag.
     */
    protected Point lastDrag;

    /**
     * Define a base class for all our panels to extend. Includes constants for defining panel sizes,
     * and methods for dragging views. Will be used for handling all mous events inside of panel and delegating them to
     * their respective controllers.
     */
    public KabaSujiJPanel() {
        setBounds(START_X, START_Y, WIDTH, HEIGHT);
        setBorder(new EmptyBorder(5, 5, 5, 5));
    }

    /**
     * Returns the object being dragged. If no object is being dragged,
     * the special <code>getNothingBeingDragged()<code> object is the value
     * of this method.
     * <p/>
     *
     * @return Piece
     */
    public Piece getActiveDraggingObject() {
        return activeDraggingObject;
    }

    /**
     * Sets the source Piece from which a drag originated.
     * <p/>
     * Note: dragSource must be manually set by the controller of the Piece since there is
     * no obvious way for the container to know the object for which the drag originates.
     * <p/>
     * Passing in null simply means that the drag is released.
     * <p/>
     *
     * @param newDragSource Piece
     * @since v1.6
     */
    public void setDragSource(Piece newDragSource) {
        if (newDragSource == null)
            releaseDraggingObject();
        else
            dragSource = newDragSource;
    }

    /**
     * Specifies the Piece being dragged. Note: this is called once. Thereafter, for each
     * drag event, MouseManagers for the Pieces update the lastDrag Point in the container.
     * <p/>
     * We also take as input the MouseEvent associated with this dragging object; this enables
     * us to calculate the anchor.
     * <p/>
     * Take some care if MouseEvent is null.
     *
     * @param newActiveDraggingObject Piece
     * @param me                      MouseEvent
     */
    public void setActiveDraggingObject(Piece newActiveDraggingObject, java.awt.event.MouseEvent me) {
        activeDraggingObject = newActiveDraggingObject;

        if (me == null) {
            setDraggingAnchor(null);
            return;
        }

        Point p = new Point(me.getX() - newActiveDraggingObject.getPosition().getX(),
                me.getY() - newActiveDraggingObject.getPosition().getY());
        setDraggingAnchor(p);
    }

    /**
     * Returns a 'sentinel' object that represents the fact that nothing
     * is being dragged. This avoids the use of using null object references
     * <p/>
     *
     * @return Piece
     */
    public static Piece getNothingBeingDragged() {
        return nothingBeingDragged;
    }

    /**
     * Releases the object being dragged by the container.
     * <p/>
     * Note: this will also reset the dragSource and lastDrag to null.
     */
    public void releaseDraggingObject() {
        // release dragging Object.
        setActiveDraggingObject(getNothingBeingDragged(), null);

        dragging = false;
        lastDrag = null;

        // reset our sourceWidget (if it was ever set in the first place).
        dragSource = null;
    }

    /**
     * Record DraggingAnchor, the offset within the dragged widget of where the
     * mouse was first clicked. Using this point will ensure that dragging redraws
     * are smooth.
     * <p/>
     *
     * @param newDraggingAnchor Point
     */
    protected void setDraggingAnchor(Point newDraggingAnchor) {
        draggingAnchor = newDraggingAnchor;
    }

    /**
     * Returns the last Drag point, or null if no drag is in process.
     * <p/>
     * This class variable is kept up-to-date by the various MouseManagers
     * associated with each widget, as well as the MouseManagers with the
     * Container itself that represents the background.
     * <p/>
     * If this ever returns null, it means nothing is being dragged.
     * <p/>
     *
     * @return java.awt.Point
     */
    public Point getLastDrag() {
        return lastDrag;
    }

    /**
     * Tell container of last drag point (or null if ending a drag).
     *
     * @param p Point
     */
    public void setLastDrag(Point p) {
        lastDrag = p;
        dragging = (p != null);
    }
}
