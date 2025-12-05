package com.chainsys.epassmanagementsystem.controller;

import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.ui.Model;

@ControllerAdvice
public class GlobalModelAttributes {
    public static final String USERID  = "USERID";
    public static final String ADMINID  = "ADMINID";
    public static final String USERNAME = "USERNAME";
    public static final String EPASSID = "EPASSID";

    @ModelAttribute
    public void addSessionAttributes(Model model, HttpSession session) {
        // Read once from session
        Object userIdObj  = session.getAttribute("userId");
        Object adminIdObj  = session.getAttribute("adminId");
        Object usernameObj = session.getAttribute("username");
        Object epassIdObj = session.getAttribute("epassId");

        Integer userId = toIntegerOrNull(userIdObj);
        if (userId != null) {
            model.addAttribute(USERID, userId);
        }

        if (adminIdObj instanceof String) {
            model.addAttribute(ADMINID, (String) adminIdObj);
        } else if (adminIdObj != null) {
            model.addAttribute(ADMINID, String.valueOf(adminIdObj));
        }

        if (usernameObj instanceof String) {
            model.addAttribute(USERNAME, (String) usernameObj);
        } else if (usernameObj != null) {
            model.addAttribute(USERNAME, String.valueOf(usernameObj));
        }

        Integer epassId = toIntegerOrNull(epassIdObj);
        if (epassId != null) {
            model.addAttribute(EPASSID, epassId);
        }
    }

    private Integer toIntegerOrNull(Object obj) {
        if (obj == null) return null;
        if (obj instanceof Integer) return (Integer) obj;
        if (obj instanceof Number) return ((Number) obj).intValue();
        if (obj instanceof String) {
            String s = ((String) obj).trim();
            if (s.isEmpty()) return null;
            try {
                return Integer.valueOf(s);
            } catch (NumberFormatException ignored) {
                return null;
            }
        }
        return null;
    }
}
