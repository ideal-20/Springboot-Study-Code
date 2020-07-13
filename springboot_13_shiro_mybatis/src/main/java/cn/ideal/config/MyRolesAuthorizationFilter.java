package cn.ideal.config;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: MyRolesAuthorizationFilter
 * @Description: TODO
 * @Author: BWH_Steven
 * @Date: 2020/7/9 20:47
 * @Version: 1.0
 */
public class MyRolesAuthorizationFilter extends AuthorizationFilter {

    @SuppressWarnings({"unchecked"})
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {

        Subject subject = getSubject(request, response);
        String[] rolesArray = (String[]) mappedValue;

        if (rolesArray == null || rolesArray.length == 0) {
            //no roles specified, so nothing to check - allow access.
            return false;
        }

        List<String> roles = CollectionUtils.asList(rolesArray);
        boolean[] hasRoles = subject.hasRoles(roles);
        for (boolean hasRole : hasRoles) {
            if (hasRole) {
                return true;
            }
        }
        return false;
    }
}
