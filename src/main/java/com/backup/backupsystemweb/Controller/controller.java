package com.backup.backupsystemweb.Controller;

import com.backup.backupsystemweb.utils.Algorithm;
import com.backup.backupsystemweb.utils.Judge;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {
    public static Judge judge;
//    private static String password = null;
//    private static String filename = null;

    @GetMapping("/")
    public static String main_page() {
        return "index";
    }

    @GetMapping("/thread")
    public static String deal(@ModelAttribute("filename") String filename,
                            @ModelAttribute("method") String method,
                            @ModelAttribute("passwd") String password,
                            @ModelAttribute("key") String key,
                            Model map) {
        List<String> attr = new ArrayList<String>();
        attr.add(key);
        attr.add(filename);
        attr.add(method);
        attr.add(password);
        String resp = Algorithm.deal(attr);
        map.addAttribute("msg", resp);
        return "test";
    }

    @PostMapping("/beifen")
    public static String beifen(@RequestParam("FileDir") String filePath,
                                @RequestParam("method") String method,
                                Model map,
                                RedirectAttributes attr) {
//        filename = filePath;
        boolean passwd =  judge.UsePasswd(filePath, method);
        if(passwd) {
            map.addAttribute("filename", filePath);
            map.addAttribute("method", method);
            map.addAttribute("key", "backup");
            return "passwd";
        }
        else {
            attr.addFlashAttribute("filename", filePath);
            attr.addFlashAttribute("method", method);
            attr.addFlashAttribute("passwd", null);
            attr.addFlashAttribute("key", "backup");
            return "redirect:/thread";
        }
    }

    @PostMapping("/huifu")
    public static String huifu(@RequestParam("FileDir2") String filePath,
                               @RequestParam("leixing") String method,
                               Model map) {
        return "";
    }

    @PostMapping("/pass")
    public static String getpasswd(@RequestParam("passwd") String passwd,
                                 @RequestParam("filename") String filename,
                                 @RequestParam("method") String method,
                                 @RequestParam("key") String key,
                                 RedirectAttributes attr) {
        attr.addFlashAttribute("filename", filename);
        attr.addFlashAttribute("method", method);
        attr.addFlashAttribute("passwd", passwd);
        attr.addFlashAttribute("key", key);
        return "redirect:/thread";
    }
}
