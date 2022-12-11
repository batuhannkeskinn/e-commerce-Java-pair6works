package com.etiya.ecommercedemopair6.core.util.results;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class Result//Super Type
{

    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

}
