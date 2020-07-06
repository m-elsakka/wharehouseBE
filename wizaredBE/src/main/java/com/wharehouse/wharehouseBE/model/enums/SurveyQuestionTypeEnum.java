/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wharehouse.wharehouseBE.model.enums;

/**
 *
 * @author waleed.mohamed
 */
public enum SurveyQuestionTypeEnum {
    TEXT(1),
    MCQ(2);

    private final Integer questionType;

    private SurveyQuestionTypeEnum(Integer questionType) {
        this.questionType = questionType;
    }

    public Integer getQuestionType() {
        return questionType;
    }
}
