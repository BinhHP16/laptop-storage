package com.saltlux.laptopstorage.utils.constraints;

public interface AppConstants {
    String DEFAULT_PAGE_NUMBER = "0";
    String DEFAULT_PAGE_SIZE = "50";

    int MAX_PAGE_SIZE = 50;

    String TOMCAT_BASE = System.getProperty("catalina.base");
    //        String TOMCAT_BASE = Paths.get("").toAbsolutePath().getParent().toString();
    String TRANSS_UPLOAD_DIR = System.getProperty("tranSSUploadDir");

    String RESOURCE_PATH = "/transs-resource";
    String UNICODE_FONT = "/font/NotoSansCJKjp-Regular.otf";
    String VIETNAM_FONT_BOLD = "/font/vuArialBold.ttf";
    public static final String DATE_FORMAT = "yyyyMMdd HHmmss";

    String DATE_FORMAT_VI = "dd/MM/yyyy";

    public static final String FORMAT_DATETIME = "yyyyMMdd HH:mm:ss";

    /*Community status*/
    int STATUS_ACTIVE = 1;
    int STATUS_ENABLE = 1;
    int STATUS_DISABLE = 0;
    int STATUS_DELETED = -1;

    /*Status request*/
    int PROGRESS_STATUS_ALL = 0;
    int PROGRESS_STATUS_COMPLETED = 1;
    int PROGRESS_STATUS_UNCOMPLETED = 2;



    int EVENT_GROUP_TYPE_COLLABORATION = 1;
}
