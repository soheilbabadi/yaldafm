package cloud.yalda.www.yaldaIdentity.helper;

public interface ApiResult {
    Object getData();

    ApiResultImp saved();
    ApiResultImp fatalError(Exception ex);
    ApiResultImp notFound();

    long getTotalCount();

    long getCurrentCount();

    String getMessage();

    String getErrorMessage();

    org.springframework.http.HttpStatus getHttpStatus();

    boolean isSuccess();

    void setData(Object data);

    void setTotalCount(long totalCount);

    void setCurrentCount(long currentCount);

    void setMessage(String message);

    void setErrorMessage(String errorMessage);

    void setHttpStatus(org.springframework.http.HttpStatus httpStatus);

    void setSuccess(boolean isSuccess);
}
