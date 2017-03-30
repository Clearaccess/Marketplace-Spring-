package com.marketplace.spring.interceptors;

import com.marketplace.spring.controllers.HelperController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Aleksandr_Vaniukov on 3/22/2017.
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HelperController helperController;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session=request.getSession(true);
        String requestURL=request.getRequestURI();
        String requestMethod=request.getMethod();

        //Attempt authorize
        if(requestURL.equals("/login") && requestMethod.equals("POST")){
            if(isAuthorize(request)){
                String login=request.getParameter("login");
                session.setAttribute("user", helperController.getUserByLogin(login));
                response.sendRedirect("/showItems");
                return false;
            } else {
                request.setAttribute("error","No exist such login or password");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
                return false;
            }
        } else {
            //Attempt access to pages when no authorize user
            if(session.getAttribute("user")==null && (requestURL.equals("/advancedSearch") || requestURL.equals("/editItem") || requestURL.equals("/showMyItems"))){
                response.sendRedirect("/login");
                return false;
            } else {
                if(session.getAttribute("user")!=null && (requestURL.equals("/login") || requestURL.equals("/"))){
                    response.sendRedirect("/showItems");
                    return false;
                } else{
                    return super.preHandle(request, response, handler);
                }
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    protected boolean isAuthorize(HttpServletRequest request){
        String login=request.getParameter("login").toLowerCase();
        String password=request.getParameter("password").toLowerCase();
        return helperController.isLogin(request) && helperController.isRegister(login,password);
    }
}
