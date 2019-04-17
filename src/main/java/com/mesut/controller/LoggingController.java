package com.mesut.controller;

import com.mesut.dto.ResponseObject;
import com.mesut.model.Address;
import com.mesut.model.ApiBaseException;
import com.mesut.model.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.ArrayList;
import java.util.Map;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);


    @GetMapping("/")
    public ResponseObject<String> index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return new ResponseObject<String>("Howdy! Check out the Logs to see the output...");
    }

    @GetMapping("/error/{throwError}")
    public ResponseObject<String> error(@PathVariable(name = "throwError") boolean throwError) {

        logger.error("An ERROR Message");
        if (throwError) {
            throw new ApiBaseException("1", "global exception handling test.");
        }
        return new ResponseObject<String>("no exception");
    }

    @GetMapping("/customer/{id}")
    public ResponseObject<Customer> customer(@PathVariable(name = "id") Long pId) {


        if (pId.equals(0L)) {
            throw new ApiBaseException("1", "no customer is not exist");
        }
        else if(pId.equals(1L))
        {
            Customer cc =null;
            cc.toString(); //TODO: null point Exception.
        }


        Customer customer = new Customer(pId,"mesut","Zincir",1,1,2982,"UK",
                "7345676543",null,null, new ArrayList<>());
        Address address1= new Address(3L,"UK", "POPLAR","LONDON","E14",customer, null, null);
        customer.getAddressList().add(address1);
        Address address2= new Address(5L,"UK", "BECTON","LONDON","E03",customer, null, null);
        customer.getAddressList().add(address2);
        return new ResponseObject<Customer>(  customer);
    }
}

