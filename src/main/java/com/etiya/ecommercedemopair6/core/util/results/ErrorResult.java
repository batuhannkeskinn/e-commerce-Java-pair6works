package com.etiya.ecommercedemopair6.core.util.results;
//logic kullanıldığı için constraction kullanamazsın.
public class ErrorResult extends Result{
    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false,message);
    }
}
