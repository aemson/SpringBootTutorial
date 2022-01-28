package com.tutorials.springTutorial.controller;

import com.tutorials.springTutorial.domain.RequestData;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static io.swagger.v3.oas.annotations.enums.SecuritySchemeIn.HEADER;
import static io.swagger.v3.oas.annotations.enums.SecuritySchemeType.HTTP;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/users")
@SecuritySchemes(value = @SecurityScheme(type = HTTP, name = "Logged in Users", scheme = "basic", in = HEADER))
public class Controllers {

    List<String> users = new ArrayList<>() {
        {
            this.add("Learner1");
            this.add("Learner2");
            this.add("Learner3");
        }
    };

    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "List of all the users", 
            content = @Content(array = @ArraySchema(schema = @Schema(description = "List of data", implementation = List.class)))),
            @ApiResponse(responseCode = "404", description = "Error fetching users")})
    @GetMapping("/")
    public ResponseEntity<Object> getUsers() {
        return status(OK).body(users);
    }

    @PostMapping("/{user}")
    public ResponseEntity<Boolean> addUsers(@PathVariable String user) {
        users.add(user);
        return status(OK).body(true);
    }

    @Operation(summary = "Delete API", description = "Delete the user from list",
            parameters = {@Parameter(name = "user", description = "User to be deleted", schema = @Schema(allowableValues = {"User1", "User2", "User3"}))},
    security = @SecurityRequirement(name = "userAuthScheme"))
    @DeleteMapping("/{user}")
    public ResponseEntity<Boolean> deleteUsers(@PathVariable String user) {
        users.remove(user);
        return status(OK).body(true);
    }


    @RequestMapping(value = "/addMoreUsers", method = POST)
    public ResponseEntity<String> addMoreUsers(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Sample request",
            content = @Content(examples = {@ExampleObject(name = "Ex1", value = "{\"name\": \"user1\",\"address\": \"JavaHub\"}"),
                    @ExampleObject(name = "Ex2", value = "{\"name\": \"user2\",\"address\": \"KotlinHub\"}")})) @RequestBody RequestData requestData) {
        System.out.println(requestData);
        return status(OK).body("Done adding");
    }
}


