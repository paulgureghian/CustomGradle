package com.example.Paul.myapplication.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.example.JokesSupply;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Paul.example.com",
                ownerName = "backend.myapplication.Paul.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    JokesSupply jokesSupply = new JokesSupply();

    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();
        String joke = jokesSupply.getJoke();
        response.setData(joke);

        return response;
    }
}
