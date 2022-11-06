package com.backup.backupsystemweb.Controller;

import com.backup.backupsystemweb.utils.Algorithm;
import com.backup.backupsystemweb.utils.Judge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class controller {
    @Autowired
    Judge judge;

    @Autowired
    Algorithm algorithm;
//    private static String password = null;
//    private static String filename = null;

    @GetMapping("/")
    public String main_page() {
        return "index";
    }

    @GetMapping("/test")
    public String test(Model map) {
        map.addAttribute("msg", "test");
        return "test";
    }

    @GetMapping("/thread")
    public String deal(@ModelAttribute("filename") String filename,
                            @ModelAttribute("method") String method,
                            @ModelAttribute("passwd") String password,
                            @ModelAttribute("key") String key,
                            Model map) {
        if(key.equals("recover") && method.equals("jiemi")) {
            boolean right = judge.CheckPasswd(filename, password);
            if(!right) {
                map.addAttribute("msg", "密码有误，请检查后重试");
                return "test";
            }
        }
        List<String> attr = new ArrayList<String>();
        attr.add(key);
        attr.add(filename);
        attr.add(method);
        attr.add(password);
        List<String> resp = algorithm.deal(attr);
        if(key.equals("backup") && resp.equals("成功")) {
            judge.InDatabase(filename, method, password);
        }
        map.addAttribute("msg", resp);
        return "test";
    }

    @PostMapping("/beifen")
    public String beifen(@RequestParam("FileDir") String filePath,
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
    public String huifu(@RequestParam("FileDir2") String filePath,
                                @RequestParam("leixing") String method,
                                Model map,
                                RedirectAttributes attr) {
        // 用于判断用户选择的恢复方式是否是输入密码的方式
        boolean passwd =  judge.UsePasswd(filePath, method);
        // 用于判断用户操作的文件是否加密备份
        boolean usePass = judge.HavePasswd(filePath);
        if(usePass) {
            // 是加密备份且用户选择输入密码
            if(passwd) {
                map.addAttribute("filename", filePath);
                map.addAttribute("method", method);
                map.addAttribute("key", "recover");
                return "passwd";
            } else {    // 是加密备份但用户选择不输入密码
                map.addAttribute("msg", "很抱歉，您之前对"+filePath+"进行了加密备份，请选择‘解密解压’恢复模式后，重新进行恢复");
                return "test";
            }
        } else  // 未进行加密备份时，直接忽略用户输入的密码
        {
            attr.addFlashAttribute("filename", filePath);
            attr.addFlashAttribute("method", method);
            attr.addFlashAttribute("passwd", null);
            attr.addFlashAttribute("key", "recover");
            return "redirect:/thread";
        }
    }

    @PostMapping("/check")
    public String check(@RequestParam("tarFile") String filePath,
                                Model map,
                                RedirectAttributes attr) {
        attr.addFlashAttribute("filename", filePath);
        attr.addFlashAttribute("method", "jichu");
        attr.addFlashAttribute("passwd", null);
        attr.addFlashAttribute("key", "check");
        return "redirect:/thread";
    }

    @PostMapping("/pass")
    public String getpasswd(@RequestParam("passwd") String passwd,
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
