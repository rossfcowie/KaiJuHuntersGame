package arcane.KaijuHunters.Monsters.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RouteContoller {
	   @GetMapping(value = "/")
	    public String homepage() {
	        return "/Website/index.html";
	    }
	
    @GetMapping(value = "/play")
    public String index() {
        return "/Website/www/Index.html";
    }

   @GetMapping(value = "/home")
    public String home() {
        return "/Website/index.html";
    }
   @GetMapping(value = "/register")
   public String register() {
       return "/Website/Register.html";
   }
   @GetMapping(value = "/login")
   public String login() {
       return "/Website/Login.html";
   }
   @GetMapping(value = "/threat")
   public String threat() {
       return "/Website/Monster.html";
   }
    @GetMapping(value = "/js/{file}")
    public String js(@PathVariable String file) {
        return "/Website/www/js/" +file;
    }
    @GetMapping(value = "/javascript/{file}")
    public String jsite(@PathVariable String file) {
        return "/Website/javascript/" +file;
    }
    @GetMapping(value = "/css/{file}")
    public String css(@PathVariable String file) {
        return "/Website/css/" +file;
    }
   @GetMapping(value = "/Pictures/{file}")
    public String pics(@PathVariable String file) {
        return "/Website/Pictures/" +file;
    }
   @GetMapping(value = "/js/libs/{file}")
   public String jslibs(@PathVariable String file) {
       return "/Website/www/js/libs/" +file;
   }
   @GetMapping(value = "/SystemPictures/{file}")
   public String SystemPictures(@PathVariable String file) {
       return "/Website/SystemPictures/" +file;
   }
    @GetMapping(value = "/js/plugins/{file}")
    public String jsplugs(@PathVariable String file) {
        return "/Website/www/js/plugins/" +file;
    }
    @GetMapping(value = "/fonts/{file}")
    public String fonts(@PathVariable String file) {
        return "/Website/www/fonts/" +file;
    }
    @GetMapping(value = "/data/{file}")
    public String data(@PathVariable String file) {
        return "/Website/www/data/" +file;
    }
    @GetMapping(value = "/img/{folder}/{file}")
    public String img(@PathVariable String file,@PathVariable String folder) {
        return "/Website/www/img/" + folder+"/" +file;
    }

    @GetMapping(value = "/audio/{folder}/{file}")
    public String audio(@PathVariable String file,@PathVariable String folder) {
        return "/Website/www/audio/" + folder+"/" +file;
    }
}
