package com.itplayer.common.exception;

import com.itplayer.common.base.resp.ResponseData;
import com.itplayer.utils.json.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author caijun.yang
 * @date 2018/10/26
 */
public class RequestHanderExceptionResolver implements HandlerExceptionResolver {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private static final String XMLHTTPREQ = "XMLHttpRequest";
    private static final String XREQWITH = "X-Requested-With";

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
        e.printStackTrace();
        String message = e.getMessage();
        ResponseData responseData = new ResponseData(ResponseData.ERROR);
        logger.error(message);
        if (XMLHTTPREQ.equalsIgnoreCase(request.getHeader(XREQWITH))) {
            if (e instanceof SystemException) {
                logger.error(e.getMessage());
                responseData.setMsg(e.getMessage());
            } else if (e instanceof MaxUploadSizeExceededException) {
                MaxUploadSizeExceededException exceededException = (MaxUploadSizeExceededException) e;
                responseData.setMsg("上传文件过大，最大为" + exceededException.getMaxUploadSize() / 1024 / 1024 + "M");
            } else {
                responseData.setMsg("系统错误！");
            }
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            String dataString = JsonUtils.obj2Str(responseData);
            if (null != out) {
                out.write(dataString);
                out.flush();
                out.close();
            }
        } else {// 针对返回错误页面
            try {
                request.setAttribute("message", message);
                request.getRequestDispatcher("WEB-INF/jsp/error.jsp").forward(request, response);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
