package com.tagLibDemo;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.lang.Integer.parseInt;

/**
 * Created by student on 3/26/17.
 */
public class TimeOfDayHello extends SimpleTagSupport {
    private static final DateFormat dateFormatTime = new SimpleDateFormat("HH");
    private static final DateFormat dateFormatMonth = new SimpleDateFormat("MM");
    private static final DateFormat dateFormatDay = new SimpleDateFormat("dd");
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();
        JspWriter out = getJspContext().getOut();
        Date currentDate = new Date();
        int currentHour = parseInt(dateFormatTime.format(currentDate));
        int currentMonth = parseInt(dateFormatMonth.format(currentDate));
        int currentDay = parseInt(dateFormatDay.format(currentDate));

        // If Halloween
        if (currentDay == 31 && currentMonth == 10) {
            out.println("Happy Halloween!");
            return;
        }
        // If morning
        if (currentHour > 4 && currentHour < 12) {
            out.println("Good morning!");
            return;
        }
        // If afternoon
        if (currentHour >=12 && currentHour < 5) {
            out.println("Good afternoon!");
            return;
        }
        // If night
        if (currentHour >= 5 || currentHour <= 4) {
            out.println("Good night!");
            return;
        }

        out.println("Good day!");

    }


}

