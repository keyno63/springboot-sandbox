package jp.co.who.spring_tutorial.dto;

import java.util.List;

public class ResponseTest<T> {
    private List<T> param;

    public List<T> getData() {
        return param;
    }

    public void setData(List<T> data) {
        this.param = data;
    }
}
