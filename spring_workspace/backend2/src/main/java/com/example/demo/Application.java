package com.example.demo;

import javax.annotation.PreDestroy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.config.SSConnection;


@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"})
public class Application {
	
	 private static SSConnection tunnel;

	 public  Application() 
	 {
		 super();
		 System.out.println("start>>>>>>>>>>>>>>>>>  ");
		 System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		
		 //init();
	 }
	 
	 public void init()
	 {
	  	
        tunnel = new SSConnection().init( res->{
        	
        	System.out.println(res );
            if(!res) {
                
                System.exit(0);
            }
            else {
            	System.out.println("��Ʈ������ ����");
            }
        });        
		 	
	}
	 
	public static void main(String[] args) {
		
		
		//SpringApplication app = new SpringApplication(Application.class);
		//app.run(args);
		
		SpringApplication.run(Application.class, args);
		
	}
	
	 /*@PreDestroy
	    public void end() {
        try {
            tunnel.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

}
