package cn.trollaura.plugman;

import cn.trollaura.api.�������;
import cn.trollaura.api.�������ݿ�;
import cn.trollaura.plugman.loader.CommandLoader;
import cn.trollaura.plugman.loader.EventLoader;
import snw.jkook.entity.Guild;
import snw.jkook.plugin.BasePlugin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import static cn.trollaura.api.ϵͳKt.���;

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
        ���( "ָ��ϵͳ��ʼ�����!",false," PlugMan | ");


        new EventLoader(this).init();
        ���( "�¼�ϵͳ��ʼ�����!",false," PlugMan | ");
        ���( "�Ѿ���ȫ����!",false," PlugMan | ");
    }

}
