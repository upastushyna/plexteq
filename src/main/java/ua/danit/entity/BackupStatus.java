package ua.danit.entity;

public enum BackupStatus {
  OK ("Ok"),
  IN_PROGRESS("In progress"),
  FAILED ("Failed");

  private final String uiValue;

  BackupStatus(String uiValue) {
    this.uiValue = uiValue;
  }
}
