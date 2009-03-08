package gwtscheduler.client.widgets.view.day;

import gwtscheduler.client.utils.DebugUtils;
import gwtscheduler.client.widgets.resize.IViewportResizeHandler;
import gwtscheduler.client.widgets.resize.ViewportResizeEvent;
import gwtscheduler.client.widgets.view.WrapperWidget;

import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Enter class description here.
 * 
 * @author Miguel Ping
 * @version $Revision: $
 * @since 1.0
 */
public class DayView extends WrapperWidget implements IViewportResizeHandler {

    /** Main container */
    private VerticalPanel container;

    /**
     * Default constructor.
     */
    public DayView() {
        container = new VerticalPanel();
        wrapWidget(container);
        container.add(new Label("xxx"));
        // this helps visual debug
        DebugUtils.addBgColor(container.getElement());
    }

    public void onViewportResize(ViewportResizeEvent event) {
        container.setSize(event.width + "px", "96em");// 24h*4 lines
    }
}