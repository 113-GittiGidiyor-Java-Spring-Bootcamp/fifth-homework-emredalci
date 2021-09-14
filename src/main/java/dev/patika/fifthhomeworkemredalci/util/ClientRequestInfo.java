package dev.patika.fifthhomeworkemredalci.util;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

@Data
@NoArgsConstructor
@Component
@SessionScope
//@RequestScope
public class ClientRequestInfo {

    private String clientIpAddress;
    private String clientUrl;
    private String sessionActivity;
}
