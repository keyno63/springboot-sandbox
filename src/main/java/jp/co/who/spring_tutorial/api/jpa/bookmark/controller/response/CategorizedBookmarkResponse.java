package jp.co.who.spring_tutorial.api.jpa.bookmark.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.who.spring_tutorial.api.jpa.bookmark.domain.CategorisedBookData;

import java.util.List;

public class CategorizedBookmarkResponse {
    @JsonProperty
    private List<CategorisedBookData> categorisedBookDataList;

    public CategorizedBookmarkResponse(List<CategorisedBookData> categorisedBookDataList) {
        this.categorisedBookDataList = categorisedBookDataList;
    }
}
