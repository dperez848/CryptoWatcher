package com.napsis.cryptowatcher.data.models;

/**
 * Created by daniel.leonett on 2/02/2018.
 */

public class UiStateModel<T> {

    private boolean inProgress;
    private boolean isError;
    private boolean isSuccess;
    private String errorMessage;
    private T data;

    public UiStateModel() {

    }

    public UiStateModel(boolean inProgress, boolean isError, boolean isSuccess, String errorMessage, T data) {
        this.inProgress = inProgress;
        this.isError = isError;
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
        this.data = data;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public boolean isError() {
        return isError;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public T getData() {
        return data;
    }

    public static <T> UiStateModel<T> idle() {
        return new UiStateModel<>();
    }

    public static <T> UiStateModel<T> loading() {
        return new UiStateModel<>(true, false, false, null, null);
    }

    public static <T> UiStateModel<T> success(T data) {
        return new UiStateModel<>(false, false, true, null, data);
    }

    public static <T> UiStateModel<T> failure(String errorMessage) {
        return new UiStateModel<>(false, true, false, errorMessage, null);
    }
}
