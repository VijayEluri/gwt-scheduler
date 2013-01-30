package gwtscheduler.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import gwtscheduler.client.modules.config.AppConfiguration;
import gwtscheduler.client.resources.Resources;
import gwtscheduler.client.resources.css.SchedulerCssResource;
import gwtscheduler.client.widgets.common.CalendarPresenter;
import gwtscheduler.client.widgets.common.navigation.TabPanelContainer;
import gwtscheduler.client.widgets.view.columns.ColumnsViewWidget;

import java.util.Iterator;

/**
 * @author mlesikov  {mlesikov@gmail.com}
 */
public class GwtSchedulerWidget extends Composite implements GwtScheduler.Display, HasWidgets {

  private AppConfiguration configuration;
  private int columnsCount;

  /**
   * ui binder interface
   */
  interface GwtSchedulerWidgetUiBinder extends UiBinder<Widget, GwtSchedulerWidget> {
  }

  /**
   * ui binder instance
   */
  private static GwtSchedulerWidgetUiBinder uiBinder = GWT.create(GwtSchedulerWidgetUiBinder.class);

  /**
   * static ref to css
   */
  protected static final SchedulerCssResource CSS = Resources.schedulerCss();

  /**
   * widget delegate
   */
  @UiField
  TabPanelContainer calendarContainer;
  @UiField
  ColumnsViewWidget calendar;


  public GwtSchedulerWidget(AppConfiguration configuration, int columnsCount) {
    this.configuration = configuration;
    this.columnsCount = columnsCount;
    initWidget(uiBinder.createAndBindUi(this));
  }

  @UiFactory
  public TabPanelContainer getTabPanelContainer(){
    TabPanelContainer container = new TabPanelContainer();
    container.setHeight(configuration.getCalendarHeight());
    container.setHeight(configuration.getCalendarWidth());
    return container;
  }

  @UiFactory
  public  ColumnsViewWidget getColumnsViewWidget(){
    return new ColumnsViewWidget(configuration.rowsInDay(),columnsCount,configuration.daysLineHeightEMs());
  }

  public CalendarPresenter.Display getColumnsView(){
    return calendar;
  }

  @Override
  public void add(Widget w) {
    calendarContainer.add(w);
  }

  @Override
  public void clear() {
    calendarContainer.clear();
  }

  @Override
  public Iterator<Widget> iterator() {
    return calendarContainer.iterator();
  }

  @Override
  public boolean remove(Widget w) {
    return calendarContainer.remove(w);
  }
}
