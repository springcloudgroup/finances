package cn.zsk.authservice.config;

import cn.zsk.authservice.service.security.LocalUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @author:zsk
 * @CreateTime:2019-08-14 16:30
 */

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

    private TokenStore tokenStore = new InMemoryTokenStore();
    private final String NOOP_PASSWORD_ENCODE = "{noop}";

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Autowired
    private LocalUserDetailsService userDetailsService;

    @Autowired
    private Environment env;

    /*
     * 用来配置客户端详情服务（ClientDetailsService），
     * 客户端详情信息在这里进行初始化，
     * 你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息。
     *
     * */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        // TODO persist clients details

        // @formatter:off
        clients.inMemory()
                .withClient("browser")
                .authorizedGrantTypes("refresh_token", "password")
                .scopes("ui")
                .and()
                .withClient("account")
                .secret(env.getProperty("ACCOUNT_SERVICE_PASSWORD"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .and()
                .withClient("statistics")
                .secret(env.getProperty("STATISTICS_SERVICE_PASSWORD"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server")
                .and()
                .withClient("notification")
                .secret(env.getProperty("NOTIFICATION_SERVICE_PASSWORD"))
                .authorizedGrantTypes("client_credentials", "refresh_token")
                .scopes("server");
        // @formatter:on
    }

    /*
    *用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)。
    *
    * */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                .tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }

    /*
     * 用来配置令牌端点(Token Endpoint)的安全约束.
     * */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()")
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

}
