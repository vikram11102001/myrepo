package com.springexample.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ForkJoinPool;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.DispatcherServlet;

import com.springexample.model.Customer;
import com.springexample.model.Flights;
import com.springexample.model.Logon;

@Controller
@Scope("prototype")
@RequestMapping("/rmsampledemo")
public class LogonController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogonController.class);

    @Autowired
    private Customer mycust;

    @GetMapping("/vardhan")
    public String landing(Locale locale, Model model) throws SQLException {
        System.out.println("Home Page Requested, locale = " + locale);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String mysqlUrl = "jdbc:mysql://localhost:3306/sampleschema";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "root");
        String QUERY = "select * from flights";

        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(QUERY);
        ArrayList<Flights> flightlist = new ArrayList<>(); // Specify the type of the ArrayList

        while (rs.next()) {
            String flightId = rs.getString("flightid");
            String flightName = rs.getString("flightname");
            String sourceplace = rs.getString("source");
            String destinationplace = rs.getString("destination");
            String dateandtime = rs.getString("dateandtime");

            Flights flightobj = new Flights();

            flightobj.setFlightid(flightId);
            flightobj.setFlightname(flightName);
            flightobj.setSource(sourceplace);
            flightobj.setDestination(destinationplace);
            flightobj.setDateandtime(dateandtime);

            flightlist.add(flightobj);
        }

        model.addAttribute("flightlist", flightlist);
        return "listflight";
    }

    @PostMapping("/satish")
    public String dashboard(@Validated Customer customer, Model model) {
        System.out.println("User Page Requested");
        System.out.println(customer.getUserName());
        model.addAttribute("userName", customer.getUserName());
        mycust.setUserName(customer.getUserName());
        System.out.println(mycust.getAccount().getOutstandingBalance());
        model.addAttribute("cust", mycust);
        return "user";
    }

    @PostMapping("/postdemo")
    public String postDemo(@RequestBody Logon customer) {
        System.out.println("User Page Requested");
        System.out.println(customer.getUsername());
        System.out.println(customer.getPassword());
        return "user";
    }

    @GetMapping("/{id}")
    public String pathVarDemo(@PathVariable("id") long id) {
        System.out.println("id is " + id);
        return "user";
    }

    @GetMapping("/{id}/from/{fromid}")
    public String pathVarDemo(@PathVariable("id") long id, @PathVariable String fromid) {
        System.out.println("id is " + id);
        System.out.println("fromid is " + fromid);
        return "user";
    }

    @GetMapping("/rpd")
    public String requestParamDemo(@RequestParam("id") long id) {
        System.out.println("User Page Requested");
        System.out.println("rpd method id is " + id);
        return "user";
    }

    @GetMapping("/sessionput")
    @ResponseBody
    public String testMethod(HttpServletRequest request) {
        request.getSession().setAttribute("lastlogin", new Date().toGMTString());
        return "Welcome to Online policy renewal";
    }

    @GetMapping("/sessionget")
    @ResponseBody
    public String testMethod2(HttpServletRequest request) {
        String message = (String) request.getSession().getAttribute("lastlogin");
        return "Welcome to Online policy renewal. Your last login is at " + message;
    }

    @ResponseBody
    @GetMapping("/strdemo")
    String simpleString() {
        return "WELCOME to SPRING";
    }

    @ResponseBody
    @GetMapping("/rsdemo")
    @ResponseStatus(HttpStatus.CREATED)
    String simpleResponseStatus() {
        return "WELCOME to SPRING";
    }

    @GetMapping("/blockrequest")
    public ResponseEntity<?> getSimpleResponse() throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(3000);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/asynchronous-request")
    public DeferredResult<ResponseEntity<?>> asynchronousRequestProcessing(final Model model) {
        final DeferredResult<ResponseEntity<?>> deferredResult = new DeferredResult<>();
        System.out.println(Thread.currentThread().getName());
        LOGGER.info("async started");
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(() -> {
            LOGGER.info("async in new thread started");
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
            }
            deferredResult.onCompletion(() -> System.out.println("Processing complete"));
            deferredResult.setResult(ResponseEntity.ok("OK"));
        });
        return deferredResult;
    }
}
