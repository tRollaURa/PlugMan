package cn.trollaura.plugman;

import cn.trollaura.api.输出类型;
import cn.trollaura.api.连接数据库;
import cn.trollaura.plugman.loader.CommandLoader;
import cn.trollaura.plugman.loader.EventLoader;
import snw.jkook.entity.Guild;
import snw.jkook.plugin.BasePlugin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static cn.trollaura.api.系统Kt.输出;

/**
 * @author tRollaURa_
 * @since 2024/5/19
 */
public class Main extends BasePlugin {



    @Override
    public void onLoad() {


        saveDefaultConfig();
        reloadConfig();
    }

    @Override
    public void onEnable() {
        new CommandLoader(this);
        输出( "指令系统初始化完毕!",false," PlugMan | ");


        new EventLoader(this).init();
        输出( "事件系统初始化完毕!",false," PlugMan | ");
        输出( "已经完全加载!",false," PlugMan | ");
    }

}
