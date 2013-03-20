package gwtscheduler.client.modules.config;

import gwtscheduler.common.util.DateTimeConstants;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class GwtSchedulerConfiguration implements AppConfiguration{
  public static Builder aNewGwtSchedulerConfiguration() {
     return new Builder();
   }

  public static class Builder {

    private int startDayOfWeek =  DateTimeConstants.MONDAY;
    private int daysInWeek = 7;
    private int hourIntervalHeightEMs = 3;
    private int rowsInDay = 24;
    private int height= 0;
    private int width = 0;
    private int pixelsPerInterval = 0;
    private int scrollToHour = 0;

    public Builder startDayOfWeek(int startDayOfWeek) {
      this.startDayOfWeek = startDayOfWeek;
      return this;
    }

    public Builder daysInWeek(int daysInWeek) {
      this.daysInWeek = daysInWeek;
      return this;
    }

    public Builder hourIntervalHeightEMs(int daysLineHeightEMs) {
      this.hourIntervalHeightEMs = daysLineHeightEMs;
      return this;
    }

    public Builder intervalsPerHour(int IntervalsPerHour) {
      this.rowsInDay = 24 * IntervalsPerHour;
      return this;
    }

    //still not in use
    public Builder pixelsPerInterval(int pixelsPerInterval) {
      this.pixelsPerInterval = pixelsPerInterval;
      return this;
    }


    public Builder height(int height) {
      this.height = height;
      return this;
    }

    public Builder width(int width) {
      this.width = width;
      return this;
    }

    public GwtSchedulerConfiguration build() {
      GwtSchedulerConfiguration configuration = new GwtSchedulerConfiguration();
      configuration.startDayOfWeek = startDayOfWeek;
      configuration.daysInWeek = daysInWeek;
      configuration.hourIntervalHeightEMs = hourIntervalHeightEMs;
      configuration.rowsInDay = rowsInDay;
      configuration.pixelsPerInterval= pixelsPerInterval;
      configuration.height = height;
      configuration.width = width;
      configuration.scrollToHour = scrollToHour;
      return configuration;
    }

    public Builder setScrollToHour(int scrollToHour) {
      this.scrollToHour = scrollToHour;
      return this;
    }
  }

  private int startDayOfWeek;
  private int daysInWeek;
  private int hourIntervalHeightEMs;
  private int rowsInDay;
  private int pixelsPerInterval;
  private int height;
  private int width;
  private int scrollToHour = 0;

  @Override
  public int startDayOfWeek() {
    return startDayOfWeek;
  }

  @Override
  public int daysInWeek() {
    return daysInWeek;
  }

  @Override
  public int daysLineHeightEMs() {
    return hourIntervalHeightEMs;
  }

  @Override
  public int rowsInDay() {
    return rowsInDay;
  }

  @Override
  public int getDayViewTopRows() {
    return 3;
  }

  @Override
  public int getCalendarHeight() {
    return height;
  }

  @Override
  public int getCalendarWidth() {
    return width;
  }

  @Override
  public int getPixelsPerInterval() {
    return pixelsPerInterval;
  }

  public int scrollToHour() {
    return scrollToHour;
  }
}