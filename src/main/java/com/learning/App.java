/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.learning;

import com.learning.ioc.SimpleIoCContainer;
import com.learning.main.Business;
import com.learning.service.GreetingService;
import com.learning.service.impl.GreetingServeiceImpl;

import javax.inject.Inject;

public class App {

    public static void main(String[] args) {
        SimpleIoCContainer container = new SimpleIoCContainer();
        container.register(GreetingService.class, GreetingServeiceImpl.class);

        Business mainBusiness = container.resolve(Business.class);
        System.out.println(mainBusiness.run("World"));
    }

}
