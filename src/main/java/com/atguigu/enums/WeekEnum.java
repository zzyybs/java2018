package com.atguigu.enums;

/**
 * @auther zzyy
 * @create 2018-08-10 14:49
 */
public enum WeekEnum
{
    ONE(1,"周1"),TWO(2,"周2"),THREE(3,"周3"),FOUR(4,"周4"),FIVE(5,"周5"),SIX(6,"周6"),SEVEN(7,"周7");

    private Integer retCode;
    private String  retMessage;

    private WeekEnum(Integer retCode, String retMessage)
    {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public Integer getRetCode()
    {
        return retCode;
    }

    public String getRetMessage()
    {
        return retMessage;

    }

    public static WeekEnum foreachWeekEnum(int index)
    {
        for(WeekEnum element:values())
        {
            if(element.getRetCode() == index)
            {
                return element;
            }
        }
        return null;
    }
}
