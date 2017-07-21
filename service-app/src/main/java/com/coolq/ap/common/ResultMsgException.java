package com.coolq.ap.common;

import com.coolq.ap.enums.ResultMsgEnum;

public class ResultMsgException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = -750175880536757644L;

    public final ResultMsgEnum msgEnum;

    /**
     * @param msg
     */
    public ResultMsgException(String msg) {
        super(msg);
        this.msgEnum = null;
    }

    public ResultMsgException(ResultMsgEnum msgEnum) {
        super(msgEnum.message);
        this.msgEnum = msgEnum;
    }

}
