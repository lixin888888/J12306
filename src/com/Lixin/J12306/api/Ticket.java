package com.Lixin.J12306.api;

import cn.hutool.http.HttpResponse;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.Lixin.J12306.config.UrlConfig;
import com.Lixin.J12306.config.UrlsEnum;
import com.Lixin.J12306.http.Session;

/**
 * 车票
 * Create by Kalvin on 2019/9/19.
 */
public class Ticket {

    private static final Log log = LogFactory.get();

    private Session session;
    private String trainDate;
    private String fromStation;
    private String toStation;
    private String tempCookie;

    public Ticket(Session session, String trainDate, String fromStation, String toStation) {
        // 进入查询车票页面
        session.httpClient.send(UrlsEnum.INIT_TICKET);
        log.info("进入查询车票页面，开始查票...");

        this.tempCookie = session.getCookie();
        this.session = session;
        this.trainDate = trainDate;
        this.fromStation = fromStation;
        this.toStation = toStation;
    }

    //https://kyfw.12306.cn/otn/leftTicket/queryA?leftTicketDTO.train_date=2019-12-28&leftTicketDTO.from_station=BJP&leftTicketDTO.to_station=NFF&purpose_codes=ADULT
    public HttpResponse query() {
        this.session = new Session();
        this.session.setCookie(this.tempCookie);
        UrlConfig urlConfig = UrlsEnum.QUERY_TICKET.getUrlConfig();
        urlConfig.setUrl(urlConfig.getUrl()
                .replace("{0}", trainDate)
                .replace("{1}", this.fromStation)
                .replace("{2}", this.toStation));

        UrlsEnum.QUERY_TICKET.setUrlConfig(urlConfig);
        log.info("当前请求的路径",UrlsEnum.QUERY_TICKET);
        return this.session.httpClient.send(UrlsEnum.QUERY_TICKET);
    }
}
