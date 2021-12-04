package io.vdev.clientapplication;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "api-gateway-server")
@RibbonClient(name = "micro-service-server")
public interface ApiProxy {
    @GetMapping("micro-service-server/server/technologyInfo/{platform}")
    ResponseModel retreiveTechnologyInfo(@PathVariable("platform") String platform);
}