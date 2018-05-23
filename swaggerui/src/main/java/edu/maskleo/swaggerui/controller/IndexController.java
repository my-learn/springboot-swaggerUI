package edu.maskleo.swaggerui.controller;

import edu.maskleo.swaggerui.domain.Resp;
import edu.maskleo.swaggerui.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@Api(description = "用户相关")
public class IndexController {

    private static final Map<Integer, User> DATAS = new ConcurrentHashMap<Integer, User>() {{
        put(1, new User(1, "tom", 12));
        put(2, new User(2, "jek", 15));
    }};

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Resp<List<User>> list() {
        return Resp.ok(Arrays.asList(DATAS.values().toArray(new User[0])));
    }

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Resp<Void> add(User user) {
        DATAS.put(DATAS.size() + 1, user);
        return Resp.ok(null);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public Resp<Void> add(int id) {
        DATAS.remove(id);
        return Resp.ok(null);
    }
}
