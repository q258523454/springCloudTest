package com.springCloudModule.util;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By
 *
 * @author :   zhangjian
 * @date :   2018-10-15
 */
@Component
public class MyFilter extends ZuulFilter {

    /***
     * pre：路由之前, routing：路由之时, post：路由之后, error：发送错误调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /***
     * 过滤的顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /***
     * 是否过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /***
     * 过滤逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token"); // 查看是否有token这个参数传递, 没有则不会跳转
        if(accessToken == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}
            return null;
        }
        return null;
    }
}
