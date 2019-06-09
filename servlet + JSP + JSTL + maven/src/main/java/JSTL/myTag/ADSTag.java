package JSTL.myTag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import java.io.IOException;
import java.util.Enumeration;

public class ADSTag extends TagSupport{
    public String value = "";
    public String label = "";
    public String name = "";

    public void setName(String name) {
        this.name = name;
    }
}
