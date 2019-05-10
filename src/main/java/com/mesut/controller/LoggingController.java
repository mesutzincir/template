package com.mesut.controller;

import com.mesut.dto.ResponseObject;
import com.mesut.model.Address;
import com.mesut.model.ApiBaseException;
import com.mesut.model.Customer;
import com.mesut.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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


}

