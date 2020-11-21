package jp.co.who.spring_tutorial.api.sample.dto;

import java.util.List;

public class ResponseTest<T> {
    private List<T> param;

    public List<T> getParam() {
        return param;
    }

    public void setData(List<T> data) {
        this.param = data;
    }
}
