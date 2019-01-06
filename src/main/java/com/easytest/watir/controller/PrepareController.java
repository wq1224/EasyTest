package com.easytest.watir.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrepareController {

    @RequestMapping("/search")
	public String search() {
		return "你好";
    }

    @RequestMapping("/add")
    public void add() throws IOException, InterruptedException {
        String bashCommand = "sh ./test.sh";
//      String bashCommand = "chmod 777 " + "/usr/local/java/jdk1.8.0_121/lib/stopffmpeg.sh" ;
//      String bashCommand = "kill -9" + ip;
        Runtime runtime = Runtime.getRuntime();
        Process pro = runtime.exec(bashCommand);
        int status = pro.waitFor();
        if (status != 0)
        {
            System.out.println("Failed to call shell's command ");
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
        StringBuffer strbr = new StringBuffer();
        String line;            
        while ((line = br.readLine())!= null)
        {                
            strbr.append(line).append("\n");
        }

        String result = strbr.toString();
        System.out.println(result);
    }

}

