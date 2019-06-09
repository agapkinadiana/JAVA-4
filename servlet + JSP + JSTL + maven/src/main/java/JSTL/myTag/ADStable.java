package JSTL.myTag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Enumeration;

public class ADStable extends TagSupport {
    public int doStartTag() throws JspException {

        JspWriter out = pageContext.getOut();
        try {
            out.print("<table width=\"50%\" border=\"1\" align=\"left\">" +
                    "<tr bgcolor=\"B0F4B3\">" +
                    "<th>Parameter</th><th>Value</th>" +
                    "</tr>");
            Enumeration params = pageContext.getRequest().getParameterNames();
            while(params.hasMoreElements()) {
                String paramName = (String)params.nextElement();
                out.print("<tr><td>" + paramName + "</td>");
                String paramValue = pageContext.getRequest().getParameter(paramName);
                out.println("<td> " + paramValue + "</td></tr>");
            }
        } catch (IOException e) {
            System.out.println("ADStable: " + e);
        }
        return EVAL_BODY_INCLUDE;
    }
}
