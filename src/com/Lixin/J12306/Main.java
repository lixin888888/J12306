package com.Lixin.J12306;

public class Main {

    public static void main(String[] args) {
        // 开始抢票，可开多个
//        selectTicket1();
        selectTicket2();
    }


    public static void selectTicket1() {
        Go12306.newInstance()
                .initUser("lixin__888", "188282hcp")    // 用户名/密码
                .initBookTicketInfo("2019-10-13", // 乘车日期
                        "广州",   // 始发站
                        "怀集",   // 到达站
                        "D2812,D1822,D2948,G2904,D1872,D2834,D2962",    // 列车编号（D2834）。多个使用英文半角逗号分隔。目前暂时只能人工看列车编号啦
                        "M,O,N")    // 列车座席。M,O,N分别代表：一等座、二等座、无座。目前只支持这三种选择
                .run();
    }

    public static void selectTicket2() {
        Go12306.newInstance()
                .initUser("lixin__888", "188282hcp")      // 用户名/密码
                .initBookTicketInfo("2019-01-22", // 乘车日期
                        "北京西",   // 始发站
                        "南阳",   // 到达站
                        "G4067",    // 列车编号（D2834）。多个使用英文半角逗号分隔。目前暂时只能人工看列车编号啦
                        "M,O,N")    // 列车座席。M,O,N分别代表：一等座、二等座、无座。目前只支持这三种选择
                .run();
    }


}
